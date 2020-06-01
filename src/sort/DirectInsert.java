package sort;

/**
 * 直接插入排序
 */
public class DirectInsert {
    public static void main(String[] args) {
        int[] array = new int[]{1,3,5,4,2};
        new DirectInsert().insert(array);
    }

    public void insert(int[] array){
        for (int i = 1; i < array.length; i++) {
            int tmp = array[i];
//            循环之前的，每一个都移动
            if(tmp < array[i - 1]){
                for(int j = i -1;j >= 0;j--){
                    if(j > 0 && array[j] > tmp){
                        array[j+1] = array[j];
                    }else{
                        array[j+1] = tmp;
                        break;
                    }
                }
            }
        }
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
