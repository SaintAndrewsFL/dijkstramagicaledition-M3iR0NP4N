public class LocationCard {
    private final String location;
    private final int distance;

    public LocationCard(String location, int distance) {
        this.location = location;
        this.distance = distance;
    }
    public String getLocation() {
        return location;
    }
    public int getDistance() {
        return distance;
    }
}
