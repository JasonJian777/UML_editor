package editor_mode;

import java.awt.event.MouseEvent;
import java.awt.Point;
import editor_main.*;

public class BaseObjMode {
    protected Canvas canvas = Canvas.getInstance();
    protected Point startPoint, endPoint;

    public void myMousePressed(MouseEvent e) {
    }

    public void myMouseReleased(MouseEvent e) {
    }

    // public void myMouseClicked(MouseEvent e){
    // }
    public String re() {
        return "Base Obj Mode";
    }

    public int pressInWhichShape(Point p) {
        for (int i = canvas.getShapeList().size() - 1; i >= 0; i--) { // last shape in list have lowest depth
            if (canvas.getShapeList().get(i).isPointInShape(p)) {
                return i;
            }
        }
        return -1;
    }

}