package testwiki;

import configwiki.ConfigurationWiki;
import org.testng.Assert;
import org.testng.annotations.Test;
import screens.MainScreen;

public class LaunchWiki extends ConfigurationWiki {

    @Test
    public void lauchWiki(){
        logger.info("Start main page");
        String detail = new MainScreen(driver).getDetail();
        Assert.assertEquals(detail, "In the news");
    }

    }

