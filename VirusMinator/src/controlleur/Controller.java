package controlleur;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import javafx.scene.layout.TilePane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.nio.file.Paths;
import java.util.ResourceBundle;

public class Controller implements Initializable {

	@FXML
	private TilePane map;

	@FXML
	private Button TourGBas;

	@FXML
	private Button TourDBas;

	@FXML
	private Button TourDHaut;

	@FXML
	private Button TourDMid;

	@FXML
	private Button TourGHaut;

	@FXML
	void turrets(ActionEvent event) {
		/*
		 * Dans cette methode, il faudra coder l'affichage lors du clic des differentes
		 * tourelles dispo on peut aussi (peut-etre) y coder les pdv mais probablement
		 * pas optimal
		 */
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		getImg(paths);
		map.getChildren().add(carte);
		
	}
	private static ImageView getImg(String...paths) {
		return new ImageView( Paths.get(System.getProperty("user.dir"), paths).toUri().toString());
				//ImageView(Paths.get(Paths.get(System.getProperty("user.dir"), "ressources").toString(), paths).toUri().toString());
	}


}
