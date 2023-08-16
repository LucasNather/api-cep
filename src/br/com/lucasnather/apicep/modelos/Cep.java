package br.com.lucasnather.apicep.modelos;

public class Cep {
    private String cep;
    private String logradouro;

    private String uf;
    private String localidade;

    public Cep(ViaCep viaCep) {
        this.cep = viaCep.cep();
        this.logradouro= viaCep.logradouro();
        this.uf = viaCep.uf();
        this.localidade = viaCep.localidade();
    }
    @Override
    public String toString() {
        return "Cep: " + this.cep +
                " Logradouro: " + this.logradouro +
                " Uf: " + this.uf +
                " Localidade: " +this.localidade;
    }

}
