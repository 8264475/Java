package encap;

public class TestCar {

	public static void main(String[] args) {
		Car c = new Car("Prius", "藍色");
		//c.setColor("藍色");
		//c.model = "Prius";
		//c.setModel("Prius");
		//c.price = 1099000;
		System.out.printf("售出:%s,%d元,顏色:%s%n",
				c.getModel(),c.getPrice(),c.getColor());
	}

}
