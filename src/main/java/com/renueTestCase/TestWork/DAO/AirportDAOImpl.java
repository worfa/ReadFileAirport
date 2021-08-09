package com.renueTestCase.TestWork.DAO;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.renueTestCase.TestWork.service.ServiceSearchAirport;
import com.renueTestCase.TestWork.service.ServiceSortFileAirport;

//класс получения аэропортов по запросу
@Repository
public class AirportDAOImpl implements AirportDAO{
	
	@Value("${idFieldSearch}")
	private int idFieldSearch;
	
	@Autowired
	private ServiceSortFileAirport serviceSortFileAirport;
	
	@Autowired
	private ServiceSearchAirport serviceSearchAirport;
	
	private boolean checkFile;
	
	//метод предварительной сортировки при создании бина(в начале работы программы)
	@PostConstruct
	private void init() {
		if(idFieldSearch > 0 && idFieldSearch <= 13)
			checkFile = serviceSortFileAirport.createSortedFile();
		else 
			System.out.println("Укажите корректный столбец поиска в свойствах от 1 до 13");
	}
	//метод уничтожающий отсортированный файл по окончанию программы
	@PreDestroy
	private void destroy() {
		try {
			if(Files.exists(Paths.get("sortedFile.tmp")))
				Files.delete(Paths.get("sortedFile.tmp"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/*Принимает запрос и возвращает количество найденных строк*/
	
	@Override
	public int getAirports(String query) {
		if(checkFile || (idFieldSearch < 1 & idFieldSearch > 13))
			return serviceSearchAirport.search(query);
		else {
			System.out.println("Некорректные данные в свойствах!");
			return 0;
		}
	}
	
	
	

}
