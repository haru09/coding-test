package com.study.algorism.codingdojang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GoalArray {

    final static String[] GOAL = {"i", "want", "to", "drink", "water"};

    private String[] cards1;
    private String[] cards2;

    GoalArray(String[] cards1, String[] cards2){
        this.cards1 = cards1;
        this.cards2 = cards2;
    }

    public boolean isEqual(String[] cards1, String[] cards2) {
        boolean isEqual = true;

        List<String> arr1 = new ArrayList<>(Arrays.asList(cards1));
        List<String> arr2 = new ArrayList<>(Arrays.asList(cards2));

        // 막간 스트림 테스트
        Arrays.asList(cards1).stream().forEach(item -> System.out.print(item+" "));
        Arrays.asList(cards2).stream().forEach(item -> System.out.print(item+" "));

        arr1.stream().forEach(item -> System.out.print(item+" "));
        arr2.stream().forEach(item -> System.out.print(item+" "));

        /*
        * 배열의 첫번째만 비교.
        * 이 후 없을 경우엔 완성된 문장이 나오지 않음.
        * 배열 전체를 비교하지 않기 때문에 좀 더 가벼운 코드가 됨
        * */
        for(int i=0; i<GOAL.length; i++) {
            if( !arr1.isEmpty() && GOAL[i].equals(arr1.get(0))) {
                isEqual = true;
                arr1.remove(0);
            } else if( !arr2.isEmpty() && GOAL[i].equals(arr2.get(0)) ){
                isEqual = true;
                arr2.remove(0);
            } else {
                isEqual = false;
                break;
            }
        }

        return isEqual;
    }

    public static void main(String[] args) {
        GoalArray ga1 = new GoalArray(new String[]{"i", "drink", "water"}, new String[]{"want", "to"});
        GoalArray ga2 = new GoalArray(new String[]{"i", "water", "drink"}, new String[]{"want", "to"});

        System.out.println( String.format("tc1 result==%s", ga1.isEqual(ga1.cards1, ga1.cards2) ));
        System.out.println( String.format("tc2 result==%s", ga2.isEqual(ga2.cards1, ga2.cards2) ));
    }
}
