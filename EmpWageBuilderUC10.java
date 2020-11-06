public class EmpWageBuilderUC10 {
   public static final int IS_PART_TIME = 1;
   public static final int IS_FULL_TIME = 2;

	private int numOfCompany = 0;
	private CompanyEmpWage[] companyEmpWageArray;

	public EmpWageBuilderUC10() {
      companyEmpWageArray = new CompanyEmpWage[5];
   }
   private void addCompanyEmpWage(String company, int empRatePerHr, int numOfWorkingDays, int maxHrPerMonth) {
      companyEmpWageArray[numOfCompany] = new CompanyEmpWage(company, empRatePerHr,numOfWorkingDays,maxHrPerMonth);
		numOfCompany++;
   }
   private void computeEmpWage(){
     for (int i = 0; i < numOfCompany; i++) {
          int totalEmpWage = this.computeEmpWage(companyEmpWageArray[i]);
          System.out.println("Total EmpWage for company: " + companyEmpWageArray[i].company + 
										" is " + totalEmpWage);
  		}
	}

   private int computeEmpWage(CompanyEmpWage companyEmpWage) {
		//Variables
		int empHrs = 0, totalEmpHrs = 0, totalWorkingDays = 0;
      while (totalEmpHrs <= companyEmpWage.maxHrPerMonth && totalWorkingDays <=
               companyEmpWage.numOfWorkingDays) {
         totalWorkingDays++;
         int empCheck = (int)Math.floor(Math.random() * 10) % 3;
         switch (empCheck) {
          case IS_PART_TIME:
              empHrs = 4;
              break;
          case IS_FULL_TIME:
              empHrs = 8;
              break;
          default:
              empHrs = 0;
         }
         totalEmpHrs += empHrs;
         System.out.println("Day: " +totalWorkingDays + " Emp Hrs: " +empHrs);
      }
         return totalEmpHrs * companyEmpWage.empRatePerHr;
   }

   public static void main(String[] args) {

      EmpWageBuilderUC10 empWageBuilder = new  EmpWageBuilderUC10();
      empWageBuilder.addCompanyEmpWage("Dmart",20,2,10);
      empWageBuilder.addCompanyEmpWage("BigBasket",30,2,20);
		empWageBuilder.computeEmpWage();
   }
}
