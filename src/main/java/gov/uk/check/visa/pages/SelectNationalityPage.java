package gov.uk.check.visa.pages;

import com.aventstack.extentreports.Status;
import gov.uk.check.visa.customlisterners.CustomListeners;
import gov.uk.check.visa.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class SelectNationalityPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//select[@id='response']")
    WebElement country;
    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Continue')]")
    WebElement continueButton;

    public void selectCountry(String country) {
        Reporter.log("Select country:"+this.country.toString());
        selectByVisibleTextFromDropDown(this.country,country);
        CustomListeners.test.log(Status.PASS,"Select country"+country);
    }
    public void clickContinueButton(){
        Reporter.log("click on continue :" + continueButton.toString());
        clickOnElement(continueButton);
        CustomListeners.test.log(Status.PASS,"Click on continue"+ continueButton);
    }
}
