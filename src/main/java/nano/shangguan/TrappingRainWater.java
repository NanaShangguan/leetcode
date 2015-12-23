package nano.shangguan;

import util.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nano on 2015/10/29.
 */
public class TrappingRainWater {
    public int trap(int[] height) {
        if (height.length == 0) return 0;
        int highest = highestIndex(height, 0, height.length);
        int leftArea = 0, rightArea = 0;
        int start = 0, end = highest;
        while (start != end) {
            int nextHighestIndex = highestIndex(height, start, end);
            int nextHighest = height[nextHighestIndex];
            for (int i = nextHighestIndex + 1; i < end; i++) {
                leftArea += (nextHighest - height[i]);
            }
            end = nextHighestIndex;
        }
        start = highest + 1;
        end = height.length;
        while (start != end) {
            int nextHighestIndex = highestIndex(height, start, end);
            int nextHighest = height[nextHighestIndex];
            for (int i = start; i < nextHighestIndex; i++) {
                rightArea += (nextHighest - height[i]);
            }
            start = nextHighestIndex + 1;
        }
        return leftArea + rightArea;
    }

    /**
     * [start, end)
     * @param height
     * @param start
     * @param end
     * @return
     */
    private int highestIndex(int[] height, int start, int end) {
        int max = start;
        for (int i = start + 1; i < end; i++) {
            if (height[max] < height[i]) max = i;
        }
        return max;
    }
}
