package steps;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class deneme {
    public static void main (String [] args) throws IOException {
        SimpleDateFormat dateFormat = new SimpleDateFormat();
        Date date = new Date();
        String filePath = new File("").getAbsolutePath()+"\\src\\test\\java\\data\\coin-list.xlsx";
        FileInputStream fs = new FileInputStream(filePath);
        XSSFWorkbook workbook = new XSSFWorkbook(fs);
        XSSFSheet sheet = workbook.createSheet(dateFormat.format(date).replaceAll(":","."));
        Row row = sheet.createRow(0);
        Cell cell1 = row.createCell(0);
        Cell cell2 = row.createCell(1);
        Cell cell3 = row.createCell(2);
        cell1.setCellValue("Name");
        cell2.setCellValue("Price");
        cell3.setCellValue("Volume");
        for (int i=1;i<10;i++){
            Row y = sheet.createRow(i);
            Cell satır1 = y.createCell(0);
            Cell satır2 = y.createCell(1);
            Cell satır3 = y.createCell(2);
            satır1.setCellValue("Name");
            satır2.setCellValue("Price");
            satır3.setCellValue("Volume");
        }

        FileOutputStream outFile = new FileOutputStream(new File(filePath));
        workbook.write(outFile);

    }
}
