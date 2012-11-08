package models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Query;

import org.joda.time.DateTime;

import play.data.binding.As;
import play.data.validation.Required;
import play.db.jpa.JPA;
import play.db.jpa.Model;

@Entity
public class Race extends Model{
	@Required(message="It must have had a name.")
	public String eventName; 
	@Required(message="When was it?")
	@As("dd/MM/yyyy") 
	public Date eventDate; 
	@Required(message="City please!")
	public String city; 
	@Required(message="State please!")
	public String state; 
	@Required(message="Zip please!")
	public String zip;
	
	@OneToMany @JoinColumn(name="raceId")
	public List<ParticipantResults> results;

	public Race(String eventName, String eventDate, String city, String state, String zip){ 
		this.eventName = eventName; 
		try {
			this.eventDate = new SimpleDateFormat("mm/dd/yyyy").parse(eventDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		this.city = city; 
		this.state = state; 
		this.zip = zip;
	}
	
	public List<String> getDivisions(){ 
		Query query = JPA.em().createQuery("select distinct division from ParticipantResults");
		return query.getResultList();
	}
}
