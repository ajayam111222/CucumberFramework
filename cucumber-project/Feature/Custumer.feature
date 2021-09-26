Feature: Custumer feature
  
Scenario: Add New Custumer
    Given Open the browser
    When Open the application URL "https://admin-demo.nopcommerce.com/login"
    And Enter the username "admin@yourstore.com" and Password "admin" ;
    And Click on login button
    Then User can view the Dashboard
    And click on Customer option
    And click on the customer feature
    And Click on the Add New button
    Then User can view the Cutomer info page
    Then Enter the customer info
    And Click on the save button
    Then Successfull message should display with text "The new customer has been added successfully."
    And close browser
    

 Scenario: Search Customer
    Given Open the browser
    When Open the application URL "https://admin-demo.nopcommerce.com/login"
    And Enter the username "admin@yourstore.com" and Password "admin" ;
    And Click on login button
    Then User can view the Dashboard
    And click on Customer option
    And click on the customer feature
    Then Enter the Details in Serach Field
    And click search button
    Then Verify the customer is Available in Search Field
    And close the browser

Scenario: Active type All Name is enabled or Not
    
    Given Open the browser
    When Open the application URL "https://admin-demo.nopcommerce.com/login"
    And Enter the username "admin@yourstore.com" and Password "admin" ;
    And Click on login button
    Then User can view the Dashboard
    And click on Customer option
    And click on Active Type feature
    When click on the is Enabled button 
    Then verify all button is selected or not 
    And close the browser
     
    
    