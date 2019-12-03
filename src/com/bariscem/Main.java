package com.bariscem;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        FlightNetwork n = new FlightNetwork("network");
        System.out.println(n.toString());

        System.out.println("The shortest path is: ");
        List<Airport> shortestRoute = n.getShortestPath("RIX", "CND");

        for (Airport airport :
                shortestRoute) {
            System.out.println(airport.name);
        }

    }
}

