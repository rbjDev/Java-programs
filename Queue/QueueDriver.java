package Queue;
import java.util.*;
public class QueueDriver {
    public static void main(String args[]){
        Queue<Integer> q = new LinkedList<>();
        q.add(5);
        q.add(6);
        q.add(7);
        Iterator<Integer> it = q.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }

        //Using Dequeue as queue
        Queue<Integer> q1 = new ArrayDeque<>();
        q1.offer(5);
        q1.offer(10);
        System.out.println("Queue poll:" +q1.poll());
        q1.poll();

        //Using Dequeue as stack
        Deque<String> d1 = new ArrayDeque<String>();
        d1.push("Stack1");
        d1.push("Stack2");
        d1.pop();
        System.out.println(d1.peek());


      


    }
}
