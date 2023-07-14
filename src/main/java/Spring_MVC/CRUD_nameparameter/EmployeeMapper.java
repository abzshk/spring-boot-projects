package Spring_MVC.CRUD_nameparameter;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class EmployeeMapper implements RowMapper {  
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
	      Employee emp = new Employee();
	      emp.setAge(rs.getInt("age"));
	      emp.setEmpId(rs.getInt("empid"));
	      emp.setEmpName(rs.getString("name"));
	      emp.setSalary(rs.getInt("salary"));
	      return emp;
	   }
}  