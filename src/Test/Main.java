package Test;
import java.util.*;

class Node {
    
    String val;
    String address;
    String nextAddress;

    Node(String val, String address, String nextAddress) {
        this.val = val;
        this.address = address;
        this.nextAddress = nextAddress;
    }
}

class Main {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] line1 = scanner.nextLine().split(" ");
        String address1 = line1[0];
        String address2 = line1[1];
        int num = Integer.parseInt(line1[2]);
        System.out.println("address1: " + address1 + ", address2: " + address2 + ", num: "+ num);

        LinkedList<Node> queue = new LinkedList<>();
        for(int i = 0; i < num; i++) {
            String[] input = scanner.nextLine().split(" ");
            queue.offer(new Node(input[1], input[0], input[2]));
        }
        System.out.println(queue.size());

        LinkedList<Node> list1 = new LinkedList<>();
        LinkedList<Node> list2 = new LinkedList<>();
        while(!queue.isEmpty()) {
            Node node = queue.poll();
            if(node.address.equals(address1)) {
                list1.offer(node);
                address1 = node.nextAddress;
            } else if(node.address.equals(address2)) {
                list2.offer(node);
                address2 = node.nextAddress;
            } else {
                queue.offer(node);
            }
        }
        System.out.println("list1.size:" + list1.size() + ", list2.size:" + list2.size());

        // LinkedList<Node> longest = null, shortless = null;
        // if(list1.size() < list2.size()) {
        //     longest = list2;
        //     shortless = list1;
        // } else {
        //     longest = list1;
        //     shortless = list2;
        // }

        // LinkedList<Node> last = new LinkedList<>();
        // int index = 0;
        // while(!longest.isEmpty() && !shortless.isEmpty()) {
        //     if(index < 2) {
        //         Node tmp = longest.poll();
        //         Node pre = last.peekLast();
        //         if(pre != null) {
        //             //pre.next = tmp;
        //             pre.nextAddress = tmp.address;
        //         }
        //         last.offer(tmp);
        //         index ++;
        //     } else {
        //         Node tmp = shortless.pollLast();
        //         Node pre = last.peekLast();
        //         if(pre != null) {
        //             //pre.next = tmp;
        //             pre.nextAddress = tmp.address;
        //         }
        //         last.offer(tmp);
        //         index = 0;
        //     }
        // }
        // if(!shortless.isEmpty()) {
        //     last.addAll(shortless);
        // }
        // if(!longest.isEmpty()){
        //     last.addAll(longest);
        // }

        // for(int i = 0; i < last.size(); i++) {
        //     Node tmp = last.get(i);
        //     System.out.println(tmp.address + " " + tmp.val + " " + tmp.nextAddress);
        // }
        
        
    }
}