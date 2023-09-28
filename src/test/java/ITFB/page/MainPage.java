package ITFB.page;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;

public class MainPage {
    private final SelenideElement elementsButton = $x("//*[@id='app']/div/div/div[2]/div/div[1]/div/div[1]");
    private final SelenideElement alertsFramesWndsButton = $x("//h5[text()='Alerts, Frame & Windows']");

    public void clickElementsButton() {
        elementsButton.click();
    }

    public void clickAlrtsFrmsWndsButton() {
        alertsFramesWndsButton.click();
    }
}

