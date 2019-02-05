package main.model;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/*
Represents an Entity of type 'Country', which can be the home of multiple or none Clients.
 */
@Entity
public class Country {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "country_Sequence")
    @SequenceGenerator(name = "country_Sequence", sequenceName = "COUNTRY_SEQ")
    private Long id;

    @NotNull
    @Column(name = "name")
    private String country;

    public Country(){

    }

    public Country(String country) {
        this.country = country;
    }

    public Long getId() {
        return id;
    }

    /*public void setId(Long id) {
        this.id = id;
    }*/

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
