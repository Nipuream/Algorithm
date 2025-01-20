package Work_Circle;


public class DfsSolution {
    
    public int calWorkCircleNum(int[][] graph) {
        int length = graph.length;
        boolean[] visit = new boolean[length];
        int circle = 0;
        for(int i = 0; i < length; i ++) {     
            if(!visit[i]) {
                dfs(i, graph, visit);
                circle ++;
            }
        }
        return circle;
    }

    private void dfs(int i, int[][] graph, boolean[] visit) {
        if(visit[i]) return;
        visit[i] = true;
        int length = graph.length;
        for(int j = 0; j < length; j ++) {
            if(graph[i][j] == 1 && !visit[j]) {
                dfs(j, graph, visit);
            }
        }
    }

}
