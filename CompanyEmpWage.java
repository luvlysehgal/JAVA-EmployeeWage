public class CompanyEmpWage {
	public final String company;
	public final int empRatePerHr;
	public final int numOfWorkingDays;
	public final int maxHrPerMonth;

	public CompanyEmpWage(String company, int empRatePerHr, int numOfWorkingDays, int maxHrPerMonth) {
		this.company = company;
		this.empRatePerHr = empRatePerHr;
		this.numOfWorkingDays = numOfWorkingDays;
		this.maxHrPerMonth = maxHrPerMonth;
	}
}

