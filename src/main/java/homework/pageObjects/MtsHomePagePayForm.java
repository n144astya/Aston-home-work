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

    @FindBy(xpath = "//input[@id = 'connection-phone']")
    private WebElement phoneNumberInput;

    @FindBy(xpath = "//input[@id = 'connection-sum']")
    private WebElement sumInput;

    @FindBy(xpath = "//input[@id = 'connection-email']")
    private WebElement emailInput;

    @FindBy(xpath = "//*[@id = 'pay-connection']/button")
    private WebElement continueBtn;

    @FindBy(xpath = "//iframe[@class = 'bepaid-iframe']")
    private WebElement paidAppForm;

    @FindBy(xpath = "//div[@class = 'pay-description__cost']/span[1]")
    private WebElement paidAppDescriptionCoast;

    @FindBy(xpath = "//div[@class = 'pay-description__text']/span")
    private WebElement paidAppDescriptionText;

    public void discardCookie() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(cookieCancelBtn));
        cookieCancelBtn.click();
    }

    public void scrollToPaymentForm() {
        Actions  actions = new Actions(driver);
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
        phoneNumberInput.sendKeys(phoneNumber);
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
}
