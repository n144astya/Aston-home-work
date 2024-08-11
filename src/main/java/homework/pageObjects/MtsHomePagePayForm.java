package homework.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class MtsHomePagePayForm {

    private final WebDriver driver;

    public MtsHomePagePayForm(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//button[contains(@class,'cookie__cancel')]")
    private WebElement cookieCancelBtn;

    @FindBy(xpath = "//section[@class = 'pay']")
    private WebElement payOnlineForm;

    @FindBy(xpath = "//div[@class = 'pay__wrapper']/h2")
    private WebElement payOnlineTitle;

    @FindBy(xpath = "//div[@class = 'pay__partners']/ul/li/img")
    private List<WebElement> payPartners;

    @FindBy(xpath = "//div[@class = 'pay__wrapper']/a")
    private WebElement aboutLinc;

    @FindBy(xpath = "//div[@class = 'pay__form']/div")
    private WebElement typesOfServiceDropDow;

    @FindBy(xpath = "//div[contains(@class, 'select__wrapper')]/ul/li")
    private List<WebElement> typesOfServices;

    @FindBy(xpath = "//input[@id = 'connection-phone']")
    private WebElement mobilePhoneInput;

    @FindBy(xpath = "//input[@id = 'internet-phone']")
    private WebElement internetPhoneInput;

    @FindBy(xpath = "//input[@id = 'score-instalment']")
    private WebElement instalmentAccountNumberInput;

    @FindBy(xpath = "//input[@id = 'score-arrears']")
    private WebElement arrearsAccountNumberInput;

    @FindBy(xpath = "//input[@id = 'connection-sum']")
    private WebElement sumInput;

    @FindBy(xpath = "//input[@id = 'internet-sum']")
    private WebElement internetSumInput;

    @FindBy(xpath = "//input[@id = 'instalment-sum']")
    private WebElement instalmentSumInput;

    @FindBy(xpath = "//input[@id = 'arrears-sum']")
    private WebElement arrearsSumInput;

    @FindBy(xpath = "//input[@id = 'connection-email']")
    private WebElement emailInput;

    @FindBy(xpath = "//input[@id = 'internet-email']")
    private WebElement internetEmailInput;

    @FindBy(xpath = "//input[@id = 'instalment-email']")
    private WebElement instalmentEmailInput;

    @FindBy(xpath = "//input[@id = 'arrears-email']")
    private WebElement arrearsEmailInput;

    @FindBy(xpath = "//*[@id = 'pay-connection']/button")
    private WebElement continueBtn;

    @FindBy(xpath = "//iframe[@class = 'bepaid-iframe']")
    private WebElement paidAppForm;

    @FindBy(xpath = "//div[@class = 'pay-description__cost']/span[1]")
    private WebElement paidAppDescriptionCoast;

    @FindBy(xpath = "//div[@class = 'pay-description__text']/span")
    private WebElement paidAppDescriptionText;

    @FindBy(xpath = "//button[@aria-label='Google Pay']")
    private WebElement googlePay;

    @FindBy(xpath = "//button[@aria-label='Yandex Pay']")
    private WebElement yandexPay;

    @FindBy(xpath = "//div[contains(@class, 'icons-container')]/div[contains(@class, 'cards-brands')]")
    private WebElement cardsBrands;

    @FindBy(xpath = "//div[@class = 'card-page__card']/button")
    private WebElement paidAppSubmitBtn;

    @FindBy(xpath = "//*[@id = 'cc-number']/following-sibling::label")
    private WebElement paidAppCardNumber;

    @FindBy(xpath = "//*[@autocomplete = 'cc-exp']/following-sibling::label")
    private WebElement paidAppCardExpirationDate;

    @FindBy(xpath = "//*[@autocomplete = 'cc-csc']/following-sibling::label")
    private WebElement paidAppCardCVC;

    @FindBy(xpath = "//*[@autocomplete = 'cc-name']/following-sibling::label")
    private WebElement paidAppCardOwner;

    public void discardCookie() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(cookieCancelBtn));
        cookieCancelBtn.click();
    }

    public void scrollToPaymentForm() {
        Actions actions = new Actions(driver);
        actions.moveToElement(payOnlineForm);
        actions.perform();
    }

    public String getPaymentFormTitle() {
        return payOnlineTitle.getText();
    }

    public int getPayPartnersCount() {
        return payPartners.size();
    }

    public String getPayPartnersImgAlt(int index) {
        return payPartners.get(index).getAttribute("alt");
    }

    public void clickAboutLinc() {
        aboutLinc.click();
    }

    public void completeForm(String phoneNumber, String sum, String email) {
        mobilePhoneInput.sendKeys(phoneNumber);
        sumInput.sendKeys(sum);
        emailInput.sendKeys(email);
        continueBtn.click();
    }

    public boolean isPaidAppShow() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.visibilityOf(paidAppForm));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isPaidAppFormContain(String sum, String phoneNumber) {
        driver.switchTo().frame(paidAppForm);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(paidAppDescriptionCoast));
        wait.until(ExpectedConditions.visibilityOf(paidAppDescriptionText));
        return paidAppDescriptionCoast.getText().toLowerCase().contains(sum) &&
                paidAppDescriptionText.getText().toLowerCase().contains(phoneNumber);
    }

    public boolean isPhoneInputContainPlaceholderText(String text) {
        return mobilePhoneInput.getAttribute("placeholder").toLowerCase().contentEquals(text.toLowerCase());
    }

    public boolean isSumInputContainPlaceholderText(String text) {
        return sumInput.getAttribute("placeholder").toLowerCase().contentEquals(text.toLowerCase());
    }

    public boolean isEmailInputContainPlaceholderText(String text) {
        return emailInput.getAttribute("placeholder").toLowerCase().contentEquals(text.toLowerCase());
    }

    public boolean isInternetNumberInputContainPlaceholderText(String text) {
        return internetPhoneInput.getAttribute("placeholder").toLowerCase().contentEquals(text.toLowerCase());
    }

    public boolean isInternetSumInputContainPlaceholderText(String text) {
        return internetSumInput.getAttribute("placeholder").toLowerCase().contentEquals(text.toLowerCase());
    }

    public boolean isInternetEmailInputContainPlaceholderText(String text) {
        return internetEmailInput.getAttribute("placeholder").toLowerCase().contentEquals(text.toLowerCase());
    }

    public boolean isInstalmentAccountNumberInputContainPlaceholderText(String text) {
        return instalmentAccountNumberInput.getAttribute("placeholder").toLowerCase().contentEquals(text.toLowerCase());
    }

    public boolean isInstalmentSumInputContainPlaceholderText(String text) {
        return instalmentSumInput.getAttribute("placeholder").toLowerCase().contentEquals(text.toLowerCase());
    }

    public boolean isInstalmentEmailInputContainPlaceholderText(String text) {
        return instalmentEmailInput.getAttribute("placeholder").toLowerCase().contentEquals(text.toLowerCase());
    }

    public boolean isArrearsAccountNumberInputContainPlaceholderText(String text) {
        return arrearsAccountNumberInput.getAttribute("placeholder").toLowerCase().contentEquals(text.toLowerCase());
    }

    public boolean isArrearsSumInputContainPlaceholderText(String text) {
        return arrearsSumInput.getAttribute("placeholder").toLowerCase().contentEquals(text.toLowerCase());
    }

    public boolean isArrearsEmailInputContainPlaceholderText(String text) {
        return arrearsEmailInput.getAttribute("placeholder").toLowerCase().contentEquals(text.toLowerCase());
    }

    public void selectService(int index) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        typesOfServiceDropDow.click();
        wait.until(ExpectedConditions.visibilityOf(typesOfServices.get(index)));
        typesOfServices.get(index).click();
    }

    public boolean isPaidAppFormValid(String sum,
                                      String phoneNumber,
                                      String cardNumberPlaceholder,
                                      String cardExpirationPlaceholder,
                                      String cardCVCPlaceholder,
                                      String cardOwnerPlaceholder) {
        driver.switchTo().frame(paidAppForm);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(paidAppDescriptionCoast));
        wait.until(ExpectedConditions.visibilityOf(paidAppDescriptionText));

        return paidAppDescriptionCoast.getText().toLowerCase().contains(sum) &&
                paidAppDescriptionText.getText().toLowerCase().contains(phoneNumber) &&
                paidAppCardNumber.getText().toLowerCase().contains(cardNumberPlaceholder.toLowerCase()) &&
                paidAppCardExpirationDate.getText().toLowerCase().contains(cardExpirationPlaceholder.toLowerCase()) &&
                paidAppCardCVC.getText().toLowerCase().contains(cardCVCPlaceholder.toLowerCase()) &&
                paidAppCardOwner.getText().toLowerCase().contains(cardOwnerPlaceholder.toLowerCase()) &&
                googlePay.isDisplayed() &&
                yandexPay.isDisplayed() &&
                cardsBrands.isDisplayed();
    }
}
