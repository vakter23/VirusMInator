package application.controleur;

import application.modele.tir.Tir;
import application.modele.tourelles.Tourelles;
import javafx.collections.ListChangeListener;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class MonObservateurTirs implements ListChangeListener<Tir>{

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

	private void creerSpriteTir(Tir t) {
		Circle r = new Circle(3);
		r.setFill(Color.RED);
		r.setTranslateX(t.getX());
		r.setTranslateY(t.getY());
		pane.getChildren().add(r);
	}

	private void supprimerSpriteTir(Tir t) {
		// TODO Auto-generated method stub
		
	}

}
