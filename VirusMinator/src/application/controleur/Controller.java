package application.controleur;

import java.net.URL;
import java.util.ResourceBundle;

import org.omg.CORBA.Current;

import com.sun.javafx.iio.common.SmoothMinifier;

import application.modele.Config;
import application.modele.Environnement;
import application.virus.Virus;
import application.virus.VirusBasirus;
import application.virus.VirusDivirus;
import application.virus.VirusVhealrus;
import application.virus.VirusViboomrus;
import application.virus.VirusViterus;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

public class Controller implements Initializable {

	@FXML
	private Button seDeplace;

	@FXML
	private Button Reinit;

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

	private Environnement e1;

	private Timeline gameLoop;

	private int temps;

	public void initialize(URL arg0, ResourceBundle arg1) {
		/*
		 * Appeler lvl1 qui appelera la methode de création de map, et après utiliser un
		 * switch pour afficher Victoire ou défaite, et niveau suivant.
		 */
		this.e1 = new Environnement(920, 920);
		this.panneauEnnemis.setMaxWidth(952);
		this.panneauEnnemis.setMaxHeight(952);
		creerTerrainVue();
		System.out.println("fait");
		int compteur = 0;
		for (int i = 0; i < e1.getViruses().size(); i++) {
			// demarre l'animation
			creerSpriteVirus(e1.getViruses().get(i));
			switch (e1.getViruses().get(i).getNom()) {
			case "VirusBasirus":
				ImageView VirusBasirus = Config.getImg("/src/ressources/virus/base_Virus.png");
				initAnimation(e1.getViruses().get(i));
				break;

			case "VirusDivirus":
				ImageView VirusDivirus = Config.getImg("/src/ressources/virus/divisible_Virus.png");
				initAnimation(e1.getViruses().get(i));
				break;
			case "VirusVhealrus":
				ImageView VirusVhealrus = Config.getImg("/src/resspirces/virus/healing_Virus.png");
				initAnimation(e1.getViruses().get(i));
				break;

			}
			gameLoop.play();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		creerSpriteNull();
	}

	private void initAnimation(Virus v) {
		gameLoop = new Timeline();
		temps = 0;
		gameLoop.setCycleCount(Timeline.INDEFINITE);
		double vitesse;
		if (true) {
			vitesse = v.getVitesse();
		} else {
			vitesse = v.getVitesse();
		}

		KeyFrame kf = new KeyFrame(
				// on définit le FPS (nbre de frame par seconde)
				Duration.seconds(vitesse),

				// on définit ce qui se passe à chaque frame
				// c'est un eventHandler d'ou le lambda
				(ev -> {
					if (temps == 100) {
						System.out.println("fini");
						gameLoop.stop();
					} else if (temps % 10 == 0) {
						System.out.println("un tour");
						for (int i = 0; i < getPanneauEnnemis().getChildren().size(); i++) {
							panneauEnnemis.getChildren().get(i)
									.setTranslateX(panneauEnnemis.getChildren().get(i).getTranslateX() + 5);
							panneauEnnemis.getChildren().get(i)
									.setTranslateY(panneauEnnemis.getChildren().get(i).getTranslateY());
						}
					}
					temps++;
				}));
		gameLoop.getKeyFrames().add(kf);
//		
	}

	public void creerTerrainVue() {
		System.out.println(Config.listeMap.size());
		ImageView shopSavonSolid = Config.getImg("/src/ressources/tourelles/solidSavon.png");
		shopSavon.getChildren().add(shopSavonSolid);
		ImageView shopHydroGel = Config.getImg("/src/ressources/tourelles/gelHydro.png");

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
				break;
			case "vertEnnemi":
				map.getChildren().add(vertEnnemi);
				break;
			case "violetEnnemi":
				map.getChildren().add(violetEnnemi);
				break;
			}

		}
		teteHero.getChildren().add(Config.getImg("/src/ressources/tete.png"));
		teteVilain.getChildren().add(Config.getImg("/src/ressources/tete.png"));

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
			panneauEnnemis.getChildren().get(i).setTranslateX(panneauEnnemis.getChildren().get(i).getTranslateX() + 32);
			panneauEnnemis.getChildren().get(i).setTranslateY(panneauEnnemis.getChildren().get(i).getTranslateY());
			
		}
	}

	@FXML
	void reinit(ActionEvent event) {
		getPanneauEnnemis().getChildren().clear();
		for (int i = 0; i < e1.getViruses().size(); i++) {
			creerSpriteVirus(e1.getViruses().get(i));
			initAnimation(e1.getViruses().get(i));
			gameLoop.play();
		}

	}

	public void creerSpriteVirus(Virus v) {
		/*
		 * { Demander à la prof pour la gameloop, et pour la facon d'afficher un ennemi
		 * en fonction de sa sous classe
		 * 
		 *
		 */

		// this.e1.getViruses().addListener()
		if (v instanceof VirusBasirus) {
			ImageView VirusBasirus = Config.getImg("/src/ressources/virus/base_Virus.png");
			VirusBasirus.setId(v.getId());
			VirusBasirus.setTranslateX(v.getX());
			VirusBasirus.setTranslateY(v.getY());
			panneauEnnemis.getChildren().add(VirusBasirus);
		} else if (v instanceof VirusDivirus) {
			ImageView VirusDivirus = Config.getImg("/src/ressources/virus/divisible_Virus.png");
			VirusDivirus.setId(v.getId());
			VirusDivirus.setTranslateX(v.getX());
			VirusDivirus.setTranslateY(v.getY());
			panneauEnnemis.getChildren().add(VirusDivirus);
		} else if (v instanceof VirusVhealrus) {
			ImageView VirusVhealrus = Config.getImg("/src/ressources/virus/healing_Virus.png");
			VirusVhealrus.setId(v.getId());
			VirusVhealrus.setTranslateX(v.getX());
			VirusVhealrus.setTranslateY(v.getY());
			panneauEnnemis.getChildren().add(VirusVhealrus);
		} else if (v instanceof VirusViboomrus) {
			ImageView VirusViboomrus = Config.getImg("/src/ressources/virus/impact_Virus.png");
			VirusViboomrus.setId(v.getId());
			VirusViboomrus.setTranslateX(v.getX());
			VirusViboomrus.setTranslateY(v.getY());
			panneauEnnemis.getChildren().add(VirusViboomrus);
		} else if (v instanceof VirusViterus) {
			ImageView VirusViterus = Config.getImg("/src/ressources/virus/rapid_Virus.png");
			VirusViterus.setId(v.getId());
			VirusViterus.setTranslateX(v.getX());
			VirusViterus.setTranslateY(v.getY());
			panneauEnnemis.getChildren().add(VirusViterus);
		}

	}

	public void creerSpriteNull() {
		ImageView Virus = Config.getImg("/src/ressources/Virus/base_Virus.png");
		Virus.setTranslateX(0);
		Virus.setTranslateY(352); /* (0;352 est le bloc ou les ennemis spawnent) */
		getPanneauEnnemis().getChildren().add(Virus);
		System.out.println("sout SpriteNull");
	}

	@FXML
	void Start(ActionEvent event) {
		for (int i = 0; i < 20; i++) {

			seDeplacer();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
//	void placerEnnemis(ActionEvent event) {
//		Circle r = new Circle(3);
//		r.setFill(Color.RED);
//		r.setId("rond");this.panneauEnnemis.setMaxWidth(952);
//		r.setTranslateX(0);
//		r.setTranslateY(0);
//		r.setOnMouseClicked(e-> System.out.println("clic sur acteur"+e.getSource()));
//		map.getChildren().add(r);
//	}

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