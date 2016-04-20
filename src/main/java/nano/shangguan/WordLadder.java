package nano.shangguan;

import util.Graph;

import java.util.*;

/**
 * Created by Nano on 2015/12/17.
 */
public class WordLadder {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        wordList.add(beginWord);
        wordList.add(endWord);
        Map<String, Integer> map = new HashMap<String, Integer>();
        Iterator<String> it = wordList.iterator();
        int index = 0;
        while (it.hasNext()) {
            String word = it.next();
            map.put(word, index++);
        }
        //gou zao tu
        Graph graph = new Graph(wordList.size());
        it = wordList.iterator();
        while (it.hasNext()) {
            String word = it.next();
            int len = word.length();
            char[] arr = word.toCharArray();
            for (int i = 0; i < len; i++)
                for (char j = 'a'; j <= 'z'; j++) {
                    char orig = arr[i];
                    arr[i] = j;
                    String replaced = new String(arr);
                    if (wordList.contains(replaced) && !replaced.equals(word)) {
                        int v = map.get(word);
                        int w = map.get(replaced);
                        graph.addEdge(v, w);
                    }
                    arr[i] = orig;
                }
        }

        int[] distance = new int[wordList.size()];
        int begin = map.get(beginWord);
        int end = map.get(endWord);
        distance[begin] = 0;

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
