package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class DFSandBFS1260_2 {

  static int[][] matrix;
  static boolean[] visited;    // 방문 여부
  static StringBuilder sb = new StringBuilder();

  public void solution() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    // N: 정점의 개수, M: 간선의 개수, V: 탐색을 시작할 정점의 번호
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int V = Integer.parseInt(st.nextToken());

    // 인접행렬 설정
    int m, n;   // 연결할 노드 넣을 변수
    matrix = new int[N + 1][N + 1];

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      m = Integer.parseInt(st.nextToken()); // 대상 1
      n = Integer.parseInt(st.nextToken()); // 대상 2
      matrix[m][n] = matrix[n][m] = 1;  // 양방향 연결
    }

    int length = matrix.length;

    // DFS
    visited = new boolean[length + 1];
    DFS(V, length);

    sb.append("\n");

    // BFS
    visited = new boolean[length + 1];
    BFS(V, length);

    System.out.println(sb);
  }

  // DFS 구현
  private static void DFS(int vertex, int length) {
    if (visited[vertex]) {
      return;
    }
    // 방문 확인
    visited[vertex] = true;
    sb.append(vertex).append(" ");

    // 현재 정점과 연결된 정점들을 검사
    for (int i = 1; i < length; i++) {
      if (matrix[vertex][i] == 1 && !visited[i]) {
        // 현재 정점과 연결되어 있고, 방문하지 않은 정점이라면 방문하러 감
        DFS(i, length);
      }
    }
  }

  // BFS 구현
  private static void BFS(int vertex, int length) {
    Queue<Integer> queue = new LinkedList<>();
    int v;
    // 시작 노드 등록
    queue.add(vertex);
    visited[vertex] = true;
    sb.append(vertex).append(" ");

    while (!queue.isEmpty()) {
      v = queue.poll();

      for (int i = 1; i < length; i++) {
        if (matrix[v][i] == 1 && !visited[i]) {
          queue.add(i);
          visited[i] = true;
          sb.append(i).append(" ");
        }
      }
    }
  }
}
