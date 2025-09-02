package dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 문제 번호 커밋 수정
public class MakeOne1463 {

  public void solution() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    // 숫자 i를 1로 만드는 데 필요한 최소 연산 횟수
    int[] table = new int[N + 1];

    // 기저 조건 (1은 이미 1이므로 횟수 = 0)
    // 0의 경우, 쓰레기 값 방지 (편의상 초기화)
    table[0] = table[1] = 0;

    /**
     * 사용 가능 연산: -1, /3, /2
     */
    // 반복 (Bottom-Up 방식)
    for (int i = 2; i <= N; i++) {
      // -1 연산 시 최소 계산 값
      table[i] = table[i - 1] + 1;

      // /2 연산 시 최소 계산 값
      // i가 2로 나누어 떨어지면, i/2에서 오는 경우와 비교해 더 작은 연산 횟수 선택
      if (i % 2 == 0) {
        table[i] = Math.min(table[i], table[i / 2] + 1);
      }

      // /3 연산 시 최소 계산 값
      // i가 3으로 나누어 떨어지면, i/3에서 오는 경우와 비교해 더 작은 연산 횟수 선택
      if (i % 3 == 0) {
        table[i] = Math.min(table[i], table[i / 3] + 1);
      }
    }
    System.out.println(table[N]);
  }

}
