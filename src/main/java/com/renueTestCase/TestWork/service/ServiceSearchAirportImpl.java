package com.renueTestCase.TestWork.service;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.renueTestCase.TestWork.DAO.ReadFile;
import com.renueTestCase.TestWork.model.Airport;

//сервис поиска по предварительно отсортированному файлу
@Service
public class ServiceSearchAirportImpl implements ServiceSearchAirport{

	private int checkSearch = 0;
	private int numOfRowsFound = 0;
	
	@Value("${idFieldSearch}")
	private int idFieldSearch;
	
	//метод выводящий на экран информацию по заданному запросу
	@Override
	public int search(String query) {
		ReadFile readFile = new ReadFile();
		Iterator<Airport> iteratorAirport = readFile.getIteratorFile("sortedFile.tmp");
		
		while(iteratorAirport.hasNext() & checkSearch != 2) {
			searchOfField(iteratorAirport.next(), query);
		}
		
		checkSearch = 0;
		readFile.closeReader();
		int numOfRowsFound2 = numOfRowsFound;
		numOfRowsFound = 0;
		return numOfRowsFound2;
	}
	
	//метод сравнения входящего объекта с запросом учитывая заданный столбец в пропертах
	private void searchOfField(Airport airport, String query) {
		
		switch(idFieldSearch){
		case 1: 
				if(airport.getName().startsWith(query)) {
					checkSearch = 1;
					System.out.println(airport.toString());
					numOfRowsFound++;
				}else {
					if(checkSearch == 1) {
						checkSearch = 2;
					}
				}
			break;
		case 2: 
				if(airport.getCity().startsWith(query)) {
					checkSearch = 1;
					System.out.println(airport.toString());
					numOfRowsFound++;
				}else {
					if(checkSearch == 1) {
						checkSearch = 2;
					}
				}
			break;
		case 3: 
				if(airport.getCountry().startsWith(query)) {
					checkSearch = 1;
					System.out.println(airport.toString());
					numOfRowsFound++;
				}else {
					if(checkSearch == 1) {
						checkSearch = 2;
					}
				}
			break;
		case 4: 
				if(airport.getIata().startsWith(query)) {
					checkSearch = 1;
					System.out.println(airport.toString());
					numOfRowsFound++;
				}else {
					if(checkSearch == 1) {
						checkSearch = 2;
					}
				}
			break;
		case 5: 
				if(airport.getIkao().startsWith(query)) {
					checkSearch = 1;
					System.out.println(airport.toString());
					numOfRowsFound++;
				}else {
					if(checkSearch == 1) {
						checkSearch = 2;
					}
				}
			break;
		case 6: 
				Float f1 = airport.getLatitude();
				if(f1.toString().startsWith(query)) {
					checkSearch = 1;
					System.out.println(airport.toString());
					numOfRowsFound++;
				}else {
					if(checkSearch == 1) {
						checkSearch = 2;
					}
				}
			break;
		case 7: 
				Float f2 = airport.getLongitude();
				if(f2.toString().startsWith(query)) {
					checkSearch = 1;
					System.out.println(airport.toString());
					numOfRowsFound++;
				}else {
					if(checkSearch == 1) {
						checkSearch = 2;
					}
				}
			break;
		case 8: 
				Integer i1 = airport.getIdontKnow1();
				if(i1.toString().startsWith(query)) {
					checkSearch = 1;
					System.out.println(airport.toString());
					numOfRowsFound++;
				}else {
					if(checkSearch == 1) {
						checkSearch = 2;
					}
				}
			break;
		case 9: 
				if(airport.getIdontKnow2().startsWith(query)) {
					checkSearch = 1;
					System.out.println(airport.toString());
					numOfRowsFound++;
				}else {
					if(checkSearch == 1) {
						checkSearch = 2;
					}
				}
			break;
		case 10: 

				if(airport.getIataCode().startsWith(query)) {
					checkSearch = 1;
					System.out.println(airport.toString());
					numOfRowsFound++;
				}else {
					if(checkSearch == 1) {
						checkSearch = 2;
					}
				}
			break;
		case 11: 
				if(airport.getTimeZone().startsWith(query)) {
					checkSearch = 1;
					System.out.println(airport.toString());
					numOfRowsFound++;
				}else {
					if(checkSearch == 1) {
						checkSearch = 2;
					}
				}
			break;
		case 12: 
				if(airport.getItIs().startsWith(query)) {
					checkSearch = 1;
					System.out.println(airport.toString());
					numOfRowsFound++;
				}else {
					if(checkSearch == 1) {
						checkSearch = 2;
					}
				}
			break;
		case 13: 
				if(airport.getOurAirports().startsWith(query)) {
					checkSearch = 1;
					System.out.println(airport.toString());
					numOfRowsFound++;
				}else {
					if(checkSearch == 1) {
						checkSearch = 2;
					}
				}
				break;
		default:
			break;
		}
	}

}
