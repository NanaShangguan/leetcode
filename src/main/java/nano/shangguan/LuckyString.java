package nano.shangguan;

import java.util.*;

/**
 * Created by Nano on 2016/3/31.
 */
public class LuckyString {

    static Set<String> getAllSubstringSorted(String s) {
        int len = s.length();
        Set<String> list = new TreeSet<String>();
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j <= len; j++) {
                String substring = s.substring(i, j);
                list.add(substring);
            }
        }
        return list;
    }

    static void removeUnluckyString(Set<String> list) {
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String s = iterator.next();
            Set<Character> set = new HashSet<Character>();
            char[] sArr = s.toCharArray();
            for (char each : sArr) {
                set.add(each);
            }
            if (!isFibonacci(set.size())) iterator.remove();
        }
    }

    static boolean isFibonacci(int num) {
        int[] fibonacci = { 0, 1, 1, 2, 3, 5, 8, 13, 21 };
        for (int f : fibonacci) {
            if (f == num)
                return true;
        }
        return false;
    }

    static Set<String> getLuckySubstring(String s) {
        Set<String> set = getAllSubstringSorted(s);
        removeUnluckyString(set);
        return set;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        Set<String> set = getLuckySubstring(input);
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

}
