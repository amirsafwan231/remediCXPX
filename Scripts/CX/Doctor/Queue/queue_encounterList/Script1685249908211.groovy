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

String queue = doctorQueue

if (queue == 'MyAssignedPhysical') {
    WebUI.waitForElementPresent(findTestObject('Queue Management/Doctor/queueAccessEncounterBtn'), 0)

    WebUI.verifyElementPresent(findTestObject('Queue Management/Doctor/myAssignPatientNameTxt', [('PATNAME') : findTestData(
                    'TestData').getValue(7, 1)]), 0)

    WebUI.verifyElementPresent(findTestObject('Object Repository/Queue Management/Doctor/myAssignPatientIDNoTxt', [('IC') : findTestData('TestData').getValue(
                6, 1), ('IDType') : findTestData('TestData').getValue(12, 1), ('Gender') : findTestData('TestData').getValue(
                13, 1)]), 0)

    WebUI.click(findTestObject('Queue Management/Doctor/queueAccessEncounterBtn'))
}

