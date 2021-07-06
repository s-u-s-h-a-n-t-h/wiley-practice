package wiley.intern.intro;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Project{
	int projectId;
	String name;
	double budget;
	
	Project(int projectId, String name, double budget){
		this.projectId = projectId;
		this.name = name;
		this.budget = budget;
	}
	
	static List<Employee> trimResourcesForProject(List<Employee> employees, int projectId) {
		List<Employee> projectEmployees = new ArrayList<>();
		List<Employee> removedEmployees = new ArrayList<>();
		double resourceCost = 0;
		double budget = 0;
		
		//Filtering out the employees of a particular project and
		//calculating total resource cost
		for(Employee emp : employees) {
			if(emp.project.projectId==projectId) {
				projectEmployees.add(emp);
				resourceCost += emp.salary;
			}
		}
		
		budget = projectEmployees.get(0).project.budget;
		
		//sorting employees based on their salaries in reverse order
		Collections.sort(projectEmployees);
		
		//now removing employees at the rear end to fit the budget
		while(resourceCost>budget) {
			int lastIndex = projectEmployees.size()-1;
			resourceCost -= projectEmployees.get(lastIndex).salary;
			removedEmployees.add(projectEmployees.remove(lastIndex));
		}
		
		System.out.println("Removed employees(excess resources):");
		for(Employee emp: removedEmployees) {
			System.out.println("Employee id: " + emp.id);
			System.out.println("Employee name: " + emp.name);
			System.out.println("Employee salary: " + emp.salary);
		}
		
		return projectEmployees;
	}
}

class Address{
	String city;
	String zipCode;
	
	Address(String city, String zipCode){
		this.city = city;
		this.zipCode = zipCode;
	}
}

class User{
	String id;
	String name;
	
	User(String id, String name){
		this.id = id;
		this.name = name;
	}
}

class Employee extends User implements Comparable<Employee>{
	Address address;
	Project project;
	double salary;
	
	Employee(User user, Address address, Project project, double salary){
		super(user.id, user.name);
		this.address = address;
		this.project = project;
		this.salary = salary;
	}

@Override public int compareTo(Employee emp){
		if(emp.salary>salary) {
			return 1;
		}
		else if(emp.salary<salary) {
			return -1;
		}
		return 0;
	}
}

public class ProjectBudget {
	public static void main(String[] args) {
		
		User user1 = new User("101", "user1");
		User user2 = new User("102", "user2");
		User user3 = new User("103", "user3");
		
		Address address1 = new Address("Banglore", "111");
		Address address2 = new Address("Hyderabad", "222");
		Address address3 = new Address("Chennai", "333");
		
		Project project1 = new Project(1, "resolving the budget", 1000);
		Project project2 = new Project(2, "another project", 2000);
		
		Employee emp1 = new Employee(user1, address1, project1, 200);
		Employee emp2 = new Employee(user2, address2, project1, 500);
		Employee emp3 = new Employee(user3, address3, project1, 400);
		
		Employee emp4 = new Employee(user2, address2, project2, 700);
		
		List<User> users = new ArrayList<>();
		users.add(emp1);
		users.add(emp2);
		users.add(user1);
		users.add(emp3);
		users.add(user2);
		users.add(emp4);
		users.add(user3);
		
		List<Employee> employees = new ArrayList<>();
		
		//Filtering out employees from Users list
		for(User user : users) {
			if(user instanceof Employee) {
				employees.add((Employee)user);
			}
		}
		
		//Getting optimal employees for the project
		List<Employee> employeesToWorkWith = Project.trimResourcesForProject(employees, 1);
		
		double totalResourceCost = 0;
		
		System.out.println("\nOptimal employees to work for the project '" + employeesToWorkWith.get(0).project.name + "' : ");
		for(Employee emp: employeesToWorkWith) {
			System.out.println("Employee name: " + emp.name);
			System.out.println("Employee salary: " + emp.salary);
			System.out.println();
			totalResourceCost += emp.salary;
		}
		
		System.out.println("Total budget available: " + employeesToWorkWith.get(0).project.budget);
		System.out.println("Total resource cost required: " + totalResourceCost);
	}
}
