import java.util.Scanner;

public class ReadNums {
    void main() {
        Scanner sc = new Scanner(System.in);
        IO.println("Введите значение переменной a: ");
        int a = sc.nextInt();
        System.out.println("a = " + a);
        IO.println("теперь по-новому");
        IO.readln("теперь с приглашением: "); // только для строк
        String sb = IO.readln("введём же строку: ");
        IO.println("sb = " + sb);
        int b = Integer.parseInt(sb);
        IO.println("a+sb = " + (a + sb));
        // чтение с превращением
        int c = Integer.parseInt(IO.readln("Вводим значение c: "));
        double summa = a + b + c;
        IO.println("summa / 3 = " + summa / 3);
    }
}
