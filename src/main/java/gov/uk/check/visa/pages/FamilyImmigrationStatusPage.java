package gov.uk.check.visa.pages;

import com.aventstack.extentreports.Status;
import gov.uk.check.visa.customlisterners.CustomListeners;
import gov.uk.check.visa.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.List;

public class FamilyImmigrationStatusPage extends Utility {


    @CacheLookup
    @FindBy(xpath = "//div[@class='gem-c-radio govuk-radios__item']//label")
    List<WebElement> visa;

    @FindBy(xpath = "//button[normalize-space()='Continue']")
    WebElement continueButton;

    public void selectImmigrationStatus(String status){
        Reporter.log("Select immigration status: " + visa.toString());

        switch (status){
            case "Yes":
                visa.get(0).click();
                break;
            case "NO":
                visa.get(1).click();
                break;
        }
        CustomListeners.test.log(Status.PASS, "Select immigration status" +visa);
    }
    public void clickContinueButton() {
        Reporter.log("Click on continue: " + continueButton.toString());
        clickOnElement(continueButton);
        CustomListeners.test.log(Status.PASS, "Click on continue" + continueButton);
    }
}
