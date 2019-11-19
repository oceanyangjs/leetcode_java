import java.util.HashMap;
import java.util.Iterator;

//获取最长公共前缀
public class LongestPre {
    public String longestCommonPrefix(String[] strs) {
        String result = "";
        if(strs == null || strs.length == 0 ){
            return result;
        }
        HashMap<String,String[]> hashMap = new HashMap<>();
        for (int i = 0;i<strs.length;i++){
            String[] items = strs[i].split("");
            hashMap.put(strs[i],items);
        }
        for (int j = 0;j<hashMap.get(strs[0]).length;j++){
            String item = hashMap.get(strs[0])[j];
            boolean status = false;
            Iterator iterator = hashMap.values().iterator();
            while (iterator.hasNext()){
                status = false;
                String[] temp = (String[]) iterator.next();
                if(temp.length <= j || temp[j] == null || !temp[j].equals(item)){
                    status = true;
                    break;
                }
            }
            if(status){
                break;
            }else{
                result += item;
            }
        }
        return result;
    }

    public String longestCommonPrefixNew(String[] strs) {
        String result = "";
        if(strs == null || strs.length == 0 ){
            return result;
        }
        int minLength = -1;
        String shortStr = "";
        for (int i =0;i<strs.length;i++){
            if(minLength == -1){
                minLength = strs[i].length();
                shortStr = strs[i];
            }else{
                minLength = strs[i].length() < minLength ? strs[i].length():minLength;
                shortStr = strs[i].length() < minLength ? strs[i]:shortStr;
            }
        }
        boolean finish = false;
        for (int k = 0;k < minLength;k++){
            for (int j = 0;j < strs.length;j++){
                if(strs[j].equals(shortStr)){
                    continue;
                }
                if(shortStr == "" || shortStr.charAt(k) != strs[j].charAt(k)){
                    finish = true;
                    break;
                }
            }
            if(finish){
                break;
            }else{
                result += shortStr.charAt(k);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String[] str = new String[]{"","b"};
        String result = new LongestPre().longestCommonPrefixNew(str);
        System.out.println(result);
    }
}
