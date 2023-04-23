package br.com.alura.viacep;

public class Address {
    private String postalCode;
    private String street;
    private String complement;
    private String neighborhood;
    private String city;
    private String state;
    private String number;

    public Address(
            String postalCode,
            String street,
            String complement,
            String neighborhood,
            String city,
            String state,
            int number
        ) {
        this.postalCode = postalCode;
        this.street = street;
        this.complement = complement;
        this.neighborhood = neighborhood;
        this.city = city;
        this.state = state;
        this.number = String.valueOf(number);
    }

    public Address(AddressRecord addressRecord, int number) {
        this.postalCode = addressRecord.cep();
        this.street = addressRecord.logradouro();
        this.complement = addressRecord.complemento();
        this.neighborhood = addressRecord.bairro();
        this.city = addressRecord.localidade();
        this.state = addressRecord.uf();
        this.number = String.valueOf(number);
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getStreet() {
        return street;
    }

    public String getComplement() {
        return complement;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Este endereço é referente ao CEP: " +
                postalCode +
                ", número: " +
                number;
    }
}
