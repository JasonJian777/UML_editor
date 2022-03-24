package editor_main;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.awt.*;
import editor_mode.*;
import editor_shape.*;
import editor_shape.Shape;
import editor_line.*;

public class Canvas extends JPanel {
    private static Canvas instance = null; // for singleton
    public BaseObjMode currentMode;
    public List<Shape> shapeList = new ArrayList<>();
    public List<Line> lineList = new ArrayList<>();
    public List<Shape> selectedShapeList = new ArrayList<>();

    public Port showPort = null; // when draw a line, show the startShape nearest port

    public static Canvas getInstance() {
        if (instance == null)
            instance = new Canvas();
        return instance;
    }

    public Canvas() {
        addMouseListener(new myMouseAdapter());
        setBackground(Color.WHITE);
    }

    private class myMouseAdapter extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent e) {
            if (currentMode != null) {
                currentMode.myMousePressed(e);
                // System.out.println("mousePressed");
                repaint();
            }
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            if (currentMode != null) {
                currentMode.myMouseReleased(e);
                // System.out.println("mouseReleased");
                repaint();
            }
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            if (currentMode != null) {
                // currentMode.myMouseClicked(e);
                // System.out.println("mouseClicked");
                repaint();
            }
        }

    }

    public void setShowPort(Port port) {
        showPort = port;
    }

    public void setCurMode(BaseObjMode mode) {
        currentMode = mode;
        cleanSelected();
        System.out.println(currentMode.re());
    }

    public void cleanSelected() {
        for (Shape s : getSelectedShapeList()) {
            s.setSelected(false);
        }
        getSelectedShapeList().clear();
        repaint();
    }

    public List<Shape> getShapeList() {
        return shapeList;
    }

    public List<Line> getLineList() {
        return lineList;
    }

    public List<Shape> getSelectedShapeList() {
        return selectedShapeList;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(2.0f));

        for (Shape s : shapeList) {
            s.draw(g2);
        }

        for (Line l : lineList) {
            l.lineDraw(g2);
        }
        for (Shape s : selectedShapeList) {
            s.drawPort(g2);
        }

        if (showPort != null) { // when draw a line, start port will show
            showPort.portDraw(g2);
        }
        showPort = null;

    }

    public void top(int idx) {
        Shape s = shapeList.get(idx);
        shapeList.remove(s);
        shapeList.add(s);
    }

    public void groupShape() {
        GroupShape tmp = new GroupShape(selectedShapeList);
        tmp.isSelected = true;
        for (Shape s : selectedShapeList) {
            shapeList.remove(s);
        }
        shapeList.add(tmp);

        selectedShapeList.clear();
        selectedShapeList.add(tmp);

        for (Shape s : tmp.groupList) {
            System.out.println(s.shapeName);
        }
    }

    public void ungroupShape() {
        shapeList.remove(selectedShapeList.get(0)); // delete the group from shapeList
        for (Shape s : selectedShapeList.get(0).groupList) { // add group's shape to shapeList
            shapeList.add(s);
            selectedShapeList.add(s);
            s.isSelected = true;
        }
        selectedShapeList.remove(0);

    }
};