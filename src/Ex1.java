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
         * Convert the given number (num) to a decimal representation (as int).
         * If the given number is not in a valid format returns -1.
         * @param num a String representing a number in basis [2,16]
         * @return ans which represents the number in decimal base
         */
        public static int number2Int(String num) {
            int ans = 0 , value = 0;
            // add your code here
            if(!isNumber(num)) {
                return -1;
            }
            else
            {
                //int basis = getBasis(num);
                for(int i =0 ; i < num.length(); i++){
                   // ans += Integer.parseInt(String.valueOf(getLeftSide(str[]).));
                }
            }

            ////////////////////
            return ans;
        }


    /**
     * determines if there are any 'space' characters if there are it returns true else returns false.
     * @param str
     * @return
     */
    public static boolean isEmpty(String str){
            char[] getChars = str.toCharArray();
            for(int i = 0;i < getChars.length; i++){
                if(str.charAt(i) == ' ')
                    return true;
            }
            return false;
        }
    public static boolean isValidBase(String base){
        if(base.length() == 1){
            char baseChar = base.charAt(0);
           if ((baseChar >= '2' && baseChar <= '9') || (baseChar >= 'A' && baseChar <= 'G'))
            return true;
        }
        return false;
    }


    /**
     * determines if the letters in the String are in the required format
     * @param str
     * @return
     *
     */
    public static boolean validFormatCharacters(String str){
        return false;
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
            if(isEmpty(a)){
                return false;
            }
            else {
                //Not null
                if (a.isBlank() || a.isEmpty())
                    return false;
                //Contains 'b'
                for (int i = 0; i < a.length(); i++) {
                    if (check[i] == 'b') {
                        ans = true;
                        break;
                    }
                }

                //has a number before b and that number is not empty
                //that the number before b is a positive number
                //the number before b and after b are not equal
                //that before and after b there is a base
                String[] str = a.split("b");
                if (a.length() > 2 && str.length > 1 && isValidBase(str[1])) {
                    if (str[0].equals("") || str[0].equals("0") || Integer.parseInt(str[0]) < 0 || str[0].equals(str[1]))
                        return false;
                    else {
                        ans = true;
                    }
                } else {
                    return false;
                }


                return ans;
            }
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
            String ans = "";
            // add your code here

            ////////////////////
            return ans;
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

            ////////////////////
            return ans;
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
            int ans = 0;
            // add your code here

            ////////////////////
            return ans;
        }
}
