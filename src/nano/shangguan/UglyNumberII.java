package nano.shangguan;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Nano on 2015/9/1.
 */
public class UglyNumberII {
    //for solution1
    private int[] arr = { 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 };
    private ArrayList<Integer> initList, list1, list2, list3;

    public int nthUglyNumber(int n) {
//        return solution1(n);
        return solution2(n);
    }

    /**
     * 三个指针分别指向由当前ugly number依次乘以2、3、5得出的三个list中与最后一个ugly number最接近的位置
     * 不保存ugly number乘以2、3、5得出的三个list
     * @param n
     * @return
     */
    private int solution2(int n) {
        int[] uglyNumbers = new int[n];
        uglyNumbers[0] = 1;
        int pos2 = 0, pos3 = 0, pos5 = 0;
        for (int i = 1; i < n; i++) {
            int next2 = uglyNumbers[pos2] * 2;
            int next3 = uglyNumbers[pos3] * 3;
            int next5 = uglyNumbers[pos5] * 5;

            //取最小值，指针相应往后移一位
            int next = Math.min(Math.min(next2, next3), next5);
            if (next == next2) pos2++;
            if (next == next3) pos3++;
            if (next == next5) pos5++;
            uglyNumbers[i] = next;
        }
        return uglyNumbers[n - 1];
    }

    /**
     * 三个list维护的数字太多且没必要
     * @param n
     * @return
     */
    private int solution1(int n) {
        if (n <= arr.length) return arr[n - 1];
        init();
        for (int i = arr.length + 1; i < n; i++)
            findNextUglyNumber();
        return findNextUglyNumber();
    }

    private void init() {
        initList = new ArrayList<>();
        list1 = new ArrayList<>();
        list2 = new ArrayList<>();
        list3 = new ArrayList<>();
        //初始化initList
        for (int prime : arr) {
            initList.add(prime);
        }
        //初始化L1,L2,L3
        for (int prime : initList) {
            if (!initList.contains(prime * 2))
                list1.add(prime * 2);
            if (!initList.contains(prime * 3))
                list2.add(prime * 3);
            if (!initList.contains(prime * 5))
                list3.add(prime * 5);
        }
    }

    private int findNextUglyNumber() {
        //合并三个list
        ArrayList<Integer> listAll = new ArrayList<>();
        listAll.addAll(list1);
        listAll.addAll(list2);
        listAll.addAll(list3);
        //下一个ugly number就是listAll中的最小值
        int next = Collections.min(listAll);
        //在三个list中移除next
        list1.remove((Integer) next);
        list2.remove((Integer) next);
        list3.remove((Integer) next);
        //把next乘以2、3、5的值分别放入三个list，如果溢出，不放入
        if (next < Integer.MAX_VALUE / 2) list1.add(next * 2);
        if (next < Integer.MAX_VALUE / 3) list2.add(next * 3);
        if (next < Integer.MAX_VALUE / 5) list3.add(next * 5);
        //返回next
        return next;
    }

    public static void main(String[] args) {
        System.out.println(new UglyNumberII().nthUglyNumber(1600));
    }
}
