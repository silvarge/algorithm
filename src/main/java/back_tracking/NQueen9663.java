package back_tracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NQueen9663 {

  static int N;
  static int[] chess;
  static int result;

  // 현재 행(cdx)에 퀸을 놓을 수 있는지 검사
  static boolean isValid(int cdx) {
    for (int i = 0; i < cdx; i++) {
      // 1. 같은 열이면 안됨
      if (chess[cdx] == chess[i]) {
        return false;
      }

      // 2. 대각선상도 안됨 (기울기 비교 (행과 열의 차이 비교 시, 두 값이 같으면 대각선))
      if (Math.abs(cdx - i) == Math.abs(chess[cdx] - chess[i])) {
        return false;
      }
    }
    return true;
  }

  // cdx: 행, chess[cdx]: 열
  static void nQueen(int cdx) {
    // 모든 행에 퀸을 배치했을 때
    if (cdx == N) {
      result++;
      return;
    }

    for (int i = 0; i < N; i++) {
      chess[cdx] = i; //(i, cdx)에 퀸을 놓아 본다
      if (isValid(cdx)) {
        nQueen(cdx + 1);  // 다음 행에 대한 탐색 시작
      }
    }
  }

  public void solution() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());

    chess = new int[N];   // 인덱스는 행, 값은 열

    nQueen(0);  // nQueen 알고리즘 수행

    System.out.println(result);
  }

}
