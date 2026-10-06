package exc02;

import java.util.Arrays;

public class TreeThinning {
    static char TREE = 'T';
    static char GAP = '_';

    /**
     * Проходит по битовому массиву {@code treeline}, где {@code true} соответствует
     * дереву, а {@code false} — пустому месту, и проверяет, удовлетворяет ли схема
     * прорежения требованиям короля Флетляндии: расстояния между всеми соседними
     * деревьями должны быть одинаковы.
     *
     * @param treeline массив отметок: {@code true} = дерево, {@code false} = пусто
     * @return {@code true}, если все промежутки между деревьями равны (также если
     *         в ряду 0 или 1 дерев), иначе {@code false}.
     */
    static boolean isAppropriateLine(boolean[] treeline, int checkUpTo) {
        int standardDistance = 0;   // величина стандартного прогала (0 если ещё не определён)
        int lastTreeIndex = -1;     // индекс пройденного дерева

        for (int i = 0; i <= checkUpTo; i++) {
            // нас интересуют только деревья
            if (!treeline[i]) continue;

            // если это не первое дерево
            if (lastTreeIndex != -1) {
                int gap = i - lastTreeIndex; // расстояние до этого от предыдущего

                // если это первый прогал, определяем стандарт прогалам
                if (standardDistance == 0) {
                    standardDistance = gap;

                    // если текущий прогал не равен проектному, значит вариант не проходит
                } else if (gap != standardDistance) {
                    return false;
                }
            }
            lastTreeIndex = i;
        }
        return true; // если добрались до конца, значит вариант пока годный
    }

    /**
     * Рекурсивная искалка корректных вариантов прорежения аллеи во Флетляндии.
     *
     * @param model         битовый массив, моделирующий состояние аллеи.
     * @param treesFinal    сколько деревьев оставляется после прорежения.
     * @param index         какое место в аллее предшествует проверяемому.
     * @param treesChecked  сколько деревьев уже проверено.
     * @return сколько всего годных вариантов найдено в нисходящих ветвях.
     */
    static int countVariants(boolean[] model,
                             int treesFinal,
                             int index,
                             int treesChecked
                             ) {

//        System.out.println("variant invoked: model=" + Arrays.toString(model) + " index=" + index + " treesChecked=" + treesChecked);

        // если к этому дереву это годный вариант
        if (isAppropriateLine(model, index)) {

            // если проверены столько дерев, сколько надо оставить
            if (treesChecked == treesFinal) {
                // значит найден конечный годный вариант
                plotATreeline(model);
                return 1;
            }

            // если это уже конец линии, то вариант не годный
            if (index == model.length - 1) return 0;

            // иначе надо продолжать проверку
            // проверяем ветку, если в следующей позиции не будет дерева
            int branchGap = countVariants(model, treesFinal, index + 1, treesChecked);

            // проверяем ветку, если в следующей позиции будет дерево
            boolean[] modelX = Arrays.copyOf(model, model.length);
            modelX[index + 1] = true;
            treesChecked++;
            int branchTree = countVariants(modelX, treesFinal, index + 1, treesChecked);

            return branchGap + branchTree;
        }
        return 0;
    }

    static void plotATreeline(boolean[] model) {
        for (boolean place : model)
            IO.print(place ? TREE : GAP);
        IO.println();
    }

    void main() {
        int N = 7;  // начальное количество дерев
        int M = 4;  // дерев останется после прорежения

        int variantsCount = countVariants(new boolean[N], M, -1, 0);
        IO.println("Вычислено вариантов: " + variantsCount);
    }

}
