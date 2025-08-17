package recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 지수 법칙과 모듈러 성질
 * <p>
 * 지수 법칙
 * <p>
 * - a ^ (n+m) = a^n * a^m
 * <p>
 * 분할 수식
 * <p>
 * - b가 짝수일 때: a^b = a^(b/2) * a^(b/2)
 * <p>
 * - b가 홀수일 때: a^b = a^(b/2) * a^(b/2+1)
 *
 * <p>
 * 모듈러 성질: 곱하기 전에 미리 Mod 연산을 해도 결과가 변하지 않는다
 * <p>
 * - (a*b)%c = (a%c * b%c)%c
 */

public class Multiple1629 {

  static long A, B, C;

  public void solution() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    A = Integer.parseInt(st.nextToken());
    B = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());

    System.out.println(power(B));
  }

  /**
   *
   * @param b: 지수
   * @return (A^B)%C의 값
   */
  long power(long b) {
    // 특수한 상황 0, 1 (가장 마지막에 도달했을 떄)
    // 지수가 0일때는 1
    if (b == 0) {
      return 1 % C;
    }
    // 지수가 1일 때는 A % C
    if (b == 1) {
      return A % C;
    }

    // k = A^(b/2)%C
    long k = power(b / 2) % C;

    // A^b%C 를 구함
    if (b % 2 == 0) {
      // 지수가 짝수일 때
      // A^b=(A^(b/2))×(A^(b/2))
      return k * k % C;
    } else {
      // 지수가 홀수일 때
      // A^b=(A^(b/2))×(A^(b/2))×A
      return k * k % C * A % C;
    }
    // 굳이 %C를 여러 번 하는 이유는 모듈러 성질에 따라 곱하기 전 MOD를 해도 결과가 변하지 않기 때문
    // 계산 시 부하를 줄이기 위해 미리 수를 작게 줄여 두는 것
  }

}
