import java.util.LinkedList;
import java.util.HashMap;
public class EmpWageFinalSolution implements IComputeEmpWage {
   public static final int IS_PART_TIME = 1;
   public static final int IS_FULL_TIME = 2;

	private int numOfCompany = 0;
	private LinkedList<CompanyEmpWage> companyEmpWageList;
	private HashMap<String,CompanyEmpWage> companyEmpWageMap;

	public EmpWageFinalSolution() {
      companyEmpWageList = new LinkedList<>();
		companyEmpWageMap = new HashMap<>();
   }
   public void addCompanyEmpWage(String company, int empRatePerHr, int numOfWorkingDays, int maxHrPerMonth) {
      CompanyEmpWage companyEmpWage  = new CompanyEmpWage(company, empRatePerHr,numOfWorkingDays,maxHrPerMonth);
		companyEmpWageList.add(companyEmpWage);
		companyEmpWageMap.put(company,companyEmpWage);
   }
   public void computeEmpWage(){
     for (int i = 0; i < companyEmpWageList.size(); i++) {
          CompanyEmpWage companyEmpWage = companyEmpWageList.get(i);
			companyEmpWage.setTotalEmpWage(this.computeEmpWage(companyEmpWage));
          System.out.println(companyEmpWage);
  		}
	}
	public int getTotalWage(String company){
		return companyEmpWageMap.get(company).totalEmpWage;
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

      IComputeEmpWage empWageBuilder = new  EmpWageFinalSolution();
      empWageBuilder.addCompanyEmpWage("DMart",20,2,10);
      empWageBuilder.addCompanyEmpWage("BigBasket",30,2,20);
		empWageBuilder.computeEmpWage();
		System.out.println("Total Employee Wage for DMart company: " 
										+ empWageBuilder.getTotalWage("DMart"));
		System.out.println("Total Employee Wage for BigBasket company: "
                              + empWageBuilder.getTotalWage("BigBasket"));
   }
}
