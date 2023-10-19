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

WebUI.waitForElementPresent(findTestObject('Object Repository/Check In/checkInTitleTxt'), 0)

WebUI.verifyElementText(findTestObject('Object Repository/Check In/checkInTitleTxt'), 'CHECK IN')

WebUI.verifyElementText(findTestObject('Check In/icNameTxt', [('NAME') : findTestData('TestData').getValue(7, 1), ('IC') : findTestData(
                'TestData').getValue(6, 1)]), ((findTestData('TestData').getValue(7, 1) + ' ' +'(') + findTestData('TestData').getValue(
        6, 1)) + ')')

//WebUI.verifyElementText(findTestObject('Object Repository/Check In/visitTypeDropdownSeeDoctor'), findTestData('TestData').getValue(
//        14, 1))

WebUI.click(findTestObject('Object Repository/Check In/doctorSelectionDropdown'))

WebUI.setText(findTestObject('Object Repository/Check In/doctorSelectionSearchBox'), findTestData('TestData').getValue(15, 
        1))

WebUI.click(findTestObject('Check In/assignDoctorSelectedDoctorName', [('DRNAME') : findTestData('TestData').getValue(15, 
                1)]))

WebUI.verifyElementText(findTestObject('Check In/doctorRoomAssignedRoom', [('ROOM') : findTestData('TestData').getValue(
                16, 1)]), findTestData('TestData').getValue(16, 1))

WebUI.setText(findTestObject('Object Repository/Check In/refNoInputField'), findTestData('TestData').getValue(18, 1))

WebUI.click(findTestObject('Object Repository/Check In/checkInBtn'))

WebUI.waitForElementPresent(findTestObject('Object Repository/Check In/checkInConfirmationTxt'), 0)

WebUI.verifyElementText(findTestObject('Object Repository/Check In/checkInConfirmationTxt'), 'WAITING DOCTOR')

