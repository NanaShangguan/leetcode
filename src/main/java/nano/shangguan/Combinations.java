package nano.shangguan;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Сô on 2016/4/24.
 */
public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        if (k == 1) {
            List<List<Integer>> lists = new ArrayList<List<Integer>>();
            for (int i = 1; i <= n; i++) {
                List<Integer> list = new ArrayList<Integer>();
                list.add(i);
                lists.add(list);
            }
            return lists;
        }
        if (n == k) {
            List<List<Integer>> lists = new ArrayList<List<Integer>>();
            List<Integer> list = new ArrayList<Integer>();
            for (int i = 1; i <= n; i++) list.add(i);
            lists.add(list);
            return lists;
        }
        List<List<Integer>> lists1 = combine(n - 1, k - 1);
        List<List<Integer>> lists2 = combine(n - 1, k);
        for (int i = 0; i < lists1.size(); i++) lists1.get(i).add(n);
        lists1.addAll(lists2);
        return lists1;
    }

    public static void main(String[] args) {
        System.out.println(new Combinations().combine(5, 3));
    }
}
