package com.tryking;

import java.util.Arrays;
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
}