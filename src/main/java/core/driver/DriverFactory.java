

package core.driver;

import core.config.Configuration;
import core.driver.local.LocalDriverManager;
import core.driver.remote.RemoteDriverManager;
import lombok.extern.log4j.Log4j2;
import org.aeonbits.owner.ConfigCache;
import org.openqa.selenium.WebDriver;

@Log4j2
public class DriverFactory {


    public static WebDriver createInstance(String browser) {
        DriverManager.setBrowserName(browser);
        Configuration configuration = ConfigCache.getOrCreate(Configuration.class);
        Target target = Target.valueOf(configuration.target().toUpperCase());
        WebDriver webdriver;

        switch (target) {

            case LOCAL:
                webdriver = new LocalDriverManager().createInstance(browser);
                break;
            case GRID:
                webdriver = new RemoteDriverManager().createInstance(browser);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + target);
        }
        return webdriver;
    }

    enum Target {
        LOCAL, GRID
    }
}
