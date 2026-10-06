static int[] data = {3, 5, 7};

//    вывести: сумму чисел, среднее арифметическое,
//    разности a - b, b - a, a - c, c - a, b - c, c - b

void main() {
    int sum = 0;
    for (int number : data) sum += number;
    IO.println("сумма = " + sum);


    int average;
    if (data.length != 0) {
        average = sum / data.length;
        IO.println("среднее = " + average);
    } else {
        IO.println("нет данных");
    }

    // вывод типа `a - b = значение` можно было бы оформить,
    // если ввести данные в виде мапы
    for (int i = 0; i < data.length; i++) {
        for (int j = 0; j < data.length; j++) {
            if (i != j) {
                IO.println(data[i] - data[j]);
            }
        }
    }
}

