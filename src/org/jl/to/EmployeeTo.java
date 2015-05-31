package org.jl.to;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="employees")

public class EmployeeTo {
	@Id
	
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator = "emp_seq")
	@SequenceGenerator(
			name="emp_seq",
			sequenceName="emp_seq"
			
		)
	@Column(name="employee_id")
	private Integer employeeId;
	@Column(name="first_name")
	private String firstName;
	@Column(name="last_name")
	private String lastName;
    public String getJobId() {
		return jobId;
	}


	public void setJobId(String jobId) {
		this.jobId = jobId;
	}


	@Column(name="email")
    private String email;
    @Column(name="hire_date")
	private Date hireDate;
    @Column(name="job_id")
   	private String jobId;
    public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public Double getSalary() {
		return salary;
	}


	public void setSalary(Double salary) {
		this.salary = salary;
	}


	public Double getCommissionPct() {
		return commissionPct;
	}


	public void setCommissionPct(Double commissionPct) {
		this.commissionPct = commissionPct;
	}


	@Column(name="phone_number")
    private String phoneNumber;
    @Column(name="salary")
    private Double salary;
    @Column(name="COMMISSION_PCT")
    
	private Double commissionPct;
    
	public String getEmail() {
		return email;
	}


	public Date getHireDate() {
		return hireDate;
	}


	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}


	public EmployeeTo(){
		
	}


	public int getEmployeeId() {
		return employeeId;
	}


	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
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

	

	
}
