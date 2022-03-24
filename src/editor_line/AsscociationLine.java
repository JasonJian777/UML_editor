package editor_line;

import java.awt.Graphics2D;
import editor_shape.*;

public class AsscociationLine extends Line {

    public AsscociationLine(Port sp, Port ep) {
        super(sp, ep);
    }

    @Override
    public void lineDraw(Graphics2D g) {
        super.lineDraw(g);
        drawArrow(g);
    }

    public void drawArrow(Graphics2D g) {
        double angle = Math.atan(5.0f / 8.0f);
        double arr1[] = rotateVec(endPoint.x - startPoint.x, endPoint.y - startPoint.y, angle);
        double arr2[] = rotateVec(endPoint.x - startPoint.x, endPoint.y - startPoint.y, -angle);
        g.drawLine((int) (endPoint.x - arr1[0]), (int) (endPoint.y - arr1[1]), endPoint.x, endPoint.y);
        g.drawLine((int) (endPoint.x - arr2[0]), (int) (endPoint.y - arr2[1]), endPoint.x, endPoint.y);

    }
}
