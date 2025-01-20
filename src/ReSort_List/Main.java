package ReSort_List;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Node {
    String address;
    String data;
    String nextAddress;
    Node next;

    Node(String address, String data, String nextAddress) {
        this.address = address;
        this.data = data;
        this.nextAddress = nextAddress;
    }
}

public class Main {

    private static Node buildList(String headerAddress, Queue<Node> queue) {
        Node header = null, next = null;
        while(!queue.isEmpty()) {
            Node node = queue.poll();
            if(header == null) {
                if(node.address.equals(headerAddress)) {
                    header = next = node;
                } else {
                    queue.offer(node);
                }
                continue;
            }

            if(next.nextAddress.equals(node.address)) {
                next.next = node;
                next = next.next;
            } else {
                queue.offer(node);
            }
        }
        return header;
    }

    private static Node Resort_List(Node header) {

        if(header == null) return header;
        LinkedList<Node> list = new LinkedList<>();
        Node dummy = header;
        Node new_header = null;
        while (dummy != null) {
            list.offer(dummy);
            dummy = dummy.next;
        }

        boolean fromEnd = true;
        while (!list.isEmpty()) {
            Node tmp = fromEnd ? list.pollLast() : list.pollFirst();
            fromEnd = !fromEnd;
            if(new_header == null) {
                new_header = dummy = tmp;
            } else {
                dummy.next = tmp;
                dummy.nextAddress = tmp.address;
                dummy = tmp;
            }
        }
        dummy.next = null;
        dummy.nextAddress = "-1";
        return new_header;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] line1 = scanner.nextLine().trim().split(" ");
        String headerAddress = line1[0];
        int len = Integer.parseInt(line1[1]);
        
        Queue<Node> queue = new LinkedList<>();
        for(int i = 0; i < len; i++) {
            String[] line = scanner.nextLine().trim().split(" ");
            Node node = new Node(line[0], line[1], line[2]);
            queue.offer(node);
        }

        Node head = buildList(headerAddress, queue);   
        head = Resort_List(head);
        while(head != null) {
            if(head.nextAddress.equals("-1")) {
                System.out.print(head.address + " " + head.data + " " + head.nextAddress);
            } else {
                System.out.println(head.address + " " + head.data + " " + head.nextAddress);
            }
            head = head.next;
        }
    }
    
}
