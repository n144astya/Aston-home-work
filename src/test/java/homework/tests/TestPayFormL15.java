package homework.tests;

import homework.pageObjects.MtsHomePagePayForm;
import io.qameta.allure.Allure;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("TestPayFormL15")
public class TestPayFormL15 extends BaseTest {

    public MtsHomePagePayForm payForm;

    @BeforeEach
    public void before() {
        super.before();
        payForm = new MtsHomePagePayForm(driver);
        Allure.step("Discard cookie");
        payForm.discardCookie();
    }

    @DisplayName("Test Check Communication Services Placeholders")
    @Test
    public void testCheckCommunicationServicesPlaceholders() {
        Allure.step("Scroll to pay form");
        payForm.scrollToPaymentForm();
        Allure.step("Communication services placeholders check");
        assertAll("Communication services placeholders check",
                () -> assertTrue(payForm.isPhoneInputContainPlaceholderText("Номер телефона")),
                () -> assertTrue(payForm.isSumInputContainPlaceholderText("Сумма")),
                () -> assertTrue(payForm.isEmailInputContainPlaceholderText("E-mail для отправки чека"))
        );
    }

    @DisplayName("Test Check Home Internet Placeholders")
    @Test
    public void testCheckHomeInternetPlaceholders() {
        Allure.step("Scroll to pay form");
        payForm.scrollToPaymentForm();
        Allure.step("Select service type: 2");
        payForm.selectService(1);
        Allure.step("Home internet placeholders check");
        assertAll("Home internet placeholders check",
                () -> assertTrue(payForm.isInternetNumberInputContainPlaceholderText("Номер абонента")),
                () -> assertTrue(payForm.isInternetSumInputContainPlaceholderText("Сумма")),
                () -> assertTrue(payForm.isInternetEmailInputContainPlaceholderText("E-mail для отправки чека"))
        );
    }

    @DisplayName("Test Check Instalment Placeholders")
    @Test
    public void testCheckInstalmentPlaceholders() {
        Allure.step("Scroll to pay form");
        payForm.scrollToPaymentForm();
        Allure.step("Select service type: 3");
        payForm.selectService(2);
        Allure.step("Instalment placeholders check");
        assertAll("Instalment placeholders check",
                () -> assertTrue(payForm.isInstalmentAccountNumberInputContainPlaceholderText("Номер счета на 44")),
                () -> assertTrue(payForm.isInstalmentSumInputContainPlaceholderText("Сумма")),
                () -> assertTrue(payForm.isInstalmentEmailInputContainPlaceholderText("E-mail для отправки чека"))
        );
    }

    @DisplayName("Test Check Arrears Placeholders")
    @Test
    public void testCheckArrearsPlaceholders() {
        Allure.step("Scroll to pay form");
        payForm.scrollToPaymentForm();
        Allure.step("Select service type: 4");
        payForm.selectService(3);
        Allure.step("Arrears placeholders check");
        assertAll("Arrears placeholders check",
                () -> assertTrue(payForm.isArrearsAccountNumberInputContainPlaceholderText("Номер счета на 2073")),
                () -> assertTrue(payForm.isArrearsSumInputContainPlaceholderText("Сумма")),
                () -> assertTrue(payForm.isArrearsEmailInputContainPlaceholderText("E-mail для отправки чека"))
        );
    }

    @DisplayName("Test Check Payments")
    @Test
    public void testCheckPayments() {
        Allure.step("Scroll to pay form");
        payForm.scrollToPaymentForm();
        Allure.step("Fill payment form and submit");
        payForm.completeForm("297777777", "10", "email@email.com");
        Allure.step("Pay app form validation");
        assertAll("Pay app form validation",
                () -> assertTrue(payForm.isPaidAppShow()),
                () -> assertTrue(payForm.isSubmitBtnContainText("10")),
                () -> assertTrue(payForm.isDescriptionCoastContainText("10")),
                () -> assertTrue(payForm.isDescriptionTextContainText("297777777")),
                () -> assertTrue(payForm.isCardNumberContainPlaceholder("Номер карты")),
                () -> assertTrue(payForm.isCardExpirationDateContainPlaceholder("Срок действия")),
                () -> assertTrue(payForm.isCardCVCContainPlaceholder("CVC")),
                () -> assertTrue(payForm.isCardOwnerContainPlaceholder("Имя держателя (как на карте)")),
                () -> assertTrue(payForm.isPaymentsCardDisplayed()),
                () -> assertTrue(payForm.isYandexPayBtnExist()),
                () -> assertTrue(payForm.isGooglePayBtnExist())
        );
    }
}
