import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class cek_quest {

    public static void main(String[] args) throws Exception {
        WebDriver driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor)driver;
        driver.get("https://noctua.gg");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-text p-0']//*[name()='svg']")).click();
        driver.findElement(By.xpath(
                "//a[@class='ant-btn ant-btn-primary ant-btn-lg ant-btn-background-ghost ant-btn-block text-m-medium text-color-white border-radius-20']"))
                .click();
        Thread.sleep(6000);
        driver.findElement(By.xpath("//input[@id='login-form_email']")).sendKeys("jabal.rahmatullah@attn.sg");
        driver.findElement(By.xpath("//input[@id='login-form_password']")).sendKeys("qwerty123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(6000);

        if (driver.findElements(By.xpath(
                "//div[@class='ant-row ant-row-space-between ant-row-middle mt--5']//div[@class='ant-row ant-row-middle']//*[name()='svg']//*[name()='path' and contains(@d,'M9.48063 8')]"))
                .size() != 0) {
            System.out.println("Element is Present");
        } else {
            System.out.println("Element is Absent");
        }

        driver.findElement(By.xpath(
                "//div[@class='ant-row ant-row-center bottom-navbar-active tour-homepage-claim-reward']//*[name()='svg']"))
                .click();
        Thread.sleep(10000);
        driver.findElement(By.xpath("//img[@alt='Yggdrasil']")).click();
        Thread.sleep(4000);
        js.executeScript("window.scrollBy(0,100)", "");
        while(driver.findElements(By.xpath("//span[@class='ant-typography text-s-medium']")).size() !=0){
            driver.findElement(By.xpath("//span[@class='ant-typography text-s-medium']")).click();
            Thread.sleep(4000);
        }
        driver.findElement(By.xpath("//img[@alt='AFK Champion']")).click();
        Thread.sleep(4000);
        while(driver.findElements(By.xpath("//span[@class='ant-typography text-s-medium']")).size() !=0){
            driver.findElement(By.xpath("//span[@class='ant-typography text-s-medium']")).click();
            Thread.sleep(4000);
        }
        driver.findElement(By.xpath("//img[@alt='Noctua Platform']")).click();
        Thread.sleep(4000);
        while(driver.findElements(By.xpath("//span[@class='ant-typography text-s-medium']")).size() !=0){
            driver.findElement(By.xpath("//span[@class='ant-typography text-s-medium']")).click();
            Thread.sleep(4000);
        }
    }
}
