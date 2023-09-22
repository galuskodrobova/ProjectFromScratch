import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FirstEnergy {

        @Test
        public void testMainScreenEmail() {

            System.setProperty("webdriver.chrome.driver","/usr/local/bin/chromedriver");
            WebDriver webDriver = new ChromeDriver();
            webDriver.get("https://codility-frontend-prod.s3.amazonaws.com/media/task_static/qa_login_page/9a83bda125cd7398f9f482a3d6d45ea4/static/attachments/reference_page.html");

            WebElement emailInput = webDriver.findElement(By.id("email-input"));

            boolean isEmailFieldDisplayed = emailInput.isDisplayed();

            Assert.assertTrue(isEmailFieldDisplayed,"Email field is not displayed");
        }

        @Test
        public void testMainScreenPassword() {

            System.setProperty("webdriver.chrome.driver","/usr/local/bin/chromedriver");
            WebDriver webDriver = new ChromeDriver();
            webDriver.get("https://codility-frontend-prod.s3.amazonaws.com/media/task_static/qa_login_page/9a83bda125cd7398f9f482a3d6d45ea4/static/attachments/reference_page.html");

            WebElement passwordInput = webDriver.findElement(By.id("password-input"));

            boolean isPasswordFieldDisplayed = passwordInput.isDisplayed();

            Assert.assertTrue(isPasswordFieldDisplayed,"Password field is not displayed");
        }

        @Test
        public void testMainScreenLoginButton() {

            System.setProperty("webdriver.chrome.driver","/usr/local/bin/chromedriver");
            WebDriver webDriver = new ChromeDriver();
            webDriver.get("https://codility-frontend-prod.s3.amazonaws.com/media/task_static/qa_login_page/9a83bda125cd7398f9f482a3d6d45ea4/static/attachments/reference_page.html");

            WebElement loginButton = webDriver.findElement(By.xpath("//button[@id='login-button']"));

            boolean isloginButtondDisplayed = loginButton.isDisplayed();

            Assert.assertTrue(isloginButtondDisplayed,"Login button is not displayed");
        }

        @Test
        public void testMainLoginSuccessful() {

            System.setProperty("webdriver.chrome.driver","/usr/local/bin/chromedriver");
            WebDriver webDriver = new ChromeDriver();
            webDriver.get("https://codility-frontend-prod.s3.amazonaws.com/media/task_static/qa_login_page/9a83bda125cd7398f9f482a3d6d45ea4/static/attachments/reference_page.html");

            WebElement emailInput = webDriver.findElement(By.id("email-input"));
            emailInput.sendKeys("login@codility.com");

            WebElement passwordInput = webDriver.findElement(By.id("password-input"));
            passwordInput.sendKeys("password");

            WebElement loginButton = webDriver.findElement(By.xpath("//button[@id='login-button']"));
            loginButton.click();

            WebElement actRes = webDriver.findElement(By.xpath("//div[text()='Welcome to Codility']"));

            String expMessage = "Welcome to Codility";

            Assert.assertEquals(expMessage, actRes.getText());

        }

        @Test
        public void testWrongCredentiols() {

            System.setProperty("webdriver.chrome.driver","/usr/local/bin/chromedriver");
            WebDriver webDriver = new ChromeDriver();
            webDriver.get("https://codility-frontend-prod.s3.amazonaws.com/media/task_static/qa_login_page/9a83bda125cd7398f9f482a3d6d45ea4/static/attachments/reference_page.html");

            WebElement emailInput = webDriver.findElement(By.id("email-input"));
            emailInput.sendKeys("unknown@codility.com");

            WebElement passwordInput = webDriver.findElement(By.id("password-input"));
            passwordInput.sendKeys("password");

            WebElement loginButton = webDriver.findElement(By.xpath("//button[@id='login-button']"));
            loginButton.click();

            WebElement actRes = webDriver.findElement(By.xpath("//div[text()='You shall not pass! Arr!']"));

            Assert.assertTrue(actRes.isDisplayed());

        }

        @Test
        public void testInvalidEmail() {

            System.setProperty("webdriver.chrome.driver","/usr/local/bin/chromedriver");
            WebDriver webDriver = new ChromeDriver();
            webDriver.get("https://codility-frontend-prod.s3.amazonaws.com/media/task_static/qa_login_page/9a83bda125cd7398f9f482a3d6d45ea4/static/attachments/reference_page.html");

            WebElement emailInput = webDriver.findElement(By.id("email-input"));
            emailInput.sendKeys("invalidEmail");

            WebElement passwordInput = webDriver.findElement(By.id("password-input"));
            passwordInput.sendKeys("password");

            WebElement loginButton = webDriver.findElement(By.xpath("//button[@id='login-button']"));
            loginButton.click();

            WebElement actRes = webDriver.findElement(By.xpath("//div[text()='Enter a valid email']"));

            Assert.assertTrue(actRes.isDisplayed());

        }

        @Test
        public void testEmptyEmailCredentiols() {

            System.setProperty("webdriver.chrome.driver","/usr/local/bin/chromedriver");
            WebDriver webDriver = new ChromeDriver();
            webDriver.get("https://codility-frontend-prod.s3.amazonaws.com/media/task_static/qa_login_page/9a83bda125cd7398f9f482a3d6d45ea4/static/attachments/reference_page.html");

            WebElement emailInput = webDriver.findElement(By.id("email-input"));
            emailInput.sendKeys("");

            WebElement passwordInput = webDriver.findElement(By.id("password-input"));
            passwordInput.sendKeys("password");

            WebElement loginButton = webDriver.findElement(By.xpath("//button[@id='login-button']"));
            loginButton.click();

            WebElement actRes = webDriver.findElement(By.xpath("//div[text()='Email is required']"));

            String expMessage = "Email is required";

            Assert.assertEquals(expMessage, actRes.getText());

        }

        @Test
        public void testEmptyPasswordCredentiols() {

            System.setProperty("webdriver.chrome.driver","/usr/local/bin/chromedriver");
            WebDriver webDriver = new ChromeDriver();
            webDriver.get("https://codility-frontend-prod.s3.amazonaws.com/media/task_static/qa_login_page/9a83bda125cd7398f9f482a3d6d45ea4/static/attachments/reference_page.html");

            WebElement emailInput = webDriver.findElement(By.id("email-input"));
            emailInput.sendKeys("login@codility.com");

            WebElement passwordInput = webDriver.findElement(By.id("password-input"));
            passwordInput.sendKeys("");

            WebElement loginButton = webDriver.findElement(By.xpath("//button[@id='login-button']"));
            loginButton.click();

            WebElement actRes = webDriver.findElement(By.xpath("//div[text()='Password is required']"));

            String expMessage = "Password is required";

            Assert.assertEquals(expMessage, actRes.getText());

        }

}
