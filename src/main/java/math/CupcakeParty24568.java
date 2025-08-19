package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 11:21
public class CupcakeParty24568 {

  public void solution() throws IOException {
    // 8개 박스(R)와 3개 박스(S)의 개수
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int R = Integer.parseInt(br.readLine());
    int S = Integer.parseInt(br.readLine());

    int totalCake = 8 * R + 3 * S;
    System.out.println(totalCake - 28);

  }

}
