Feature: Submit Registration Application Organisation

  @org @org-reg-only
  Scenario: To verify the process of Registering an organisation successfully
    Given User navigates to the login page
    When Enters the username "tripsuser" and password "Passw0rd" to login
    Then Go to Registration > Register Taxpayer > Register Organization
    Then Select organization category as "Private Limited Liability Company"
    Then Enter organization name
    Then Enter rgd number
    Then Select account year end date and end month
    Then Enter actual turnover and source of capital
    Then Enter place of incorporation "India"
    Then Enter business sector details
#    Then Select Assigned tax office for organization as "BOMTO"
    Then Select reason for organization tin application "Am a Supplier"
    Then Enter details for person making application with tin "1000007601"
    Then Fill in Local postal address details for Organization
    Then Enter email primary contact for organization as "margiewambui11@gmail.com"
    Then Enter primary director with tin "1000007601"
    Then Verify success message "Record Added"
    Then Upload attachment "Business Registration Certificate" for Organization with file "id_doc.png"
    Then Verify success message "Record Added"
    Then Upload attachment "Certificate of Incorporation" for Organization with file "id_doc.png"
    Then Verify success message "Record Added"
    Then Upload attachment "Memorandum of association & Articles of Association, (including amendments thereto)" for Organization with file "id_doc.png"
    Then Verify success message "Record Added"
    Then Submit organization registration application
    Then Verify success message "Processing Completed - Reference Number"
    Then Obtain reference number for org registration "Processing Completed - Reference Number - ARN"
    Then Open CRM and close modal
    Then Click on registration application link
    Then switch to frame0
    Then search organization registration reference number
    Then Click on reference number
    Then switch to frame1
    Then Click next stage button
    Then switch to frame1
    Then wait for duplicate check "Organisation Name"
    Then switch to frame1
    Then Click next stage button
    Then switch to frame1
    Then Goto view AttachmentDetails screen
    And Download the Attachment
    Then switch to frame1
    And Select Approval outcome Org dropdown value to Approve
    Then Click on Save button
    Then switch to frame1
    And Verify approval "Approved"
    And Clicks on Taxpayer name CRM
    And refresh page
    Then switch to frame0
    Then Organization Taxpayer Tin is displayed


