package nano.shangguan;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Nano on 2015/7/15.
 */
public class RepeatedDNASequences {
    public List<String> findRepeatedDnaSequences(String s) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 10; i <= s.length(); i++) {
            String subString = s.substring(i - 10, i);
            if (map.containsKey(subString) && !list.contains(subString))
                list.add(subString);
            else map.put(subString, null);
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(new RepeatedDNASequences().findRepeatedDnaSequences("AAAAAAAAAAAA").toString());
    }
}
