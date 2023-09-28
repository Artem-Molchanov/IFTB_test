package ITFB.test;

import ITFB.data.DataHelper;
import ITFB.page.AlertFrameWindow;
import ITFB.page.Alerts;
import ITFB.page.Elements;
import ITFB.page.MainPage;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class TestToolsQA {

    MainPage mainPage = new MainPage();
    Elements elemObj = new Elements();
    AlertFrameWindow alertFraWinObj = new AlertFrameWindow();
    Alerts alertsObj = new Alerts();
    DataHelper.UserInfo userInfo = new DataHelper.UserInfo();

    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterAll
    static void tearDown() {
        SelenideLogger.removeListener("AllureSelenide");
    }

    @BeforeEach
    void setup() {
        Configuration.headless = true;
        Configuration.browserSize = "1920x1080";
        open("https://demoqa.com/");
    }

    @Test

    public void shouldTestTextBox() {
        mainPage.clickElementsButton();
        elemObj.clickElementsButton();
        elemObj.fillFields(userInfo);
        elemObj.clickSubmitButton();
        String[] expected = {userInfo.getName(), userInfo.getEmail(), userInfo.getCurrentAddress(), userInfo.getPermanentAddress()};
        String[] actual = Elements.getSavedData();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldTestButtonsClicks() {
        mainPage.clickElementsButton();
        elemObj.clickButtonsButton();
        elemObj.clickDblClickMeBtn();
        elemObj.findDblClickMeBtnMsg();
        elemObj.clickRightClickMeBtn();
        elemObj.findRightClickMeBtnMsg();
    }

    @Test
    public void shouldTestCloseTabsAndWindows() {
        mainPage.clickAlrtsFrmsWndsButton();
        alertFraWinObj.clickBrwWinBtn();
        alertFraWinObj.clickNewTabBtn();
        alertFraWinObj.clickNewWinBtn();
        switchTo().window(1);
        Selenide.closeWindow();
        switchTo().window(1);
        Selenide.closeWindow();
        switchTo().window(0);
        alertFraWinObj.clickNewWinMsgBtn();
        Selenide.closeWindow();
    }

    @Test
    public void shouldTestAlertsWindows() {
        mainPage.clickAlrtsFrmsWndsButton();
        alertsObj.clickAlertBtn();
        alertsObj.clickAlertClkMeBtn();
        getWebDriver().switchTo().alert().accept();
        alertsObj.clickAlertTimerClkMeBtn();
        sleep(5000);
        getWebDriver().switchTo().alert().accept();
    }

    @Test
    public void shouldTestConfirmWindow() {
        mainPage.clickAlrtsFrmsWndsButton();
        alertsObj.clickAlertBtn();
        alertsObj.clickConfirmClkMeBtn();

        Assertions.assertEquals("You selected Ok", alertsObj.extractOKResult());
    }

    @Test
    public void shouldTestPromptWindow() {
        mainPage.clickAlrtsFrmsWndsButton();
        alertsObj.clickAlertBtn();
        alertsObj.clickPromptClkMeBtn();
        getWebDriver().switchTo().alert().sendKeys("Test name");
        switchTo().alert().accept();

        Assertions.assertEquals("You entered Test name", alertsObj.extractEnterNameResult());

    }
}
