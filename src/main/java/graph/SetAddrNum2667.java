package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class SetAddrNum2667 {

  // 지도 크기
  static int N;
  // 그래프/방문 여부
  static char[][] map;
  static boolean[][] visited;

  // 단지 개수 계산용 데이터
  static int count = 0;
  // 결과값 저장할 리스트
  static List<Integer> result = new ArrayList<>();

  // 상하좌우
  static int[] dx = {0, 0, 1, -1};
  static int[] dy = {1, -1, 0, 0};

  static void search(int x, int y) {
    visited[x][y] = true;
    count++;

    // 상하좌우 반복하며 탐색
    for (int dir = 0; dir < 4; dir++) {
      // 새로 탐색할 위치 설정 (x, y 좌표)
      int newX = x + dx[dir];
      int newY = y + dy[dir];

      // 탐색할 위치 좌표가 지도의 크기를 벗어나면 그냥 넘어감
      if (newX < 0 || newX >= N || newY < 0 || newY >= N) {
        continue;
      }

      // 새 좌표를 방문하지 않았고, 그 좌표의 데이터가 '1' 이라면 탐색 수행
      if (!visited[newX][newY] && map[newX][newY] == '1') {
        search(newX, newY);
      }
    }

  }

  public void solution() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    N = Integer.parseInt(br.readLine());

    // 그래프, 방문 여부 데이터 할당
    map = new char[N][N];
    visited = new boolean[N][N];

    // 그래프에 입력된 데이터 넣기
    for (int i = 0; i < N; i++) {
      char[] array = br.readLine().toCharArray();
      for (int j = 0; j < N; j++) {
        map[i][j] = array[j]; // 0이나 1
      }
    }

    // 탐색 시작
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        // 새로운 단지 탐색
        // 방문하지 않은 곳 + 그래프 값이 1인 곳을 방문하여 탐색 시작
        if (!visited[i][j] && map[i][j] == '1') {
          search(i, j);
          result.add(count);  // 탐색 후 단지 개수 결과 리스트에 저장
          count = 0;  // 단지 개수 데이터 초기화
        }
      }
    }

    result.sort(null);  // 결과 오름차순 정렬
    sb.append(result.size()).append("\n");  // 총 개수 출력용 빌더에 추가
    result.forEach(rst -> sb.append(rst).append("\n")); // 단지 개수 출력용 빌더에 반복하여 추가

    System.out.println(sb);
  }

}
