package graph;

import graphics.DrawingApi;

public abstract class Graph {
    protected final DrawingApi drawingApi;
    protected int verticesNumber;

    public Graph(DrawingApi drawingApi) {
        this.drawingApi = drawingApi;
    }

    protected double getVertexX(int number) {
        double angle = Math.PI * 2 * number / verticesNumber;
        double x = Math.cos(angle);
        return (x + 1.5) / 3 * drawingApi.getDrawingAreaWidth();
    }

    protected double getVertexY(int number) {
        double angle = Math.PI * 2 * number / verticesNumber;
        double x = Math.sin(angle);
        return (x + 1.5) / 3 * drawingApi.getDrawingAreaHeight();
    }

    public abstract void drawGraph() throws Exception;
}
