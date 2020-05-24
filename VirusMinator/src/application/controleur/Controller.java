package application.controleur;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import application.Config;
import application.modele.Action;
import application.modele.Environnement;
import application.modele.Timer;

public class Controller implements Initializable {

	@FXML
	private Button seDeplace;

	@FXML
	private Button Reinit;

	@FXML
	private Button placerEnnemis;

	@FXML
	private HBox shopTFT;

	@FXML
	private VBox teteVilain;

	@FXML
	private HBox shopSavon;

	@FXML
	private HBox shopGelHydro;

	@FXML
	private HBox shopSlow;

	@FXML
	private HBox shopMask;

	@FXML
	private HBox shopPingoLimbo;

	@FXML
	private VBox teteHero;

	@FXML
	private TilePane map;


	@FXML
	private Pane panneauEnnemis;
	private Environnement e1;

	private Image tourelleGel = (Image) (getImgg("/src/ressources/tourelles/gelHydro.png"));
    @FXML
    private ImageView gelHydro;



	public void creerTerrainVue() {
		System.out.println(Config.listeMap.size());
		gelHydro.setImage(tourelleGel);
		/*
		 * ImageView shopSavonSolid =
		 * Config.getImg("/src/ressources/tourelles/solidSavon.png");
		 * shopSavon.getChildren().add(shopSavonSolid); ImageView shopHydroGel =
		 * Config.getImg("/src/ressources/tourelles/gelHydro.png");
		 */

		for (int i = 0; i < Config.listeMap.size(); i++) {
			ImageView blancHopital = Config.getImg("/src/ressources/tiles/blancHopital");
			ImageView herbe = Config.getImg("/src/ressources/tiles/herbe.png");
			ImageView BordTerrain = Config.getImg("/src/ressources/tiles/BordTerrain.png");
			ImageView hitBoxHosto = Config.getImg("/src/ressources/tiles/hitBoxHosto.png");
			ImageView rougeHopital = Config.getImg("/src/ressources/tiles/rougeHopital.png");
			ImageView sableChemin = Config.getImg("/src/ressources/tiles/sableChemin.png");
			ImageView sableTerrain = Config.getImg("/src/ressources/tiles/sableTerrain.png");
			ImageView spawnMob = Config.getImg("/src/ressources/tiles/spawnMob.png");
			ImageView spawnTourelles = Config.getImg("/src/ressources/tiles/spawnTourelles.png");
			ImageView vertEnnemi = Config.getImg("/src/ressources/tiles/vertEnnemi.png");
			ImageView violetEnnemi = Config.getImg("/src/ressources/tiles/violetEnnemi.png");
			String retour = Config.imageDe(Config.listeMap.get(i));
			switch (retour) {
			case "blancHopital":
				map.getChildren().add(blancHopital);
				break;
			case "herbe":
				map.getChildren().add(herbe);
				break;
			case "BordTerrain":
				map.getChildren().add(BordTerrain);
				break;
			case "hitBoxHosto":
				map.getChildren().add(hitBoxHosto);
				break;
			case "rougeHopital":
				map.getChildren().add(rougeHopital);
				break;
			case "sableChemin":
				map.getChildren().add(sableChemin);
				break;
			case "sable":
				map.getChildren().add(sableTerrain);
				break;
			case "spawnMob":
				map.getChildren().add(spawnMob);
				break;
			case "spawnTourelles":
				map.getChildren().add(spawnTourelles);
				System.out.println(spawnTourelles);
				spawnTourelles.setOnMouseClicked(e -> gelHydro.setOnMouseClicked(ee->clicTourelle(e)));
				break;
			case "vertEnnemi":
				map.getChildren().add(vertEnnemi);
				break;
			case "violetEnnemi":
				map.getChildren().add(violetEnnemi);
				break;
			}

		}
		/*
		 * teteHero.getChildren().add(Config.getImg("/src/ressources/tete.png"));
		 * teteVilain.getChildren().add(Config.getImg("/src/ressources/tete.png"));
		 */

	}

//	void seDeplace (ActionEvent event) {
//		e1.
//	}
	/*
	 * @FXML void creerSprite(ActionEvent event) { Circle r = new Circle(10);
	 * r.setFill(Color.RED); r.setTranslateX(10); r.setTranslateY(10);
	 * panneauEnnemis.getChildren().add(r); }
	 */
	@FXML
	void seDeplacer() {
		for (int i = 0; i < getPanneauEnnemis().getChildren().size(); i++) {
			getPanneauEnnemis().getChildren().get(i).setTranslateX(Math.random() * 900);
			getPanneauEnnemis().getChildren().get(i).setTranslateY(Math.random() * 900);

		}
	}

	@FXML
	void reinit(ActionEvent event) {
		getPanneauEnnemis().getChildren().clear();

	}


    @FXML
    void supprimer(ActionEvent event) {
		for (int i = 0; i < map.getChildren().size(); i++) {
			ImageView spawnTourelles = Config.getImg("/src/ressources/tiles/spawnTourelles.png");
			String retour = Config.imageDe(Config.listeMap.get(i));
			if(map.getChildren().contains(tourelleGel)) {
				map.getChildren().remove(i);
			}
		}
//    	for (int i = 0; i < e1.getTourelles().size(); i++) {
//			
//		}
//    	for (int i = 0; i < panneauEnnemis.getChildren().size(); i++) {
//			if(panneauEnnemis.getChildren().get(i).contains(tourelleGel)) {
//				
//			}
//		}
    }
	public void dessinEnnemi() {
		ImageView Virus = Config.getImg("/src/ressources/Virus/base_Virus.png");
		Virus.setTranslateX(720);
		Virus.setTranslateY(720);
		getPanneauEnnemis().getChildren().add(Virus);
	}

	void clicTourelle(MouseEvent event) {

		System.out.println("TOurelle Cliqué");// Coder Placement Tourelle

		ImageView sourc = (ImageView) event.getSource();
		Image tourelleGel = (Image) (getImgg("/src/ressources/tourelles/gelHydro.png"));
		
		sourc.setImage(tourelleGel);

	}

	private static Image getImgg(String... paths) {
		return new Image(Paths.get(System.getProperty("user.dir"), paths).toUri().toString());
		// ImageView(Paths.get(Paths.get(System.getProperty("user.dir"),
		// "ressources").toString(), paths).toUri().toString());
	}

	@FXML
	void placerEnnemis(ActionEvent event) {
		System.out.println("lancement");
		dessinEnnemi();
	}
//	void placerEnnemis(ActionEvent event) {
//		Circle r = new Circle(3);
//		r.setFill(Color.RED);
//		r.setId("rond");
//		r.setTranslateX(0);
//		r.setTranslateY(0);
//		r.setOnMouseClicked(e-> System.out.println("clic sur acteur"+e.getSource()));
//		map.getChildren().add(r);
//	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		/*
		 * Appeler lvl1 qui appelera la methode de création de map, et après utiliser un
		 * switch pour afficher Victoire ou défaite, et niveau suivant.
		 */
		creerTerrainVue();
		dessinEnnemi();
		System.out.println("fait");

	}

	void faireDesTours() {
		while (!Reinit.isPressed()) {
			seDeplacer();
		}

	}

	public String lvl1() {
		return null;
		/*
		 * faire retourner "Victoire" si on survit, "Defaite" sinon. Faire pareil pour
		 * tout les niveaux
		 */
	}

	public Pane getPanneauEnnemis() {
		return panneauEnnemis;
	}

	public void setPanneauEnnemis(Pane panneauEnnemis) {
		this.panneauEnnemis = panneauEnnemis;
	}
}