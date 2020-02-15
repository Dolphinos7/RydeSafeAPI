package com.example.demo;
/**
 * 
 * @author Bryan Wells
 * @version 2020.02.14
 *
 */

public class Ride {

    private static int rideNumber = 0;
    private String startLocation;
    private String endLocation;
    private int numPassengers;
    private User rideOwner;
    private int rideTime;
    private boolean isComplete;
    private User driver;
    private int rideId;
    
    /**
     * Creates a Ride object for a user
     * @param user
     *              The user who created the ride
     * @param startLocation
     *              Where the ride starts from
     * @param endLocation
     *              Where the ride ends
     * @param numPassengers
     *              Number of Passengers, including user
     * @param time
     *              Length of ride in minutes
     */
    public Ride(User user, String startLocation, String endLocation,
        int numPassengers, int time)
    {
        rideOwner = user;
        this.startLocation = startLocation;
        this.endLocation = endLocation;
        this.numPassengers = numPassengers;
        rideTime = time;
        rideId = rideNumber;
        rideNumber++;
    }
    
    public boolean getIsComplete() {
    	return isComplete;
    }
    
    public void setIsComplete(boolean bool) {
    	isComplete = bool;
    }
    
    //--------------------------------------------------------------
    
    /**
     * Returns the start location
     * @return string of the starting location
     */
    public String getStartLocation()
    {
        return startLocation;
    }
    
    /**
     * Changes the starting location of the ride
     * @param newLocation
     *              The new start location
     */
    public void setStartLocation(String newLocation)
    {
        startLocation = newLocation;
    }
    
    /**
     * Returns the end location of the ride
     * @return String of the end ride location
     */
    public String getEndLocation()
    {
        return endLocation;
    }
    
    /**
     * Changes the ending location of the ride
     */
    public void setEndLocation(String newLocation)
    {
        endLocation = newLocation;
    }
    
    /**
     * Returns the number of passengers
     * @return int of the number of passengers 
     */
    public int getNumPassengers()
    {
        return numPassengers;
    }
    
    
    /**
     * Changes the number of passengers
     * @param newNum 
     *          The new number of passengers
     */
    public void setNumPassengers(int newNum)
    {
        numPassengers = newNum;
    }
    
    /**
     * Returns the user who created the ride
     * @return An User object who created the ride
     */
    public User getUser()
    {
        return rideOwner;
    }
    
    /**
     * Returns how long the ride is
     * @return
     *          int of the ride time
     */
    public int getRideTime()
    {
        return rideTime;
    }
    
    /**
     * Changes the how long the ride is
     * @param newTime
     *              The new length of time for the ride
     */
    public void setRideTime(int newTime)
    {
        rideTime = newTime;
    }
    
    /**
     * Sets who the driver for the ride is
     * @param newDriver
     *              The driver 
     */
    public void setDriver(User newDriver)
    {
        driver = newDriver;
    }
    
    /**
     * Returns the driver for the ride
     * @return
     *          The driver as a User
     */
    public User getDriver()
    {
        return driver;
    }
    
    /**
     * Returns the ride Id
     * @return
     *          Returns an int for the ride id
     */
    public int getRideId()
    {
        return rideId;
    }

} 
