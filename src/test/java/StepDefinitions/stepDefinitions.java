package StepDefinitions;


import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.security.Key;
import java.sql.Timestamp;

import java.util.List;
import java.util.Properties;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import gherkin.lexer.Th;
import io.cucumber.java.DataTableType;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.math3.analysis.function.Exp;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utils.BaseClass;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;


@RunWith(Cucumber.class)
public class stepDefinitions extends BaseClass {
    public Properties Pro;
    public WebDriverWait five;
    public WebDriverWait ten;
    public WebDriverWait fifteen;
    public WebDriverWait twenty;
    public WebDriverWait twentyfive;
    public WebDriverWait thirty;
    public WebDriverWait thirtyfive;
    public WebDriverWait fourty;
    public WebDriverWait fourtyfive;
    public WebDriverWait fifty;
    public WebDriverWait fiftyfive;
    public WebDriverWait sixty;
    public WebDriverWait sixtyfive;
    public WebDriverWait seventy;
    public WebDriverWait seventyfive;
    public WebDriverWait eighty;
    public WebDriverWait eightyfive;
    public WebDriverWait ninety;
    public WebDriverWait ninetyfive;
    public WebDriverWait onehundred;
    public WebDriverWait twohundred;
    public WebDriverWait threehundred;
    public Actions actions;


    public static sharedatastep sharedata;
    public String ReferenceNumber = "IA000000046";

    public stepDefinitions(sharedatastep sharedata) {

        stepDefinitions.sharedata = sharedata;

    }

    @Before(order = 2)
    public void method1() throws Exception {
        Pro = new Properties();
        FileInputStream fls = new FileInputStream("src\\test\\resources\\global.properties");
        Pro.load(fls);
        driver = BaseClass.getDriver();
        actions = new Actions(driver);
        five = new WebDriverWait(driver, 5);
        ten = new WebDriverWait(driver, 10);
        fifteen = new WebDriverWait(driver, 15);
        twenty = new WebDriverWait(driver, 20);
        twentyfive = new WebDriverWait(driver, 25);
        thirty = new WebDriverWait(driver, 30);
        thirtyfive = new WebDriverWait(driver, 35);
        fourty = new WebDriverWait(driver, 40);
        fourtyfive = new WebDriverWait(driver, 45);
        fifty = new WebDriverWait(driver, 50);
        fiftyfive = new WebDriverWait(driver, 55);
        sixty = new WebDriverWait(driver, 60);
        sixtyfive = new WebDriverWait(driver, 65);
        seventy = new WebDriverWait(driver, 70);
        seventyfive = new WebDriverWait(driver, 75);
        eighty = new WebDriverWait(driver, 80);
        eightyfive = new WebDriverWait(driver, 85);
        ninety = new WebDriverWait(driver, 90);
        ninetyfive = new WebDriverWait(driver, 95);
        onehundred = new WebDriverWait(driver, 100);
        twohundred = new WebDriverWait(driver, 200);
        threehundred = new WebDriverWait(driver, 300);

    }

