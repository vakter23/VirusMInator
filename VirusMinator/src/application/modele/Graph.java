package application.modele;

import java.io.*;
import java.util.*;

public class Graph {

	private static ArrayList<Sommet> sommet;
	private static ArrayList<Sommet> sommetDansLordre;

	public Graph() {
		this.sommetDansLordre = new ArrayList<Sommet>();
		this.sommet = new ArrayList<Sommet>();
	}

	public static ArrayList<Sommet> getSommet() {
		return sommet;
	}

	public void addEdge() {
		for (int i = 0; i < Environnement.getTerrainInt().length; i++) {
			for (int j = 0; j < Environnement.getTerrainInt()[i].length; j++) {
				if (Environnement.estUnChemin(i, j)) {
					sommet.add(new Sommet(i, j));

				}
			}
		}

	}

	public void ajouterAdj(Sommet s) {

		for (int i = 0; i < sommet.size(); i++) {

			if (sommet.get(i).getX() == s.getX() - 1 && sommet.get(i).getY() == s.getY()) {
				s.getAdj().add(sommet.get(i));

			} else if (sommet.get(i).getX() == s.getX() && sommet.get(i).getY() == s.getY() - 1) {
				s.getAdj().add(sommet.get(i));

			} else if (sommet.get(i).getX() == s.getX() && sommet.get(i).getY() == s.getY() + 1) {
				s.getAdj().add(sommet.get(i));

			} else if (sommet.get(i).getX() == s.getX() + 1 && sommet.get(i).getY() == s.getY()) {
				s.getAdj().add(sommet.get(i));

			}
		}
	}

	public static ArrayList<Sommet> getSommetDansLordre() {
		Collections.reverse(sommetDansLordre);
		return sommetDansLordre;
	}

	public void BFS(Sommet s) {

		LinkedList<Sommet> queue = new LinkedList<Sommet>();

		s.setVisited(true);
		queue.add(s);
		this.ajouterAdj(s);
		int y = 0;
		while (queue.size() != 0) {

			s = queue.poll();

			this.sommetDansLordre.add(s);
			System.out.print("[" + this.sommetDansLordre.get(y) + "] ");
			y++;

			ArrayList<Sommet> i = s.getAdj();
			for (Sommet n : i) {

				this.ajouterAdj(n);
				if (!n.getVisited()) {

					n.setVisited(true);
					n.setParent(s);
					queue.add(n);

				}

			}

		}

	}

}
