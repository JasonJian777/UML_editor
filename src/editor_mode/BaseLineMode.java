package editor_mode;

import java.awt.event.MouseEvent;
import editor_shape.*;

public class BaseLineMode extends BaseObjMode {
    public Shape startShape = null, endShape = null;
    public Port startPort = null, endPort = null;

    @Override
    public void myMousePressed(MouseEvent e) {
        // System.out.println(Integer.toString(inWhichShape(e.getPoint())));
        startShape = null;
        startPoint = e.getPoint();
        int shapeIdx = pressInWhichShape(e.getPoint());
        if (shapeIdx != -1) {
            startShape = canvas.getShapeList().get(shapeIdx);
            if (!startShape.isGroup) {
                startPort = startShape.findNearestPort(startPoint);
                canvas.setShowPort(startPort);
            } else {
                startShape = null;
                shapeIdx = -1;
            }
        }
    }

    @Override
    public void myMouseReleased(MouseEvent e) {
        // System.out.println("mouseReleased2");
        endShape = null;
        endPoint = e.getPoint();
        int shapeIdx = pressInWhichShape(e.getPoint());
        if (shapeIdx != -1 && startShape != null) {
            endShape = canvas.getShapeList().get(shapeIdx);
            if (endShape.isGroup) {
                shapeIdx = -1;
                endShape = null;
            } else if (!startShape.equals(endShape)) {
                endPort = endShape.findNearestPort(endPoint);
            }
        }
        // System.out.println(Integer.toString(shapeIdx));
    }

    // @Override
    // public void myMouseClicked(MouseEvent e) {
    // // System.out.println("mouseClicked2");
    // }

    @Override
    public String re() {
        return "Base Line Mode";
    }

    public boolean canCreatLine() {
        if (startShape == null || endShape == null || startShape.equals(endShape))
            return false;
        startPort = startShape.findNearestPort(startPoint);
        endPort = endShape.findNearestPort(endPoint);
        return true;
    }

}
