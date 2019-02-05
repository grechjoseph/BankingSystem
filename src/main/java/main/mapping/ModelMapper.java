package main.mapping;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import main.api.ApiAccount;
import main.api.ApiClient;
import main.api.ApiTransaction;
import main.model.Account;
import main.model.Client;
import main.model.Transaction;
import org.springframework.stereotype.Component;

@Component
public class ModelMapper extends ConfigurableMapper {

    public void configure(MapperFactory factory){
        super.configure(factory);

        factory.registerClassMap(factory.classMap(Account.class, ApiAccount.class)
                .byDefault()
                .toClassMap());

        factory.registerClassMap(factory.classMap(Transaction.class, ApiTransaction.class)
                .field("debtor.id", "debtorId")
                .field("creditor.id", "creditorId")
                .byDefault()
                .toClassMap());

        factory.registerClassMap(factory.classMap(Client.class, ApiClient.class)
                .field("primaryCountry.country", "primaryCountry")
                .field("secondaryCountry.country", "secondaryCountry")
                .byDefault()
                .toClassMap());
    }



}
