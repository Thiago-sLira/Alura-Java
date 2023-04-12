public class Main {
    public static void main(String[] args) {
        System.out.println("Olá Mundooooooooooooooooooo!");
        System.out.println("Filme: Top Gun: Maverick");

        int anoDeLancamento = 2022;
        System.out.println("Ano de lançamento: " + anoDeLancamento);
        boolean incluidoNoPlano = true;
        double notaDoFilme = 8.1;

        double media = (9.8 + 6.3 + 8.0) /3;
        System.out.println(media);
        // Média calculada pelas 3 notas da Jack, Paulo e Suelem;
        String sinopse;
        sinopse = """
                Filme Top Gun
                Filme de aventura com galã dos anos 80
                Muito bom!
                Ano de lançamento
                """ + anoDeLancamento;
        System.out.println(sinopse);

        if (notaDoFilme == 8.2) {
            System.out.println("Deu bom");
        } else {
            System.out.println("Deu ruim");
        }

        String nome = "João";
        int aulas = 4;

        String mensagem = """
                  Olá, %s!
                  Boas vindas ao curso de Java.
                  Teremos %d aulas para te mostrar o que é preciso para você dar o seu primeiro mergulho na linguagem!
                  """.formatted(nome, aulas);

        System.out.println(mensagem);

        int classificacao = (int) (media /2);
        System.out.println(classificacao);
    }
}