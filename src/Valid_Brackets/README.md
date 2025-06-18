# 有效的括号

## 题目描述

给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。

有效字符串需满足：

1. 左括号必须在**之后**有相同类型的右括号配对，配对仅能一次
2. 所有类型的括号必须以正确的顺序配对，先有左括号，再有右括号
3. 括号要按顺序配对，不能出现不同类型的括号相互交叠

__case1__
> input: s = "()" <br/>
> output: true

__case2__
> input: s = "()[]{}" <br/>
> output: true

__case3__
> input: s = "([])" <br/>
> output: true


## 题解

利用栈的特性来解决这个问题。
- 若字符串是有效的括号，则长度肯定是偶数，不是偶数可直接返回 false.
- 遍历字符串，如果是括号映射的左半部分则押入栈内，若不是则弹出栈顶元素比较是否满足映射。
- 如果栈内元素为空返回 true， 不为空返回 false.

```java
  public boolean isValid(String s) {
      Stack<Character> stack = new Stack<>();
      for (char c : s.toCharArray()) {
          if (c == '(' || c == '{' || c == '[') {
              stack.push(c);
          } else {
              if (stack.isEmpty()) return false;
              if (c == ')' && stack.peek() != '(') return false;
              if (c == '}' && stack.peek() != '{') return false;
              if (c == ']' && stack.peek() != '[') return false;
              stack.pop();
          }
      }
      if (!stack.isEmpty()) return false;
      return true;
  }
```
