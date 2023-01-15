package SEM_final;

import java.util.Scanner;

public class ulohy07_05 {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
//in
    System.out.println("zadej rozměry matice:");
        int m = sc.nextInt();
        int n = sc.nextInt();
        boolean found = true;
        
        System.out.println("Zadej čísla matice:");
        int [][] matrix = new int [m][n];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = sc.nextInt();}
        }  
    if (m != n){
        System.out.println("Matice není čtvercová, nelze vypořítat");
    }else{
        boolean [] falseArray = new boolean[m*n];
        for (int i = 0; i < falseArray.length; i++) {
            falseArray[i]=false;
//solving if matrix has all numbers from 1-n^2        
        }
        
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    if (falseArray[matrix[i][j]-1] == false){
                        falseArray[matrix[i][j]-1] = true;
                    }else{
                        found=false;
                    }
                }
            }
//out        
        if(found==true){
            System.out.println("Matice obsahuje všechny hodnoty");
        }else 
            System.out.println("Matice neobsahuje včechny hodnoty");
    }
}   

}
