package graph;

public class NetworkPG43162 {


  static void dfs(int[][] computers, int target, boolean[] visited) {
    if (target == computers.length) {
      return;
    }
    visited[target] = true;

    for (int i = 0; i < computers.length; i++) {
      if (computers[target][i] == 1 && !visited[i]) {
        dfs(computers, i, visited);
      }
    }
  }

  public int solution(int n, int[][] computers) {
    int answer = 0;
    boolean[] visited = new boolean[n];

    for (int i = 0; i < n; i++) {
      if (!visited[i]) {
        dfs(computers, i, visited);
        answer++;
      }
    }

    return answer;
  }

}
