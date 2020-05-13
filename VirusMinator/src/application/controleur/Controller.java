package application.controleur;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
	private TilePane map;

	@FXML
	private Button seDeplace;

	@FXML
	private Button Reinit;

	@FXML
	private Button placerEnnemis;

	@FXML
	private Pane panneauEnnemis;

	void placerEnnemis() {

	}

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

	void placerEnnemis(ActionEvent event) {
		Circle r = new Circle(3);
		r.setFill(Color.RED);
		r.setTranslateX(0);
		r.setTranslateY(0);
		map.getChildren().add(r);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		creerTerrainVue();

	}

	private static ImageView getImg(String... paths) {
		return new ImageView(Paths.get(System.getProperty("user.dir"), paths).toUri().toString());
		// ImageView(Paths.get(Paths.get(System.getProperty("user.dir"),
		// "ressources").toString(), paths).toUri().toString());
	}

}
