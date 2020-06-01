package sort;

public class SimpleSelectSort {
    public static void main(String[] args) {
        int[] array = new int[]{1,3,5,4,2};
        new SimpleSelectSort().select(array);
    }

    private void select(int[] array){
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            int min = array[i];
            for (int j = i; j < array.length; j++) {
                if(array[j] < min){
                    minIndex = j;
                    min = array[j];
                }
            }
            array[minIndex] = array[i];
            array[i] = min;
        }
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
