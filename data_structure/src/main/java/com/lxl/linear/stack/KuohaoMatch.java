package com.lxl.linear.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 括号匹配问题
 */
public class KuohaoMatch {

    public static boolean matchSuccess(String content){
        Stack<Character> stack = new Stack<Character>();
        Map<Character,Character> map = new HashMap<Character, Character>();
        map.put('{','}');
        map.put('[',']');
        map.put('(',')');
        char[] charArray = content.toCharArray();
        for(int i = 0;i< charArray.length;i++){
            char c = charArray[i];
            if(map.containsKey(c)){
                stack.push(c);
            }else {
                Character pop = stack.pop();
                if(!map.get(pop).equals(c)){
                    return false;
                }
            }
        }
        return stack.isEmpty();

    }

    public static void main(String[] args) {
        String str = "[{()}]";
        System.out.println(matchSuccess(str));
    }
}