    public void switchToFrameBackoffice() {
        WebElement frame = fourty.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("iframe")));
        driver.switchTo().frame(frame);
    }

    @Then("Switch to default")
    public void switchToDefault() {
        driver.switchTo().defaultContent();
    }

    @Then("^Verify success message \"([^\"]*)\"$")
    public void verify_success_message(String Message) throws Throwable {

        WebElement successMessage = twohundred.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'" + Message + "')]")));
        if (successMessage.isDisplayed()) {
            System.out.println("Success message ('" + Message + "') has been displayed");
            Assert.assertTrue(true);
        } else {
            Assert.fail();
        }
    }

    @Then("^Verify error message \"([^\"]*)\"$")
    public void verify_error_message(String error) throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'" + error + "')]")));
        if (errorMessage.isDisplayed()) {
            //This will scroll the page till the element is found
            System.out.println("Error message ('" + error + "') has been displayed");
            Assert.assertTrue(true);
        } else {
            Assert.fail();
        }
    }

    @Then("^Verify no data is found in table$")
    public void verify_no_data_is_found_in_table() throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        WebElement noDataXpath = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[contains(text(),'No record(s) found.')]")));
        if (noDataXpath.isDisplayed()) {
            Assert.assertTrue("No data found in table", true);
        } else {
            Assert.assertFalse("Data found in table", false);
        }
    }

    @Given("^User navigates to the login page$")
    public void user_navigates_to_the_login_page() throws Throwable {
        driver.get(Pro.getProperty("NRA_BackOffice_URL"));
        driver.manage().window().maximize();
    }

    @When("^Enters the username \"([^\"]*)\" and password \"([^\"]*)\" to login$")
    public void enters_the_username_something_and_password_something_to_login(String username, String password) throws Throwable {
        thirty.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginForm:username"))).sendKeys(username);
        driver.findElement(By.id("loginForm:password")).sendKeys(password);
        driver.findElement(By.xpath("//button[span='Login']")).click();

    }

    @Then("^User logs out successfully$")
    public void user_logs_out_successfully() throws Throwable {
        driver.findElement(By.id("Logout")).click();

    }

    //---------------------------------------------------------------------Verify the Process of Assign Audit Case-----------------------------------------------------------------------------------------------//
    @Given("^Open CRM URL Module as \"([^\"]*)\"$")
    public void open_crm_url_module_as_something(String strArg1) throws Throwable {
//        driver = getDriver();
        driver.get("http://" + strArg1 + ":Passw0rd@trips-crm:5555/TripsWorkflow/main.aspx");
    }

    @And("^Close Popup Window$")
    public void close_Popup_Window() throws Throwable {

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement specificframe = (driver.findElement(By.id(Pro.getProperty("CRM_ExploreCrmWindow_Frame__ID"))));
        driver.switchTo().frame(specificframe);
        WebDriverWait CloseWindow = new WebDriverWait(driver, 60);
        CloseWindow.until(ExpectedConditions.elementToBeClickable(By.id(Pro.getProperty("CRM_ExploreCrmWindow_Frame_Close_ID")))).click();
    }

    @And("^Click on Case management dropdown$")
    public void click_on_case_management_dropdown() throws Throwable {
        driver.findElement(By.xpath("//*[@id=\"TabCS\"]/a/span")).click();
    }

    @Then("^switch to frame0$")
    public void switch_to_frame0() throws Throwable {
        driver.switchTo().defaultContent();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        WebElement specificframe = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(Pro.getProperty("NextStage_Frame_ID"))));
        driver.switchTo().frame(specificframe);
        Thread.sleep(3000);

    }

    @Then("^Click on reference number$")
    public void click_on_reference_number() {
        WebElement elementLocator = thirty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"gridBodyTable\"]/tbody/tr/td[1]")));

        Actions actions = new Actions(driver);
        actions.doubleClick(elementLocator).perform();

        driver.switchTo().defaultContent();
    }

    @And("^wait for plan to load \"([^\"]*)\"$")
    public void wait_for_duplicate_check(String strArg1) throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, 200);
        driver.switchTo().defaultContent();
        Thread.sleep(3000);
        driver.switchTo().frame("contentIFrame1");
        WebElement frame = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("WebResource_DebtManagementApplicationAngular")));
        driver.switchTo().frame(frame);
        WebElement DebtCaseSummary = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='" + strArg1 + "']")));
        Assert.assertTrue(DebtCaseSummary.isDisplayed());
    }

    @And("^clicks Submit button$")
    public void clicks_submit_button() throws Throwable {
        WebElement submitButton = ten.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/trips-app/div/app-debt-management/app-enforcement-process/div/div/form/div[4]/div/div/button")));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submitButton);
        Thread.sleep(500);
        submitButton.click();

        Thread.sleep(500);
        driver.switchTo().defaultContent();
    }

    @Then("^switch to frame1$")
    public void switch_to_frame1() throws Throwable {
        driver.switchTo().defaultContent();
        WebDriverWait wait = new WebDriverWait(driver, 100);
        WebElement specificframe = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(Pro.getProperty("NextStage_Frame_ID1"))));
        driver.switchTo().frame(specificframe);
        Thread.sleep(2000);

    }

    @And("^Select Approval outcome value to Approve \"([^\"]*)\"$")
    public void select_approval_outcome_value_to_approve_something(String strArg1) throws Throwable {
        String approvalId = "header_process_tbg_" + strArg1 + "approval";
        WebElement dropDown = driver.findElement(By.id(approvalId));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        dropDown.click();
        Actions action = new Actions(driver);
        action.doubleClick(dropDown).perform();
        action.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
    }

    @And("^Select Reject outcome dropdown value to Approve \"([^\"]*)\"$")
    public void select_reject_outcome_dropdown_value_to_approve_something(String strArg1) throws Throwable {
        String approvalId = "header_process_tbg_" + strArg1 + "approval";
        WebElement dropDown = driver.findElement(By.id(approvalId));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        dropDown.click();
        Actions action = new Actions(driver);
        action.doubleClick(dropDown).perform();
        action.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
    }

    @Then("^Enter Outcome Reason$")
    public void enter_Outcome_Reason() throws Throwable {
        Thread.sleep(2000);
        WebElement specificframe = (driver.findElement(By.id("WebResource_DebtManagementRejectionDataReferenceResource")));
        driver.switchTo().frame(specificframe);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.id("viewoption")).click();
        WebDriverWait ReasonValue = new WebDriverWait(driver, 60);
        ReasonValue.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"statuscode_i\"]/option[2]"))).click();

    }


    @Then("^Click on Save button$")
    public void click_on_Save_button() throws Throwable {
        Thread.sleep(1000);
        driver.switchTo().defaultContent();
        driver.findElement(By.id("tbg_registrationapplication|NoRelationship|Form|Mscrm.Form.tbg_registrationapplication.Save")).click();
    }

    @Then("^Click on NextStage button$")
    public void click_on_NextStage_button() throws Throwable {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.xpath(Pro.getProperty("Individual_NextStage_Button_XPATH"))).click();
        Thread.sleep(2000);
    }


    @Then("^Click reporting > reports$")
    public void goToReportingScreen() throws Throwable {
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[span='Reporting']"))).click();
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[span='Reports']"))).click();
    }

    @Then("Switch to backoffice frame")
    public void switchToBackofficeFrame() {
        switchToFrameBackoffice();
    }

    @Then("Open CRM and close modal")
    public void openCRMAndCloseModal() {
        driver.get(Pro.getProperty("NRA_crm_url_Registration"));

        WebElement specificframe = twohundred.until(ExpectedConditions.visibilityOfElementLocated(By.id("InlineDialog_Iframe")));
        driver.switchTo().frame(specificframe);
        WebDriverWait CloseWindow = new WebDriverWait(driver, 60);
        CloseWindow.until(ExpectedConditions.elementToBeClickable(By.id(Pro.getProperty("CRM_ExploreCrmWindow_Frame_Close_ID")))).click();
    }


    @Then("^approve transaction$")
    public void approve_transaction() throws Throwable {

        onehundred.until(ExpectedConditions.visibilityOfElementLocated(By.id("WebResource_DebtManagementApplicationAngular")));
        driver.switchTo().frame("WebResource_DebtManagementApplicationAngular");
        Thread.sleep(3000);

        WebDriverWait wait = new WebDriverWait(driver, 120);
        WebElement downloadAttach = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='Instalment Agreement Number:']")));
        Assert.assertTrue(downloadAttach.isDisplayed());

        driver.switchTo().defaultContent();
        WebDriverWait wait1 = new WebDriverWait(driver, 30);
        WebElement specificframe = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id(Pro.getProperty("NextStage_Frame_ID1"))));
        driver.switchTo().frame(specificframe);
        Thread.sleep(5000);

        driver.findElement(By.xpath("//div[@data-attributename='tbg_approvaloutcome']")).click();
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
        driver.switchTo().defaultContent();
    }

    @Then("reject transaction after text {string} loads")
    public void rejectTransactionAfterTextLoads(String text) throws InterruptedException {
        onehundred.until(ExpectedConditions.visibilityOfElementLocated(By.id("WebResource_DebtManagementApplicationAngular")));
        driver.switchTo().frame("WebResource_DebtManagementApplicationAngular");
        Thread.sleep(3000);

        WebDriverWait wait = new WebDriverWait(driver, 120);
        WebElement downloadAttach = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='" + text + "']")));
        Assert.assertTrue(downloadAttach.isDisplayed());

        driver.switchTo().defaultContent();
        WebDriverWait wait1 = new WebDriverWait(driver, 30);
        WebElement specificframe = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id(Pro.getProperty("NextStage_Frame_ID1"))));
        driver.switchTo().frame(specificframe);
        Thread.sleep(5000);

        driver.findElement(By.xpath("//div[@data-attributename='tbg_approvaloutcome']")).click();
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
        driver.switchTo().defaultContent();
    }

    @Then("^Enter Outcome Notes (.+)$")
    public void enter_outcome_notes(String Notes) throws Throwable {
        Thread.sleep(3000);
        Actions action1 = new Actions(driver);
        WebElement element1 = driver.findElement(By.id((Pro.getProperty("Individual_NextStage_RefNum_Reject_OutComeNotes_ID"))));
        action1.sendKeys(element1, Notes).build().perform();
        Thread.sleep(5000);
    }

    @Then("^Click save CRM$")
    public void ClickSaveCRM() throws Throwable {
        driver.switchTo().defaultContent();
        driver.findElement(By.id("tbg_debtmanagementapplication|NoRelationship|Form|Mscrm.Form.tbg_debtmanagementapplication.Save")).click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }


    @Then("^Select report to print \"([^\"]*)\"$")
    public void select_report_to_print(String reportType) {
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='" + reportType + "']"))).click();

    }

    @Then("^Select report file type \"([^\"]*)\"$")
    public void select_report_file_type(String reportFormat) throws Throwable {
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"frmReportDetails:ReportFormat\"]/div[3]"))).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//li[contains(text(),'" + reportFormat + "')]")).click();
    }

    @Then("^Select tax office \"([^\"]*)\"$")
    public void select_tax_office(String taxOffice) throws Throwable {
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"frmReportDetails:TAX_OFFICE\"]/div[3]")).click();
        Thread.sleep(1000);
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
    }

    @Then("^Select return type$")
    public void select_return_type() throws Throwable {

        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"frmReportDetails:TAX_TYPE\"]/div[3]"))).click();
        Thread.sleep(1000);
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
    }

    public boolean isFileDownloaded(String downloadPath, String fileName) {
        File dir = new File(downloadPath);
        File[] dirContents = dir.listFiles();
        for (int i = 0; i < dirContents.length; i++) {
            if (dirContents[i].getName().equals(fileName)) {
                // File has been found, it can now be deleted:
                dirContents[i].delete();
                return true;
            }
        }
        return false;
    }

    //registration
    @Then("Go to Registration > Register Taxpayer > Register Individual Demo")
    public void goToRegistrationRegisterTaxpayerRegisterIndividualDemo() {
        thirty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[span='Registration']"))).click();
        thirty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[span='Register Taxpayer']"))).click();
        thirty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"sub1\"]/ul/li[1]/a"))).click();
    }

    @Then("Select Category if Individual as {string}")
    public void selectCategoryIfIndividualAs(String category) throws InterruptedException {
        fourty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"RegisterIndividual:LegalStatusInd\"]/div[3]"))).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//li[contains(text(),'" + category + "')]")).click();
    }

    @Then("Select title for Individual")
    public void selectTitleForIndividual() throws InterruptedException {
        fourty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"RegisterIndividual:Title\"]/div[3]"))).click();
        Thread.sleep(1000);
        actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
        Thread.sleep(2000);
    }

    @Then("Enter first name as {string} and last name as random")
    public void enterFirstNameAsAndLastNameAsRandom(String firstname) throws InterruptedException {
        Thread.sleep(1500);
        fourty.until(ExpectedConditions.visibilityOfElementLocated(By.id("RegisterIndividual:FirstName"))).sendKeys(firstname);
        Thread.sleep(1000);
        fourty.until(ExpectedConditions.visibilityOfElementLocated(By.id("RegisterIndividual:LastName"))).sendKeys(getRandom(6));
//        fourty.until(ExpectedConditions.visibilityOfElementLocated(By.id("RegisterIndividual:LastName"))).sendKeys("aro");
    }

    @Then("Select Gender for Individual")
    public void selectGenderForIndividual() throws InterruptedException {
        fourty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"RegisterIndividual:individualAccordion:Gender\"]/div[3]"))).click();
        Thread.sleep(1000);
        actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
        Thread.sleep(2000);
    }

    @Then("Enter mothers maiden name {string}")
    public void enterMothersMaidenName(String name) {
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.id("RegisterIndividual:individualAccordion:MothersMaidenName"))).sendKeys(name);
    }

    @Then("Enter marital status {string}")
    public void enterMaritalStatus(String maritalStatus) throws InterruptedException {
        fourty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"RegisterIndividual:individualAccordion:MaritalStatus\"]/div[3]"))).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//li[contains(text(),'" + maritalStatus + "')]")).click();
    }

    @Then("Enter date of birth as {string} and place of birth {string}")
    public void enterDateOfBirthAsAndPlaceOfBirth(String dob, String pob) {
        WebElement dobField = ten.until(ExpectedConditions.visibilityOfElementLocated(By.id("RegisterIndividual:individualAccordion:DOB_input")));
        dobField.click();
        dobField.sendKeys(dob);
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.id("RegisterIndividual:individualAccordion:PlaceOfBirth"))).sendKeys(pob);
    }

    @Then("Select Nationality and Country of Residence as {string}")
    public void selectNationalityAndCountryOfResidenceAs(String country) throws InterruptedException {
        fourty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"RegisterIndividual:individualAccordion:Nationality\"]/div[3]"))).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//li[contains(text(),'" + country + "')]")).click();
        Thread.sleep(1000);
        fourty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"RegisterIndividual:individualAccordion:CountryOfResidence\"]/div[3]"))).click();
        Thread.sleep(4000);
        driver.findElement(By.xpath("//li[contains(text(),'" + country + "')]")).click();
    }

    @Then("Select Assigned tax office as {string}")
    public void selectAssignedTaxOfficeAs(String office) throws InterruptedException {
        fourty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"RegisterIndividual:individualAccordion:AssignedOffice\"]/div[3]"))).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//li[contains(text(),'" + office + "')]")).click();
        Thread.sleep(1000);

    }

    @Then("Select Assigned tax office for organization as {string}")
    public void selectAssignedTaxOfficeOrgAs(String office) throws InterruptedException {
        fourty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"OrganisationSummaryDetails:organisationAccordion:AssignedOffice\"]/div[3]"))).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//li[contains(text(),'" + office + "')]")).click();
        Thread.sleep(1000);

    }

    @Then("Select reason for Individual tin application {string}")
    public void selectReasonForIndividualTinApplication(String reason) throws InterruptedException {
        fourty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"RegisterIndividual:individualAccordion:ReasonForTIN\"]/div[3]"))).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//li[contains(text(),'" + reason + "')]")).click();
    }

    @Then("Fill in passport Identification details")
    public void fillInPassportIdentificationDetails() throws InterruptedException {
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(., 'Identification')]"))).click();

        //click add
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.id("RegisterIndividual:individualAccordion:identificationTableHandler:AddIdentification"))).click();
        WebElement frame = twenty.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("iframe")));
        driver.switchTo().frame(frame);

        //enter passport details
        fourty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"Identification:IdentificationType\"]/div[3]"))).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//li[contains(text(),'Passport')]")).click();
        Thread.sleep(3000);

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        driver.findElement(By.id("Identification:IdentificationNumber")).sendKeys(String.valueOf(timestamp.getTime()));
        driver.findElement(By.id("Identification:IdentificationEffectiveDate_input")).click();
        driver.findElement(By.id("Identification:IdentificationEffectiveDate_input")).sendKeys("30/07/2020");
        actions.sendKeys(Keys.TAB).perform();
        Thread.sleep(3000);
        driver.findElement(By.id("Identification:ExpiryDate_input")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("Identification:ExpiryDate_input")).sendKeys(Keys.ENTER);
        actions.sendKeys(Keys.TAB).perform();
        Thread.sleep(1000);

        fourty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"Identification:CountryOfIssue\"]/div[3]"))).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//li[contains(text(),'Kenya')]")).click();

        driver.findElement(By.id("Identification:Ok")).click();
        //end of passport details

        driver.switchTo().defaultContent();
        thirty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[contains(text(),'Passport')]"))).isDisplayed();
    }

    @Then("Fill in residence permit identification details")
    public void fillInResidencePermitIdentificationDetails() throws InterruptedException {
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(., 'Identification')]"))).click();

        //click add
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.id("RegisterIndividual:individualAccordion:identificationTableHandler:AddIdentification"))).click();
        WebElement frame = twenty.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("iframe")));
        driver.switchTo().frame(frame);

        //enter passport details
        fourty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"Identification:IdentificationType\"]/div[3]"))).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//li[contains(text(),'Residence Permit')]")).click();
        Thread.sleep(2000);

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        driver.findElement(By.id("Identification:IdentificationNumber")).sendKeys(String.valueOf(timestamp.getTime()));


        fourty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"Identification:CountryOfIssue\"]/div[3]"))).click();
        Thread.sleep(4000);
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[contains(text(),'Kenya')]"))).click();
//        driver.findElement(By.xpath("//li[contains(text(),'Kenya')]")).click();

        driver.findElement(By.id("Identification:Ok")).click();
        //end of passport details

        driver.switchTo().defaultContent();
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[contains(text(),'Residence Permit')]"))).isDisplayed();
    }

    @Then("Fill in occupation and business Interest details for Individual")
    public void fillInOccupationAndBusinessInterestDetailsForIndividual() throws InterruptedException {
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(., 'Occupation/Business Interests')]"))).click();

        ten.until(ExpectedConditions.visibilityOfElementLocated(By.id("RegisterIndividual:individualAccordion:TotalSalesTurnoverPA_input"))).sendKeys("10,000,000");

        //add business sector
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.id("RegisterIndividual:individualAccordion:businessDetailsHandler:AddBusinessSD"))).click();
        switchToBackofficeFrame();

        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"BusinessSectorDetails:BusinessCode\"]/div[3]"))).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//li[contains(text(),'5820 - Software publishing')]")).click();

        //set as primary indicator
        driver.findElement(By.xpath("//*[@id=\"BusinessSectorDetails:PrimaryIndicator\"]/div[2]/span")).click();
        driver.findElement(By.id("BusinessSectorDetails:OK")).click();
        switchToDefault();
        fourty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[contains(text(),'Software publishing')]"))).isDisplayed();
    }

    @Then("Fill in Local postal address details for Individual")
    public void fillInLocalPostalAddressDetailsForIndividual() throws InterruptedException {
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(., 'Addresses')]"))).click();

        ten.until(ExpectedConditions.visibilityOfElementLocated(By.id("RegisterIndividual:individualAccordion:addressTableHandler:AddAddress"))).click();
        WebElement frame = twenty.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("iframe")));
        driver.switchTo().frame(frame);

        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"AddressDetails:AddressType\"]/div[3]"))).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//li[contains(text(),'Local Postal Address')]")).click();

        //wait for postal address details to load
        WebElement region = twenty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"AddressDetails:PostalRegion\"]/div[3]")));
        region.isDisplayed();
        //end wait

        driver.findElement(By.id("AddressDetails:City")).sendKeys("Kenema");
        region.click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//li[contains(text(),'East')]")).click();
        Thread.sleep(4000);
        driver.findElement(By.xpath("//*[@id=\"AddressDetails:District1\"]/div[3]")).click();
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[contains(text(),'Kenema')]"))).click();

        driver.findElement(By.id("AddressDetails:addOk")).click();
        switchToDefault();
        fourty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[contains(text(),'Local Postal Address')]"))).isDisplayed();
    }

    @Then("Enter email primary contact for individual as {string}")
    public void enterEmailPrimaryContactForIndividualAs(String email) throws InterruptedException {
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(., 'Contact Methods')]"))).click();

        ten.until(ExpectedConditions.visibilityOfElementLocated(By.id("RegisterIndividual:individualAccordion:contactDetailsHandler:AddContacts"))).click();
        WebElement frame = twenty.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("iframe")));
        driver.switchTo().frame(frame);

        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"ContactDetails:Purpose\"]/div[3]"))).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//li[contains(text(),'Personal')]")).click();

        driver.findElement(By.id("ContactDetails:ContactMethodDetailForWeb")).sendKeys(email);
        driver.findElement(By.id("ContactDetails:Ok")).click();
        switchToDefault();

        onehundred.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[contains(text(),'Personal')]"))).isDisplayed();
        //Thread.sleep(5000);
    }

    @Then("Upload attachment {string} for Individual with file {string}")
    public void uploadAttachmentForIndividual(String attachment, String file) {
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(., 'Attachments')]"))).click();

        ten.until(ExpectedConditions.visibilityOfElementLocated(By.id("RegisterIndividual:individualAccordion:attachmentTableHandler:AddAttachment"))).click();
        WebElement frame = twenty.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("iframe")));
        driver.switchTo().frame(frame);

        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"AttachmentDetails:DocType\"]/div[3]"))).click();
        driver.findElement(By.xpath("//li[text()='" + attachment + "']")).click();

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        driver.findElement(By.id("AttachmentDetails:Reference")).sendKeys(String.valueOf(timestamp.getTime()));

        String path = System.getProperty("user.dir") + File.separator + "src\\test\\resources\\" + File.separator + file;
        driver.findElement(By.id("AttachmentDetails:AttachmentPath_input")).sendKeys(path);

        //verified
        driver.findElement(By.xpath("//*[@id=\"AttachmentDetails:Verified\"]/div[2]/span")).click();


        driver.findElement(By.id("AttachmentDetails:Ok")).click();
        driver.switchTo().defaultContent();

    }

    @Then("Submit Individual registration application")
    public void submitIndividualRegistrationApplication() {
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("RegisterIndividual:submitTaxpayerRegistration"))).click();
    }


    @Then("Obtain reference number for ind registration {string}")
    public void obtainReferenceNumberForIndRegistration(String SuccessMessage) {
//get full message
        String FullMessage = driver.findElement(By.xpath("//span[contains(text(),'" + SuccessMessage + "')]")).getText();
        System.out.println(FullMessage);
        //Processing Completed - Reference Number - CRAL/000001959/2020
        sharedatastep.Reference_number = FullMessage.substring(41);

        System.out.println(sharedatastep.Reference_number);
    }

    @Then("^Click on registration application link$")
    public void click_on_registration_application_link() throws Throwable {
        Thread.sleep(2000);
        fiftyfive.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Pro.getProperty("Cases_Management_Dropdown_XPATH")))).click();
        Thread.sleep(2000);
        driver.findElement(By.id("tbg_registrationapplication")).click();
    }

    @Then("search individual registration reference number")
    public void searchIndividualRegistrationReferenceNumber() throws InterruptedException {

        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("crmGrid_findCriteria"))).sendKeys(sharedatastep.Reference_number);
       //twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("crmGrid_findCriteria"))).sendKeys("ARN/00027152/2021");
        driver.findElement(By.id("crmGrid_findCriteriaButton")).click();
    }

    @Then("Click next stage button")
    public void clickNextStageButton() throws InterruptedException {
        Thread.sleep(2000);
        WebDriverWait wait = new WebDriverWait(driver, 120);
        WebElement nextButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("stageAdvanceActionContainer")));
        nextButton.click();
        Thread.sleep(2000);
        driver.switchTo().defaultContent();
    }

    @Then("Goto view AttachmentDetails screen")
    public void gotoViewAttachmentDetailsScreen() throws InterruptedException {

        WebElement specificframe = onehundred.until(ExpectedConditions.visibilityOfElementLocated(By.id("WebResource_RegistrationApplicationAngular")));
        driver.switchTo().frame(specificframe);

        onehundred.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Attachments')]"))).isDisplayed();

        List<WebElement> element = driver.findElements(By.xpath(Pro.getProperty("Individual_NextStage_RefNum_DownloadFrame_DownloadLink_XPATH")));
        for (WebElement ele : element) {

            JavascriptExecutor js1 = (JavascriptExecutor) driver;
            js1.executeScript("arguments[0].scrollIntoView(true);", ele);

        }
        Thread.sleep(2000);
    }

    @And("Download the Attachment")
    public void downloadTheAttachment() throws InterruptedException {
        WebElement downloadAttach = onehundred.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Download']")));
        downloadAttach.click();
        Thread.sleep(5000);
        //change path
//        String downloadPath = "C:\\Users\\maxma\\Downloads";
//        String fileName = strArg1;
//        Thread.sleep(5000);
//        if (isFileDownloaded(downloadPath, fileName)) {
//            System.out.println(fileName + ": has been downloaded");
//            Assert.assertTrue(true);
//        } else {
//            Assert.assertFalse(fileName + ": has not been downloaded", false);
//        }

    }

    @Then("Select Identification Outcome dropdown value for Individual Taxpayer Approval")
    public void selectIdentificationOutcomeDropdownValueForIndividualTaxpayerApproval() {
        driver.findElement(By.xpath("//span[text()='click to enter']")).click();
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
    }

    @Then("wait for duplicate check {string}")
    public void waitForDuplicateCheck(String name) {
        WebElement frame = twohundred.until(ExpectedConditions.visibilityOfElementLocated(By.id("WebResource_RegistrationApplicationAngular")));
        driver.switchTo().frame(frame);
        twohundred.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='" + name + "']")));
    }

    @And("Select Approval outcome dropdown value to Approve {string}")
    public void selectApprovalOutcomeDropdownValueToApprove(String confirmation) throws InterruptedException {
        driver.switchTo().frame("WebResource_RegistrationApplicationAngular");
        WebElement downloadAttach = twohundred.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='" + confirmation + "']")));
        Assert.assertTrue(downloadAttach.isDisplayed());

        driver.switchTo().defaultContent();

        WebElement specificframe = thirty.until(ExpectedConditions.visibilityOfElementLocated(By.id(Pro.getProperty("NextStage_Frame_ID1"))));
        driver.switchTo().frame(specificframe);
        Thread.sleep(3000);

        driver.findElement(By.xpath("//div[@data-attributename='tbg_approvaloutcome']")).click();
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
    }

    @And("Verify approval {string}")
    public void verifyApproval(String Status) throws InterruptedException {
        WebElement statusLabel = twohundred.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[contains(text(),'" + Status + "')]")));
        if (statusLabel.isDisplayed()) {
            Assert.assertTrue("Approved", true);
        } else {
            Assert.fail("Approval failed");
        }
        Thread.sleep(2000);
    }

    @And("Clicks on Taxpayer name CRM")
    public void clicksOnTaxpayerNameCRM() throws InterruptedException {

        WebElement NameLabel = twohundred.until(ExpectedConditions.visibilityOfElementLocated(By.id("header_tbg_taxpayer_lookupValue")));
        NameLabel.click();
    }

    @And("^refresh page$")
    public void refresh_page() throws Throwable {
        driver.navigate().refresh();
        Thread.sleep(5000);
    }

    @Then("^Taxpayer Tin is displayed$")
    public void taxpayer_tin_is_displayed() throws Throwable {


        WebDriverWait wait = new WebDriverWait(driver, 40);
        WebElement tinLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"TIN Number_label\"]")));
        System.out.println("---------------------------------------------------------");
        Thread.sleep(2000);
        sharedatastep.Individual_tin=tinLabel.getText();
        if(sharedatastep.Individual_tin == null || sharedatastep.Individual_tin.equals("--")){
            refresh_page();
            switchToDefault();
            switch_to_frame0();
            taxpayer_tin_is_displayed();
        }else {
            System.out.println("Taxpayer TIN is " + sharedatastep.Individual_tin );
            System.out.println("---------------------------------------------------------");
        }

    }

    @Then("Go to Registration > Register Taxpayer > Register Organization")
    public void goToRegistrationRegisterTaxpayerRegisterOrganization() {
        thirty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[span='Registration']"))).click();
        thirty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[span='Register Taxpayer']"))).click();
        thirty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"sub1\"]/ul/li[2]/a"))).click();
    }

    @Then("Select organization category as {string}")
    public void selectOrganizationCategoryAs(String category) throws InterruptedException {
        fourty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"OrganisationSummaryDetails:LegalStatus\"]/div[3]"))).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//li[contains(text(),'" + category + "')]")).click();
    }

    @Then("Enter organization name")
    public void enterOrganizationName() {
        String name = "Codei "+getRandom(5);
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("OrganisationSummaryDetails:LegalName"))).sendKeys(name);
    }

    @Then("Enter rgd number")
    public void enterRgdNumber() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("OrganisationSummaryDetails:organisationAccordion:rgdNo"))).sendKeys(String.valueOf(timestamp.getTime()));
    }

    @Then("Select account year end date and end month")
    public void selectAccountYearEndDateAndEndMonth() throws InterruptedException {
        fourty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"OrganisationSummaryDetails:organisationAccordion:AccountYearEndDateDD\"]/div[3]"))).click();
        Thread.sleep(1000);
        actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();

        fourty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"OrganisationSummaryDetails:organisationAccordion:AccountYearEndDateMM\"]/div[3]"))).click();
        Thread.sleep(1000);
        actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
    }

    @Then("Enter actual turnover and source of capital")
    public void enterActualTurnoverAndSourceOfCapital() {
        driver.findElement(By.id("OrganisationSummaryDetails:organisationAccordion:TotalSalesTurnoverPA_input")).sendKeys("1,000,000");
        driver.findElement(By.id("OrganisationSummaryDetails:organisationAccordion:SourceOfCapital")).sendKeys("Sales and supplies");
    }

    @Then("Enter place of incorporation {string}")
    public void enterPlaceOfIncorporation(String poi) {
        driver.findElement(By.id("OrganisationSummaryDetails:organisationAccordion:PlaceOfIncorporation")).sendKeys(poi);
    }

    @Then("Enter business sector details")
    public void enterBusinessSectorDetails() throws InterruptedException {
        //add business sector
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.id("OrganisationSummaryDetails:organisationAccordion:businessDetailsHandler:AddBusinessSD"))).click();
        WebElement frame = twenty.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("iframe")));
        driver.switchTo().frame(frame);

        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"BusinessSectorDetails:BusinessCode\"]/div[3]"))).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//li[contains(text(),'5820 - Software publishing')]")).click();

        //set as primary indicator
        driver.findElement(By.xpath("//*[@id=\"BusinessSectorDetails:PrimaryIndicator\"]/div[2]/span")).click();
        driver.findElement(By.id("BusinessSectorDetails:OK")).click();
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[contains(text(),'Software publishing')]"))).isDisplayed();
    }

    @Then("Select reason for organization tin application {string}")
    public void selectReasonForOrganizationTinApplication(String reason) throws InterruptedException {
        fourty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"OrganisationSummaryDetails:organisationAccordion:ReasonForTIN\"]/div[3]"))).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//li[contains(text(),'" + reason + "')]")).click();
    }



    @Then("Enter details for person making application with tin {string}")
    public void enterDetailsForPersonMakingApplicationWithTin(String arg0) throws InterruptedException {
        driver.findElement(By.id("OrganisationSummaryDetails:organisationAccordion:find")).click();
        switchToFrameBackoffice();
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("SearchForm:tin"))).sendKeys("1000007601");
        driver.findElement(By.id("SearchForm:j_idt21")).click();
        Thread.sleep(2000);
        switchToDefault();
        Thread.sleep(6000);
        driver.findElement(By.id("OrganisationSummaryDetails:organisationAccordion:footerPositionOfApplicant")).sendKeys("CEO");
    }

    @Then("Fill in Local postal address details for Organization")
    public void fillInLocalPostalAddressDetailsForOrganization() throws InterruptedException {
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(., 'Addresses')]"))).click();

        ten.until(ExpectedConditions.visibilityOfElementLocated(By.id("OrganisationSummaryDetails:organisationAccordion:addressTableHandler:AddAddress"))).click();
        WebElement frame = twenty.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("iframe")));
        driver.switchTo().frame(frame);

        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"AddressDetails:AddressType\"]/div[3]"))).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//li[contains(text(),'Local Postal Address')]")).click();

        //wait for postal address details to load
        WebElement region = twenty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"AddressDetails:PostalRegion\"]/div[3]")));
        region.isDisplayed();
        //end wait

        driver.findElement(By.id("AddressDetails:City")).sendKeys("Kenema");
        region.click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//li[contains(text(),'East')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"AddressDetails:District1\"]/div[3]")).click();
        Thread.sleep(2000);
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[contains(text(),'Kenema')]"))).click();

        driver.findElement(By.id("AddressDetails:addOk")).click();
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[contains(text(),'Local Postal Address')]"))).isDisplayed();
    }

    @Then("Enter email primary contact for organization as {string}")
    public void enterEmailPrimaryContactForOrganizationAs(String email) throws InterruptedException {
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(., 'Contact Methods')]"))).click();

        ten.until(ExpectedConditions.visibilityOfElementLocated(By.id("OrganisationSummaryDetails:organisationAccordion:contactDetailsHandler:AddContacts"))).click();
        WebElement frame = twenty.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("iframe")));
        driver.switchTo().frame(frame);

        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"ContactDetails:Purpose\"]/div[3]"))).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//li[contains(text(),'Personal')]")).click();

        driver.findElement(By.id("ContactDetails:ContactMethodDetailForWeb")).sendKeys(email);
        driver.findElement(By.id("ContactDetails:Ok")).click();
        thirty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[contains(text(),'Personal')]"))).isDisplayed();
    }

    @Then("Enter primary director with tin {string}")
    public void enterPrimaryDirectorWithTin(String tin) throws InterruptedException {
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(., 'Directors')]"))).click();
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.id("OrganisationSummaryDetails:organisationAccordion:directorsTableHandler:AddDirectors"))).click();
        switchToFrameBackoffice();
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("DirectorsDetails:FindTin"))).click();
        switchToDefault();
        Thread.sleep(3000);
        driver.switchTo().frame(1);
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("SearchForm:tin"))).sendKeys(tin);
        driver.findElement(By.id("SearchForm:j_idt21")).click();
        switchToDefault();
        switchToFrameBackoffice();
        Thread.sleep(5000);
        //principal
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"DirectorsDetails:PrimaryIndicatorChk\"]/div[2]/span"))).click();
        Thread.sleep(2000);
        driver.findElement(By.id("DirectorsDetails:PositionHeldSince_input")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("DirectorsDetails:PositionHeldSince_input")).sendKeys(Keys.ENTER);
        actions.sendKeys(Keys.TAB).perform();
        driver.findElement(By.id("DirectorsDetails:rdOk")).click();
        switchToDefault();
    }

    @Then("Upload attachment {string} for Organization with file {string}")
    public void uploadAttachmentForOrganizationWithFile(String attachment, String file) throws InterruptedException {
        Thread.sleep(2000);
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(., 'Attachments')]"))).click();

        ten.until(ExpectedConditions.visibilityOfElementLocated(By.id("OrganisationSummaryDetails:organisationAccordion:attachmentTableHandler:AddAttachment"))).click();
        switchToFrameBackoffice();

        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"AttachmentDetails:DocType\"]/div[3]"))).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//li[text()='" + attachment + "']")).click();
        Thread.sleep(2000);
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        driver.findElement(By.id("AttachmentDetails:Reference")).sendKeys(String.valueOf(timestamp.getTime()));

        String path = System.getProperty("user.dir") + File.separator + "src\\test\\resources\\" + File.separator + file;
        driver.findElement(By.id("AttachmentDetails:AttachmentPath_input")).sendKeys(path);

        //verified
        driver.findElement(By.xpath("//*[@id=\"AttachmentDetails:Verified\"]/div[2]/span")).click();


        driver.findElement(By.id("AttachmentDetails:Ok")).click();
        driver.switchTo().defaultContent();

    }

    @Then("Submit organization registration application")
    public void submitOrganizationRegistrationApplication() throws InterruptedException {
        Thread.sleep(2000);
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.id("OrganisationSummaryDetails:submitTaxpayerRegistration"))).click();
    }

    @Then("Obtain reference number for org registration {string}")
    public void obtainReferenceNumberForOrgRegistration(String SuccessMessage) {
        String FullMessage = driver.findElement(By.xpath("//span[contains(text(),'" + SuccessMessage + "')]")).getText();
        System.out.println(FullMessage);
        //Processing Completed - Reference Number - CRAL/000001959/2020
        sharedatastep.Reference_number = FullMessage.substring(41);

        System.out.println(sharedatastep.Reference_number);
    }

    @Then("search organization registration reference number")
    public void searchOrganizationRegistrationReferenceNumber() {
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("crmGrid_findCriteria"))).sendKeys(sharedatastep.Reference_number);
        //twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("crmGrid_findCriteria"))).sendKeys("ARN/00027144/2021");
        driver.findElement(By.id("crmGrid_findCriteriaButton")).click();
    }

    @Then("Organization Taxpayer Tin is displayed")
    public void organizationTaxpayerTinIsDisplayed() throws Throwable {
        Thread.sleep(3000);

        WebDriverWait wait = new WebDriverWait(driver, 40);
        WebElement tinLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"TIN Number_label\"]")));
        System.out.println("---------------------------------------------------------");
        sharedatastep.Organization_tin=tinLabel.getText();
        if(sharedatastep.Organization_tin == null || sharedatastep.Organization_tin.equals("--")){
            refresh_page();
            switchToDefault();
            switch_to_frame0();
            organizationTaxpayerTinIsDisplayed();
        }else {
            System.out.println("Organization Taxpayer TIN is " + sharedatastep.Organization_tin );
            System.out.println("---------------------------------------------------------");
        }
    }

    @And("^Select Approval outcome Org dropdown value to Approve$")
    public void select_approval_outcome_org_dropdown_value_to_approve() throws Throwable {

        WebElement dropDown = driver.findElement(By.id("header_process_tbg_approvaloutcome3_d"));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        dropDown.click();
        Actions action = new Actions(driver);
        action.doubleClick(dropDown).perform();
        action.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();

        driver.switchTo().defaultContent();
    }

    @Then("Go to Registration > Register Taxtype")
    public void goToRegistrationRegisterTaxtype() throws InterruptedException {
        thirty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[span='Registration']"))).click();
        Thread.sleep(2000);
        thirty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[span='Register Tax Type']"))).click();
    }

    @Then("Search for Individual tin to register taxtype for")
    public void searchForIndividualTinToRegisterTaxtypeFor() {
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("SearchForm:tin"))).sendKeys(sharedatastep.Individual_tin);
        //twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("SearchForm:tin"))).sendKeys("1000058018");
        driver.findElement(By.id("SearchForm:j_idt40")).click();
    }

    @Then("Search for Organization tin to register taxtype for")
    public void searchForOrganizationTinToRegisterTaxtypeFor() {
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("SearchForm:tin"))).sendKeys(sharedatastep.Organization_tin);
        //twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("SearchForm:tin"))).sendKeys("1000058018");
        driver.findElement(By.id("SearchForm:j_idt40")).click();
    }

    @Then("Select taxtype to register and fill required details {string}")
    public void selectTaxtypeToRegister(String taxtype) throws InterruptedException {
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("RegisterRegime:RegimeTable:RegisterTaxType"))).click();
        switchToFrameBackoffice();
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"RevenueTypeDetails:RevenueType\"]/div[3]"))).click();
        Thread.sleep(1500);
        driver.findElement(By.xpath("//li[contains(text(),'"+taxtype+"')]")).click();
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("document.getElementById('RevenueTypeDetails:EffectiveDateOfRegistration_input').setAttribute('value', '16/09/2016')");
        Thread.sleep(3500);
        driver.findElement(By.id("RevenueTypeDetails:EffectiveDateOfRegistration_input")).click();
        Thread.sleep(1500);
        driver.findElement(By.id("RevenueTypeDetails:EffectiveDateOfRegistration_input")).sendKeys("01012020");
        Thread.sleep(1500);
        actions.sendKeys(Keys.TAB);
        Thread.sleep(1500);
        driver.findElement(By.id("RevenueTypeDetails:TaxableTurnover_input")).sendKeys("12,000");
        Thread.sleep(900);
        driver.findElement(By.id("RevenueTypeDetails:okButton")).click();
        switchToDefault();

    }

    @Then("Submit taxtype registration application")
    public void submitTaxtypeRegistrationApplication() {
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("RegisterRegime:Submit"))).click();
    }

    @And("Select taxtype Approval outcome dropdown value to Approve {string}")
    public void selectTaxtypeApprovalOutcomeDropdownValueToApprove(String confirmation) throws Throwable {
        driver.switchTo().frame("WebResource_RegistrationApplicationAngular");
        WebElement downloadAttach = twohundred.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='" + confirmation + "']")));
        Assert.assertTrue(downloadAttach.isDisplayed());

        driver.switchTo().defaultContent();
        switch_to_frame1();
        WebElement Outcome = driver.findElement(By.id("header_process_tbg_approvaloutcome4"));
        Thread.sleep(5000);
        actions.doubleClick(Outcome).build().perform();
        Outcome.click();
        actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
    }


    @And("Click on return filing and processing > Lodge return")
    public void clickOnReturnFilingAndProcessingLodgeReturn() {
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[span='Return Filing and Processing']"))).click();
        driver.findElement(By.xpath("//a[span='Lodge Return']")).click();
    }

    @Then("Click Return document search button")
    public void clickReturnDocumentSearchButton() {
        fourty.until(ExpectedConditions.visibilityOfElementLocated(By.id("ReturnsLodgement:searchId"))).click();
    }

    @Then("Search for taxtype with category {string} and taxtype {string} for period year {string} and number {string}")
    public void searchForTaxtypeWithCategoryAndTaxtype(String category, String taxtype, String year, String number) throws InterruptedException {
         switchToFrameBackoffice();
         String tin="";
         if(category.equals("Individual")){
             tin = sharedatastep.Individual_tin;
            // tin = "1000066002";
         }else if(category.equals("Organisation")){
             tin = sharedatastep.Organization_tin;
             //tin = "1000058603";
         }

         thirty.until(ExpectedConditions.visibilityOfElementLocated(By.id("SearchForm:TIN"))).sendKeys(tin);
         driver.findElement(By.xpath("//*[@id=\"SearchForm:ReturnType_label\"]")).click();
         Thread.sleep(1000);
         driver.findElement(By.xpath("//li[contains(text(),'" + taxtype + "')]")).click();
         driver.findElement(By.id("SearchForm:PeriodNumber")).sendKeys(number);
         driver.findElement(By.id("SearchForm:PeriodYear")).sendKeys(year);

         driver.findElement(By.id("SearchForm:j_idt21")).click();
         switchToDefault();
    }

    @Then("Enter liability")
    public void enterLiability() throws InterruptedException {
         Thread.sleep(5000);
         twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("ReturnsLodgement:id_Liability_input"))).sendKeys("100,000");
    }

    @Then("Submit lodge return application")
    public void submitLodgeReturnApplication() throws InterruptedException {
        Thread.sleep(4000);
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("ReturnsLodgement:SaveLodgement"))).click();
    }

    @And("Click on return filing and processing > File return")
    public void clickOnReturnFilingAndProcessingFileReturn() throws InterruptedException {
        thirty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[span='Return Filing and Processing']"))).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[span='File Return']")).click();
    }

    @Then("Select return document as {string}")
    public void selectReturnDocumentAs(String taxtype) throws InterruptedException {
        thirty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"FormSelection:returnType\"]/div[3]"))).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//li[contains(text(),'" + taxtype + "')]")).click();
        driver.findElement(By.id("FormSelection:nextReturnButton")).click();
    }

    @Then("Find tax return for category {string} with year {string} and number {string}")
    public void findTaxReturnForCategoryWithYearAndNumber(String category, String year, String number) {
        String tin="";
        if(category.equals("Individual")){
            tin = sharedatastep.Individual_tin;
            //tin = "1000066002";
        }else if(category.equals("Organisation")){
            tin = sharedatastep.Organization_tin;
            //tin = "1000058603";
        }

        thirty.until(ExpectedConditions.visibilityOfElementLocated(By.id("SearchForm:tin"))).sendKeys(tin);
        driver.findElement(By.id("SearchForm:periodyear")).sendKeys(year);
        driver.findElement(By.id("SearchForm:periodnumber")).sendKeys(number);

        driver.findElement(By.id("SearchForm:j_idt40")).click();



    }

    @Then("Fill in file return details for taxtype {string}")
    public void fillInFileReturnDetailsForTaxtype(String taxtype) throws InterruptedException, AWTException {
        if (taxtype.equals("PAYE Returns")) {
            twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("FlexibleFormEntity:T_Items:j_id5"))).click();
            switchToFrameBackoffice();
            Thread.sleep(1000);
            thirty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"FlexbleCSVFileUpload:fileCSVFiletoUpload\"]/div[1]/span"))).click();
            Thread.sleep(2000);
