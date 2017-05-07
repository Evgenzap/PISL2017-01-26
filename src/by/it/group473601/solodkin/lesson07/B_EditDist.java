package by.it.group473601.solodkin.lesson07;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

/*
Задача на программирование: расстояние Левенштейна
    https://ru.wikipedia.org/wiki/Расстояние_Левенштейна
    http://planetcalc.ru/1721/

Дано:
    Две данных непустые строки длины не более 100, содержащие строчные буквы латинского алфавита.

Необходимо:
    Решить задачу МЕТОДАМИ ДИНАМИЧЕСКОГО ПРОГРАММИРОВАНИЯ
    Итерационно вычислить расстояние редактирования двух данных непустых строк

    Sample Input 1:
    ab
    ab
    Sample Output 1:
    0

    Sample Input 2:
    short
    ports
    Sample Output 2:
    3

    Sample Input 3:
    distance
    editing
    Sample Output 3:
    5

*/

public class B_EditDist {

    int getDistanceEditing(String first, String second) {
        //!!!!!!!!!!!!!!!!!!!!!!!!!     НАЧАЛО ЗАДАЧИ     !!!!!!!!!!!!!!!!!!!!!!!!!

        int[][] distances = new int[first.length() + 1][second.length() + 1];

        for (int i = 0; i < first.length() + 1; i++) {
            distances[i][0] = i;
        }
        for (int i = 0; i < second.length() + 1; i++) {
            distances[0][i] = i;
        }

        for (int i = 0; i < first.length(); i++) {
            for (int j = 0; j < second.length(); j++) {
                int cost = getDifference(first.charAt(i), second.charAt(j));
                distances[i + 1][j + 1] = getMinimum(
                        distances[i][j + 1] + 1,
                        distances[i + 1][j] + 1,
                        distances[i][j] + cost);
            }
        }

        int result = distances[first.length()][second.length()];
        //!!!!!!!!!!!!!!!!!!!!!!!!!     КОНЕЦ ЗАДАЧИ     !!!!!!!!!!!!!!!!!!!!!!!!!
        return result;
    }

    private int getDifference(char first, char second) {
        return first != second ? 1 : 0;
    }

    private int getMinimum(int first, int second, int third) {
        return Math.min(first, Math.min(second, third));
    }

    public static void main(String[] args) throws FileNotFoundException {
        String root = System.getProperty("user.dir") + "/src/";
        InputStream stream = new FileInputStream(root + "by/it/group473601/solodkin/lesson07/dataABC.txt");
        B_EditDist instance = new B_EditDist();
        Scanner scanner = new Scanner(stream);
        System.out.println(instance.getDistanceEditing(scanner.nextLine(), scanner.nextLine()));
        System.out.println(instance.getDistanceEditing(scanner.nextLine(), scanner.nextLine()));
        System.out.println(instance.getDistanceEditing(scanner.nextLine(), scanner.nextLine()));
    }

}
