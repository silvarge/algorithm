package brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NandM15650 {

  public static int[] arr = new int[9];
  public static StringBuilder sb = new StringBuilder();

  public void solution() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] input = br.readLine().split(" ");
    int n = Integer.parseInt(input[0]);
    int m = Integer.parseInt(input[1]);

    f(0, n, m);
    System.out.println(sb);

  }

  void print(int n) {
    for (int i = 1; i <= n; i++) {
      if (arr[i] == 1) {
        sb.append(i + " ");
      }
    }
    sb.append("\n");
  }

  void f(int start, int n, int m) {
    if (m < 1) {
      print(n);
      return;
    }
    for (int i = start + 1; i <= n; i++) {
      arr[i] = 1;
      f(i, n, m - 1);
      arr[i] = 0;
    }
  }
}
