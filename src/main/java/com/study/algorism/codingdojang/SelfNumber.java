package com.study.algorism.codingdojang;

public class SelfNumber {
    public static final int MAX=10001;

    /*
    구현 방식
    - 1 ~ 10000 까지 검사한 뒤, 해당 수를 생성자로 하는 수가 있으면 그 수를 거르는 것이다.

    d(n), d(d(n), d(d(d(n))) ...
    예제 : 91 >> 9 + 1 + 91 = 101
     */
    public static int getNum(int n){
        int dn = n;
        while(n >= 10){
            dn += n%10;
            n /= 10;
        }
        dn += n;

        return dn;
    }

    public static void main(String[] args){
        boolean[] isSelfNum = new boolean[MAX];     // default false

        for(int i=1; i<MAX; i++){
            
            // i의 값 MAX까지 돌면서 생성자가 되는 값을 제거
            for(int j= getNum(i); j<MAX; j=getNum(j)){
                //System.out.println(i+"번째 >> "+j);
                if(isSelfNum[j]) continue;
                isSelfNum[j] = true;
            }
        }

        for(int i=1; i<MAX; i++){
            if(!isSelfNum[i])
                System.out.println(i);
        }
    }
}
