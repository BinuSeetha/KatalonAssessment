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

WebUI.callTestCase(findTestCase('Add Admin Testcase'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.openBrowser('')

WebUI.navigateToUrl('https://www.phptravels.net/admin')

WebUI.setText(findTestObject('TourCreation/Page_Administator Login/input_email'), 'binu.inapp@hmail.com')

WebUI.setText(findTestObject('TourCreation/Page_Administator Login/input_password'), 'binukuthalingam')

WebUI.click(findTestObject('TourCreation/Page_Administator Login/button_Login'))

WebUI.click(findTestObject('TourCreation/Page_Dashboard/a_Tours'))

WebUI.click(findTestObject('TourCreation/Page_Dashboard/a_Tours_1'))

WebUI.click(findTestObject('TourCreation/Page_Tours Management/button_Add'))

def internalData = findTestData('DataFile For TourCreation/AddTourData')

int i = 1

WebUI.setText(findTestObject('Common/fieldData', [('dynamicvariable') : 'tourname']), internalData.getValue(i++, 1))

WebUI.setText(findTestObject('Common/fielddata', [('dynamicvariable') : 'maxadult']), internalData.getValue(i++, 1))

WebUI.setText(findTestObject('Common/fielddata', [('dynamicvariable') : 'adultprice']), internalData.getValue(i++, 1))

WebUI.click(findTestObject('TourCreation/childbutton'))

WebUI.setText(findTestObject('Common/fielddata', [('dynamicvariable') : 'maxchild']), internalData.getValue(i++, 1))

WebUI.setText(findTestObject('Common/fielddata', [('dynamicvariable') : 'childprice']), internalData.getValue(i++, 1))

WebUI.click(findTestObject('TourCreation/InfantButton'))

WebUI.setText(findTestObject('Common/fielddata', [('dynamicvariable') : 'maxinfant']), internalData.getValue(i++, 1))

WebUI.setText(findTestObject('Common/fielddata', [('dynamicvariable') : 'infantprice']), internalData.getValue(i++, 1))

WebUI.click(findTestObject('TourCreation/StarDropdown'))

WebUI.click(findTestObject('TourCreation/StarSelection', [('value') : internalData.getValue(i++, 1)]))

WebUI.setText(findTestObject('Common/fielddata', [('dynamicvariable') : 'tourdays']), internalData.getValue(i++, 1))

WebUI.setText(findTestObject('Common/fielddata', [('dynamicvariable') : 'tournights']), internalData.getValue(i++, 1))

WebUI.click(findTestObject('TourCreation/TourTypeDrop'))

WebUI.click(findTestObject('TourCreation/TypeSelection', [('type') : internalData.getValue(i++, 1)]))

WebUI.click(findTestObject('TourCreation/LocationDropdown'))

WebUI.setText(findTestObject('TourCreation/SearchLocation'), 'paris')

WebUI.click(findTestObject('TourCreation/LocationSelection'))

WebUI.click(findTestObject('TourCreation/ClickInclusions/Page_Add Tour/a_Inclusions'))

WebUI.click(findTestObject('TourCreation/Select All'))

WebUI.delay(5)

WebUI.click(findTestObject('TourCreation/Select All'))

def tourfacilitiesinclude = findTestData('DataFile For TourCreation/Inclusions')

for (def index : (1..tourfacilitiesinclude.getRowNumbers())) {
    WebUI.click(findTestObject('TourCreation/IncludeFacilities', [('includefacilities') : tourfacilitiesinclude.getValue(
                    1, index)]))
}

WebUI.click(findTestObject('TourCreation/ClickExclusions'))

def tourfacilitiesexclude = findTestData('DataFile For TourCreation/Exclusions')

for (def indexe : (1..tourfacilitiesexclude.getRowNumbers())) {
    WebUI.click(findTestObject('TourCreation/ExcludeFacilities', [('excludefacilities') : tourfacilitiesexclude.getValue(
                    1, indexe)]))
}

WebUI.click(findTestObject('TourCreation/SubmitTour'))

WebUI.verifyElementPresent(findTestObject('TourCreation/VerifyTourPresent'), 10)

WebUI.closeBrowser()

