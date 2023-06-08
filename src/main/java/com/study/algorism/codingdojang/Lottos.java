package com.study.algorism.codingdojang;

public class Lottos {

    private int[] lottos;
    private int[] win_nums;
    private int max_rank;
    private int low_rank;

    Lottos(int[] lottos, int[] win_nums, int max_rank, int low_rank){
        this.lottos = lottos;
        this.win_nums = win_nums;
        this.max_rank = max_rank;
        this.low_rank = low_rank;
    }


    public int rank(int count){
        switch(count){
            case 6 :
                return 1;
            case 5 :
                return 2;
            case 4 :
                return 3;
            case 3 :
                return 4;
            case 2 :
                return 5;
            default :
                return 6;
        }
    }

    public int[] compareLottosRank(int[] lottos, int[] win_nums){
        int low_rank = 0;
        int max_rank = 0;

        for(int i=0; i<lottos.length; i++)   {
            if(lottos[i] == 0){
                max_rank++;
            }

            for(int j=0; j<win_nums.length; j++) {
                if(lottos[i] == win_nums[j]) {
                    max_rank++;
                    low_rank++;
                }
            }
        }

        return new int[] {rank(max_rank), rank(low_rank)};
    }

    //public int[] solution(int[] lottos, int[] win_nums) {
    public void solution(int[] lottos, int[] win_nums, int req_max, int req_low) {
        int[] rank = compareLottosRank(lottos, win_nums);
        int[] answer = {rank[0], rank[1]};

        System.out.println(String.format("최고등수:%s, 최저등수:%s, 기대값[%s, %s]", rank[0], rank[1], req_max, req_low));
        //return answer;
    }
    public static void main(String[] args){
        Lottos lt1 = new Lottos(new int[] {44, 1, 0, 0, 31, 25}, new int[] {31, 10, 45, 1, 6, 19}, 3, 5);
        Lottos lt2 = new Lottos(new int[] {0, 0, 0, 0, 0, 0}, new int[] {38, 19, 20, 40, 15, 25}, 1, 6);
        Lottos lt3 = new Lottos(new int[] {45, 4, 35, 20, 3, 9}, new int[] {20, 9, 3, 45, 4, 35}, 1, 1);

        lt1.solution(lt1.lottos, lt1.win_nums, lt1.max_rank, lt1.low_rank);
        lt2.solution(lt2.lottos, lt2.win_nums, lt2.max_rank, lt2.low_rank);
        lt2.solution(lt3.lottos, lt3.win_nums, lt3.max_rank, lt3.low_rank);
    }
}
