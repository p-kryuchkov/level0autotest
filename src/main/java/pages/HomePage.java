package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import steps.HomeSteps;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    @FindBy(xpath = "//*[@class=\"ph-whiteline\"]")
    WebElement topMenu;
    @FindBy(name = "username")
    WebElement username;
    @FindBy(name = "password")
    WebElement password;
    @FindBy(className = "submit-button-wrap")
    WebElement submitButton;

    public void selectTopMenu(String menuItem) {
        PageFactory.initElements(HomeSteps.getDriver(), this);
        @Deprecated
        Wait<WebDriver> wait = new WebDriverWait(HomeSteps.getDriver(), 5, 1000);
        wait.until(ExpectedConditions.visibilityOf(topMenu));
        topMenu.findElement(By.xpath("//*[contains(text(),'" + menuItem + "')]")).click();
    }

    public void typeLogin(String value) throws InterruptedException {
        WebElement iframe = HomeSteps.getDriver().findElement(By.className("ag-popup__frame__layout__iframe"));
        HomeSteps.getDriver().switchTo().frame(iframe);

        PageFactory.initElements(HomeSteps.getDriver(), this);
        @Deprecated
        Wait<WebDriver> wait = new WebDriverWait(HomeSteps.getDriver(), 15, 1000);
        wait.until(ExpectedConditions.visibilityOf(username));
        username.click();
        username.sendKeys(value);
        username.sendKeys(Keys.RETURN);
    }

    public void typePassword(String value) {
        PageFactory.initElements(HomeSteps.getDriver(), this);
        @Deprecated
        Wait<WebDriver> wait = new WebDriverWait(HomeSteps.getDriver(), 15, 1000);
        wait.until(ExpectedConditions.visibilityOf(password));
        password.click();
        password.sendKeys(value);
        submitButton.click();

    }


}
