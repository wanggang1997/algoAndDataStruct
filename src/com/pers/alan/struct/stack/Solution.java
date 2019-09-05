package com.pers.alan.struct.stack;

import java.util.Stack;

/**
 * @program: algoAndDataStruct
 * @description:
 * @author: wg
 * @create: 2019-09-04 17:56
 **/



class Solution {
    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i <s.length() ; i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{')
                stack.push(c);
            else {
                if (stack.isEmpty())
                    return false;
                char cN = stack.pop();
                if (cN=='(' && c!=')')
                    return false;
                if (cN=='[' && c!=']')
                    return false;
                if (cN=='{' && c!='}')
                    return false;
            }
        }
        return stack.isEmpty();
    }
}