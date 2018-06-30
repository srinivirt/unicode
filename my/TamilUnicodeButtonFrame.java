package my;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;

import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.text.Collator;

import java.awt.Font;

public class TamilUnicodeButtonFrame extends JFrame {

	// private data area
	JButton[] tamButtons;  // variable to access array of buttons
	private final int NBUTTONS = 256;
	
	// contructor: initialize the private parts and self
	public TamilUnicodeButtonFrame() {
		// initialize frame stuff
		setTitle("Tamil Unicode Buttons");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// what does this do?
		// Character Ch = new Character('\u0b85'); // deprecated in Java 9
		// char c = Ch.charValue(); // deprecated in Java 9
        char c = Character.valueOf('\u0b85'); // single call in Java 9
		System.out.print("Print char \u0b85 to console: ");
		System.out.println(c);
		
		// get local Graphics Environment
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		Font[] fonts = ge.getAllFonts();
		System.out.println("Available fonts:");
		for (Font f : fonts) {
			System.out.println(f.getName());
		}
		for (Font f : fonts) {
			
			if (f.canDisplay('\u0b85')) {
				System.out.println(f.getName() + " can display tamil!!!!!!");
				// System.out.println("can display");
			}
		}
		
		// choose a Tamil font available on the system
		// Font tamFont = new Font("Latha", Font.PLAIN, 12);
		Font tamFont = new Font("Arial Unicode MS", Font.PLAIN, 12);
		
		// allocate memory for tamButtons
		tamButtons = new JButton[NBUTTONS]; // allocate memory space for 128 JButton objects
		char tamChar = '\u0b85';
		tamChar++;
		String tamAlphaFromChar = new String(Character.toString(tamChar));
		
		String tamAlpha = new String("\u0b85");
		// initialize the array its by calling the ctor for each one
		
		// set tamChar to an initial unicode value, then increment it by 1 (one)
		// to get the next value
		tamChar = '\u0b80';
		for (int i = 0; i < NBUTTONS; ++i) {
			tamButtons[i] = new JButton();
			tamButtons[i].setFont(tamFont);
			// tamButtons[i].setText(tamAlphaFromChar);
			if (tamFont.canDisplay(tamChar)) {
				//tamButtons[i].setText(Character.toString(tamChar) + Integer.toHexString((int)tamChar));
				tamButtons[i].setText(Character.toString(tamChar));
			}
			// add the U vowel sound
			// tamButtons[i].setText(Character.toString(tamChar) + Character.toString('\u0bc1'));
			++tamChar;
		}
		
		// set the layout for the frame's content pane
		this.getContentPane().setLayout(new GridLayout(0,8)); // fixed columns
		
		// add the tamButtons to the content pane
		for (int i = 0; i < NBUTTONS; ++i) {
			this.getContentPane().add(tamButtons[i]);
		}
		
        // add a TextField
        JTextField displayText = new JTextField(80);
        this.getContentPane().add(displayText);

		// pack and show the frame
		pack();
		setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// tell the GUI thread to create the frame later (asap)
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new TamilUnicodeButtonFrame();
			}
		});
		

	}

}
