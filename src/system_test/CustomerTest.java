package system_test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class CustomerTest {
    private String base_path = "http://localhost:8080/";
    private final String Driver = "/home/totalchest/IdeaProjects/Web-Application/lib/greckodriver";
    @Test
    public void CusTest() throws IOException, InterruptedException {
        System.setProperty("webdriver.gecko.driver", Driver);
        WebDriver driver = new FirefoxDriver();
        driver.get(base_path);

        driver.findElement(By.linkText("КЛИЕНТЫ")).click();
        title = driver.getTitle();
        Assert.assertTrue(title.equals("Клиенты"));

        driver.findElement(By.linkText("ДОБАВИТЬ КЛИЕНТА")).click();
        title = driver.getTitle();
        Assert.assertTrue(title.equals("Добавить клиента"));
        driver.findElement(By.name("type")).click();
        driver.findElement(By.name("type")).sendKeys("INDIVIDUAL");
        driver.findElement(By.name("name")).click();
        driver.findElement(By.name("name")).sendKeys("Иван");
        driver.findElement(By.name("surname")).click();
        driver.findElement(By.name("surname")).sendKeys("Иванов");
        driver.findElement(By.name("address")).click();
        driver.findElement(By.name("address")).sendKeys("Улица Пушкина, 21");
        driver.findElement(By.name("phone_number")).click();
        driver.findElement(By.name("phone_number")).sendKeys("8-903-678-34-44");
        driver.findElement(By.name("email")).click();
        driver.findElement(By.name("email")).sendKeys("ivan@mail.ru");
        driver.findElement(By.id("add")).click();

        driver.findElement(By.linkText("КЛИЕНТЫ")).click();
        driver.findElement(By.id("name")).click();
        driver.findElement(By.id("name")).sendKeys("Иван");
        driver.findElement(By.cssSelector("//td[2]")).click();
        title = driver.getTitle();
        Assert.assertTrue(title.equals("Клиент"));
        Assert.assertEquals( driver.findElement(By.xpath("//td[2]")).getText(), "INDIVIDUAL");


        driver.findElement(By.linkText("КЛИЕНТЫ")).click();
        driver.findElement(By.id("type")).click();
        driver.findElement(By.id("type")).sendKeys("ORGANIZATION");
        Assert.assertEquals( driver.findElement(By.xpath("//td[6]")).getText(), "23.11.19");

        driver.findElement(By.linkText("ДОБАВИТЬ КЛИЕНТА")).click();
        title = driver.getTitle();
        Assert.assertTrue(title.equals("Добавить клиента"));
        driver.findElement(By.name("type")).click();
        driver.findElement(By.name("type")).sendKeys("ERROR");
        driver.findElement(By.name("name")).click();
        driver.findElement(By.name("name")).sendKeys("Иван");
        driver.findElement(By.name("surname")).click();
        driver.findElement(By.name("surname")).sendKeys("Иванов");
        driver.findElement(By.name("address")).click();
        driver.findElement(By.name("address")).sendKeys("Улица Пушкина, 21");
        driver.findElement(By.name("phone_number")).click();
        driver.findElement(By.name("phone_number")).sendKeys("8-903-678-34-44");
        driver.findElement(By.name("email")).click();
        driver.findElement(By.name("email")).sendKeys("ivan@mail.ru");
        driver.findElement(By.id("add")).click();
        title = driver.getTitle();
        Assert.assertTrue(title.equals("Ошибка"));
        Assert.assertEquals(driver.findElement(By.className("error")).getText(), "Ошибка");

        driver.findElement(By.linkText("СИСТЕМА УПРАВЛЕНИЯ СБЕРЕГАТЕЛЬНЫМИ СЧЕТАМИ БАНКА")).click();
        driver.quit();
    }
}