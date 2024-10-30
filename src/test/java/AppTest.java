import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class AppTest {

    static AppiumDriver driver;

    public static void main(String[] args) throws MalformedURLException {
        openMobileApp();
    }

    public static void openMobileApp() throws MalformedURLException {
        DesiredCapabilities cap = new DesiredCapabilities();

        cap.setCapability("appium:deviceName","JJP");
        cap.setCapability("appium:udid","3084529408000P6");
        cap.setCapability("platformName","Android");
        cap.setCapability("appium:platformVersion","14");
        cap.setCapability("appium:automationName","uiAutomator2");
        //cap.setCapability("appium:appPackage","com.ubercab");
        //cap.setCapability("appium:appActivity","com.ubercab.presidio.app.core.root.RootActivity");
        cap.setCapability("appium:appPackage","com.reddit.frontpage");
        cap.setCapability("appium:appActivity","com.reddit.launch.main.MainActivity");

        URL url = new URL("http://127.0.0.1:4723/");
        driver = new AppiumDriver(url,cap);

        /* // --Uber--
        driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiSelector().resourceId(\"com.android.permissioncontroller:id/permission_deny_button\")")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiSelector().resourceId(\"com.ubercab:id/welcome_screen_continue\")")).click();
        driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiSelector().resourceId(\"com.google.android.gms:id/cancel\")")).click();
        driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiSelector().resourceId(\"PHONE_NUMBER\")")).isDisplayed();
        driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiSelector().resourceId(\"forward-button\")")).isDisplayed();
        driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiSelector().resourceId(\"google-login-btn\")")).isDisplayed();
         */

        // --Reddit--

        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(new AppiumBy.ByAccessibilityId("Search")).click();
        driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiSelector().resourceId(\"com.reddit.frontpage:id/search\")")).sendKeys("Australia");
        driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiSelector().resourceId(\"com.reddit.frontpage:id/toolbar_search_icon\")")).click();
        driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiSelector().resourceId(\"search_typeahead_item\").instance(0)")).isDisplayed();


        System.out.println("Application has Started!");
    }

}
