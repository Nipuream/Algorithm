# 题目描述
将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 

LeetCode 21.
# 解题思路

```java
public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

    ListNode head = new ListNode();
    ListNode tmp = head;
    while (list1 != null && list2 != null) {
        if (list1.val <= list2.val) {
            tmp.next = list1;
            tmp = list1;
            list1 = list1.next;
        } else {
            tmp.next = list2;
            tmp = list2;
            list2 = list2.next;
        }
    }
    if (list1 != null) tmp.next = list1;
    if (list2 != null) tmp.next = list2;
    return head.next;
}
```