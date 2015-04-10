package com.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

public class JdbcVehicleDao implements VehicleDao {
	private DataSource dataSource;
	@Override
	public void insert(Vehicle vehicle) {
		String sql ="insert into vehicle(vehicle_no,color,wheel,seat) values (?,?,?,?)";
		Connection conn =null;
		try {
			conn = this.dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, vehicle.getVehicleNo());
			ps.setString(2, vehicle.getColor());
			ps.setInt(3, vehicle.getWheel());
			ps.setInt(4, vehicle.getSeat());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			if(conn !=null){
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public void update(Vehicle vehicle) {

	}

	@Override
	public void delete(Vehicle vehicle) {

	}

	@Override
	public Vehicle findByVehicleNo(String vehicleNo) {
		String sql ="select * from vehicle where vehicle_no=?";
		Connection conn =null;
		Vehicle vehicle = null; 
		try {
			conn = this.dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, vehicleNo);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				vehicle= new Vehicle();
				vehicle.setVehicleNo(rs.getString("VEHICLE_NO"));
				vehicle.setSeat(rs.getInt("SEAT"));
				vehicle.setWheel(rs.getInt("WHEEL"));
				vehicle.setColor(rs.getString("COLOR"));
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			if(conn !=null){
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}		
		return vehicle;
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
}
