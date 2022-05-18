import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class FailSafeAndFast {
    public static void main(String args[]){
        // Map<String,String> map = new HashMap<>();
        // map.put("ab", "Ram");
        // map.put("bc", "Rm");
        // map.put("ac", "am");
        // Iterator<String> iterator = map.keySet().iterator();
        // while(iterator.hasNext()){
        //     System.out.println(iterator.next());
        //     //map.put("acd", "am"); //Fail-fast
        //     iterator..remove();

        // }
        // System.out.println(map);
        
      ArrayList<String> aList = new ArrayList<String>();
      aList.add("Apple");
      aList.add("Mango");
      aList.add("Guava");
      aList.add("Orange");
      aList.add("Peach");
      System.out.println("The ArrayList elements are: ");
      for (String s: aList) {
         System.out.println(s);
      }
      Iterator i = aList.iterator();
      String str = "";
      while (i.hasNext()) {
         str = (String) i.next();
         if (str.equals("Orange")) {
            i.remove();
            System.out.println("\nThe element Orange is removed");
            break;
         }
      }
      System.out.println("\nThe ArrayList elements are: ");
      for (String s: aList) {
         System.out.println(s);
      }

    }
}
