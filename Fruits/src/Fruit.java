
public class Fruit implements Comparable<Fruit>{
	private String fruitName;
	
	public String getFruitName() {
		return fruitName;
	}
	public Fruit(String fruitName){
		this.fruitName = fruitName;
	}
	public String toString(){
		return "[ " + this.getClass() + " - " + fruitName + " ]";
	}
	public boolean equals(Object other){
		if(this == other ) return true;
		if(other == null || this.getClass() != other.getClass()) return false;
		Fruit otherFruit = (Fruit)other;
		if(this.compareTo(otherFruit) == 0 )
			return true;
		return false;
	}
	@Override
	public int compareTo(Fruit arg0) {
		// TODO Auto-generated method stub
		return fruitName.compareTo(arg0.getFruitName());
	}
}
