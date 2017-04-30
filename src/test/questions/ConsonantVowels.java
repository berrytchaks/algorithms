package test.questions;

import java.util.LinkedList;
import java.util.List;

public class ConsonantVowels {
	private String vowels = "aeiou";
	private List<CharSequence> list;
	public ConsonantVowels(){
		list =new LinkedList<>();
	}
	public List<CharSequence> rearrange(){
		List<CharSequence> vowelsList = new LinkedList<>();
		List<CharSequence> consonantList = new LinkedList<>();
		for (int i =0; i <list.size(); i++){
			if (vowels.contains(list.get(i))){
				vowelsList.add(list.get(i));
			}else{
				consonantList.add(list.get(i));
			}
		}
		for(int i =0; i < consonantList.size(); i++){
			vowelsList.add(consonantList.get(i));
		}
		return vowelsList;
	}
	private void addLetter(CharSequence letter){
		list.add(letter);
	}
	public static void main(String... args){
		ConsonantVowels consonantVowels = new ConsonantVowels();
		consonantVowels.addLetter("d");
		consonantVowels.addLetter("a");
		consonantVowels.addLetter("v");
		consonantVowels.addLetter("i");
		consonantVowels.addLetter("d");
		consonantVowels.addLetter("o");
		List<CharSequence> listConsonantVowels = consonantVowels.rearrange();
		System.out.println(listConsonantVowels);
		
	}
}
