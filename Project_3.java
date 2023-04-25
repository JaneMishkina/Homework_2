
// 3.* В файле содержится строка с данными:
// [{"фамилия":"Иванов","оценка":"5","предмет":"Математика"}, {"фамилия":"Петрова","оценка":"4","предмет":"Информатика"}, 
// {"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
// Напишите метод, который разберёт её на составные части и, используя StringBuilder создаст массив строк такого вида:
// Студент Иванов получил 5 по предмету Математика.
// Студент Петрова получил 4 по предмету Информатика.
// Студент Краснов получил 5 по предмету Физика.

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;

public class Project_3 {

    public static void main(String[] args) throws FileNotFoundException {
        FileReader reader = new FileReader("file3.txt");
        Scanner scan = new Scanner(reader);
        String input = scan.nextLine();
        scan.close();

        System.out.println(input);

        input = input.substring(1, input.length() - 2);
        input = input.replace(":", ",").replaceAll("[{}]", "");
        System.out.println(input);

        String[] arrString = new String[]{};
        arrString = input.split(",");
        System.out.println(Arrays.toString(arrString));

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < arrString.length; i += 6) {
            result.append(String.format("\nСтудент %s получил %s по предмету %s.",
                    arrString[i + 1], arrString[i + 3], arrString[i + 5]));
        }

        System.out.println(result);


    }
}
