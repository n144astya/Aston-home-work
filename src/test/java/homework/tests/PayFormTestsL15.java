package homework.tests;

import homework.pageObjects.MtsHomePagePayForm;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PayFormTestsL15 extends BaseTest {

    public MtsHomePagePayForm payForm;

    @BeforeEach
    public void before() {
        super.before();
        payForm = new MtsHomePagePayForm(driver);
        payForm.discardCookie();
    }

    @Test
    public void testCheckCommunicationServicesPlaceholders() {
        payForm.scrollToPaymentForm();
        assertAll("Communication services placeholders check",
                () -> assertTrue(payForm.isPhoneInputContainPlaceholderText("Номер телефона")),
                () -> assertTrue(payForm.isSumInputContainPlaceholderText("Сумма")),
                () -> assertTrue(payForm.isEmailInputContainPlaceholderText("E-mail для отправки чека"))
        );
    }

    @Test
    public void testCheckHomeInternetPlaceholders() {
        payForm.scrollToPaymentForm();
        payForm.selectService(1);
        assertAll("Home internet placeholders check",
                () -> assertTrue(payForm.isInternetNumberInputContainPlaceholderText("Номер абонента")),
                () -> assertTrue(payForm.isInternetSumInputContainPlaceholderText("Сумма")),
                () -> assertTrue(payForm.isInternetEmailInputContainPlaceholderText("E-mail для отправки чека"))
        );
    }

    @Test
    public void testCheckInstalmentPlaceholders() {
        payForm.scrollToPaymentForm();
        payForm.selectService(2);
        assertAll("Instalment placeholders check",
                () -> assertTrue(payForm.isInstalmentAccountNumberInputContainPlaceholderText("Номер счета на 44")),
                () -> assertTrue(payForm.isInstalmentSumInputContainPlaceholderText("Сумма")),
                () -> assertTrue(payForm.isInstalmentEmailInputContainPlaceholderText("E-mail для отправки чека"))
        );
    }

    @Test
    public void testCheckArrearsPlaceholders() {
        payForm.scrollToPaymentForm();
        payForm.selectService(3);
        assertAll("Arrears placeholders check",
                () -> assertTrue(payForm.isArrearsAccountNumberInputContainPlaceholderText("Номер счета на 2073")),
                () -> assertTrue(payForm.isArrearsSumInputContainPlaceholderText("Сумма")),
                () -> assertTrue(payForm.isArrearsEmailInputContainPlaceholderText("E-mail для отправки чека"))
        );
    }

    @Test
    public void testCheckPayments() {
        payForm.scrollToPaymentForm();
        payForm.completeForm("297777777", "10", "email@email.com");

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
