package brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Blackjack2798 {

  public void solution() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());
    int[] card = new int[n];
    for (int i = 0; i < n; i++) {
      card[i] = Integer.parseInt(st.nextToken());
    }

    int result = -1;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
          for (int k = 0; k < n; k++) {
            if(i != j && j != k && i != k) {
              int temp = card[i] + card[j] + card[k];
              if(temp <= m && temp >= result) {
                result = temp;
              }
            }
        }
      }
    }
    System.out.println(result);
  }
}
