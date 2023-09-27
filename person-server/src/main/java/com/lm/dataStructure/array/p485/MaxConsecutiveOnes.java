package com.lm.dataStructure.array.p485;

import java.util.Arrays;

/**
 * @author yond
 * @date 2022/12/31 23:41
 * @description 最大连续1的个数
 * 给定一个二进制数组 nums ， 计算其中最大连续 1 的个数。
 *
 * 示例 1：
 * 输入：nums = [1,1,0,1,1,1]
 * 输出：3
 * 解释：开头的两位和最后的三位都是连续 1 ，所以最大连续 1 的个数是 3.
 *
 * 示例 2:
 * 输入：nums = [1,0,1,1,0,1]
 * 输出：2
 *
 * 提示：
 * 1 <= nums.length <= 105
 * nums[i] 不是 0 就是 1.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/max-consecutive-ones
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxConsecutiveOnes {

    public static void main(String[] args) {
        int[] array = new int[]{1, 1, 0, 1, 1, 1};
        int max = 0;
        int tran = 0;
        for (int i : array) {
            if (i == 1) {
                tran += 1;
            }else {
                max = Math.max(max, tran);
                tran = 0;
            }
        }
        System.out.println(Arrays.toString(array) + "\n最大1个数:" + Math.max(max, tran));
    }

}
