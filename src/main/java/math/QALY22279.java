package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class QALY22279 {

  public void solution() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    double QALY = 0;
    StringTokenizer st;

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      QALY += Double.parseDouble(st.nextToken()) * Double.parseDouble(st.nextToken());
    }

    System.out.printf("%.3f%n", QALY);
  }

}
