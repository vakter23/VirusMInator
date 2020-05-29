package application.controleur;

import java.nio.file.Paths;

import application.modele.tourelles.TourelleDocteurPingoLimbo;
import application.modele.tourelles.TourelleHydroClaque;
import application.modele.tourelles.TourelleMousseuse;
import application.modele.tourelles.TourelleSavonneuse;
import application.modele.tourelles.TourelleSilliteBang;
import application.modele.tourelles.Tourelles;
import javafx.collections.ListChangeListener;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class ecouteurTourelle implements ListChangeListener<Tourelles> {

	private Pane panneauEnnemi;
	private ImageView savonneuse;
	private ImageView avastirus;
	private ImageView siliteBang;
	private ImageView drPingoLimbo;
	private ImageView gelHydroClaque;

	public ecouteurTourelle(Pane pane) {
		super();
		this.panneauEnnemi = pane;
	}

	@Override
	public void onChanged(Change<? extends Tourelles> c) {

		while (c.next()) {
			for (Tourelles nouvelle : c.getAddedSubList()) {
				creerSpriteTourelle(nouvelle);
			}
			for (Tourelles nouvelle : c.getRemoved()) {
				supprimerSpriteTourelle(nouvelle);
			}
			
		}
	}

	private void creerSpriteTourelle(Tourelles t) {
//			ImageView sourc = (ImageView) event.getSource();
//			ImageView spawnTourellesR = getImgg("/src/ressources/tiles/spawnTourelleRouge.png");
//			sourc.setImage(spawnTourellesR);
			if(t instanceof TourelleSavonneuse){
				ImageView tourelle =  getImgg("/src/ressources/tourelles/gelHydro.png");
				tourelle.setLayoutX(t.getX());
				tourelle.setLayoutY(t.getY());
				panneauEnnemi.getChildren().add(tourelle);
//				panneauEnnemi.getChildren().add(tourelle.getHeight()*tourelle.getWidth(), tourelle);
			}
			else if (t instanceof TourelleMousseuse){
				ImageView tourelle = getImgg("/src/ressources/tourelles/Avast.png");
				tourelle.setLayoutX(t.getX());
				tourelle.setLayoutY(t.getY());
				panneauEnnemi.getChildren().add(tourelle);
			}
			else if (t instanceof TourelleHydroClaque){
				ImageView tourelle = getImgg("/src/ressources/tourelles/gel-hydoralcoolique.png");
				tourelle.setLayoutX(t.getX());
				tourelle.setLayoutY(t.getY());
				panneauEnnemi.getChildren().add(tourelle);

			}
			else if (t instanceof TourelleSilliteBang){
				ImageView tourelle = getImgg("/src/ressources/tourelles/javel.png");
				tourelle.setLayoutX(t.getX());
				tourelle.setLayoutY(t.getY());
				panneauEnnemi.getChildren().add(tourelle);

			}
			else if (t instanceof TourelleDocteurPingoLimbo){
				ImageView tourelle = getImgg("/src/ressources/tourelles/drPingoLimbo.png");
				tourelle.setLayoutX(t.getX());
				tourelle.setLayoutY(t.getY());
				panneauEnnemi.getChildren().add(tourelle);
			}
		

	}

	private void supprimerSpriteTourelle(Tourelles t) {
		panneauEnnemi.getChildren().remove(t);
	}

	public int recupererX(MouseEvent e) {
		return (int) e.getSceneX();
	}

	public int recupererY(MouseEvent e) {
		return (int) e.getSceneY();
	}

//	public void clicTourelle(MouseEvent event) {
//		if (event.getClickCount() == 2) {
//			ImageView sourc = (ImageView) event.getSource();
//			Image spawnTourellesR = getImgg("/src/ressources/tiles/spawnTourelleRouge.png");
//			sourc.setImage(spawnTourellesR);
//			savonneuse.setOnMouseClicked((e) -> {
////			this.e1.ajouterTourelles(new TourelleSavonneuse(0, 0, 0, 0, "0", event.getX(), event.getY()));
//				Image tourelle = (Image) (getImgg("/src/ressources/tourelles/gelHydro.png"));
//				sourc.setImage(tourelle);
//			});
//			avastirus.setOnMouseClicked((e) -> {
//				Image tourelle = (Image) (getImgg("/src/ressources/tourelles/Avast.png"));
//				sourc.setImage(tourelle);
//			});
//			gelHydroClaque.setOnMouseClicked((e) -> {
//				Image tourelle = (Image) (getImgg("/src/ressources/tourelles/gel-hydoralcoolique.png"));
//				sourc.setImage(tourelle);
//			});
//			siliteBang.setOnMouseClicked((e) -> {
//				Image tourelle = (Image) (getImgg("/src/ressources/tourelles/javel.png"));
//				sourc.setImage(tourelle);
//			});
//			drPingoLimbo.setOnMouseClicked((e) -> {
//				Image tourelle = (Image) (getImgg("/src/ressources/tourelles/drPingoLimbo.png"));
//				sourc.setImage(tourelle);
//			});
//
//		}
//		else {
//			System.out.println("clic");
//		}
//	}

	private static ImageView getImgg(String... paths) {
		return new ImageView(Paths.get(System.getProperty("user.dir"), paths).toUri().toString());
		// ImageView(Paths.get(Paths.get(System.getProperty("user.dir"),
		// "ressources").toString(), paths).toUri().toString());
	}

}
