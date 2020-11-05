public class EmpWageBuilderUC9 {
	public static final int IS_PART_TIME = 1;
   public static final int IS_FULL_TIME = 2;

	private final String company;
	private final int empRatePerHr;
	private final int numOfWorkingDays;
	private final int maxHrsPerMonth;

   public EmpWageBuilderUC9(String company, int empRatePerHr, int numOfWorkingDays, int maxHrsPerMonth) {
		this.company = company;
		this.empRatePerHr = empRatePerHr;
		this.numOfWorkingDays = numOfWorkingDays;
		this.maxHrsPerMonth = maxHrsPerMonth;
	}

	private int companyEmpWage() {
		 //Variables
      int empHrs = 0 , totalEmpHrs = 0 , totalWorkingDays = 0;
      //computation
      while (totalEmpHrs <= maxHrsPerMonth && totalWorkingDays < numOfWorkingDays) {
         totalWorkingDays++;
         int empcheck = (int)Math.floor(Math.random() * 10) % 3;
         switch (empcheck) {
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
         System.out.println("Days: " +totalWorkingDays + " Emp Hrs: " +empHrs);
      }
      int totalEmpWage = totalEmpHrs * empRatePerHr;
		return totalEmpWage;
	}
	   public static void main(String[] args) {

		EmpWageBuilderUC9 dMart = new EmpWageBuilderUC9("dMart", 20, 2, 10);
		EmpWageBuilderUC9 BigBasket = new EmpWageBuilderUC9("BigBasket", 10, 4, 20);
		System.out.println("Total emmployee wage for company: " +dMart.company +
                       " is " +dMart.companyEmpWage());
      System.out.println("Total employee wage for Company: " +BigBasket.company + " is "
                       +BigBasket.companyEmpWage());
	   }
}
