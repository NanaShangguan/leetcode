package nano.shangguan;

import java.util.*;

/**
 * Created by Nano on 2015/11/24.
 */
public class TheSkylineProblem {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> rightSideSortedAsc = new ArrayList<int[]>();
        for (int[] building : buildings)
            rightSideSortedAsc.add(building);
        //按右边界排序
        Collections.sort(rightSideSortedAsc, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        //按高度排序的大根堆
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<int[]>(10, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                return o2[2] - o1[2];
            }
        });
        List<int[]> resultSet = new ArrayList<int[]>();
        int len = buildings.length;
        for (int i = 0, j = 0; i < len || j < len; ) {
            if (i < len && buildings[i][0] < rightSideSortedAsc.get(j)[1]) {
                priorityQueue.add(buildings[i]);
                //新扫描到一个建筑，并且高度增加
                if (buildings[i] == priorityQueue.peek()) {
                    resultSet.add(new int[]{ buildings[i][0], priorityQueue.peek()[2] });
                }
                i++;
            } else {
                int[] removed = rightSideSortedAsc.get(j++);
                priorityQueue.remove(removed);
                if (priorityQueue.isEmpty()) {
                    if ((i == len || removed[1] < buildings[i][0])) {
                        resultSet.add(new int[]{removed[1], 0});
                    }
                }
                //扫描完一个建筑，并且高度降低
                else if (removed[2] > priorityQueue.peek()[2]) {
                    resultSet.add(new int[]{ removed[1], priorityQueue.peek()[2]
                    });
                }
            }
        }
        //合并resultSet
        for (int i = 1; i < resultSet.size(); ) {
            if (resultSet.get(i - 1)[0] == resultSet.get(i)[0])
                resultSet.remove(resultSet.get(i - 1));
            else i++;
        }
        for (int i = 1; i < resultSet.size(); ) {
            if (resultSet.get(i - 1)[1] == resultSet.get(i)[1])
                resultSet.remove(resultSet.get(i));
            else i++;
        }
        return resultSet;
    }
}
