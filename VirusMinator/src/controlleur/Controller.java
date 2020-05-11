package controlleur;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;


import javafx.scene.layout.TilePane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
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
/*Dans cette methode, il faudra coder l'affichage lors du clic des différentes tourelles dispo
on peut aussi (peut-être) y coder les pdv mais probablement pas optimal
 */
    }
    @Override
    public void initialize(URL arg0, ResourceBundle arg1){
        Image im = new Image("/ressources/tilemapTest.png");
        ImageView carteA_Ajouter = new ImageView(im);

       /* map.getChi ().add(carteA_Ajouter);*/
//        /*setMap(map);*/
//        this.map = map;
//        System.out.println(this.map);
    }
    public void setMap(TilePane map) {
        this.map = map;
        System.out.println(this.map);
    }
}
