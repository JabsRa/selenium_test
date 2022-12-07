import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class App {
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
        Thread.sleep(6000);

        if(driver.findElements(By.xpath("//div[@class='ant-row ant-row-space-between ant-row-middle mt--5']//div[@class='ant-row ant-row-middle']//*[name()='svg']//*[name()='path' and contains(@d,'M9.48063 8')]")).size() != 0){
            System.out.println("Element is Present");
            }else{
            System.out.println("Element is Absent");
            }
            
            driver.findElement(By.xpath("//div[@class='ant-row ant-row-center bottom-navbar-active tour-homepage-claim-reward']//*[name()='svg']")).click();
            Thread.sleep(6000);

            // Ambil Koin Awal
            String coinawalquest = driver.findElement(By.xpath("//span[@class='ant-typography ml-1 mr-1 heading-m-bold']")).getText();
            System.out.println("String : "+coinawalquest);
            coinawalquest = coinawalquest.replaceAll("[^\\d]", "");
            Integer c_awal = Integer.parseInt(coinawalquest);
            System.out.println("Integer : "+c_awal);

            Thread.sleep(2000);
            driver.findElement(By.cssSelector("img[alt='Noctua Platform']")).click();

            // Ambil Koin Quest
            String coinquest = driver.findElement(By.xpath("//span[@class='ant-typography text-s-regular text-color-warning-main']")).getText();
            System.out.println("String : "+coinquest);
            // coinquest = coinquest.substring(0,coinquest.length()-1);
            coinquest = coinquest.replaceAll("[^\\d]", "");
            Integer c_quest = Integer.parseInt(coinquest);
            System.out.println("Integer : "+c_quest);

            // Klik Ambil Koin
            Thread.sleep(2000);
            JavascriptExecutor js = (JavascriptExecutor)driver;
            js.executeScript("window.scrollBy(0,250)", "");
            driver.findElement(By.xpath("//span[@class='ant-typography text-s-medium']")).click();

            Thread.sleep(2000); 
            driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/button/span")).click();

            // Ambil Koin Akhir
            Thread.sleep(2000);
            js.executeScript("window.scrollBy(0,-250)", "");
            driver.findElement(By.xpath("//a[@href='/']//div[@class='ant-row ant-row-center bottom-navbar-active undefined']//*[name()='svg']")).click();
            Thread.sleep(5000);
            String coinakhirquest = driver.findElement(By.xpath("//span[@class='ant-typography ml--5 heading-m-bold']")).getText();
            System.out.println("String : "+coinakhirquest);
            coinakhirquest = coinakhirquest.replaceAll("[^\\d]", "");
            Integer c_akhir = Integer.parseInt(coinakhirquest);
            System.out.println("Integer : "+c_akhir);

            System.out.println("========================================================================");

            System.out.println("Koin Awal : "+c_awal);
            System.out.println("Koin Quest : "+c_quest);
            System.out.println("Koin Akhir : "+c_akhir);

            Integer valid = c_awal+c_quest;

            if(c_akhir == valid){
                System.out.println("Valid");
            }else{
                System.out.println("Not Valid");
            }

    }
}
