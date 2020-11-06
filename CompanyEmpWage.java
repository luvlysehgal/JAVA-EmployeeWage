public class CompanyEmpWage {
	public final String company;
	public final int empRatePerHr;
	public final int numOfWorkingDays;
	public final int maxHrPerMonth;
	public int totalEmpWage;

	public CompanyEmpWage(String company, int empRatePerHr, int numOfWorkingDays, int maxHrPerMonth) {
		this.company = company;
		this.empRatePerHr = empRatePerHr;
		this.numOfWorkingDays = numOfWorkingDays;
		this.maxHrPerMonth = maxHrPerMonth;
		totalEmpWage = 0;
	}

	public void setTotalEmpWage(int totalEmpWage) {
		this.totalEmpWage = totalEmpWage;
	}
	public String toString(){
		return "Total Emp Wage for company: " +company+ " is " +totalEmpWage;
	}
}

