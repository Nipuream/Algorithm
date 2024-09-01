package Chg_Sum;

import java.util.Scanner;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

/**
 * 交换和
 * 
 */
public class Main {


    public static List<Integer> chgSum(int[] l1_i, int[] l2_i) {

        int sum1 = 0;
        int sum2 = 0;
        for(int i = 0; i < l1_i.length; i++) {
            sum1 += l1_i[i];
        }
        for(int i = 0; i< l2_i.length; i++) {
            sum2 += l2_i[i];
        }

        int diff = sum1 - sum2;
        int diff_val = Math.abs(diff) / 2;
        if(diff == 0 && diff % 2 != 0) return null;

        List<Integer> list = new ArrayList<Integer>();
        for(int i = 0; i < l1_i.length; i++) {
            for(int j = 0; j < l2_i.length; j++) {

                int compare = -1;
                if(list.size() > 0) {
                    compare = list.get(list.size() - 2);
                }

                if(diff > 0) {
                    if(l1_i[i] < l2_i[j]) continue;
                    if(l1_i[i] - l2_i[j] == diff_val && compare != l1_i[i]) {
                        list.add(l1_i[i]);
                        list.add(l2_i[j]);
                    } 
                } else {
                    if(l2_i[j] < l1_i[i]) continue;
                    if(l2_i[j] - l1_i[i] == diff_val && compare != l1_i[i]) {
                        list.add(l1_i[i]);
                        list.add(l2_i[j]);
                    }
                }
            }
        }
        return list;
    }


    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        String[] l1 = scanner.nextLine().trim().split(" ");
        String[] l2 = scanner.nextLine().trim().split(" ");

        int[] l1_i = new int[l1.length];
        for(int i = 0; i < l1.length; i++) {
            l1_i[i] = Integer.parseInt(l1[i]);
        }
        
        int[] l2_i = new int[l2.length];
        for(int i = 0; i < l2.length; i++) {
            l2_i[i] = Integer.parseInt(l2[i]);
        }

        Arrays.sort(l1_i);
        Arrays.sort(l2_i);

        List<Integer> list = chgSum(l1_i, l2_i);
        if(list.size() == 0) {
            System.out.println();
            return;
        }
        for(int i = 0; i < list.size(); i += 2) {
            System.out.println(list.get(i) + " " + list.get(i+1));
        }
    }
    
}
