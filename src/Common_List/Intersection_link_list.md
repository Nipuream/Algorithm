# 相交链表

给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。

LeetCode 160.

---

pa 和 pb 同时走完 m+n 的路程，要不相遇，要不同时等于 null.
```java
public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    ListNode pa = headA, pb = headB;
    while (pa != pb) {
        pa = pa == null ? headB : pa.next;
        pb = pb == null ? headA : pb.next;
    }
    return pa;
}
```