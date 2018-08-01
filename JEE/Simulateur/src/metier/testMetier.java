package metier;

public class testMetier {

	public static void main(String[] args) {
		CreditMetier test = new CreditMetier();
		double m = test.calculMensualite(200000, 240, 4.5);
		System.out.println(m);
		

	}

}
