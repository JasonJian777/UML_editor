package editor_mode;

import java.awt.event.MouseEvent;
import editor_main.Canvas;
import editor_shape.Shape;
import editor_shape.UseCaseShape;

public class UseCaseMode extends BaseObjMode {
    @Override
    public void myMouseReleased(MouseEvent e) {
        Shape newShape = new UseCaseShape(e.getPoint());
        Canvas.getInstance().getShapeList().add(newShape);
    }

    @Override
    public String re() {
        return "Use Case Mode";
    }
}
