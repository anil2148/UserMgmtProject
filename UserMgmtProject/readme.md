Json to create record
Method - POST
URL = localhost:8090/createUser
{
"fName":"Anil",
"lName":"Chowdhary",
"email":"anilchowdhary48@gmail.com",
"pincode":"480331",
"birthdate":"17/04/1987"
}



Json for update record
Method -POST
URL = localhost:8090/updateUser
{
"id":1,
"fName":"anil",
"lName":"Chowdhary",
"email":"anilchowdhary48@gmail.com",
"pincode":480331,
"birthdate":"17/04/1987"
}



Delete User url
Mothod = DELETE
url = localhost:8090/delete/1