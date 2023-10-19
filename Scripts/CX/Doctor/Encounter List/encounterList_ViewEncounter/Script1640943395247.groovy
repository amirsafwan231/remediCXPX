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

WebUI.openBrowser(findTestData('Clinic URL').getValue(1, 1))

WebUI.maximizeWindow()

WebUI.delay(5)

url = WebUI.getUrl()

WebUI.verifyMatch(url, findTestData('Clinic URL').getValue(1, 1), false)

WebUI.waitForElementPresent(findTestObject('Login/signInBtn'), 0)

WebUI.setText(findTestObject('Login/usernameField'), 'DoktorKlinikAmir')

WebUI.setText(findTestObject('Login/passwordField'), 'qwerty@12345')

WebUI.click(findTestObject('Login/signInBtn'))

WebUI.waitForElementPresent(findTestObject('Queue Management/queuePatientQueue'), 0)

