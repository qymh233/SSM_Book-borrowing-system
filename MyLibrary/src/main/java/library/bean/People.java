package library.bean;

public class People {
	
	private String name;
	private Car car;
	public People() {
		System.out.println("people 被创建");
	}
	public People(String name, Car car) {
		super();
		this.name = name;
		this.car = car;
		System.out.println("people 被创建");
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}
	@Override
	public String toString() {
		return "People [name=" + name + ", car=" + car + "]";
	}
}
