# 环形链表

LeetCode 141 142

1）判断是否有环，则使用快慢指针，能相遇则有环。
  ```java
  public boolean hasCycle(ListNode head) {
    ListNode fast = head, slow = head;
    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
        if (fast == slow) return true;
    }
    return false;
  }
  ```
2）如果确定链表中有环，返回入环的第一个节点。
```java
public ListNode detectCycle(ListNode head) {
    ListNode fast = head, slow = head;
    while (true) {
        if (fast == null || fast.next == null)
            return null;
        slow = slow.next;
        fast = fast.next.next;
        if (fast == slow) break;
    }

    fast = head;
    while (fast != slow) {
        fast = fast.next;
        slow = slow.next;
    }
    return slow;
}
```