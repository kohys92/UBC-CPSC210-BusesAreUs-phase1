package ca.ubc.cs.cpsc210.translink.model;

import ca.ubc.cs.cpsc210.translink.util.LatLon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A description of one pattern of a route
 * Each pattern has a name, destination, direction, list of points (of class LatLon), and Route
 */

// TODO: Task 2: Complete all the methods in this class

public class RoutePattern {

    private String name;
    private String destination;
    private String direction;
    private Route route;
    private List<LatLon> path;

    /**
     * Construct a new RoutePattern with the given information
     * @param name          the name of the pattern
     * @param destination   the destination
     * @param direction     the direction
     * @param route         the Route of which this is a pattern
     */
    public RoutePattern(String name, String destination, String direction, Route route) {
        this.name = name;
        this.destination = destination;
        this.direction = direction;
        this.route = route;
        path = new ArrayList<>();
    }

    /**
     * Get the pattern name
     * @return      the name
     */
    public String getName() {
        return name;
    }

    /**
     * Get the pattern destination
     * @return      the destination
     */
    public String getDestination() {
        return destination;
    }

    /**
     * Get the pattern direction
     * @return      the direction
     */
    public String getDirection() {
        return direction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RoutePattern that = (RoutePattern) o;

        return name != null ? name.equals(that.name) : that.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    /**
     * Set the pattern path: list of coordinates
     * @param path      the path
     */
    public void setPath(List<LatLon> path) {
        this.path = path;
    }

    /**
     * Return the list of coordinates making up this pattern
     *
     * @return      an unmodifiable list of the coordinates on this route pattern
     */
    public List<LatLon> getPath() {
        return Collections.unmodifiableList(path);
    }

    /**
     * Set the direction
     * @param direction     the direction
     */
    public void setDirection(String direction) {
        this.direction = direction;
    }

    /**
     * Set the destination
     * @param destination     the destination
     */
    public void setDestination(String destination) {
        this.destination = destination;
    }
}
