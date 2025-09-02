package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 아래와 같이 소요 시간이 걸렸다. (값은 동일, f(50) 계산)
 * <p>
 * 일반 재귀 소요 시간: 23198
 * <p>
 * Top-Down DP 소요 시간: 0
 * <p>
 * Bottom-Up DP 소요 시간: 0
 */
public class FibonacciDP {

  static long[] topDown_memo;
  static long[] bottomUp_table;

  public void practice() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    topDown_memo = new long[N + 1];
    bottomUp_table = new long[N + 1];

    long startTime, endTime;

    startTime = System.currentTimeMillis();
    System.out.println(recursion(N));
    endTime = System.currentTimeMillis();
    System.out.println("일반 재귀 소요 시간: " + (endTime - startTime));

    startTime = System.currentTimeMillis();
    System.out.println(topDown(N));
    endTime = System.currentTimeMillis();
    System.out.println("Top-Down DP 소요 시간: " + (endTime - startTime));

    startTime = System.currentTimeMillis();
    System.out.println(bottomUp(N));
    endTime = System.currentTimeMillis();
    System.out.println("Bottom-Up DP 소요 시간: " + (endTime - startTime));

  }

  // 단순 재귀를 톹한 피보나치 수 계산
  // 동일한 계산을 반복하여 비효율적
  public static long recursion(int n) {
    if (n <= 1) {
      return n;
    }
    return recursion(n - 1) + recursion(n - 2);
  }

  // DP
  // Top-Down(재귀)을 사용하여 계산
  public static long topDown(int n) {

    // 기저 조건: n이 0이면 0, 1이면 1 반환
    if (n < 2) {
      return topDown_memo[n] = n;
    }

    // 이미 계산된 값이 있으면 그대로 반환
    if (topDown_memo[n] > 0) {
      return topDown_memo[n];
    }

    // 점화식: F(n) = F(n-1) + F(n-2)
    // 재귀 사용 (이전 두 항의 값을 재귀적으로 호출하여 계산)
    topDown_memo[n] = topDown(n - 1) + topDown(n - 2);

    return topDown_memo[n];
  }

  // DP
  // Bottom-Up(반복문)을 사용하여 계산
  public static long bottomUp(int n) {

    // 기저 조건 설정
    bottomUp_table[0] = 0;
    bottomUp_table[1] = 1;

    // 작은 문제(0,1)부터 시작해 n까지 차례로 계산
    for (int i = 2; i <= n; i++) {
      // 작은 수부터 Table을 채워 나감 (bottom 부터 up)
      bottomUp_table[i] = bottomUp_table[i - 1] + bottomUp_table[i - 2];
    }

    return bottomUp_table[n];
  }

}
