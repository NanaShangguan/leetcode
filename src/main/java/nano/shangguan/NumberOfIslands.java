package nano.shangguan;

/**
 * Created by Nano on 2015/11/25.
 */
public class NumberOfIslands {
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

        /**
         * 返回连通分量个数
         * @return
         */
        public int getCount() {
            return count;
        }
    }
    public int numIslands(char[][] grid) {
        if (grid.length == 0) return 0;
        int rows = grid.length, cols = grid[0].length;
        int size = rows * cols;
        UnionFind unionFind = new UnionFind(size);
        //扫描行
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols - 1; j++) {
                if (grid[i][j] == '1' && grid[i][j + 1] == '1') {
                    int value = i * cols + j;
                    unionFind.union(value, value + 1);
                }
            }
        for (int i = 0; i < cols; i++)
            for (int j = 0; j < rows - 1; j++) {
                if (grid[j][i] == '1' && grid[j + 1][i] == '1') {
                    int value = j * cols + i;
                    unionFind.union(value, value + cols);
                }
            }
        //统计'0'的个数
        int countWater = 0;
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                if (grid[i][j] == '0')
                    countWater++;
        return unionFind.getCount() - countWater;
    }
}
