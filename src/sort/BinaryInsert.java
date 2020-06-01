package sort;

/**
 * 二分插入排序
 */
public class BinaryInsert {
    public static void main(String[] args) {
        int[] array = new int[]{1,3,5,4,2};
        new BinaryInsert().insert(array);
    }

    public void insert(int[] array){
        int left,right,middle,tmp;
        for (int i = 1; i < array.length; i++) {
            tmp = array[i];
            left = 0;
            right = i - 1;
            while (left <= right){
                middle = (left + right) / 2;
                if(tmp < array[middle]){
                    right = middle - 1;
                }else{
                    left = middle + 1;
                }
            }

//            这里不能用加法的循环，应该用减法，从右向左替换
            for (int j = i-1; j >= left; j--) {
                array[j+1] = array[j];
            }

            array[left] = tmp;
        }
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
