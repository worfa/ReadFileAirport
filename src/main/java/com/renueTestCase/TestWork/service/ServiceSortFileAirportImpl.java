package com.renueTestCase.TestWork.service;

import java.io.IOException;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.renueTestCase.TestWork.DAO.ReadFile;
import com.renueTestCase.TestWork.model.Airport;

// сервис считывани исходного файла, имя которого получается из пропертов, и предварительной его подготовки

@Service
public class ServiceSortFileAirportImpl implements ServiceSortFileAirport{

	@Value("${nameFile}")
	private String mainFile;
	
	@Value("${idFieldSearch}")
	private int idFieldSearch;
	
	private int numbFileTemp = 0;

	private int countStringOfFile = 0;
	
	private List<Airport> tempListAirport = new ArrayList<>();
	
	//разделение исходного файла на временные для предварительной сортировки
	private void filePartition() {

		ReadFile readFile = new ReadFile();
		WriteFile writeFile = new WriteFile();
		Iterator<Airport> iteratorAirport = readFile.getIteratorFile(mainFile);
		
		while(iteratorAirport.hasNext()) {
			if(countStringOfFile < 4000) {
				tempListAirport.add(iteratorAirport.next());
				countStringOfFile++;
			}else {
				writeFile.writeFileTmp();
			}
		}
		writeFile.writeFileTmp();
		readFile.closeReader();
	}
	//метод сортировки временного листа, учитывая выбранную колонку в пропертах
	private void sortList(List<Airport> list) {
		
			switch(idFieldSearch) {
			case 1: 
				Collections.sort(list, new Comparator<Airport>() {
					public int compare(Airport o1, Airport o2) {
						return o1.getName().compareTo(o2.getName());
					}
				});
				break;
			case 2: 
				Collections.sort(list, new Comparator<Airport>() {
					public int compare(Airport o1, Airport o2) {
						return o1.getCity().compareTo(o2.getCity());
					}
				});
				break;
			case 3:
				Collections.sort(list, new Comparator<Airport>() {
					public int compare(Airport o1, Airport o2) {
						return o1.getCountry().compareTo(o2.getCountry());
					}
				});
				break;
			case 4: 
				Collections.sort(list, new Comparator<Airport>() {
					public int compare(Airport o1, Airport o2) {
						return o1.getIata().compareTo(o2.getIata());
					}
				});
				break;
			case 5: 
				Collections.sort(list, new Comparator<Airport>() {
					public int compare(Airport o1, Airport o2) {
						return o1.getIkao().compareTo(o2.getIkao());
					}
				});
				break;
			case 6: 
				Collections.sort(list, new Comparator<Airport>() {
					public int compare(Airport o1, Airport o2) {
						Float f1 = o1.getLatitude();
						Float f2 = o2.getLatitude();
						return f1.compareTo(f2);
					}
				});
				break;
			case 7: 
				Collections.sort(list, new Comparator<Airport>() {
					public int compare(Airport o1, Airport o2) {
						Float f1 = o1.getLongitude();
						Float f2 = o2.getLongitude();
						return f1.compareTo(f2);
					}
				});
				break;
			case 8: 
				Collections.sort(list, new Comparator<Airport>() {
					public int compare(Airport o1, Airport o2) {
						Integer i1 = o1.getIdontKnow1();
						Integer i2 = o2.getIdontKnow1();
						return i1.compareTo(i2);
					}
				});
				break;
			case 9:
				Collections.sort(list, new Comparator<Airport>() {
					public int compare(Airport o1, Airport o2) {
						try{
							Float i1 = Float.valueOf(o1.getIdontKnow2());
							Float i2 = Float.valueOf(o1.getIdontKnow2());
							return i1.compareTo(i2);
						}catch(Exception e) {
							return o1.getIdontKnow2().compareTo(o2.getIdontKnow2());
						}
					}
				});
				break;
			case 10: 
				Collections.sort(list, new Comparator<Airport>() {
					public int compare(Airport o1, Airport o2) {
						return o1.getIataCode().compareTo(o2.getIataCode());
					}
				});
				break;
			case 11: 
				Collections.sort(list, new Comparator<Airport>() {
					public int compare(Airport o1, Airport o2) {
						return o1.getTimeZone().compareTo(o2.getTimeZone());
					}
				});
				break;
			case 12: 
				Collections.sort(list, new Comparator<Airport>() {
					public int compare(Airport o1, Airport o2) {
						return o1.getItIs().compareTo(o2.getItIs());
					}
				});
				break;
			case 13: 
				Collections.sort(list, new Comparator<Airport>() {
					public int compare(Airport o1, Airport o2) {
						return o1.getOurAirports().compareTo(o2.getOurAirports());
					}
				});
				break;
			default: 
	            break;
			}
		}

