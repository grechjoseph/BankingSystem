package main.service.impl;

import main.api.ApiClient;
import main.exception.ClientNotFoundException;
import main.exception.CountryBlankException;
import main.mapping.ModelMapper;
import main.model.Client;
import main.model.Country;
import main.repository.ClientRepository;
import main.repository.CountryRepository;
import main.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ClientServiceImpl implements ClientService {
    @Autowired
    ClientRepository clientRepository;

    @Autowired
    CountryRepository countryRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<ApiClient> getAllClients(){
        List<Client> clients = new ArrayList<>();
        clientRepository.findAll().forEach(clients::add);
        return modelMapper.mapAsList(clients, ApiClient.class);
    }

    /**
     * Adds a new Client object to the database.
     * @param apiClient Contains all required fields to initiate Client object saving.
     * @return Saved Client object.
     */
    public ApiClient addClient(ApiClient apiClient) throws CountryBlankException {
        //Get countries if exist
        Country primaryCountry = countryRepository.findByCountryIgnoreCase(apiClient.getPrimaryCountry());
        Country secondaryCountry = countryRepository.findByCountryIgnoreCase(apiClient.getSecondaryCountry());

        if(apiClient.getPrimaryCountry().trim().replace("\\s+", "").equals(""))
            throw new CountryBlankException();

        if(primaryCountry == null){
            //Primary Country provided does not yet exist.
            primaryCountry = new Country(apiClient.getPrimaryCountry());
            countryRepository.save(primaryCountry);
        }

        if(apiClient.getSecondaryCountry() != "") {
            //Secondary country provided.
            if(secondaryCountry == null){
                //Secondary Country does not yet exist.
                secondaryCountry = new Country(apiClient.getSecondaryCountry());
                countryRepository.save(secondaryCountry);
            }
        }

        Client client = new Client(apiClient.getName(), apiClient.getSurname(),
                apiClient.getPrimaryAdLn1(), apiClient.getPrimaryAdLn2(), apiClient.getPrimaryCity(), primaryCountry,
                apiClient.getSecondaryAdLn1(), apiClient.getSecondaryAdLn2(), apiClient.getSecondaryCity(), secondaryCountry);

        return modelMapper.map(clientRepository.save(client), ApiClient.class);
    }

    public ApiClient getClientByID(Long id){
        Client client = clientRepository.findOne(id);

        if(client == null)
            throw new ClientNotFoundException(id);

        return modelMapper.map(client, ApiClient.class);
    }
}
