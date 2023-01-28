class Employee {
    int employeeId;
    String employeeName;
    double salary;
    public Employee(int employeeId, String employeeName) {
		
		this.employeeId = employeeId;
		this.employeeName = employeeName;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
}

class ContractEmployee extends Employee{
    double wage;
    float hoursWorked;
    public ContractEmployee(int empId, String name, double wage, float hoursWorked) {
		super(empId, name);
		this.wage = wage;
		this.hoursWorked = hoursWorked;
	}
	public double getWage() {
		return wage;
	}
	public void setWage(double wage) {
		this.wage = wage;
	}
	public float getHoursWorked() {
		return hoursWorked;
	}
	public void setHoursWorked(float hoursWorked) {
		this.hoursWorked = hoursWorked;
	} 
    void calculateSalary() {
        setSalary(hoursWorked * wage);
    }
}

class PermanentEmployee extends Employee{
    double basicPay;
    double hra;
    float experience;
    public PermanentEmployee(int empId, String name, double basicPay, double hra, float experience) {
		super(empId, name);
		this.basicPay = basicPay;
		this.hra = hra;
		this.experience = experience;
	}
	public double getBasicPay() {
		return basicPay;
	}
	public void setBasicPay(double basicPay) {
		this.basicPay = basicPay;
	}
	public double getHra() {
		return hra;
	}
	public void setHra(double hra) {
		this.hra = hra;
	}
	public float getExperience() {
		return experience;
	}
	public void setExperience(float experience) {
		this.experience = experience;
	}
    void calculateMonthlySalary() {
        double variable_component;
        if(experience < 3)
        variable_component = 0;
        else if(experience < 5)
        variable_component = 0.05 * basicPay;
        else if(experience < 10)
        variable_component = 0.07 * basicPay;
        else
        variable_component = 0.12 * basicPay;
        setSalary(Math.round(basicPay + hra + variable_component));
    }
}

public class testerConstruction {
    public static void main(String[] args) {
        PermanentEmployee p = new PermanentEmployee(1, "monidepa", 100000, 50000, 10);
        ContractEmployee c = new ContractEmployee(2, "riya", 3000, 8);
        p.calculateMonthlySalary();
        c.calculateSalary();
        System.out.println("PermanentEmployee : ");
        System.out.println("Employee Id : " + p.employeeId);
        System.out.println("Employee Name: " + p.employeeName);
        System.out.println("Salary : " + p.salary);
        System.out.println("ContractEmployee : ");
        System.out.println("Employee Id : " + c.employeeId);
        System.out.println("Employee Name: " + c.employeeName);
        System.out.println("Salary : " + c.salary);
    }
}
