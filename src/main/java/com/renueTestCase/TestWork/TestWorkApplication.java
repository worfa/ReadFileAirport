package com.renueTestCase.TestWork;


import java.time.Duration;
import java.time.Instant;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.renueTestCase.TestWork.DAO.AirportDAO;

@SpringBootApplication
public class TestWorkApplication implements CommandLineRunner {

	@Autowired
	AirportDAO airportDAO;
	 
	public static void main(String[] args) {
        SpringApplication.run(TestWorkApplication.class, args);
	}

	@Override
    public void run(String... args) {
        
		String query = "";
        Scanner sc = new Scanner(System.in);
        do { 
        	System.out.print("Введите запрос: ");
        
	        //---read search bar
	        query = sc.nextLine();
	        if(!query.equals("stop")) {
	
		        //---search
		        Instant start = Instant.now();
		        int numOfFoundRow = airportDAO.getAirports(query);
		        Instant finish = Instant.now();
		        long enlapsed = Duration.between(start, finish).toMillis();
		        
		        System.out.println("Количесво найденных записей: " + numOfFoundRow);
		        System.out.println("Время поиска: " + enlapsed);
		        System.out.println("Введите \"stop\" для окончания работы программы \n\n\n");
	        }
        }while(!query.equals("stop"));
        System.out.println("Пока!!!");
        sc.close();
	}
}
