package nano.shangguan;

import java.util.*;

/**
 * Created by Nano on 2015/12/17.
 */
public class WordLadder {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        Queue<String> queue = new LinkedList<String>();
        queue.add(beginWord);
        wordList.add(endWord);
        int count = 1;

        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                String target = queue.poll();
                selectMin(wordList, queue, target);
            }
            count++;
            if (!wordList.contains(endWord)) return count;
        }
        return 0;
    }

    private void selectMin(Set<String> wordList, Queue<String> queue, String word) {
        int len = word.length();
        char[] arr = word.toCharArray();
        for (int i = 0; i < len; i++)
            for (char j = 'a'; j <= 'z'; j++) {
                char orig = arr[i];
                arr[i] = j;
                String replaced = new String(arr);
                if (wordList.contains(replaced)) {
                    queue.add(replaced);
                    wordList.remove(replaced);
                }
                arr[i] = orig;
            }
    }
}
