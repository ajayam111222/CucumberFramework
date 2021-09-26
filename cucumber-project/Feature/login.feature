Feature: login feature

 Scenario: user should login with valid credential
 
 Given : user should open browser
 When :user open the URL "https://opensource-demo.orangehrmlive.com/index.php/auth/login" ;
 Then :Enter the username "Admin" and password "admin123" ;
 And : click on the login 
 Then :user should get title "OrangeHRM" ;
 And :click on logout button
 Then :user shold get title "OrangeHRM" ;
 And :close the browser; 

Scenario Outline: check usename and password with diiferent set of data

Given : user should open browser
 When :user open the URL "https://opensource-demo.orangehrmlive.com/index.php/auth/login" ;
 Then :Enter the username "<username>" and password "<password>" ;
 And : click on the login 
 Then :user should get title "OrangeHRM" ;
 And :click on logout button
 Then :user shold get title "OrangeHRM" ;
 And :close the browser; 
 
 Examples:
 |username|password|
 |ajay|ajay1234|
 |kumar|sanjay|
 |sanjany|rajive|
 |Admin|admin123|