package editor_line;

import java.awt.Graphics2D;
import editor_shape.*;

public class CompositionLine extends Line {
    public CompositionLine(Port sp, Port ep) {
        super(sp, ep);
    }

    @Override
    public void lineDraw(Graphics2D g) {
        drawEmptyRect(g);
    }

    public void drawEmptyRect(Graphics2D g) {
        // draw the triangle
        double angle = Math.atan(1);
        double arr1[] = rotateVec(endPoint.x - startPoint.x, endPoint.y - startPoint.y, angle);
        double arr2[] = rotateVec(endPoint.x - startPoint.x, endPoint.y - startPoint.y, -angle);
        g.drawLine((int) (endPoint.x - arr1[0]), (int) (endPoint.y - arr1[1]), endPoint.x, endPoint.y);
        g.drawLine((int) (endPoint.x - arr2[0]), (int) (endPoint.y - arr2[1]), endPoint.x, endPoint.y);

        // let line shorter so that it can't cover the triangle
        double lineLength = Math.sqrt((endPoint.x - startPoint.x) * (endPoint.x - startPoint.x)
                + (endPoint.y - startPoint.y) * (endPoint.y - startPoint.y));
        double cut = Math.sqrt(arr1[0] * arr1[0] + arr1[1] * arr1[1]) * Math.cos(angle) * 2;
        double ratio = (lineLength - cut) / lineLength;

        double newLineX = (endPoint.x - startPoint.x) * ratio + startPoint.x;
        double newLineY = (endPoint.y - startPoint.y) * ratio + startPoint.y;
        g.drawLine(startPort.p.x, startPort.p.y, (int) newLineX, (int) newLineY);

        g.drawLine((int) (endPoint.x - arr1[0]), (int) (endPoint.y - arr1[1]), (int) newLineX, (int) newLineY);
        g.drawLine((int) (endPoint.x - arr2[0]), (int) (endPoint.y - arr2[1]), (int) newLineX, (int) newLineY);

    }
}
