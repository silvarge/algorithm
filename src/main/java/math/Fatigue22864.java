package math;

import java.io.IOException;
import java.util.*;
import java.io.*;

public class Fatigue22864 {
  public void solution() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] input = br.readLine().split(" ");
    int a = Integer.parseInt(input[0]);
    int b = Integer.parseInt(input[1]);
    int c = Integer.parseInt(input[2]);
    int m = Integer.parseInt(input[3]);
    int result = 0, fatigue = 0;

    for (int i = 1; i <= 24; i++) {
      if(fatigue + a > m) {
        fatigue -= c;
        fatigue = Math.max(fatigue, 0);
        continue;
      }
      fatigue += a;
      result += b;
    }
    System.out.println(result);
  }
}
