package com.pers.algo.nographic.util;

public class FibonacciUtil {

    public static int  generateFibSeq(int n){
            if (n==0) return 0;

            if(n==1) return  1;

            return generateFibSeq(n-1)+generateFibSeq(n-2);
    }


    public static void main(String[] args) {

        //
        for (int i = 0; i <40 ; i++) {
            System.out.println(i+":"+generateFibSeq(i));
        }


    }


}
