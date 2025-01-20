package Combine_Two_List;

import java.util.*;

class Node {
    String val;
    String address;
    String nextAddress;
    Node next;

    Node() {}
    Node(String val, String address, String nextAddress) {
        this.val = val;
        this.address = address;
        this.nextAddress = nextAddress;
    }
}

public class Main {

    private static Node combindTowList(Node node1, Node node2) {

        Stack<Node> stack = new Stack<>();
        while (node2 != null) {
            stack.push(node2);
            node2 = node2.next;
        }

        Node dummy = node1;
        int index = 1;
        while (dummy != null) {
            if(index % 2 == 0 && !stack.isEmpty()) {
                Node tmp = dummy.next;
                Node pop = stack.pop();

                dummy.next = pop;
                dummy.nextAddress = pop.address;
                
                if(tmp == null) {
                    pop.next = null;
                    pop.nextAddress = "-1";
                } else {
                    pop.next = tmp;
                    pop.nextAddress = tmp.address;
                    dummy = tmp;
                }
            } else {
                dummy = dummy.next;
            }
            index ++;
        }

        while (!stack.isEmpty()) {
            Node tmp = stack.pop();
            dummy.next = tmp;
            dummy.nextAddress = tmp.address;
            dummy = tmp;
        }
        return node1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] line = scanner.nextLine().trim().split(" ");
        int line_num = Integer.parseInt(line[2]);

        Node first_node_dummy = new Node();
        first_node_dummy.nextAddress = line[0];
        Node second_node_dummy = new Node();
        second_node_dummy.nextAddress = line[1];

        Queue<Node> queue = new LinkedList<>();
        for(int i = 0; i < line_num; i++) {
            String[] tmp = scanner.nextLine().trim().split(" ");
            Node node = new Node(tmp[1], tmp[0], tmp[2]);
            queue.offer(node);
        }

        int first_list_len = 0, second_list_len = 0;
        Node first_tmp_node = first_node_dummy, second_tmp_node = second_node_dummy;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if(node.address.equals(first_tmp_node.nextAddress)) {
                first_tmp_node.next = node;
                first_tmp_node = node;
                first_list_len ++;
                continue;
            }
            if(node.address.equals(second_tmp_node.nextAddress)) {
                second_tmp_node.next = node;
                second_tmp_node = node;
                second_list_len ++;
                continue;
            }
            queue.offer(node);
        }

        Node header;
        if(first_list_len < second_list_len) {
            header = combindTowList(second_node_dummy.next, first_node_dummy.next);
        } else {
            header = combindTowList(first_node_dummy.next, second_node_dummy.next);
        }

        while (header != null) {
            System.out.println(header.address + " " + header.val + " " + header.nextAddress);
            header = header.next;
        }
    }
}
