package Spring_MVC.CRUD_nameparameter;


import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
    	
    	ApplicationContext ap=new ClassPathXmlApplicationContext("spring.xml");
    	EmployeeDaoImpl emp=(EmployeeDaoImpl)ap.getBean("obj");
    	emp.create(4,"Arbaaz",24,25000);

    	List<Employee> students = emp.listEmployees();
	      for (Employee record : students) {
	         System.out.print("ID : " + record.getEmpId() );
	         System.out.print(", Name : " + record.getEmpName() );
	         System.out.println(", Age : " + record.getAge());
	      }
	    emp.updateEmpName(1, "Shaikh");
	    emp.delete(1);
    }
}
