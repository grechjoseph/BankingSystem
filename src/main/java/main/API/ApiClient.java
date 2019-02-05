package main.api;

public class ApiClient {

    /* JSON
    {
        "name":"Nathalie",
        "surname":"Grima",
        "primaryAdLn1":"1 Line 1",
        "primaryAdLn2":"1 Line 2",
        "primaryCity":"City1",
        "primaryCountry":"Country1",
        "secondaryAdLn1":"2 Line 1",
        "secondaryAdLn2":"2 Line 2",
        "secondaryCity":"City2",
        "secondaryCountry":"Country2"
        }
     */

    private Long id;

    private String name;

    private String surname;

    private String primaryAdLn1;

    private String primaryAdLn2;

    private String primaryCity;

    private String primaryCountry;

    private String secondaryAdLn1;

    private String secondaryAdLn2;

    private String secondaryCity;

    private String secondaryCountry;

    public ApiClient(){

    }

    public ApiClient(Long id, String name, String surname,
                     String primaryAdLn1, String primaryAdLn2, String primaryCity, String primaryCountry,
                     String secondaryAdLn1, String secondaryAdLn2, String secondaryCity, String secondaryCountry) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.primaryAdLn1 = primaryAdLn1;
        this.primaryAdLn2 = primaryAdLn2;
        this.primaryCity = primaryCity;
        this.primaryCountry = primaryCountry;
        this.secondaryAdLn1 = secondaryAdLn1;
        this.secondaryAdLn2 = secondaryAdLn2;
        this.secondaryCity = secondaryCity;
        this.secondaryCountry = secondaryCountry;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPrimaryAdLn1() {
        return primaryAdLn1;
    }

    public void setPrimaryAdLn1(String primaryAdLn1) {
        this.primaryAdLn1 = primaryAdLn1;
    }

    public String getPrimaryAdLn2() {
        return primaryAdLn2;
    }

    public void setPrimaryAdLn2(String primaryAdLn2) {
        this.primaryAdLn2 = primaryAdLn2;
    }

    public String getPrimaryCity() {
        return primaryCity;
    }

    public void setPrimaryCity(String primaryCity) {
        this.primaryCity = primaryCity;
    }

    public String getPrimaryCountry() {
        return primaryCountry;
    }

    public void setPrimaryCountry(String primaryCountry) {
        this.primaryCountry = primaryCountry;
    }

    public String getSecondaryAdLn1() {
        return secondaryAdLn1;
    }

    public void setSecondaryAdLn1(String secondaryAdLn1) {
        this.secondaryAdLn1 = secondaryAdLn1;
    }

    public String getSecondaryAdLn2() {
        return secondaryAdLn2;
    }

    public void setSecondaryAdLn2(String secondaryAdLn2) {
        this.secondaryAdLn2 = secondaryAdLn2;
    }

    public String getSecondaryCity() {
        return secondaryCity;
    }

    public void setSecondaryCity(String secondaryCity) {
        this.secondaryCity = secondaryCity;
    }

    public String getSecondaryCountry() {
        return secondaryCountry;
    }

    public void setSecondaryCountry(String secondaryCountry) {
        this.secondaryCountry = secondaryCountry;
    }
}
