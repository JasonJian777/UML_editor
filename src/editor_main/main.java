package editor_main;

import java.awt.BorderLayout;
import javax.swing.*;

public class main {
	// private static Canvas canvas;
	static public void main(String[] args) {
		JFrame jf = new JFrame("UML_Editor");
		jf.setSize(1600, 900);
		jf.setLocationRelativeTo(null);
		jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		Canvas canvas = Canvas.getInstance();
		MenuBar mb = MenuBar.getInstance();
		ToolBar tb = ToolBar.getInstance();

		jf.add(canvas);
		jf.getContentPane().add(BorderLayout.WEST, tb);
		jf.getContentPane().add(BorderLayout.NORTH, mb);

		jf.setVisible(true);
	}

}
