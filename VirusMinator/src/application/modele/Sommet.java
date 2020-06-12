package application.modele;

import java.util.ArrayList;
import java.util.Iterator;

public class Sommet {
	
	
	private int x;
	private int y;
	private Sommet parent;
	
	private ArrayList<Sommet> adjacent ;
	private boolean visited;
	
	public Sommet(int x , int y) {
		this.x =x;
		this.y =y;
		this.adjacent = new ArrayList<Sommet>();
		
		this.visited =false;
	}
	
	public  ArrayList<Sommet> getAdj(){
		return this.adjacent;
	}
	
	public boolean getVisited() {
		return this.visited;
	}
	
	public  Sommet getParent() {
		return this.parent;
	}
	public void setVisited(boolean b) {
		this.visited= b;
	}
	
	public boolean estUnSommet(int x , int y) {
		if(Environnement.getTerrainInt()[x][y]==0) {
			return true;
		}
		return false;
	}
	
	
	public int getX() {
		return this.x;
	}
	public int getY() {
		return this.y;
	}
	

	public void setParent(Sommet s) {
		
		parent = s;
		
	}

//	@Override
//	public String toString() {
//		return "Sommet [x=" + x + ", y=" + y + ", adjacent=" + adjacent + "]";
//	}
	
	public String toString() {
		return "x" + this.getX()+ "y" + this.getY();
	}
	
	
}	
