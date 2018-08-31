package main.enums;

import java.util.Random;

public enum Names {
	MALE("Adam", "Adolf", "Adrian", "Albert", "Aleksander", "Aleksy", "Alfred", "Amadeusz", "Andrzej", "Antoni", "Arkadiusz", "Arnold", "Artur", "Bart³omiej", "Bartosz", "Benedykt",
			"Beniamin", "Bernard", "B³a¿ej", "Bogdan", "Bogumi³", "Bogus³aw", "Boles³aw", "Borys", "Bronis³aw", "Cezary", "Cyprian", "Cyryl", "Czes³aw", "Damian", "Daniel"),
	FEMALE("Ada", "Adela", "Adelajda", "Adrianna", "Agata", "Agnieszka", "Aldona", "Aleksandra", "Alicja", "Alina", "Amanda", "Amelia", "Anastazja", "And¿elika", "Aneta", "Anita", "Anna",
			"Barbara", "Beata", "Berenika", "Bernadeta", "Blanka", "Bogus³awa", "Bo¿ena", "Cecylia", "Celina", "Czes³awa", "Dagmara", "Danuta", "Daria", "Diana", "Dominika", "Dorota");
	
	private String[] namesArray;
	
	private Names(String...values){
		namesArray = values;
	}
	
	public String getName() {
		return namesArray[new Random().nextInt(namesArray.length)];
	}
	
}
