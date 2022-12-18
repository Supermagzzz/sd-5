package graphics.awt;

import graphics.DrawingApi;
import graphics.Properties;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.List;

public class DrawingAwt extends Frame implements DrawingApi {
    private final List<Shape> circles = new ArrayList<>();
    private final List<Shape> lines = new ArrayList<>();

    public DrawingAwt() {
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
        this.setSize(Properties.APPLICATION_WIDTH, Properties.APPLICATION_HEIGHT);
        this.setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D ga = (Graphics2D)g;
        ga.setPaint(Color.black);
        for (Shape shape : circles) {
            ga.fill(shape);
        }
        for (Shape shape : lines) {
            ga.draw(shape);
        }
    }

    @Override
    public long getDrawingAreaWidth() {
        return Properties.APPLICATION_WIDTH;
    }

    @Override
    public long getDrawingAreaHeight() {
        return Properties.APPLICATION_HEIGHT;
    }

    @Override
    public void drawCircle(double x, double y, double radius) {
        circles.add(new Ellipse2D.Double(x - radius / 2, y - radius / 2, radius, radius));
    }

    @Override
    public void drawLine(double x1, double y1, double x2, double y2) {
        lines.add(new Line2D.Double(x1, y1, x2, y2));
    }

    @Override
    public void draw() {
        super.repaint();
    }
}
