import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;


public class Juicer {
	private  int numberOfCleanings = 0 ;
	private  ArrayList<Fruit> centrifuge = new ArrayList<Fruit>();
	private  ArrayList<Juice> order = new ArrayList<Juice>();
	public   void putFruits(Fruit ... var){
		Collections.addAll(centrifuge, var);
	}
	public void putFruits(ArrayList<Fruit> var){
		Collections.copy(centrifuge, var);
	}
	public void clearCentrifuge(){
		centrifuge.clear();
		numberOfCleanings++;
	}
	public Juice makeJuice(){
		return new Juice(centrifuge);
	}
	public int numberOfCleanings(){
		return numberOfCleanings;
	}
	public void restart(){
		numberOfCleanings = 0 ; 
		clearCentrifuge();
	}
	public  void optimalWork(ArrayList<Juice> juiceList){
		while(!juiceList.isEmpty()){
			Juice currJuice = juiceList.get(0);
			for( int j = 1 ; j < juiceList.size() ; ){
				Juice tmp = juiceList.get(j);
				if(currJuice.isSubJuice(tmp)){
					juiceList.remove(currJuice);
					currJuice = tmp;
				}
				else
					j++;
			}
			juiceList.remove(currJuice);
			numberOfCleanings++;
		}
	}
	public int getNumberOfCleanings() {
		return numberOfCleanings;
	}
	
}

