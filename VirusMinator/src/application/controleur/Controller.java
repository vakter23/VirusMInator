package application.controleur;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
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

public class Controller implements Initializable {

	/* Les boutons */
	@FXML
	private Button seDeplace;
	@FXML
	private Button Reinit;
	@FXML
	private Button placerEnnemis;
	@FXML
	private Button pause;
	@FXML
	private Button Start;
	@FXML
	private Button bouttonAmeliorer;
	@FXML
	private Button bouttonVendre;

	/* Les Boxes */
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

	/* Ce tilepane crée la map */
	@FXML
	private TilePane map;
	/*
	 * Les actions en dehors de la map se font sur un pane (placement des tourelles,
	 * attaque des tourelles et deplacement virus)
	 */
	@FXML
	private Pane panneauEnnemis;

	/* C'est l'environnement du jeu */
	private Environnement e1;

	/* Ces deux données nous aident pour la gameloop */
	private static Timeline gameLoop;
	public static int temps;

	/* Indique les ressources du joueur */
	@FXML
	private Label labelArgent;
	/* Indique l'issue d'une partie */
	@FXML
	private Label finDeJeu;

	/* Ces images representent le magasin */
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
	@FXML
	private ImageView coronaCoin;

	/* Il represente la vie de l'hopital */
	@FXML
	private ProgressBar healthBar;

    @FXML
    private Button nvVague;
    
