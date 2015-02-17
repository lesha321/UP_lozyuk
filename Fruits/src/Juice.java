import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;


public class Juice implements Comparable<Juice>{
	
	public ArrayList<Fruit> getComponents() {
		return (ArrayList<Fruit>)components.clone();
	}
	private   ArrayList<Fruit> components = new ArrayList<Fruit>();
	public Juice(ArrayList<Fruit> info){
		for (Fruit fruit : info) {
			components.add(fruit);
		}
		Collections.sort(components);
	}
	public Juice(Fruit ... info){
		for (Fruit fruit : info) {
			components.add(fruit);
		}
		Collections.sort(components);
	}
	public String toString(){
		StringBuilder builder = new StringBuilder();
		builder.append(this.getClass());
		builder.append(" . CocÚ‡‚ : ( ");
		for (Fruit fruit : components) {
			builder.append(fruit);
			builder.append(" ");
		}
		builder.append(")");
		return builder.toString();
	}
	public boolean isSubJuice(Juice other){
		return other.getComponents().containsAll(components);
	}
	public int compareTo(Juice o) {
		ArrayList<Fruit> comp = o.getComponents();
		if (components.containsAll(o.getComponents()) && comp.containsAll(components))
			return 0;
		else 
			return components.size() - comp.size();
	}
}
