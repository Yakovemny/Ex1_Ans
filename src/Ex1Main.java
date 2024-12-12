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
                    System.out.println("ERR: num"+ 1+ " is in the wrong format" + " is Number: "+Ex1.isNumber(num1) + " value : " + Ex1.number2Int(num1));
                }
                if(!Ex1.isNumber(num2))
                {
                    index++;
                    System.out.println("ERR: num"+ 2+ " is in the wrong format" + " is Number: "+Ex1.isNumber(num2) + " value : " + Ex1.number2Int(num2));
                }
                else {
                    int b10numA = Ex1.number2Int(num1);
                    int b10numB = Ex1.number2Int(num2);
                    int mulNums = b10numA*b10numB;
                    int addNums = b10numA+b10numB;
                    //String[] numA = num1.split("b");
                    System.out.println("num1 : " + num1 + " value : " + Ex1.int2Number(Ex1.number2Int(num1) , 10));
                    System.out.println("num2 : " + num2 + " value : " + Ex1.int2Number(Ex1.number2Int(num2) , 10));
                    System.out.println("Enter a base for output: (a number [2,16]");
                    String base = sc.next();
                    int intBase = Ex1.number2Int(base);
                    while(!Ex1.isValidBase(intBase)){
                        System.out.println("The base should be between 2 and 16!");
                        System.out.println("Enter a base for output: (a number [2,16]");
                        base = sc.next();
                        intBase = Ex1.number2Int(base);
                    }
                    System.out.println(num1 + " + " + num2 + " = " + Ex1.int2Number(b10numA + b10numB, intBase));
                    System.out.println(num1 + " * " + num2 + " = " + Ex1.int2Number(b10numA * b10numB, intBase));
                    String[] arr = {num1, num2, Ex1.int2Number(mulNums, intBase), Ex1.int2Number(addNums, intBase)};
                    System.out.println("Max number over [" + num1 + "," + num2 + "," + Ex1.int2Number(b10numA + b10numB, intBase) + "," + Ex1.int2Number(b10numA * b10numB, intBase) + "] is : " + arr[Ex1.maxIndex(arr)]);

                }
            }
        }
        System.out.println("quiting now...");
    }
}
