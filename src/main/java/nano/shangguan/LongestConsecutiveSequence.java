package nano.shangguan;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nano on 2015/11/27.
 */
public class LongestConsecutiveSequence {
    public class UnionFind {
        private int[] id;
        private int[] sz;
        private int count;

        /**
         * 初始化
         * @param size 触点个数
         */
        public UnionFind(int size) {
            count = size;
            id = new int[size];
            sz = new int[size];
            for (int i = 0; i < size; i++) {
                id[i] = i;
                sz[i] = 1;
            }
        }

        /**
         * 返回p所在树的根节点
         * @param p
         * @return
         */
        public int find(int p) {
            while (p != id[p]) p = id[p];
            return p;
        }

        /**
         * 判断p和q是否相连
         * @param p
         * @param q
         * @return
         */
        public boolean connected(int p, int q) {
            return find(p) == find(q);
        }

        /**
         * 连接两个点p、q
         * @param p
         * @param q
         */
        public void union(int p, int q) {
            int rootOfP = find(p);
            int rootOfQ = find(q);
            if (rootOfP == rootOfQ) return;
            if (sz[rootOfP] < sz[rootOfQ]) {
                id[rootOfP] = rootOfQ;
                sz[rootOfQ] += sz[rootOfP];
            } else {
                id[rootOfQ] = id[rootOfP];
                sz[rootOfP] += sz[rootOfQ];
            }
            count--;
        }
    }
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        //映射num和触点，并去除重复元素
        List<Integer> listWithNoDuplicate = new ArrayList<Integer>();
        for (int num : nums) {
            if (!listWithNoDuplicate.contains(num))
                listWithNoDuplicate.add(num);
        }
        UnionFind unionFind = new UnionFind(listWithNoDuplicate.size());
        int i = 0;
        while (!listWithNoDuplicate.isEmpty()) {
            int num = listWithNoDuplicate.get(0);
            if (listWithNoDuplicate.contains(num - 1)) {
                int index = listWithNoDuplicate.indexOf(num - 1);
                unionFind.union(i, index + i);
            }
            if (listWithNoDuplicate.contains(num + 1)) {
                int index = listWithNoDuplicate.indexOf(num + 1);
                unionFind.union(i, index + i);
            }
            listWithNoDuplicate.remove(0);
            i++;
        }
        int[] sz = unionFind.sz;
        int max = sz[0];
        for (int j = 1; j < sz.length; j++)
            if (sz[j] > max) max = sz[j];
        return max;
    }
}
