class HealthPolicy extends InsurancePolicy{
    private boolean preExistingCondition;

    HealthPolicy(String policyId, String holderName, int sumAssured, boolean preExistingCondition){
        super(policyId,holderName,sumAssured);
        this.preExistingCondition = preExistingCondition;
    }
    public String getPolicyType(){
        return "HealthPolicy";
    }

    public double calculateAnnualPremium(){
        double premium = getSumAssured() * 0.01;
        if(preExistingCondition){
            premium = premium * 1.2;
        }
        return premium;
    }
}