package homework.tests;

import homework.pageObjects.MtsHomePagePayForm;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class PayFormTestsL14 extends BaseTest {

    public static MtsHomePagePayForm payForm;

    @Before
    public void before() {
        super.before();
        payForm = new MtsHomePagePayForm(driver);
    }

    @Test
    public void testCheckBlockTitle() {
        payForm.discardCookie();
        payForm.scrollToPaymentForm();
        Assert.assertEquals( "Онлайн пополнение\nбез комиссии", payForm.getPaymentFormTitle());
    }

    @Test
    public void testPaymentsLogo() {
        payForm.discardCookie();
        payForm.scrollToPaymentForm();

        Assert.assertEquals(5, payForm.getPayPartnersCount());
        Assert.assertEquals("Visa", payForm.getPayPartnersImgAlt(0));
        Assert.assertEquals("Verified By Visa", payForm.getPayPartnersImgAlt(1));
        Assert.assertEquals("MasterCard", payForm.getPayPartnersImgAlt(2));
        Assert.assertEquals("MasterCard Secure Code", payForm.getPayPartnersImgAlt(3));
        Assert.assertEquals("Белкарт", payForm.getPayPartnersImgAlt(4));
    }

    @Test
    public void testCheckAboutLink() {
        payForm.discardCookie();
        payForm.scrollToPaymentForm();
        payForm.clickAboutLinc();
        Assert.assertEquals("https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/", driver.getCurrentUrl());
    }

    @Test
    public void testCheckPayments() {
        payForm.discardCookie();
        payForm.scrollToPaymentForm();
        payForm.completeForm("297777777", "10", "email@email.com");
        Assert.assertTrue(payForm.isPaidAppShow());
        Assert.assertTrue(payForm.isPaidAppFormContain("10", "297777777"));
    }
}
