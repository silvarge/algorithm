package back_tracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NnM4_15652 {

  static int N, M;
  static int[] resultArr;

  static StringBuilder sb = new StringBuilder();

  /**
   * 백트래킹 수행하는 함수
   * @param depth 깊이
   * @param start 시작 값
   */
  static void backtracking(int depth, int start) {

    // 깊이만큼 되면 StringBuilder에 넣은 후 종료
    if (depth == M) {
      for (int i : resultArr) {
        sb.append(i).append(" ");
      }
      sb.append("\n");
      return;
    }

    // 이전 값은 들어가지 못하게 start로 수를 잡아서 시작
    for (int i = start; i <= N; i++) {
      resultArr[depth] = i;
      backtracking(depth + 1, i);
    }
  }

  public void solution() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    resultArr = new int[M];

    backtracking(0, 1);

    System.out.println(sb);
  }

}
