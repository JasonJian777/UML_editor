package editor_main;

import java.awt.Color;
import javax.swing.*;
import java.awt.event.*;
import editor_mode.*;

public class Button extends JButton {
    protected Canvas canvas;
    private BaseObjMode mode;

    public Button(String btnName, BaseObjMode mode) {
        canvas = Canvas.getInstance();
        this.mode = mode;
        width = 100;
        height = 100;
        img = new ImageIcon("./img/" + btnName + ".png");
        img.setImage(img.getImage().getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH));
        setIcon(img);
        setName(btnName);
        setActionCommand(btnName);
        addActionListener(new toolListener());
        setBackground(Color.WHITE);
    }

    public void setImg(String btnName) {
        img = new ImageIcon("./img/%s.png", btnName);
        System.out.printf("./img/%s.png", btnName);
        img.setImage(img.getImage().getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH));
    }

    private ImageIcon img;
    private int width;
    private int height;

    class toolListener implements ActionListener {
        // @Override
        public void actionPerformed(ActionEvent e) {
            Canvas.getInstance().setCurMode(mode);
            ToolBar.getInstance().resetColor();
            setBackground(Color.GRAY);
        }
    }

};
