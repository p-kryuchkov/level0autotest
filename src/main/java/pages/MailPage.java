package pages;

import steps.HomeSteps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class MailPage {
    @FindBy(xpath = "//*[contains(text(),'Написать письмо')]")
    public WebElement title;
    @FindBy(xpath = "//span[@title=\"Пометить прочитанным\"]")
    public WebElement unreadMessage;

    public int getCountUnreadMessages() {

        PageFactory.initElements(HomeSteps.getDriver(), this);
        @Deprecated
        Wait<WebDriver> wait = new WebDriverWait(HomeSteps.getDriver(), 5, 1000);
        wait.until(ExpectedConditions.visibilityOf(unreadMessage));

        List<WebElement> messages = (HomeSteps.getDriver()).findElements(By.xpath("//span[@title=\"Пометить прочитанным\"]"));
        int size = messages.size();
        System.out.println(size);
        return messages.size();

    }

    public void markUnreadMessage() throws InterruptedException {
        PageFactory.initElements(HomeSteps.getDriver(), this);
        @Deprecated
        Wait<WebDriver> wait = new WebDriverWait(HomeSteps.getDriver(), 5, 1000);
        wait.until(ExpectedConditions.visibilityOf(unreadMessage));
        List<WebElement> messages = (HomeSteps.getDriver()).findElements(By.xpath("//span[@title=\"Пометить прочитанным\"]"));
        int size = messages.size();
        while (size>0) {
            unreadMessage.click();
            Thread.sleep(1000);
            size--;
        }





    }
}

