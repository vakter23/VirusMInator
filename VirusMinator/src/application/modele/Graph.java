package application.modele;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class Graph {

	/*
	 * création de la liste de sommet de notre graphe
	 */
	private static ArrayList<Sommet> sommet;

	/*
	 * création de la liste de sommet dans l'ordre de notre parcours
	 */
	private static ArrayList<Sommet> sommetDansLordre;

	/*
	 * constructeur du graphe
	 */

	public Graph() {
		sommetDansLordre = new ArrayList<Sommet>();
		sommet = new ArrayList<Sommet>();
	}

	/**
	 * accesseur de la liste sommet
	 * 
	 * @return la liste sommet
	 */
	public static ArrayList<Sommet> getSommet() {
		return sommet;
	}

	/*
	 * méthode permettant d'ajouter tous les Sommets de notre graphe les sommet sont
	 * les 0 de notre matrice de terrain
	 */
	public void addEdge() {
		for (int i = 0; i < Environnement.getTerrainInt().length; i++) {
			for (int j = 0; j < Environnement.getTerrainInt()[i].length; j++) {
				if (Environnement.estUnChemin(i, j)) {
					sommet.add(new Sommet(i, j));

				}
			}
		}

	}

	/**
	 * méthode ajouter les sommets voisin du Sommet en paramètre
	 */
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
		return sommetDansLordre;
	}

	/**
	 * méthode Breadth-first iterator permet faire un parcours en largeur du graphe
	 * Ã  partir du sommet en paramètre
	 */

	public void BFS(Sommet s) {

		LinkedList<Sommet> queue = new LinkedList<Sommet>();

		s.setVisited(true);
		queue.add(s);
		this.ajouterAdj(s);
		while (queue.size() != 0) {

			s = queue.poll();

			sommetDansLordre.add(s);

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
		Collections.reverse(sommetDansLordre);
	}

}
