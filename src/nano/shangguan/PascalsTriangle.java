package nano.shangguan;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nano on 2015/4/30.
 */
public class PascalsTriangle {

    public List<List<Integer>> generate(int numRows) {
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
        if (numRows > 0) {
            //初始化Pascal's triangle
            result.add(new ArrayList<Integer>() {{
                add(1);
            }});

            if (numRows > 1) {
                for (int i = 1; i < numRows; i++) {
                    ArrayList<Integer> row = new ArrayList<Integer>();
                    row.add(1);
                    ArrayList<Integer> previous = (ArrayList<Integer>) result.get(i - 1);
                    for (int j = 0; j < previous.size() - 1; j++)
                        row.add(previous.get(j) + previous.get(j + 1));
                    row.add(1);
                    result.add(row);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new PascalsTriangle().generate(1).toString());
    }
}
