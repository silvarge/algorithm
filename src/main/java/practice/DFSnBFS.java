package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class DFSnBFS {

  public void practice() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken()); // 정점의 개수
    int M = Integer.parseInt(st.nextToken()); // 간선의 개수
    int V = Integer.parseInt(st.nextToken()); // 시작 정점

    // 크기(정점의 개수)에 맞는 인접 행렬 생성
    int[][] adjMat = new int[N + 1][N + 1];

    int u, v;

    // 간선 연결
    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      u = Integer.parseInt(st.nextToken());
      v = Integer.parseInt(st.nextToken());
      adjMat[u][v] = adjMat[v][u] = 1; // 양방향 간선
    }

    boolean[] visited = new boolean[adjMat.length];
    System.out.println("DFS 탐색 시작 - Stack");
    DFS(adjMat, visited, V);
    System.out.println();

    visited = new boolean[adjMat.length];
    System.out.println("DFS 탐색 시작 - 재귀");
    DFS_R(adjMat, visited, V);
    System.out.println();

    visited = new boolean[adjMat.length];
    System.out.println("BFS 탐색 시작 - Queue");
    BFS(adjMat, visited, V);

  }

  /**
   * DFS (깊이 우선 탐색) 구현 - Stack 이용
   *
   * @param adjMat 정점들 간 연결 관계를 나타내는 인접 행렬
   * @param visited 방문 여부 확인 배열
   * @param v 탐색을 시작할 정점의 인덱스
   */
  public static void DFS(int[][] adjMat, boolean[] visited, int v) {
    int n = adjMat.length;
    Stack<Integer> stack = new Stack<>();

    stack.push(v);  // 시작 정점을 스택에 넣음 (탐색 시작할 정점 세팅)
    while (!stack.isEmpty()) {  // 스택이 빌 때까지 반복을 함
      int vertex = stack.pop(); // 정점을 하나 꺼냄
      if(!visited[vertex]) {  // 해당 정점을 방문하지 않았다면
        visited[vertex] = true; // 방문했다고 표시
        System.out.print(v + " ");

        // 인접 행렬을 이용해 연결된 정점들을 확인 (오름차순이 아닌 내림차순으로 순회)
        for (int i = n - 1; i >= 1; i--) {
          // 정점과 i가 연결되어 있고, 아직 i를 방문하지 않았다면
          if (adjMat[vertex][i] == 1 && !visited[i]) {
            stack.push(i);  // i를 스택에 추가 (다음에 방문할 후보로 등록)
          }
        }
      }
    }
  }

  /**
   * DFS (깊이 우선 탐색) 구현 - 재귀 이용
   *
   * @param adjMat 정점들 간 연결 관계를 나타내는 인접 행렬
   * @param visited 방문 여부 확인 배열
   * @param v 탐색 대상 인덱스
   */
  public static void DFS_R(int[][] adjMat, boolean[] visited, int v) {
    int n = adjMat.length;

    if(visited[v]) {  // 해당 정점을 방문했다면
      return;   // 리턴
    }

    // 방문하지 않았다면, 방문했다고 표시
    visited[v] = true;
    System.out.print(v + " ");

    // 인접한 정점들을 탐색
    for (int i = 1; i < n; i++) {
      // 정점과 i가 연결되어 있고, 아직 i를 방문하지 않았다면
      if (adjMat[v][i] == 1 && !visited[i]){
        DFS_R(adjMat, visited, i);  // i(다음 방문 후보)값으로 재귀 호출
      }
    }
  }

  /**
   * BFS (너비 우선 탐색) 구현 - Queue 이용
   * @param adjMat 정점들 간 연결 관계를 나타내는 인접 행렬
   * @param visited 방문 여부 확인 배열
   * @param v 탐색 대상 인덱스
   */
  public static void BFS(int[][] adjMat, boolean[] visited, int v) {
    int n = adjMat.length;
    Queue<Integer> queue = new LinkedList<>();

    queue.add(v); // 시작 정점을 큐에 추가
    visited[v] = true;  // 시작 정점 방문했다고 표시
    System.out.print(v + " ");

    while (!queue.isEmpty()) {  // 큐가 빌 때까지 반복
      int vertex = queue.poll();  // 방문한 정점 하나 꺼냄

      // 인접한 정점들을 탐색 (현재 정점과 연결된 모든 정점들을 검사)
      for (int i = 0; i < n; i++) {
        // 정점과 i가 연결되어 있고, 아직 i를 방문하지 않았다면
        if (adjMat[vertex][i] == 1 && !visited[i]) {
          queue.add(i); // 다음 방문 후보로 큐에 넣음
          visited[i] = true;   // 후보를 넣을 때 미리 방문했다고 표시 (중복 방지)
          System.out.print(i + " ");
        }
      }
    }
  }

}
