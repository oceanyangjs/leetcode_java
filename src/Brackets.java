import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

//括号有效性判断
public class Brackets {
    public boolean isValid(String s) {
        boolean result = true;
        HashMap<String,String> hashMap = new HashMap<>();
        if(s == ""){
            return result;
        }
        if(s.length()%2 != 0){
            return false;
        }
        hashMap.put("(",")");
        hashMap.put("[","]");
        hashMap.put("{","}");
        String[] strs = s.split("");
        int count = 0;
        for (int i = 0;i<s.length()-1;i++){
            if(strs[i] == "finish"){
                continue;
            }
//            String item = hashMap.get(strs[i]);
//            if(item == null){
//                result = false;
//                break;
//            }
            int tmp = 0;
            int tmp0 = 0;
            int tmp1 = 0;
            int tmp2 = 0;
            int tmp3 = 0;
            int tmp4 = 0;
            for (int j = i +1;j<s.length();j++){
                if(strs[j] == "finish"){
                    continue;
                }
                if(strs[j].equals(hashMap.get(strs[i]))){
                    if(tmp == tmp0 && tmp1 == tmp2 && tmp3 == tmp4){
                        strs[j] = "finish";
                        strs[i] = "finish";
                        count++;
                        break;
                    }
                }
                switch (strs[j]){
                    case "(":
                        tmp++;
                        break;
                    case ")":
                        tmp0++;
                        break;
                    case "{":
                        tmp1++;
                        break;
                    case "}":
                        tmp2++;
                        break;
                    case "[":
                        tmp3++;
                        break;
                    case "]":
                        tmp4++;
                        break;
                    default:
                        break;
                }
            }
        }
        if(count * 2 != s.length()){
            result = false;
        }
        return result;
    }


    public boolean isValidWithStack(String s) {
        boolean result = false;
        boolean finish = false;
        if(s == "" || s == null || s.equals("")){
            return true;
        }
        if(s.length()%2 != 0){
            return result;
        }
        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put(")","(");
        hashMap.put("]","[");
        hashMap.put("}","{");
        Stack<String> stack = new Stack<>();
        String[] strs = s.split("");
        for (int i = 0;i<strs.length;i++){
            if(stack.isEmpty()){
                if(hashMap.keySet().contains(strs[i])){
                    finish = true;
                    break;
                }
                stack.push(strs[i]);
                continue;
            }
            if(hashMap.keySet().contains(strs[i])){
                if(hashMap.get(strs[i]).equals(stack.peek())){
                    stack.pop();
                }else{
                    finish = true;
                    break;
                }
            }else{
                stack.push(strs[i]);
            }
        }
        if(finish){
            return false;
        }
        if(stack.isEmpty()){
            result = true;
        }
        return result;
    }

    public boolean isValidWithStack2(String s) {
        Stack<Character> stack = new Stack<Character>();
        Map<Character, Character> PARENTHESES_MAP = new HashMap<Character, Character>() {
            {
                put(')', '(');
                put(']', '[');
                put('}', '{');
            }
        };
        for(char c : s.toCharArray()) {
            switch (c) {
                case '(':
                case '[':
                case '{':
                    stack.push(c);
                    break;
                case ')':
                case ']':
                case '}':
                    if (stack.isEmpty()) {
                        return false;
                    } else {
                        char top = stack.pop();
                        if (PARENTHESES_MAP.get(c) != top) {
                            return false;
                        }
                    }
                    break;
                default:
                    break;
            }
        }

        return stack.empty();
    }

    public static void main(String[] args) {
        boolean result = new Brackets().isValidWithStack("");
        System.out.println(result);
    }
}
