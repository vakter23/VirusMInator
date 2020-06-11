package application.controleur;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ResourceBundle;
import application.Config;
import application.modele.Environnement;
import application.modele.Graph;
import application.modele.Magasin;
import application.modele.tourelles.TourelleDocteurPingoLimbo;
import application.modele.tourelles.TourelleHydroClaque;
import application.modele.tourelles.TourelleMousseuse;
import application.modele.tourelles.TourelleSavonneuse;
import application.modele.tourelles.TourelleSilliteBang;
import application.modele.tourelles.Tourelles;
import application.modele.virus.MonObservateurViruses;
import application.modele.virus.Virus;

public class Controller implements Initializable {

	@FXML
	private Button seDeplace;

	@FXML
	private Button Reinit;

	@FXML
	private Button placerEnnemis;

	@FXML
	private Button Start;
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
	@FXML
	private Button restart;

	private Environnement e1;

	private static Timeline gameLoop;

	public static int temps;

	@FXML
	private Label labelArgent;

	@FXML
	private Button bouttonVendre;

	@FXML
	private ImageView savonneuse;

	@FXML
	private ImageView avastirus;

	@FXML
	private ImageView gelHydroClaque;

	@FXML
	private ImageView siliteBang;

	@FXML
	private ImageView drPingoLimbo;

	@FXML
	private ImageView gelHydro;

	private Magasin m1;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		this.e1 = new Environnement(1600, 800, new Magasin());
		this.panneauEnnemis.setMaxWidth(1632);
		this.panneauEnnemis.setMaxHeight(832);

		creerTerrainVue();
		System.out.println(this.e1.getViruses().size());
		Graph g = new Graph();
        g.addEdge();
        g.BFS(Graph.getSommet().get(20));
		ajouter();
		System.out.println("Viruses initialisés");
		initAnimation();
		this.labelArgent.textProperty().bind(this.m1.getArgentProperty().asString());
		this.e1.getViruses().addListener(new MonObservateurViruses(panneauEnnemis));
		this.e1.getTirs().addListener(new MonObservateurTirs(panneauEnnemis));
		this.e1.getTourelles().addListener(new ecouteurTourelle(panneauEnnemis));
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
					if (temps == 20000) {
						System.out.println("fini");
						getGameLoop().stop();
					}

				else if (temps % 10 == 0) {
						//System.out.println("tour" + temps);
						this.e1.unTour();
					}
					
						this.e1.unTourTir();
					

