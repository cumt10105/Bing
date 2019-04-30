package com.example.demo.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Combination {

    public static void swap(char[] strArr,int i){

        if(i==strArr.length-1){
            System.err.println(strArr);
        }


        char[] tempStrArr = null;
        for(int j=i;j<strArr.length;j++) {
            tempStrArr = strArr.clone();
            char temp = tempStrArr[i];
            tempStrArr[i] = tempStrArr[j];
            tempStrArr[j] = temp;
            swap(tempStrArr, i+1);
        }
    }
    public static void main(String[] args) {
        System.out.println("请输入字符串：");
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        str = str.replaceAll(" ","");
        char strArr[] = str.toCharArray();
        Arrays.sort(strArr);
        swap(strArr,0);
    }
}
