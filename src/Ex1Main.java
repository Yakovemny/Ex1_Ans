//package assignments.ex1;
import java.util.Scanner;

/**
 * Intro2CS, Ex1 - very basic "main template"
 * Make sure your implementation of this main performs as the Ex1Sol.jar solution implement all needed functions.
 *
 */
public class Ex1Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num1 = "", num2="", quit = "quit";
        int index = 1;
        while (!num1.equals(quit) && !num2.equals(quit)) {
            System.out.println();
            System.out.println("Ex1 class solution:");
            System.out.println("Enter a string as number"+index+" (or \"quit\" to end the program): ");
            num1 = sc.next();
            index++;
            System.out.println("Enter a string as number"+index+" (or \"quit\" to end the program): ");
            num2 = sc.next();
            index = 1;
            if (!num1.equals("quit") && !num2.equals("quit")) {
                // add your code here
                if(!Ex1.isNumber(num1)) {
                    System.out.println("ERR: num"+ index+ " is in the wrong format" + " is Number: "+Ex1.isNumber(num1) + " value : " + Ex1.number2Int(num1));
                }
                if(!Ex1.isNumber(num2))
                {
                    index++;
                    System.out.println("ERR: num"+ index+ " is in the wrong format" + " is Number: "+Ex1.isNumber(num2) + " value : " + Ex1.number2Int(num2));
                }
                else {
                    //String[] numA = num1.split("b");
                    System.out.println("num1 : " + num1 + " value : " + Ex1.number2Int(num1));
                    System.out.println("num2 : " + num2 + " value : " + Ex1.number2Int(num2));

                    break;
                }
                /////////////////////
            }
        }
        System.out.println("quiting now...");
    }
}
