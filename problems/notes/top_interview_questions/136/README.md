# [36.Single Number](https://leetcode.com/problems/single-number/description/)

## Description

Given an array of integers, every element appears twice except for one. Find that single one.

**Note:**
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?


### 思路
> Time:12/23/2017

> 首先想到的是用一个list来做存储，在这里面对于list的iterator()需要每次都拿一遍，不能在全局去拿，不然不一样，会报异常。
> 题目中说了不能借助其他的额外空间，因此这种思路很明显不满足运行时间的要求。提交果然LeetCode没能Accept。

```
class Solution {
    public int singleNumber(int[] nums) {
        List<Integer> result = new ArrayList<>();
        Iterator<Integer> iterator;
        for (int i = 0; i < nums.length; i++) {
            if (result.contains(nums[i])) {
                iterator = result.iterator();
                while (iterator.hasNext()) {
                    if (iterator.next().equals(nums[i])) {
                        iterator.remove();
                    }
                }
            } else {
                result.add(nums[i]);
            }
        }
        return result.get(0);
    }
}
```
`未Accept`

### 优秀思路（参考别人）
> **用到了异或 ‘^’ ，有空需要补充下这块的知识。**

```
class Solution {
    public int singleNumber(int[] nums) {
        if(nums == null || nums.length == 0) {
            return -1;
        }
        int rst = 0;
        for (int i = 0; i < nums.length; i++) {
            rst ^= nums[i];
        }
        return rst;
    }
}
```