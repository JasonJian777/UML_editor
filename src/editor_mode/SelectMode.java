package editor_mode;

import java.awt.event.MouseEvent;
import editor_main.MenuBar;
import editor_shape.Shape;
import java.awt.Point;

public class SelectMode extends BaseObjMode {
    int idx;
    MenuBar menuBar = MenuBar.getInstance();

    public void myMousePressed(MouseEvent e) {
        // remPort();
        canvas.cleanSelected();
        startPoint = e.getPoint();
        idx = pressInWhichShape(startPoint);

        for (int i = 0; i < 3; i++) {
            menuBar.setMenuItem(i, false);
        }
    }

    public void myMouseReleased(MouseEvent e) {

        endPoint = e.getPoint();
        if (startPoint.equals(endPoint) && idx != -1) { // select a shape or a group
            Shape s = canvas.getShapeList().get(idx);
            s.setSelected(true);

            canvas.top(idx); // let shape go to top
            canvas.getSelectedShapeList().add(s);
            menuBar.setMenuItem(2, true);
            if (canvas.selectedShapeList.get(0).isGroup) { // is a group, can only ungroup
                menuBar.setMenuItem(1, true);
                menuBar.setMenuItem(2, false);

            }
        } else if (!startPoint.equals(endPoint)) { // drag
            int x = (int) (endPoint.getX() - startPoint.getX());
            int y = (int) (endPoint.getY() - startPoint.getY());
            if (idx != -1) { // shpae move
                Shape s = canvas.getShapeList().get(idx);
                s.shapeMove(x, y);
                canvas.top(idx); // let shape go to top
            } else { // select a lot of shape(include group)
                selectShapes();
                if (canvas.getSelectedShapeList().size() == 1) { // 1 shape, can rename
                    menuBar.setMenuItem(2, true);
                } else
                    menuBar.setMenuItem(0, true);
            }
        }
        System.out.println(canvas.selectedShapeList.size());
    }

    public String re() {
        return "Select Mode";
    }

    public void selectShapes() {
        Point[] p = rePoint();
        for (Shape s : canvas.getShapeList()) { // search all shape
            if (s.isShapeInDragRect(p[0], p[1])) {
                canvas.getSelectedShapeList().add(s);
            }
        }
    }

    public Point[] rePoint() { // return top left and bottom right point
        Point p1 = new Point(); // top left point

        int disX = Math.abs(startPoint.x - endPoint.x);
        int disY = Math.abs(startPoint.y - endPoint.y);
        if (startPoint.x < endPoint.x)
            p1.x = startPoint.x;
        else
            p1.x = endPoint.x;
        if (startPoint.y < endPoint.y)
            p1.y = startPoint.y;
        else
            p1.y = endPoint.y;
        Point p2 = new Point(p1.x + disX, p1.y + disY); // bottom right point

        return new Point[] { p1, p2 };
    }
}
