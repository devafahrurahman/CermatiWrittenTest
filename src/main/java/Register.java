import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.Random;

public class Register {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver;
        System.setProperty("webdriver.chrome.driver", "E:/QA Tools/chromedriver.exe");
        driver = new ChromeDriver();

        driver.get("https://www.cermati.com/gabung");

        WebElement email = driver.findElement(By.id("email"));
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(1000);
        int randomInt2 = randomGenerator.nextInt(1000);
        email.sendKeys(randomInt + "username"+ randomInt2 +"@gmail.com");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("Cermati123");

        WebElement confirmPassword = driver.findElement(By.id("confirm-password"));
        confirmPassword.sendKeys("Cermati123");

        WebElement namaDepan = driver.findElement(By.id("first-name"));
        namaDepan.sendKeys("Deddy");

        WebElement namaBelakang = driver.findElement(By.id("last-name"));
        namaBelakang.sendKeys("Corbuzier");

        int randomInt3 = randomGenerator.nextInt(900);
        WebElement nomorTelepon = driver.findElement(By.id("mobile-phone"));
        nomorTelepon.sendKeys("081" + randomInt +randomInt2 + randomInt3);

        WebElement kabupatenKota = driver.findElement(By.id("residence-city"));
        kabupatenKota.sendKeys("Mataram");
        Thread.sleep(1000);
        kabupatenKota.sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(1000);
        kabupatenKota.sendKeys(Keys.ENTER);

        Thread.sleep(1000);
        WebElement daftarAkunBtn = driver.findElement(By.xpath("//button[@id='']"));
        daftarAkunBtn.click();

        Thread.sleep(1000);
        driver.getPageSource().contains("Terima kasih telah bergabung dengan Cermati.com. Harap verifikasi email Anda sekarang.");

        Thread.sleep(10000);
        WebElement icon = driver.findElement(By.xpath("//*[@id=\"main-navigation\"]/ul[2]/li/a/span/i"));
        Assert.assertTrue(icon.isDisplayed());

        driver.quit();


    }
}
