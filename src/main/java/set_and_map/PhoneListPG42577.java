package set_and_map;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class PhoneListPG42577 {

  public boolean solution(String[] phone_book) {
    // 오름차순 정렬
    Arrays.sort(phone_book);

    for(int i=1; i<phone_book.length; i++) {
      if(phone_book[i].startsWith(phone_book[i-1])) {
        return false;
      }
    }

    return true;
  }

}
