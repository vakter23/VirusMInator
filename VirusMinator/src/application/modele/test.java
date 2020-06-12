package application.modele;

import java.util.ArrayList;
import java.util.Collections;

public class test {

	public static void main(String[] args) {
		ArrayList<Integer> listeDeInt = new ArrayList<Integer>();
		listeDeInt.add(1);
		listeDeInt.add(2);
		Collections.reverse(listeDeInt);
		System.out.println(listeDeInt);

	}

}
