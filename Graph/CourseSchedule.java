import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 210. Course Schedule II
There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

    For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.

Return the ordering of courses you should take to finish all courses. If there are many valid answers, return any of them. If it is impossible to finish all courses, return an empty array.
 */

public class CourseSchedule {

    public static void main(String[] args) {
        int prerequisites[][]= {{1,0},{2,0},{3,1},{3,2}};
        System.out.println(Arrays.toString(findOrder(4, prerequisites)));
    }
    public static  int[] findOrder(int numCourses, int[][] prerequisites) {
        // Create a graph representation of the prerequisites
       List<Integer>[] graph = new ArrayList[numCourses];
       int[] inDegree = new int[numCourses];
       for(int i = 0; i < numCourses; i++)
           graph[i] = new ArrayList<>();

       for(int[] prereq : prerequisites) {
           int course = prereq[0];
           int prereqCourse = prereq[1];
           graph[prereqCourse].add(course);
           inDegree[course]++;
       }

       // Perform topological sort

       Queue<Integer> queue = new LinkedList<>();
       for(int i = 0; i < numCourses; i++)
           if(inDegree[i] == 0)
               queue.offer(i);


       int[] result = new int[numCourses];
       int index = 0;
       while(!queue.isEmpty()) {
           int course = queue.poll();
           result[index++] = course;
           for(int neighbor : graph[course]) {
               inDegree[neighbor]--;
               if(inDegree[neighbor] == 0)
                   queue.offer(neighbor);

           }
       }

       // Check if all courses can be taken

       if(index == numCourses)
           return result;
       else
           return new int[0];

   }
}
