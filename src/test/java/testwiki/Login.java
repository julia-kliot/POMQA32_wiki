package testwiki;

import configwiki.ConfigurationWiki;
import configwiki.DataProviserWiki;
import model.Auth;
import org.testng.Assert;
import org.testng.annotations.Test;
import screens.MainScreen;

public class Login extends ConfigurationWiki {

    @Test
    public void login1() {
        logger.info("Start login 1");
        boolean isLogged = new MainScreen(driver)
                .clickOnFlowButton()
                .clickOnLoginWikiButton()
                .fillInLoginForm(Auth.builder().username("juliakliot.jk").password("Misha240613").build())
                .clickOnFlowButton()
                .isLogged();

        Assert.assertTrue(isLogged);
    }

    @Test(dataProvider = "loginData", dataProviderClass = DataProviserWiki.class)
    public void login2(Auth user) {
        logger.info("Start login 2");
        new MainScreen(driver)
                .clickOnFlowButton()
                .clickOnLoginWikiButton()
                .fillInLoginForm(user)
                .clickOnFlowButton()
                .logOut();
    }

    @Test(dataProvider = "logDataCsv", dataProviderClass = DataProviserWiki.class)
    public void login3(Auth user) {
        logger.info("Start login 3");
        new MainScreen(driver)
                .clickOnFlowButton()
                .clickOnLoginWikiButton()
                .fillInLoginForm(user)
                .clickOnFlowButton()
                .logOut();
    }

    @Test
    public void loginData4() {
        String inf = new MainScreen(driver)
                .clickOnFlowButton()
                .clickOnLoginWikiButton()
                .fillInLoginForm(Auth.builder().username("juliakliot.jk").password("Misha240613").build())
                .clickOnFlowButton()
                .logOut()
                .clickOnFlowButton()
                .getInf();
        Assert.assertEquals(inf, "Log in to Wikipedia");
    }

    @Test
    public void loginData5(String login, String pwd) {
        String inf = new MainScreen(driver)
                .clickOnFlowButton()
                .clickOnLoginWikiButton()
                .fillInLoginForm2("juliakliot.jk", "misha240613")
                .clickOnFlowButton()
                //isAccountPresentAssert()
                .logOut()
                //.isElOnMainPagePresAssert()
                .clickOnFlowButton()
                .getInf();
        Assert.assertEquals(inf, "Log in to Wikipedia");

    }
}