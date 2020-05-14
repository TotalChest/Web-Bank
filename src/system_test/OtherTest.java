package system_test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class OtherTest {
    private String base_path = "http://localhost:8080/";
    private final String Driver = "/home/totalchest/IdeaProjects/Web-Application/lib/greckodriver";
    @Test
    public void OthTest() throws IOException, InterruptedException {
        System.setProperty("webdriver.gecko.driver", Driver);
        WebDriver driver = new FirefoxDriver();system_test
        driver.get(base_path);
        String title = driver.getTitle();
        Assert.assertTrue(title.equals("Банк"));

        driver.findElement(By.linkText("КЛИЕНТЫ")).click();
        title = driver.getTitle();
        Assert.assertTrue(title.equals("Клиенты"));

        driver.findElement(By.linkText("СЧЕТА")).click();
        title = driver.getTitle();
        Assert.assertTrue(title.equals("Счета"));

        driver.findElement(By.linkText("ОТДЕЛЕНИЯ")).click();
        title = driver.getTitle();
        Assert.assertTrue(title.equals("Отделения"));

        driver.findElement(By.linkText("ОПЕРАЦИИ")).click();
        title = driver.getTitle();
        Assert.assertTrue(title.equals("Опреции"));

        Assert.assertEquals( driver.findElement(By.xpath("//td[1]")).getText(), "89676776");
        Assert.assertEquals( driver.findElement(By.xpath("//td[2]")).getText(), "Списание");
        Assert.assertEquals( driver.findElement(By.xpath("//td[3]")).getText(), "7000");
        Assert.assertEquals( driver.findElement(By.xpath("//td[4]")).getText(), "23.11.19");

        driver.findElement(By.linkText("ОТДЕЛЕНИЯ")).click();
        driver.findElement(By.linkText("ДОБАВИТЬ ОТДЕЛЕНИЕ")).click();
        driver.findElement(By.name("name")).click();
        driver.findElement(By.name("name")).sendKeys("Альфабанк");
        driver.findElement(By.name("address")).click();
        driver.findElement(By.name("address")).sendKeys("Тверская, 31");
        driver.findElement(By.id("add")).click();

        driver.get(base_path + "rrrrr");
        title = driver.getTitle();
        Assert.assertTrue(title.equals("Ошибка"));
        Assert.assertEquals(driver.findElement(By.className("error")).getText(), "Ошибка");

        driver.findElement(By.linkText("СИСТЕМА УПРАВЛЕНИЯ СБЕРЕГАТЕЛЬНЫМИ СЧЕТАМИ БАНКА")).click();
        Assert.assertEquals( driver.findElement(By.id("description")).getText().substring(0, 34), "Этот сайт создан в учебных целях.");

        driver.findElement(By.linkText("СИСТЕМА УПРАВЛЕНИЯ СБЕРЕГАТЕЛЬНЫМИ СЧЕТАМИ БАНКА")).click();
        driver.quit();
    }
}