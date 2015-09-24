package nano.shangguan;

import util.Point;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Nano on 2015/9/16.
 */
public class MaxPointsOnALine {
    public int maxPoints(Point[] points) {
        int len = points.length;
        HashMap<String, List> map = new HashMap<String, List>();
        for (int i = 0; i < len; i++) {
            Point point1 = points[i];
            for (int j = i + 1; j < len; j++) {
                Point point2 = points[j];
                int offsetX = point1.x - point2.x;
                int offsetY = point1.y - point2.y;
                String slope = null;
                if (offsetX == 0) {
                    slope = "null|" + point1.x;
                } else {
                    double s = ((double) offsetY) / offsetX;
                    if (s == 0) {
                        slope = s + "|" + point1.y;
                    } else {
                        double k = point1.x - point1.y / s;
                        slope = s + "|" + k;
                    }
                }

                if (!map.containsKey(slope))
                    map.put(slope, new ArrayList<Point>(){
                        {
                            add(point1);
                            add(point2);
                        }
                    });
                else {
                    List list = map.get(slope);
                    if (!list.contains(point1)) list.add(point1);
                    if (!list.contains(point2)) list.add(point2);
                }
            }
        }
        //遍历map找出count最大值
        int maxCount = (len == 0 ? 0 : 1);
        Iterator<String> it = map.keySet().iterator();
        while (it.hasNext()) {
            List list = map.get(it.next());
            int count = list.size();
            if (count > maxCount) maxCount = count;
        }
        return maxCount;
    }

//    [[0,-12],[5,2],[2,5],[0,-5],[1,5],[2,-2],[5,-4],[3,4],[-2,4],[-1,4],[0,-5],[0,-8],[-2,-1],[0,-11],[0,-9]] 15
    public static void main(String[] args) {
        System.out.println(new MaxPointsOnALine().maxPoints(new Point[]{
                new Point(3,10),
                new Point(0,2),
                new Point(0,2),
                new Point(3,10),
        }));
    }
}
