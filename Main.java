import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws IOException {
        System.out.println("Введите путь до интерпретатора Python: ");
        Scanner scan = new Scanner(System.in);
        String path = scan.nextLine();

        ProcessBuilder p = new ProcessBuilder();
        p.command("\"" + path + "\" -m timeit -r 10");

        BufferedReader reader = new BufferedReader(new InputStreamReader(p.start().getInputStream()));

        String line = reader.readLine();
        while (line != null) {
            System.out.println(line);
            line = reader.readLine();
        }
    }
}