package Connection_Min_Number;

import java.util.*;

/**
 * [[0,1],[0,2],[0,3],[1,2],[1,3]]
 * 
 * input:
6 5
0 1
0 2
0 3
1 2
1 3
 */
public class Main {

    private static boolean[] visited;
    private static List<Integer>[] edges;

    private static int Find_Min_Num() {
        int ans = 0;
        for(int i = 0; i < edges.length; i++) {
            if(!visited[i]) {
                dfs(i);
                ans ++;
            }
        }
        return ans - 1;
    }

    private static void dfs(int u) {
        visited[u] = true;
        for(int v : edges[u]) {
            if(!visited[v]){
                dfs(v);
            }
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] line1 = scanner.nextLine().trim().split(" ");
        int computer_num = Integer.parseInt(line1[0]);
        int line_num = Integer.parseInt(line1[1]);

        edges = new List[computer_num];
        for(int i = 0; i < computer_num; i++) {
            edges[i] = new ArrayList<>();
        }

        for(int i = 0; i < line_num; i++) {
            String[] line = scanner.nextLine().trim().split(" ");
            edges[Integer.parseInt(line[0])].add(Integer.parseInt(line[1]));
            edges[Integer.parseInt(line[1])].add(Integer.parseInt(line[0]));
        }

        if(line_num < computer_num - 1) {
            System.out.println("-1");
            return;
        }

        visited = new boolean[computer_num];
        int result = Find_Min_Num();
        System.out.println(result);
    }

}
