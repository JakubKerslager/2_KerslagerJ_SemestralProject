package SEM_final;

import java.util.Scanner;


public class ulohy07_08 {

static Scanner sc = new Scanner(System.in);
public static void main(String[] args) {
    int radky;
    int sloupce;
    boolean constant=true;
    int constantCount=0;

//in   
    System.out.println("Zadejte rozměry matice:");
    sloupce=sc.nextInt();
    radky=sc.nextInt();
    double[][] matrix = new double[sloupce][radky];
    
    System.out.println("Zadejte čísla matice");    
    for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = sc.nextInt();}
        }
    //top to bottom diagonals
   
    for (int i = 1; i < sloupce && i < radky; i++) {
        if(matrix[0][0] != matrix[i][i]){
          constant=false;
          break;
        }else   if (i == matrix.length-1 || i == matrix[i].length-1){
                    if (constant == true){
                        constantCount++;
                    }else constant = true;
                }
    }
    double base2;
    int m;
    int n;
    
    for (int i = 1; i < sloupce-1; i++) {
        base2 = matrix[i][0];
        m=i+1;
        n=1;
        constant = true;
        while (constant == true){           
            if (base2 == matrix[m][n]){
                if (m == matrix.length-1 || n == matrix[m].length-1){
                    constantCount++;
                    break;
                }else{
                    m++;
                    n++;
                }
            }else{
            constant = false;
            }
        }        
    }
    for (int i = 1; i < radky-1; i++) {
        base2 = matrix[0][i];
        m=1;
        n=i+1;
        constant = true;
        while (constant == true){           
            if (base2 == matrix[m][n]){
                if (m == matrix.length-1 || n == matrix[m].length-1){
                    constantCount++;
                    break;
                }else{
                    m++;
                    n++;
                }
            }else{
            constant = false;
            }
        }        
    }

//bottom to top diagonals    
    int j = radky-1;
    int base = j;
    j--;
    constant = true;
    for (int i = 1; i < matrix.length ; i++) {
        if(matrix[0][base] != matrix[i][j]){
          break;
        }else{
            if (i == matrix.length-1 || j == 0){
                if (constant == true){
                    constantCount++;
                    }
            }else j--;
        }
    }
  
    for (int i = 1; i < radky-1 ; i++) {
        base2 = matrix[0][i];
        m=1;
        n=i-1;
        constant = true;
        while (constant == true){           
            if (base2 == matrix[m][n]){
                if (m == matrix.length-1 || n == 0){
                    constantCount++;
                    break;
                }else{
                    m++;
                    n--;
                }
            }else{
            constant = false;
            }
        }        
    }    
    
    for (int i = 1; i < sloupce-1; i++) {
        base2 = matrix[i][radky-1];
        m=i+1;
        n=sloupce-2;
        constant = true;
        while (constant == true){           
            if (base2 == matrix[m][n]){
                if (m == matrix.length-1 || n == i ){
                    constantCount++;
                    break;
                }else{
                    m++;
                    n--;
                }
            }else{
            constant = false;
            }
        }        
    }    

//out    
    System.out.println("matice má " + constantCount + " konstantních posloupností");


}    
}
