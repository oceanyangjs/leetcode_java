//回文数
public class Symmetrical {
    public boolean isPalindrome(int x) {
        boolean result = false;
        int y = x;
        if(x >= 0){
            long newNum = 0;
            while (x != 0){
                newNum = newNum*10 + x%10;
                x = x/10;
            }

            try {
                if((int)newNum == y){
                    result = true;
                }
            }catch (Exception e){
                return false;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        boolean result = new Symmetrical().isPalindrome(12121);
        System.out.println(result);
    }
}
