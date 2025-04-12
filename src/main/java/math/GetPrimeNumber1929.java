package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class GetPrimeNumber1929 {
  public void solution() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int m = Integer.parseInt(st.nextToken());
    int n = Integer.parseInt(st.nextToken());

    int[] isPrime = new int[n+1];

    for (int i = 2; i <= n; i++) {
      isPrime[i] = i;
    }

    for (int i = 2; i <= n; i++) {
      if(isPrime[i]==0) {
        continue;
      }
      for (int j = 2 * i; j <= n; j+=i) {
        isPrime[j] = 0;
      }
    }

    for(int i=m; i<=n; i++){
      if(isPrime[i] != 0) {
        System.out.println(i);
      }
    }
  }
}
