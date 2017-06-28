// Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2.
//
// Note:
//
// The length of both num1 and num2 is < 110.
// Both num1 and num2 contains only digits 0-9.
// Both num1 and num2 does not contain any leading zero.
// You must not use any built-in BigInteger library or convert the inputs to integer directly.


public class MultiplyString{
    public String multiply(String num1, String num2){
        if(num1.isEmpty() || num2.isEmpty()){
            return "0";
        }

        String result = "";

        for(int i = num2.length() - 1; i >= 0; i--){
            String r1 = multiplyOneDigit(num1, num2.charAt(i));
            int tens = num2.length() - 1 - i;

            while(tens > 0){
                 r1 = multiplyTen(r1);
                 tens --;
            }
            result = add(result, r1);
        }
        return result;
    }

    private String multiplyOneDigit(String num, char c){
        int digit = 0;
        int m1 = Character.getNumericValue(c);
        StringBuffer sb = new StringBuffer();
        for(int i = num.length()-1; i >= 0; i--){
            int m2 = Character.getNumericValue(num.charAt(i));
            int v = m1 * m2 + digit;
            sb.insert(0, v % 10);
            digit = v / 10;
        }
        if(digit > 0){
            sb.insert(0, digit);
        }
        return sb.toString();
    }

    private String multiplyTen(String num){
        return num + "0";
    }

    private String add(String num1, String num2){

        int i = num1.length() - 1;
        int j = num2.length() - 1;

        StringBuffer sb = new StringBuffer();
        int digit = 0;
        while(i >= 0 && j >= 0){
            int a1 = Character.getNumericValue(num1.charAt(i--));
            int a2 = Character.getNumericValue(num2.charAt(j--));

            int v = a1 + a2 + digit;
            sb.insert(0, v % 10);
            digit = v / 10;
        }

        while(i >= 0){
            int a = Character.getNumericValue(num1.charAt(i--));
            int v = a + digit;
            sb.insert(0, v % 10);
            digit = v / 10;
        }

        while(j >= 0){
            int a = Character.getNumericValue(num2.charAt(j--));
            int v = a + digit;
            sb.insert(0, v % 10);
            digit = v / 10;
        }

        if(digit > 0){
            sb.insert(0, digit);
        }

        return sb.toString();
    }

    public static void main(String[] args){
        MultiplyString m = new MultiplyString();
        String num1 = "101";
        String num2 = "22";
        System.out.println(m.multiply(num1, num2));
    }

}
