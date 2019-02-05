package main.service;

import main.api.ApiClient;

import java.util.List;

public interface ClientService {

    List<ApiClient> getAllClients();

    ApiClient addClient(ApiClient apiClient);

    ApiClient getClientByID(Long id);
}
