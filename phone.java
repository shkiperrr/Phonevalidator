/*
Программа проверяет на валидность мобильные номера с кодом страны Украины. (+380 *********)
*/

import java.util.Scanner;

public class phone {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        int flag = 0;
        int res = 0;


        do {
            flag = 0;

            String str = scanner.next();
            char[] arc = str.toCharArray();
            String str2 = str.substring(0, 1);
            String str3 = str.substring(1, 4);
            String str4 = str.substring(4, str.length());
            String str5 = str3 + str4;

            if (str.length() == 13) flag++;

            if (str2.equals("+")) {
                flag++;
            }

            if (str3.equals("380")) {
                flag++;
            }

            for(int i=1;i<str.length();i++) {
                if( !Character.isDigit(arc[i])) flag--;
            }


            int len = str5.length();
            int sum = 0;
            int[] num = new int[len];

            if (flag == 3) {
                System.out.println("Phone number is correct");
                for (int i = 0; i < len; i++) {
                    num[i] = str5.charAt(i) - '0';
                    sum += num[i];
                }

                System.out.println("1st round of calculation, sum is:" + sum);

                while (!((sum / 10) == 0)) {
                    int j = 2;
                    sum = sum / 10 + sum % 10;
                    System.out.println(j + "st round of calculation, sum is:" + sum);
                    j++;
                }
                res = sum;
            }

            else {
                System.out.println("Phone number is incorrect. Please enter the phone number");
            }

        } while(!(flag == 3));

        switch (res) {
            case 1: System.out.println("Final result is: One"); break;
            case 2: System.out.println("Final result is: Two"); break;
            case 3: System.out.println("Final result is: Three"); break;
            case 4: System.out.println("Final result is: Four"); break;
            default: System.out.println("Final result is: " + res);
        }
    }
}
