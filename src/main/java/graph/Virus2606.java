package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Virus2606 {

  static int N, M;  // 정점의 개수, 간선의 개수
  static int[][] matrix;  // 인접 행렬용
  static boolean[] visited; // 방문 여부 확인
  static int count = 0;     // 개수 세기

  public void solution() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = null;

    N = Integer.parseInt(br.readLine());
    M = Integer.parseInt(br.readLine());

    // 행렬 연결 시키기
    matrix = new int[N + 1][N + 1];
    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());
      matrix[u][v] = matrix[v][u] = 1;
    }

    // 방문 여부 확인용 배열 추가
    visited = new boolean[N + 1];
    dfs(1); // DFS 실행
    // 무조건 1번 컴퓨터부터 바이러스가 시작되니, 1번을 기준으로만 돌리면 됨

    System.out.println(count);

  }

  static void dfs(int target) {
    if (visited[target]) {
      return;
    }
    visited[target] = true;

    for (int i = 1; i <= N; i++) {
      if (matrix[target][i] == 1 && !visited[i]) {
        count++;  // 1번과 연결되어 있는 노드 개수 더하기
        dfs(i);
      }
    }

  }

}
