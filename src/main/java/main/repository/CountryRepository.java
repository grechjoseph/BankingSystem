package main.repository;

import main.model.Country;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/*
Repository dedicated to managing Country objects in db.
 */
@Repository
public interface CountryRepository extends CrudRepository<Country, Long> {

    Country findByCountryIgnoreCase(String name);
}
