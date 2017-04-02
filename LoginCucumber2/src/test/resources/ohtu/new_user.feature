Feature: A new user account can be created if a proper unused username and password are given

  Scenario: creation succesful with correct username and password
    Given command new user is selected
    When user "eero" with password "salainen1" is created
    Then system will respond with "new user registered"

  Scenario: creation fails with correct username and too short password
    Given command new user is selected
    When user "eerotuse" with password "aaaaa1" is created
    Then system will respond with "new user not registered"

  Scenario: creation fails with correct username and password consisting of letters
    Given command new user is selected
    When user "eerot" with password "aaaaaeeeeeeeeee" is created
    Then system will respond with "new user not registered"

  Scenario: creation fails with too short username and valid password
    Given command new user is selected
    When user "aa" with password "salainen2" is created
    Then system will respond with "new user not registered"

  Scenario: creation fails with already taken username and valid password
    Given command new user is selected
    And user "eero" with password "salainen1" is created
    And command new user is selected
    When user "eero" with password "salainen1" is created
    Then system will respond with "new user not registered"

  Scenario: can login with succesfully generated account
    Given command new user is selected
    And user "eero" with password "salainen1" is created
    And command login is selected
    When username "eero" and password "salainen1" are entered
    Then system will respond with "logged in"

  Scenario: can not login with account that is not succesfully created
    Given user "aa" with password "a" is created
    And command login is selected
    When username "aa" and password "a" are entered
    Then system will respond with "wrong username or password"

  Scenario: can not login with account that is created with numbers in username
    Given user "aaaa22" with password "kalainen2" is created
    And command login is selected
    When username "aaaa22" and password "kalainen2" are entered
    Then system will respond with "wrong username or password"

