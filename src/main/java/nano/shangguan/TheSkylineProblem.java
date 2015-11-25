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
            //扫描到一组重叠building中的新building，=代表紧挨着的两个building也算重叠
            int[] nextShouldBeRemovedBuilding = rightSideSortedAsc.get(j);
            if (i < len && buildings[i][0] <= nextShouldBeRemovedBuilding[1]) {
                int[] building = buildings[i];
                //如果队列为空，添加顶点到结果集
                if (priorityQueue.isEmpty()) resultSet.add(new int[]{ building[0], building[2] });
                //如果比目前堆中所有building的高度都高，那么需要添加到结果集
                else if (building[2] > priorityQueue.peek()[2]) {
                    if (resultSet.get(resultSet.size() - 1)[0] < building[0]) {
                        resultSet.add(new int[]{ building[0], building[2] });
                    } else {
                        //如果横坐标相同，取更高的高度，移除之前较低的高度
                        int[] lastOne = resultSet.get(resultSet.size() - 1);
                        lastOne[1] = building[2];
                    }
                }
                priorityQueue.add(building);
                i++;
            } else {
                priorityQueue.remove(nextShouldBeRemovedBuilding);
                //添加一堆重叠建筑中的最后一个建筑的右下角顶点
                //或者
                //扫描完一个建筑，并且堆中最大高度降低
                if (priorityQueue.isEmpty()
                        || nextShouldBeRemovedBuilding[2] > priorityQueue.peek()[2]) {
                    addPointWhenRemovingBuilding(resultSet, nextShouldBeRemovedBuilding, priorityQueue);
                }
                j++;
            }
        }
        return resultSet;
    }

    //如果新加入的点与结果集中最后一个点last横坐标相同，那么必定高度比last的低，取低的点
    private void addPointWhenRemovingBuilding(List<int[]> resultSet
            , int[] building, PriorityQueue<int[]> priorityQueue) {
        int[] lastOne = resultSet.get(resultSet.size() - 1);
        int height = priorityQueue.isEmpty() ? 0 : priorityQueue.peek()[2];
        if (lastOne[0] == building[1]) lastOne[1] = height;
        else resultSet.add(new int[]{ building[1], height});
    }
}
