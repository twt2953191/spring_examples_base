package com.jdbc;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcVehicleDao2 implements VehicleDao {
	private DataSource dataSource;
	@Override
	public void insert(Vehicle vehicle) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.update(new VehicleInsertStatementCreator(vehicle));
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
