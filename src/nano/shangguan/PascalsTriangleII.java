package nano.shangguan;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nano on 2015/4/30.
 */
public class PascalsTriangleII {

    public List<Integer> getRow(int rowIndex) {
        ArrayList<Integer> row = new ArrayList<Integer>(rowIndex + 1);
        //初始化为1,0,...,0
        row.add(1);
        for (int i = 1; i <= rowIndex; i++)
            row.add(0);

        if (rowIndex > 0) {
            for (int i = 1; i <= rowIndex; i++)
                for (int j = i; j > 0; j--)
                    row.set(j, row.get(j) + row.get(j - 1));
        }
        return  row;
    }

    public static void main(String[] args) {
        System.out.println(new PascalsTriangleII().getRow(4));
    }
}
