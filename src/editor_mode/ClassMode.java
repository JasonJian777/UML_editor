package editor_mode;

import java.awt.event.MouseEvent;
import editor_main.Canvas;
import editor_shape.ClassShape;
import editor_shape.Shape;

public class ClassMode extends BaseObjMode {
    @Override
    public void myMouseReleased(MouseEvent e) {
        Shape newShape = new ClassShape(e.getPoint());
        Canvas.getInstance().getShapeList().add(newShape);
    }

    @Override
    public String re() {
        return "Class Mode";
    }
}
