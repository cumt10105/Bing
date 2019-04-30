package com.example.demo.algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class Combination2 {

    public static void swap(char[] strCharArray, int n){

        if(n == strCharArray.length-1){
            System.out.println(strCharArray);
        }

        for(int i=n;i<=strCharArray.length-1;i++){
            char[] tempArray = strCharArray.clone();
            char temp = tempArray[i];
            tempArray[i] = tempArray[n];
            tempArray[n] = temp;
            //System.out.println(tempArray);
            swap(tempArray, n+1);
        }
    }

    public final static void main(String[] args) {
        String str = "123";
        char[] arr = str.toCharArray();
        swap(arr, 0);
    }
}
