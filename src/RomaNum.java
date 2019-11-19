import sun.security.util.Length;

import java.util.HashMap;

public class RomaNum {
    public int romanToInt(String s) {
        int result = 0;
        HashMap<String,Integer> hashMap = new HashMap<>();
        hashMap.put("I",1);
        hashMap.put("V",5);
        hashMap.put("X",10);
        hashMap.put("L",50);
        hashMap.put("C",100);
        hashMap.put("D",500);
        hashMap.put("M",1000);
        String[] strs = s.split("");
        boolean status = false;
        for (int i = 0;i<strs.length;i++){
//            if(status){
//                status = false;
//                continue;
//            }
            if(i < strs.length -1 && hashMap.get(strs[i]) < hashMap.get(strs[i + 1])){
//                status = true;
                result -= hashMap.get(strs[i]);
            }else{
                result += hashMap.get(strs[i]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int result = new RomaNum().romanToInt("XII");
        System.out.println(result);
    }
}
