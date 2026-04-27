class VehiclePolicy extends InsurancePolicy{
    private boolean hasNoClaim;

    VehiclePolicy(String policyId, String holderName, int sumAssured, boolean hasNoClaim){
        super(policyId,holderName,sumAssured);
        this.hasNoClaim = hasNoClaim;
    }

    public String getPolicyType(){
        return "VehiclePolicy";
    }

    public double calculateAnnualPremium(){
        double premium = getSumAssured() * 0.02;
        if(hasNoClaim){
            premium = premium * 0.9;
        }
        return premium;
    }
}