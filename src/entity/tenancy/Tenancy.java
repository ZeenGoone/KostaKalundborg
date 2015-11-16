package entity.tenancy;

public abstract class Tenancy {
	protected int id;
	
	public Tenancy(int id) {this.id = id;}
	public int getId() {return id;}
}
