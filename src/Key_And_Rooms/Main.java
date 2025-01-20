package Key_And_Rooms;

import java.util.*;


public class Main {
    
    
    private static List<Integer>[] list;
    private static boolean[] visited;

    private static void Find_Rooms(int index) {
        if(visited[index]) return;
        visited[index] = true;
        List<Integer> tmp = list[index];
        for(int val: tmp) {
            if(!visited[val]){
                Find_Rooms(val);
            }
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().trim().split(";");

        list = new List[input.length];
        visited = new boolean[list.length];
        for(int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<>();
            String[] tmp = input[i].replaceAll("\\[|\\]", "").split(",");
            for(String t: tmp) {
                if(!t.equals(""))
                    list[i].add(Integer.parseInt(t));
            }
        }

        Find_Rooms(0);
        boolean result = true;
        for(boolean val: visited) {
            if(!val) {
                result = val;
                break;
            }
        }
        System.out.println(result);
    }
}
