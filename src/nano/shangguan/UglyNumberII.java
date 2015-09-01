package nano.shangguan;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Nano on 2015/9/1.
 * 注意int的溢出问题
 */
public class UglyNumberII {
    private int[] arr = { 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 };
    private ArrayList<Integer> initList, list1, list2, list3;

    public int nthUglyNumber(int n) {
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
