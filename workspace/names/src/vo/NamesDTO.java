package vo;

import java.util.ArrayList;
import java.util.Collections;

public class NamesDTO {
	private String name;
	private int ranking;
	private int population;
	//성별
	private char gender;
	
	public NamesDTO() {;}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRanking() {
		return ranking;
	}

	public void setRanking(int ranking) {
		this.ranking = ranking;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}
	
	@Override
	public String toString() {
		String result = "";
		String population = this.population + "";
		ArrayList<String> datas = new ArrayList<>();
		population.chars().forEach(c -> datas.add("" + (char)c));
		Collections.reverse(datas);
		
		for (int i = 0; i < datas.size(); i++) {
			if(i % 3 == 2 && datas.size() != i + 1) {
				datas.add(i + 1, ",");
			}
		}
		
		Collections.reverse(datas);
		
		for (int i = 0; i < datas.size(); i++) {
			result += datas.get(i);
		}
		
		String str = this.gender + "\t"
						+ this.name + "\t"
						+ this.ranking + "\t"
						+ result + "\n";
		return str;
	}
}













