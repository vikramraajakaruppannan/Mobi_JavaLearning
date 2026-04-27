abstract class InsurancePolicy{
    private String policyId;
    private String holderName;
    private int sumAssured;

    InsurancePolicy(String policyId, String holderName, int sumAssured){
        this.policyId = policyId;
        this.holderName = holderName;
        this.sumAssured = sumAssured;
    }

    private void setPolicyId(String policyId){ this.policyId = policyId;}
    private void setHolderName(String holderName){ this.holderName = holderName;}
    private void setSumAssured(int sumAssured){this.sumAssured = sumAssured;}

    public String getPolicyId(){return policyId;}
    public String getHolderName(){return holderName;}
    public int getSumAssured(){return sumAssured;}

    abstract public String getPolicyType();

    abstract public double calculateAnnualPremium();
}