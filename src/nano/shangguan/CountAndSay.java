package nano.shangguan;

/**
 * Created by Nano on 2015/4/16.
 */
public class CountAndSay {
    public String countAndSay(int n) {
        String seq = "1";
        for (int i = 1; i < n; i++) {
            int num = 0;
            char curCountInt = seq.charAt(0);
            String newSeq = "";
            for (int j = 0; j < seq.length(); j++) {
                //若当前数字与当前正在count的数字相同，count加一
                if (seq.charAt(j) == curCountInt) {
                    ++num;
                } else {
                    //将当前已经count完的数字添加到新的序列
                    newSeq += "" + num + curCountInt;

                    //将count设为1，count的数字设为index为j的数字
                    curCountInt = seq.charAt(j);
                    num = 1;
                }
            }
            //将最后一个统计的数加到新序列
            newSeq += "" + num + curCountInt;

            //将新序列赋值给seq
            seq = newSeq;
        }

        return seq;
    }

    public static void main(String[] args) {
        System.out.println(new CountAndSay().countAndSay(4));
    }
}
