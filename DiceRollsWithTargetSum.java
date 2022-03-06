import java.util.ArrayList;
import java.util.List;

/**
 * Given a dice with six faces, find possible ways/combinations to get a target sum
 * e.g if target sum= 4
 * combinations possible ={1111,112,121,13,21,211,22,31,4}
 */
public class DiceRollsWithTargetSum {
    public static void main(String args[]){
        System.out.println("Combinations:"+ getCombinations("", 7));           
    }
    
    public static List<String> getCombinations(String p,int target){
        List<String> list = new ArrayList<>();
        if(target==0){
            list.add(p);
            return list;
        }
        for(int i=1;i<=6 && i<=target;i++){
            list.addAll(getCombinations(p+i, target-i));
        }
        return list; 
         
    }
}
