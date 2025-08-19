package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JustRoundDown32458 {

  public void solution() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    double x = Double.parseDouble(br.readLine());

    System.out.println(Math.floorDiv((int)x, 1));
  }

}
