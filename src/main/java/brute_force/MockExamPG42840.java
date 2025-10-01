package brute_force;

import java.util.ArrayList;
import java.util.List;

public class MockExamPG42840 {

  public int[] solution(int[] answers) {
    // 수포자들의 찍기 방식
    int[][] howto = {
        {1, 2, 3, 4, 5},
        {2, 1, 2, 3, 2, 4, 2, 5},
        {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
    };

    // 점수 계산용
    int[] score = {0, 0, 0};
    int max = -1;

    // 한 명씩 반복
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < answers.length; j++) {
        // 찍기 방식과 답이 맞으면
        if (howto[i][j % howto[i].length] == answers[j]) {
          score[i] += 1;
        }
      }
      max = Math.max(max, score[i]);
    }

    // 가장 문제를 맞힌 수포자 등록
    List<Integer> list = new ArrayList<>();
    for (int i = 0, j = 0; i < 3; i++) {
      if (max == score[i]) {
        list.add(i + 1);
      }
    }

    return list.stream().mapToInt(Integer::intValue).toArray();
  }
}
