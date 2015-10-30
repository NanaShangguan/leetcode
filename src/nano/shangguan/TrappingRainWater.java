package nano.shangguan;

import util.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nano on 2015/10/29.
 * 从左向右扫描峰值，并记录上一个峰值index，
 * 计算两个峰值之间的储水量，计算储水量总和
 * 峰值：左右值均比自己小，默认-1位置的值小于0
 * 位置的值，len的值小于len - 1的值
 */
public class TrappingRainWater {
    public int trap(int[] height) {
        List<Integer> list = new ArrayList<Integer>();
        int trapSum = 0;
        int len = height.length;
        if (len > 1) {
            for (int i = 0; i < len; i++) {
                if (//比左右值大
                        (i > 0 && i < len - 1
                                && height[i] > height[i-1]
                                && height[i] > height[i+1])
                                || (i == 0 && height[i] > height[i+1])  //第一个值
                                || (i == len - 1 && height[i] > height[i-1])  //最后一个值
                        ) {
                    list.add(i);
                }
            }

            //去掉List中的峰值，直到剩下一个
            while (list.size() > 1) {
                List<Integer> newList = new ArrayList<Integer>();
                for (int i = 0; i < list.size(); i++) {
                    int index = list.get(i);
                    int prev = (i == 0 ? 0 : list.get(i-1));
                    int next = (i == list.size() - 1 ? 0 : list.get(i+1));
                    if (
                            (index > 0 && index < len - 1
                                    && height[index] > height[prev]
                                    && height[index] > height[next])
                            || (index == 0 && height[index] > height[next])
                            || (index == len - 1 && height[index] > height[prev])
                            )
                        newList.add(index);
                }
                if (newList.size() < 2) break;
                list = newList;
            }

            //求面积
            for (int i = 1; i < list.size(); i++) {
                int index = list.get(i);
                int prev = list.get(i-1);
                int trap = 0;
                int min = Math.min(height[index], height[prev]);
                for (int j = prev + 1; j < index; j++)
                    if (height[j] < min)
                        trap += (min - height[j]);
                trapSum += trap;
            }
        }

        return trapSum;
    }

    public static void main(String[] args) {
        System.out.println(new TrappingRainWater().trap(new int[]{6,2,1,2,1,5,2,1,2,1,6}));
    }
}
