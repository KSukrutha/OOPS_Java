package hdbms;

public class Patient {
	private String id;
	private String name;
	private int age;
	private int totBill;
	private static int count=100;

	public Patient( String name,int age,int totBill) {
		this .id="KIMS"+count;
		count++;
		this.name = name;
		this.age=age;
		this.totBill = totBill;
	}
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name=name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int Age) {
		this.age=age;
	}
	public int getTotBill() {
		return totBill;
	}
	public void setTotBill(int totbill) {
		this.totBill=totbill;
	}
	@Override
	public String toString() {
		return "id=" + id + ", name=" + name + ", age" + age +", totBill=" + totBill ;
	} 
}
