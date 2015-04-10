package com.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.jdbc.core.PreparedStatementCreator;

public class VehicleInsertStatementCreator implements PreparedStatementCreator {
	private Vehicle vehicle;
	public VehicleInsertStatementCreator(Vehicle vehicle){
		this.vehicle=vehicle;
	}
	@Override
	public PreparedStatement createPreparedStatement(Connection conn)
			throws SQLException {
		String sql ="insert into vehicle(vehicle_no,color,wheel,seat) values (?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, vehicle.getVehicleNo());
		ps.setString(2, vehicle.getColor());
		ps.setInt(3, vehicle.getWheel());
		ps.setInt(4, vehicle.getSeat());		
		return ps;
	}

}
