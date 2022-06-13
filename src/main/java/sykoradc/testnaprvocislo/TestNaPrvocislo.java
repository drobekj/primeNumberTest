/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package sykoradc.testnaprvocislo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Jaroslav Drobek
 */
public class TestNaPrvocislo {

    public static void main(String[] args) {
        File path = new File(System.getProperty("user.home") + File.separator + "primeNumberTest" + File.separator + "zadani" + File.separator + "vzorek_dat.xlsx");
        path.getParentFile().mkdirs();
        try (FileInputStream file = new FileInputStream(path)){
            Workbook workbook = new XSSFWorkbook(file);
            Sheet sheet = workbook.getSheetAt(0);
            //prochazeni dat ve druhem sloupci
            for (Row row : sheet) {
                Cell cell = row.getCell(1);
                TestovaneCislo delenec = new TestovaneCislo(cell.getStringCellValue());
                if(delenec.testValidita() && delenec.testPrvocislo()) System.out.print(delenec);
            }
        } catch (IOException ex) {
            System.out.println("Chyba při čtení souboru: " + ex.getMessage());
        }
    }
}
