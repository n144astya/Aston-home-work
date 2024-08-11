package homework.tests;

import homework.pageObjects.MtsHomePagePayForm;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PayFormTestsL15 extends BaseTest {

    public static MtsHomePagePayForm payForm;

    @Before
    public void before() {
        super.before();
        payForm = new MtsHomePagePayForm(driver);
    }
    @Test
    public void testCheckPayFormPlaceholders() {
        payForm.discardCookie();
        payForm.scrollToPaymentForm();
        Assert.assertTrue(payForm.isPhoneInputContainPlaceholderText("Номер телефона"));
        Assert.assertTrue(payForm.isSumInputContainPlaceholderText("Сумма"));
        Assert.assertTrue(payForm.isEmailInputContainPlaceholderText("E-mail для отправки чека"));
        payForm.selectService(1);
        Assert.assertTrue(payForm.isInternetNumberInputContainPlaceholderText("Номер абонента"));
        Assert.assertTrue(payForm.isInternetSumInputContainPlaceholderText("Сумма"));
        Assert.assertTrue(payForm.isInternetEmailInputContainPlaceholderText("E-mail для отправки чека"));
        payForm.selectService(2);
        Assert.assertTrue(payForm.isInstalmentAccountNumberInputContainPlaceholderText("Номер счета на 44"));
        Assert.assertTrue(payForm.isInstalmentSumInputContainPlaceholderText("Сумма"));
        Assert.assertTrue(payForm.isInstalmentEmailInputContainPlaceholderText("E-mail для отправки чека"));
        payForm.selectService(3);
        Assert.assertTrue(payForm.isArrearsAccountNumberInputContainPlaceholderText("Номер счета на 2073"));
        Assert.assertTrue(payForm.isArrearsSumInputContainPlaceholderText("Сумма"));
        Assert.assertTrue(payForm.isArrearsEmailInputContainPlaceholderText("E-mail для отправки чека"));
    }

    @Test
    public void testCheckPayments() {
        payForm.discardCookie();
        payForm.scrollToPaymentForm();
        payForm.completeForm("297777777", "10", "email@email.com");
        Assert.assertTrue(payForm.isPaidAppShow());
        Assert.assertTrue(payForm.isPaidAppFormValid("10",
                "297777777",
                "Номер карты",
                "Срок действия",
                "CVC",
                "Имя держателя (как на карте)"));
    }
}
