package Lamdas;

import java.util.function.BiFunction;
import java.util.function.Function;

interface MyTriFunction<A,B,C,R>{
    R apply(A a, B b, C c);
}

interface MyNoArgFunction<R>{
    R apply();
}

public class LambdaDemo {
    public static void main(String[] args){

        //function interface taking a single argument
        Function<Integer,Integer> absoluteValue = (x)-> {
            if(x<0) return -x;
            else return x;
        };

        System.out.println(absoluteValue.apply(-5));

        //Bifunction interface that takes two arguments

        BiFunction<Integer,Integer,Integer> sum = (x,y) -> x+y;
        System.out.println("Sum using bi-functional interface:" + sum.apply(4, 5));

        //Function interface that takes three arguments
        MyTriFunction<Integer,Integer,Integer,Integer> sumOfThree = (a,b,c) -> a+b+c;
        System.out.println("SUm of 3 using Trifunction interface:" + sumOfThree.apply(2,3,6));

        //Functional interface that takes no argument
        MyNoArgFunction<String> greet = ()-> "Hello World";
        System.out.println("Greet using no-arg functional interface:" + greet.apply());

    }
    
}
