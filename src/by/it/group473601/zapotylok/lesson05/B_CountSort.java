package by.it.group473601.zapotylok.lesson05;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

/*
Первая строка содержит число 1<=n<=10000, вторая - n натуральных чисел, не превышающих 10.
Выведите упорядоченную по неубыванию последовательность этих чисел.

При сортировке реализуйте метод со сложностью O(n)

Пример: https://karussell.wordpress.com/2010/03/01/fast-integer-sorting-algorithm-on/
Вольный перевод: http://programador.ru/sorting-positive-int-linear-time/
*/

public class B_CountSort {


    int[] countSort(InputStream stream) throws FileNotFoundException {
        //подготовка к чтению данных
        Scanner scanner = new Scanner(stream);
        //!!!!!!!!!!!!!!!!!!!!!!!!!     НАЧАЛО ЗАДАЧИ     !!!!!!!!!!!!!!!!!!!!!!!!!
        //размер массива
        int n = scanner.nextInt();
        int[] points=new int[n];

        //читаем точки
        for (int i = 0; i < n; i++) {
            points[i]=scanner.nextInt();
        }
        //тут реализуйте логику задачи с применением сортировки подсчетом
        int[] sortedSequence = new int[n];
        int[] frequency = new int[10];

        for(int i=0;i<10;i++){
            frequency[i]=0;
        }

        for(int i=0;i<n;i++){
            frequency[points[i]]++;
        }

        for(int j=1;j<10;j++){
            frequency[j]=frequency[j]+frequency[j-1];
        }

        for(int i=n-1;i>=0;i--){
            frequency[points[i]]--;
            sortedSequence[frequency[points[i]]]=points[i];
        }




        //!!!!!!!!!!!!!!!!!!!!!!!!!     КОНЕЦ ЗАДАЧИ     !!!!!!!!!!!!!!!!!!!!!!!!!
        return sortedSequence;
    }


    public static void main(String[] args) throws FileNotFoundException {
        String root = System.getProperty("user.dir") + "/src/";
        InputStream stream = new FileInputStream(root + "by/it/group473601/zapotylok/lesson05/dataB.txt");
        B_CountSort instance = new B_CountSort();
        int[] result=instance.countSort(stream);
        for (int index:result){
            System.out.print(index+" ");
        }
    }

}
