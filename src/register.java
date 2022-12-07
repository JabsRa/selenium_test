import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class register {
    public static void main(String[] args) throws Exception {
        WebDriver driver = new ChromeDriver();
        driver.get("https://dev.noctua.gg");
        WebElement burgerbutton = driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-text p-0']//*[name()='svg']"));
        burgerbutton.click();
        WebElement registerbutton = driver.findElement(By.xpath("//a[@class='ant-btn ant-btn-primary ant-btn-lg ant-btn-block border-radius-20 text-color-white text-m-medium']"));
        registerbutton.click();
        Thread.sleep(200);
        driver.findElement(By.xpath("//input[@id='change-password_email']")).sendKeys("abcdef@gmail.com");
        driver.findElement(By.xpath("//input[@id='change-password_password']")).sendKeys("qwerty123");
        driver.findElement(By.xpath("//input[@id='change-password_confirmPassword']")).sendKeys("qwerty123");
        driver.findElement(By.xpath("//span[contains(text(),'Send')]")).click();
        Thread.sleep(4000);
        driver.findElement(By.xpath("//input[@id='change-password_vcode']")).sendKeys("323232323");
        driver.findElement(By.xpath("//input[@type='checkbox']")).click();
        Thread.sleep(200);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(200);
        // WebElement notiferror = driver.findElement(By.xpath("//span[normalize-space()='VERIFICATION_CODE_NOT_MATCH']"));
        String expected_String = "VERIFICATION_CODE_NOT_MATCH";
        String tes = driver.findElement(By.xpath("//span[normalize-space()='VERIFICATION_CODE_NOT_MATCH']")).getText();
            if(expected_String.equals(tes))
                {
                    System.out.println("Text is Matched");
                }
                    else
                {
                System.out.println("Text is not Matched");
            }
        
    }

}