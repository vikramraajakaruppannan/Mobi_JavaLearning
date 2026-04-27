class LifePolicy extends InsurancePolicy{
    private int age;

    LifePolicy(String policyId, String holderName, int sumAssured, int age){
        super(policyId,holderName,sumAssured);
        this.age = age;
    }

    public String getPolicyType(){
        return "LifePolicy";
    }

    public double calculateAnnualPremium(){
        double premium = 0.005;
        if(age>40){
            premium +=((age - 40)*0.001);
        }
        return getSumAssured() * premium;
    }
}
