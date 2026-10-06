public class CoffeeAsker {
    /* Если  больше 300, то вывести "Дороговато"
Если от 150 до 300, то вывести "Норм"
Если от 80 до 150, то "Дешево"
Если меньше 80, то вывести "А это в рублях? А это вообще кофе?" */
    void main() {
        int price = Integer.parseInt(IO.readln("Введите цену кофе: "));
        String answer = "А это в рублях? А это вообще кофе?";
        if (price > 300) {
            answer = "Дороговато";
        } else if (price >= 150) {
            answer = "Норм";
        } else if (price >= 80) {
            answer = "Дёшево";
        }
        IO.println(answer);
    }
}
