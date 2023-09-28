package ITFB.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class Alerts {
    private final SelenideElement alertsBtn = $x("//span[@class = 'text'] [text() = 'Alerts']");
    private final SelenideElement alertClkMeBtn = $x("//button [@id='alertButton']");
    private final SelenideElement alertTimerClkMeBtn = $x("//button [@id='timerAlertButton']");
    private final SelenideElement confirmClkMeBtn = $x("//button [@id='confirmButton']");
    private final SelenideElement promtClkMeBtn = $x("//button [@id='promtButton']");
    private final SelenideElement confirmResultMsg = $x("//span[@id ='confirmResult']");
    private final SelenideElement promptResultMsg = $x("//span[@id ='promptResult']");


    public void clickAlertBtn() {
        alertsBtn.click();
    }

    public void clickAlertClkMeBtn() {
        alertClkMeBtn.click();
    }

    public void clickAlertTimerClkMeBtn() {
        alertTimerClkMeBtn.click();
    }

    public void clickConfirmClkMeBtn() {
        confirmClkMeBtn.click();
    }

    public void clickPromptClkMeBtn() {
        promtClkMeBtn.click();
    }

    public void findConfirmResMsg() {
        confirmResultMsg.shouldBe(Condition.visible);
    }

    public String extractOKResult() {
        String data = confirmResultMsg.getText();
        return data;
    }

    public String extractEnterNameResult() {
        String data = promptResultMsg.getText();
        return data;
    }
}
