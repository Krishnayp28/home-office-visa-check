package gov.uk.check.visa.pages;

import com.aventstack.extentreports.Status;
import gov.uk.check.visa.customlisterners.CustomListeners;
import gov.uk.check.visa.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.List;

public class WorkTypePage extends Utility {



    @CacheLookup
    @FindBy(xpath ="//div[@class='govuk-radios']//div//label")
    List<WebElement> workType;
    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Continue']")
    WebElement continueButton;

    public void selectJobTypeList(String jobType) {
        Reporter.log("Select job type: " + workType.toString());
        for (WebElement job : workType) {
            if (job.getText().contains(jobType))
                clickOnElement(job);
            break;
        }
        CustomListeners.test.log(Status.PASS, "Select job type" + jobType);
    }

    public void clickContinueButton() {
        Reporter.log("Click on continue: " + continueButton.toString());
        clickOnElement(continueButton);
        CustomListeners.test.log(Status.PASS, "Click on continue" +continueButton);
    }

}
