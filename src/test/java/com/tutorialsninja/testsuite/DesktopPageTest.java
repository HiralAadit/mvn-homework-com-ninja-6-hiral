package com.tutorialsninja.testsuite;

import com.tutorialsninja.pages.DesktopPage;
import com.tutorialsninja.pages.HomePage;
import com.tutorialsninja.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DesktopPageTest extends BaseTest {

    DesktopPage desktopPage = new DesktopPage();
    HomePage homePage = new HomePage();

    @Test
    public void verifyProductArrangeInAlphabeticalOrder() {
        homePage.hoverAndClickOnDesktop();
        desktopPage.clickOnShowAllDesktops();
        desktopPage.sortByNameZToA();
    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessfully() throws InterruptedException {
        homePage.hoverAndClickOnDesktop();
        desktopPage.clickOnShowAllDesktops();
        desktopPage.sortByNameAToZ();
        desktopPage.clickOnHpLp3065();
        String expectedText = "HP LP3065";
        Assert.assertEquals(desktopPage.getHpLaptopText(), expectedText, "HP LP3065 is not displayed");
        desktopPage.deliveryDate();
        desktopPage.clearQuantityField();
        desktopPage.changeTheQuantity();
        desktopPage.clickOnAddToCartButton();
        String expectedSuccessText = "Success: You have added HP LP3065 to your shopping cart!\n" +
                "×";
        Assert.assertEquals(desktopPage.getSuccessMessage(), expectedSuccessText, "Success message is not displayed");
        Thread.sleep(5000);
        desktopPage.clickOnShoppingCartText();
        String expectedMessage = "Shopping Cart  (1.00kg)";
        Assert.assertEquals(desktopPage.getShoppingCartText(), expectedMessage, "Shopping cart is not displayed");
        String expectedProductName = "HP LP3065";
        Assert.assertEquals(desktopPage.getProductName(), expectedProductName, "HP LP3065 is not displayed");
        Assert.assertEquals(desktopPage.getDeliveryDate(),"Delivery Date: 2023-11-30","Delivery date not displayed");
        String expectedModelName = "Product 21";
        Assert.assertEquals(desktopPage.getProductModelName(), expectedModelName, "Product 21 is not displayed");
        desktopPage.clickOnCurrency();
        desktopPage.clickOnSterlingPound();
        String expectedTotal = "£74.73";
        Assert.assertEquals(desktopPage.getTotal(), expectedTotal, "Total is not displayed");
    }
}
