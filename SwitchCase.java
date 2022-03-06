import java.util.Scanner;

public class SwitchCase{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter your choice:");
        String choice = in.next();
        System.out.println("Your fruit choice: "+ choice);
        switch(choice){
            case "apple":
                    System.out.println("An apple a day keeps the doc away!");
                    break;
            case "grapes":
                    System.out.println("Rich in potassium!");
                    break;
            case "mango":
                    System.out.println("King of fruits!");
                    break;

            default:
                    System.out.println("Wrong choice :" + choice);
        }
    //Enhanced Switch
        System.out.println("Enter Month:");
        int m = in.nextInt();
        System.out.println("Your month input: "+ m);
        // switch(month){
        //     case "Jan" ,"Mar" -> 31;


        // }
        in.close();
        
    }
    
}