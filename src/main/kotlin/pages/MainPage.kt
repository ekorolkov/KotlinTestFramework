package pages

import com.microsoft.playwright.Page

class MainPage(private val page: Page) {
    val headerContacts = "//ul[@class='elementor-icon-list-items elementor-inline-items']"
    val horizontalMenu = "//div[@class='main-header-bar-navigation']"
    val footer = "//div[@data-elementor-type='footer']"
    val certificationCourses = "Best Selenium Certification Course Online Best Selenium Certification Course"
    val coursesSlider = ".pp-info-box"
    val coursesSliderNextButton = ".pp-slider-arrow.swiper-button-next"

    fun navigate() {
        page.navigate("https://www.way2automation.com")
    }

    fun getMainPageTitle() = page.title()
}