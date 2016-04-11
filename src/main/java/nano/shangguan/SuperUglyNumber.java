package nano.shangguan;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Created by Nano on 2016/4/11.
 */
public class SuperUglyNumber {

    static int[] seq = null;

    static class Num implements Comparable<Num> {
        int base, index, current;
        public Num(int b, int i) {
            base = b;
            index = i;
            current = base * seq[index];
        }
        public int compareTo(Num o) {
            return Integer.compare(this.current, o.current);
        }
        public String toString() {
            return base + "," + index + "," + current;
        }
    }

    public int nthSuperUglyNumber(int n, int[] primes) {
        seq = new int[n + 1];
        seq[1] = 1;
        PriorityQueue<Num> queue = new PriorityQueue<Num>(primes.length);
        //init queue
        for (int prime : primes) {
            queue.add(new Num(prime, 1));
        }

        for (int i = 2; i <= n; i++) {
            Num top = queue.poll();
            if (top.current > seq[i - 1]) seq[i] = top.current;
            else i--;
            Num next = new Num(top.base, top.index + 1);
            queue.add(next);
        }

        return seq[n];
    }
}
