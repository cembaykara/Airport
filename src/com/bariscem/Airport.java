//
//  TransactionsViewCell.swift
//  com.bariscem;//
//  Created by cembaykara on 2019-12-03.
//  Copyright © 2018 cembaykara. All rights reserved.
//

package com.bariscem;

import java.util.LinkedList;

/** Airport represents a vertex on a graph with
 * outgoing edges as flights.
 */
class Airport implements Comparable<Airport> {

    public final String name;
    public LinkedList<Flight> flights = new LinkedList<>();
    public double minimumDistance = Double.POSITIVE_INFINITY;
    public Airport previous;


    Airport (String name){
        this.name = name;
    }

    public void addFlights(Flight... flight){
        for (Flight f : flight) {
            flights.add(f);
        }
    }

    @Override
    public String toString() {
        return  name +
                flights +
                '\n';
    }

    @Override
    public int compareTo(Airport o) {
        return Double.compare(minimumDistance,  o.minimumDistance);
    }
}
