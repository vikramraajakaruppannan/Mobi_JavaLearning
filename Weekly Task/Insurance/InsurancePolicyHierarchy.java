import java.util.*;

class InsurancePolicyHierarchy{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        InsurancePolicy[] policies = new InsurancePolicy[3];

        policies[0]= new LifePolicy("L01", "Arjun", 1000000, 45);
        policies[1]= new HealthPolicy("H01", "Deepa", 500000, true);
        policies[2]= new VehiclePolicy("V01", "Suresh", 800000, false);
        
        InsurancePolicy max = null;
        double maximum = 0;
        for(InsurancePolicy policy : policies){
            double premium = policy.calculateAnnualPremium();
            if(premium > maximum){
                maximum = premium;
                max = policy;
            }
            System.out.printf("%-15s: Rs. %8.2f / year\n",policy.getPolicyType(),premium);
        }
        System.out.println("Most Expensive : " + max.getPolicyType() + " - " + max.getPolicyId());
    }
}