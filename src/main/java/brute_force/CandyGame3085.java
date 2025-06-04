package brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CandyGame3085 {

  public static char[][] ARR;
  public static int MAX = 0;

  public void solution() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    ARR = new char[n][n];
    String str;
    for (int i = 0; i < n; i++) {
      str = br.readLine();
      for (int j = 0; j < n; j++) {
        ARR[i][j] = str.charAt(j);
      }
    }

    // 가로로 하나씩 변경
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n - 1; j++) {
        swap(i, j, i, j + 1);
        search(n);
        swap(i, j, i, j + 1);
      }
    }

    // 세로로 변경했을 때
    for (int i = 0; i < n - 1; i++) {
      for (int j = 0; j < n; j++) {
        swap(i, j, i + 1, j);
        search(n);
        swap(i, j, i + 1, j);
      }
    }
    System.out.println(MAX);
  }

  // swap
  public static void swap(int x1, int y1, int x2, int y2) {
    char temp = ARR[x1][y1];
    ARR[x1][y1] = ARR[x2][y2];
    ARR[x2][y2] = temp;
  }

  // search
  public static void search(int n) {
    int count = 0;
    // 가로
    for (int i = 0; i < n; i++) {
      count = 1;
      for (int j = 0; j < n - 1; j++) {
        if (ARR[i][j] == ARR[i][j + 1]) {
          count++;
          MAX = Math.max(MAX, count);
        } else {
          count = 1;
        }
      }
    }

    // 세로
    for (int i = 0; i < n; i++) {
      count = 1;
      for (int j = 0; j < n - 1; j++) {
        if (ARR[j][i] == ARR[j + 1][i]) {
          count++;
          MAX = Math.max(MAX, count);
        } else {
          count = 1;
        }
      }
    }
  }
}
