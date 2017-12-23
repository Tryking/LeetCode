# [344.Reverse String](https://leetcode.com/problems/reverse-string/description/)

## Description

Write a function that takes a string as input and returns the string reversed.

**Example:**

`Given s = "hello", return "olleh".`

### 思路
> Time:12/15/2017

> 题目让写一个方法：将给定的字符串的逆序字符串输出，这里我们只需要倒序遍历字符串然后用一个StringBuilder将其存起来，最后转化为String返回即可。

```
class Solution {
    public String reverseString(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i=s.length()-1; i>=0; i--){
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
```

`result: Your runtime beats 14% of java submissions.`

### 优秀思路（参考别人）
>暂未找到相关资源。