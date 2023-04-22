package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.excecao.ErroDeConversaoDeAnoException;
import br.com.alura.screenmatch.modelos.Titulo;
import br.com.alura.screenmatch.modelos.TituloOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrincipalComBusca {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner terminal = new Scanner(System.in);
        String busca = "";
        List<Titulo> titulos = new ArrayList<>();

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();

        while (!busca.equalsIgnoreCase("sair")) {

            System.out.println("Digite um filme para busca:");
            busca = terminal.nextLine();

            if (busca.equalsIgnoreCase("sair")) {
                break;
            }

            String endpoint = "https://www.omdbapi.com/?t=" + busca.replace(" ", "+") + "&apikey=2aad4890";
            try {
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(endpoint))
                        .build();
                HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());

//                System.out.println(response.body());
                TituloOmdb meuTituloOmdb = gson.fromJson(response.body(), TituloOmdb.class);

//                System.out.println(meuTituloOmdb);

//        try {
                Titulo meuTitulo = new Titulo(meuTituloOmdb);
//                System.out.println("Título impresso:");
//                System.out.println(meuTitulo);

                titulos.add(meuTitulo);

//                FileWriter escrita = new FileWriter("filmes.txt");
//                escrita.write(meuTitulo.toString());
//                escrita.close();
            } catch (NumberFormatException error) {
                System.out.println("Aconteceu um erro: ");
                System.out.println(error.getMessage());
            } catch (IllegalArgumentException error) {
                System.out.println("Aconteceu um erro de argumentos: ");
                System.out.println(error.getMessage());
            } catch (ErroDeConversaoDeAnoException error) {
                System.out.println(error.getMessage());
            }
        }
        System.out.println(titulos);

        FileWriter escrita = new FileWriter("filmes.json");
        escrita.write(gson.toJson(titulos));
        escrita.close();

        System.out.println("Chegou até o final!!");
    }
}
