package brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MovieDirector1436 {
  public void sol() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int input = Integer.parseInt(br.readLine());

    Integer n = 665;
    while (input != 0) {
      n++;
      if(n.toString().contains("666")) {
        input--;
      }
    }
    System.out.println(n);
  }
}
