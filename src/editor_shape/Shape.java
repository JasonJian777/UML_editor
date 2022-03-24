package editor_shape;

import java.awt.Graphics2D;
import java.awt.Point;
import java.util.List;
import java.util.ArrayList;

public abstract class Shape {
    public int x1, y1;
    public boolean isSelected = false;
    public List<Port> portList = new ArrayList<>();
    public String shapeName;
    int depth;
    int width, height;
    public boolean isGroup = false;
    public List<Shape> groupList = null;

    public abstract void draw(Graphics2D g);

    public void drawPort(Graphics2D g) {
        for (int i = 0; i < 4; i++) {
            portList.get(i).portDraw(g);
        }
    }

    public void addPort() {
        portList.add(new Port(new Point(x1 + width / 2, y1)));
        portList.add(new Port(new Point(x1, y1 + height / 2)));
        portList.add(new Port(new Point(x1 + width, y1 + height / 2)));
        portList.add(new Port(new Point(x1 + width / 2, y1 + height)));
    }

    public List<Port> getPortList() {
        return portList;
    }

    public Port findNearestPort(Point p) {
        double min = 99999;
        Port port = null;
        for (int i = 0; i < 4; i++) {
            if (min > dis(portList.get(i).p, p)) {
                min = dis(portList.get(i).p, p);
                port = portList.get(i);
            }
        }
        return port;
    }

    public double dis(Point p1, Point p2) {
        double d = Math.sqrt((p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y));
        return d;
    }

    public void setSelected(boolean set) {
        isSelected = set;
    }

    public void shapeMove(int x, int y) {
        x1 += x;
        y1 += y;
        for (Port p : portList) {
            p.move(x, y);
        }
    }

    public boolean isShapeInDragRect(Point p1, Point p2) { // when drag a rectabgle, this shape inside the retangle
        if (p1.x <= x1 && p1.y <= y1 && p2.x >= x1 + width && p2.y >= y1 + height)
            return true;
        return false;
    }

    public boolean isPointInShape(Point p) { // Point inside this shape?
        if (p.x > x1 && p.y > y1 && p.x <= x1 + width && p.y <= y1 + height)
            return true;
        return false;
    }

    public void setShapeName(String name) {
        shapeName = name;

    }

    public List<Shape> getGroupList() {
        return null;
    }

    public List<Shape> getAllGroupShape() {
        List<Shape> tmp = new ArrayList<>();
        // System.out.println(shapeName);
        tmp.add(this);
        return tmp;
    }

}
