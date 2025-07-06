package Common_Arrays;

import java.util.*;

public class Main {
  
  private static final PriorityQueue<Integer> left = new PriorityQueue<>((a, b) -> b - a); // 最大堆
  private static final PriorityQueue<Integer> right = new PriorityQueue<>(); // 最小堆

  public static void addNum(int num) {
      if (left.size() == right.size()) {
          right.offer(num);
          left.offer(right.poll());
      } else {
          left.offer(num);
          right.offer(left.poll());
      }
  }

  public static void main(String[] args) {
    addNum(0);
    addNum(1);
    System.out.println("left: " + left.size() + ", right: " + right.size());
  }
}
