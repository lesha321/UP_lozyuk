import java.util.Comparator;


public class FruitComparator  implements Comparator<Fruit>{
	
	@Override
	public int compare(Fruit arg0, Fruit arg1) {
		return arg0.getFruitName().compareTo(arg1.getFruitName());
	}

}
