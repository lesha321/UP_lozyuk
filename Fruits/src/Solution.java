import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;


public class Solution {
	private ArrayList<Juice> juices = new ArrayList<Juice>();
	private HashSet<Fruit> set = new HashSet<Fruit>();
	private ArrayList<Fruit> list = new ArrayList<Fruit>();
	private int result = 0;
	private FileManipulator fileManip = new FileManipulator();
	public Solution(){
		fileManip.readFromFile("juice.in.txt");
		fileManip.writeToFiles();
		ArrayList<Juice> juiceList = fileManip.getJuices();
		
		juices = (ArrayList<Juice>)juiceList.clone();
		
	}
	private void solution3(){
		
	}
}
