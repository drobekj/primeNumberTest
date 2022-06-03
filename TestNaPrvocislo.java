package cz.itnetwork.testnaprvocislo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

public class TestNaPrvocislo {

    public static void main(String[] args) {
        Path path = Path.of(System.getProperty("user.home"), "testNaPrvocislo", "zadani", "vzorek_dat.txt");
        try {
            List<String> lines = Files.readAllLines(path);

            //prochazeni dat
            for(String line: lines){
                int delenec;

                //ignorovani nevalidnich dat:
                try{ 
                    delenec = Integer.parseInt(line); 
                }
                catch(NumberFormatException e) {
                    continue; 
                }
                if(delenec<1) continue;

                //test na prvocislo:
                int cislo = 2;
                while(Math.floorMod(delenec,cislo)!=0 && cislo < Math.sqrt(delenec)){
                    cislo++;
                }
                if(cislo > Math.sqrt(delenec)){
                    System.out.println(delenec);
                }
            }
        } catch (IOException ex) {
            System.out.println("Chyba při čtení souboru: " + ex.getMessage());
        }
    }
}