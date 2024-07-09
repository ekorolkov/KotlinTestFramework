package tests

import com.microsoft.playwright.Browser
import com.microsoft.playwright.BrowserContext
import com.microsoft.playwright.BrowserType
import com.microsoft.playwright.Page
import com.microsoft.playwright.Playwright
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
open class BaseTest {
    private lateinit var playwright: Playwright
    private lateinit var browser: Browser
    private lateinit var context: BrowserContext
    protected lateinit var page: Page

    @BeforeAll
    fun launchBrowser() {
        playwright = Playwright.create()
        browser = playwright.chromium()
            .launch(
                BrowserType.LaunchOptions()
                    .setHeadless(false)
            )
    }

    @AfterAll
    fun closeBrowser() {
        playwright.close()
    }

    @BeforeEach
    fun createContextAndPage() {
        context = browser.newContext()
        page = context.newPage()
    }

    @AfterEach
    fun closeContext() {
        context.close()
    }
}