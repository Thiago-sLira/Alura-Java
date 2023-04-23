package br.com.alura.viacep;

public record AddressRecord(
        String cep,
        String logradouro,
        String complemento,
        String bairro,
        String localidade,
        String uf
        ) {
}
