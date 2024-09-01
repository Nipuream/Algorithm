package Min_Coin_Number;

import java.util.Scanner;

/**
 * input: 0, output: 0
 * input: 100, output: 20
 * input: 14, output: 4
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        long number = 0;
        try {
            number = Long.parseLong(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println(0);
            return;
        }

        if(number < 0 || number > Integer.MAX_VALUE) {
            System.out.println(0);
            return ;
        }
        
        long num = number/5 + number%5/2 + number%5%2;
        System.out.println(num);
    }
}
