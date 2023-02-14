package com.example.demo.recusrion;

public class RecursionPractice {
    static int[] arr;
    static String str= "bottle";
    public static void main(String[] args){
        RecursionPractice recursionPractice = new RecursionPractice();
        recursionPractice.printNumbersAsc(1);
        System.out.println();
        recursionPractice.printNumbersDesc(6);
        System.out.println("Sum of first 10 Natural Numbers"+recursionPractice.sumOfNNaturalNumbers(39));
        System.out.println("Factorial of 5 is"+recursionPractice.factorialOfANumber(10));
        System.out.print(0+"\t"+1+"\t");
        recursionPractice.fibanocciSeries(0,1,8);
        arr = new int[]{10, 203, 40, 20};
        arrayReversal(0, arr.length-1);
        System.out.println("After ArrayReversal:");
        for(int i=0 ;i<arr.length ; i++){
            System.out.print(arr[i]+"\t");
        }
        System.out.println(isPalindromeRecursion(0));
    }
    void printNumbersAsc(Integer num){
        if(num>6){
            return;
        }
        System.out.print(num+ "\t");
        printNumbersAsc(num+1);
    }
    void printNumbersDesc(Integer num){
        if(num == 0){
            return;
        }
        System.out.print(num+"\t");
        printNumbersDesc(num-1);
    }
    int sumOfNNaturalNumbers(int num){
        if(num ==0){
            return 0;
        }
        return sumOfNNaturalNumbers(num-1)+num;
    }
    int factorialOfANumber(int num){
        if(num==1 || num==0){
            return 1;
        }
        return factorialOfANumber(num-1)*num;
    }
    void fibanocciSeries(int a,int b, int num){
        if(num==0){
            return;
        }
        int c= a+b;
        System.out.print(c+"\t");
        fibanocciSeries(b,c,num-1);
    }
    static void arrayReversal(int l ,int r){
        if(l>=r){
            return;
        }
        arr[l] = arr[l]+arr[r];
        arr[r] = arr[l]-arr[r];
        arr[l] = arr[l]-arr[r];
        arrayReversal(l+1,r-1);
    }
    static boolean isPalindromeRecursion(int i){
        if(i>=(str.length()/2)){
            return true;
        }
        if(str.charAt(i)!=str.charAt(str.length()-i-1)){
            return false;
        }
        return isPalindromeRecursion(i+1);
    }
}