    private boolean finDeLaGameLoop = false;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		this.e1 = new Environnement(1600, 800, new Magasin());
		/*
		 * On ajoute 32 pixels sur le panneau ennemis car les tuiles font 32 pixels donc
		 * il faut le prendre en compte
		 */
		this.panneauEnnemis.setMaxWidth(1632);
		this.panneauEnnemis.setMaxHeight(832);
		/* Label qui contient l'affichage de la victoire */
		this.finDeJeu.setText("");
		/* Cette méthode créer dynamiquement la tilemap et le magasin */
		creerTerrainVue();
		/* On calcule le BFS ici */
		Graph g = new Graph();
		g.addEdge();
		g.BFS(Graph.getSommet().get(21));// 21 est le nombre de sommet que le BFS traverse
		initiateurDeVirus();
		initAnimation();
		/*
		 * La progresse barre se calcule en pourcentage donc c'est pour cela qu'on
		 * divise par 100
		 */
		this.healthBar.progressProperty().bind(this.e1.getHopital().getVieProperty().divide(100));
		/* On bind l'argent du compte */
		this.labelArgent.textProperty().bind(this.e1.getMagasin().getArgentProperty().asString());
		/* On ajoute les listeners sur le panneau */
		this.e1.getViruses().addListener(new MonObservateurViruses(panneauEnnemis));
		this.e1.getTirs().addListener(new MonObservateurTirs(panneauEnnemis));
		this.e1.getTourelles().addListener(new ecouteurTourelle(panneauEnnemis));
	}

	/* Cette fonction s'occupe de la Game Loop et de la condtions de victoire */
	private void initAnimation() {
		setGameLoop(new Timeline());
		/* Cette variable est le temps utiliser dans la gameloop */
		temps = 0;
		getGameLoop().setCycleCount(Timeline.INDEFINITE);
		KeyFrame kf = new KeyFrame(
				// on définit le FPS (nbre de frame par seconde)
				Duration.seconds(0.0005),

				// on définit ce qui se passe à  chaque frame
				// c'est un eventHandler d'ou le lambda
				(ev -> {
					/* Tous les tours le tir agit */
					this.e1.unTourTir();

					if (finDeLaGameLoop) {
						getGameLoop().stop();
					}
					/* Lorsque le temps est modulo 50 on fait un tour */
					else if (temps % 50 == 0) {
						unTour();
					}
					/* On gagne de l'argent tous les 800 tours */
					if (temps % 2000 == 0) {
						this.e1.getMagasin().incrementerArgent();
					}
					/* Conditions de Victoire, la gameloop s'arrete */
					if (this.e1.getViruses().isEmpty() && temps > 4000) {
						gameLoop.stop();
						this.afficherResultat("w");
						
					}
					/* Conditions de Defaite, la gameloop s'arrete */
					if (this.e1.getHopital().getVie() == 0) {
						Controller.getGameLoop().stop();
						this.afficherResultat("l");
						
					}
					/* On avance à  l'étape d'après */
					temps++;
				}));
		getGameLoop().getKeyFrames().add(kf);
	}

	void unTour() {
		this.e1.unTour();
	}

	public void initiateurDeVirus() {
		this.e1.nouvelleVague();
	}

	/* Méthode qui créer dynamiquement la vue */
	public void creerTerrainVue() {
		/* On set les images du magasin */
		savonneuse.setImage((Image) (getImage("/src/ressources/magasin/shopSavonneuse.png")));
		avastirus.setImage((Image) (getImage("/src/ressources/magasin/shopAvastirus.png")));
		gelHydroClaque.setImage((Image) (getImage("/src/ressources/magasin/shopHydroClaque.png")));
		siliteBang.setImage((Image) (getImage("/src/ressources/magasin/shopSiliteBang.png")));
		drPingoLimbo.setImage((Image) (getImage("/src/ressources/magasin/shopDrPingoLimbo.png")));
		coronaCoin.setImage((Image) (getImage("/src/ressources/magasin/coronacoin.jpg")));

		/* Création de la map dynamiquement */
		for (int i = 0; i < Config.listeMap.size(); i++) {
			ImageView blancHopital = Config.getImageView("/src/ressources/tiles/blancHopital");
			ImageView herbe = Config.getImageView("/src/ressources/tiles/herbe.png");
			ImageView BordTerrain = Config.getImageView("/src/ressources/tiles/BordTerrain.png");
			ImageView hitBoxHosto = Config.getImageView("/src/ressources/tiles/hitBoxHosto.png");
			ImageView rougeHopital = Config.getImageView("/src/ressources/tiles/rougeHopital.png");
			ImageView sableChemin = Config.getImageView("/src/ressources/tiles/sableChemin.png");
			ImageView sableTerrain = Config.getImageView("/src/ressources/tiles/sableTerrain.png");
			ImageView spawnMob = Config.getImageView("/src/ressources/tiles/spawnMob.png");
			ImageView spawnTourelles = Config.getImageView("/src/ressources/tiles/spawnTourelles.png");
			ImageView vertEnnemi = Config.getImageView("/src/ressources/tiles/vertEnnemi.png");
			ImageView violetEnnemi = Config.getImageView("/src/ressources/tiles/violetEnnemi.png");
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
				/*
				 * Les tiles spawnTourelle on un setOnMouseClicked pour gérer l'achat, la vente
				 * et l'amelioration
				 */
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
	@FXML
    void lancerVague(ActionEvent event) {
		this.finDeLaGameLoop = false;
		this.finDeJeu.setText("C'EST PARTI");
		this.temps = 0;
		initAnimation();
		this.e1.nouvelleVague();
		gameLoop.play();

    }
	/*
	 * Methode qui s'occupe de la gestion des tourelles (placements,ventes et
	 * amélioration)
	 */
	void clicTourelle(MouseEvent event) {
		/* On recupere la tuile ou on a clique */
		event.getTarget();
		Node tuile = (Node) event.getSource();
		/* On verifie si la place est libre pour poser une tourelle */
		/*
		 * Apres voir cliquer sur l'endroit et sur une tourelle du magasin on l'ajoute a
		 * la liste
		 */
		if (verifiePlaceLibre(tuile.getLayoutX(), tuile.getLayoutY()) == true) {
			savonneuse.setOnMouseClicked((e) -> {
				if (verifiePlaceLibre(tuile.getLayoutX(), tuile.getLayoutY())
						&& this.e1.getMagasin().getArgent() >= 7) {
					// On crée la tourelle
					Tourelles t1 = new TourelleSavonneuse((int) tuile.getLayoutX(), (int) tuile.getLayoutY(), e1);
					// On perd de l'argent
					this.e1.getMagasin().enleverArgent(Magasin.prixSavonneuse);
					// on ajoute la tourelle a la liste observable
					this.e1.ajouterTourelles(t1);
				}
			});
			// On suit le meme schéma pour chaque tourelle
			avastirus.setOnMouseClicked((e) -> {
				if (verifiePlaceLibre(tuile.getLayoutX(), tuile.getLayoutY()) == true
						&& this.e1.getMagasin().getArgent() >= 5) {
					this.e1.getMagasin().enleverArgent(Magasin.avastirus);
					this.e1.ajouterTourelles(
							new TourelleMousseuse((int) tuile.getLayoutX(), (int) tuile.getLayoutY(), e1));
				}
			});
			gelHydroClaque.setOnMouseClicked((e) -> {
				if (verifiePlaceLibre(tuile.getLayoutX(), tuile.getLayoutY()) == true
						&& this.e1.getMagasin().getArgent() >= 9) {
					this.e1.getMagasin().enleverArgent(Magasin.gelHydroClaque);
					this.e1.ajouterTourelles(
							new TourelleHydroClaque((int) tuile.getLayoutX(), (int) tuile.getLayoutY(), e1));
				}
			});
			siliteBang.setOnMouseClicked((e) -> {
				if (verifiePlaceLibre(tuile.getLayoutX(), tuile.getLayoutY()) == true
						&& this.e1.getMagasin().getArgent() >= 12) {
					this.e1.getMagasin().enleverArgent(Magasin.siliteBang);
					this.e1.ajouterTourelles(
							new TourelleSilliteBang((int) tuile.getLayoutX(), (int) tuile.getLayoutY(), e1));
				}
			});
			drPingoLimbo.setOnMouseClicked((e) -> {
				if (verifiePlaceLibre(tuile.getLayoutX(), tuile.getLayoutY()) == true
						&& this.e1.getMagasin().getArgent() >= 12) {
					this.e1.getMagasin().enleverArgent(Magasin.drPingoLimbo);
					this.e1.ajouterTourelles(
							new TourelleDocteurPingoLimbo((int) tuile.getLayoutX(), (int) tuile.getLayoutY(), e1));
				}
			});
		} else {
			
			bouttonAmeliorer.setOnMouseClicked((e) -> {
				if (this.e1.getMagasin().getArgent()>10) {
				for (int i = 0; i < this.e1.getTourelles().size(); i++) {
					/*L'amélioration d'une tourelle coute 10 pieces*/
					this.e1.getMagasin().enleverArgent(10);
					if (this.e1.getTourelles().get(i).getX() == tuile.getLayoutX()
							&& this.e1.getTourelles().get(i).getY() == tuile.getLayoutY()) {
						/*On fait le changement dans la liste*/
						this.e1.getTourelles().get(i).amelioration();
					}
				}
				}
			});
			
			bouttonVendre.setOnMouseClicked((e) -> {
				for (int i = 0; i < this.e1.getTourelles().size(); i++) {
					this.e1.getMagasin().ajouterArgent(4);
					if (this.e1.getTourelles().get(i).getX() == tuile.getLayoutX()
							&& this.e1.getTourelles().get(i).getY() == tuile.getLayoutY()) {
						try {
							
							this.e1.getTourelles().remove(e1.getTourelles().get(i));
						} catch (Exception e2) {

						}
					}
				}
			});
		}
	}

	/*Vérifie dans la liste si la place est libre*/
	public boolean verifiePlaceLibre(double x, double y) {
		for (int i = 0; i < this.e1.getTourelles().size(); i++) {
			if (this.e1.getTourelles().get(i).getX() == x && this.e1.getTourelles().get(i).getY() == y) {
				return false;
			}
		}
		return true;
	}
	/*Retourne l'image */
	private static Image getImage(String... paths) {
		return new Image(Paths.get(System.getProperty("user.dir"), paths).toUri().toString());

	}

	/*Affiche le resultat du match dans le label*/
	public void afficherResultat(String resultat) {
		if (resultat == "w") {
			this.finDeJeu.setText("Victoire");
		} else if (resultat == "l") {
			this.finDeJeu.setText("Défaite");

		}
		finDeLaGameLoop = true;
	}

	/*C'est le bouton reinitialiser*/
	@FXML
	void pause(ActionEvent event) {
		if (getGameLoop().getStatus().equals(Animation.Status.PAUSED)) {
			getGameLoop().play();
		} else {
			getGameLoop().pause();
		}

	}
	
	/*Lance la partie*/
	@FXML
	void Start(ActionEvent event) {
		initAnimation();
		getGameLoop().play();
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
