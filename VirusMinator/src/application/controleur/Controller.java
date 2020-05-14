package application.controleur;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import application.Config;
import application.modele.Environnement;

public class Controller implements Initializable {

	 
	 @FXML
	    private Button seDeplace;

	    @FXML
	    private Button Reinit;

	    @FXML
	    private Button placerEnnemis;

	    @FXML
	    private TilePane map;

	    @FXML
	    private Pane panneauEnnemis;

	private Environnement e1;
	

	public void creerTerrainVue() {

		for (int i = 0; i < Config.listeMap.size(); i++) {
			ImageView blancHopital = getImg("/src/ressources/tiles/blancHopital");
			ImageView herbe = getImg("/src/ressources/tiles/herbe.png");
			ImageView BordTerrain = getImg("/src/ressources/tiles/BordTerrain.png");
			ImageView hitBoxHosto = getImg("/src/ressources/tiles/hitBoxHosto.png");
			ImageView rougeHopital = getImg("/src/ressources/tiles/rougeHopital.png");
			ImageView sableChemin = getImg("/src/ressources/tiles/sableChemin.png");
			ImageView sableTerrain = getImg("/src/ressources/tiles/sableTerrain.png");
			ImageView spawnMob = getImg("/src/ressources/tiles/spawnMob.png");
			ImageView spawnTourelles = getImg("/src/ressources/tiles/spawnTourelles.png");
			ImageView vertEnnemi = getImg("/src/ressources/tiles/vertEnnemi.png");
			ImageView violetEnnemi = getImg("/src/ressources/tiles/violetEnnemi.png");
			String retour;
			retour = Config.imageDe(Config.listeMap.get(i));
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

	}
//	void seDeplace (ActionEvent event) {
//		e1.
//	}
	/*
	@FXML 
	void creerSprite(ActionEvent event) {
		Circle r = new Circle(10);
		r.setFill(Color.RED);
		r.setTranslateX(10);
		r.setTranslateY(10);
		panneauEnnemis.getChildren().add(r);
	}
	*/
	@FXML
	void seDeplacer(ActionEvent event) {
		for(int i = 0; i<panneauEnnemis.getChildren().size(); i++) {
			panneauEnnemis.getChildren().get(i).setTranslateX(Math.random()*650);
			panneauEnnemis.getChildren().get(i).setTranslateY(Math.random()*650);
			
		}
	}
	@FXML
	void reinit(ActionEvent event) {
			panneauEnnemis.getChildren().clear();
			creerTerrainVue();
		}
	
	public void dessinEnnemi() {
		Circle r = new Circle(10);
		r.setFill(Color.RED);
		r.setTranslateX(Math.random()*1024);
		r.setTranslateY(Math.random()*1024);
		panneauEnnemis.getChildren().add(r);
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
		creerTerrainVue();
		dessinEnnemi();

	}

	private static ImageView getImg(String... paths) {
		return new ImageView(Paths.get(System.getProperty("user.dir"), paths).toUri().toString());
		// ImageView(Paths.get(Paths.get(System.getProperty("user.dir"),
		// "ressources").toString(), paths).toUri().toString());
	}

}
