package models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;

import play.db.jpa.Model;
import play.libs.Time;
@Entity
public class ParticipantResults extends Model{
	public String division;
	public String homeLocation;
	public String gender;
	public String name; 
	public long bibNumber;
	public long age;
	public String chipTime; 
	public String gunTime;
	
	public ParticipantResults(String name,
			String division, String homeLocation, String gender,
			long bibNumber, long age, String chipTime, String gunTime) {
//		this.race = race;
		this.name = name;
		this.division = division;
		this.homeLocation = homeLocation;
		this.gender = gender;
		this.bibNumber = bibNumber;
		this.age = age;
		this.chipTime = chipTime;
		this.gunTime = gunTime;
	} 
	
	public ParticipantResults (){ 
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public String getHomeLocation() {
		return homeLocation;
	}

	public void setHomeLocation(String homeLocation) {
		this.homeLocation = homeLocation;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public long getBibNumber() {
		return bibNumber;
	}

	public void setBibNumber(long bibNumber) {
		this.bibNumber = bibNumber;
	}

	public long getAge() {
		return age;
	}

	public void setAge(long age) {
		this.age = age;
	}

	public String getChipTime() {
		return chipTime;
	}

	public void setChipTime(String chipTime) {
		this.chipTime = chipTime;
	}

	public String getGunTime() {
		return gunTime;
	}

	public void setGunTime(String gunTime) {
		this.gunTime = gunTime;
	}
	
	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}
}
