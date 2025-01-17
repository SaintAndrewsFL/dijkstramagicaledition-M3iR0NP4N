public class HogwartsGraph extends Graph {
    public HogwartsGraph() {
        initializeLocations();
    }

    private void initializeLocations() {
        // Add all vertices (locations)
        addVertex("Astronomy Tower");
        addVertex("Gryffindor Tower");
        addVertex("Great Hall");
        addVertex("Library");
        addVertex("Hospital Wing");
        addVertex("Transfiguration");
        addVertex("Dungeons");
        addVertex("Quidditch Pitch");
        addVertex("Hagrid's Hut");
        addVertex("Forbidden Forest");
        // Add edges with distances (in arbitrary units)
        // Main Castle Connections
        addEdge("Astronomy Tower", "Library", 7);
        addEdge("Astronomy Tower", "Gryffindor Tower", 6);
        addEdge("Gryffindor Tower", "Great Hall", 5);
        addEdge("Great Hall", "Transfiguration", 3);
        addEdge("Great Hall", "Hospital Wing", 4);
        addEdge("Great Hall", "Library", 10);
        addEdge("Library", "Hospital Wing", 4);
        addEdge("Library", "Dungeons", 4);
        addEdge("Hospital Wing", "Transfiguration", 6);
        addEdge("Dungeons", "Quidditch Pitch", 7);
        addEdge("Quidditch Pitch", "Hagrid's Hut", 5);
        addEdge("Quidditch Pitch", "Forbidden Forest", 7);
        addEdge("Hagrid's Hut", "Forbidden Forest", 3);
        addEdge("Hospital Wing", "Dungeons", 4);
        addEdge("Library", "Quidditch Pitch", 7);
    }

    public static String getLocationDescription(String location) {
        switch (location) {
            case "Astronomy Tower":
                return "The highest tower in Hogwarts, used for Astronomy classes.";
            case "Gryffindor Tower":
                return "Home to the Gryffindor common room.";
            case "Great Hall":
                return "The central dining area and main gathering hall.";
            case "Library":
                return "A vast collection of books for study and research.";
            case "Hospital Wing":
                return "A place where students recover from injuries and illnesses.";
            case "Transfiguration":
                return "The classroom for Transfiguration lessons.";
            case "Dungeons":
                return "Dark and damp corridors, home to the Potions classroom.";
            case "Quidditch Pitch":
                return "The field where Quidditch matches are held.";
            case "Hagrid's Hut":
                return "The home of Hagrid, located on the edge of the Forbidden Forest.";
            case "Forbidden Forest":
                return "A mysterious and dangerous forest, home to magical creatures.";
            default:
                return "Unknown location.";
        }
    }
}