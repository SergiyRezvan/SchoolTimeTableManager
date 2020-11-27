Feature: Verify School Manager API

  Scenario: Get list of available schools
    Given url 'http://localhost:8686/SchoolTimeTableManager'
    Then print url
    When method get
    Then status 200
    
  Scenario: Add new school without authorization
    Given url 'http://localhost:8686/SchoolTimeTableManager/schoolManager'
    When request { name: 'Test2', restName: 'Test2', description: 'Description for test school', phone: 0123456789, address: 'Address for test 2', email: 'test2@gmail.com', director: 'Test Director', webSite: 'htpp://test2.school.com'}
    And method post
    Then status 401

  Scenario: Add new school
    Given url 'http://localhost:8686/SchoolTimeTableManager/authenticate'
    And request { userName: 'admin', password: 'password' }
    When method post
    Then status 200
    And def authToken = 'Bearer ' + response.accessToken
    Given url 'http://localhost:8686/SchoolTimeTableManager/schoolManager'
    And request { name: 'Test2', restName: 'Test2', description: 'Description for test school', phone: 0123456789, address: 'Address for test 2', email: 'test2@gmail.com', director: 'Test Director', webSite: 'htpp://test2.school.com'}
    And header Authorization = authToken
    When method post
    Then status 201
    And response.name = 'Test2'

  Scenario: Get added new school
    Given url 'http://localhost:8686/SchoolTimeTableManager/schoolManager/Test2'
    And request { name: 'Test2', restName: 'Test2', description: 'Description for test school', phone: 0123456789, address: 'Address for test 2', email: 'test2@gmail.com', director: 'Test Director', webSite: 'htpp://test2.school.com'}
    When method get
    Then status 200
    And response.name = 'Test2'

  Scenario: Delete created school
    Given url 'http://localhost:8686/SchoolTimeTableManager/authenticate'
    And request { userName: 'admin', password: 'password' }
    When method post
    Then status 200
    And def authToken = 'Bearer ' + response.accessToken
    Given url 'http://localhost:8686/SchoolTimeTableManager/schoolManager/Test2'
    And header Authorization = authToken
    When method delete
    Then status 204