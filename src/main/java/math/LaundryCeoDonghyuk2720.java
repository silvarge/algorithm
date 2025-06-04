package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LaundryCeoDonghyuk2720 {

  public void solution() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < n; i++) {
      int money = Integer.parseInt(br.readLine());
      sb.append(
          money / 25 + " " + (money % 25) / 10 + " " + ((money % 25) % 10) / 5 + " " + (money % 5)
              + "\n");
    }
    System.out.println(sb);
  }
}