//            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("FlexbleCSVFileUpload:fileCSVFiletoUpload_input"))).sendKeys("C:\\template.csv");
            Robot rb = new Robot();

            // copying File path to Clipboard
            String path = System.getProperty("user.dir") + File.separator + "src\\test\\resources\\paye.csv";
            StringSelection str = new StringSelection(path);
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);

            // press Contol+V for pasting
            rb.keyPress(KeyEvent.VK_CONTROL);
            rb.keyPress(KeyEvent.VK_V);

            // release Contol+V for pasting
            rb.keyRelease(KeyEvent.VK_CONTROL);
            rb.keyRelease(KeyEvent.VK_V);
            Thread.sleep(3000);
            // for pressing and releasing Enter
            rb.keyPress(KeyEvent.VK_ENTER);
            rb.keyRelease(KeyEvent.VK_ENTER);
            Thread.sleep(3000);
            driver.findElement(By.xpath("//*[@id=\"FlexbleCSVFileUpload:fileCSVFiletoUpload\"]/div[1]/button[1]")).click();
            fifteen.until(ExpectedConditions.visibilityOfElementLocated(By.id("FlexbleCSVFileUpload:id_filename"))).isDisplayed();
            Thread.sleep(4000);
            driver.findElement(By.id("FlexbleCSVFileUpload:btnNext")).click();
            driver.switchTo().defaultContent();
            Thread.sleep(3000);
            twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("FlexibleFormEntity:declarantName"))).sendKeys("DR Margie Wambui");
            driver.findElement(By.id("FlexibleFormEntity:declarantDesignation")).sendKeys("Doctor");
            //driver.findElement(By.id("FlexibleFormEntity:declarationDate_input")).sendKeys("01/01/2018");
