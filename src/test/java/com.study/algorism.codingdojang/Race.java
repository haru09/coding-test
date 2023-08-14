package com.study.algorism.codingdojang;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

@Slf4j
public class Race {

    String[] FINAL_LIST = {"mumu", "kai", "mine", "soe", "poe"};

    public void rank(String[] callings, Map<String, Integer> p_map, Map<Integer, String> n_player){
        int x;			// 호출된 사람의 등수

        String x1_person;		// 앞 사람 이름

        for(String call : callings) {
            // 호명한 사람의 현재 등수
            x = p_map.get(call);

            if(x > 0) {
                // 앞 사람 이름
                x1_person = n_player.get(x-1);

                p_map.put(call, x-1);
                p_map.put(x1_person, x);

                n_player.put(x-1, call);
                n_player.put(x, x1_person);
            }
        }
    }

    @Test
    public void solution() {
        log.info("start");
        String[] players = {"mumu", "soe", "poe", "kai", "mine"};
        String[] callings = {"kai", "kai", "mine", "mine"};
        String[] answer = new String[players.length];

        int index = 0;		// for 문 순서

        Map<String, Integer> p_map = new HashMap<>();
        Map<Integer, String> n_player = new HashMap<>();

        for(String player : players) {
            p_map.put(player, index);		// 플레이어의 현재 순서
            n_player.put(index, player);	// 레이스 등수
            index++;
        }
        rank(callings, p_map, n_player);

        index = 0;
        for(int key : n_player.keySet()) {
            answer[index++] = n_player.get(key);
        }
        log.info("race final list::{}"+ answer);
        assertArrayEquals(answer, FINAL_LIST);
    }
}
