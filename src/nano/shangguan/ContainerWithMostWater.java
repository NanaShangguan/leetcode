package nano.shangguan;

/**
 * Created by Nano on 2015/6/17.
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int len = height.length;
        if (len == 0 || len == 1) return 0;
        int maxArea = 0;
        for (int low = 0, high = len - 1; low < high; ) {
            int length = high - low;
            int minIndex = (height[low] > height[high] ? high-- : low++);
            int area = length * height[minIndex];
            if (maxArea < area) maxArea = area;
        }
        return maxArea;
    }
}
