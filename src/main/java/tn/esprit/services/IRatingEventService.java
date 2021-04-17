package tn.esprit.services;

import tn.esprit.entities.Rating;

public interface IRatingEventService {
	
	
	public String addRatingEvent(int idUser,int idEvent,float ratingValue);
	public String updateRatingEvent(Rating ratEvent);
	public float getAvgRat();
	public float getValueRatingByEventAndUser(int idEvent,int idUser);
}
