import java.util.*;

class StockPortfolioManager{
    
    private List<Asset> assets= new ArrayList<>();

    public void addAsset(Asset asset){
        assets.add(asset);
    }

    public void removeAsset(String symbol){
        // for (Asset asset : assets) {
        //     if (asset.getSymbol().equals(symbol)) {
        //         list.remove(asset);
        //         return;
        //     }
        // }
        assets.removeIf(asset -> symbol.equals(asset.getSymbol()));
    }

    public double totalPortfolioValue(){
        double total =0;
        for(Asset asset : assets) total+=asset.currentValue();
        return total;
    }

    public double totalPnl(){
        double total =0;
        for(Asset asset : assets) total+=asset.getPnl();
        return total;
    }

    public void generateReport(){
        assets.sort(Comparator.comparing(Asset::getPnl).reversed());
        System.out.println("=== PORTFOLIO REPORT === ");
        for (Asset asset : assets) {
            double pnl = asset.getPnl();
            double value = asset.currentValue();
            System.out.printf(
                "%-8s %-10s PnL: %sRs.%.2f  Value: Rs.%.2f%n",
                asset.getAssetType(),
                asset.getSymbol(),
                (pnl >= 0 ? "+" : ""), 
                pnl,
                value
            );
        }
        
        double totalValue = totalPortfolioValue();
        double totalPnL = totalPnl();

        System.out.printf(
            "Total Value: Rs.%.2f   Total PnL: %sRs.%.2f%n",
            totalValue,
            (totalPnL >= 0 ? "+" : ""),
            totalPnL
        );
    }

    public void rebalance(double targetEquity){
        
        double portfoliovalue = totalPortfolioValue();
        double equityvalue = 0;
        for(Asset asset : assets){
            if(asset.getAssetType().equals("Equity")){
                equityvalue +=asset.currentValue();
            }
        }

        double targetEquityValue = (targetEquity  / 100) * portfoliovalue;
        double difference = targetEquityValue - equityvalue;
        
        if (portfoliovalue == 0) {
            System.out.println("Portfolio is empty");
            return;
        }
        double currentPct = (equityvalue / portfoliovalue) * 100;

        if (difference > 0) {
            System.out.printf(
                "Rebalance: Equity is %.1f%% (target %.0f%%) — Suggest BUY Rs.%.0f of equities.%n",
                currentPct,
                targetEquity,
                difference
            );
        } else if (difference < 0) {
            System.out.printf(
                "Rebalance: Equity is %.1f%% (target %.0f%%) - Suggest SELL Rs.%.0f of equities.%n",
                currentPct,
                targetEquity,
                Math.abs(difference)
            );
        } else {
            System.out.printf(
                "Rebalance: Equity is %.1f%% (target %.0f%%) - Portfolio already balanced.%n",
                currentPct,
                targetEquity
            );
        }
    }
    
    public static void main(String[] args){

        StockPortfolioManager rm = new StockPortfolioManager();
        rm.addAsset(new Equity("TCS", 10, 3500, 4200)); 
        rm.addAsset(new MutualFund("HDFC Top", 100, 50, 62)); 
        rm.generateReport();
        rm.rebalance(60.0);
    }
}