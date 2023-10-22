package com.my.library.pages;

import com.my.library.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Excel {

    public static void main(String[] args) throws IOException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        driver.get("https://library1.cydeo.com/login.html");

        String path = "C:\\Users\\QA534\\Desktop\\LibraryCredentials3.xlsx";

        FileInputStream file = new FileInputStream(path);
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet sheet1 = workbook.getSheet("library1");



        for (int rowNum = 1; rowNum <= sheet1.getLastRowNum(); rowNum++) {
            Row row = sheet1.getRow(rowNum);

            String username = row.getCell(0).getStringCellValue();
            String password = row.getCell(1).getStringCellValue();


            WebElement inputUsername = driver.findElement(By.xpath("//input[@id='inputEmail']"));
            BrowserUtils.sleep(2);
            inputUsername.sendKeys(username);

            WebElement inputPassword = driver.findElement(By.id("inputPassword"));

            inputPassword.sendKeys(password);

            WebElement signInButton = driver.findElement(By.xpath("//button[.='Sign in']"));

            signInButton.click();
            BrowserUtils.sleep(2);
            driver.close();

        }
    }
}
