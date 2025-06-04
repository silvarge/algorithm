package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MathIsOnline19532 {

  public void solution() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] prepared = br.readLine().split(" ");

    int a = Integer.parseInt(prepared[0]);
    int b = Integer.parseInt(prepared[1]);
    int c = Integer.parseInt(prepared[2]);
    int d = Integer.parseInt(prepared[3]);
    int e = Integer.parseInt(prepared[4]);
    int f = Integer.parseInt(prepared[5]);

    for (int i = -999; i <= 999; i++) {
      for (int j = -999; j <= 999; j++) {
        if ((a * i + b * j == c) && (d * i + e * j == f)) {
          System.out.println(i + " " + j);
          return;
        }
      }
    }
  }
}
