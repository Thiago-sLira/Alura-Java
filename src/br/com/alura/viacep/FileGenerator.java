package br.com.alura.viacep;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;

public class FileGenerator {
    public void createFileJson(Address myAddress) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        FileWriter file = new FileWriter(myAddress.getPostalCode() + ".json");
        file.write(gson.toJson(myAddress));
        file.close();
    }
}
