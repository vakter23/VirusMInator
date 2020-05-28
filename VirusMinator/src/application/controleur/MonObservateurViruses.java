package application.controleur;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import application.Config;
import application.modele.virus.Virus;
import application.modele.virus.VirusBasirus;
import application.modele.virus.VirusDivirus;
import application.modele.virus.VirusVhealrus;
import application.modele.virus.VirusViboomrus;
import application.modele.virus.VirusViterus;
import javafx.beans.InvalidationListener;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class MonObservateurViruses implements ListChangeListener<Virus> {
	private Pane panneauEnnemis;
	public MonObservateurViruses(Pane Ennemis ) {
		super();
		this.panneauEnnemis = Ennemis;
	}
	public void creerSpriteVirus(Virus v) {
		
		ImageView VirusActuel;
		/*
		 * { Demander à la prof pour la gameloop, et pour la facon d'afficher un ennemi
		 * en fonction de sa sous classe
		 * 
		 *
		 */

		// this.e1.getViruses().addListener()
		if (v instanceof VirusBasirus) {
			VirusActuel = Config.getImg("/src/ressources/virus/base_Virus.png");
			VirusActuel.setId(v.getId());
			VirusActuel.translateXProperty().bind(v.getXproperty());
			VirusActuel.translateYProperty().bind(v.getYproperty());
			System.out.println(VirusActuel.getTranslateX());
			System.out.println(VirusActuel.getTranslateY());
			panneauEnnemis.getChildren().add(VirusActuel);

		} else if (v instanceof VirusDivirus) {
			VirusActuel = Config.getImg("/src/ressources/virus/divisible_Virus.png");
			VirusActuel.setId(v.getId());
			VirusActuel.translateXProperty().bind(v.getXproperty());
			VirusActuel.translateYProperty().bind(v.getYproperty());
			System.out.println(VirusActuel.getTranslateX());
			System.out.println(VirusActuel.getTranslateY());
			panneauEnnemis.getChildren().add(VirusActuel);
		}

		else if (v instanceof VirusVhealrus) {
			VirusActuel = Config.getImg("/src/ressources/virus/healing_Virus.png");
			VirusActuel.setId(v.getId());
			VirusActuel.translateXProperty().bind(v.getXproperty());
			VirusActuel.translateYProperty().bind(v.getYproperty());
			System.out.println(VirusActuel.getTranslateX());
			System.out.println(VirusActuel.getTranslateY());
			panneauEnnemis.getChildren().add(VirusActuel);

		} else if (v instanceof VirusViboomrus) {
			VirusActuel = Config.getImg("/src/ressources/virus/impact_Virus.png");
			VirusActuel.setId(v.getId());
			VirusActuel.translateXProperty().bind(v.getXproperty());
			VirusActuel.translateYProperty().bind(v.getYproperty());
			System.out.println(VirusActuel.getTranslateX());
			System.out.println(VirusActuel.getTranslateY());
			panneauEnnemis.getChildren().add(VirusActuel);

		} else if (v instanceof VirusViterus) {	
			VirusActuel = Config.getImg("/src/ressources/virus/rapid_Virus.png");
			VirusActuel.setId(v.getId());
			VirusActuel.translateXProperty().bind(v.getXproperty());
			VirusActuel.translateYProperty().bind(v.getYproperty());
			System.out.println(VirusActuel.getTranslateX());
			System.out.println(VirusActuel.getTranslateY());
			panneauEnnemis.getChildren().add(VirusActuel);

		}

	}
	private void enleverSprite(Virus mort) {
		this.panneauEnnemis.getChildren().remove(this.panneauEnnemis.lookup("#"+mort.getId()));
	}
	@Override
	public void onChanged(Change<? extends Virus> c) {
		while (c.next()) {			
			for (Virus mort : c.getRemoved()){
				System.out.println(mort.getId());
				enleverSprite(mort);
				
			}
			for (Virus nouveau : c.getAddedSubList()) {
				creerSpriteVirus(nouveau);
			}
		}
		
	}



}
