package ITFB.page;

import ITFB.data.DataHelper;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class Elements {


    private static final SelenideElement extractName = $x("//p[@id='name']");
    private static final SelenideElement extractEmail = $x("//p[@id='email']");
    private static final SelenideElement extractCurrAddress = $x("//p[@id='currentAddress']");
    private static final SelenideElement extractPermAddress = $x("//p[@id='permanentAddress']");
    private final SelenideElement textBoxButton = $x("//span[@class = 'text'] [text() = 'Text Box']");
    private final SelenideElement fullNameInput = $x("//input [@id='userName']");
    private final SelenideElement emailInput = $x("//input [@id='userEmail']");
    private final SelenideElement currAddressInput = $x("//textarea[@id='currentAddress']");
    private final SelenideElement permAddressInput = $x("//textarea[@id='permanentAddress']");
    private final SelenideElement submitButton = $x("//*[@id='submit']");
    private final SelenideElement buttonsButton = $x("//span[@class = 'text'] [text() = 'Buttons']");
    private final SelenideElement dblClickMeBtn = $x("//*[@id='doubleClickBtn']");
    private final SelenideElement findDblClickBtnMsg = $x("//*[@id='doubleClickMessage']");
    private final SelenideElement rightClickMeBtn = $x("//*[@id='rightClickBtn']");
    private final SelenideElement findRightClickMeBtnMsg = $x("//*[@id='rightClickMessage']");
    private final SelenideElement dynamicClickMeBtn = $x("//*[@id='ld2Yw']");
    private final SelenideElement findDynamicClickMeBtnMsg = $x("//*[@id='dynamicClickMessage']");

    public static String[] getSavedData() {
        String[] cleanResult = new String[4];
        cleanResult[0] = extractName.getText().replace("Name:", "");
        cleanResult[1] = extractEmail.getText().replace("Email:", "");
        cleanResult[2] = extractCurrAddress.getText().replace("Current Address :", "");
        cleanResult[3] = extractPermAddress.getText().replace("Permananet Address :", "");
        return cleanResult;
    }

    public void clickElementsButton() {
        textBoxButton.click();
    }

    public void clickSubmitButton() {
        submitButton.click();
    }

    public void clickButtonsButton() {
        buttonsButton.click();
    }

    public void clickDblClickMeBtn() {
        dblClickMeBtn.doubleClick();
    }

    public void findDblClickMeBtnMsg() {
        findDblClickBtnMsg.shouldBe(Condition.visible);
    }

    public void clickRightClickMeBtn() {
        rightClickMeBtn.contextClick();
    }

    public void findRightClickMeBtnMsg() {
        findRightClickMeBtnMsg.shouldBe(Condition.visible);
    }

    public void clickDynamicClickMeBtn() {
        dynamicClickMeBtn.click();
    }

    public void findDynamicClickMeBtnMsg() {
        findDynamicClickMeBtnMsg.shouldBe(Condition.visible);
    }

    public void fillFields(DataHelper.UserInfo userInfo) {
        fullNameInput.setValue(userInfo.getName());
        emailInput.setValue(userInfo.getEmail());
        currAddressInput.setValue(userInfo.getCurrentAddress());
        permAddressInput.setValue(userInfo.getPermanentAddress());

    }

}

