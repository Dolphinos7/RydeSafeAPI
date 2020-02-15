package com.example.demo;
/**
 * @author roningick
 * @version (2020-14-2)
 */

/*
 * Class that will manage the name / Phone number / isDriving 
 */
public class User 
{
	//~ Fields
	public boolean isDriver;
	public String name;
	public String phoneNumber;
	
	//~ Constructor
	
	/*
	 * User constructor that holds the information 
	 * @param driver: boolean if the user is a driver
	 * @param personID: string the user names 
	 * @param phoneNum: string the users phone number
	 */
	public User(Boolean driver, String personID, String phoneNum)
	{
		isDriver = driver;
		name = personID;
		phoneNumber = phoneNum;
	}
	
	/*
	 * Getter method to see if the user is a driver 
	 * @return boolean indicating if your a driver
	 */
	public boolean getIsDriver()
	{
		return isDriver;
	}
	
	/*
	 * Setter method to change driver status
	 * @param driverStatus boolean indicating desired driver status
	 * @return
	 *         Returns boolean true if user is driving, boolean false if not
	 */
	public boolean setIsDriver(boolean driving)
	{
		isDriver = driving;
		return isDriver;
	}
	
	/*
	 * Getter method to return user's name 
	 * @return string indicating driver's name
	 */	
	public String getName()
	{
		return name;
	}
	
	/*
	 * Setter method to change user's name 
	 * @param newName changes the user's name 
	 */	
	public void setName(String newName)
	{
		name = newName;
	}
	
	/*
	 * Getter method to return user's phoneNum 
	 * @return string indicating driver's number
	 */	
	public String getPhoneNumber()
	{
		return phoneNumber;
	}
	
	/*
	 * Setter method to change user's number 
	 * @param newNum changes the user's number 
	 */
	public void setPhoneNumber(String newNumber)
	{
		phoneNumber = newNumber;
	}
	
	/*
	 * Getter method to check if the user is correct  
	 * @return boolean if Users are equal
	 */	
	@Override
	public boolean equals(Object obj) {
        if (this == obj) {
            return true; 
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() == obj.getClass()) {
            User user = (User)obj;
            return ((this.getIsDriver() && user.getIsDriver()) 
                || (!this.getIsDriver() && !user.getIsDriver())
                && (this.getName().equals(user.getName()))
                && (this.getPhoneNumber().equals(user.getPhoneNumber())));
        }
        else {
            return false;
        }
                
    }
} 
