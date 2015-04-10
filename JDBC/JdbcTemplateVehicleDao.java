package com.jdbc;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
public class JdbcTemplateVehicleDao extends JdbcDaoSupport implements VehicleDao {
	@Override
	public void insert(final Vehicle vehicle) {
		String sql ="insert into vehicle(vehicle_no,color,wheel,seat) values (?,?,?,?)";
		this.getJdbcTemplate().update(sql, new Object[]{vehicle.getVehicleNo(),vehicle.getColor(),vehicle.getWheel(),vehicle.getSeat()});
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

}
