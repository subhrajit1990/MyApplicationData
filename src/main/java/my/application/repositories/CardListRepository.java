package my.application.repositories;

import org.springframework.data.repository.CrudRepository;

import my.application.entities.CardList;



public interface CardListRepository extends CrudRepository<CardList, Integer>{

}
