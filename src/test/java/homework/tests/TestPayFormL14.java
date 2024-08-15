package homework.tests;

import homework.pageObjects.MtsHomePagePayForm;
import io.qameta.allure.Allure;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("TestPayFormL14")
public class TestPayFormL14 extends BaseTest {

    public static MtsHomePagePayForm payForm;

    @BeforeEach
    public void before() {
        super.before();
        payForm = new MtsHomePagePayForm(driver);
        Allure.step("Discard cookie");
        payForm.discardCookie();
    }

    @DisplayName("Test Check Block Title")
    @Test
    public void testCheckBlockTitle() {
        Allure.step("Scroll to pay form");
        payForm.scrollToPaymentForm();
        Allure.step("Check form title");
        assertEquals("Онлайн пополнение\nбез комиссии", payForm.getPaymentFormTitle());
    }

    @DisplayName("Test Payments Logo")
    @Test
    public void testPaymentsLogo() {
        Allure.step("Scroll to pay form");
        payForm.scrollToPaymentForm();
        Allure.step("Check Payments Logo");
        assertAll("Payments Logo check",
                () -> assertEquals(5, payForm.getPayPartnersCount()),
                () -> assertEquals("Visa", payForm.getPayPartnersImgAlt(0)),
                () -> assertEquals("Verified By Visa", payForm.getPayPartnersImgAlt(1)),
                () -> assertEquals("MasterCard", payForm.getPayPartnersImgAlt(2)),
                () -> assertEquals("MasterCard Secure Code", payForm.getPayPartnersImgAlt(3)),
                () -> assertEquals("Белкарт", payForm.getPayPartnersImgAlt(4))
        );
    }

    @DisplayName("Test Check About Link")
    @Test
    public void testCheckAboutLink() {
        Allure.step("Scroll to pay form");
        payForm.scrollToPaymentForm();
        Allure.step("Click about link");
        payForm.clickAboutLinc();
        Allure.step("Check is about page opened");
        assertEquals("https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/", driver.getCurrentUrl());
    }

    @DisplayName("Test Check Payments")
    @Test
    public void testCheckPayments() {
        Allure.step("Scroll to pay form");
        payForm.scrollToPaymentForm();
        Allure.step("Fill pay form and submit");
        payForm.completeForm("297777777", "10", "email@email.com");
        Allure.step("Check Payments");
        assertAll("Check Payments",
                () -> assertTrue(payForm.isPaidAppShow()),
                () -> assertTrue(payForm.isPaidAppFormContain("10", "297777777"))
        );
    }
}
