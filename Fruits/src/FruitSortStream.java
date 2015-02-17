import java.util.ArrayList;
import java.util.Collections;


public class FruitSortStream  extends Thread{
	private ArrayList<Fruit> fruits = new ArrayList<Fruit>();

    public FruitSortStream(ArrayList<Fruit> allFruits){
        fruits = allFruits;
        start();
    }
    public ArrayList<Fruit> getFruits(){
    	try{
    		this.join();
    	}catch(InterruptedException e){
    		e.printStackTrace();
    	}
        return fruits;
    }
    public void run(){ 
    	Collections.sort(fruits , new FruitComparator());
    }
}
