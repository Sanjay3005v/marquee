package july24;

import java.util.*;

public class CharacterFrequency {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the sentence");
		String str = scan.nextLine();
		scan.close();
		countFrequency(str);
	}
	public static void countFrequency(String str) {
		TreeMap<Character,Integer> map = new TreeMap<>();
		for(char ch:str.toCharArray()) {
			map.put(ch, map.getOrDefault(ch, 0)+1);
		}
		System.out.println("Frequency");
		System.out.println(map);
	}
}
