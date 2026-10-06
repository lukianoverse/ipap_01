static String[] windowsill = {"G", "C", "V"};

static String[] mashaMove(String[] flowers) {
    if (flowers.length < 2) return flowers;
    String inHands = flowers[flowers.length - 1];
    flowers[flowers.length - 1] = flowers[flowers.length - 2];
    flowers[flowers.length - 2] = inHands;
    return flowers;
}

static String[] tanyaMove(String[] flowers) {
    if (flowers.length < 2) return flowers;
    String inHands = flowers[0];
    flowers[0] = flowers[1];
    flowers[1] = inHands;
    return flowers;
}

static String[] dayPass(String[] flowers) {
    return tanyaMove(mashaMove(flowers));
}

void main() {
    Scanner scanner = new Scanner(System.in);
    IO.println("Сколько дней прошло? ");
    int days = scanner.nextInt();
    if (days > 1000) {
        IO.println("Слишком много дней");
        return;
    }

    for (int i = 0; i < days; i++)
        windowsill = dayPass(windowsill);

    IO.println("Цветы стоят в таком порядке: " + Arrays.toString(windowsill));
}
