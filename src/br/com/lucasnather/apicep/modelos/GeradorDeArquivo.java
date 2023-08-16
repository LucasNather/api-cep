package br.com.lucasnather.apicep.modelos;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class GeradorDeArquivo {

    public void geraArquivo(List<Cep> ceps) throws IOException {
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        String cepParaJson = gson.toJson(ceps);
        FileWriter escrita = new FileWriter("cep.json");
        escrita.write(cepParaJson);
        escrita.close();
    }
}
