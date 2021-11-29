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

WebUI.openBrowser(GlobalVariable.cxURL)

WebUI.maximizeWindow()

//WebUI.waitForElementPresent(findTestObject('Login/signInBtn'), 0)
//
//WebUI.setText(findTestObject('Login/usernameField'), 'KlinikAmirStaff')
//
//WebUI.setText(findTestObject('Login/passwordField'), 'Secret@1')
//
//WebUI.click(findTestObject('Login/signInBtn'))

//int counter
//for (counter = 1; counter <= 10; counter++) {
//    WebUI.waitForElementPresent(findTestObject('Queue Management/queueManagementPage'), 0)
//
//    WebUI.click(findTestObject('Queue Management/addNewPatientBtn'))
//
//    WebUI.setText(findTestObject('Check In/patientIDField'), findTestData('Patient Data').getValue(1, counter))
//
//    WebUI.click(findTestObject('Check In/searchPatientBtn'))
//
//    WebUI.verifyElementText(findTestObject('Check In/detailsIDNumberInfo', [('IC') : findTestData('Patient Data').getValue(
//                    1, counter)]), findTestData('Patient Data').getValue(1, counter))
//
//    WebUI.click(findTestObject('Check In/checkInBtn'))
//
//    WebUI.delay(5)
//}
//for (int counterNext = 1; counterNext <= 10; counterNext++) {
//    println(counterNext)
//
//    WebUI.click(findTestObject('Queue Management/assignPatientBtn', [('index') : counterNext]))
//
//    WebUI.waitForElementPresent(findTestObject('Queue Management/assignPatientDoctorTxt'), 0)
//
//    WebUI.verifyElementAttributeValue(findTestObject('Queue Management/assignPatientICInfo', [('IC') : findTestData('Patient Data').getValue(
//                    1, counterNext)]), 'value', findTestData('Patient Data').getValue(1, counterNext), 0)
//
//    WebUI.click(findTestObject('Queue Management/assignPatientAssignBtn'))
//
//    //    println(counterNext)
//    WebUI.delay(5)
//}

//WebUI.click(findTestObject('Main/logoutBtn'))

WebUI.waitForElementPresent(findTestObject('Login/signInBtn'), 0)

WebUI.setText(findTestObject('Login/usernameField'), 'DoktorKlinikAmir')

WebUI.setText(findTestObject('Login/passwordField'), 'qwerty@12345')

WebUI.click(findTestObject('Login/signInBtn'))

WebUI.closeBrowser()