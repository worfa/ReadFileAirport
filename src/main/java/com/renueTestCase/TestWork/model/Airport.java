package com.renueTestCase.TestWork.model;

import com.opencsv.bean.CsvBindByPosition;

//модель объекта аэропорта
public class Airport {

	@CsvBindByPosition(position = 0)
	private long id;
	
	@CsvBindByPosition(position = 1)
	private String name;
	
	@CsvBindByPosition(position = 2)
	private String city;
	
	@CsvBindByPosition(position = 3)
	private String country;
	
	@CsvBindByPosition(position = 4)
	private String iata;
	
	@CsvBindByPosition(position = 5)
	private String ikao;
	
	@CsvBindByPosition(position = 6)
	private float latitude;
	
	@CsvBindByPosition(position = 7)
	private float longitude;
	
	@CsvBindByPosition(position = 8)
	private int IdontKnow1;
	
	@CsvBindByPosition(position = 9)
	private String IdontKnow2;
	
	@CsvBindByPosition(position = 10)
	private String iataCode;
	
	@CsvBindByPosition(position = 11)
	private String timeZone;
	
	@CsvBindByPosition(position = 12)
	private String itIs;
	
	@CsvBindByPosition(position = 13)
	private String ourAirports;

	public Airport(long id, String name, String city, String country, String iata, String ikao, float latitude,
			float longitude, int idontKnow1, String idontKnow2, String iataCode, String timeZone, String itIs,
			String ourAirports) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
		this.country = country;
		this.iata = iata;
		this.ikao = ikao;
		this.latitude = latitude;
		this.longitude = longitude;
		IdontKnow1 = idontKnow1;
		IdontKnow2 = idontKnow2;
		this.iataCode = iataCode;
		this.timeZone = timeZone;
		this.itIs = itIs;
		this.ourAirports = ourAirports;
	}

	public Airport() {
		super();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + IdontKnow1;
		result = prime * result + ((IdontKnow2 == null) ? 0 : IdontKnow2.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((iata == null) ? 0 : iata.hashCode());
		result = prime * result + ((iataCode == null) ? 0 : iataCode.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((ikao == null) ? 0 : ikao.hashCode());
		result = prime * result + ((itIs == null) ? 0 : itIs.hashCode());
		result = prime * result + Float.floatToIntBits(latitude);
		result = prime * result + Float.floatToIntBits(longitude);
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((ourAirports == null) ? 0 : ourAirports.hashCode());
		result = prime * result + ((timeZone == null) ? 0 : timeZone.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Airport other = (Airport) obj;
		if (IdontKnow1 != other.IdontKnow1)
			return false;
		if (IdontKnow2 == null) {
			if (other.IdontKnow2 != null)
				return false;
		} else if (!IdontKnow2.equals(other.IdontKnow2))
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (iata == null) {
			if (other.iata != null)
				return false;
		} else if (!iata.equals(other.iata))
			return false;
		if (iataCode == null) {
			if (other.iataCode != null)
				return false;
		} else if (!iataCode.equals(other.iataCode))
			return false;
		if (id != other.id)
			return false;
		if (ikao == null) {
			if (other.ikao != null)
				return false;
		} else if (!ikao.equals(other.ikao))
			return false;
		if (itIs == null) {
			if (other.itIs != null)
				return false;
		} else if (!itIs.equals(other.itIs))
			return false;
		if (Float.floatToIntBits(latitude) != Float.floatToIntBits(other.latitude))
			return false;
		if (Float.floatToIntBits(longitude) != Float.floatToIntBits(other.longitude))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (ourAirports == null) {
			if (other.ourAirports != null)
				return false;
		} else if (!ourAirports.equals(other.ourAirports))
			return false;
		if (timeZone == null) {
			if (other.timeZone != null)
				return false;
		} else if (!timeZone.equals(other.timeZone))
			return false;
		return true;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getIata() {
		return iata;
	}

	public void setIata(String iata) {
		this.iata = iata;
	}

	public String getIkao() {
		return ikao;
	}

	public void setIkao(String ikao) {
		this.ikao = ikao;
	}

	public float getLatitude() {
		return latitude;
	}

	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}

	public float getLongitude() {
		return longitude;
	}

	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}

	public int getIdontKnow1() {
		return IdontKnow1;
	}

	public void setIdontKnow1(int idontKnow1) {
		IdontKnow1 = idontKnow1;
	}

	public String getIdontKnow2() {
		return IdontKnow2;
	}

	public void setIdontKnow2(String idontKnow2) {
		IdontKnow2 = idontKnow2;
	}

	public String getIataCode() {
		return iataCode;
	}

	public void setIataCode(String iataCode) {
		this.iataCode = iataCode;
	}

	public String getTimeZone() {
		return timeZone;
	}

	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}

	public String getItIs() {
		return itIs;
	}

	public void setItIs(String itIs) {
		this.itIs = itIs;
	}

	public String getOurAirports() {
		return ourAirports;
	}

	public void setOurAirports(String ourAirports) {
		this.ourAirports = ourAirports;
	}

	@Override
	public String toString() {
		return  id + ",\"" + name + "\",\"" + city
				+ "\",\"" + country + "\",\"" + iata + "\",\"" + ikao + "\",\"" + latitude
				+ "\",\"" + longitude + "\",\"" + IdontKnow1 + "\",\"" + IdontKnow2
				+ "\",\"" + iataCode + "\",\"" + timeZone + "\",\"" + itIs + "\",\""
				+ ourAirports + "\"";
	}
}
