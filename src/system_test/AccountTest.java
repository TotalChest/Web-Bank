package system_test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class AccountTest {
    private String base_path = "http://localhost:8080/";
    private final String Driver = "/home/totalchest/IdeaProjects/Web-Application/lib/greckodriver";
    @Test
    public void AccTest() throws IOException, InterruptedException {
        System.setProperty("webdriver.gecko.driver", Driver);
        WebDriver driver = new FirefoxDriver();
        driver.get(base_path);

        driver.findElement(By.linkText("СЧЕТА")).click();
        title = driver.getTitle();
        Assert.assertTrue(title.equals("Счета"));

        driver.findElement(By.linkText("ДОБАВИТЬ СЧЕТ")).click();
        title = driver.getTitle();
        Assert.assertTrue(title.equals("Добавить счет"));
        driver.findElement(By.name("number")).click();
        driver.findElement(By.name("number")).sendKeys("8888888888");
        driver.findElement(By.name("customer_id")).click();
        driver.findElement(By.name("customer_id")).sendKeys("2");
        driver.findElement(By.name("type")).click();
        driver.findElement(By.name("type")).sendKeys("LIGHT");
        driver.findElement(By.name("interest_account")).click();
        driver.findElement(By.name("interest_account")).sendKeys("6");
        driver.findElement(By.name("department")).click();
        driver.findElement(By.name("department")).sendKeys("1");
        driver.findElement(By.id("add")).click();

        driver.findElement(By.linkText("СЧЕТА")).click();
        driver.findElement(By.id("number")).click();
        driver.findElement(By.id("number")).sendKeys("8888888888");
        driver.findElement(By.cssSelector("input:nth-child(2)")).click();
        title = driver.getTitle();
        Assert.assertTrue(title.equals("Счет"));
        driver.findElement(By.id("amount")).click();
        driver.findElement(By.id("amount")).sendKeys("5000.0");
        driver.findElement(By.linkText("Зачислить")).click();

        driver.findElement(By.linkText("СЧЕТА")).click();
        driver.findElement(By.id("number")).click();
        driver.findElement(By.id("number")).sendKeys("8888888888");
        driver.findElement(By.cssSelector("//td[2]")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//td[5]")).getText(), "5000.0");

        driver.findElement(By.linkText("СЧЕТА")).click();
        driver.findElement(By.id("department")).click();
        driver.findElement(By.id("department")).sendKeys("2");
        driver.findElement(By.xpath("//td[5]")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//td[7]")).getText(), "Московский банк. Сбербанк");

        driver.findElement(By.linkText("ДОБАВИТЬ СЧЕТ")).click();
        title = driver.getTitle();
        Assert.assertTrue(title.equals("Добавить счет"));
        driver.findElement(By.name("number")).click();
        driver.findElement(By.name("number")).sendKeys("1234567890");
        driver.findElement(By.name("customer_id")).click();
        driver.findElement(By.name("customer_id")).sendKeys("3");
        driver.findElement(By.name("type")).click();
        driver.findElement(By.name("type")).sendKeys("ERROR");
        driver.findElement(By.name("department")).click();
        driver.findElement(By.name("department")).sendKeys("1");
        driver.findElement(By.id("add")).click();
        title = driver.getTitle();
        Assert.assertTrue(title.equals("Ошибка"));
        Assert.assertEquals(driver.findElement(By.className("error")).getText(), "Ошибка");

        driver.findElement(By.linkText("СИСТЕМА УПРАВЛЕНИЯ СБЕРЕГАТЕЛЬНЫМИ СЧЕТАМИ БАНКА")).click();
        driver.quit();
    }
}