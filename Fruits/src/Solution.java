import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;


public class Solution {
	private ArrayList<Juice> juices = new ArrayList<Juice>();
	private FileManipulator fileManip = new FileManipulator();
	private int [] result;
	private int res;
	private boolean [] usedJuices;
	private int [][] graph;
	public Solution(){
		fileManip.readFromFile("juice.in.txt");
		juices = fileManip.getJuices();
		res = solution3();
		fileManip.writeToFiles(res);	
	}
	private int  solution3(){
	    graph = new int [juices.size()][juices.size()];
	    ArrayList<Juice> tmpArrayList = new ArrayList<>();        
	    
	    for (int index = 0; index < juices.size(); ++index) {
	        ArrayList<Fruit> tempJuice = new ArrayList<>();
	        tempJuice = juices.get(index).getComponents();
	        FruitSortStream stream = new FruitSortStream(tempJuice);
	        tmpArrayList.add(new Juice(stream.getFruits()));
	    }       
	    juices = tmpArrayList;
	        
	    for (int index1 = 0; index1 < juices.size(); ++index1)
	        for (int index2 = 0; index2 < juices.size(); ++index2) {
	            	
	        	ArrayList<Fruit> tempJuice1 = juices.get(index1).getComponents();
	            ArrayList<Fruit> tempJuice2 = juices.get(index2).getComponents();
	            
	            int tmpIndex1 = 0;
	            int tmpIndex2 = 0;
	            
	            while (tmpIndex1 < tempJuice1.size() && tmpIndex2 < tempJuice2.size()) {
	            	if (tempJuice1.get(tmpIndex1).equals(tempJuice2.get(tmpIndex2))) {
	                    ++tmpIndex1;
	                    ++tmpIndex2;
	                } else {
	                    ++tmpIndex2;
	                }
	            }
	            
	            if (tmpIndex1 >= tempJuice1.size() && index1 != index2) {
	            	graph[index1][index2] = 1;
	            } else {
	                graph[index1][index2] = 0;
	            }
	        }
	    int answer = 0;
	    result = new int [juices.size()];
	    usedJuices = new boolean [juices.size()];
	    for (int i = 0; i < juices.size(); ++i) {
	        result[i] = -1;
	    }
	    for (int i = 0; i < juices.size(); ++i) {
	        for (int j = 0; j < juices.size(); ++j)
	            usedJuices[j] = true;       
	        if (getPair(i) == true) 
	            ++answer;
	    }
	    return juices.size() - answer;
	}
    private boolean getPair(int currJuice) {
        if (!usedJuices[currJuice]) {
            return false;
        }
        usedJuices[currJuice] = false;
        for (int index = 0; index < juices.size(); ++index) {
            if (graph[currJuice][index] == 0) {
                continue;
            }
            if (result[index] == -1 || getPair(result[index])) {
                result[index] = currJuice;
                return true;
            }
        }
        return false;
    }
}
