package com.intellect.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.intellect.model.User;
import com.intellect.response.UserResponse;
import com.intellect.service.UserService;
import com.intellect.validationMessage.ValidationMessage;

@RestController
public class UserController extends ResponseEntityExceptionHandler {
	@Autowired
	UserService userService;

	@RequestMapping(value = "/{user}", method = RequestMethod.POST)
	public ResponseEntity<User> updateUser(@RequestBody User user) {
		System.out.println("updateUser(): Entering in updateUser method");
      
		userService.updateUser(user);
		
		System.out.println("updateUser(): Exit from updateUser method");
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@RequestMapping(value = "/createUser", method = RequestMethod.PUT)
	public ResponseEntity<UserResponse> createUser(@RequestBody User user) {
		System.out.println("createUser(): Entering in createUser method");
		UserResponse userRes = respone(user);
		// Actual call to database
		if(userRes.getValidationError().size()==0){
		    userService.createUser(user);
		}else{
			return new ResponseEntity<>(respone(user),HttpStatus.ACCEPTED);
		}
		userRes = respone(user);
		System.out.println("createUser(): Exit from createUser method" + user.getId());
		final URI uri = ServletUriComponentsBuilder.fromCurrentRequest().build().toUri();
		return new ResponseEntity<>(userRes,HttpStatus.ACCEPTED);
	}

	@RequestMapping(value = "/delete/{user}", method = RequestMethod.DELETE)
	public User deleteUser(@PathVariable Long user) {
		System.out.println("deleteUser(): Entering in deleteUser method");

		userService.deleteUser(user);

		System.out.println("deleteUser(): Exit from deleteUser method");
		return null;
	}

	@RequestMapping(value = "getAll", method = RequestMethod.GET)
	public List<User> getAllUser() {
		System.out.println("getAllUser(): Entering in getAllUser method");
		List<User> allUser = userService.findAll();
		for (User user : allUser) {
			System.out.println(user);
		}
		System.out.println("getAllUser(): Exit from getAllUser method");
		return /* List<User> allUser = */userService.findAll();
	}

	public UserResponse respone(User user) {
		UserResponse userRes = validate(new UserResponse(), user);
		if(userRes.getValidationError().size()>0){
			userRes.setResponseMsg("Request is not valid");
			userRes.setMsg("Please send required value");
		}else{
			userRes.setResponseMsg("Data saved successfully");
			userRes.setMsg("Request completed successfully");
		}
		userRes.setUserId(user.getId()+"");
		return userRes;
	}

	public UserResponse validate(UserResponse userRes, Object obj) {
		User user = (User) obj;
		if (checkInputString(user.getfName())) {
			userRes.getValidationError().add(new ValidationMessage("First Name","name.empty"));
		}
		if (checkInputString(user.getPinCode() + "")) {
			userRes.getValidationError().add(new ValidationMessage("Pin Code","pincode.empty"));
		}
		/*if (checkInputString(user.getBirthDate())) {
			userRes.getValidationError().add(new ValidationMessage("birthDate","birthDate.empty"));
		}*/
		if (checkInputString(user.getEmail())) {
			userRes.getValidationError().add(new ValidationMessage("email","birthDate.empty"));		}
		return userRes;
	}

	private boolean checkInputString(String input) {
		return (input == null || input.trim().length() == 0);
	}
}
