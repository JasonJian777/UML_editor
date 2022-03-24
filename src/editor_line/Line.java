package editor_line;

import java.awt.Point;
import java.awt.Graphics2D;
import editor_shape.*;

public class Line {
    public Point startPoint, endPoint;
    public Port startPort, endPort;

    public Line(Port sp, Port ep) {
        startPort = sp;
        endPort = ep;
        startPoint = sp.p;
        endPoint = ep.p;
    }

    public void lineDraw(Graphics2D g) {
        g.drawLine(startPort.p.x, startPort.p.y, endPort.p.x, endPort.p.y);
    }

    public double[] rotateVec(int px, int py, double angle) {
        double newX = px * Math.cos(angle) - py * Math.sin(angle);
        double newY = px * Math.sin(angle) + py * Math.cos(angle);
        double d = Math.sqrt(newX * newX + newY * newY);
        newX = newX / d * 15;
        newY = newY / d * 15;
        return new double[] { newX, newY };
    }
}
