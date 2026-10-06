/*
     Оргкомитет Московской городской олимпиады решил организовать
     обзорную экскурсию по Москве для участников олимпиады.
     Для этого был заказан двухэтажный автобус (участников олимпиады
     достаточно много и в обычный они не умещаются) высотой 437 сантиметров.
     На экскурсионном маршруте встречаются N мостов.
     Жюри и оргкомитет олимпиады очень обеспокоены тем, что высокий
     двухэтажный автобус может не проехать под одним из них.
     Им удалось выяснить точную высоту каждого из мостов.
     Автобус может проехать под мостом тогда и только тогда,
     когда высота моста превосходит высоту автобуса.

     Первая строка входных данных содержит число N (1 ≤ N ≤ 1000).
     Вторая строка содержит N натуральных чисел, не превосходящих 10000,
     через пробел - высо́ты мостов в сантиметрах в том порядке,
     в котором они встречаются на пути автобуса.
    */
static int BUS_HEIGHT = 437;

static Scanner input = new Scanner(System.in);

static boolean crashes(int vehicleHeight, int bridgeHeight) {
    return vehicleHeight >= bridgeHeight;
}

void main() {
    IO.println("Введите количество мостов: ");
    int N = input.nextInt();
    if (N < 1) {
        IO.println("Должен быть хотя бы один мост.");
        N = 1;
    }
    if (N > 1000) {
        IO.println("Должно быть не более 1000 мостов.");
        N = 1000;
    }
    int[] heights = new int[N];
    IO.println("Введите высо́ты мостов в сантиметрах: ");
    for (int i = 0; i < N; i++) {
        int next = input.nextInt();
        if (next > 10000) {
            IO.println("Высота моста не может быть больше 100 метров.");
            next = 10000;
        }
        heights[i] = next;
    }

    int crashingBridgeIndex = -1;
    for (int i = 0; i < N; i++)
        if (crashes(BUS_HEIGHT, heights[i])) {
            crashingBridgeIndex = i;
            break;
        }

    String report = crashingBridgeIndex == -1 ?
            "No crash" : "Crash " + (crashingBridgeIndex + 1);
    IO.println(report);
}
