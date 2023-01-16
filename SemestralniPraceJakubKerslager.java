package SEM_final;
/**
 *2. Program searches for the longest same part in 2 given arrays 
 * @author Jakub Keršláger
 * Java 17.0.5 15/1/23
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
public class SemestralniPraceJakubKerslager {
    static Scanner sc = new Scanner(System.in);    

    static int Balls = 0;
    static int SnowmanCount = 1;
    static boolean end = false;
    static String ColorReset = "\u001B[0m";
    static String BkgBLACK = "\u001B[40m";
    static String BkgRED = "\u001B[41m";
    static String BkgGREEN = "\u001B[42m";
    static String BkgYELLOW = "\u001B[43m";
    static String BkgBLUE = "\u001B[44m";
    static String BkgPURPLE = "\u001B[45m";
    static String BkgCYAN = "\u001B[46m";
    static String BkgWHITE = "\u001B[47m";
    static String SnowColor = " ";
    static String PotColor = " ";

    public static void main(String[] args) {
    int Choice; 
        boolean off = false;
        do{ 
            menu();
            Choice = sc.nextInt();
            switch (Choice){
                case 1: semestralniUloha(); break;
                case 2: ChristmasMenu(); break; 
                case 0: off = true; break;
                default: System.out.println("Nevalidní volba");

            }
        }while(!off);
}
private static void menu(){
    System.out.println("Jaký program si přejete spustit?");
    System.out.println("Pro semestrální práci 1 - Nejdelší stejná část dvou polí napište 1");
    System.out.println("Pro Vánoční úlohu - Postav si sněhuláka napište 2");
    System.out.println("Pro ukončení programu 0");
}
private static void semestralniUloha(){
    List<Integer> a = new ArrayList<>();
    List<Integer> b = new ArrayList<>();
    int longest;
    boolean off = false;
    char choice;
    do{ 
        System.out.println("Pokračovat ve zpracování (a/n)");
        choice = sc.next().charAt(0);
        choice = Character.toLowerCase(choice);      
        switch (choice){
        case 'a' -> {    
            Lists(a,b);
            longest = longestSamePart(a,b);
            System.out.println("Nejdelší společný úsek obou posloupností má délku " + longest);
        }
        case 'n' -> off = true;
        default -> System.out.println("Nevalidní volba");
        }
    }while(!off);
//    a.addAll(Arrays.asList(0, 1, 0, 1, 2, 4, 8, 12, 65, 11, 6));
//    b.addAll(Arrays.asList(8, 12, 65, 4, 0, 1, 0, 1, 2, 78, 5));
//    firstSequence();    
//    secondSequence();
//    int[] X = listToArray(a);    
//    for (int i = 0; i < X.length; i++) {
//            System.out.println(X[i]+" ");
//    }
//    int[] Y = listToArray(b);    
//    for (int i = 0; i < Y.length; i++) {
//            System.out.println(Y[i]+" ");
//    }
//    longestSamePart();    
}

/**
 * Asks user to write two set of positive numbers, negative number stops adding more numbers. 
 */
private static void Lists(List a, List b){
    System.out.println("Zadej první posloupnost:");  
    a.clear();
    boolean adding = true;
    int num;    
    
    while (adding){
        while(!sc.hasNextInt()) {
        sc.next();
        }
        num = sc.nextInt();   
        if (num>=0)
            a.add(num);
        else adding=false;
    }  
    
    System.out.println("Zadej druhou posloupnost:");
    b.clear();
    adding=true;
    while (adding){
        while(!sc.hasNextInt()) {
        sc.next();
        }
        num = sc.nextInt();   
        if (num>=0)
            b.add(num);
        else adding=false;
    }  
}
/**
 * This part takes 2 arrays and goes trough them and finds how many numbers are in the same order in both of them
 */
private static int longestSamePart(List a, List b){
    int[] A = listToArray(a);
    int[] B = listToArray(b);
    int longest = 0;
    for (int i = 0; i < A.length; i++) {
        for (int j = 0; j < B.length; j++) {
            if (A[i]==B[j]){                              
                int x = samePart(A,B,i,j);
                if (longest < x){
                    longest = x;    
                }    
            }   
        }
    }    
return longest;    
}

    /**Converts list of integers to array
     * @param list
     * @return Array
     */
public static int[] listToArray(List list){
  int[] Array = new int[list.size()];
    for (int i = 0; i < list.size(); i++)
        Array[i] = (int) list.get(i);
return Array;    
}

    /**
     * This method goes trough 2 arrays from specific elements and counts for how long they are identical
     * @param Array1
     * @param Array2
     * @param indexOfArray1
     * @param indexOfArray2
     * @return count
     */
    public static int samePart(int[] Array1, int[] Array2, int indexOfArray1, int indexOfArray2) {
    int count=0;
    boolean same=true;
    while (same==true){
            if (Array1[indexOfArray1]==Array2[indexOfArray2]){
            count++; 
            if (indexOfArray1==Array1.length-1) break;
            else indexOfArray1++; 
            if (indexOfArray2==Array2.length-1) break; 
            else indexOfArray2++;
            }else same=false;
    }       
return count;
}

