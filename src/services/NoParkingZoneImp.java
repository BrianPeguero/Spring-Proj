package services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.DAO;
import enums.NoParkingZoneEnum;
import models.NoParkingZone;

public class NoParkingZoneImp extends DAO {
	
	public List<NoParkingZone> getAllNoParkingZone() {
		List<NoParkingZone> allNoParkingZones = new ArrayList<NoParkingZone>();
		
		connect();
		
		try {
			ps = conn.prepareStatement(NoParkingZoneEnum.GET_NO_PARKINNG_ZONE.getQuery());
			rs = ps.executeQuery();
			
			while(rs.next()) {
				allNoParkingZones.add(new NoParkingZone(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getString(5)));
			}
			
			System.out.println(allNoParkingZones);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dispose();
		}
		
		return allNoParkingZones;
	}
}
