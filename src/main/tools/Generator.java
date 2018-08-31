package main.tools;
import java.util.Random;

import main.enums.Names;

public class Generator{
	private final String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private final String LOWER = UPPER.toLowerCase();
	private final String NUMBER = "0123456789";
	private Random random = new Random();
	
	
	public String gLower (int wordSize) {
		String result ="";
		for (int i=0 ; i<wordSize; i++) {
			char temp = LOWER.charAt(random.nextInt(LOWER.length()));
			result += String.valueOf(temp);
		}
		return result;
	}
	
	public String gUpper (int wordSize) {
		String result ="";
		for (int i=0 ; i<wordSize; i++) {
			char temp = UPPER.charAt(random.nextInt(UPPER.length()));
			result += String.valueOf(temp);
		}
		return result;
	}
	
	public String gNumbers (int wordSize) {
		String result ="";
		for (int i=0 ; i<wordSize; i++) {
			char temp = NUMBER.charAt(random.nextInt(NUMBER.length()));
			result += String.valueOf(temp);
		}
		return result;
	}
	
	public int randomFromRange (int from, int to) {
		return random.nextInt(to-from+1)+from;
	}
	
	public String gPass(int wordSize) {
		String result = "";
		for (int i=0;i<wordSize;i++) {
			char[] charArray = {gLower(1).charAt(0), gUpper(1).charAt(0),gNumbers(1).charAt(0)};
			String temp = String.valueOf(charArray[random.nextInt(charArray.length)]);
			result +=temp;
		}
		return result;
	}
	
	public String gName(Names gender) {
		if (gender == Names.MALE) {
			return Names.MALE.getName();
		}
		else if (gender == Names.FEMALE) {
			return Names.FEMALE.getName();
		}
		else {
			return null;
		}
	}
	public String gName() {
		Names[] namesArray = {Names.MALE, Names.FEMALE};
		return namesArray[random.nextInt(2)].getName();
	}
	
	public String gEmail(int prefix) {
		String[] server = {"gmail","googlemail","outlook","mail","yahoo","aol","outlook"};
		String[] suffix = {"pl","com","gf","cz","gb","it","sk","tr","cn","be","au","is","fr"};
		return String.format("%s@%s.%s", gLower(prefix), server[random.nextInt(server.length)], suffix[random.nextInt(suffix.length)]);
	}	
}
