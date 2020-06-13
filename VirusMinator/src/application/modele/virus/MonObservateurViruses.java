package application.modele.virus;

import application.Config;
import javafx.collections.ListChangeListener;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class MonObservateurViruses implements ListChangeListener<Virus> {
	private Pane panneauEnnemis;

	public MonObservateurViruses(Pane Ennemis) {
		super();
		this.panneauEnnemis = Ennemis;
	}

	/**
	 * Cette méthode crée les sprite de chaque virus lorsqu'ils sont ajoutés à la
	 * liste "virusesDansTerrain"
	 */
	public void creerSpriteVirus(Virus v) {

		ImageView VirusActuel;

		if (v instanceof VirusBasirus) {
			VirusActuel = Config.getImageView("/src/ressources/Virus/base_Virus.png");
			VirusActuel.setId(v.getId());
			VirusActuel.translateXProperty().bind(v.getXproperty());
			VirusActuel.translateYProperty().bind(v.getYproperty());
			panneauEnnemis.getChildren().add(VirusActuel);

		} else if (v instanceof VirusDivirus) {
			VirusActuel = Config.getImageView("/src/ressources/Virus/divisible_Virus.png");
			VirusActuel.setId(v.getId());
			VirusActuel.translateXProperty().bind(v.getXproperty());
			VirusActuel.translateYProperty().bind(v.getYproperty());
			panneauEnnemis.getChildren().add(VirusActuel);
		}

		else if (v instanceof VirusVhealrus) {
			VirusActuel = Config.getImageView("/src/ressources/Virus/healing_Virus.png");
			VirusActuel.setId(v.getId());
			VirusActuel.translateXProperty().bind(v.getXproperty());
			VirusActuel.translateYProperty().bind(v.getYproperty());
			panneauEnnemis.getChildren().add(VirusActuel);

		} else if (v instanceof VirusViboomrus) {
			VirusActuel = Config.getImageView("/src/ressources/Virus/impact_Virus.png");
			VirusActuel.setId(v.getId());
			VirusActuel.translateXProperty().bind(v.getXproperty());
			VirusActuel.translateYProperty().bind(v.getYproperty());
			panneauEnnemis.getChildren().add(VirusActuel);

		} else if (v instanceof VirusViterus) {
			VirusActuel = Config.getImageView("/src/ressources/Virus/rapid_Virus.png");
			VirusActuel.setId(v.getId());
			VirusActuel.translateXProperty().bind(v.getXproperty());
			VirusActuel.translateYProperty().bind(v.getYproperty());
			panneauEnnemis.getChildren().add(VirusActuel);

		}
	}

	private void enleverSprite(Virus mort) {
		this.panneauEnnemis.getChildren().remove(this.panneauEnnemis.lookup("#" + mort.getId()));
	}

	/**
	 * Cette méthode appelle "enleverSprite" pour les viruses morts et appelle
	 * "creerSpriteViruses"
	 */
	@Override
	public void onChanged(Change<? extends Virus> c) {
		while (c.next()) {
			for (Virus mort : c.getRemoved()) {
				enleverSprite(mort);
			}
			for (Virus nouveau : c.getAddedSubList()) {
				creerSpriteVirus(nouveau);
			}
		}

	}

}
