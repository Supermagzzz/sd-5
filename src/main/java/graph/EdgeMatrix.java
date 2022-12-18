package graph;

import graphics.DrawingApi;
import graphics.Properties;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EdgeMatrix extends Graph {
    private final boolean[][] edges;

    public EdgeMatrix(DrawingApi drawingApi) {
        super(drawingApi);

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        verticesNumber = n;
        if (n < 0) {
            throw new IllegalArgumentException("Number of vertices should be positive");
        }
        edges = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int x = scanner.nextInt();
                if (x != 0 && x != 1) {
                    throw new IllegalArgumentException("Invalid edges count");
                }
                edges[i][j] = x == 1;
            }
        }
    }

    @Override
    public void drawGraph() {
        for (int i = 0; i < verticesNumber; i++) {
            drawingApi.drawCircle(getVertexX(i), getVertexY(i), Properties.VERTEX_RADIUS);
        }
        for (int i = 0; i < verticesNumber; i++) {
            for (int j = 0; j < verticesNumber; j++) {
                if (edges[i][j]) {
                    drawingApi.drawLine(
                            getVertexX(i), getVertexY(i),
                            getVertexX(j), getVertexY(j)
                    );
                }
            }
        }
        drawingApi.draw();
    }
}
