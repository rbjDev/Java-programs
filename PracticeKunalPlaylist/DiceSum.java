package PracticeKunalPlaylist;

public class DiceSum {
    public static void main(String args[]){
        dice("",5);
    }

    private static void dice(String p, int target) {
        if(target==0){
            System.out.println(p);
            return;
        }
        for(int i=1;i<=6;i++){
            if(i<=target){
                dice(p+i, target-i);
            }
        }
    }
    
}
