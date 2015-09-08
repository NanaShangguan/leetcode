package nano.shangguan;

import java.util.HashMap;

/**
 * Created by Nano on 2015/5/26.
 */
public class ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {
        HashMap map = new HashMap();
        for (int each : nums) {
//            if (map.containsKey(each))
//                return true;
            map.put(each, null);
        }
        if (map.keySet().size() == nums.length)
            return false;
        else return true;
    }

    public static void main(String[] args) {
        System.out.println(new ContainsDuplicate().containsDuplicate(new  int[]{1, 2, 2, 1, 8}));
    }
}
