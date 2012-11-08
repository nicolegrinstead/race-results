package files;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import au.com.bytecode.opencsv.CSVReader;

public class CsvParser<T> {
	private String[] headers;
	private final Class<T> type;

	public CsvParser(String headers, Class<T> type) {
		this.headers = headers.split(",");
		this.type = type;
	}
	
	public List<T> parse(File file) throws IllegalAccessException, InvocationTargetException, IOException, InstantiationException{ 
		List<T> results = new ArrayList<T>();
		CSVReader reader = new CSVReader(new FileReader(file));
		List<String[]> readAll = reader.readAll();
		readAll.remove(0); //remove header row
		for (String[] currentLine : readAll) {
			T bean = type.newInstance();
			for (int i=0; i<headers.length; i++){ 
				BeanUtils.setProperty(bean,headers[i],currentLine[i]); 
			}
			results.add(bean);
		}
		return results;
	}
}
