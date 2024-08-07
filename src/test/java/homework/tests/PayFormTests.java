package homework.tests;

import homework.pageObjects.MtsHomePagePayForm;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;


public class PayFormTests {

    public static WebDriver driver;
    public static MtsHomePagePayForm payForm;

    @BeforeClass
    public static void setuo() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        payForm = new MtsHomePagePayForm(driver);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("http://mts.by");
    }

    @Test
    public void test() {
        payForm.discardCookie();
        payForm.scrollToPaymentForm();
        Assert.assertEquals( "Онлайн пополнение\nбез комиссии", payForm.getPaymentFormTitle());
        Assert.assertEquals(5, payForm.getPayPartnersCount());

        Assert.assertEquals("Visa", payForm.getPayPartnersImgAlt(0));
        Assert.assertEquals("Verified By Visa", payForm.getPayPartnersImgAlt(1));
        Assert.assertEquals("MasterCard", payForm.getPayPartnersImgAlt(2));
        Assert.assertEquals("MasterCard Secure Code", payForm.getPayPartnersImgAlt(3));
        Assert.assertEquals("Белкарт", payForm.getPayPartnersImgAlt(4));

        payForm.clickAboutLinc();
        Assert.assertEquals("https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/", driver.getCurrentUrl());
        driver.navigate().back();

        payForm.completeForm("297777777", "10", "email@email.com");
        Assert.assertTrue(payForm.isPaidAppShow());
        Assert.assertTrue(payForm.isPaidAppFormContain("10", "297777777"));
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
}
