Feature: Lodge-File-Adjust-Cancel Tax Returns for Individual and Organization

  @org @sanity @lodge
  Scenario Outline: Verify the process of Lodge Paper Return for <taxtype>
    Given User navigates to the login page
    When Enters the username "tripsuser" and password "Passw0rd" to login
    And Click on return filing and processing > Lodge return
    Then Click Return document search button
    Then Search for taxtype with category "<category>" and taxtype "<taxtype>" for period year "<year>" and number "<number>"
    Then Enter liability
    Then Submit lodge return application
    Then Verify success message "Returns Lodgement is Successful with Reference Number"
    Examples:
      | category     | taxtype            | year | number |
      | Organisation | CIT Return (Final) | 2020 | 1      |

  @org @sanity @file @returns
  Scenario Outline: Verify the process of Submit Tax Return for <taxtype>
    Given User navigates to the login page
    When Enters the username "tripsuser" and password "Passw0rd" to login
    And Click on return filing and processing > File return
    Then Select return document as "<taxtype>"
    Then Find tax return for category "<category>" with year "<year>" and number "<number>"
    Then Fill in file return details for taxtype "<taxtype>"
    Then Submit file return application
    Then Verify success message "Record successfully saved with reference number"
    Examples:
      | category     | taxtype            | year | number |
      | Organisation | CIT Return (Final) | 2020 | 1      |

  @org @sanity @adjust @returns
  Scenario Outline: Verify the process of Adjust Tax Return for <taxtype>
    Given User navigates to the login page
    When Enters the username "tripsuser" and password "Passw0rd" to login
    And Click on return filing and processing > Adjust return
    Then Select return document as "<taxtype>"
    Then Find tax return for category "<category>" with year "<year>" and number "<number>"
    Then Perform amendment for taxtype "<taxtype>"
    Then Submit adjust return application
    Then Verify success message "Tax return has been successfully saved.The status is now pending approval."
    Then Obtain reference number for adjust "Tax return has been successfully saved.The status is now pending approval."
    Then Open CRM and close modal
    And Click on Case management dropdown
    And click on Returns Tax return application
    Then switch to frame0
    When enters adjust reference number in search results
    Then Click on reference number
    Then switch to frame1
    And Approve adjust returns application
    Then Click on Returns Save button
    Then switch to frame1
    And Verify approval "Approved"
    Examples:
      | category     | taxtype            | year | number |
      | Organisation | CIT Return (Final) | 2020 | 1      |

  @org @sanity @cancel @returns
  Scenario Outline: Verify the process of Cancel Tax Return for <taxtype>
    Given User navigates to the login page
    When Enters the username "tripsuser" and password "Passw0rd" to login
    And Click on return filing and processing > Cancel return
    Then Select return document as "<taxtype>"
    Then Find tax return for category "<category>" with year "<year>" and number "<number>"
    Then Select reason for cancellation as "RETURN POSTED TO WRONG TAXPAYER" "<taxtype>"
    Then Click cancel return
    Then Click yes
    Then Verify success message "Tax return has successfully saved.The status is now pending cancellation"
    Then Obtain reference number for cancellation "Tax return has successfully saved.The status is now pending cancellation"
    Then Open CRM and close modal
    And Click on Case management dropdown
    And click on Returns Tax return application
    Then switch to frame0
    When enters cancel reference number in search results
    Then Click on reference number
    Then switch to frame1
    And Approve adjust returns application
    Then Click on Returns Save button
    Then switch to frame1
    And Verify approval "Approved"
    Examples:
      | category     | taxtype            | year | number |
      | Organisation | CIT Return (Final) | 2020 | 1      |