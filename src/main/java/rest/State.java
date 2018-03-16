package rest;

import static java.lang.String.format;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class State {

	@Id
	@GeneratedValue
	private Long id;
	private String abbreviation;
	private String name;
	private String motto;
	private String fish;

	@JsonIgnore
	@OneToMany(mappedBy = "state")
	private Collection<City> cities;

	public String getAbbreviation() {
		return abbreviation;
	}

	public String getName() {
		return name;
	}

	public String getMotto() {
		return motto;
	}

	public String getFish() {
		return fish;
	}

	public Collection<String> getCitiesUrl() {
		Collection<String> urls = new ArrayList<>();
		for (City city : cities) {
			urls.add(format("/city/%d", city.getId()));
		}
		return urls;
	}

	public Collection<City> getCities() {

		return cities;
	}

	@SuppressWarnings("unused")
	private State() {

	}

	public State(String abbreviation, String name, String motto, String fish) {
		this.abbreviation = abbreviation;
		this.name = name;
		this.motto = motto;
		this.fish = fish;

	}

}
