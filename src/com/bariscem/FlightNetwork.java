//
//  TransactionsViewCell.swift
//  com.bariscem;//
//  Created by cembaykara on 2019-12-03.
//  Copyright © 2018 cembaykara. All rights reserved.
//

package com.bariscem;

import java.util.*;

/** FlightNetwork represents a graph of Airports as vertices
 * and Flights as edges.
 */
class FlightNetwork {

    private String name;
    public Map<String, Airport> network = new HashMap<>();


    /**
     * Applies dijkstra's algorithm from specified airport to
     * it's connected routes and assigns duration.
     */
    public void calculateRoutes(String airport){

        Airport start = network.get(airport);
        start.minimumDistance = 0.;
        PriorityQueue<Airport> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(start);

        while (!priorityQueue.isEmpty()){
            Airport current = priorityQueue.poll();

            for (Flight flight : current.flights) {
                Airport destination = flight.getDestination();
                double duration = flight.getFlightDuration();
                double distance = current.minimumDistance + duration;

                if (distance < destination.minimumDistance){
                    priorityQueue.remove(current);
                    destination.minimumDistance = distance;
                    destination.previous = current;
                    priorityQueue.add(destination);
                }
            }

        }
    }

    /**
     * Gets the shortest path from airport to airport
     * Uses Dijkstra's algorithm.
     * @param fromAirport starting airport code
     * @param toAirport destination airport code
     * @return ordered list of airports to follow
     */
    public List<Airport> getShortestPath(String fromAirport, String toAirport){

        Airport away;
        away = network.get(toAirport);

        calculateRoutes(fromAirport);
        List<Airport> path = new ArrayList<>();

        for (Airport airport = away; airport != null; airport = airport.previous)
            path.add(airport);

        Collections.reverse(path);
        return path;
    }

    FlightNetwork(String name){
        this.name = name;
        createFlightNetwork();
    }


    /**
     * Creates a predefined flight network
     */
    public void createFlightNetwork(){

        String[] airports = {"JFK","IST","TLL", "CHG", "RIX", "CND"};

        for (String airport : airports) {
            network.put(airport, new Airport(airport));
        }


        Airport ist = network.get("IST");
        Flight a = new Flight(ist, 3.15, "THY112");
        Flight b = new Flight(ist, 0.45, "THY111");
        Flight c = new Flight(ist, 18., "THY113");

        Airport cnd = network.get("CND");
        Flight d = new Flight(cnd, 0.45, "THY111");

        Airport rix = network.get("RIX");
        Flight e = new Flight(rix, 2, "LFT879");
        Flight f = new Flight(rix, 2.45, "THY114");

        Airport tll = network.get("TLL");
        Flight g = new Flight(tll, 0.30, "LTO3452");
        Flight h = new Flight(tll, 3.15, "THY112");

        Airport chg = network.get("CHG");
        Flight i = new Flight(chg, 18., "THY113");
        Flight j = new Flight(chg, 4., "AA376");

        Airport jfk = network.get("JFK");
        Flight k = new Flight(jfk, 4., "AA376");

        //IST FLIGHTS
        ist.addFlights(d, f, h, i);

        //CND FLIGHTS
        cnd.addFlights(b, e);

        //RIX FLIGHTS
        rix.addFlights(g);

        //TLL FLIGHTS
        tll.addFlights(a);

        //CHG FLIGHTS
        chg.addFlights(c, k);

        //JFK FLIGHTS
        jfk.addFlights(j);
    }


    @Override
    public String toString() {
        return "" + network.values();
    }
}
