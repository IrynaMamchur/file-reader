package homeWork1303;

import java.io.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class MainTask {


    public static void main(String[] args) throws IOException {
        String path = "data.txt";
        String outputPath = "resize_data.txt";
        Scanner scanner = new Scanner(System.in);
        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outputPath));

        System.out.print("Введите start:");
        int start = scanner.nextInt();
        System.out.print("Введите finish:");
        int finish = scanner.nextInt();

        if (start > finish) {
            System.out.println("Вы ввели некорректные данные");
            return;
        }

        List<String> strings = new ArrayList<>();
        String line = "";
        while (line != null) {
            line = bufferedReader.readLine();
            if (line != null) {
                strings.add(line);
            }
        }

        bufferedReader.close();

        for (String s : strings) {
            System.out.println(s);
        }
        System.out.println("-----------");

        List<String> answer = strings.stream()
                .skip(start - 1)
                .limit(finish - start + 1)
                .toList();

        for (String a : answer) {
            System.out.println(a);
            bufferedWriter.write(a);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

    }
}

