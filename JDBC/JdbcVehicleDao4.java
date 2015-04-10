package com.jdbc;
import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcVehicleDao4 implements VehicleDao {
	private DataSource dataSource;
	@Override
	public void insert(final Vehicle vehicle) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql ="insert into vehicle(vehicle_no,color,wheel,seat) values (?,?,?,?)";
		jdbcTemplate.update(sql, new Object[]{vehicle.getVehicleNo(),vehicle.getColor(),vehicle.getWheel(),vehicle.getSeat()});
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
