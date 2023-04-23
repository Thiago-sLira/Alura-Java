package br.com.alura.viacep;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner terminal = new Scanner(System.in);
        String postalCodeToSearch = "";

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                        .setPrettyPrinting()
                                .create();

        System.out.println("Digite o cep: ");
        postalCodeToSearch = terminal.nextLine();
        String endpoint = "https://viacep.com.br/ws/" + postalCodeToSearch + "/json/";

        Requisition requisition = new Requisition(endpoint);

        AddressRecord myAddressRecord = gson.fromJson(requisition.makeTheRequisition(), AddressRecord.class);

        System.out.println(myAddressRecord);
        System.out.println(requisition.makeTheRequisition());

        System.out.println("Final da aplicação!!");
    }
}
