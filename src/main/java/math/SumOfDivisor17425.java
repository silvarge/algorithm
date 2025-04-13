package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SumOfDivisor17425 {

  public static int MAX = 1000000;
  public void solution() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int count = Integer.parseInt(br.readLine());
    long[] f = new long[MAX+1];
    long[] g = new long[MAX+1];

    for (int i = 1; i <= MAX; i++) {
      for (int j = i; j <= MAX; j+=i) {
        f[j] += i;
      }
    }

    for (int i = 1; i <= MAX; i++) {
      g[i] = g[i-1] + f[i];
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < count; i++) {
      int n = Integer.parseInt(br.readLine());
      sb.append(g[n]).append('\n');
    }
    System.out.println(sb);
  }
}
