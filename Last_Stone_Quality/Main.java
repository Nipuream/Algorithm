package Last_Stone_Quality;

import java.util.*;

/**
 * 最后一块石头的重量
 * input: 2,7,4,1,8,1
 * output: 1
 */
public class Main {

    public static int lastStoneQuality(PriorityQueue<Integer> queue) {

        int last = 0;
        while (!queue.isEmpty()) {
            if(queue.size() == 1) {
                last = queue.poll();
                break;
            }
            int diff = Math.abs(queue.poll() - queue.poll());
            if(diff > 0) queue.offer(diff); 
        }
        return last;
    }


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().trim().split(",");

        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(Comparator.reverseOrder());
        for(String entity: input) {
            queue.offer(Integer.parseInt(entity));
        }
        int lastStoneQuality = lastStoneQuality(queue);
        System.out.println(lastStoneQuality);
    }
    
}
