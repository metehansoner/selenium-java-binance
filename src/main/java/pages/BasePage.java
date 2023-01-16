package pages;

import driver.DriverManager;
import model.Coin;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static config.ConfigurationManager.configuration;
import static org.openqa.selenium.support.PageFactory.initElements;

public class BasePage {
    public WebDriver driver;

    protected BasePage() {
        this.driver = DriverManager.getDriver();
        initElements(new AjaxElementLocatorFactory(driver, configuration().timeout()), this);
    }

    public List findChildElemnts(String locator) {
        return driver.findElements(By.xpath(locator));
    }

    public void writeToFile(List<Coin> coinList) throws IOException {
        SimpleDateFormat dateFormat = new SimpleDateFormat();
        Date date = new Date();
        String filePath = new File("").getAbsolutePath() + "\\src\\test\\java\\data\\coin-list.xlsx";
        FileInputStream fs = new FileInputStream(filePath);
        XSSFWorkbook workbook = new XSSFWorkbook(fs);
        XSSFSheet sheet = workbook.createSheet(dateFormat.format(date).replaceAll(":", "."));
        Row row = sheet.createRow(0);
        Cell cell1 = row.createCell(0);
        Cell cell2 = row.createCell(1);
        Cell cell3 = row.createCell(2);
        cell1.setCellValue("Name");
        cell2.setCellValue("Price");
        cell3.setCellValue("Volume");
        for (int i = 1; i < coinList.size(); i++) {
            Row y = sheet.createRow(i);
            Cell newline1 = y.createCell(0);
            Cell newline2 = y.createCell(1);
            Cell newline3 = y.createCell(2);
            newline1.setCellValue(coinList.get(i).getName());
            newline2.setCellValue(coinList.get(i).getPrice());
            newline3.setCellValue(coinList.get(i).getVolume());
        }

        FileOutputStream outFile = new FileOutputStream(new File(filePath));
        workbook.write(outFile);
    }

}
