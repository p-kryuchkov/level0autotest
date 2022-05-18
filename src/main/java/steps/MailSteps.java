package steps;

import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import pages.MailPage;

import java.io.IOException;

public class MailSteps {
    @Step("Получение количества непрочитанных сообщений")
    public void stepGetCountUnreadMessages() {
        new MailPage().getCountUnreadMessages();
        int size = new MailPage().getCountUnreadMessages();
        Allure.addAttachment("Результат", "text/plain", String.valueOf(size));
    }

    @Step("Пометить непрочитанные сообщения как прочитанные")
    public void stepMarkUnreadMessage() throws InterruptedException {
        new MailPage().markUnreadMessage();
    }

}
