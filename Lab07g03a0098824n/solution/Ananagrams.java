import java.util.*;

public class Ananagrams {
 public static void main(String args[]) {
  Scanner sc = new Scanner(System.in);
  Map<String, String> ananaMap = new TreeMap<String, String>(); //for ananagrams
  Set<String> anaSet = new HashSet<String>(); //for anagrams
  
  System.out.print("Key in the dictionary: ");
  while(true) {
   String word = sc.next();

   if(word.equals("#")) {
    break;
   }

   //sort character in a string (alphabetic order)
   char[] charArray = word.toLowerCase().toCharArray();
   Arrays.sort(charArray);
   String sortedWord = new String(charArray);

   if(!ananaMap.containsValue(sortedWord)) {
    ananaMap.put(word, sortedWord);
   }
   else {
    anaSet.add(sortedWord);
   }

  }

  for(String anagram : anaSet){
   while(ananaMap.values().remove(anagram));
  }

  for(String ananagram : ananaMap.keySet())
  {
   System.out.println(ananagram); 
  }
  
  if(ananaMap.isEmpty()) {
    System.out.println("No ananagrams found.");
  }
  
  sc.close();
 }
}
