import java.util.HashMap;
import java.util.Map;

public class CustomClassAsKey {
    public static class Coordinate{
        int x;
        int y;
        Coordinate(int x, int y){
            this.x=x;
            this.y=y;
        }
        public int getX() {
            return x;
        }
        public void setX(int x) {
            this.x = x;
        }
        public int getY() {
            return y;
        }
        public void setY(int y) {
            this.y = y;
        }
        
        @Override
        public String toString() {
            return "Coordinate [x=" + x + ", y=" + y + "]";
        }
        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + x;
            result = prime * result + y;
            return result;
        }
        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Coordinate other = (Coordinate) obj;
            if (x != other.x)
                return false;
            if (y != other.y)
                return false;
            return true;
        }      

    }

    public static void main(String args[]){
        Coordinate c1= new Coordinate(1,2);
        Coordinate c2= new Coordinate(2,3);
        Coordinate c3= new Coordinate(3,4);
        Map<Coordinate,String> map = new HashMap<>();
        map.put(c1, "first");
        map.put(c2, "second");
        map.put(c3, "third");
        System.out.println(map);
    }

}
