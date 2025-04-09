public class Basic {

  void compareString(){
    String str1 = "str";
    String str2 = "str";
    String str3 = new String("str");
    String str4 = new String(str1);
    String str5 = new String("str");
    String str6 = str1;
    String str7 = str3;

    System.out.println("str1 / str2: " + (str1 == str2));
    System.out.println("str1 / str3: " + (str1 == str3));
    System.out.println("str1 / str4: " + (str1 == str4));
    System.out.println("str3 / str4: " + (str3 == str4));
    System.out.println("str4 / str5: " + (str4 == str5));
    System.out.println("str3 / str5: " + (str3 == str5));
    System.out.println("str2 / str6: " + (str2 == str6));
    System.out.println("str7 / str1: " + (str7 == str1));
    System.out.println("str7 / str3: " + (str7 == str3));
    System.out.println("str7 / str5: " + (str7 == str5));
  }
}
