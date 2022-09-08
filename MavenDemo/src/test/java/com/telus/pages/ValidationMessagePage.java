package com.telus.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Reporter;


public class ValidationMessagePage
{
	WebDriver  driver;
	Actions action;


	@FindBy (how = How.XPATH,using="//*[@class='elementor-widget-container']")
	WebElement successMessage;
	public ValidationMessagePage(WebDriver  driver)
	{
		this.driver=driver;


	}

	public void navigateToSubmissionForm()
	{
		action =new Actions(driver);
		action.moveToElement(successMessage).perform();



		if(successMessage.isDisplayed())
		{
			Reporter.log(" Successfully Form Submitted is Message displayed");

		}
		else
		{
			Reporter.log("Successfully Form Submitted is Message not displayed");
		}
		// Validating the Success Message 

		String sucTxt = successMessage.getText();
		String[] arrySuccMsg=sucTxt.split(":");
		String actMsgTxt=arrySuccMsg[0].trim();
		String expMsgTxt = "Registration Form is Successfully Submitted. The Transaction ID";
		if(actMsgTxt.contains(expMsgTxt)) 
		{
			Reporter.log("successful Message "+ actMsgTxt);
		}
		else
		{

			Reporter.log("Actual and Expected Submitted message are not same");
			Reporter.log("The Actual Submitted message is "+ actMsgTxt);
			Reporter.log("The Expected Submitted message is "+ expMsgTxt);
		}


	}}


