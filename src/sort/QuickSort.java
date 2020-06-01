package sort;

public class QuickSort {
    public static void main(String[] args) {
        int[] array = new int[]{4,1,3,5,6,2};
        new QuickSort().quick(array,0,array.length-1);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    public void quick(int[] array,int start,int end){
//        增加一下结束
        if (start > end) {
            return;
        }
        int start0 = start;
        int end0 = end;
        int tmp = array[start];//定义基准数字
        while (start < end){
            while (array[end] > tmp  && start < end){
                end--;
            }
            while (array[start] <= tmp  && start < end){
                start++;
            }
            if(start < end){
                int xx = array[start];
                array[start] = array[end];
                array[end] = xx;
            }
        }
        array[start0] = array[start];
        array[start] = tmp;

        quick(array,start0,start-1);
        quick(array,start+1,end0);
    }
}
