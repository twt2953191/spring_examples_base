package com.jdbc;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

public class JdbcVehicleDao5 implements VehicleDao {
	private DataSource dataSource;
	@Override
	public void insert(final Vehicle vehicle) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate).withTableName("vehicle");
		Map<String, Object> parameters = new HashMap<String, Object>(3);
		parameters.put("vehicle_no", vehicle.getVehicleNo());
		parameters.put("color", vehicle.getColor());
		parameters.put("wheel", vehicle.getWheel());
		parameters.put("seat", vehicle.getSeat());
		simpleJdbcInsert.execute(parameters);
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
