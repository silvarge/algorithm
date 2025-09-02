package dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Fibonacci2747 {

  public void solution() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    int[] fibo = new int[N + 1];  // 함수 값 저장할 배열 추가

    // 해당 수에 맞는 함수값 계산
    for (int i = 0; i <= N; i++) {
      if (i <= 1) {
        fibo[i] = i;
      } else {
        fibo[i] = fibo[i - 1] + fibo[i - 2];
      }
    }

    // f(N) 출력
    System.out.println(fibo[N]);
  }

}
