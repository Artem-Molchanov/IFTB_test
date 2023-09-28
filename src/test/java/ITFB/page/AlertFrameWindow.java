package ITFB.page;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class AlertFrameWindow {
    private final SelenideElement browserWindowsBtn = $x("//span[@class = 'text'] [text() = 'Browser Windows']");
    private final SelenideElement newTabBtn = $x("//*[@id='tabButton']");
    private final SelenideElement newWinBtn = $("#windowButton");
    private final SelenideElement newWinMsgBtn = $x("//button [@id='messageWindowButton']");


    public void clickBrwWinBtn() {
        browserWindowsBtn.click();
    }

    public void clickNewTabBtn() {
        newTabBtn.click();
    }

    public void clickNewWinBtn() {
        newWinBtn.click();
    }

    public void clickNewWinMsgBtn() {
        newWinMsgBtn.click();
    }

}