private static void ChristmasMenu(){
     int choice;    
        do {
            WantToBuild();
            choice = sc.nextInt();
            switch (choice){
                case 1: Snow();
                        Pot();
                        NumberOfBalls();
                        NumberOfSnowman();
                        Head();
                        Balls();
                        break;
                case 0: end = true; break;
                default: System.out.println("Nevalidní volba");}  
        }while(!end);   
}
 private static void WantToBuild() {
     System.out.println("Zdravíčko, chceš postavit sněhuláka?");
     System.out.println("Jestli ano, napiš 1, jestli ne, napiš 0.");
 }          

private static void Snow() {
    int choice;
        System.out.println("");
        System.out.println("Jakou barvu má sněhulák mít?");
        System.out.println("");
        System.out.println("Pro červenou napiš 1");
        System.out.println("Pro zelenou napiš 2");
        System.out.println("Pro žlutou napiš 3");
        System.out.println("Pro modrou napiš 4");
        System.out.println("Pro fialovou napiš 5");
        System.out.println("Pro světle modrou napiš 6");
        System.out.println("Pro bílou napiš 7");
        System.out.println("");
        
    choice = sc.nextInt();              
        switch (choice){
            case 1: SnowColor = BkgRED; break;
            case 2: SnowColor = BkgGREEN;break;
            case 3: SnowColor = BkgYELLOW; break;
            case 4: SnowColor = BkgBLUE; break;
            case 5: SnowColor = BkgPURPLE; break;
            case 6: SnowColor = BkgCYAN; break;
            case 7: SnowColor = BkgWHITE; break;
            default: System.out.println("Nevalidní volba");
        }
}        

private static void Pot() {
    int choice;
        System.out.println("");
        System.out.println("Jakou barvu má hrnec mít?");
        System.out.println("");
        System.out.println("Pro červenou napiš 1");
        System.out.println("Pro zelenou napiš 2");
        System.out.println("Pro žlutou napiš 3");
        System.out.println("Pro modrou napiš 4");
        System.out.println("Pro fialovou napiš 5");
        System.out.println("Pro světle modrou napiš 6");
        System.out.println("Pro bílou napiš 7");
        System.out.println("");
        
    choice = sc.nextInt();            
        switch (choice){
            case 1: PotColor = BkgRED; break;
            case 2: PotColor = BkgGREEN;break;
            case 3: PotColor = BkgYELLOW; break;
            case 4: PotColor = BkgBLUE; break;
            case 5: PotColor = BkgPURPLE; break;
            case 6: PotColor = BkgCYAN; break;
            case 7: PotColor = BkgWHITE; break;
            default: System.out.println("Nevalidní volba");
        }
}        

private static void NumberOfSnowman() {
        System.out.println("");
        System.out.println("Kolik sněhuláků chceš postavit?");
        System.out.println("");
        SnowmanCount = sc.nextInt();
}
private static void NumberOfBalls() {
        System.out.println("");
        System.out.println("Kolik koulí má sněhulák mít?");
        System.out.println("");
        Balls = sc.nextInt();
}
        
