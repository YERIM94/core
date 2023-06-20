package hello.core.singleton;

public class StatefulService {
	private int price; //상태를 유지하는 필드

	public void order(String name, int price) {
		System.out.println("name = " + name);
		System.out.println("price = " + price);
		this.price = price; // 문제지점
	}

	public int getPrice() {
		return price;
	}
}
