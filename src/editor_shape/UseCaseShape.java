package editor_shape;

import java.awt.*;

public class UseCaseShape extends Shape {
    Color myGray = new Color(200, 200, 200);

    public UseCaseShape(Point p) {
        x1 = p.x;
        y1 = p.y;
        width = 150;
        height = 100;
        shapeName = "Object Name";
        addPort();
    }

    @Override
    public void draw(Graphics2D g2) {
        g2.setColor(myGray);
        g2.fillOval(x1, y1, width, height);
        g2.setColor(Color.BLACK);
        g2.drawOval(x1, y1, width, height);
        g2.drawString(shapeName, x1 + (width - shapeName.length() * 6) / 2, y1 + 55);
    }
}
