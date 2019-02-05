package main.repository;

import main.model.Account;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {

    @Query(value = "SELECT * from account a WHERE a.id=?1 FOR UPDATE", nativeQuery = true)
    Account findByIdAndLock(Long id);

    List<Account> findByClientId(Long clientId);
}
