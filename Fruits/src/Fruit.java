
public class Fruit {
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
		if(this.fruitName.compareTo(otherFruit.getFruitName()) == 0 )
			return true;
		return false;
	}
}
