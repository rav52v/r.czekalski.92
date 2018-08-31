package main.enums;

import java.util.Random;

public enum Names {
	MALE("Adam", "Adolf", "Adrian", "Albert", "Aleksander", "Aleksy", "Alfred", "Amadeusz", "Andrzej", "Antoni", "Arkadiusz", "Arnold", "Artur", "Bart�omiej", "Bartosz", "Benedykt",
			"Beniamin", "Bernard", "B�a�ej", "Bogdan", "Bogumi�", "Bogus�aw", "Boles�aw", "Borys", "Bronis�aw", "Cezary", "Cyprian", "Cyryl", "Czes�aw", "Damian", "Daniel"),
	FEMALE("Ada", "Adela", "Adelajda", "Adrianna", "Agata", "Agnieszka", "Aldona", "Aleksandra", "Alicja", "Alina", "Amanda", "Amelia", "Anastazja", "And�elika", "Aneta", "Anita", "Anna",
			"Barbara", "Beata", "Berenika", "Bernadeta", "Blanka", "Bogus�awa", "Bo�ena", "Cecylia", "Celina", "Czes�awa", "Dagmara", "Danuta", "Daria", "Diana", "Dominika", "Dorota");
	
	private String[] namesArray;
	
	private Names(String...values){
		namesArray = values;
	}
	
	public String getName() {
		return namesArray[new Random().nextInt(namesArray.length)];
	}
	
}
