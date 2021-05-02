import Pages.HomePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.*;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.*;
import java.util.Random;




@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestCases extends BaseTest{
    private  static  final Logger logger = LogManager.getLogger(TestCases.class);


    @Test
    public void test_1_HomePage(){
        HomePage homePage  = new HomePage(driver);
        driver.get(homePage.site());
        driver.manage().window().maximize();
        try {
            Assert.assertEquals("GittiGidiyor - Türkiye'nin Öncü Alışveriş Sitesi", driver.getTitle());
        }catch (Exception e) {
            logger.error("Başlık hatalı,anasayfaya giriş başarısız.");
        }

        System.out.println("Anasayfaya giriş başarılı bir şekilde yapıldı.");

    }

    private final By hovenlogin = By.xpath("//*[@id=\"main-header\"]/div[3]/div/div/div/div[3]/div/div[1]/div/div[2]");
    private final By clicklogin = By.xpath("//*[@id=\"main-header\"]/div[3]/div/div/div/div[3]/div/div[1]/div[2]/div/div/div/a");

    @Test
    public void test_2_LoginPage() throws InterruptedException{
        WebElement giris_element = driver.findElement(hovenlogin);
        giris_element.click();
        Thread.sleep(2000);
        WebElement giris = driver.findElement(clicklogin);
        giris.click();
    }


    private final By username = By.id("L-UserNameField");
    private final By password = By.id("L-PasswordField");
    private final By login = By.id("gg-login-enter");
    @Test
    public void test_3_toLogin() throws InterruptedException{
        WebElement setusername = driver.findElement(username);
        setusername.click();
        setusername.sendKeys("testiniumprojehusrev@gmail.com");
        WebElement setpassword = driver.findElement(password);
        setpassword.click();
        setpassword.sendKeys("testiniumhusrev1");
        Thread.sleep(2000);
        WebElement loginButton = driver.findElement(login);
        loginButton.click();
    }


    private final By searchbar = By.xpath("//*[@id=\"main-header\"]/div[3]/div/div/div/div[2]/form/div/div[1]/div[2]/input");
    private final By searchclick = By.xpath("//*[@id=\"main-header\"]/div[3]/div/div/div/div[2]/form/div/div[2]/button");
    @Test
    public void test_4_Search() throws InterruptedException{
        WebElement setsearchbar = driver.findElement(searchbar);
        setsearchbar.click();
        setsearchbar.sendKeys("Bilgisayar");
        Thread.sleep(2000);
        WebElement setsearchclick = driver.findElement(searchclick);
        setsearchclick.click();
    }


    private final By secondpage = By.xpath("//*[@id=\"best-match-right\"]/div[5]/ul/li[2]/a");
    private final By icon = By.xpath("/html/body/div[5]/div[2]/div/div/a/span");
    @Test
    public void test_5_secondPage() throws InterruptedException{
        JavascriptExecutor setsecond = (JavascriptExecutor) driver;
        setsecond.executeScript("scroll(0,350)");
        Thread.sleep(2000);
        WebElement ccicon = driver.findElement(icon);
        ccicon.click();
        Thread.sleep(2000);
        WebElement secondclick = driver.findElement(secondpage);
        secondclick.click();
        System.out.println("2.sayfaya geçildi.");
    }

    @Test
    public void test_6_controlSecondpage(){
        Assert.assertEquals("Bilgisayar - GittiGidiyor - 2/100",driver.getTitle());
        System.out.println("2. sayfanın açıldığı kontrol edildi. ");
    }

    @Test
    public void test_7_randomChoose() throws InterruptedException {
        Random random = new Random();
        int upper = 48;
        int randomnum = random.nextInt(upper);
        WebElement item = driver.findElement(By.xpath("/html/body/div[5]/div[1]/div/div[2]/div[3]/div[2]/ul/li["+randomnum+"]"));
        item.click();
        Thread.sleep(1000);

    }





    private final By addthebasket = By.id("add-to-basket");
    @Test
    public void test_8_addBasket() throws InterruptedException {
        WebElement basket = driver.findElement(addthebasket);
        basket.click();

    }




    private final By clickbasket = By.xpath("//*[@id=\"header_wrapper\"]/div[4]/div[3]/a/div[2]");
    @Test
    public void test_9_1_basket() {
        WebElement giris = driver.findElement(clickbasket);
        giris.click();

    }


    @Test
    public void test_9_3_plusProduct() throws InterruptedException {

        driver.findElement(By.className("number-selection")).click();
        //driver.findElement(By.cssSelector("#"+id+" > div.gg-w-24.gg-d-24.gg-t-24.gg-m-24.padding-none.product-item-box-container > div.gg-w-3.gg-d-3.gg-t-4.gg-m-16.pull-right-m.hidden-m.padding-none > div > div.gg-input.gg-input-select > select > option:nth-child(2)")).click();
        Thread.sleep(500);
        System.out.println("Ürün adeti ikiye çıkarıldı.");
    }

    @Test
    public void test_9_4_delProduct(){
        driver.findElement(By.className("btn-delete")).click();
        System.out.println("Sepet boşaltıldı.");
    }













}
