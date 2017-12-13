package com.tryking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PrimitiveIterator;

/**
 * 12月份LeetCode
 *
 * @author dengkaiting
 * @date 2017/12/10
 */
public class December {

    /**
     * 561. Array Partition I
     * <p>
     * Given an array of 2n integers, your task is to group these integers into n pairs of integer,
     * say (a1, b1), (a2, b2), ...,(an, bn)
     * which makes sum of min(ai, bi) for all i from 1 to n as large as possible.
     *
     * @param nums
     * @return
     * @date 2017/12/10
     */
    public int arrayPairSum(int[] nums) {
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                }
            }
        }
        temp = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                temp += nums[i];
            }
        }
        return temp;
    }

    public int arrayPairSum1(int[] nums) {
        int temp = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
                if (i % 2 != 0 && j == nums.length - i - 2) {
                    sum += nums[nums.length - 1 - i];
                }
            }
        }
        sum += nums[0];
        return sum;
    }

    /**
     * 标准答案：不知道能直接使用排序函数
     *
     * @param nums
     * @return
     */
    public int arrayPairSum0(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        for (int i = 0; i < nums.length; i += 2) {
            res += nums[i];
        }
        return res;
    }

    /**
     * 595. Big Countries
     * select name,population,area from World where area>3000000 or population>25000000
     * 一次Accept，题目简单
     *
     * @date 2017/12/11
     */

    /**
     * 461.Hamming Distance
     * <p>
     * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
     * Given two integers x and y, calculate the Hamming distance.
     * 没有思路
     *
     * @param x
     * @param y
     * @return
     */
    public int hammingDistance(int x, int y) {
        return 0;
    }

    /**
     * 标准答案：对进制转换还是不熟
     *
     * @param x
     * @param y
     * @return
     */
    public int hammingDistance0(int x, int y) {
        int Distance = 0;

        while (x != 0 || y != 0) {
            if (x % 2 != y % 2) {
                Distance++;
            }
            x /= 2;
            y /= 2;
        }
        return Distance;
    }

    /**
     * 476. Number Complement
     * Given a positive integer, output its complement number.
     * The complement strategy is to flip the bits of its binary representation.
     * 借助便捷器调试做出来了，但是性能不好，取反，取补这些知识不熟
     *
     * @param num
     * @return
     */
    public int findComplement(int num) {
        String binary = "";
        while (num > 0) {
            binary = binary + String.valueOf(num % 2);
            num = num / 2;
        }
        int result = 0;

        for (int i = binary.length() - 1; i >= 0; i--) {
            int temp = 1;
            if (binary.charAt(i) == '0') {
                for (int j = 0; j < i; j++) {
                    temp = temp * 2;
                }
                result += temp;
            } else {
            }
        }
        return result;
    }

    /**
     * 627. Swap Salary
     * Given a table salary, such as the one below, that has m=male and f=female values.
     * Swap all f and m values (i.e., change all f values to m and vice versa) with a single update query and no intermediate
     * temp table.
     * 查了很久的语法才写对
     * // update salary set sex= case when sex='m' then 'f' else 'm' end;
     */

    /**
     * 657. Judge Route Circle
     * <p>
     * Initially, there is a Robot at position (0, 0).
     * Given a sequence of its moves, judge if this robot makes a circle, which means it moves back to the original place.
     * <p>
     * The move sequence is represented by a string. And each move is represent by a character.
     * The valid robot moves are R (Right), L (Left), U (Up) and D (down). The output should be true or false representing whether the robot makes a circle.
     * <p>
     * 只打败14%的人（把if换成switch能提高到45%）
     *
     * @date 2017/12/12
     **/

    public boolean judgeCircle(String moves) {
        //也可以定义length=2的数组，左加1，右减1，最终看是否为0
        int[] result = new int[4];
        for (int i = 0; i < moves.length(); i++) {
            if (moves.charAt(i) == 'R') {
                result[0] += 1;
            } else if (moves.charAt(i) == 'L') {
                result[1] += 1;
            } else if (moves.charAt(i) == 'U') {
                result[2] += 1;
            } else if (moves.charAt(i) == 'D') {
                result[3] += 1;
            }
        }
        if (result[0] != result[1] || result[2] != result[3]) {
            return false;
        } else {
            return true;
        }
    }


    /**
     * 网上答案，打败75%的人
     *
     * @param moves
     * @return
     */
    public boolean judgeCircle0(String moves) {
        if (moves.length() % 2 != 0) {
            return false;
        }
        int countV = 0;
        int countH = 0;
        for (char letter : moves.toCharArray()) {
            switch (letter) {
                case 'U':
                    countV++;
                    break;
                case 'D':
                    countV--;
                    break;
                case 'L':
                    countH++;
                    break;
                case 'R':
                    countH--;
                    break;
            }
        }
        return countV == 0 && countH == 0;
    }

    /**
     * 88. Merge Sorted Array
     * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
     * <p>
     * Note:
     * You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
     * The number of elements initialized in nums1 and nums2 are m and n respectively.
     * <p>
     * 未通过，理解不了需求。
     *
     * @date 2017/12/12
     */
    class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int index = 0;
            for (int i = 0; i < nums2.length; i++) {
                while (index <= m) {
                    if (nums2[i] > nums1[index]) {
                        for (int j = nums1.length - 1; j > index; j--) {
                            nums1[j] = nums1[j - 1];
                        }
                        nums1[index] = nums2[i];
                        index++;
                        break;
                    }
                    index++;
                }
            }
            int i = 0;
            int temp;
            while (i < nums1.length - 1 - i) {
                temp = nums1[i];
                nums1[i] = nums1[nums1.length - 1 - i];
                nums1[nums1.length - 1 - i] = temp;
            }
        }
    }

    /**
     * 557. Reverse Words in a String III
     * Given a string, you need to reverse the order of characters in each word within a sentence
     * while still preserving whitespace and initial word order.
     *
     * @param s
     * @return
     * @date 2017/12/12
     * your runtime beats 28.61% of java submissions.
     */
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                sb.append(temp.reverse().toString()).append(" ");
                temp.setLength(0);
            } else if (i == s.length() - 1) {
                temp.append(s.charAt(i));
                sb.append(temp.reverse().toString());
            } else {
                temp.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

    /**
     * Your runtime beats 81% of java submissions.(这个百分数会不断变化，不是很准)
     */
    public String reverseWords1(String s) {
        String[] split = s.split(" ");
        StringBuilder sb = new StringBuilder();
        StringBuilder s1 = new StringBuilder();
        for (int i = 0; i < split.length - 1; i++) {
            sb.append(split[i]);
            s1.append(sb.reverse().toString()).append(" ");
            sb.setLength(0);
        }
        sb.append(split[split.length - 1]);
        s1.append(sb.reverse().toString());
        return s1.toString();
    }


}