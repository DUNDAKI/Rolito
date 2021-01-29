package robo;

import javax.swing.JOptionPane;

public class Cronometro {
	private int seg = 0;
	private int min = 0;
	private int h = 0;
	private int  totalSeg,totalMin;
	private int cont = 0;
	
	
	public Cronometro() {

		// TODO Auto-generated constructor stub
	}

	
	public Cronometro(int seg, int min, int h, int totalSeg, int totalMin, int cont) {
		super();
		this.seg = seg;
		this.min = min;
		this.h = h;
		this.totalSeg = totalSeg;
		this.totalMin = totalMin;
		this.cont =  cont;
	}


	
	public int getSeg() {
		return seg;
	}


	public void setSeg(int seg) {
		this.seg = seg;
	}


	public int getMin() {
		return min;
	}


	public void setMin(int min) {
		this.min = min;
	}


	public int getH() {
		return h;
	}


	public void setH(int h) {
		this.h = h;
	}


	public int getTotalSeg() {
		return totalSeg;
	}


	public void setTotalSeg(int totalSeg) {
		this.totalSeg = totalSeg;
	}


	public int getTotalMin() {
		return totalMin;
	}


	public void setTotalMin(int totalMin) {
		this.totalMin = totalMin;
	}
	
	


	public void cronometro() throws InterruptedException {

		while (true) {
			Thread.sleep(1000);
			seg += 1;

			System.out.println(h + ":" + min + ":" + seg);

			// timer
			if (seg == 60) {
				min += 1;
				seg = 0;
			}

			if (min == 60) {
				h += 1;
				min = 0;
			}
			
			
			if(min == 60) {
				min=0;
				System.out.println("Atualizando");
			}
			
		}
			
			
		}

	

}
