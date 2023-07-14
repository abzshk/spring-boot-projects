package Spring_MVC.CRUD_nameparameter;


import java.sql.Types;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.core.support.SqlLobValue;
import org.springframework.jdbc.support.lob.DefaultLobHandler;

public class EmployeeDaoImpl implements EmpDao {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	SimpleJdbcInsert jdbcInsert;
	public void setDataSource(DataSource dataSource) {
	   this.dataSource = dataSource;
	   this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	   this.jdbcInsert = new SimpleJdbcInsert(dataSource).withTableName("Employee");
	}
	public void updateEmpName(Integer empId, String empName) {
	     MapSqlParameterSource in = new MapSqlParameterSource();
	     in.addValue("empid", empId);
	     in.addValue("name",  new SqlLobValue(empName, new DefaultLobHandler()), Types.CLOB);
	     String SQL = "update test.employee set empName = :empName where empid = :empId";
	     NamedParameterJdbcTemplate jdbcTemplateObject = new NamedParameterJdbcTemplate(dataSource);
	     jdbcTemplateObject.update(SQL, in);
	     System.out.println("Updated Record with ID = " + empId );
	 }
	public void create(Integer empId,String name, Integer age,Integer salary) {
	      Map<String,Object> parameters = new HashMap<String,Object>();
	      parameters.put("empid", empId);	
	      parameters.put("name", name);
	      parameters.put("age", age);
	      parameters.put("salary", salary);
	      jdbcInsert.execute(parameters);
	      System.out.println("Created Record empId= "+empId+"Name = " + name + " Age = " + age);
	      return;
	   }
	
	   public List<Employee> listEmployees() {
	      String SQL = "select * from Employee";
	      List <Employee> students = jdbcTemplateObject.query(SQL, new EmployeeMapper());
	      return students;
	   }
	   public void delete(Integer id){
		   	MapSqlParameterSource in = new MapSqlParameterSource();
		    in.addValue("empid", id);
		    String SQL = "delete from test.Employee where empid = :empid";
		    NamedParameterJdbcTemplate jdbcTemplateObject = new NamedParameterJdbcTemplate(dataSource);
		     jdbcTemplateObject.update(SQL, in);
		      System.out.println("Deleted Record with ID = " + id );
		      return;
	   }
}
