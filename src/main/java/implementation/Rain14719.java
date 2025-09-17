package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Rain14719 {

  public void solution() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    // 2차원 세계 높이/너비 값 입력받기
    int H = Integer.parseInt(st.nextToken()); // 높이
    int W = Integer.parseInt(st.nextToken()); // 너비

    // 2차원 세상 만들기
    int[][] world = new int[H][W];
    st = new StringTokenizer(br.readLine());

    // 벽 세우기
    int wall;
    for (int i = 0; i < W; i++) {
      wall = Integer.parseInt(st.nextToken());
      for (int j = 1; j <= wall; j++) {
        world[H - j][i] = 1;
      }
    }

    int totalRain = 0;

    int startIdx; // 벽 인덱스 만났을 때
    boolean flag; // 상대 벽을 찾고 있는지 여부
    for (int i = 0; i < H; i++) {
      // 인덱스 값 초기화
      startIdx = -1;
      flag = false;
      for (int j = 0; j < W; j++) {
        // 벽을 만나면
        if (world[i][j] == 1) {
          // 만약 상대 벽 찾기 시작을 하지 않았다면
          if (!flag) {
            startIdx = j;
            flag = true;
          } else if (startIdx > -1) {
            // 만약 상대 벽 찾기 시작을 했고, 시작 인덱스에 값이 있다면
            // 막는 벽을 찾은 상황 => 빗물이 고일 수 있는 상황
            totalRain += j - startIdx - 1;
            startIdx = j;
          }
        }
      }
    }

    System.out.println(totalRain);

  }

}
