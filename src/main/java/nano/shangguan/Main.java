package nano.shangguan;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by Nano on 2016/4/11.
 */
public class Main {
    static class Planet implements Comparable<Planet> {
        public int pos;
        public int people;
        public Planet(int pos, int people) {
            this.pos = pos;
            this.people = people;
        }

        public int compareTo(Planet p) {
            return Integer.compare(this.pos, p.pos);
        }

        @Override
        public String toString() {
            return pos + " " + people;
        }
    }
    static int solution(int n, int r, Planet[] planets) {
        //按距离排序
        Arrays.sort(planets);
        long sum = 0;
        for (int i = 0; i < n; i++)
            sum += planets[i].people;
        int avg = (int) sum / n;
        //求每个星球可能会容纳的最大人数
        long[] max = new long[n];
        boolean isAvailable = true;
        for (int i = 0; i < n; i++) {
            long total = 0;
            for (int j = i + 1; j < n; j++) {
                if (planets[j].pos - planets[i].pos > r) break;
                total += planets[j].people;
            }
            for (int j = i - 1; j > -1; j--) {
                if (planets[i].pos - planets[j].pos > r) break;
                total += planets[j].people;
            }
            max[i] = total;
            if (total < avg) isAvailable = false;
        }
        //寻找一个target
        while (!isAvailable) {
            sum = 0;
            for (int i = 0; i < n; i++) {

            }
        }
        return 0;
    }
}
