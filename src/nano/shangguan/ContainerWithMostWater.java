package nano.shangguan;

/**
 * Created by Nano on 2015/6/17.
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int maxArea = 0;
        int len = height.length;
        for (int i = 0; i < len - 1; i++) {
            int min_height = height[i];
            if (height[i] > height[i + 1])
                min_height = height[i + 1];
            if (min_height > maxArea)
                maxArea = min_height;
        }
        return maxArea;
    }
}
