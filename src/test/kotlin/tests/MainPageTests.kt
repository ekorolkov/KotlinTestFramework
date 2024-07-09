package tests

import io.qameta.allure.Epic
import io.qameta.allure.Feature
import io.qameta.allure.Severity
import io.qameta.allure.SeverityLevel
import io.qameta.allure.Story
import org.junit.jupiter.api.Test
import pages.MainPage
import kotlin.test.assertEquals
import kotlin.test.assertTrue

@Epic("Kotlin tests")
@Feature("UI tests")
class MainPageTests : BaseTest() {
    val pageTitle = "Get Online Selenium Certification Course | Way2Automation"

    @Story("Check main page")
    @Severity(SeverityLevel.NORMAL)
    @Test
    fun checkMainPage() {
        val mainPage = MainPage(page)
        mainPage.navigate()
        assertEquals(mainPage.getMainPageTitle(), pageTitle,
            "Ожидается заголовок страницы")

        assertTrue(page.locator(mainPage.headerContacts).isVisible,
            "Ожидается заголовок с контактами")

        assertTrue(page.locator(mainPage.horizontalMenu).first().isVisible,
            "Ожидается горизонтальное меню")

        assertTrue(page.getByText(mainPage.certificationCourses).isVisible,
            "Ожидается блок с сертификацией")

        assertTrue(page.locator(mainPage.coursesSlider).isVisible,
            "Ожидается блок с курсами")

        assertTrue(page.locator(mainPage.footer).isVisible,
            "Ожидается футер")
    }

    @Story("Check courses slider")
    @Severity(SeverityLevel.NORMAL)
    @Test
    fun checkCoursesSlider() {
        val mainPage = MainPage(page)
        mainPage.navigate()
        page.locator(mainPage.coursesSliderNextButton).click()
    }
}