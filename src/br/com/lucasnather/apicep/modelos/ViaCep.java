package br.com.lucasnather.apicep.modelos;

public record ViaCep(
        String cep,
        String logradouro,
        String uf,
        String localidade
        ) {
}
