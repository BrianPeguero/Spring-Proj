package services;

import java.sql.SQLException;

import dao.DAO;
import enums.UserEnum;
import models.User;
import models.UserSigningIn;
import repositories.UserInt;
import repositories.VehicalInt;

public class UserImp extends DAO implements UserInt {

	@Override
	public User getUserByEmail(String email) {
		User user = null;
		connect();
		
		try {
			ps = conn.prepareStatement(UserEnum.GET_USER_BY_EMAIL.getQuery());
			ps.setString(1, email);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				user = new User(rs.getString(1), rs.getString(2), rs.getInt(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dispose();
		}
		
		return user;
	}
	
	public void newUser(String email, String password, int vehicalType) {
		connect();
		
		try {
			ps = conn.prepareStatement(UserEnum.NEW_USER.getQuery());
			ps.setString(1, email);
			ps.setString(2, password);
			ps.setInt(3, vehicalType);
			
			ps.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dispose();
		}
		
	}

	@Override
	public boolean isValidUser(UserSigningIn userSigningIn) {
		boolean isValid = false;
		User user = null;
		connect();
		
		try {
			ps = conn.prepareStatement(UserEnum.GET_USER_BY_EMAIL.getQuery());
			
			if(rs.next()) {
				user = new User(rs.getString(1), rs.getString(2), rs.getInt(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dispose();
		}
		
		if (user.getEmail().equals(userSigningIn.getEmail()) && user.getPassword().equals(userSigningIn.getPassword())) {
			isValid = true;
		}
		
		return isValid;
	}
	
	

	@Override
	public VehicalInt vehicalInfo(int vehicalId) {
		return null;
	}

	@Override
	public VehicalInt vehicalInfo(UserInt user) {
		return null;
	}

	@Override
	public void releaseSpot() {
		connect();
		
		try {
			ps = conn.prepareStatement(UserEnum.RELEASE_LOC_OF_CAR.getQuery());
			ps.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dispose();
		}
	}

	@Override
	public String updateSpot(String location) {
		String newLoc = "";
		connect();
		
		try {
			ps = conn.prepareStatement(UserEnum.UPDATE_LOC.getQuery());
			ps.setString(1, location);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				newLoc = rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dispose();
		}
		
		return newLoc;
	}

}