private static void Head() {        
        if (Balls>=1){     
            for (int i =1; i <= SnowmanCount; i++) System.out.printf("      " +PotColor + "                 " + ColorReset + "             "); System.out.printf("\n");
            for (int i =1; i <= SnowmanCount; i++) System.out.printf("    " +PotColor + "                     " + ColorReset + "           "); System.out.printf("\n");
            for (int i =1; i <= SnowmanCount; i++) System.out.printf("    " +PotColor + "                     " + ColorReset + "           "); System.out.printf("\n");
            for (int i =1; i <= SnowmanCount; i++) System.out.printf("      " +PotColor + "                 " + ColorReset + "             "); System.out.printf("\n");
            for (int i =1; i <= SnowmanCount; i++) System.out.printf("      " +PotColor + "                 " + ColorReset + "             "); System.out.printf("\n");
            for (int i =1; i <= SnowmanCount; i++) System.out.printf("      " +SnowColor + "                 " + ColorReset + "             "); System.out.printf("\n");
            for (int i =1; i <= SnowmanCount; i++) System.out.printf("     " +SnowColor + "   "+BkgBLACK+"  "+SnowColor+"         "+BkgBLACK+"  "+SnowColor+"   " + ColorReset + "            "); System.out.printf("\n");
            for (int i =1; i <= SnowmanCount; i++) System.out.printf("    " +SnowColor + "                     " + ColorReset +"           "); System.out.printf("\n");
            for (int i =1; i <= SnowmanCount; i++) System.out.printf("   " +SnowColor +"          "+BkgBLACK+"  "+SnowColor+"           " + ColorReset + "          "); System.out.printf("\n");
            for (int i =1; i <= SnowmanCount; i++) System.out.printf("   " +SnowColor +"                       " + ColorReset + "          "); System.out.printf("\n");
            for (int i =1; i <= SnowmanCount; i++) System.out.printf("    " +SnowColor + "                     " + ColorReset +"           "); System.out.printf("\n");
            for (int i =1; i <= SnowmanCount; i++) System.out.printf("     " +SnowColor + "    "+BkgBLACK+" "+SnowColor+"         "+BkgBLACK+" "+SnowColor+"    " + ColorReset + "            "); System.out.printf("\n");
            for (int i =1; i <= SnowmanCount; i++) System.out.printf("      " +SnowColor + "    "+BkgBLACK+"         "+SnowColor+"    " + ColorReset + "             "); System.out.printf("\n");
            for (int i =1; i <= SnowmanCount; i++) System.out.printf("        " +SnowColor + "             " + ColorReset + "               "); System.out.printf("\n");
        }
        else{
            System.out.println("Vážně chceš stavět sněhuláka bez jediné koule? Jestli se ti to povede, tak budeš prohlášen za druhého Ježíše Krista...");
            System.out.println("");
            System.out.println("");
        }
           
}
private static void Balls() {
            
    
    if (Balls >= 2){
                for (int i =1; i <= SnowmanCount; i++) System.out.printf("        " +SnowColor + "             " + ColorReset + "               " ); System.out.printf("\n");
                for (int i =1; i <= SnowmanCount; i++) System.out.printf("      " +SnowColor + "                 " + ColorReset + "             "); System.out.printf("\n");
                for (int i =1; i <= SnowmanCount; i++) System.out.printf("     " +SnowColor + "                   " + ColorReset + "            " ); System.out.printf("\n");
                for (int i =1; i <= SnowmanCount; i++) System.out.printf(" " +SnowColor + "            "+BkgBLACK+"  "+SnowColor +"             " + ColorReset +"        "); System.out.printf("\n");
                for (int i =1; i <= SnowmanCount; i++) System.out.printf("" +SnowColor +"                             " + ColorReset + "       "); System.out.printf("\n");
                for (int i =1; i <= SnowmanCount; i++) System.out.printf("" +SnowColor +"                             " + ColorReset + "       "); System.out.printf("\n");
                for (int i =1; i <= SnowmanCount; i++) System.out.printf(" " +SnowColor + "            "+BkgBLACK+"  "+SnowColor+"             " + ColorReset +"        "); System.out.printf("\n");
                for (int i =1; i <= SnowmanCount; i++) System.out.printf("     " +SnowColor + "                   " + ColorReset + "            " ); System.out.printf("\n");
                for (int i =1; i <= SnowmanCount; i++) System.out.printf("      " +SnowColor + "                 " + ColorReset +"             "); System.out.printf("\n");
                for (int i =1; i <= SnowmanCount; i++) System.out.printf("        " +SnowColor + "             " + ColorReset +"               ");  System.out.printf("\n");    
                
        for (int ii=3;  ii <= Balls;){
                for (int i =1; i <= SnowmanCount; i++) System.out.printf("        " +SnowColor + "             " + ColorReset + "               "); System.out.printf("\n");
                for (int i =1; i <= SnowmanCount; i++) System.out.printf("      " +SnowColor + "                 " + ColorReset + "             "); System.out.printf("\n");
                for (int i =1; i <= SnowmanCount; i++) System.out.printf("     " +SnowColor + "                   " + ColorReset + "            "); System.out.printf("\n");
                for (int i =1; i <= SnowmanCount; i++) System.out.printf("    " +SnowColor + "         "+BkgBLACK+"  "+SnowColor+"          " + ColorReset + "           "); System.out.printf("\n");
                for (int i =1; i <= SnowmanCount; i++) System.out.printf("   " +SnowColor +"                       " + ColorReset + "          "); System.out.printf("\n");
                for (int i =1; i <= SnowmanCount; i++) System.out.printf("   " +SnowColor +"                       " + ColorReset + "          "); System.out.printf("\n");
                for (int i =1; i <= SnowmanCount; i++) System.out.printf("    " +SnowColor + "         "+BkgBLACK+"  "+SnowColor+"          " + ColorReset + "           "); System.out.printf("\n");
                for (int i =1; i <= SnowmanCount; i++) System.out.printf("     " +SnowColor + "                   " + ColorReset + "            "); System.out.printf("\n");
                for (int i =1; i <= SnowmanCount; i++) System.out.printf("      " +SnowColor + "                 " + ColorReset + "             "); System.out.printf("\n");
                for (int i =1; i <= SnowmanCount; i++) System.out.printf("        " +SnowColor + "             " + ColorReset + "               "); System.out.printf("\n");   
                ii++;                 
        }
    }    
    else {      if (Balls == 0){
                System.out.println("");
                }
                else {
                System.out.println("Nějakej malej ne? To u tebe asi moc nenasněžilo....");
                System.out.println("");
                }
    }     
}
    
}