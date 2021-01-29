package robo;

import java.util.Scanner;

public class Robo {
	public static void main(String[] args) throws InterruptedException {
		
		Scanner sc = new Scanner(System.in);
		
		int seg = 60;
		int min = 10;
		
		Cronometro c = new Cronometro();
		
		c.setTotalSeg(seg);
		c.setMin(min);
		
		
		c.cronometro();
	}
}
