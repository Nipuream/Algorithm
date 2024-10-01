package Revese_List;

import java.util.*;

class Node {
    String address;
    String nums;
    String nextAddress;
    Node next;

    Node(String address, String nums, String nextAddress) {
        this.address = address;
        this.nums = nums;
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

    private static Node reverseList(Node header, int k, int len) {

        if(header == null) return header;
        Stack<Node> stack = new Stack<>();
        
        Node cur = header;
        Node dummy = null, new_header = null;

        int loop = 0;
        while (cur != null) {
            loop ++;
            stack.push(cur);
            cur = cur.next;
            if(stack.size() >= k) {
                while (!stack.isEmpty()) {
                    Node tmp = stack.pop();
                    if(new_header == null) {
                        new_header = dummy = tmp;
                        continue;
                    }
                    dummy.next = tmp;
                    dummy.nextAddress = tmp.address;
                    dummy = tmp;
                }
                if(len - loop < k) break;
            }
        }

        if(loop == len) {
            dummy.next = null;
            dummy.nextAddress = "-1";
        } else {
            dummy.next = cur;
            dummy.nextAddress = cur.address;
        }
        return new_header;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] line1 = scanner.nextLine().trim().split(" ");
        String headerAddress = line1[0];
        int len = Integer.parseInt(line1[1]);
        int k = Integer.parseInt(line1[2]);
        
        Queue<Node> queue = new LinkedList<>();
        for(int i = 0; i < len; i++) {
            String[] line = scanner.nextLine().trim().split(" ");
            Node node = new Node(line[0], line[1], line[2]);
            queue.offer(node);
        }

        Node head = buildList(headerAddress, queue);
        head = reverseList(head, k, len);
        System.out.println("=======");
        while(head != null) {
            if(head.nextAddress.equals("-1")) {
                System.out.print(head.address + " " + head.nums + " " + head.nextAddress);
            } else {
                System.out.println(head.address + " " + head.nums + " " + head.nextAddress);
            }
            head = head.next;
        }

    }
}
