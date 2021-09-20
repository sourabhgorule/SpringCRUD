package com.springCRUD.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.springCRUD.bean.Employee;

@Component
public class EmployeeDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public String getNameById(int id) {

		String sql = "select fullname from employee where id=" + id;

		String fullname = jdbcTemplate.queryForObject(sql, String.class);

		return fullname;

	}

	public int countEmpoyee() {

		String sql = "select count(id) from employee";
		int cnt = jdbcTemplate.queryForObject(sql, int.class);

		return cnt;

	}

	public int save(Employee emp) {

		String sql = "insert into employee values(?,?,?)";

		Object[] params = { emp.getId(), emp.getDepartment(), emp.getFullName() };

		int cnt = jdbcTemplate.update(sql, params);

		return cnt;

	}

	public int updateEmployee(Employee e) {

		String sql = "update employee set department=?,fullname=? where id=?";

		Object[] params = { e.getDepartment(), e.getFullName(), e.getId() };

		int cnt = jdbcTemplate.update(sql, params);

		return cnt;

	}

	public int deleteEmployee(int id) {

		String sql = "delete from employee where id=" + id;

		int cnt = jdbcTemplate.update(sql);

		return cnt;

	}

	public List<Employee> allEmployee() {
			
		String sql="select * from employee";
		
		return jdbcTemplate.query(sql, new Employeemapper());
	}

	private class Employeemapper implements RowMapper<Employee> {

		@Override
		public Employee mapRow(ResultSet rs, int row) throws SQLException {

			Employee emp = new Employee();

			emp.setId(rs.getInt("id"));
			emp.setDepartment(rs.getString("department"));
			emp.setFullName(rs.getString("fullname"));

			return emp;
		}

	}
}
