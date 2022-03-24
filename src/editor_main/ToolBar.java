package editor_main;

import javax.swing.JToolBar;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import editor_mode.*;

public class ToolBar extends JToolBar {
	protected Canvas canvas;
	private List<Button> btnList;
	private BaseObjMode[] modeList;
	static public ToolBar instance = null;

	public static ToolBar getInstance() {
		if (instance == null)
			instance = new ToolBar();
		return instance;
	}

	public ToolBar() {
		canvas = Canvas.getInstance();
		btnList = new ArrayList<>();
		int btnNum = 6;
		setFloatable(false);
		setLayout(new GridLayout(btnNum, 1));
		String[] btnNames = { "select", "aline", "gline", "cline", "class", "ucase" };
		modeList = new BaseObjMode[] { new SelectMode(), new AsscociationMode(), new GeneralizationMode(),
				new CompositionMode(), new ClassMode(), new UseCaseMode() };
		for (int i = 0; i < btnNum; i++) {
			Button btn = new Button(btnNames[i], modeList[i]);
			btnList.add(btn);
			add(btn);
		}
	}

	public void resetColor() {
		for (Button btn : btnList) {
			btn.setBackground(Color.WHITE);
		}
	}
}
