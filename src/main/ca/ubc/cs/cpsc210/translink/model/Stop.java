package ca.ubc.cs.cpsc210.translink.model;

import ca.ubc.cs.cpsc210.translink.model.exception.RouteException;
import ca.ubc.cs.cpsc210.translink.util.LatLon;

import java.util.*;

/**
 * Represents a bus stop with an number, name, location (lat/lon)
 * set of routes which stop at this stop, list of buses that pass
 * through this stop and a list of arrivals.
 */
// TODO: Task 2: Complete all the methods of this class

public class Stop implements Iterable<Arrival> {
    private List<Arrival> arrivals;
    private Set<Route> routes;
    private int number;
    private String name;
    private LatLon locn;
    private List<Bus> buses;

    /**
     * Constructs a stop with given number, name and location.
     * Set of routes and list of arrivals are empty.
     *
     * @param number the number of this stop
     * @param name   name of this stop
     * @param locn   location of this stop
     */
    public Stop(int number, String name, LatLon locn) {
        arrivals = new ArrayList<>();
        routes = new HashSet<>();
        buses = new ArrayList<>();
        this.number = number;
        this.name = name;
        this.locn = locn;
    }

    /**
     * getter for name
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * getter for locn
     *
     * @return the location
     */
    public LatLon getLocn() {
        return locn;
    }

    /**
     * getter for number
     *
     * @return the number
     */
    public int getNumber() {
        return number;
    }

    /**
     * getter for set of routes
     *
     * @return an unmodifiable set of routes using this stop
     */
    public Set<Route> getRoutes() {
        return Collections.unmodifiableSet(routes);
    }

    /**
     * Add route to set of routes with stops at this stop.
     *
     * @param route the route to add
     */
    public void addRoute(Route route) {
        if (!routes.contains(route)) {
            routes.add(route);

            route.addStop(this);
        }
    }

    /**
     * Remove route from set of routes with stops at this stop
     *
     * @param route the route to remove
     */
    public void removeRoute(Route route) {
        if (routes.contains(route)) {
            routes.remove(route);
            route.removeStop(this);
        }
    }

    /**
     * Determine if this stop is on a given route
     *
     * @param route the route
     * @return true if this stop is on given route
     */
    public boolean onRoute(Route route) {
        return route.hasStop(this);
    }

    /**
     * Add bus arrival travelling on a particular route at this stop.
     * Arrivals are to be sorted in order by arrival time
     *
     * @param arrival the bus arrival to add to stop
     */
    public void addArrival(Arrival arrival) {
        arrivals.add(arrival);
        Collections.sort(arrivals);
    }

    /**
     * Remove all arrivals from this stop
     */
    public void clearArrivals() {
        arrivals.clear();
    }

    /**
     * Adds bus that is on a route passing through this stop
     *
     * @param bus bus to add
     * @throws RouteException if bus is not on a route on which this stop lies
     */
    public void addBus(Bus bus) throws RouteException {
        if (!onRoute(bus.getRoute()))
            throw new RouteException("Bus is not on a route on which this stop lies");

        buses.add(bus);

    }

    /**
     * Get unmodifiable list of buses on routes serving this stop
     *
     * @return unmodifiable list of buses
     */
    public List<Bus> getBuses() {
        return Collections.unmodifiableList(buses);
    }

    /**
     * Clear all buses from this stop
     */
    public void clearBuses() {
        buses.clear();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Stop arrivals = (Stop) o;

        return number == arrivals.number;
    }

    @Override
    public int hashCode() {
        return number;
    }

    @Override
    public Iterator<Arrival> iterator() {
        // Do not modify the implementation of this method!
        return arrivals.iterator();
    }

    /**
     * setter for name
     *
     * @param name the new name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * setter for location
     *
     * @param locn the new location
     */
    public void setLocn(LatLon locn) {
        this.locn = locn;
    }
}
