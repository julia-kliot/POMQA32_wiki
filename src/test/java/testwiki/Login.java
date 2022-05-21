package testwiki;

import configwiki.ConfigurationWiki;
import model.Auth;
import org.testng.Assert;
import org.testng.annotations.Test;
import screens.MainScreen;

public class Login extends ConfigurationWiki {

    @Test
    public void login1(){
        logger.info("Start login 1");
        boolean isLogged = new MainScreen(driver)
                .clickOnFlowButton()
                .clickOnLoginWikiButton()
                .fillInLoginForm(Auth.builder().username("juliakliot.jk").password("Misha240613").build())
                .clickOnFlowButton()
                .isLogged();

        Assert.assertTrue(isLogged);
    }
}
