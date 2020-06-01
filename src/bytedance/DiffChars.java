package bytedance;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Scanner;

//无重复字符的最长子串
public class DiffChars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputvalue = "";
        if (scanner.hasNextLine()) {
            String str2 = scanner.nextLine();
//            System.out.println("输入的数据为：" + str2);
            inputvalue = str2;
        }
        System.out.println(new DiffChars().lengthOfLongestSubstring(inputvalue));
    }

    public int lengthOfLongestSubstring(String inputvalue) {
        int cnt = 0;//不重复字符串长度
        String str = "";//不重复字符串
        for (int i = 0; i < inputvalue.length(); i++) {
//            如果剩余数目已经不足，则直接结束
            if(cnt >= inputvalue.length() - i){
                break;
            }
            Hashtable<String,Integer> hashtable = new Hashtable<>();
            int tmpcnt = 0;
            for (int j = i; j < inputvalue.length(); j++) {
                if(hashtable.containsKey(Character.toString(inputvalue.charAt(j)))){
                    if(tmpcnt > cnt){
                        cnt = tmpcnt;
                    }
                    break;
                }else{
                    hashtable.put(Character.toString(inputvalue.charAt(j)),1);
                    tmpcnt++;
                    if(j == inputvalue.length() -1 && tmpcnt > cnt){
                        cnt = tmpcnt;
                    }
                }
            }
        }
        return cnt;
    }

//    public int lengthOfLongestSubstring(String s) {
//        if (s.length()==0) return 0;
//        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
//        int max = 0;
//        int left = 0;
//        for(int i = 0; i < s.length(); i ++){
//            if(map.containsKey(s.charAt(i))){
//                left = Math.max(left,map.get(s.charAt(i)) + 1);
//            }
//            map.put(s.charAt(i),i);
//            max = Math.max(max,i-left+1);
//        }
//        return max;
//
//    }
}
