package my.application.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import my.application.entities.GuessMeAccount;

@Repository
public interface GuessMeAccountRepository  extends JpaRepository<GuessMeAccount, Long>{

}
