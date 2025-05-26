package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class DFSandBFS1260 {

  static int[][] graph;
  static boolean[] visited;
  static StringBuilder sb = new StringBuilder();

  public void solution() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int V = Integer.parseInt(st.nextToken());

    graph = new int[N + 1][N + 1];

    int u, v;

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      u = Integer.parseInt(st.nextToken());
      v = Integer.parseInt(st.nextToken());
      graph[u][v] = graph[v][u] = 1; // 양방향 간선
    }

    visited = new boolean[N + 1];
    dfs(V);
    sb.append("\n");
    visited = new boolean[N + 1];
    bfs(V);

    System.out.println(sb);

  }

  public static void dfs(int value) {
    visited[value] = true;
    sb.append(value).append(" ");

    if(value == graph.length) {
      return;
    }

    for (int i = 1; i < graph.length; i++) {
      if (graph[value][i] == 1 && !visited[i]) {
        dfs(i);
      }
    }
  }

  public static void bfs(int value) {
    Queue<Integer> queue = new LinkedList<>();
    queue.add(value);
    visited[value] = true;
    sb.append(value).append(" ");

    while (!queue.isEmpty()) {
      int temp = queue.poll();
      for (int i = 1; i < graph.length; i++) {
        if(graph[temp][i] == 1 && !visited[i]) {
          queue.add(i);
          visited[i] = true;
          sb.append(i).append(" ");
        }
      }
    }
  }
}
