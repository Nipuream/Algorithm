package Delete_Duplicate_Number;

import java.util.*;



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

/**
 * 
00101 14
99999 3 87654
87654 4 11111
55555 8 55556
55556 8 55557
55557 8 -1
44444 4 55555
23854 2 00000
11111 4 22222
00100 1 23854
00101 1 00102
00102 1 00100
22222 4 33333
00000 3 99999
33333 4 44444


00001 3
00001 3 00002
00002 3 00003
00003 3 -1


55555 0


*/

class Main {

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

    private static Node Delete_Duplicate_List(Node header) {
        if(header == null || header.next == null)
            return header;
        Node pre = null;
        Node start = header;
        Node tmp = start.next;
        int ans = 1;
        while(tmp != null) {
            if(start.data.equals(tmp.data)) {
                ans ++;
            } else {
                if(ans > 2) {
                    if(pre == null) {
                        header = start = tmp;
                    } else {
                        pre.next = tmp;
                        pre.nextAddress = tmp.address;
                        start = tmp;
                    }
                    ans = 1;
                } else {
                    pre = start;
                    start = tmp;
                    while(pre != null && pre.next != start) 
                        pre = pre.next;
                    ans = 1;
                }
            }
            tmp = tmp.next;
        }
        if(ans > 2) {
            if(pre == null) return null;
            pre.next = null;
            pre.nextAddress = "-1";
        }
        return header;
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
        head = Delete_Duplicate_List(head);

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