package rest;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class City {

	@Id
	@GeneratedValue
	private Long id;

	private String name;
	private int population;

	@ManyToOne
	private State state;

	public String getName() {
		return name;
	}

	public int getPopulation() {
		return population;
	}

	public Long getId() {
		return id;
	}

	@SuppressWarnings("unused")
	private City() {

	}

	public City(String name, State state, int population) {
		this.name = name;
		this.state = state;
		this.population = population;
	}

}
