package tn.esprit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.entities.Rating;
@Repository
public interface IRatingEventRepository extends CrudRepository<Rating,Integer>{
	@Query("SELECT AVG(rat.ratingValue) FROM Rating rat")
	public int getAvgOfValueRating();
	
	@Query("SELECT rat FROM Rating rat WHERE rat.eventRat.id=:idEvent AND rat.userRat.id=:idUser ")
	public List<Rating> findRatingEventByEventAndUser(@Param("idEvent")int eventRat,@Param("idUser")int userRat);
}
