import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.chrome.ChromeDriver as ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions as ChromeOptions
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.Dimension as Dimension
import org.openqa.selenium.Point as Point

browser = Browser

if (browser == 'normal') {
    WebUI.openBrowser(findTestData('TestData').getValue(1, 1))

    WebUI.maximizeWindow()

    WebUI.delay(5)

    url = WebUI.getUrl()

    WebUI.verifyMatch(url, findTestData('TestData').getValue(1, 1), false) //	ChromeOptions options = new ChromeOptions()
    //	options.addArguments("--incognito")
    //	return openChromeBrowser(options);
    //WebUI.openBrowser(findTestData('TestData').getValue(1, 1))
} else if (browser == 'private') {
    WebDriver incognitoChrome = openChromeBrowserInIncognitoMode()

    resizeHorizontalHalfLocateRight(incognitoChrome)

    DriverFactory.changeWebDriver(incognitoChrome)

    WebUI.navigateToUrl(findTestData('TestData').getValue(1, 1))

    WebUI.maximizeWindow()

    WebUI.delay(5)

    url = WebUI.getUrl()

    WebUI.verifyMatch(url, findTestData('TestData').getValue(1, 1), false)

}

ChromeDriver openChromeBrowser(ChromeOptions options) {
    System.setProperty('webdriver.chrome.driver', DriverFactory.getChromeDriverPath())

    return new ChromeDriver(options)
}

Dimension resizeHorizontalHalfLocateLeft(WebDriver driver) {
    Dimension d = resizeToHorizontalHalf(driver)

    driver.manage().window().setPosition(new Point(0, 0))

    return d
}

Dimension resizeHorizontalHalfLocateRight(WebDriver driver) {
    Dimension d = resizeToHorizontalHalf(driver)

    driver.manage().window().setPosition(new Point(d.getWidth(), 0))

    return d
}

Dimension resizeToHorizontalHalf(WebDriver driver) {
    driver.manage().window().maximize()

    Dimension maxDim = driver.manage().window().getSize()

    Dimension curDim = new Dimension(((maxDim.getWidth() / 2) as Integer), maxDim.getHeight())

    driver.manage().window().setSize(curDim)

    return curDim
}

ChromeDriver openChromeBrowserInIncognitoMode() {
    ChromeOptions options = new ChromeOptions()

    options.addArguments('--incognito')

    return openChromeBrowser(options)
}

