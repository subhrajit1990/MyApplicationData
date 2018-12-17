package my.application.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import my.application.entities.GuessMeAccount;

@Repository
public interface GuessMeAccountRepository extends CrudRepository<GuessMeAccount, Integer>{

//	@Query("SELECT DISTINCT NEW my.application.entities.AccountResponse(account.username,account.point) FROM GuessMeAccount account ORDER BY account.point DESC LIMIT 5")
//	List<Object> topFive();
	
	
	
	//List<Object> findTop5ByPointLessThanOrderByPointDesc();

	@Query("SELECT COUNT(*) FROM GuessMeAccount account WHERE account.username = :username")
	Long countById(@Param("username") String username);
}
