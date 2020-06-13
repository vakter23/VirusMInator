package application.controleur;

import application.modele.tir.Tir;
import application.modele.tir.TirAvecDegats;
import javafx.collections.ListChangeListener;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class MonObservateurTirs implements ListChangeListener<Tir> {

	private Pane pane;

	public MonObservateurTirs(Pane pane) {
		super();
		this.pane = pane;
	}

	@Override
	public void onChanged(Change<? extends Tir> c) {
		while (c.next()) {
			for (Tir t : c.getAddedSubList()) {
				creerSpriteTir(t);
			}
			for (Tir t : c.getRemoved()) {
				supprimerSpriteTir(t);
			}

		}
	}

	/**
	 * Cette méthode crée les sprite de chaque tirs lorsqu'ils sont ajoutés à la
	 * liste "listeTirs"
	 */
	private void creerSpriteTir(Tir t) {
		if (t instanceof TirAvecDegats) {
			Circle r = new Circle(3);
			r.setFill(Color.RED);
			r.setId(t.getId());
			r.setTranslateX(t.getX());
			r.setTranslateY(t.getY());
			r.translateXProperty().bind(t.getXProperty());
			r.translateYProperty().bind(t.getYProperty());
			pane.getChildren().add(r);
		} else {
			Circle r = new Circle(3);
			r.setFill(Color.BLUE);
			r.setId(t.getId());
			r.setTranslateX(t.getX());
			r.setTranslateY(t.getY());
			r.translateXProperty().bind(t.getXProperty());
			r.translateYProperty().bind(t.getYProperty());
			pane.getChildren().add(r);
		}
	}

	/**
	 * Cette méthode appelle "supprimerSpriteTir" pour les tirs morts et appelle
	 * "creerSpriteTir"
	 */
	private void supprimerSpriteTir(Tir t) {
		this.pane.getChildren().remove(this.pane.lookup("#" + t.getId()));
	}

}
