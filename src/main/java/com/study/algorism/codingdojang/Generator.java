package com.study.algorism.codingdojang;

public class Generator {

    public static int getNum(int n){
        int dn = n;

        while(n >= 10){
            dn += n%10;
            n /= 10;
        }
        dn += n;

        return dn;
    }
    public static void main(String[] args) {
        boolean[] isSelfNum = new boolean[10];

        for(int i=0; i<isSelfNum.length; i++) {
            System.out.println(isSelfNum[i]);
        }

        System.out.println(getNum(91));

    }
}
