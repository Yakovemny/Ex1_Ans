import java.util.Scanner;

/**
 * This class represents a simple solution for Ex1.
 * As defined here: https://docs.google.com/document/d/1AJ9wtnL1qdEs4DAKqBlO1bXCM6r6GJ_J/r/edit/edit
 * In this assignment, we will design a number formatting converter and calculator.
 * In general, we will use Strings as numbers over basis of binary till Hexa.
 * [2-16], 10-16 are represented by A,B,..G.
 * The general representation of the numbers is as a String with the following format:
 * <number><b><base> e.g., “135bA” (i.e., “135”, as 10 is the default base), “100111b2”, “12345b6”,”012b5”, “123bG”, “EFbG”.
 * The following are NOT in the format (not a valid number):
 * “b2”, “0b1”, “123b”, “1234b11”, “3b3”, “-3b5”, “3 b4”, “GbG”, "", null,
 * You should implement the following static functions:
 */
public class Ex1 {
    /**
     * This method converts a number 'a' to its decimal representation
     * @param a
     * @return
     */
    public static int convert2Basis10(String a) {
        int ans = 0;

        if (!a.contains("b")) {
            a = a + "b10"; // Default to base 10 if no base is specified
        }

        String[] num = a.split("b");
        if (num.length != 2 || num[0].isEmpty()) {
            System.out.println("Invalid input format: " + a);
            return -1;
        }

        String numberPart = num[0];
        String basePart = num[1];

        int base;
        try {
            // Convert base part to decimal (handle letters A-G)
            base = basePart.matches("\\d+") ? Integer.parseInt(basePart) : basePart.charAt(0) - 'A' + 10;
        } catch (NumberFormatException e) {
            System.out.println("Invalid base format: " + basePart);
            return -1;
        }

        if (base < 2 || base > 16) {
            System.out.println("Base out of range: " + base);
            return -1;
        }

        for (int i = 0; i < numberPart.length(); i++) {
            int power = numberPart.length() - i - 1;
            char c = numberPart.charAt(i);

            int digitValue = Character.isDigit(c) ? c - '0' : Character.toUpperCase(c) - 'A' + 10;
            if (digitValue < 0 || digitValue >= base) {
                System.out.println("Invalid digit '" + c + "' for base " + base);
                return -1;
            }

            ans += digitValue * Math.pow(base, power);
        }

        return ans;
    }

    /**
     * Convert the given number (num) to a decimal representation (as int).
     * If the given number is not in a valid format returns -1.
     *
     * @param num a String representing a number in basis [2,16]
     * @return ans which represents the number in decimal base
     */
    public static int number2Int(String num) {
        int ans = 0, value = 0;
        // add your code here
        if (!isNumber(num)) {
            return -1;
        } else {
            ans = convert2Basis10(num );
        }

        return ans;
    }


    /**
     * determines if there are any 'space' characters if there are it returns true else returns false.
     * @param str
     * @return
     */
    public static boolean isEmpty(String str) {
        char[] getChars = str.toCharArray();
        for (int i = 0; i < getChars.length; i++) {
            if (str.charAt(i) == ' ')
                return true;
        }
        return false;
    }
    /**
     * determines if the base is valid [2-16]
     * @param base
     * @return
     */
    public static boolean isValidBase(String base) {

        if (base.length() == 1) {
            char baseChar = base.charAt(0);
            if ((baseChar >= '2' && baseChar <= '9') || (baseChar >= 'A' && baseChar <= 'G'))
                return true;
        }
        return false;
    }
    /**
     * determines if the number part of the string is valid for the base by making sure that the value of the number part is smaller than the base
     * @param numberPart
     * @param base
     * @return
     */
    public static boolean isValidForBase(String numberPart, int base) {
        for (char c : numberPart.toCharArray()) {
            int value = Character.isDigit(c) ? c - '0' : c - 'A' + 10; //either it's a num or a character
            if (value >= base) return false; // Invalid digit for base.
        }
        return true;
    }

    /**
     * This static function checks if the given String (a) is in a valid "number" format.
     * @param a a String representing a number
     * @return true if the given String is in a number format
     */
    public static boolean isNumber(String a) {
        boolean ans = false;
        char[] check = a.toCharArray();
        //does not contain any space chars. aka ' '
        if(isEmpty(a) || a.isBlank()){
            return false;
        }
        //to ensure that there won't be any case of two b's or al least one b
        int bIndex = a.indexOf('b');
        // if there are no b's in the input it will check if the input contains only numbers.
        if (bIndex <= 0 || bIndex == a.length() - 1 || a.indexOf('b') != a.lastIndexOf('b')) {
            if(isValidForBase(a , 10))
                return true;
            return false;
        }


        //has a number before b and that number is not empty
        //that the number before b is a positive number
        //that before and after b there is a base / a number
        //Ensures that the String has 2 parts theNumberPart <b> theBasePart
        String[] str = a.split("b");
        if (str[0].isEmpty() || str[1].isEmpty() && str.length != 2) {
            return false;
        }
        int base = str[1].matches("\\d") ? Integer.parseInt(str[1]) : str[1].charAt(0) - 'A' + 10;
        if (base < 2 || base > 16) return false;

        //the base can represent the num
        if (isValidBase(str[1]) && isValidForBase(str[0], base)) {
            ans = true;
        } else {
            return false;
        }


        return ans;
    }


/**
 * Calculate the number representation (in basis base)
 * of the given natural number (represented as an integer).
 * If num<0 or base is not in [2,16] the function should return "" (the empty String).
 * @param num the natural number (include 0).
 * @param base the basis [2,16]
 * @return a String representing a number (in base) equals to num, or an empty String (in case of wrong input).
 */
public static String int2Number(int num, int base) {
    String ans = ""; //we will use String Builder
    // add your code here
    if (num < 0 || base > 16 || base < 0) {
        return "";
    }
    if (num == 0) {
        return "0";
    }
    StringBuilder sb = new StringBuilder();
    while (num > 0) {
        int remainder = num % base;
        char digit = (remainder < 10)
                ? (char) ('0' + remainder)
                : (char) ('A' + remainder - 10); // Map 10–15 to A–F
        sb.append(digit);
        num /= base;
    }
    sb.reverse();
    sb.append("b");
    sb.append(base);
    return sb.toString();
}

/**
 * Checks if the two numbers have the same value.
 * @param n1 first number
 * @param n2 second number
 * @return true if the two numbers have the same values.
 */
public static boolean equals(String n1, String n2) {
    boolean ans = true;
    // add your code here
    int num1 = convert2Basis10(n1);
    int num2 = convert2Basis10(n2);
    return num1 == num2;
}

/**
 * This static function search for the array index with the largest number (in value).
 * In case there are more than one maximum - returns the first index.
 * Note: you can assume that the array is not null and is not empty, yet it may contain null or none-valid numbers (with value -1).
 * @param arr an array of numbers
 * @return the index in the array in with the largest number (in value).
 *
 */
    public static int maxIndex(String[] arr) {
        int max = Integer.MIN_VALUE , index = 0;
        for(int i = 0 ; i < arr.length ; i++) {
            if(max < Ex1.number2Int(arr[i])){
                max = Ex1.number2Int(arr[i]);
                index = i;
            }

        }
        ////////////////////
        return index;
    }
}
