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

for (int counters = 1; counters <= 1; counters++) {
    
	WebUI.openBrowser(findTestData('Clinic URL').getValue(1, counters))

    WebUI.maximizeWindow()

    WebUI.delay(5)

    url = WebUI.getUrl()

    WebUI.verifyMatch(url, findTestData('Clinic URL').getValue(1, counters), false)

    WebUI.waitForElementPresent(findTestObject('Login/signInBtn'), 0)

    WebUI.setText(findTestObject('Login/usernameField'), 'KlinikAmirStaff')

    WebUI.setText(findTestObject('Login/passwordField'), 'Secret@1')

    WebUI.click(findTestObject('Login/signInBtn'))

    int counter

    for (counter = 1; counter <= 1; counter++) {
        WebUI.waitForElementPresent(findTestObject('Queue Management/queueManagementPage'), 0)

        WebUI.click(findTestObject('Queue Management/addNewPatientBtn'))

        WebUI.setText(findTestObject('Patient Search/patientIDField'), findTestData('Patient Data').getValue(1, counter))

        WebUI.click(findTestObject('Main/searchPatientBtn'))

        WebUI.verifyElementText(findTestObject('Patient Search/patientDetailsIDNumber', [('IC') : findTestData('Patient Data').getValue(
                        1, counter)]), findTestData('Patient Data').getValue(1, counter))

        WebUI.click(findTestObject('Patient Search/checkInBtn'))

        WebUI.delay(5)
    }
    
    for (int counterNext = 1; counterNext <= 1; counterNext++) {
        println(counterNext)

        WebUI.click(findTestObject('Queue Management/assignPatientBtn', [('index') : counterNext]))

        WebUI.waitForElementPresent(findTestObject('Queue Management/assignPatientDoctorTxt'), 0)

        WebUI.verifyElementAttributeValue(findTestObject('Queue Management/assignPatientICInfo', [('IC') : findTestData(
                        'Patient Data').getValue(1, counterNext)]), 'value', findTestData('Patient Data').getValue(1, counterNext), 
            0)

        WebUI.click(findTestObject('Queue Management/Staff/assignDoctorDropdownSelect'))

        WebUI.waitForElementPresent(findTestObject('Queue Management/Staff/assignDoctorDropdownOption'), 0)

        WebUI.click(findTestObject('Queue Management/Staff/assignDoctorDropdownOption'))

        WebUI.click(findTestObject('Queue Management/assignPatientAssignBtn'))

        //    println(counterNext)
        WebUI.delay(5)
    }
    
    WebUI.click(findTestObject('Main/logoutBtn'))

    WebUI.waitForElementPresent(findTestObject('Login/signInBtn'), 0)

    WebUI.setText(findTestObject('Login/usernameField'), 'DoktorKlinikAmir')

    WebUI.setText(findTestObject('Login/passwordField'), 'qwerty@12345')

    WebUI.click(findTestObject('Login/signInBtn'))

    WebUI.waitForElementPresent(findTestObject('Queue Management/queuePatientQueue'), 0)

    WebUI.verifyElementText(findTestObject('Queue Management/queueAssignPhysicalMetrics'), '1')

    WebUI.click(findTestObject('Queue Management/Doctor/queueAccessEncounterBtn'))

    WebUI.waitForElementPresent(findTestObject('Encounter/patientNewEncounterICNumber'), 0)

    WebUI.verifyTextPresent(findTestData('Patient Data').getValue(1, 1), false)

    WebUI.click(findTestObject('Encounter/patientNewEncounterEncounterTab'))

    WebUI.waitForElementPresent(findTestObject('Encounter/patientNewEncounterEncounterSymptomTxt'), 0)

    WebUI.setText(findTestObject('Encounter/patientNewEncounterEncounterSymptomInputField'), 'Test')

    WebUI.delay(3)

    WebUI.setText(findTestObject('Encounter/patientNewEncounterEncounterExamInputField'), 'Test')

    WebUI.delay(3)

    WebUI.setText(findTestObject('Encounter/patientNewEncounterEncounterDiagnosisInputField'), 'Fever')

    WebUI.delay(3)

    WebUI.click(findTestObject('Encounter/patientNewEncounterEncounterDiagnosisSelect'))

    WebUI.delay(3)

    WebUI.click(findTestObject('Encounter/patientNewEncounterManagementTab'))

    if (WebUI.verifyTextPresent('Dispense Method', false, FailureHandling.OPTIONAL) == false) {
        WebUI.waitForElementPresent(findTestObject('Encounter/patientNewEncounterMedicationSelect'), 0)

        WebUI.click(findTestObject('Encounter/patientNewEncounterMedicationSelect'))
    }
    
    //WebUI.waitForElementPresent(findTestObject('Encounter/patientNewEncounterMedicationSelect'), 0)
    //WebUI.click(findTestObject('Encounter/patientNewEncounterMedicationSelect'))
    WebUI.waitForElementPresent(findTestObject('Encounter/patientNewEncounterMedicationDescriptionInput'), 0)

    WebUI.setText(findTestObject('Encounter/patientNewEncounterMedicationDescriptionInput'), 'Cetir')

    WebUI.click(findTestObject('Encounter/patientNewEncounterMedicationDescriptionSelect'))

    WebUI.delay(3)

    WebUI.setText(findTestObject('Encounter/patientNewEncounterPlanDescriptionInputField'), 'Submit')

    WebUI.click(findTestObject('Encounter/patientNewEncounterSubmitBtn'))

    WebUI.delay(3)

    WebUI.click(findTestObject('Encounter/patientNewEncounterConfirmSubmitBtn'))

    WebUI.waitForElementPresent(findTestObject('Queue Management/Doctor/queueAssignPatientCounter'), 0)

    WebUI.verifyElementText(findTestObject('Queue Management/Doctor/queueAssignPatientCounter'), '0')

    WebUI.click(findTestObject('Main/logoutBtn'))

    WebUI.waitForElementPresent(findTestObject('Login/signInBtn'), 0)

    WebUI.setText(findTestObject('Login/usernameField'), 'KlinikAmirStaff')

    WebUI.setText(findTestObject('Login/passwordField'), 'Secret@1')

    WebUI.click(findTestObject('Login/signInBtn'))

    WebUI.waitForElementPresent(findTestObject('Queue Management/Staff/queuePatientPharmacyCounter'), 0)

    WebUI.verifyElementText(findTestObject('Queue Management/Staff/queuePatientPharmacyCounter'), '1')

    WebUI.click(findTestObject('Queue Management/Staff/queuePatientPharmacyCounter'))

    WebUI.waitForElementPresent(findTestObject('Queue Management/Staff/queuePatientPharmacyDispenseBtn'), 0)

    WebUI.click(findTestObject('Queue Management/Staff/queuePatientPharmacyDispenseBtn'))

    WebUI.waitForElementPresent(findTestObject('Pharmacy/dispenseSummaryPatientICTxt'), 0)

    //WebUI.verifyElementText(findTestObject('Pharmacy/dispenseSummaryPatientICTxt'), '930922087711')
    WebUI.verifyTextPresent('930922087711', false)

    WebUI.click(findTestObject('Pharmacy/dispenseSummarySubmitBtn'))

    WebUI.waitForElementPresent(findTestObject('Main/dispenseConfirmationProceedYesBtn'), 0)

    WebUI.click(findTestObject('Main/dispenseConfirmationProceedYesBtn'))

    WebUI.waitForElementPresent(findTestObject('Pharmacy/dispenseConfirmationDispenseStatus'), 0)

    WebUI.click(findTestObject('Pharmacy/dispenseConfirmationDispenseBtn'))

    WebUI.waitForElementPresent(findTestObject('Main/dispenseConfirmationProceedYesBtn'), 0)

    WebUI.click(findTestObject('Main/dispenseConfirmationProceedYesBtn'))

    WebUI.waitForElementPresent(findTestObject('Invoice/invoicePatientICTxt'), 0)

    //WebUI.verifyElementText(findTestObject('Invoice/invoicePatientICTxt'), '930922087711')
    WebUI.verifyTextPresent('930922087711', false)

    WebUI.click(findTestObject('Invoice/invoiceConsultationDropdownSelect'))

    WebUI.click(findTestObject('Invoice/invoiceConsultationDropdownOption'))

    WebUI.delay(3)

    WebUI.click(findTestObject('Invoice/invoiceGenerateInvoiceBtn'))

    WebUI.waitForElementPresent(findTestObject('Main/dispenseConfirmationProceedYesBtn'), 0)

    WebUI.click(findTestObject('Main/dispenseConfirmationProceedYesBtn'))

    WebUI.waitForElementPresent(findTestObject('Payment/paymentSummaryPatientICTxt'), 0)

    WebUI.setText(findTestObject('Payment/paymentCashInputField'), '33')

    WebUI.click(findTestObject('Payment/paymentConfirmBtn'))

    WebUI.waitForElementPresent(findTestObject('Main/dispenseConfirmationProceedYesBtn'), 0)

    WebUI.click(findTestObject('Main/dispenseConfirmationProceedYesBtn'))
	
}	