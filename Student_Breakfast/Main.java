package Student_Breakfast;

import java.util.*;


/**
 * 统计无法吃午饭的学生
 * 
 * input:
 * 1 1 0 0
 * 0 1 0 1
 * 
 * output:
 * 0
 */
public class Main {

    public static int countStudent(int[] students, int[] sandswitchs){

        int[] cnt = new int[2];
        for(int student: students) cnt[student]++;

        for(int sandswitch: sandswitchs) {
            if(cnt[sandswitch] > 0) cnt[sandswitch]--;
            else break;
        }
        return cnt[0] + cnt[1];
    }
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        String[] studentstr = scanner.nextLine().trim().split(" ");
        String[] sandswitchstr = scanner.nextLine().trim().split(" ");

        int[] students = new int[studentstr.length];
        int[] sandswitchs = new int[sandswitchstr.length];

        for(int i = 0; i < students.length; i++) {
            students[i] = Integer.parseInt(studentstr[i]);
            sandswitchs[i] = Integer.parseInt(sandswitchstr[i]);
        }

        int count = countStudent(students, sandswitchs);
        System.out.println(count);
    }


}
