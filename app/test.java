import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import models.ParticipantResults;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.bean.ColumnPositionMappingStrategy;
import au.com.bytecode.opencsv.bean.CsvToBean;


public class test {
public static void main(String[] args) throws IOException {
//	ColumnPositionMappingStrategy strat = new ColumnPositionMappingStrategy();
//	strat.setType(Bean.class);
//	strat.setColumnMapping(new String[] {"name","age"});
//
//	CsvToBean csv = new CsvToBean();
//	File resultsCsv = new File("/home/nicole/Documents/sampleResults2.csv");
//	CSVReader reader = new CSVReader(new FileReader(resultsCsv));
////	System.out.println( csv.parse(strat, reader));
//	
//	List<String[]> readAll = reader.readAll();
//	for (String[] strings : readAll) {
////		System.out.println(strings[0] + " " + strings[1] + " " + strings[2] + " " + strings[3] 
////		                  + " " + strings[4] + " " + strings[5] + " " + strings[6] + " " + strings[7]);
//	 }
//	
//	List parse = csv.parse(strat, reader);
//	
//	System.out.println(results.size());
////	System.out.println(results);
}
}
