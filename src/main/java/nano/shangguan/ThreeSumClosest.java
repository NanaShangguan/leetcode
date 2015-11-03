package nano.shangguan;

/**
 * Created by Nano on 2015/5/22.
 * ��Ŀ������
 * �ȶ���������Ȼ��ö����С����n1�����ڵڶ���������������������l��r���������м�л��ң�����ӽ�target - n1��������������ͨ��������һ������������������ʹ���������ĺ���ӽ�Ŀ������newTarget����
 * ��ȷ��˵���������ź��������ΪS1,S2...Si...Sj...Sn���ٶ�����Si + Sj��ӽ�Ŀ������newTarget
 * ��1����Si + Sj < newTarget ��ôSi-k + Sj  < newTarget��Si + Sj+k  > newTarget�������Si + Sj+k  < newTarget����ôSi��Sj��������ֵ��
 * ��l�ȵ���iʱ��Si + Sj+k > newTarget��r���С��j����r�ȵ���jʱ��Si-k + Sj < newTarget��l��������i��
 * ��2����Si + Sj > newTarget ��ôSi + Sj+k  > newTarget��Si-k + Sj  < newTarget�������Si-k + Sj  > newTarget����ôSi��Sj��������ֵ��
 * ��l�ȵ���iʱ��Si + Sj+k > newTarget��r���С��j����r�ȵ���iʱ��Si-k + Sj < newTarget��l��������i��
 * �����ܻ��ҵ�����ֵ
 * ʱ�临�Ӷȣ�O��n^2��
 */
public class ThreeSumClosest {

    // ʱ�临�Ӷȣ�O��n^2��
    public int threeSumClosest(int[] nums, int target) {
        quickSort(nums);

        int min_offset = target - nums[0] - nums[1] - nums[2];
        for (int i = 0; i < nums.length; i++) {
            // ȷ��index��С��һ����������[i, len - 1]
            for (int low = i + 1, high = nums.length - 1; low < high; ) {
                int new_offset = target - nums[i] - nums[low] - nums[high];
                if (Math.abs(min_offset) > Math.abs(new_offset))
                    min_offset = new_offset;
                if (new_offset < 0) high--;
                else if (new_offset > 0) low++;
                else return target;
            }
        }

        return target - min_offset;
    }

    public void quickSort(int[] nums) {
        divide(nums, 0 , nums.length - 1);
    }
    public void divide(int[] nums, int start, int end) {
        if (start >= end)
            return;
        int target = nums[start];
        boolean isHigh = true;
        int i = start, j = end;

        while (i < j) {
            if (isHigh) {
                if (nums[j] >= target) j--;
                else {
                    nums[i++] = nums[j];
                    isHigh = false;
                }
            } else {
                if (nums[i] <= target) i++;
                else {
                    nums[j--] = nums[i];
                    isHigh = true;
                }
            }
        }

        nums[i] = target;
        divide(nums, start, i - 1);
        divide(nums, i + 1, end);
    }

    public static void main (String[] args) {
        System.out.println(new ThreeSumClosest().threeSumClosest(new int[]{1,1,1,0}, -100));
    }
}
