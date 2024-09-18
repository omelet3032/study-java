package animal;

public class Cat implements Animal {

	private String name;
	private String type;
	private String sex;
	private int age;
	private String status;

	public Cat(String name, String type, String sex, int age, String status) {
		this.name = name;
		this.type = type;
		this.sex = sex;
		this.age = age;
		this.status = status;
	}

	@Override
	public void play() {
		System.out.println("그르릉");
	}

	@Override
	public void sound() {
		System.out.println("야옹");
	}

	@Override
	public int getAge() {
		return this.age;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public String getSex() {
		return this.sex;
	}

	@Override
	public String getStatus() {
		return this.status;
	}

	@Override
	public String getType() {
		return this.type;
	}

}
