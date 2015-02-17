import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;


public class Juice implements Comparable<Juice>{
	
	private   ArrayList<Fruit> components = new ArrayList<Fruit>();
	
	public ArrayList<Fruit> getComponents() {
		return (ArrayList<Fruit>)components.clone();
	}
	public Juice(ArrayList<Fruit> info){
		for (Fruit fruit : info) {
			components.add(fruit);
		}
		components = new FruitSortStream(components).getFruits();
	}
	public Juice(Fruit ... info){
		for (Fruit fruit : info) {
			components.add(fruit);
		}
		components = new FruitSortStream(components).getFruits();
	}
	public boolean isSubJuice(Juice other){
		return other.getComponents().containsAll(components);
	}
	public int compareTo(Juice o) {
		ArrayList<Fruit> comp = o.getComponents();
		if (components.containsAll(o.getComponents()) && comp.containsAll(components))
			return 0;
		else {
			if(components.size() != comp.size())
				return components.size() - comp.size();
			else {			
				FruitComparator comparator = new FruitComparator();
				for (int i = 0 ; i < components.size() ; i ++) {
				int result = comparator.compare(components.get(i), comp.get(i));
				if(result != 0) return result;
              }
              return 0;
			}
		}
	}
	public String toString(){
		StringBuilder builder = new StringBuilder();
		builder.append(this.getClass());
		builder.append(" . Cocòàâ : ( ");
		for (Fruit fruit : components) {
			builder.append(fruit);
			builder.append(" ");
		}
		builder.append(")");
		return builder.toString();
	}
}
