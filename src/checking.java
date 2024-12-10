public class checking {
    public static void main(String[] args) {
        /*
        String str = "-3b3";

        System.out.println(str.charAt(2)); //'b'
        String[] strCharArray = str.split("b");
        System.out.println(strCharArray[0]); // "-3"
        System.out.println(Integer.parseInt(strCharArray[0])); // -3 as integer

        String str2 = "Is connected to this String ";
        System.out.println(str2.concat(str)); //returns the connected string between this and the string to connect
        System.out.println(str.equals("Hello"));
        System.out.println(str.isEmpty());
        System.out.println(str.isBlank());

        String connect = "b1234567";
        System.out.println(connect.replace("1" , "L")); //connect does not change the value in the
        //memory only changes it when it returns it, it could be beneficial to use it to put some value on another variable
        System.out.println(connect);

        String[] split = connect.split("b");
        for(int i = 0; i < split.length; i++){
            System.out.print(split[i] + " ");
        }
        System.out.println(split[0].isEmpty());
        //connect = "b1234567";
        connect = "123b";
        String[] st = connect.split("b"); //
        for(int i =0 ; i < st.length; i++){ //1234567
            System.out.print(st[i] + " ");
        }
        System.out.println("length"+st.length);
        System.out.println("...........");
        //System.out.println(Ex1.getBasis("12345b"));
        String num = "12b34";
        String chars = "abcd";
        String[] num1 = num.split("b");
        System.out.println(num.charAt(0));
        System.out.println(num1[0].charAt(0));


         */
        String[] s = {"1", "1b2", "01b2", "123bA", "ABbG", "0bA", "12b3" , "123b4" , "1234b5" , "12345b6" ,
                "123456b7","12b8" , "78b9" , "23bB" , "32bC" , "43bD", "45bE" , "56bF"};
        for(int i = 0; i < s.length; i++){
            System.out.println(Ex1.int2Number(Ex1.number2Int(s[i]) , 8));
        }

    }
}
