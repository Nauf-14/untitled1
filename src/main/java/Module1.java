import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
public class Module1 {


        private AndroidDriver driver;

        @Before
        public void setUp() throws MalformedURLException {
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setCapability("platformName", "Android");
            desiredCapabilities.setCapability("ensureWebviewsHavePages", true);

            URL remoteUrl = new URL("http://localhost:4723/wd/hub");

            driver = new AndroidDriver(remoteUrl, desiredCapabilities);
        }

        @Test
        public void sampleTest() {
            MobileElement el1 = (MobileElement) driver.findElementByAccessibilityId("Contacts");
            el1.click();
            MobileElement emptyListViewMessage = (MobileElement) driver.findElementById("com.google.android.dialer:id/emptyListViewMessage");
            emptyListViewMessage.isDisplayed();
        }

        @After
        public void tearDown() {
            driver.quit();
        }

}
