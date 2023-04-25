// Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации запишите в лог-файл.

import java.io.IOException;
import java.util.Arrays;
import java.util.logging.*;

public class Project_2 {
    public static void main(String[] args) throws SecurityException, IOException {
        int[] arr = new int[] { 13, 2, 7, 9, 10 };
        int number = 0;
        Logger logger = Logger.getLogger(Homework_2.class.getName());
        // ConsoleHandler info = new ConsoleHandler();
        FileHandler info = new FileHandler("log.xml");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] < arr[j]) {
                    number = arr[i];
                    arr[i] = arr[j];
                    arr[j] = number;
                }
            }
            logger.addHandler(info);
            logger.info(Arrays.toString(arr));
        }
        System.out.println(Arrays.toString(arr));
    }
}