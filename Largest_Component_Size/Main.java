package Largest_Component_Size;

import java.util.Arrays;
import java.util.Scanner;

class UnionFind {

    int[] parent;
    int[] rank;

    public UnionFind(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        rank = new int[n];
    }

    public void union(int x, int y) {
        int rootx = find(x);
        int rooty = find(y);
        if (rootx != rooty) {
            if (rank[rootx] > rank[rooty]) {
                parent[rooty] = rootx;
            } else if (rank[rootx] < rank[rooty]) {
                parent[rootx] = rooty;
            } else {
                parent[rooty] = rootx;
                rank[rootx]++;
            }
        }
    }

    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
}

public class Main {

    private static int largestComponentSize(int[] nums) {
        int m = Arrays.stream(nums).max().getAsInt();
        UnionFind unionFind = new UnionFind(m + 1);
        for(int x: nums) {
            for(int y = 2; y * y <= x; y++) {
                if(x % y == 0) {
                    unionFind.union(x, y);
                    unionFind.union(x, x/y);
                }
            }
        }
        int ans = 0;
        int[] count = new int[m + 1];
        for(int num: nums) {
            int root = unionFind.find(num);
            count[root] ++;
            ans = Math.max(ans, count[root]);
        }
        return ans;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] nums = Arrays.stream(scanner.nextLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
        int result = largestComponentSize(nums);
        System.out.println(result);
    }

}
