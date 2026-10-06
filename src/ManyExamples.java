public class ManyExamples {
    void main() {
        IO.println("делаю пример 1");
        example2();
        twoBandits();
    }

    private void twoBandits() {
        int shotByHarry = Integer.parseInt(IO.readln("Сколько прострелил Гарри: "));
        int shotByLarry = Integer.parseInt(IO.readln("Сколько прострелил Ларри: "));
        int totalJars = shotByHarry + shotByLarry - 1;
        IO.println("Всего выстрелов: " + totalJars);
        IO.println("Гарри не прострелил " + (totalJars - shotByHarry));
        IO.println("Ларри не прострелил " + (totalJars - shotByLarry));

    }

    void paperCranes() {
        int Петя, Катя, Серёжа;
//        int total = Петя + Катя + Серёжа;
//        Петя == Серёжа;
//        Катя = 2 * (Петя + Серёжа);
//        
    }

    private static void example2() {
        IO.println("делаю пример 2");
    }

    void example1() {
        IO.println("делаю пример 1");
        IO.println("ещё что-то");
    }



}
