package nano.shangguan;

import java.util.Scanner;

/**
 * Created by Nano on 2016/4/5.
 */
public class SpringOuting {
    static int solution(int n, int k, int[][] preference) {
        //对每个place投票
        int pk = 0;
        for (int i = k; i >= 1; i--) {
            int voteCount = 0;
            for (int j = 0; j < n; j++) {
                if (isVote(i, preference[j], pk)) voteCount++;
            }
            if (voteCount > (n / 2)) pk = i;
        }
        return pk;
    }

    /**
     * @param place 当前要投票的地点
     * @param preference 偏好数组
     * @param pk 当前地点投发对票时最终要去的地点
     * @return
     */
    static boolean isVote(int place, int[] preference, int pk) {
        for (int i = 0; i < preference.length; i++) {
            if (preference[i] == 0) return false;
            if (preference[i] == place) return true;
            if (preference[i] == pk) return false;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int[][] preference = new int[n][k + 1];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < k + 1; j++)
                    preference[i][j] = scanner.nextInt();
            }
            int result = solution(n, k, preference);
            System.out.println(result == 0 ? "otaku" : result);
        }
    }
}
