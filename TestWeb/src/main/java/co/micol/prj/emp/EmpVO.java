package co.micol.prj.emp;

public class EmpVO {

	private String employeeID;
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	private String hireDate;
	private String JOB_ID;
	private String salary;
	private String departmentsId;
	
	public EmpVO() {
		super();
	}
	
	public EmpVO(String employeeID, String firstName, String lastName, String email, String phone, String hireDate,
			String jOB_ID, String salary, String departmentsId) {
		super();
		this.employeeID = employeeID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.hireDate = hireDate;
		JOB_ID = jOB_ID;
		this.salary = salary;
		this.departmentsId = departmentsId;
	}

	public String getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(String employeeID) {
		this.employeeID = employeeID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getHireDate() {
		return hireDate;
	}

	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}

	public String getJOB_ID() {
		return JOB_ID;
	}

	public void setJOB_ID(String jOB_ID) {
		JOB_ID = jOB_ID;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getDepartmentsId() {
		return departmentsId;
	}

	public void setDepartmentsId(String departmentsId) {
		this.departmentsId = departmentsId;
	}
	
	
	
}