//            JavascriptExecutor jse = (JavascriptExecutor) driver;
//            jse.executeScript("document.getElementById('FlexibleFormEntity:declarationDate_input').setAttribute('value', '01/01/2018')");
        }

        if (taxtype.equals("PIT Return (Final)")) {
            WebDriverWait wait = new WebDriverWait(driver, 70);
            Thread.sleep(5000);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'BALANCE SHEET')]"))).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("FlexibleFormEntity:pitShowTab:balanceSheetDate_input"))).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("FlexibleFormEntity:pitShowTab:balanceSheetDate_input"))).sendKeys(Keys.ENTER);
            Thread.sleep(2000);
            driver.findElement(By.id("FlexibleFormEntity:pitShowTab:stocksInventories_input")).sendKeys("0");
            driver.findElement(By.id("FlexibleFormEntity:pitShowTab:receivables_input")).sendKeys("0");
            driver.findElement(By.id("FlexibleFormEntity:pitShowTab:bankBalances_input")).sendKeys("0");
            driver.findElement(By.id("FlexibleFormEntity:pitShowTab:otherCurrentAssets_input")).sendKeys("0");
            driver.findElement(By.id("FlexibleFormEntity:pitShowTab:prePayment_input")).sendKeys("0");
            driver.findElement(By.id("FlexibleFormEntity:pitShowTab:building_input")).sendKeys("0");
            driver.findElement(By.id("FlexibleFormEntity:pitShowTab:furnitureAndEquipments_input")).sendKeys("0");
            driver.findElement(By.id("FlexibleFormEntity:pitShowTab:motorVehicles_input")).sendKeys("0");
            driver.findElement(By.id("FlexibleFormEntity:pitShowTab:otherAssets_input")).sendKeys("0");
            driver.findElement(By.id("FlexibleFormEntity:pitShowTab:billsPayable_input")).sendKeys("0");
            driver.findElement(By.id("FlexibleFormEntity:pitShowTab:loans_input")).sendKeys("0");
            driver.findElement(By.id("FlexibleFormEntity:pitShowTab:accruals_input")).sendKeys("0");
            driver.findElement(By.id("FlexibleFormEntity:pitShowTab:otherPayables_input")).sendKeys("0");
            driver.findElement(By.id("FlexibleFormEntity:pitShowTab:capital_input")).sendKeys("0");
            driver.findElement(By.id("FlexibleFormEntity:pitShowTab:netProfitBalanceSheet_input")).sendKeys("0");
            driver.findElement(By.id("FlexibleFormEntity:pitShowTab:drawings_input")).sendKeys("0");

            driver.findElement(By.xpath("//a[contains(text(),'INCOME STATEMENT')]")).click();
            Thread.sleep(2000);
            driver.findElement(By.id("FlexibleFormEntity:pitShowTab:basicSalary_input")).sendKeys("65000");
            driver.findElement(By.id("FlexibleFormEntity:pitShowTab:cashAllowance_input")).sendKeys("0");
            driver.findElement(By.id("FlexibleFormEntity:pitShowTab:otherCashBenefit_input")).sendKeys("0");
            driver.findElement(By.id("FlexibleFormEntity:pitShowTab:bonus_input")).sendKeys("0");
            driver.findElement(By.id("FlexibleFormEntity:pitShowTab:accomodation_input")).sendKeys("0");
            driver.findElement(By.id("FlexibleFormEntity:pitShowTab:vehicle_input")).sendKeys("0");
            driver.findElement(By.id("FlexibleFormEntity:pitShowTab:bkOthers_input")).sendKeys("0");
            driver.findElement(By.id("FlexibleFormEntity:pitShowTab:otherEmploymentIncome_input")).sendKeys("0");
            driver.findElement(By.id("FlexibleFormEntity:pitShowTab:rentIncome_input")).sendKeys("0");
            driver.findElement(By.id("FlexibleFormEntity:pitShowTab:dividends_input")).sendKeys("0");
            driver.findElement(By.id("FlexibleFormEntity:pitShowTab:interest_input")).sendKeys("0");
            driver.findElement(By.id("FlexibleFormEntity:pitShowTab:naturalResourcePayment_input")).sendKeys("0");
            driver.findElement(By.id("FlexibleFormEntity:pitShowTab:royalty_input")).sendKeys("0");
            driver.findElement(By.id("FlexibleFormEntity:pitShowTab:directorsFees_input")).sendKeys("0");
            driver.findElement(By.id("FlexibleFormEntity:pitShowTab:commission_input")).sendKeys("0");
            driver.findElement(By.id("FlexibleFormEntity:pitShowTab:charges_input")).sendKeys("0");
            driver.findElement(By.id("FlexibleFormEntity:pitShowTab:discounts_input")).sendKeys("0");
            driver.findElement(By.id("FlexibleFormEntity:pitShowTab:premium_input")).sendKeys("0");
            driver.findElement(By.id("FlexibleFormEntity:pitShowTab:annuity_input")).sendKeys("0");
            driver.findElement(By.id("FlexibleFormEntity:pitShowTab:otherInvestmentIncome_input")).sendKeys("0");
            driver.findElement(By.id("FlexibleFormEntity:pitShowTab:costOfSales_input")).sendKeys("0");
            driver.findElement(By.id("FlexibleFormEntity:pitShowTab:operatingExpenses_input")).sendKeys("0");
            driver.findElement(By.id("FlexibleFormEntity:pitShowTab:generalExpenses_input")).sendKeys("0");
            driver.findElement(By.id("FlexibleFormEntity:pitShowTab:depreciation_input")).sendKeys("0");
            driver.findElement(By.id("FlexibleFormEntity:pitShowTab:foreignExchangeLoss_input")).sendKeys("0");
            driver.findElement(By.id("FlexibleFormEntity:pitShowTab:otherCostsExpenses_input")).sendKeys("0");
            driver.findElement(By.id("FlexibleFormEntity:pitShowTab:unrealisedExchangeLoss_input")).sendKeys("0");
            driver.findElement(By.id("FlexibleFormEntity:pitShowTab:addBackDepreciation_input")).sendKeys("0");
            driver.findElement(By.id("FlexibleFormEntity:pitShowTab:addBackBadDebt_input")).sendKeys("0");
            driver.findElement(By.id("FlexibleFormEntity:pitShowTab:addBackServiceBenifit_input")).sendKeys("0");
            driver.findElement(By.id("FlexibleFormEntity:pitShowTab:addBackDisallowedInterest_input")).sendKeys("0");
            driver.findElement(By.id("FlexibleFormEntity:pitShowTab:addBackCapitalisedRepairs_input")).sendKeys("0");
            driver.findElement(By.id("FlexibleFormEntity:pitShowTab:addBackEntertainmentExpenses_input")).sendKeys("0");
            driver.findElement(By.id("FlexibleFormEntity:pitShowTab:addBackSaleBusinessAsset_input")).sendKeys("0");
            driver.findElement(By.id("FlexibleFormEntity:pitShowTab:addBackOther_input")).sendKeys("0");
            driver.findElement(By.id("FlexibleFormEntity:pitShowTab:nonTaxInterestIncome_input")).sendKeys("0");
            driver.findElement(By.id("FlexibleFormEntity:pitShowTab:nonTaxSaleBusinessAsset_input")).sendKeys("0");
            driver.findElement(By.id("FlexibleFormEntity:pitShowTab:nonTaxRentalIncome_input")).sendKeys("0");
            driver.findElement(By.id("FlexibleFormEntity:pitShowTab:nonTaxOthers_input")).sendKeys("0");
            driver.findElement(By.id("FlexibleFormEntity:pitShowTab:adExchangeGain_input")).sendKeys("0");
            driver.findElement(By.id("FlexibleFormEntity:pitShowTab:adCapitalAllowance_input")).sendKeys("0");
            driver.findElement(By.id("FlexibleFormEntity:pitShowTab:adEndOfServicePaid_input")).sendKeys("0");
            driver.findElement(By.id("FlexibleFormEntity:pitShowTab:adSaleOfBusinessAsset_input")).sendKeys("0");
            driver.findElement(By.id("FlexibleFormEntity:pitShowTab:adInvestmentAllowance_input")).sendKeys("0");
            driver.findElement(By.id("FlexibleFormEntity:pitShowTab:adOthers_input")).sendKeys("0");

            driver.findElement(By.xpath("//a[contains(text(),'TAX COMPUTATION')]")).click();
            Thread.sleep(2000);
            driver.findElement(By.id("FlexibleFormEntity:pitShowTab:finalTotalEmploymentIncome_input")).sendKeys("90000");
            driver.findElement(By.id("FlexibleFormEntity:pitShowTab:lossBroughtFromPreviousYear_input")).sendKeys("0");
            driver.findElement(By.id("FlexibleFormEntity:pitShowTab:lossReliefForTheYear_input")).sendKeys("0");
            driver.findElement(By.id("FlexibleFormEntity:pitShowTab:tpWHT_input")).sendKeys("0");
            driver.findElement(By.id("FlexibleFormEntity:pitShowTab:tpTaxesPaidDirectly_input")).sendKeys("0");
            driver.findElement(By.id("FlexibleFormEntity:pitShowTab:tpPAYETaxPaid_input")).sendKeys("0");
            driver.findElement(By.id("FlexibleFormEntity:pitShowTab:tpPriorPeriodCredit_input")).sendKeys("0");

            Thread.sleep(1000);
            driver.findElement(By.xpath("//a[contains(text(),'ATTACHMENTS')]")).click();
            Thread.sleep(2000);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("FlexibleFormEntity:pitShowTab:attachmentTable:j_id1"))).click();
            WebElement frame = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("iframe")));
            driver.switchTo().frame(frame);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"FlexbleFormAttachment:DocType\"]/div[3]"))).click();
            Thread.sleep(1000);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[contains(text(),'Annual Financial Statements')]"))).click();
            Thread.sleep(2000);
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            driver.findElement(By.id("FlexbleFormAttachment:id_reference")).sendKeys(String.valueOf(timestamp.getTime()));
            Thread.sleep(1000);
            String path = System.getProperty("user.dir") + File.separator + "src\\test\\resources\\" + File.separator + "id_doc.png";
            driver.findElement(By.id("FlexbleFormAttachment:id_attachment_input")).sendKeys(path);
            Thread.sleep(3000);
            driver.findElement(By.id("FlexbleFormAttachment:Ok")).click();
            driver.switchTo().defaultContent();

            Thread.sleep(6000);
            driver.findElement(By.xpath("//a[contains(text(),'PERSONAL DETAILS')]")).click();

            twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("FlexibleFormEntity:pitShowTab:declarantName"))).sendKeys("DR Margie Wambui");
            driver.findElement(By.id("FlexibleFormEntity:pitShowTab:declarantPosition")).sendKeys("Doctor");
