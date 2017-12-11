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

}