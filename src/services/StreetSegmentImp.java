package services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.DAO;
import enums.StreetSegmentEnum;
import models.StreetSegment;

public class StreetSegmentImp extends DAO{
	
	public List<StreetSegment> getAllStreetSegments() {
		List<StreetSegment> allStreetSegments = new ArrayList<StreetSegment>();
		
		connect();
		
		try {
			ps = conn.prepareStatement(StreetSegmentEnum.GET_ALL_STREETS.getQuery());
			rs = ps.executeQuery();
			
			while(rs.next()) {
				allStreetSegments.add(new StreetSegment(rs.getInt(1), rs.getInt(2), rs.getDouble(3), rs.getString(4)));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dispose();
		}
		
		return allStreetSegments;
	}
	
}
