package com.example.demo;
/**
 * This class manages the waiting, in progress, and finished ride lists. Think
 * of it as the dispatcher.
 * 
 * @author rgniadek
 * @author Benjamin Bernstein
 *
 */
import java.util.List;
import java.util.ArrayList;
public class RideManager {
	private RideList waitingRides;
	private RideList activeRides;
	private RideList finishedRides;
	private List<User> users;

	/**
	 * Constructs a new ride manager and the inner lists.
	 */
	public RideManager() {
		waitingRides = new RideList();
		activeRides = new RideList();
		finishedRides = new RideList();
		users = new ArrayList<User>();
	}

	/**
	 * Adds specified ride to queue if user has no other ride alreayd in queue
	 * 
	 * @param ride
	 * @return
	 *         boolean for if ride was added
	 */
	public boolean addToQueue(Ride ride) {
	    User user = ride.getUser();
	    if ((user != null) && (waitingRides.getRide(user) == null) &&(activeRides.getRide(user) == null))
	    {
	        return waitingRides.addRide(ride);
	    }
	    return false;
	}

	/**
	 * Searches the list for finished rides and moves them to finished ride list
	 * @param user the user who's ride is finished
	 * @return true if ride was found and moved to finished
	 */
	public boolean markRideFinished(User user) {
		if (activeRides.getRide(user) != null) {
			activeRides.getRide(user).setIsComplete(true);
			checkForFinishedRides();
			return true;
		}
		return false;
	}

	/**
	 * If the ride specified by paramter ride exists in the waiting rides queue it
	 * will move it to active ride
	 */
	public boolean moveToActive(Ride ride) {
		boolean found = waitingRides.removeRide(ride);
		if (found)
			activeRides.addRide(ride);
		return found;
	}

	/**
	 * If specified ride is found in active rides, move it to finished ride
	 * 
	 * @param ride
	 * @return
	 */
	public boolean moveToFinished(Ride ride) {
		boolean found = activeRides.removeRide(ride);
		if (found)
			finishedRides.addRide(ride);
		return found;
	}

	/**
	 * Puts the top ride in the queue into active rides
	 * @return true if the waitingRides list wasn't empty and ride
	 * was added successfully
	 */
	public boolean getNextRide() {
		if (waitingRides.getList().isEmpty()) {
			return false;
		}
		moveToActive(waitingRides.getLowestRideId());
		return true;
	}

	/**
	 * Checks the active rides list for any finished rides
	 * and moves them to the appropriate list
	 * @return true if it moved at least 1 ride to the finished
	 * list
	 */
	public boolean checkForFinishedRides() {
		boolean toReturn = false;
		for (int i = 0; i < activeRides.getList().size(); i++) {
			Ride tempRide = (Ride) activeRides.getList().get(i);
			if (tempRide.getIsComplete()) {
				toReturn = true;
				moveToFinished(tempRide);
			}
		}
		return toReturn;
	}
	
	
	//--------------------------------------------------------------------------
	// These are to be called by the driver or user through the API
	/**
	 * Cancels a ride from waiting or active list. Sent by user to cancel own ride
	 * @param user
	 * @return
	 *         boolean representing if ride was canceled
	 */
	public boolean cancelRide(User user)
	{
	    Ride ride = waitingRides.getRide(user);
	    if (ride == null)
	    {
	        ride = activeRides.getRide(user);
	    }
	    else
	    {
	        return waitingRides.removeRide(ride);
	    }
	    if (ride == null)
	    {
	        return false;
	    }
	    else
	    {
	        return activeRides.removeRide(ride);
	    }
	    
	}
	
	/**
	 * Allows driver to request the next ride
	 * @param user The driver who requested the next ride
	 * @return
	 *         Returns the next ride in the queue and moves it to active
	 */
	public Ride nextRide(User user)
	{
	    if (getNextRide())
	    {
	        Ride ride = (Ride) activeRides.getList().get(activeRides.getList().size());
	        ride.setDriver(user);
	        return ride;
	    }
	    else
	    {
	        return null;
	    }
	}
	/**
	 * Toggles the user between driver and passenger
	 * @param user The user making the toggle request
	 * @return
	 *            Boolean true if is driver, boolean false if passenger
	 */
	public boolean toggleDrivePassenger(User user)
	{
	    if (user.getIsDriver())
	    {
	        return user.setIsDriver(false);
	    }
	    else
	    {
	        return user.setIsDriver(true);
	    }
	}
	
	/**
	 * Adds a user to the list of users in this ride group
	 * @param personID Name
	 * @param phoneNum Phone number
	 * @return
	 *         returns the user as a User
	 */
	public User makeNewUser(String personID, String phoneNum)
	{
	    User user = new User (false, personID, phoneNum);
	    if (users.isEmpty() || !users.contains(user))
	    {
	        users.add(user);
	        return user;
	    }
	    else
	    {
	        int index = users.indexOf(user);
	        return users.get(index);
	    }
	}

}
