package kr01;

public class kr01 {
    static void main() {
        task1();
        task2();
        task3();
        task4();

    }

    private static void task1() {
        double x = 0, y = 10;
        System.out.println(x + y);
        System.out.println("ы" + x + y);
        int z = (int) (25 - y);
        System.out.println(x + " " + y + " " + z);
    }

    private static void task2() {
        int i = 0, N = 7, x = 2;
//        i=5;
        while (i <= N) {
            ++i;
            x *= 2;
        }
        System.out.println("i=" + i + " x=" + x);
    }

    private static void task3() {
        int i, N=7, x=2;
        for(i=4; i<N; i++);
        x*=2;
        System.out.println("i="+i+" x="+x);
    }

    private static void task4() {

    }
}
