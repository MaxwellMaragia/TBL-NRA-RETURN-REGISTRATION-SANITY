Feature: Submit Registration Application Individual

  @ind @ind-reg-only @ind-reg-taxtypes @sanity
  Scenario: To verify the process of Registering an individual successfully
    Given User navigates to the login page
    When Enters the username "tripsuser" and password "Passw0rd" to login
    Then Go to Registration > Register Taxpayer > Register Individual Demo
    Then Select Category if Individual as "Self-employed"
    Then Select title for Individual
    Then Enter first name as "Maxipain" and last name as random
    Then Select Gender for Individual
    Then Enter mothers maiden name "Wambui"
    Then Enter marital status "Single"
    Then Enter date of birth as "29091996" and place of birth "Pumwani"
    Then Select Nationality and Country of Residence as "Kenya"
#    Then Select Assigned tax office as "Freetown West"
#    Then Select Assigned tax office as "BOMTO"
    Then Select reason for Individual tin application "Am a Supplier"
    Then Fill in passport Identification details
    Then Fill in residence permit identification details
    Then Fill in occupation and business Interest details for Individual
    Then Fill in Local postal address details for Individual
    Then Enter email primary contact for individual as "margiewambui11@gmail.com"
    Then Upload attachment "Passport" for Individual with file "id_doc.png"
#    Then Verify success message "Record Added"
    Then Submit Individual registration application
    Then Verify success message "Processing Completed - Reference Number"
    Then Obtain reference number for ind registration "Processing Completed - Reference Number - ARN"
    Then Open CRM and close modal
    Then Click on registration application link
    Then switch to frame0
    Then search individual registration reference number
    Then Click on reference number
    Then switch to frame1
    Then Click next stage button
    Then switch to frame1
    Then Goto view AttachmentDetails screen
    And Download the Attachment
    Then switch to frame1
    Then Select Identification Outcome dropdown value for Individual Taxpayer Approval
    And Click on NextStage button
    Then switch to frame1
    Then wait for duplicate check "First Name"
    Then switch to frame1
    And Click on NextStage button
    Then switch to frame1
    And Select Approval outcome dropdown value to Approve "First Name"
    Then Click on Save button
    Then switch to frame1
    And Verify approval "Approved"
    And Clicks on Taxpayer name CRM
    And refresh page
    Then switch to frame0
    Then Taxpayer Tin is displayed
