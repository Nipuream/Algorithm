# 反转链表

给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。

LeetCode 206


```java
public ListNode reverseList(ListNode head) {
  ListNode cur = null, pre = null;
  while (head != null) {
      pre = cur;
      cur = head;
      head = head.next;
      cur.next = pre;
  }
  return cur;
}
```