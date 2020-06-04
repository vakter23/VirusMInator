package application.modele.tir;

import application.modele.virus.Virus;

public class TirAvecDegats extends Tir {

	private double atq;
	private Virus v;
	public TirAvecDegats(int x, int y, Virus v) {
		super(x, y);
		this.v=v;
	}

	/**
	 * @return the atq
	 */
	public double getAtq() {
		return atq;
	}
	/**
	 * @param atq the atq to set
	 */
	public void setAtq(double atq) {
		this.atq = atq;
	}

	@Override
	public void agit() {
	}

}
