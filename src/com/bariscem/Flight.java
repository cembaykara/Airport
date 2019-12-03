//
//  TransactionsViewCell.swift
//  com.bariscem;//
//  Created by cembaykara on 2019-12-03.
//  Copyright © 2018 cembaykara. All rights reserved.
//

package com.bariscem;

/** Flight represents an edge on a graph with
 * a target vertex as an airport.
 */
class Flight {

    private final String flightName;
    private final Airport destination;
    private final double flightDuration;

    Flight(Airport destination, double flightDuration, String flightName){
        this.destination = destination;
        this.flightDuration = flightDuration;
        this.flightName = flightName;
    }

    public Airport getDestination() {
        return destination;
    }

    public double getFlightDuration() {
        return flightDuration;
    }

    @Override
    public String toString() {
        return " " + flightName + "-> " +
               destination.name + " " +
                flightDuration + 'h';
    }
}
