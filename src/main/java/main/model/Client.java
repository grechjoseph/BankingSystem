package main.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/*
Represents an Entity of type Client, which can own multiple or none Account(s)
 */
@Entity
public class Client {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "client_Sequence")
    @SequenceGenerator(name = "client_Sequence", sequenceName = "CLIENT_SEQ")
    private Long id;

    @NotNull
    @Column(name = "name")
    private String name;

    @NotNull
    @Column(name = "surname")
    private String surname;

    @NotNull
    @Column(name = "primary_ad_ln_1")
    private String primaryAdLn1;

    @NotNull
    @Column(name = "primary_ad_ln_2")
    private String primaryAdLn2;

    @NotNull
    @Column(name = "primary_city")
    private String primaryCity;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "primary_country_id")
    private Country primaryCountry;

    @Column(name = "secondary_ad_ln_1")
    private String secondaryAdLn1;

    @Column(name = "secondary_ad_ln_2")
    private String secondaryAdLn2;

    @Column(name = "secondary_city")
    private String secondaryCity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "secondary_country_id")
    private Country secondaryCountry;

    public Client(){

    }

    public Client(String name, String surname,
                  String primaryAdLn1, String primaryAdLn2, String primaryCity, Country primaryCountry,
                  String secondaryAdLn1, String secondaryAdLn2, String secondaryCity, Country secondaryCountry) {
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

    /*public void setId(Long id) {
        this.id = id;
    }*/

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

    public Country getPrimaryCountry() {
        return primaryCountry;
    }

    public void setPrimaryCountry(Country primaryCountry) {
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

    public Country getSecondaryCountry() {
        return secondaryCountry;
    }

    public void setSecondaryCountry(Country secondaryCountry) {
        this.secondaryCountry = secondaryCountry;
    }
}
