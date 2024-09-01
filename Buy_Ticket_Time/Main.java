package Buy_Ticket_Time;

import java.util.*;

/**
 * 2 3 2
 * 2
 */
public class Main {


    public static int buyTicketTime(int[] tickets, int k) {

        int time = 0;
        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0; i < tickets.length; i++) {
            queue.offer(i);
        }

        while(tickets[k] > 0) {
            int index = queue.poll();
            tickets[index] --;
            time ++;
            if(tickets[index] > 0) {
                queue.offer(index);
            }
        }
        return time;
    }
    


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] ticketStrs = scanner.nextLine().trim().split(" ");
        int index = Integer.parseInt(scanner.nextLine().trim());

        int[] tickets = new int[ticketStrs.length];
        for(int i = 0; i < ticketStrs.length; i++) {
            tickets[i] = Integer.parseInt(ticketStrs[i]);
        }

        int constTime = buyTicketTime(tickets, index);
        System.out.println(constTime);     
    }
    
}
