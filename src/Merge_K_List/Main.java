package Merge_K_List;

import java.util.*;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { 
        this.val = val;
        this.next = next;
    }
}


public class Main {

    private static ListNode Merge_K_List(ListNode[] list) {

        if(list == null || list.length == 0) return null;
        PriorityQueue<ListNode> queue = new PriorityQueue<>((a, b) -> a.val - b.val);
                for(ListNode node: list) {
                    if(node != null)
                        queue.offer(node);
                }
        
                ListNode summary = new ListNode(); //哨兵节点, 它的next即是要返回的链表头节点
                ListNode cur = summary;
        
                while(!queue.isEmpty()) {
                    ListNode min = queue.poll();
                    if(min.next != null) {
                        queue.offer(min.next);
                    }
                    cur.next = min;
                    cur = cur.next;
                }
        return summary.next;
    }



//测试case:
// []
// [[]]
// [[1,4,5],[1,3,4],[2,6],[]]
// [[1,4,5],[1,3,4],[2,6]]

//第二个测试用例应该是 "[]”
//第三个测试用例应该是类似于 "[[1,4,5],[1,3,4],[2,6],[]]"
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().trim();

        String[] array_str = input.split("\\],\\[");
        if(array_str.length == 1) {
            System.out.println("[]");
            return;
        }

        ListNode[] list = new ListNode[array_str.length];
        int index = 0;
        for(String str: array_str) {
            System.out.println("str: " + str);
            str = str.replaceAll("\\[\\[", "").replaceAll("\\]\\]", "");
            if(str.equals("")) continue;
            String[] split_str = str.split(",");
            if(split_str.length == 0) continue;

            ListNode node = new ListNode();
            ListNode cur = node;

            for(String split: split_str) {
                cur.next = new ListNode();
                cur = cur.next;
                cur.val = Integer.parseInt(split);
            }
            list[index++] = node.next;
        }
        ListNode last = Merge_K_List(list);
        if(last == null) {
            System.out.print("[]");
        } else {
            System.out.print("[" + last.val);
            last = last.next;
            while(last != null) {
                System.out.print(", " + last.val);
                last = last.next;
            }
            System.out.print("]");
        }
    }

}
