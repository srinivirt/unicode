package my;

import java.awt.GraphicsEnvironment;
import java.awt.Font;

public class PrintAllAvailableFonts {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// get local Graphics Environment
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		Font[] fonts = ge.getAllFonts();
		System.out.println("Available fonts:");
		for (Font f : fonts) {
			System.out.println(f.getName());
		}
	}

}
