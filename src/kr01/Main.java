package kr01;

public class Main {
   public static void main(String[] args) {
        int k = 5;
        f1(k);
        System.out.println(""+k);
    }

    public static void f1(int x)
    {
        x += x--;
        System.out.println(x);



    }
}