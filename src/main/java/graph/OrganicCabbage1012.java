package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class OrganicCabbage1012 {

  // 테스트 케이스의 개수
  static int T;

  // 가로 길이, 세로 길이, 배추가 심어져 있는 위치 개수
  static int M, N, K;

  // 결괏값들을 저장할 장소
  static List<Integer> result = new ArrayList<>();

  // 그래프 정의
  static int[][] graph;

  // 방문 여부 판단
  static boolean[][] visited;

  // 필요한 지렁이 개수
  static int worm = 0;

  // 상하좌우 좌표
  static int[] dx = {0, 0, -1, 1};
  static int[] dy = {1, -1, 0, 0};

  // 탐색 로직
  static void bfs(int x, int y) {
    visited[x][y] = true;

    // 상하좌우 탐색
    for (int dir = 0; dir < 4; dir++) {
      int newX = x + dx[dir];
      int newY = y + dy[dir];

      // 좌표 벗어나면 넘기기
      if (newX < 0 || newX >= M || newY < 0 || newY >= N) {
        continue;
      }

      // 방문하지 않은 곳이고, 배추가 심어져 있는 곳이라면 탐색
      if (!visited[newX][newY] && graph[newX][newY] == 1) {
        bfs(newX, newY);
      }
    }
  }

  public void solution() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    T = Integer.parseInt(br.readLine());

    // 임시 X, Y
    int tX, tY;

    // 테스트 케이스만큼 반복
    while (T > 0) {
      st = new StringTokenizer(br.readLine());
      M = Integer.parseInt(st.nextToken());
      N = Integer.parseInt(st.nextToken());
      K = Integer.parseInt(st.nextToken());

      graph = new int[M][N];
      visited = new boolean[M][N];

      // 그래프 세팅
      for (int i = 0; i < K; i++) {
        st = new StringTokenizer(br.readLine());
        tX = Integer.parseInt(st.nextToken());
        tY = Integer.parseInt(st.nextToken());

        graph[tX][tY] = 1;
      }

      // 탐색 시작
      for (int i = 0; i < M; i++) {
        for (int j = 0; j < N; j++) {
          if (!visited[i][j] && graph[i][j] == 1) {
            bfs(i, j);
            worm++;
          }
        }
      }

      // 결과값 추가
      result.add(worm);
      worm = 0;
      T--;
    }

    // 출력 처리
    StringBuilder sb = new StringBuilder();
    result.forEach(worms -> sb.append(worms).append("\n"));
    System.out.println(sb);

  }

}
