import java.net.*;
import java.util.Scanner;
import java.io.*;

public class client {

    public static void main(String[] args) throws IOException {
        Socket s = new Socket("localhost", 4999);

        Scanner sc = new Scanner(System.in);
        System.out.print("Digite sue calculo: ");
        String str = sc.next();
        System.out.print("Você digitou: " + str + "\n");

        PrintWriter pr = new PrintWriter(s.getOutputStream());
        pr.println(str);
        pr.flush();

        InputStreamReader in = new InputStreamReader(s.getInputStream());
        BufferedReader bf = new BufferedReader(in);

        String calcResult = bf.readLine();
        System.out.print("Resultado do calculo: " + calcResult);

    }
}
