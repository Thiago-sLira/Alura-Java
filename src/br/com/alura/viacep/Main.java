package br.com.alura.viacep;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner terminal = new Scanner(System.in);
        String postalCodeToSearch = "";

        while (!postalCodeToSearch.equalsIgnoreCase("sair")) {
            System.out.println("Digite o cep ou 'salvar' para salvar a consulta: ");
            postalCodeToSearch = terminal.nextLine();

            if (postalCodeToSearch.equalsIgnoreCase("sair")) {
                break;
            }

            String endpoint = "https://viacep.com.br/ws/" + postalCodeToSearch + "/json/";
            try {
                Requisition requisition = new Requisition(endpoint);

                AddressRecord myAddressRecord = new Gson().fromJson(requisition.makeTheRequisition(), AddressRecord.class);
                Address myAddress = new Address(myAddressRecord);

                System.out.println(myAddress.getCity());

                FileGenerator file = new FileGenerator();
                file.createFileJson(myAddress);
            } catch (InterruptedException | IOException error) {
                throw new RuntimeException("Não consegui pesquisar a partir deste CEP: " + postalCodeToSearch);
            } catch (JsonSyntaxException error) {
                System.out.println("CEP digitado incorretamente, tente de novo");
            }
        }

        System.out.println("Final da aplicação!!");
    }
}
