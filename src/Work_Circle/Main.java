package Work_Circle;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 工作圈
 */
class Main {

   public static void main(String[] args) {
    
    Scanner in = new Scanner(System.in);
    String input = in.nextLine();
    String[] raw = input.split("\\|");

    int[][] graph = new int[raw.length][];
    for(int i = 0; i < raw.length; i++) {
        String[] lineStr = raw[i].split(" ");
        graph[i] = new int[lineStr.length];
        int var = 0;
        for(String str: lineStr) {
            graph[i][var] = Integer.parseInt(str);
            var ++;
        }
    }


    DfsSolution dfs = new DfsSolution();
    int number = dfs.calWorkCircleNum(graph);

    System.out.println(number);
   }


}