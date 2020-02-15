package com.example.demo;

/**
 * 
 * @author Benjamin Bernstein (neberizer)
 * 
 *
 */
import java.util.LinkedList;

public class RideList {
	private LinkedList<Ride> rideList;
	
	public LinkedList getList() {
		return rideList;
	}
	/**
	 * Initializes the RideList as new linked list
	 */
	public RideList() {
		rideList = new LinkedList<Ride>();
	}

	/**
	 * Adds a ride to the RideList
	 * 
	 * @param ride the ride to add
	 */
	public boolean addRide(Ride ride) {
		return rideList.add(ride);
	}
	
	/**
	 * Removes a ride from ride list 
	 * @param ride The ride in the list to remove
	 * @return true if successful, false if fails
	 */
	public boolean removeRide(Ride ride) {
		return rideList.remove(ride);
	}
	
	/**
	 * Returns the ride at the top of the list
	 * @return the ride
	 */
	public Ride getNextRide() {
		return rideList.get(0);
	}
	
	/**
	 * Returns a ride searched for by user
	 * @param user the user to search for the ride by
	 * @return The ride that user created
	 */
	public Ride getRide(User user) {
		for (int i = 0; i < rideList.size(); i++) {
			if (rideList.get(i).getUser().equals(user)) {
				return rideList.get(i);
			}
		}
		return null;
	}
	
	public Ride getLowestRideId() 
	{
	    Ride ride = rideList.get(0);
	    int id = ride.getRideId();
	    for (int i = 0; i < rideList.size(); i++)
	    {
	        Ride rideTemp = rideList.get(i);
	        if (rideTemp.getRideId() < id)
	        {
	            id = rideTemp.getRideId();
	            ride = rideTemp;
	        }
	    }
        return ride;
    }

}
