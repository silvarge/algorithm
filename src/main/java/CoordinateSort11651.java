import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class CoordinateSort11651 {
  public void solution() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int count = Integer.parseInt(br.readLine());
    int[][] arr = new int[count][2];

    for (int i = 0; i < count; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      arr[i][0] = Integer.parseInt(st.nextToken());
      arr[i][1] = Integer.parseInt(st.nextToken());
    }

    arr = mergeSort(arr);

    for (int i = 0; i < count; i++) {
      System.out.println(arr[i][0] + " " + arr[i][1]);
    }
  }

  int[][] mergeSort(int[][] arr){
    if(arr.length < 2) return arr;

    int mid = arr.length/2; // 중간 값
    int[][] low_arr = mergeSort(Arrays.copyOfRange(arr, 0, mid));
    int[][] high_arr = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));

    int[][] mergedArr = new int[arr.length][2];
    int m = 0, l = 0, h = 0;
    while (l < low_arr.length && h < high_arr.length){
      if((low_arr[l][1] < high_arr[h][1]) || (low_arr[l][1] == high_arr[h][1] && low_arr[l][0] < high_arr[h][0])) {
        mergedArr[m++] = low_arr[l++];
      }else {
        mergedArr[m++] = high_arr[h++];
      }
    }
    while (low_arr.length > l) {
      mergedArr[m++] = low_arr[l++];
    }
    while (high_arr.length > h) {
      mergedArr[m++] = high_arr[h++];
    }
    return mergedArr;
  }
}
