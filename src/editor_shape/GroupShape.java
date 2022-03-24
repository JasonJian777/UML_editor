package editor_shape;

import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class GroupShape extends Shape {
    public GroupShape(List<Shape> ss) {
        isGroup = true;
        groupList = new ArrayList<>();
        for (Shape s : ss) {
            groupList.add(s);
        }

        shapeName = ss.get(0).shapeName;
        for (int i = 1; i < ss.size(); i++) {
            shapeName += ", ";
            shapeName += ss.get(i).shapeName;
        }
        shapeName += ".";
    }

    @Override
    public void draw(Graphics2D g) {
        for (Shape s : groupList) {
            s.setSelected(isSelected);
            s.draw(g);
        }
    }

    @Override
    public void drawPort(Graphics2D g) {
        for (Shape s : groupList) {
            s.drawPort(g);
        }
    }

    @Override
    public boolean isShapeInDragRect(Point p1, Point p2) {
        boolean ans = true;
        for (Shape s : groupList) {
            ans = s.isShapeInDragRect(p1, p2);
            // System.out.println("test");
            if (!ans)
                return false;
        }
        return ans;
    }

    @Override
    public boolean isPointInShape(Point p) {
        boolean ans = false;
        for (Shape s : groupList) {
            ans = s.isPointInShape(p);
            if (ans)
                return true;
        }
        return false;
    }

    @Override
    public List<Shape> getAllGroupShape() {
        List<Shape> tmp = new ArrayList<>();

        for (Shape s : groupList) {
            tmp.addAll(s.getAllGroupShape());
            s.getAllGroupShape();
        }
        return tmp;
    }

    @Override
    public void shapeMove(int x, int y) {
        for (Shape s : groupList) {
            s.shapeMove(x, y);
        }
        System.out.println();
    }
}
