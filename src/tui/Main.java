package tui;

//@author: Ali Barakji, Jeppe B. Sørensen, Kasper Mikkelsen, Magnus Tomra Engberg, Matias Holm Nielsen, Oscar Seistrup Hermann
//@date: 31/5/2024
//@description: This class contains our Main method. Needed to start 
//the program, also ensuring the testdata is always run.
public class Main {

	public static void main(String[] args) {
		TryMe.addData();
		OrderMenu om = new OrderMenu();
		om.start();

	}

}
