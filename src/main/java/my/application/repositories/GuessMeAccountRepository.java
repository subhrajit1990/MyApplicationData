package my.application.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import my.application.entities.GuessMeAccount;

@Repository
public interface GuessMeAccountRepository extends CrudRepository<GuessMeAccount, Integer>{

}
