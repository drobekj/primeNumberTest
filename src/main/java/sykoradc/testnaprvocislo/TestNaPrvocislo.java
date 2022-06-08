/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package sykoradc.testnaprvocislo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 *
 * @author Jaroslav Drobek
 */
public class TestNaPrvocislo {

    public static void main(String[] args) {
        Path path = Path.of(System.getProperty("user.home"), "primeNumberTest", "zadani", "vzorek_dat.txt");
        try {
            List<String> lines = Files.readAllLines(path);

            //prochazeni dat
            for(String line: lines){
                TestovaneCislo delenec = new TestovaneCislo(line);
                if(delenec.testValidita() && delenec.testPrvocislo()) System.out.print(delenec);
            }
        } catch (IOException ex) {
            System.out.println("Chyba při čtení souboru: " + ex.getMessage());
        }
    }
}
