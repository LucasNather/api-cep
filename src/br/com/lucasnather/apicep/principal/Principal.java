package br.com.lucasnather.apicep.principal;
import br.com.lucasnather.apicep.modelos.Cep;
import br.com.lucasnather.apicep.modelos.ConsultaCep;
import br.com.lucasnather.apicep.modelos.GeradorDeArquivo;
import br.com.lucasnather.apicep.modelos.ViaCep;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException {
        Scanner leitura = new Scanner(System.in);
        String buscaCep = "";

        List<Cep> ceps = new ArrayList<>();

        while (!buscaCep.equalsIgnoreCase("sair")) {
            System.out.println("Qual o CEP você deseja buscar? ");
            buscaCep = leitura.nextLine();

            if (buscaCep.equalsIgnoreCase("sair")) {
                    break;
            }

            try {
                ConsultaCep consultaCep = new ConsultaCep();
                ViaCep viaCep = consultaCep.buscaApi(buscaCep);

                Cep cep = new Cep(viaCep);
                ceps.add(cep);

                GeradorDeArquivo geradorDeArquivo = new GeradorDeArquivo();
                geradorDeArquivo.geraArquivo(ceps);
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