					if (temps % 800 == 0) {
						this.m1.incrementerArgent();
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

	

	public void creerTerrainVue() {
		System.out.println(Config.listeMap.size());
		savonneuse.setImage((Image) (getImgg("/src/ressources/magasin/gelHydro.png")));
		avastirus.setImage((Image) (getImgg("/src/ressources/magasin/Avast.png")));
		gelHydroClaque.setImage((Image) (getImgg("/src/ressources/magasin/gel-hydoralcoolique.png")));
		siliteBang.setImage((Image) (getImgg("/src/ressources/magasin/javel.png")));
		drPingoLimbo.setImage((Image) (getImgg("/src/ressources/magasin/drPingoLimbo.png")));

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
				spawnTourelles.setOnMouseClicked(e -> clicTourelle(e));
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

	void clicTourelle(MouseEvent event) {
//		ImageView sourc = (ImageView) event.getSource();
//		Image spawnTourellesR = getImgg("/src/ressources/tiles/spawnTourelleRouge.png");
//		sourc.setImage(spawnTourellesR);
		event.getTarget();
		Node tuile = (Node) event.getSource();
		System.out.println("x=" + tuile.getLayoutX() + "y = " + tuile.getLayoutY());
//		System.out.println("clic tourelle" + event.getSceneX()() + event.getSceneY() + event.getSource().);
		if (verifiePlaceLibre(tuile.getLayoutX(), tuile.getLayoutY()) == true) {
			savonneuse.setOnMouseClicked((e) -> {
				if (verifiePlaceLibre(tuile.getLayoutX(), tuile.getLayoutY()) && this.m1.getArgent() > 7) {
					Tourelles t1 = new TourelleSavonneuse(50, 100, "TourelleSavonneuse", (int) tuile.getLayoutX(),
							(int) tuile.getLayoutY(), e1);
					this.m1.enleverArgent(7);
					System.out.println(t1);
					this.e1.ajouterTourelles(t1);
				}
			});
			avastirus.setOnMouseClicked((e) -> {
				if (verifiePlaceLibre(tuile.getLayoutX(), tuile.getLayoutY()) == true && this.m1.getArgent() > 5) {
					this.m1.enleverArgent(5);
					this.e1.ajouterTourelles(
							new TourelleMousseuse(50, 100, "", (int) tuile.getLayoutX(), (int) tuile.getLayoutY(), e1));
				}
			});
			gelHydroClaque.setOnMouseClicked((e) -> {
				if (verifiePlaceLibre(tuile.getLayoutX(), tuile.getLayoutY()) == true && this.m1.getArgent() > 9) {
					this.m1.enleverArgent(9);
					this.e1.ajouterTourelles(new TourelleHydroClaque(75, 0.01, "", (int) tuile.getLayoutX(),
							(int) tuile.getLayoutY(), e1));
				}
			});
			siliteBang.setOnMouseClicked((e) -> {
				if (verifiePlaceLibre(tuile.getLayoutX(), tuile.getLayoutY()) == true && this.m1.getArgent() > 12) {
					this.m1.enleverArgent(12);
					this.e1.ajouterTourelles(new TourelleSilliteBang(75, 500, "", (int) tuile.getLayoutX(),
							(int) tuile.getLayoutY(), e1));
				}
			});
			drPingoLimbo.setOnMouseClicked((e) -> {
				if (verifiePlaceLibre(tuile.getLayoutX(), tuile.getLayoutY()) == true && this.m1.getArgent() > 12) {
					this.m1.enleverArgent(12);
					this.e1.ajouterTourelles(new TourelleDocteurPingoLimbo(75, 0, "", (int) tuile.getLayoutX(),
							(int) tuile.getLayoutY(), e1));
				}
			});
		} else {
			System.out.println("taille avant boucle" + e1.getTourelles().size());
			System.out.println("l id de la tuile " + tuile.getId());

			bouttonVendre.setOnMouseClicked((e) -> {
				System.out.println("taille avant vente : " + this.e1.getTourelles().size());
				for (int i = 0; i < this.e1.getTourelles().size(); i++) {
					this.m1.ajouterArgent(-4);
					if (this.e1.getTourelles().get(i).getX() == tuile.getLayoutX()
							&& this.e1.getTourelles().get(i).getY() == tuile.getLayoutY()) {
					try {
						this.e1.getTourelles().remove(e1.getTourelles().get(i));
						System.out.println("xx = " + e1.getTourelles().get(0).getX());
						System.out.println("yy = " + e1.getTourelles().get(0).getY());
						System.out.println("taille apres boucle " + e1.getTourelles().size());
					} catch (Exception e2) {
						System.out.println("La tourelle à été vendue, la liste des tourelles est maintenant vide");
						

					} 
						
						
					}
				}
			});
		}
	}

	public boolean verifiePlaceLibre(double x, double y) {
		for (int i = 0; i < this.e1.getTourelles().size(); i++) {
			if (this.e1.getTourelles().get(i).getX() == x && this.e1.getTourelles().get(i).getY() == y) {
				return false;
			}
		}
		return true;
	}

	private static Image getImgg(String... paths) {
		return new Image(Paths.get(System.getProperty("user.dir"), paths).toUri().toString());

	}

	@FXML
	void reinit(ActionEvent event) {
		getGameLoop().stop();
		if (this.e1.getViruses().size() != 0) {
			for (Virus v : this.e1.getViruses()) {
				this.e1.getViruses().remove(v);
			}
		}
		if (this.e1.getTourelles().size() != 0) {
			for (int j = 0; j < this.e1.getTourelles().size(); j++) {
				this.e1.getTourelles().remove(j);
			}
		}

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
