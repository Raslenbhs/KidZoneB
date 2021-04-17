package tn.esprit.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.entities.Kindergarten;

@Repository
public interface KindergartenRepository extends CrudRepository<Kindergarten, Integer> {

}
