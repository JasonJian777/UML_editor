package editor_main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuBar extends JMenuBar {
    private static MenuBar instance = null;
    private Canvas canvas = Canvas.getInstance();
    private JMenu edit;
    public JMenuItem[] menuItem;

    public MenuBar() {
        edit = new JMenu("Edit");
        add(edit);

        menuItem = new JMenuItem[] { new JMenuItem("Group"), new JMenuItem("UnGroup"),
                new JMenuItem("Change Object Name") };
        for (int i = 0; i < 3; i++) {
            edit.add(menuItem[i]);
            setMenuItem(i, false);
        }
        menuItem[0].addActionListener(new groupListener());
        menuItem[1].addActionListener(new ungroupListener());
        menuItem[2].addActionListener(new renameListener());

    }

    public void setMenuItem(int idx, boolean s) {
        menuItem[idx].setEnabled(s);
    }

    public static MenuBar getInstance() {
        if (instance == null)
            instance = new MenuBar();
        return instance;
    }

    class renameListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String input;
            input = JOptionPane.showInputDialog("New Object Name");
            if (input != null) {
                canvas.getSelectedShapeList().get(0).setShapeName(input);
                canvas.repaint();
            }
        }
    }

    class groupListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            canvas.groupShape();
            canvas.repaint();
            menuItem[0].setEnabled(false);
            menuItem[1].setEnabled(true);
        }
    }

    class ungroupListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            canvas.ungroupShape();
            canvas.repaint();
            menuItem[0].setEnabled(true);
            menuItem[1].setEnabled(false);
        }
    }
}
