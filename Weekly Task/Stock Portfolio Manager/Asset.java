abstract class Asset{
    private String symbol;
    private int quantity;
    private int purchasePrice;

    Asset(String symbol, int quantity, int purchasePrice){
        this.symbol = symbol;
        this.quantity = quantity;
        this.purchasePrice = purchasePrice;
    }

    // private void setSymbol(String symbol){this.symbol = symbol;}
    // private void setQuantity(int quantity){this.quantity = quantity;}
    // private void setPurchasePrice(int purchasePrice){this.purchasePrice = purchasePrice;}

    public String getSymbol(){ return symbol;}
    public int getQuantity(){ return quantity;}
    public int getPurchasePrice(){ return purchasePrice;}

    abstract public double currentValue();
    abstract public double getPnl();
    abstract public String getAssetType();

}