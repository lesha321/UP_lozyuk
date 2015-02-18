import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;


public class FileManipulator {
	private ArrayList<Juice> juices = new ArrayList<Juice>();
	private HashSet<String> set = new HashSet<String>();
	private ArrayList<String> list = new ArrayList<String>();
	
	public void readFromFile(String fileName){	
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
			String components;
			while((components = reader.readLine())!=null){
				if(components.isEmpty())
					continue;
				String [] tokens = components.split(" ");
				Collections.addAll(set, tokens);
				Collections.addAll(list, tokens);
				Fruit [] fruits = new Fruit[tokens.length];
				for(int i = 0 ; i < tokens.length ; i ++)
					fruits[i] = new Fruit(tokens[i]);
				juices.add(new Juice(fruits));
			}
			Collections.sort(list);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void writeToFiles(int result){
		try{
		    PrintWriter out = new PrintWriter(new File("juice1.out.txt").getAbsoluteFile());
		    PrintWriter out1 = new PrintWriter(new File("juice2.out.txt").getAbsoluteFile());
		    PrintWriter out2 = new PrintWriter(new File("juice3.out.txt").getAbsoluteFile());
		    try{
		    	for (String juice : set) {
					out.println(juice);
		    	}
		    	for (String juice : list) {
		    		out1.println(juice);
					}
		    	out2.println(result);
		    	}finally {
		        	out.close();
		            out1.close();
		            out2.close();
		        }
		        }catch(IOException e) {
		          throw new RuntimeException(e);
		        }
	}
	public ArrayList<Juice> getJuices() {
		return (ArrayList<Juice>)juices.clone();
	}
	public HashSet<String> getSet() {
		return (HashSet<String>)set.clone();
	}
	public ArrayList<String> getList() {
		return (ArrayList<String>)list.clone();
	}
	

}
