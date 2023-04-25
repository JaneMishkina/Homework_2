// В файле содержится строка с исходными данными в такой форме:
// {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
// Требуется на её основе построить и вывести на экран новую строку, в форме SQL запроса:
// SELECT * FROM students WHERE name = "Ivanov" AND country = "Russia" AND city = "Moscow";
// Для разбора строки используйте String.split. Сформируйте новую строку, используя StringBuilder.
// Значения null не включаются в запрос.

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Project_1 {

public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("file.txt"));
        String[] input = reader.readLine()
                .replace("{", "")
                .replace("}", "")
                .split(",");
reader.close();
 

        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM students WHERE ");

        for (String s : input) {
            String[] temp = s.trim().split(":");
            if (!temp[1].contains("null")) {
                sb.append(temp[0].replace("", "")).append(" = ").append(temp[1]).append(" AND ");
            }
}

sb.replace(sb.lastIndexOf(" AND "), sb.length()-1, ";");
        System.out.println(sb);
    }
}