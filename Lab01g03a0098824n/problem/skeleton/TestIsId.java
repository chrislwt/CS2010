// TestIsId

import java.io.*;
import java.util.*;

public class TestIsId
{
  public static void main( String [ ] args )
  {
    Scanner scan = new Scanner(System.in);
    String s;
    while (scan.hasNext()) {  
      s = scan.next();
      if (isId(s)) {
        System.out.println(s + " is an identifier");
      } else {
        System.out.println(s + " is not an identifier");
      }
    }
    return;
  }
  
  public static boolean isId( String s )
  {

  }
}