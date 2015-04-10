package com.jdbc;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;

public class JdbcVehicleDao3 implements VehicleDao {
	private DataSource dataSource;
	@Override
	public void insert(final Vehicle vehicle) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql ="insert into vehicle(vehicle_no,color,wheel,seat) values (?,?,?,?)";
		jdbcTemplate.update(sql, new PreparedStatementSetter(){
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, vehicle.getVehicleNo());
				ps.setString(2, vehicle.getColor());
				ps.setInt(3, vehicle.getWheel());
				ps.setInt(4, vehicle.getSeat());				
			}});
	}

	@Override
	public void update(Vehicle vehicle) {

	}

	@Override
	public void delete(Vehicle vehicle) {

	}

	@Override
	public Vehicle findByVehicleNo(String vehicleNo) {

		return null;
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
}
