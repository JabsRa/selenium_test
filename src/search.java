import java.io.FileReader;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import graphql.parser.Parser;
import net.bytebuddy.asm.Advice.Return;

public class search {

    public static void main(String[] args) throws Exception {

        try {
            //Bind JSON
            JSONParser parser = new JSONParser();
            Object object = parser.parse(new FileReader("src/test.json"));
            JSONObject jsonObject = (JSONObject) object;
            JSONArray data = (JSONArray) jsonObject.get("data");

            
            

            WebDriver driver = new ChromeDriver();
            JavascriptExecutor js = (JavascriptExecutor) driver;
            driver.get("https://www.service.nsw.gov.au");
            driver.manage().window().maximize();
            driver.findElement(By.xpath(
                    "//ul[@class='MainNav__list-peZtddYtxn']//a[@class='NavLink__link-M-HSy9SYcc'][normalize-space()='Find locations']  "))
                    .click();
            // js.executeScript("window.scrollBy(0,300)", "");
            Thread.sleep(3000);
            int count = 1;
            for(int x = 0;x<data.size();x++){
                JSONObject result = (JSONObject) data.get(x);
                System.out.println("Location ["+count+"] :"+result.get("location"));
                System.out.println("Service Center Expected ["+count+"] :"+result.get("verification"));
                System.out.println();
                count+=1;

                driver.findElement(By.xpath("//input[@id='locatorTextSearch']")).sendKeys(result.get("location").toString());
                driver.findElement(By.xpath("//button[@class='button button--primary button--xxlarge']//*[name()='svg']")).click();
                // js.executeScript("window.scrollBy(0,300)", "");
                Thread.sleep(3000);
                List<WebElement> items = driver.findElements(By.className("location__title"));
                System.out.println("=========================================================================");
                int verify = 0;
                for(WebElement item : items) {
                    String serviceCenter = item.getText();
                    if(serviceCenter.equals(result.get("verification").toString())){
                        verify+=1;
                    }
                }
                if(verify>0){
                    System.out.println("Service Center Found");
                }else{
                    System.out.println("Service Center Not Found");
                }
                System.out.println("=========================================================================");
                driver.findElement(By.xpath("//input[@id='locatorTextSearch']")).clear();
            }
            
            

        } catch (Exception e) {
            System.out.println("Error " + e);
        }

    }
}
