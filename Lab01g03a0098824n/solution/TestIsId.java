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
    //the string has completed checking
    if(s.isEmpty())
      return true;
    
    char id = s.charAt(s.length()-1);
    
    //check if the string begins with a digit
    if(s.length() == 1 && Character.isDigit(id))
      return false;
    
    //check if the string contains non java-identifier characters
    if(Character.isLetterOrDigit(id) || id == '_')
      s = s.substring(0,s.length()-1);
    else
      return false;
    
    return isId(s);
    
  }
}