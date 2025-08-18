package back_tracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NnM3_15651 {

  static int N, M;
  static int[] resultArr;

  static StringBuilder sb = new StringBuilder();

  static void dfs(int depth) {

    // 깊이가 M과 같아지면 탐색 멈춤
    // (배열 크기가 3이라면 최대 깊이가 3인 상황, 가장 깊게 들어가도 3 이상 만족할 수 없다는 소리)
    if (depth == M) {
      for (int i : resultArr) {
        sb.append(i).append(" ");
      }
      sb.append("\n");
      return;
    }

    // 깊이를 증가시키며 탐색 반복
    for (int i = 1; i <= N; i++) {
      resultArr[depth] = i; // 탐색한 값을 결과배열에 넣어둠 (깊이 => index)
      dfs(depth + 1); // 깊이를 증가시킴
    }

  }


  public void solution() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    // 결과를 저장할 배열 크기
    resultArr = new int[M];

    dfs(0);

    System.out.println(sb);
  }

}
