package graph;

import graphics.DrawingApi;
import graphics.Properties;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EdgeList extends Graph {
    private final List<Edge> edges = new ArrayList<>();

    public EdgeList(DrawingApi drawingApi) {
        super(drawingApi);

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), m = scanner.nextInt();
        verticesNumber = n;
        if (n < 0 || m < 0) {
            throw new IllegalArgumentException("Number of vertices and edges should be positive");
        }
        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt(), b = scanner.nextInt();
            if (a < 1 || a > verticesNumber || b < 1 || b > verticesNumber) {
                throw new IllegalArgumentException("Vertex index should be in [1, n]");
            }
            edges.add(new Edge(a, b));
        }
    }

    @Override
    public void drawGraph() {
        for (int i = 0; i < verticesNumber; i++) {
            drawingApi.drawCircle(getVertexX(i), getVertexY(i), Properties.VERTEX_RADIUS);
        }
        for (Edge edge : edges) {
            drawingApi.drawLine(
                getVertexX(edge.a), getVertexY(edge.a),
                getVertexX(edge.b), getVertexY(edge.b)
            );
        }
        drawingApi.draw();
    }

    public record Edge(int a, int b) {}
}
