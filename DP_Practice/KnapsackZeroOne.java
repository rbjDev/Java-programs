package DP_Practice;

import java.util.Arrays;

public class KnapsackZeroOne {
    static int table[][];
    public static void main(String[] args) {
        int values[] = {60,100,120};
        int weights[] = {10,20,30};
        int weight = 50;
        table = new int[values.length+1][weight+1];
        for(int i = 0;i<table.length;i++)
            Arrays.fill(table[i], -1);
        System.out.println(maxValueMemoized(values,weights,weight,values.length));
    }

    static int maxValue(int values[],int weights[],int weight,int n){
        if(weight==0 || n==0)
            return 0;
        if(weights[n-1] <= weight ){
            return Math.max( values[n-1] + maxValue(values, weights, weight - weights[n-1], n-1),
                                        maxValue(values, weights, weight, n-1));
        }
        else{
            return maxValue(values, weights, weight, n-1);
        }
    }

    static int maxValueMemoized(int values[],int weights[],int weight,int n){
        if(weight==0 || n==0)
            return 0;
        if(table[n][weight]!=-1) return table[n][weight];
        if(weights[n-1] <= weight ){
            table[n][weight] =  Math.max( values[n-1] + maxValue(values, weights, weight - weights[n-1], n-1),
                                        maxValue(values, weights, weight, n-1));
        }
        else{
            table[n][weight] =  maxValue(values, weights, weight, n-1);
        }
        return table[n][weight];
    }


}
