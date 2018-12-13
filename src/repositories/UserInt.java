package repositories;

import models.User;
import models.UserSigningIn;

public interface UserInt {
	
	/**
	 * gathers all the information from a user by fetching it from the database
	 * 
	 * @param email
	 * @return
	 */
	public User getUserByEmail(String email);
	
	/**
	 * Compares the UserSigningIn object from the form and compares the email and password parameters
	 * to that of the user from the database.
	 * 
	 * @param userSigningIn
	 * @return
	 */
	public boolean isValidUser(UserSigningIn userSigningIn);
	
	/**
	 * gets information about the users car from the database using the users int vehical type parameter
	 * 
	 * @param vehicalId
	 * @return
	 */
	public VehicalInt vehicalInfo(int vehicalId);
	
	/**
	 * gets information about the users car from the database using the users
	 * 
	 * @param vehicalId
	 * @return
	 */
	public VehicalInt vehicalInfo(UserInt user);
	
	/**
	 * makes the location field of the user object null and updates it in the database
	 * 
	 */
	public void releaseSpot();
	
	/**
	 * returns the location of the parking spot you have selected and updates it in the database
	 * 
	 * @param Location
	 * @return
	 */
	public String updateSpot(String Location);
}
