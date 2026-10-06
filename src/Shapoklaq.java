static boolean isNotValidAmount(int amount) {
    return amount < 2 || amount >= 1000;
}

void main() {
    int p, k; // кол-во карт в первой и последней стопке
    do {
        p = Integer.parseInt(IO.readln("Введи кол-во карт в первой стопке: "));
    } while (isNotValidAmount(p));
    do {
        k = Integer.parseInt(IO.readln("Введи кол-во карт в последней стопке: "));
    } while (isNotValidAmount(k) || k < p);

    int[] stacks = new int[k - p + 1]; // модель стопок
    for (int i = 0; i < stacks.length; i++)
        stacks[i] = k + i;

    int count = 0; // сколько проходов стопок
    boolean notReady = true;

    while (notReady) {
        notReady = false;
        for (int i = 0; i < stacks.length; i++) {
            int stack = stacks[i];
            if (stack != 2) {
                notReady = true;
                if (stack % 2 == 0) stacks[i] = stack / 2;
                else stacks[i] = stack * 3 + 1;
            }
        }
        if (notReady) count++;
    }

    IO.println("Количество проходов пасьянса: " + count);



}
