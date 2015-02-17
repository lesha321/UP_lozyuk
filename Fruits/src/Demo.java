import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;


public class Demo {
	public static void main(String args []){
		
		String fileName = "juice.txt";
		FileReader reader = new FileReader();
		
		reader.readFromFile(fileName);
	
		System.out.println();	
	
		System.out.println("Различные компоненты : ");
		for (String string : reader.getSet())
			System.out.println(string);
		
		System.out.println();
	
		System.out.println("Список по возрастанию : ");
		for (String string : reader.getList())
			System.out.println(string);
		reader.writeToFiles();
		ArrayList<Integer> integers = new ArrayList<Integer>();
		
		Juicer juicer = new Juicer();
		ArrayList<Juice> juices = reader.getJuices();
		Collections.sort(juices);
		System.out.println("Список соков : ");
		for (Juice juice : juices) 
			System.out.println(juice);
		juicer.optimalWork(juices);
		System.out.println("Кол-во чисток : " + juicer.getNumberOfCleanings());
		
	}
}
