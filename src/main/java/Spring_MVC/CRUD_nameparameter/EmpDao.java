package Spring_MVC.CRUD_nameparameter;
import java.util.List;

import javax.sql.DataSource;


public interface EmpDao {
	 
	public void setDataSource(DataSource ds);
	public void updateEmpName(Integer empId, String empName);
}
