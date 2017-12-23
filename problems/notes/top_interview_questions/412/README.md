# [412.Fizz Buzz](https://leetcode.com/problems/fizz-buzz/description/)

## Description

Write a program that outputs the string representation of numbers from 1 to n.

But for multiples of three it should output "Fizz" instead of the number and for the multiples of five output "Buzz". For numbers which are multiples of both three and five output "FizzBuzz".

**Example:**

```
n = 15,

Return:
[
    "1",
    "2",
    "Fizz",
    "4",
    "Buzz",
    "Fizz",
    "7",
    "8",
    "Fizz",
    "Buzz",
    "11",
    "Fizz",
    "13",
    "14",
    "FizzBuzz"
]
```

### 思路
> Time:12/22/2017

> 题目让写出从1到n的数字的字符串表示，并且如果数字是3的倍数的话输出“Fizz”，如果是5的倍数的话，输出“Buzz”。如果该数字同时是3和5的倍数的话，输出“FizzBuzz”。
> 其实这道题不难，我们只要遍历从1到n，然后判断这个数字是否是3以及5的倍数，然后做相应的转换就可以了。

```
class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList(n);
        for(int i = 1; i <= n; i++){
            if(i % 3 == 0 || i % 5 == 0){
                if(i % 3 == 0 && i % 5 == 0){
                    result.add("FizzBuzz");
                }else if(i % 3 == 0){
                    result.add("Fizz");
                }else{
                    result.add("Buzz");
                }
            }else{
                result.add(String.valueOf(i));
            }
        }
        return result;
    }
}
```
`result: Your runtime beats 29.60 % of java submissions.`

### 优秀思路（参考别人）
> 网上看了别人的，感觉基本和我这个也差不多。但是好像他们大多是直接写了一个if加好多else。我的想法是如果
不是3和5的倍数的话，只需要走一个 `i % 3 == 0`的判断就可以了，这样可以加快速度，因此if里面嵌套了if。