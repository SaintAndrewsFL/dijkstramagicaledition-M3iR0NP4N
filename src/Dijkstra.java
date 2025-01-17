import java.util.*;

public class Dijkstra {
    private final Graph graph;

    public Dijkstra(Graph graph) {
        this.graph = graph;
    }

    /**
     * Implements Dijkstra's algorithm to find the shortest path between two vertices.
     * @param start The starting vertex
     * @param target The destination vertex
     * @return A string in the format "Path (distance): vertex1 -> vertex2 -> ... -> vertexN"
     *         Returns "No path exists between start and target" if no path is found
     *         Returns "Invalid vertex" if either vertex is not in the graph
     */
    public String findShortestPath(String start, String target) {
        // TODO: Implement Dijkstra's algorithm here
        // The graph provides the following methods you can use:
        // graph.getVertices() - returns Set<String> of all vertices
        // graph.getNeighbors(vertex) - returns Map<String, Integer> of neighbor vertices and their weights
        // graph.hasVertex(vertex) - returns boolean indicating if vertex exists
        if (!graph.hasVertex(start) || !graph.hasVertex(target)) return "Invalid vertex";
        Map<String, Integer> distances = new HashMap<>();
        Map<String, String> previous = new HashMap<>();
        PriorityQueue<LocationCard> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(LocationCard::getDistance));
        Set<String> visited = new HashSet<>();

        for (String vertex : graph.getVertices()) distances.put(vertex, Integer.MAX_VALUE);
        distances.put(start, 0);
        priorityQueue.add(new LocationCard(start, 0));

        while (!priorityQueue.isEmpty()) {
            LocationCard currentCard = priorityQueue.poll();
            String current = currentCard.getLocation();

            if (!visited.add(current)) continue;
            if (current.equals(target)) return constructPath(previous, target, distances.get(target));

            for (Map.Entry<String, Integer> neighbor : graph.getNeighbors(current).entrySet()) {
                String neighborVertex = neighbor.getKey();
                int edgeWeight = neighbor.getValue();

                if (visited.contains(neighborVertex)) continue;

                int newDist = distances.get(current) + edgeWeight;
                if (newDist < distances.get(neighborVertex)) {
                    distances.put(neighborVertex, newDist);
                    previous.put(neighborVertex, current);
                    priorityQueue.add(new LocationCard(neighborVertex, newDist));
                }
            }
        }

        return "No path exists between start and target";
    }

    private String constructPath(Map<String, String> previous, String target, int distance) {
        LinkedList<String> path = new LinkedList<>();
        String current = target;
        while (current != null) {
            path.addFirst(current);
            current = previous.get(current);
        }
        return "Path (" + distance + "): " + String.join(" -> ", path);
    }
}
