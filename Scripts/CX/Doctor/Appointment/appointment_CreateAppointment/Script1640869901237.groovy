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
import java.time.*
import java.time.DayOfWeek as DayOfWeek

WebUI.openBrowser(findTestData('Clinic URL').getValue(1, 1))

WebUI.maximizeWindow()

WebUI.delay(5)

url = WebUI.getUrl()

WebUI.verifyMatch(url, findTestData('Clinic URL').getValue(1, 1), false)

WebUI.waitForElementPresent(findTestObject('Login/signInBtn'), 0)

WebUI.setText(findTestObject('Login/usernameField'), 'DoktorKlinikAmir')

WebUI.setText(findTestObject('Login/passwordField'), 'Secret@1')

WebUI.click(findTestObject('Login/signInBtn'))

WebUI.waitForElementPresent(findTestObject('Queue Management/queuePatientQueue'), 0)

WebUI.click(findTestObject('Appointment/sideMenu'))

WebUI.waitForElementPresent(findTestObject('Appointment/plusIconBtn'), 0)

WebUI.click(findTestObject('Appointment/plusIconBtn'))

WebUI.waitForElementPresent(findTestObject('Appointment/searchPatientInputField'), 0)

WebUI.setText(findTestObject('Appointment/searchPatientInputField'), findTestData('Patient Data').getValue(1, 2))

WebUI.click(findTestObject('Main/searchPatientBtn'))

WebUI.waitForElementPresent(findTestObject('Appointment/detailsPatientName', [('PatientName') : findTestData('Patient Data').getValue(
                4, 2)]), 0)

WebUI.click(findTestObject('Appointment/appointmentTimeSelect'))

WebUI.clearText(findTestObject('Appointment/appointmentTimeSelect'))

WebUI.delay(5)

WebUI.sendKeys(findTestObject('Appointment/appointmentTimeSelect'), Keys.chord(Keys.COMMAND, 'a'))

WebUI.sendKeys(findTestObject('Appointment/appointmentTimeSelect'), Keys.chord(Keys.DELETE))

WebUI.sendKeys(findTestObject('Appointment/appointmentTimeSelect'), Keys.chord('1:00PM'))

WebUI.setText(findTestObject('Appointment/appointmentRemarksInputField'), '2022-01-02 @ 1PM')

WebUI.click(findTestObject('Appointment/appointmentSMS30MinsReminder'))

WebUI.click(findTestObject('Appointment/submitAppointmentBtn'))

WebUI.waitForElementPresent(findTestObject('Appointment/setAppointmentOnCalendarSelect', [('Phone') : findTestData('Patient Data').getValue(
                2, 2)]), 0)

WebUI.click(findTestObject('Appointment/setAppointmentOnCalendarSelect', [('Phone') : findTestData('Patient Data').getValue(
                2, 2)]))

WebUI.verifyElementText(findTestObject('Appointment/appointmentDetailPatientPhoneNo', [('Phone') : findTestData('Patient Data').getValue(
                2, 2)]), findTestData('Patient Data').getValue(2, 2))

WebUI.verifyElementText(findTestObject('Appointment/appointmentDetailPatientNameTxt', [('PatientName') : findTestData('Patient Data').getValue(
                3, 2)]), findTestData('Patient Data').getValue(3, 2))

//WebUI.verifyElementText(findTestObject('Appointment/appointmentDetailsDateTimeTxt'), 'Sunday, 02/01/2022 1:00 PM')
dateTime = WebUI.getText(findTestObject)

WebUI.verifyMatch(dateTime, null, false)

WebUI.closeBrowser()

