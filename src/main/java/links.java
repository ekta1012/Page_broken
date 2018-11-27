

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

    public class links {

        public static void main(String args[]) {
            String[] links = null;
            int linksCount = 0;
            WebDriver ff;
            System.setProperty("webdriver.firefox.marionette", "C:\\geckodriver.exe");
            ff = new FirefoxDriver();
            //FirefoxDriver ff=new FirefoxDriver();
            ff.get("http://qaerp.franciscanecare.net/Payroll/Default.aspx");
            WebElement g = ff.findElement(By.id("txtUserName"));
            g.sendKeys("admin");
            WebElement gg = ff.findElement(By.id("txtPassword"));
            gg.sendKeys("Admin#franciscan");

            WebElement ggh = ff.findElement(By.id("btnLogin"));
            ggh.click();

            WebElement abc = ff.findElement(By.xpath("//a[contains(text(),'Go to Payroll')]"));
            abc.click();


            for (String handle : ff.getWindowHandles()) {
                ff.switchTo().window(handle);

            }
            Actions ac = new Actions(ff);
            WebElement abcd = ff.findElement(By.xpath("//span[text()='Navigation']"));
            ac.moveToElement(abcd).perform();
            WebElement abcde = ff.findElement(By.xpath("//span[text()='Global Masters']"));
            ac.moveToElement(abcde).click().build().perform();
            //span[text()='Define Academic Year']
            WebElement academic = ff.findElement(By.xpath("//span[text()='Define Academic Year']"));
            ac.moveToElement(academic).click();
            ff.navigate().to("http://qaerp.franciscanecare.net/SchoolCommonDetails/AcademicYear.aspx");
            List<WebElement> linksize = ff.findElements(By.tagName("a"));
            linksCount = linksize.size();
            System.out.println("Total no of links Available: " + linksCount);
            links = new String[linksCount];
            System.out.println("List of links Available: " +links.toString());
// print all the links from webpage
            for (int i = 0; i < linksCount; i++) {
                links[i] = linksize.get(i).getAttribute("href");
                System.out.println(linksize.get(i).getAttribute("href"));
            }
// navigate to each Link on the webpage
            for (int i = 0; i < linksCount; i++) {
                ff.navigate().to(links[i]);
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }


        /*public static List findAllLinks(WebDriver driver) {
            List<WebElement> elementList = new ArrayList();
            elementList = driver.findElements(By.tagName("a"));
            List finalList = new ArrayList();
            for (WebElement e : elementList) {
                if (e.getAttribute("href") != null) {
                    finalList.add(e);
                }
            }
            return finalList;
        }

        public static String isLinkBroken(URL url) throws Exception {

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            try {

                connection.connect();

                String response = connection.getResponseMessage();

                connection.disconnect();

                return response;

            } catch (Exception exp) {

                return exp.getMessage();

            }
        }

        public static void main(String args[]) throws Exception {
            WebDriver ff;
            System.setProperty("webdriver.firefox.marionette", "C:\\geckodriver.exe");
            ff = new FirefoxDriver();
            //FirefoxDriver ff=new FirefoxDriver();
            ff.get("http://qaerp.franciscanecare.net/Payroll/Default.aspx");
            WebElement g= ff.findElement(By.id("txtUserName"));
            g.sendKeys("admin");
            WebElement gg= ff.findElement(By.id("txtPassword"));
            gg.sendKeys("Admin#franciscan");

            WebElement ggh= ff.findElement(By.id("btnLogin"));
            ggh.click();

            WebElement abc=ff.findElement(By.xpath("//a[contains(text(),'Go to Payroll')]"));
            abc.click();


            for (String handle :ff.getWindowHandles()) {
                ff.switchTo().window(handle);

            }
            Actions ac = new Actions(ff);
            WebElement abcd=ff.findElement(By.xpath("//span[text()='Navigation']"));
            ac.moveToElement(abcd).perform();
            WebElement abcde=ff.findElement(By.xpath("//span[text()='Global Masters']"));
            ac.moveToElement(abcde).click().build().perform();
            List<WebElement> elementList1 = new ArrayList();


            elementList1 =ff.findElements(By.tagName("a"));
            System.out.println("Total links***" +elementList1);

            List<WebElement> allImages=findAllLinks(ff);
            System.out.println("Total no of elements found::::" +allImages.size());
            System.out.println("Total no of elements found::::" +allImages.getClass());

            for(WebElement e :allImages)
                try
                {
                    System.out.println("URL:" +e.getAttribute("href")+"returned" +isLinkBroken(new URL(e.getAttribute("href"))));

                }
                catch(Exception ex)
                {
                    System.out.println("At " + e.getAttribute("innerHTML") + " Exception occured)");
                    // "//-&gt; " + exp .getMessage());
                }


        }*/

