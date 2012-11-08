package models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import play.db.jpa.Model;
import play.libs.Time;

@Entity
public class Ranking extends Model{
	@OneToOne
	public ParticipantResults participant;
	public int OverallRank;
	public int GenderRank;
	public int DivisionRank;
	
	
}
