package com.ust.esdemo.dao;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Component;

import com.ust.esdemo.model.Crime;

@Component
public class CrimeDAO {

	public List<Crime> getCrimeRecords(Map<String,Object> payload) {
		StringBuffer buildString = new StringBuffer();
		buildString.append(payload.get("path")).append("/").append(payload.get("filename"));
		String path = buildString.toString();
		//System.out.println(path);
		Reader re;
		List<Crime> crimeRecords = new ArrayList<>();
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss a");
		try {
			re = Files.newBufferedReader(Paths.get(path));
			CSVParser csvParser = new CSVParser(re, CSVFormat.DEFAULT.withFirstRecordAsHeader());
			for (CSVRecord csvRecord : csvParser) {
				Crime c = new Crime();
				c.setCrimeId(csvRecord.get("Crime_ID"));
				c.setCaseNumber(csvRecord.get("Case Number"));
				Date d = dateFormat.parse(csvRecord.get("Date").trim());
				c.setDate(d);
				c.setBlock(csvRecord.get("Block"));
				c.setIUCR(csvRecord.get("IUCR"));
				c.setPrimaryType(csvRecord.get("Primary Type"));
				c.setDescription(csvRecord.get("Description"));
				c.setLocationDescription(csvRecord.get("Location Description"));
				c.setArrest(csvRecord.get("Arrest"));
				c.setDomestic(csvRecord.get("Domestic"));
				c.setBeat(Integer.parseInt(csvRecord.get("Beat").trim()));
				c.setDistrict(Integer.parseInt(csvRecord.get("District")));
				c.setWard(Integer.parseInt(csvRecord.get("Ward")));
				c.setCommunityArea(Integer.parseInt(csvRecord.get("Community Area")));
				c.setFbiCode(csvRecord.get("FBI Code"));
				if (!(csvRecord.get("X Coordinate").trim().isEmpty())) {
					c.setxCoordinate(Integer.parseInt(csvRecord.get("X Coordinate")));

				}
				if (!(csvRecord.get("Y Coordinate").trim().isEmpty())) {
					c.setyCoordinate(Integer.parseInt(csvRecord.get("Y Coordinate")));

				}
				c.setYear(Integer.parseInt(csvRecord.get("Year").trim()));
				c.setUpdatedOn(dateFormat.parse(csvRecord.get("Updated On").trim()));

				/*
				 * This piece will be useful later
				 * 
				 * c.setUpdatedOn(LocalDateTime.parse(csvRecord.get("Updated On").trim(),
				 * DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm:ss a")));
				 */
				if (!(csvRecord.get("Latitude").trim().isEmpty())) {
					c.setLatitude(Double.parseDouble(csvRecord.get("Latitude").trim()));
				}
				if (!(csvRecord.get("Longitude").trim().isEmpty())) {
					c.setLatitude(Double.parseDouble(csvRecord.get("Longitude").trim()));
				}
				if (!(csvRecord.get("Location").trim().isEmpty())) {
					c.setLocation(csvRecord.get("Location"));
				}
				crimeRecords.add(c);

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return crimeRecords;
	}

}
