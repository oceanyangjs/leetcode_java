//数字反转
public class ReverseInteger {
    public int reverse(int x) {
        boolean status = false;
        if(x < 0){
            status = true;
            x = -1 * x;
        }
        StringBuilder data = new StringBuilder(String.valueOf(x)).reverse();
        int result = 0;
        try {
            if(status){
                result = Integer.valueOf(data.toString()) * -1;
            }else{
                result = Integer.valueOf(data.toString());
            }
        }catch (Exception e){
            return 0;
        }
        return result;
    }

    public static void main(String[] args) {
        int result = new ReverseInteger().reverse(1534236469);
        System.out.println(result);
    }
}
