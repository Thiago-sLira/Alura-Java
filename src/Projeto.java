import java.util.Scanner;

public class Projeto {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        String userName = "Callum Jarrus";
        double initialCash = 2500;

        String clientData = """
                ****************************************
                Dados iniciais do cliente:
                
                Nome: %s
                Tipo conta: Corrente
                Saldo inicial: R$ %.2f
                ****************************************
                
                
                """.formatted(userName, initialCash);

        int optionChosed = 0;
        double valueToTransfer = 0;
        String operations = """
                Operações
                
                1- Consultar saldos
                2- Receber valor
                3- Transferir valor
                4- Sair
                
                Digite a opção desejada:
                """;

        System.out.println(clientData + operations);


        while (optionChosed != 4) {
            optionChosed = read.nextInt();

            switch (optionChosed) {
                case 1:
                    System.out.println("O saldo atual é R$ " + initialCash);
                    System.out.println(operations);
                    break;
                case 2:
                    System.out.println("Informe o valor a receber:");
                    initialCash += read.nextDouble();
                    System.out.println("Saldo atualizado R$ " + initialCash);
                    System.out.println(operations);
                    break;
                case 3:
                    System.out.println("Informe o valor que deseja transferir:");
                    valueToTransfer = read.nextDouble();
                    if (valueToTransfer > initialCash) {
                        System.out.println("Valor superior ao saldo disponível");
                        System.out.println(operations);
                        break;
                    } else {
                        initialCash -= valueToTransfer;
                        System.out.println("Saldo atualizado R$ " + initialCash);
                        System.out.println(operations);
                        break;
                    }
                case 4:
                    System.out.println("Agradecemos a preferência, até logo!");
                    break;
                default:
                    System.out.println("Opção " + optionChosed + " inválida!");
                    System.out.println(operations);
            }
        }


    }
}