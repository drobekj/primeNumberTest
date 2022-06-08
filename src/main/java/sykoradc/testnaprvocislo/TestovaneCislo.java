/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sykoradc.testnaprvocislo;

/**
 *
 * @author Jaroslav Drobek
 */
public class TestovaneCislo {

    private String vstup;
    private int cislo;
    
    public TestovaneCislo(String vstup) {
        this.vstup = vstup;
    }

    //test validity vstupniho udaje:
    public boolean testValidita(){
        try{ 
            cislo = Integer.parseInt(vstup); 
        }
        catch(NumberFormatException e) {
            return false; 
        }
        if(cislo < 1) return false;
        return true;
    }
    
    // vlastni test na prvocislo:
    public boolean testPrvocislo(){
        int delitel = 2;
        while(Math.floorMod(cislo,delitel)!=0 && delitel < Math.sqrt(cislo)){
            delitel++;
        }
        if(delitel > Math.sqrt(cislo)) return true;
        return false;        
    }

    //novy vystupni format instance
    @Override
    public String toString(){
        return String.format("%d\n",cislo);
    }
}
