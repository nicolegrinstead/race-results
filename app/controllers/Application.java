package controllers;

import play.*;
import play.data.validation.Error;
import play.data.validation.Required;
import play.data.validation.Valid;
import play.db.jpa.JPA;
import play.mvc.*;
import play.mvc.results.*;

import play.mvc.results.Ok.*;
import transformers.BeanToGoogleChartJsonTransformer;
import transformers.JsonNumberTransformer;
import transformers.JsonStringTransformer;
import transformers.JsonTimeTransformer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

import javax.persistence.Query;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.jaxen.expr.iter.IterableSelfAxis;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.bean.ColumnPositionMappingStrategy;
import au.com.bytecode.opencsv.bean.CsvToBean;

import com.google.common.collect.Iterables;
import com.google.gson.JsonSerializer;

import files.CsvParser;
import flexjson.JSONSerializer;
import flexjson.transformer.Transformer;

import net.sf.oval.guard.Post;

import models.*;

public class Application extends Controller {

	public static void index() {
		render();
	}
	
	public static void home() {
	    render();
	}

	public static void find() {
	    render();
	}
	
	public static void findResults(String eventName, String date, String cityState, String zip){ 
		List<Race> races = Race.find("byEventName", eventName).fetch();
		render(races);
	}
	
	public static void showResults(Long raceId){
		Race race = Race.findById(raceId);
		
		render(race);
	}

	public static void resultsJson(Long raceId, String criteria){
		List<ParticipantResults> results = ParticipantResults.find("byRaceId", raceId).fetch();

		renderJSON(BeanToGoogleChartJsonTransformer.resultsJson(results));
	}
	
	public static void timeChartJson(Long raceId){ 
	   Query query = JPA.em().createQuery("select substring(chipTime,0,4), count(chipTime) from ParticipantResults group by substring(chipTime,0,4) order by 1");
	   renderJSON(query.getResultList());
	}

	public static void upload(){ 
		render();
	}
	
	public static void uploadSubmit(@Valid Race race, @Required(message="It has to have results") File resultsCsv) throws FileNotFoundException {
		if(validation.hasErrors()) {
			validation.keep(); 
	    	params.flash();
	    	upload();
	    }
		
		List<ParticipantResults> results = new ArrayList<ParticipantResults>();
		CsvParser parser = new CsvParser("name,homeLocation,bibNumber,age,gender,division,chipTime,gunTime", ParticipantResults.class);
		try {
			results = parser.parse(resultsCsv);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		for (ParticipantResults result : results) {
			result.save();
		}
		race.results = results;
		race.save();
		
	    showResults(race.getId());
	}
}