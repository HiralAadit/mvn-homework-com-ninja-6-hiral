package com.tutorialsninja.Utility;

import com.tutorialsninja.browserfactory.ManageBrowser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Utility extends ManageBrowser {
    public void clickOnElement(By by) {
        WebElement loginLink = driver.findElement(by);
        loginLink.click();
    }

    public void sendTextToElement(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }

    /*This method will send on element
     */
    public String getTextFromElement(By by) {
        WebElement actualTextMessageElement = driver.findElement(by);
        return actualTextMessageElement.getText();
    }
    //Homework 4 method acceptAlert,dismissAlert, getTextFromAlert, sendtoAlert(String text)
    //******* Select class Methods**********************
//This method will send text to elements
    public void sendTextToElements(By by, String text) {
        //Find the email field element
        WebElement emailField = driver.findElement(by);
        emailField.sendKeys(text);
    }
    //this method will swith to alert
    public void switchToAlert() {
        driver.switchTo().alert();
    }

    //acceptAlert
    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }
    //dismissAlert
    public void dismissAlert() {
        driver.switchTo().alert().dismiss();
    }
    //String getTextFromAlert
    public String getTextFromAlert() {
        return driver.switchTo().alert().getText();
    }
    //sendTextToAlert(String text)
    public void sendTextToAlert(String text) {
        driver.switchTo().alert().sendKeys(text);
    }
    //This method will select option by visible text
    public void selectByVisibleTextFromDropDown(By by,String text){
        WebElement drodown = driver.findElement(by);
        Select select = new Select(drodown);
        select.selectByVisibleText(text);
    }
    // This method will select the option by value
    public void selectByValue(By by, String text) {
        WebElement dropdown = driver.findElement(by);
        Select select = new Select(dropdown);
        select.selectByValue(text);
    }
    // This method will select the option by index(int)

    public void selectByIndex(By by, int index) {
        WebElement dropdown = driver.findElement(by);
        Select select = new Select(dropdown);
        select.selectByIndex(index);
    }
    // This method will select the option by contains text
    public void selectByContainsText(By by, String text1) {
        WebElement dropdown = driver.findElement(by);
        Select select = new Select(dropdown);
        selectByContainsText(by, text1);
    }
    //*****************************Window Handle*****************************
    /**
     * This method will close all windows
     */
    public void closeAllWindows(List<String> hList, String parentWindow) {
        for (String str : hList) {
            if (!str.equals(parentWindow)) {
                driver.switchTo().window(str).close();
            }
        }
    }

    /**
     * This method will switch to parent window
     */
    public void switchToParentWindow(String parentWindowId) {
        driver.switchTo().window(parentWindowId);
    }

    /**
     * This method will find that we switch to right window
     */
    public boolean switchToRightWindow(String windowTitle, List<String> hList) {
        for (String str : hList) {
            String title = driver.switchTo().window(str).getTitle();
            if (title.contains(windowTitle)) {
                System.out.println("Found the right window....");
                return true;
            }
        }
        return false;
    }

    //*****************************************Action Class**************************
    //mouseHoverTOElement(By by)
    public void mouseHoverToElement(By by) {
        Actions actions = new Actions(driver);
        WebElement mouseHoverToElement = driver.findElement(by);
        //mouseHoverToElement(by);
        actions.moveToElement(mouseHoverToElement).build().perform();
    }
    //mouseHoverToElementAndClick(By by)
    public void mouseHoverToElementAndclick(By by){
        Actions actions = new Actions(driver);
        WebElement mouseHoverClick = driver.findElement(by);
        actions.moveToElement(mouseHoverClick).click().build().perform();
    }
    // in hw create othe 2 method Index &....

    /*/**
     * This method will select the option by value
     */

    /**
     * This method will select the option by index
     */

    /**
     * This method will select the option by contains text
     */
//***************** Window handle***************
    //****************** Action Class**************
//mouseHoverToElementAndClick(By by)
}


