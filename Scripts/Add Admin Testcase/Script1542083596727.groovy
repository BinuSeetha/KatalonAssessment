import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory as CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as MobileBuiltInKeywords
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testcase.TestCaseFactory as TestCaseFactory
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WSBuiltInKeywords
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
//Assignment
WebUI.openBrowser('')

WebUI.navigateToUrl('https://www.phptravels.net/admin')

WebUI.setText(findTestObject('AddAdmin/Page_Administator Login/input_email'), 'admin@phptravels.com')

WebUI.setText(findTestObject('AddAdmin/Page_Administator Login/input_password'), 'demoadmin')

WebUI.click(findTestObject('AddAdmin/Page_Administator Login/button_Login'))

WebUI.click(findTestObject('AddAdmin/Page_Dashboard/a_Accounts'))

WebUI.click(findTestObject('AddAdmin/Page_Dashboard/a_Admins'))

WebUI.click(findTestObject('AddAdmin/Page_Admins Management/button_Add'))

def dbdata = findTestData('DataFile For AdminCreation/AddAdminData')

int i = 1

WebUI.setText(findTestObject('Common/fieldData', [('dynamicvariable') : 'fname']), dbdata.getValue(i++, 1))

WebUI.setText(findTestObject('Common/fielddata', [('dynamicvariable') : 'lname']), dbdata.getValue(i++, 1))

WebUI.setText(findTestObject('Common/fielddata', [('dynamicvariable') : 'email']), dbdata.getValue(i++, 1))

WebUI.setText(findTestObject('Common/fielddata', [('dynamicvariable') : 'password']), dbdata.getValue(i++, 1))

WebUI.setText(findTestObject('Common/fielddata', [('dynamicvariable') : 'mobile']), dbdata.getValue(i++, 1))

WebUI.click(findTestObject('AddAdmin/SelectDropDown'))

WebUI.delay(1)

WebUI.click(findTestObject('AddAdmin/Country', [('Country') : dbdata.getValue(i++, 1)]))

WebUI.delay(5)

WebUI.setText(findTestObject('Common/fielddata', [('dynamicvariable') : 'address1']), dbdata.getValue(i++, 1))

WebUI.setText(findTestObject('Common/fielddata', [('dynamicvariable') : 'address2']), dbdata.getValue(i++, 1))

def dbdataForPermission = findTestData('DataforCheckbox/permission')

for (def index : (1..dbdataForPermission.getRowNumbers())) {
    for (def indexc : (1..dbdataForPermission.getColumnNumbers())) {
        WebUI.scrollToElement(findTestObject('AddAdmin/checkbox', [('value') : dbdataForPermission.getValue(indexc, index)]), 
            10)

        WebUI.click(findTestObject('AddAdmin/checkbox', [('value') : dbdataForPermission.getValue(indexc, index)]))
    }
}

WebUI.click(findTestObject('Submit'))

WebUI.verifyElementPresent(findTestObject('AddAdmin/verifyelementpresent'), 5)

WebUI.closeBrowser()




