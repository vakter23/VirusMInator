package application.controleur;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import application.Config;
import application.modele.Environnement;
import application.modele.tourelles.TourelleMousseuse;
import application.modele.tourelles.TourelleSavonneuse;
import application.modele.tourelles.Tourelles;
import application.modele.virus.Virus;
import application.modele.virus.VirusBasirus;
import application.modele.virus.VirusDivirus;
import application.modele.virus.VirusVhealrus;
import application.modele.virus.VirusViboomrus;
import application.modele.virus.VirusViterus;

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
    private Label labelArgent;

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
	@FXML
	private Button bouttonVendre;
	@FXML
	private ImageView savonneuse;
	@FXML
	private ImageView avastirus;
	@FXML
	private ImageView siliteBang;
	@FXML
	private ImageView drPingoLimbo;
	@FXML
	private ImageView gelHydroClaque;

	@FXML
	private Button restart;

	private Environnement e1;

	private static Timeline gameLoop;

	public static int temps;

	private Image tourelleGel = (Image) (getImgg("/src/ressources/tourelles/gelHydro.png"));
	@FXML
	private ImageView gelHydro;

	public void creerTerrainVue() {
		System.out.println(Config.listeMap.size());
		gelHydro.setImage(tourelleGel);


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
				spawnTourelles.setOnMouseClicked(e -> gelHydro.setOnMouseClicked(ee -> clicTourelle(e)));

				break;
			case "vertEnnemi":
				map.getChildren().add(vertEnnemi);
				break;
			case "violetEnnemi":
				map.getChildren().add(violetEnnemi);
				break;
			}

		}


	}



	public void ajouter() {
		this.e1.initVirus();
	}

	/*
	 * void supprimer(ActionEvent event) { for (int i = 0; i <
	 * map.getChildren().size(); i++) { ImageView spawnTourelles =
	 * Config.getImg("/src/ressources/tiles/spawnTourelles.png"); String retour =
	 * Config.imageDe(Config.listeMap.get(i)); if
	 * (map.getChildren().contains(tourelleGel)) { map.getChildren().remove(i); } }
	 * // for (int i = 0; i < e1.getTourelles().size(); i++) { // // } // for (int i
	 * = 0; i < panneauEnnemis.getChildren().size(); i++) { //
	 * if(panneauEnnemis.getChildren().get(i).contains(tourelleGel)) { // // } // }
	 * }
	 * 
	 * //>>>>>>> branch 'develop' of https:github.com/vakter23/VirusMInator.git
	 * /*public void dessinEnnemi() { ImageView Virus =
	 * Config.getImg("/src/ressources/Virus/base_Virus.png");
	 * Virus.setTranslateX(720); Virus.setTranslateY(720);
	 * getPanneauEnnemis().getChildren().add(Virus); }
	 */
	void clicTourelle(MouseEvent event) {
//		ImageView sourc = (ImageView) event.getSource();
//		Image spawnTourellesR = getImgg("/src/ressources/tiles/spawnTourelleRouge.png");
//		sourc.setImage(spawnTourellesR);
		event.getTarget();
		Node test = (Node) event.getSource();
		System.out.println("x=" + test.getLayoutX() + "y = " + test.getLayoutY());
//		System.out.println("clic tourelle" + event.getSceneX()() + event.getSceneY() + event.getSource().);
		if (verifiePlaceLibre(test.getLayoutX(), test.getLayoutY()) == true) {
			savonneuse.setOnMouseClicked((e) -> {
				if (verifiePlaceLibre(test.getLayoutX(), test.getLayoutY()) == true) {
					Tourelles t1 = new TourelleSavonneuse(50, 64, 0,"TourelleSavonneuse", (int) test.getLayoutX(),
							(int) test.getLayoutY(), e1);
					System.out.println(t1);
					this.e1.ajouterTourelles(t1);
				}
			});
			avastirus.setOnMouseClicked((e) -> {
				if (verifiePlaceLibre(test.getLayoutX(), test.getLayoutY()) == true) {

					this.e1.ajouterTourelles(
							new TourelleMousseuse(0, 0, "", (int) test.getLayoutX(), (int) test.getLayoutY(), e1));
				}
			});
			gelHydroClaque.setOnMouseClicked((e) -> {
				if (verifiePlaceLibre(test.getLayoutX(), test.getLayoutY()) == true) {

					this.e1.ajouterTourelles(
							new TourelleHydroClaque(0, 0, "", (int) test.getLayoutX(), (int) test.getLayoutY(), e1));
				}
			});
			siliteBang.setOnMouseClicked((e) -> {
				if (verifiePlaceLibre(test.getLayoutX(), test.getLayoutY()) == true) {

					this.e1.ajouterTourelles(
							new TourelleSilliteBang( 0, 0, "", (int) test.getLayoutX(), (int) test.getLayoutY(), e1));
				}
			});
			drPingoLimbo.setOnMouseClicked((e) -> {
				if (verifiePlaceLibre(test.getLayoutX(), test.getLayoutY()) == true) {

					this.e1.ajouterTourelles(new TourelleDocteurPingoLimbo(0, 0, "", (int) test.getLayoutX(),
							(int) test.getLayoutY(), e1));
				}
			});
		} else {
			System.out.println("taille avant boucle" + e1.getTourelles().size());
			System.out.println("l id de la tuile " + test.getId());
			bouttonVendre.setOnMouseClicked((e) -> {
				for (int i = 0; i < this.e1.getTourelles().size(); i++) {
					if (this.e1.getTourelles().get(i).getX() == test.getLayoutX()
							&& this.e1.getTourelles().get(i).getY() == test.getLayoutY()) {
						this.e1.getTourelles().remove(e1.getTourelles().get(i));
						System.out.println("xx=" + e1.getTourelles().get(0).getX());
						System.out.println("yy=" + e1.getTourelles().get(0).getY());
						System.out.println("taille apres boucle" + e1.getTourelles().size());


					}
				}
			});
		}
	}
	public boolean verifiePlaceLibre(double d, double e) {
		for (int i = 0; i < this.e1.getTourelles().size(); i++) {
			if (this.e1.getTourelles().get(i).getX() == d && this.e1.getTourelles().get(i).getY() == e) {
				return false;
			}
		}
		return true;
	}


	private static Image getImgg(String... paths) {
		return new Image(Paths.get(System.getProperty("user.dir"), paths).toUri().toString());
		// ImageView(Paths.get(Paths.get(System.getProperty("user.dir"),
		// "ressources").toString(), paths).toUri().toString());
	}


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
		this.e1 = new Environnement(1600, 800);
		this.panneauEnnemis.setMaxWidth(1632);
		this.panneauEnnemis.setMaxHeight(832);
		this.e1.getViruses().addListener(new MonObservateurViruses(panneauEnnemis));
		creerTerrainVue();
		System.out.println(this.e1.getViruses().size());
		ajouter();
		System.out.println("Viruses initialisés");
		initAnimation();
		this.labelArgent.textProperty().bind(this.e1.getArgentProperty().asString());


	}

	private void initAnimation() {
		setGameLoop(new Timeline());
		temps = 0;
		getGameLoop().setCycleCount(Timeline.INDEFINITE);
		KeyFrame kf = new KeyFrame(
				// on définit le FPS (nbre de frame par seconde)
				Duration.seconds(0.0025),

				// on définit ce qui se passe à chaque frame
				// c'est un eventHandler d'ou le lambda
				(ev -> {
					if (temps == 8000) {
						System.out.println("fini");
						getGameLoop().stop();
					} else if (temps % 20 == 0) {
						System.out.println("tour" + temps);
						unTour();
					}
					else {
						//this.e1.unTourTir();
					}
					if (temps % 800 == 0) {
						this.e1.incrementerArgent();
					}
					if (this.e1.getViruses().isEmpty() && temps > 400) {
						gameLoop.stop();
						System.out.println("V.I.C.T.O.I.R.E");
					}
						

					temps++;
				}));
		getGameLoop().getKeyFrames().add(kf);

//		
	}

	void unTour() {
		this.e1.unTour();

	}

	@FXML
	void reinit(ActionEvent event) {
		getGameLoop().stop();
		System.out.println(this.e1.getViruses().size());
		//for (Virus v : this.e1.getViruses()) {
			//this.e1.getViruses().clear();
			//}
//		for (int j = 0; j < this.e1.getTourelles().size(); j++) {
//			this.e1.getTourelles().remove(j);
//		}
		for (int i = 0; i < this.e1.getViruses().size(); i++) {
			System.out.println(this.e1.getViruses().get(i).getId());
		}
	
		this.temps = 0;
		System.out.println(this.e1.getViruses().size());

	}

	@FXML
	void Start(ActionEvent event) {
		
		initAnimation();
		getGameLoop().play();
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

	public static Timeline getGameLoop() {
		return gameLoop;
	}

	public void setGameLoop(Timeline gameLoop) {
		this.gameLoop = gameLoop;
	}
}
