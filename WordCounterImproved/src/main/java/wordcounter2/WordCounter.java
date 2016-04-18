package wordcounter2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Hashtable;

import org.apache.commons.lang3.StringUtils;

public class WordCounter {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 try {
	            FileReader file = new FileReader("src/main/resources/file.txt");
	            BufferedReader buff = new BufferedReader(file);
	            boolean eof = false;
	            Hashtable<String, Integer> wordsFromFile = new Hashtable<String, Integer>();
	           
	            while (!eof) {
	                String line = buff.readLine();
	                if (line == null) {
	                    eof = true;
	                } else {
	                	//line = line.toLowerCase();
	                	line = StringUtils.uncapitalize(line);
	                	String[] words = line.split(" ");
	                	for(int i = 0; i < words.length; i++){
	                		if(wordsFromFile.get(words[i]) != null){
	                			int count = wordsFromFile.get(words[i]);
	                			wordsFromFile.replace(words[i], count, (count+1));
	                		}
	                		else
	                		{
	                			wordsFromFile.put(words[i], 1);
	                		}
	                	}
	                }
	            }
	            buff.close();
	            
	            System.out.println(wordsFromFile);

	        } catch (IOException e) {
	            System.out.println("Error — " + e.toString());

	        }
	}

}
