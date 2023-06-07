package com.study.algorism.codingdojang;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LuckySeven {

    public static int getNumberCount(int num, String s_num){
        return String.valueOf(num).length()-String.valueOf(num).replaceAll(s_num, "").length();
    }

    public static void main(String[] args){
        int[] array = {7, 77, 17};
        int count = 0;

        for(int num : array){
            count += getNumberCount(num, "7");
        }

        System.out.println(count);
        System.out.println(Arrays.toString(array).split("7").length-1);
    }
}