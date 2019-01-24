@tag
Feature: First test in cucumber

  @tag1
  Scenario Outline: Login and create Content Type
    Given I am going to "EIDMLoginPage"
    And checking for security certificates
    Then I am entering "<UserID>" and "<Password>"
    And checking for security certificates
    And verifying that I have logged in successfully and title is "Content Management System"
    Then I am going to Manage Content Type Page
    And clicking on create content type and entering "<Name>" in Content Type name field
    Then I am verifying that Content Type has been created
    Examples: 
      | Name          | UserID        | Password      |
      | Content name1 | DYURCHYK_TEST | Summr88!      |
      | Content name2 | KK-Test02     | Spr!ng2018@07 |

 #  @tag2
 # Scenario: Title of your scenario outline
 #   Given I want to write a step with <name>
 #   When I check for the <value> in step
 #   Then I verify the <status> in step
