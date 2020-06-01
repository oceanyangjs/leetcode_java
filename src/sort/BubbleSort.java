package sort;

/**
 * 冒泡排序
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] array = new int[]{1,3,5,4,2};
        new BubbleSort().bubble(array);
    }

    private void bubble(int[] array){
        for (int i = 0; i < array.length-1; i++) {
            for (int j = array.length-1; j > i ; j--) {
                if(array[j] < array[j-1]){
                    int tmp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = tmp;
                }
            }
        }
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
