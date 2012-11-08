package transformers;

import java.util.List;

import models.ParticipantResults;
import models.Race;

public class BeanToGoogleChartJsonTransformer {
	public static String resultsJson(List<ParticipantResults> results){
		StringBuilder json = new StringBuilder(" {\"cols\":["+
		     "{\"id\":\"A\",\"label\":\"Name\",\"type\":\"string\"},"+
		     "{\"id\":\"B\",\"label\":\"Division\",\"type\":\"string\"},"+
		     "{\"id\":\"C\",\"label\":\"Home Location\",\"type\":\"string\"},"+
		     "{\"id\":\"D\",\"label\":\"Gender\",\"type\":\"string\"},"+
		     "{\"id\":\"E\",\"label\":\"Bib Number\",\"type\":\"string\"},"+
		     "{\"id\":\"F\",\"label\":\"Age\",\"type\":\"number\"},"+
		     "{\"id\":\"G\",\"label\":\"Chip time\",\"type\":\"timeofday\"},"+
		     "{\"id\":\"H\",\"label\":\"Gun time\",\"type\":\"timeofday\"}],"+
         "\"rows\":[");
		for (int i=0; i<results.size(); i++) {
			json.append("{\"c\":[");
			json.append("{\"v\": \"").append(results.get(i).getName()).append("\"},");
			json.append("{\"v\": \"").append(results.get(i).getDivision()).append("\"},");
			json.append("{\"v\": \"").append(results.get(i).getHomeLocation()).append("\"},");
			json.append("{\"v\": \"").append(results.get(i).getGender()).append("\"},");
			json.append("{\"v\": ").append(results.get(i).getBibNumber()).append("},");
			json.append("{\"v\": ").append(results.get(i).getAge()).append("},");
			json.append("{\"f\": \"").append(results.get(i).getChipTime()).append("\"},");
			json.append("{\"f\": \"").append(results.get(i).getGunTime()).append("\"}");
			json.append("]}");
			if (i<results.size()-1){
				json.append(",");
			}
		}
		json.append("]}");
		return json.toString();
	}
}