	//метод сборки отсортированного файла
	@Override
	public boolean createSortedFile() {
		if(Files.exists(Paths.get(mainFile))) {
			try {
				if(Files.exists(Paths.get("sortedFile.tmp"))) 
					Files.delete(Paths.get("sortedFile.tmp"));
				
				filePartition();
				
				Airport tmpObject = null;
				
				ReadFile readFile = new ReadFile();
				ReadFile readFile2 = new ReadFile();
				StringBuilder strBuilder = new StringBuilder();
				
				Iterator<Airport> iteratorTemp0 = readFile.getIteratorFile("temp0.tmp");
				Iterator<Airport> iteratorTemp1 = readFile2.getIteratorFile("temp1.tmp");
				
				tempListAirport.clear();
				if(iteratorTemp0.hasNext() || iteratorTemp1.hasNext()) {
					tempListAirport.add(iteratorTemp0.next());
					tmpObject = tempListAirport.get(0);
					tempListAirport.add(iteratorTemp1.next());
				}
	
				Writer write = Files.newBufferedWriter(Paths.get("sortedFile.tmp"), 
						StandardCharsets.UTF_8, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
			
			
				while(iteratorTemp0.hasNext() && iteratorTemp1.hasNext()) {
					sortList(tempListAirport);
					if(tempListAirport.get(0).equals(tmpObject)) {
						write.append(tempListAirport.get(0).toString() + "\n");
						tmpObject = tempListAirport.get(1);
						tempListAirport.clear();
						tempListAirport.add(iteratorTemp0.next());
						tempListAirport.add(tmpObject);
						tmpObject = tempListAirport.get(0);
					}else{
						write.append(tempListAirport.get(0).toString() + "\n");
						tmpObject = tempListAirport.get(1);
						tempListAirport.clear();
						tempListAirport.add(tmpObject);
						tempListAirport.add(iteratorTemp1.next());
					}
				}
				
				strBuilder.append(tempListAirport.get(0).toString() + "\n");
				strBuilder.append(tempListAirport.get(1).toString() + "\n");
				if(iteratorTemp0.hasNext()) {
					iteratorTemp0.forEachRemaining(a -> strBuilder.append(a.toString() + "\n"));
				}else {
					iteratorTemp1.forEachRemaining(a -> strBuilder.append(a.toString() + "\n"));
				}
				
				write.append(strBuilder);
				write.close();
				
				readFile.closeReader();
				readFile2.closeReader();
				
				Files.delete(Paths.get("temp0.tmp"));
				Files.delete(Paths.get("temp1.tmp"));
				
				return true;
			
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else {
			System.out.println("Файл указанный в свойствах не обнаружен,"
					+ " просьба ввести название файла в .properties файл");
			return false;
		}
		return false;
	}
	
	//класс записи в файлы
	private class WriteFile {
		
		public void writeFileTmp() {
			try {
				sortList(tempListAirport);
				if(Files.exists(Paths.get("temp" +numbFileTemp+ ".tmp"))) {
					Files.delete(Paths.get("temp" +numbFileTemp+ ".tmp"));
				}
				Path path = Paths.get("temp" +numbFileTemp+ ".tmp");
				Writer write = Files.newBufferedWriter(path, 
						StandardCharsets.UTF_8, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
				
				for(Airport airport :tempListAirport) 
					write.append(airport.toString() + "\n");
				write.close();
				
				numbFileTemp++;
				countStringOfFile = 0;
				tempListAirport.clear();
				
			}catch(IOException e){
				System.out.println(e);
			}
		}
	}
	
}
