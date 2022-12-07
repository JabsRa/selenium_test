import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class quest {
    
    public static void main(String[] args) throws Exception { 
        WebDriver driver = new ChromeDriver();
        driver.get("https://dev.noctua.gg");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-text p-0']//*[name()='svg']")).click();
        driver.findElement(By.xpath("//a[@class='ant-btn ant-btn-primary ant-btn-lg ant-btn-background-ghost ant-btn-block text-m-medium text-color-white border-radius-20']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='login-form_email']")).sendKeys("jabalrahmatullah6@gmail.com");    
        driver.findElement(By.xpath("//input[@id='login-form_password']")).sendKeys("qwerty123");;
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@class='ant-row ant-row-center bottom-navbar-active tour-homepage-claim-reward']//*[name()='svg']")).click();
    
        Thread.sleep(5000);
        if(driver.findElements(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/button/span")).size() <= 0){
            driver.findElement(By.cssSelector("img[alt='Noctua Platform']")).click();
        }else{
            driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/button/span")).click();
        }
           
                
    }
}
