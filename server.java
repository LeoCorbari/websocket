import java.net.*;
import java.util.regex.Pattern;
import java.io.*;

public class server {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(4999);
        Socket s = ss.accept();

        System.out.println("+-+-+-+-+-+-+-+ +-+-+-+-+-+-+-+-+-+ \n");
        System.out.println("|c|l|i|e|n|t|e| |c|o|n|e|c|t|a|d|o| \n");
        System.out.println("+-+-+-+-+-+-+-+ +-+-+-+-+-+-+-+-+-+ \n");

        InputStreamReader in = new InputStreamReader(s.getInputStream());
        BufferedReader bf = new BufferedReader(in);

        String str = bf.readLine();
        PrintWriter pr = new PrintWriter(s.getOutputStream());

        float resultado = 0;
        String[] valores = str.split(Pattern.quote("|"));

        float valorUm = Float.valueOf(valores[1]);
        float valorDois = Float.valueOf(valores[2]);

        if (str.contains("soma")) {
            resultado = valorUm + valorDois;

        } else if (str.contains("divide")) {
            resultado = valorUm / valorDois;

        } else if (str.contains("subtrai")) {
            resultado = valorUm - valorDois;

        } else if (str.contains("multiplica")) {
            resultado = valorUm * valorDois;

        } else {
            pr.println("O servidor não entendeu a operação!");

        }

        pr.println(resultado);
        pr.flush();

    }
}