//            JavascriptExecutor jse = (JavascriptExecutor) driver;
            //jse.executeScript("FlexibleFormEntity:pitShowTab:declarationDate_input').setAttribute('value', '01/01/2018')");
            driver.findElement(By.id("FlexibleFormEntity:pitShowTab:declarationDate_input")).sendKeys("01/01/2018");
        }

        if (taxtype.equals("GST Return")) {

            thirty.until(ExpectedConditions.visibilityOfElementLocated(By.id("FlexibleFormEntity:standardSalesExclusive_input"))).sendKeys("20000");
            driver.findElement(By.id("FlexibleFormEntity:zeroRatedSupplies_input")).sendKeys("20000000");
            driver.findElement(By.id("FlexibleFormEntity:exemptSupplies_input")).sendKeys("0");
            driver.findElement(By.id("FlexibleFormEntity:relievedSuppliesExclusive_input")).sendKeys("0");
            driver.findElement(By.id("FlexibleFormEntity:InputTaxDeductible_input")).sendKeys("0");
            Thread.sleep(2000);

            thirty.until(ExpectedConditions.visibilityOfElementLocated(By.id("FlexibleFormEntity:attachmentTable:j_id1"))).click();

            switchToBackofficeFrame();
            thirty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"FlexbleFormAttachment:DocType\"]/div[3]"))).click();

            fourty.until(ExpectedConditions.visibilityOfElementLocated(By.id("FlexbleFormAttachment:DocType_1"))).click();
            Thread.sleep(2000);
            driver.findElement(By.id("FlexbleFormAttachment:id_reference")).sendKeys("Attachment");
            String path = System.getProperty("user.dir") + File.separator + "src\\test\\resources\\" + File.separator + "id_doc.png";
            driver.findElement(By.id("FlexbleFormAttachment:id_attachment_input")).sendKeys(path);
            driver.findElement(By.id("FlexbleFormAttachment:Ok")).click();
            switchToDefault();
            Thread.sleep(3000);
            twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("FlexibleFormEntity:declarantName"))).sendKeys("DR Margie Wambui");
            driver.findElement(By.id("FlexibleFormEntity:declarantDesignation")).sendKeys("Doctor");
            //driver.findElement(By.id("FlexibleFormEntity:declarationDate_input")).sendKeys("01/01/2018");
        }

        if (taxtype.equals("CIT Return (Final)")) {
            WebDriverWait wait = new WebDriverWait(driver, 50);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"FlexibleFormEntity:CITDetailsTab:BusinessLocation\"]/div[3]"))).click();
            Thread.sleep(1000);
            Actions actions = new Actions(driver);
            actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
            Thread.sleep(1000);
            driver.findElement(By.xpath("//a[contains(text(),'Balance Sheet')]")).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("FlexibleFormEntity:CITDetailsTab:balanceSheetDate_input"))).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("FlexibleFormEntity:CITDetailsTab:balanceSheetDate_input"))).sendKeys(Keys.ENTER);


            Thread.sleep(1000);
            driver.findElement(By.id("FlexibleFormEntity:CITDetailsTab:currentAssetsLocalCurrencies_input")).sendKeys("0");
            driver.findElement(By.id("FlexibleFormEntity:CITDetailsTab:currentAssetsCedis_input")).sendKeys("0");
            driver.findElement(By.id("FlexibleFormEntity:CITDetailsTab:stocksInventories_input")).sendKeys("0");
            driver.findElement(By.id("FlexibleFormEntity:CITDetailsTab:accountReceivables_input")).sendKeys("0");
            driver.findElement(By.id("FlexibleFormEntity:CITDetailsTab:fixedAssets_input")).sendKeys("0");
            driver.findElement(By.id("FlexibleFormEntity:CITDetailsTab:otherAssets_input")).sendKeys("0");
            driver.findElement(By.id("FlexibleFormEntity:CITDetailsTab:tradePayablesLocalCurrencies_input")).sendKeys("0");
            driver.findElement(By.id("FlexibleFormEntity:CITDetailsTab:tradePayablesLeones_input")).sendKeys("0");
            driver.findElement(By.id("FlexibleFormEntity:CITDetailsTab:otherPayablesLocalCurrencies_input")).sendKeys("0");
            driver.findElement(By.id("FlexibleFormEntity:CITDetailsTab:otherPayablesLeones_input")).sendKeys("0");
            driver.findElement(By.id("FlexibleFormEntity:CITDetailsTab:shareholdersFund_input")).sendKeys("0");

            Thread.sleep(1000);
            driver.findElement(By.xpath("//a[contains(text(),'Income Statement')]")).click();
            Thread.sleep(2000);
            driver.findElement(By.id("FlexibleFormEntity:CITDetailsTab:localSales_input")).sendKeys("0");
            driver.findElement(By.id("FlexibleFormEntity:CITDetailsTab:exportSales_input")).sendKeys("0");
            driver.findElement(By.id("FlexibleFormEntity:CITDetailsTab:rentIncome_input")).sendKeys("0");
            driver.findElement(By.id("FlexibleFormEntity:CITDetailsTab:dividends_input")).sendKeys("0");
            driver.findElement(By.id("FlexibleFormEntity:CITDetailsTab:interest_input")).sendKeys("0");
            driver.findElement(By.id("FlexibleFormEntity:CITDetailsTab:naturalResourcePayment_input")).sendKeys("0");
            driver.findElement(By.id("FlexibleFormEntity:CITDetailsTab:royalty_input")).sendKeys("0");
            driver.findElement(By.id("FlexibleFormEntity:CITDetailsTab:annuity_input")).sendKeys("0");
            driver.findElement(By.id("FlexibleFormEntity:CITDetailsTab:otherSpecify_input")).sendKeys("0");
            driver.findElement(By.id("FlexibleFormEntity:CITDetailsTab:lessCostOfSalesAndExpenses_input")).sendKeys("0");
            driver.findElement(By.id("FlexibleFormEntity:CITDetailsTab:generalExpenses_input")).sendKeys("0");
            driver.findElement(By.id("FlexibleFormEntity:CITDetailsTab:depreciation_input")).sendKeys("0");
            driver.findElement(By.id("FlexibleFormEntity:CITDetailsTab:foreignExchangeLosses_input")).sendKeys("0");
            driver.findElement(By.id("FlexibleFormEntity:CITDetailsTab:otherCostsExpenses_input")).sendKeys("0");
            driver.findElement(By.id("FlexibleFormEntity:CITDetailsTab:unrealisedExchangeLoss_input")).sendKeys("0");
            driver.findElement(By.id("FlexibleFormEntity:CITDetailsTab:depreciation_ab_input")).sendKeys("0");
            driver.findElement(By.id("FlexibleFormEntity:CITDetailsTab:gpForBadDebt_input")).sendKeys("0");
            driver.findElement(By.id("FlexibleFormEntity:CITDetailsTab:serviceBenefit_input")).sendKeys("0");
            driver.findElement(By.id("FlexibleFormEntity:CITDetailsTab:disallowedInterest_input")).sendKeys("0");
            driver.findElement(By.id("FlexibleFormEntity:CITDetailsTab:capitalisedRepairs_input")).sendKeys("0");
            driver.findElement(By.id("FlexibleFormEntity:CITDetailsTab:entertainmentExpenses_input")).sendKeys("0");
            driver.findElement(By.id("FlexibleFormEntity:CITDetailsTab:businessAsset_input")).sendKeys("0");
            driver.findElement(By.id("FlexibleFormEntity:CITDetailsTab:othersSpecify_ab_input")).sendKeys("0");
            driver.findElement(By.id("FlexibleFormEntity:CITDetailsTab:interestIncome_input")).sendKeys("0");
            driver.findElement(By.id("FlexibleFormEntity:CITDetailsTab:saleBusinessAsset_input")).sendKeys("0");
            driver.findElement(By.id("FlexibleFormEntity:CITDetailsTab:nt_rentalIncome_input")).sendKeys("0");
            driver.findElement(By.id("FlexibleFormEntity:CITDetailsTab:nt_othersSpecify_input")).sendKeys("0");
            driver.findElement(By.id("FlexibleFormEntity:CITDetailsTab:ad_exchangeGain_input")).sendKeys("0");
            driver.findElement(By.id("FlexibleFormEntity:CITDetailsTab:ad_capitalAllowance_input")).sendKeys("0");
            driver.findElement(By.id("FlexibleFormEntity:CITDetailsTab:ad_endOfServicePaid_input")).sendKeys("0");
            driver.findElement(By.id("FlexibleFormEntity:CITDetailsTab:ad_saleOfBusinessAsset_input")).sendKeys("0");
            driver.findElement(By.id("FlexibleFormEntity:CITDetailsTab:ad_investmentAllowance_input")).sendKeys("0");
            driver.findElement(By.id("FlexibleFormEntity:CITDetailsTab:ad_othersSpecify_input")).sendKeys("0");

            Thread.sleep(1000);
            driver.findElement(By.xpath("//a[contains(text(),'Computation Of Taxes')]")).click();
            Thread.sleep(2000);
            driver.findElement(By.id("FlexibleFormEntity:CITDetailsTab:lossBroughtFromPrevYear_input")).sendKeys("0");
            driver.findElement(By.id("FlexibleFormEntity:CITDetailsTab:lossRelief_input")).sendKeys("0");
            driver.findElement(By.id("FlexibleFormEntity:CITDetailsTab:wht_input")).sendKeys("0");
            driver.findElement(By.id("FlexibleFormEntity:CITDetailsTab:taxesPaidDirectly_input")).sendKeys("0");
            driver.findElement(By.id("FlexibleFormEntity:CITDetailsTab:priorPeriodCredit_input")).sendKeys("0");

            Thread.sleep(1000);
            driver.findElement(By.xpath("//a[contains(text(),'Attachments')]")).click();
            Thread.sleep(2000);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("FlexibleFormEntity:CITDetailsTab:attachmentTable:j_id1"))).click();
            WebElement frame = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("iframe")));
            driver.switchTo().frame(frame);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"FlexbleFormAttachment:DocType\"]/div[3]"))).click();
            Thread.sleep(1000);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[contains(text(),'Annual Financial Statements')]"))).click();
            Thread.sleep(2000);
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            driver.findElement(By.id("FlexbleFormAttachment:id_reference")).sendKeys(String.valueOf(timestamp.getTime()));
            Thread.sleep(1000);
            String path = System.getProperty("user.dir") + File.separator + "src\\test\\resources\\" + File.separator + "id_doc.png";
            driver.findElement(By.id("FlexbleFormAttachment:id_attachment_input")).sendKeys(path);
            Thread.sleep(3000);
            driver.findElement(By.id("FlexbleFormAttachment:Ok")).click();
            driver.switchTo().defaultContent();

            twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("FlexibleFormEntity:CITDetailsTab:declarantName"))).sendKeys("DR Margie Wambui");
            driver.findElement(By.id("FlexibleFormEntity:CITDetailsTab:declarantPosition")).sendKeys("Doctor");
            //driver.findElement(By.id("FlexibleFormEntity:CITDetailsTab:declarationDate_input")).sendKeys("01/01/2018");
        }

    }

    @Then("Submit file return application")
    public void submitFileReturnApplication() throws InterruptedException {
        Thread.sleep(4000);
        driver.findElement(By.id("FlexibleFormEntity:save")).click();
    }

    @And("Click on return filing and processing > Adjust return")
    public void clickOnReturnFilingAndProcessingAdjustReturn() {
        thirty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[span='Return Filing and Processing']"))).click();
        driver.findElement(By.xpath("//a[span='Adjust Return']")).click();
    }

    @Then("Perform amendment for taxtype {string}")
    public void performAmendmentForTaxtype(String taxtype) throws InterruptedException {
        if (taxtype.equals("PAYE Returns")) {

            fifty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"FlexibleFormEntity:reasonForAmendment\"]/div[3]"))).click();
            Thread.sleep(1000);
            actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();

            Thread.sleep(1000);
            driver.findElement(By.id("FlexibleFormEntity:declarantName")).clear();
            driver.findElement(By.id("FlexibleFormEntity:declarantName")).sendKeys("DR Muthoni");

        }

        if (taxtype.equals("PIT Return (Final)")) {

            fifty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"FlexibleFormEntity:pitShowTab:reasonForAdjustment\"]/div[3]"))).click();
            Thread.sleep(1000);
            actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();

            Thread.sleep(1000);
            driver.findElement(By.id("FlexibleFormEntity:pitShowTab:declarantName")).clear();
            driver.findElement(By.id("FlexibleFormEntity:pitShowTab:declarantName")).sendKeys("DR Muthoni");

        }

        if (taxtype.equals("GST Return")) {

            fifty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"FlexibleFormEntity:reasonForAmendment\"]/div[3]"))).click();
            Thread.sleep(1000);
            actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();

            Thread.sleep(1000);
            driver.findElement(By.id("FlexibleFormEntity:declarantName")).clear();
            driver.findElement(By.id("FlexibleFormEntity:declarantName")).sendKeys("DR Muthoni");

        }


        if (taxtype.equals("CIT Return (Final)")) {
            fifty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"FlexibleFormEntity:CITDetailsTab:reasonForAdjustment\"]/div[3]"))).click();
            Thread.sleep(1000);
            actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();

            Thread.sleep(1000);
            driver.findElement(By.id("FlexibleFormEntity:CITDetailsTab:declarantName")).clear();
            driver.findElement(By.id("FlexibleFormEntity:CITDetailsTab:declarantName")).sendKeys("DR Muthoni");
        }
    }

    @Then("Submit adjust return application")
    public void submitAdjustReturnApplication() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.id("FlexibleFormEntity:save")).click();
    }

    @Then("Obtain reference number for adjust {string}")
    public void obtainReferenceNumberForAdjust(String refno) {
        String text  = onehundred.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'"+refno+"')]"))).getText();
        System.out.println(text);
        System.out.println("substring is "+ text.substring(75));
        sharedatastep.Reference_number = text.substring(75);
        //Tax return has been successfully saved.The status is now pending approval. PAYER/000001429/2020

        System.out.println("Actual ARN to be used in CRM is " +sharedatastep.Reference_number);
    }

    @And("click on Returns Tax return application")
    public void clickOnReturnsTaxReturnApplication() {
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.id("tbg_taxreturnapplication"))).click();
    }

    @When("enters adjust reference number in search results")
    public void entersAdjustReferenceNumberInSearchResults() {
        WebElement search = twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("crmGrid_findCriteria")));
        search.sendKeys(sharedatastep.Reference_number);
    	//search.sendKeys("PAYER/000003143/2021");
        search.sendKeys(Keys.ENTER);
    }

    @When("enters cancel reference number in search results")
    public void entersCancelReferenceNumberInSearchResults() {
        WebElement search = twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("crmGrid_findCriteria")));
        search.sendKeys(sharedatastep.Reference_number);
        //search.sendKeys("PAYER/000003143/2021");
        search.sendKeys(Keys.ENTER);
    }

    @And("Approve adjust returns application")
    public void approveAdjustReturnsApplication() throws Throwable {

        WebElement detailsframe = thirty.until(ExpectedConditions.visibilityOfElementLocated(By.id("WebResource_TaxReturnApplicationAngular")));
        driver.switchTo().frame(detailsframe);
        WebElement downloadAttach = twohundred.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='Taxpayer Name']")));
        Assert.assertTrue(downloadAttach.isDisplayed());

        driver.switchTo().defaultContent();

        WebElement specificframe = thirty.until(ExpectedConditions.visibilityOfElementLocated(By.id(Pro.getProperty("NextStage_Frame_ID1"))));
        driver.switchTo().frame(specificframe);
        Thread.sleep(3000);

        driver.findElement(By.xpath("//div[@data-attributename='tbg_approvaloutcome']")).click();
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
    }

    @Then("Click on Returns Save button")
    public void clickOnReturnsSaveButton() throws InterruptedException {
        Thread.sleep(1000);
        driver.switchTo().defaultContent();
        driver.findElement(By.id("tbg_taxreturnapplication|NoRelationship|Form|Mscrm.Form.tbg_taxreturnapplication.Save")).click();
    }


    @And("Click on return filing and processing > Cancel return")
    public void clickOnReturnFilingAndProcessingCancelReturn() {
        thirty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[span='Return Filing and Processing']"))).click();
        driver.findElement(By.xpath("//a[span='Cancel Return demo']")).click();
    }

    @Then("^Select reason for cancellation as \"([^\"]*)\" \"([^\"]*)\"$")
    public void select_reason_for_cancellation(String cancellationReason, String returnType) throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, 100);
        String dropdownXpath = "//*[@id=\"FlexibleFormEntity:reasonForCancellation\"]/div[3]";

        if(returnType.equals("CIT Return (Final)")){
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"FlexibleFormEntity:CITDetailsTab\"]/ul/li[6]/a"))).click();
            dropdownXpath = "//*[@id=\"FlexibleFormEntity:CITDetailsTab:reasonForCancellation\"]/div[3]";
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(dropdownXpath))).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//li[contains(text(),'" + cancellationReason + "')]")).click();

        }
        if(returnType.equals("Capital Gains Tax Return")){
            dropdownXpath = "//*[@id=\"FlexibleFormEntity:reasonForCancellation\"]/div[3]";
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(dropdownXpath))).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//li[contains(text(),'" + cancellationReason + "')]")).click();

        }
        if (returnType.equals("PAYE Returns")) {
            dropdownXpath = "//*[@id=\"FlexibleFormEntity:reasonForCancellation\"]/div[3]";
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(dropdownXpath))).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//li[contains(text(),'" + cancellationReason + "')]")).click();
        }

        if (returnType.equals("Excise Tax Return")) {
            dropdownXpath = "//*[@id=\"FlexibleFormEntity:reasonForCancellation\"]/div[3]";
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(dropdownXpath))).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//li[contains(text(),'" + cancellationReason + "')]")).click();
        }

        if (returnType.equals("FTT Return")) {
            dropdownXpath = "//*[@id=\"FlexibleFormEntity:reasonForCancellation\"]/div[3]";
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(dropdownXpath))).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//li[contains(text(),'" + cancellationReason + "')]")).click();
        }

        if (returnType.equals("GST Return")) {
            dropdownXpath = "//*[@id=\"FlexibleFormEntity:reasonForCancellation\"]/div[3]";
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(dropdownXpath))).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//li[contains(text(),'" + cancellationReason + "')]")).click();
        }

        if (returnType.equals("PIT Return (Final)")) {
            dropdownXpath = "//*[@id=\"FlexibleFormEntity:pitShowTab:reasonForCancellation\"]/div[3]";
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(dropdownXpath))).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//li[contains(text(),'" + cancellationReason + "')]")).click();
        }

        if (returnType.equals("PIT Return (Provisional)")) {
            dropdownXpath = "//*[@id=\"FlexibleFormEntity:reasonForCancellation\"]/div[3]";
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(dropdownXpath))).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//li[contains(text(),'" + cancellationReason + "')]")).click();
        }

        if (returnType.equals("Payroll Tax Return")) {
            dropdownXpath = "//*[@id=\"FlexibleFormEntity:reasonForCancellation\"]/div[3]";
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(dropdownXpath))).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//li[contains(text(),'" + cancellationReason + "')]")).click();
        }

        if (returnType.equals("Rental income Return")) {
            dropdownXpath = "//*[@id=\"FlexibleFormEntity:reasonForCancellation\"]/div[3]";
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(dropdownXpath))).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//li[contains(text(),'" + cancellationReason + "')]")).click();
        }

        if (returnType.equals("WHT (10.5% and 5.5%) Return")) {
            dropdownXpath = "//*[@id=\"FlexibleFormEntity:reasonForCancellation\"]/div[3]";
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(dropdownXpath))).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//li[contains(text(),'" + cancellationReason + "')]")).click();
        }
    }

    @Then("^Click cancel return$")
    public void click_cancel_return() throws Throwable {

        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("FlexibleFormEntity:cancel"))).click();
    }

    @Then("^Click yes$")
    public void click_yes() throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("FlexibleFormEntity:j_idt31"))).click();
    }

    @Then("Obtain reference number for cancellation {string}")
    public void obtainReferenceNumberForCancellation(String refno) throws Throwable{
        String text  = onehundred.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'"+refno+"')]"))).getText();
        System.out.println(text);
        System.out.println("substring is "+ text.substring(74));
        sharedatastep.Reference_number = text.substring(74);
        //Tax return has successfully saved.The status is now pending cancellation. CGTR/000002235/2021

        System.out.println("Actual ARN to be used in CRM is " +sharedatastep.Reference_number);
    }
}




