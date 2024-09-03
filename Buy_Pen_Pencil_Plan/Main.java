package Buy_Pen_Pencil_Plan;

import java.util.Scanner;

public class Main {
    
    private static long Buy_Pen_Pencil_Plan(int prices, int pen, int pencil) {
        long plan_num = 0;
        for(int i = 0; i <= prices / pen; i++) {
            int left_price = prices - i * pen;
            int pencil_num = left_price / pencil + 1;
            plan_num += pencil_num;
        }
        return plan_num;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().trim().split(",");
        long plan_num = Buy_Pen_Pencil_Plan(Integer.parseInt(input[0]), Integer.parseInt(input[1]), Integer.parseInt(input[2]));
        System.out.println(plan_num);
    }
}
