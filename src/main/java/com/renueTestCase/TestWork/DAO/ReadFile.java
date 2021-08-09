package com.renueTestCase.TestWork.DAO;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.renueTestCase.TestWork.model.Airport;

//Класс которвый считывает файлы и возвращает итератор с методом закрытия чтения

public class ReadFile {

	private Reader reader;
	private CsvToBean<Airport> csvToBean;
	
	public Iterator<Airport> getIteratorFile(String nameFile){
		try {
			reader = Files.newBufferedReader(Paths.get(nameFile));
		} catch (IOException e) {
			reader = null;
			e.printStackTrace();
		}
		csvToBean = new CsvToBeanBuilder<Airport>(reader)
			       .withType(Airport.class)
			       .build();
		return csvToBean.iterator();
	}
	
	public void closeReader() {
		try {
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}