package Generics;

public class GenericClass<T> {
    T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public GenericClass(T data) {
        this.data = data;
    }

    public static void main(String[] args) {
        GenericClass<?> obj = new GenericClass<Integer>(5);
        System.out.println(obj.getData());
        GenericClass<Double> obj1 = new GenericClass<>(5.5);
        Double doubleVal = obj1.getData();
        System.out.println(obj.getData());
    }
}
