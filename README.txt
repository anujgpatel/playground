Sample REST project 
ListPartner
You can perform a GET on http://localhost:8080/lp/list which will xml with response 200 if it is health;
<healthy>true</healthy>

You can also perform a POST with query string param checkPartner=<Any Number>, with the POST you can pass in body comma separated values of numbers (As plain string).  E.g. 1,2,3,4,5
If the list contains any partner for "checkPartner number" it will return;
<result>
true
</result>

Else if the list does not contain any partner for "checkpartner number" it will return;
<result>
false
</result>


You will get BAD_REQUEST (400) response code if an invalid list is passed in POST body.  


Implementation
--------------
While we could have implemented this in many ways, with this project we create a custom linked list object and add numbers that were passed in as comma separated values to that custom Linked list object (https://github.com/anujgpatel/playground/blob/master/src/main/java/com/anuj/llist/LList.java).
We then traverse through the generated list to see if the LinkedList contains the partners for given number.  
Rest resource (https://github.com/anujgpatel/playground/blob/master/src/main/java/com/anuj/rest/resources/ListResource.java) supports GET & POST on http://<server>:<port>/lp/list URL. 
