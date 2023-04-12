import java.util.Random;
import java.util.Scanner;

public class Exercises {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);
//        System.out.println(new Random().nextInt(100));
        int numeroSorteado = 0;
        int tentativa = 0;

        for (int i = 0; i < 10; i++) {
            numeroSorteado = new Random().nextInt(10);
            tentativa = leitura.nextInt();

            if (numeroSorteado == tentativa) {
                System.out.println("Parabéns, você acertou!!");
            } else {
                System.out.println("Errou, o número era " + numeroSorteado + "! Mais sorte na próxima");
            }
        }
    }
}
