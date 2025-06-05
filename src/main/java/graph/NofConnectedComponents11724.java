package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NofConnectedComponents11724 {

  static int N, M;
  static int[][] matrix;
  static boolean[] visited;

  public void solution() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int count = 0;

    // 정점의 개수 / 간선의 개수
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    // 행렬
    matrix = new int[N + 1][N + 1];

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());
      matrix[u][v] = matrix[v][u] = 1;
    }

    visited = new boolean[N + 1];
    for (int i = 1; i <= N; i++) {
      if (!visited[i]) {
        dfs(i);
        count++;
      }
    }
    System.out.println(count);
  }

  static void dfs(int vertex) {
    if (visited[vertex]) {
      return;
    }
    visited[vertex] = true;

    for (int i = 1; i <= N; i++) {
      if (matrix[vertex][i] == 1 && !visited[i]) {
        dfs(i);
      }
    }
  }
}
