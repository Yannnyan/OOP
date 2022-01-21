package Threads;

public class Tax implements TaxInterface {

    private final int ZIKUI_POINT = 2676;
    private final int MINIMUM_PAY = 5300;
    private final int MAS_1 = 75480;
    private final int MAS_2 = 108360;
    private final int MAS_3 = 173880;
    private final int MAS_4 = 241680;
    private final int MAS_5 = 502920;
    private final int MAS_6 = 647640;
    private final int MAS_7 = Integer.MAX_VALUE;


    /* private method to calculate income tax for each stage*/
    private double stagesSwitch(int stage, double money){
        double delta,deltaMas;
        float masRatio = 1;
        int mas1,mas2;
        switch(stage){
            case 1:
                masRatio = 0.1f;
                mas1 = 0;
                mas2 = MAS_1;
                break;
            case 2:
                masRatio = 0.14f;
                mas1 = MAS_1;
                mas2 = MAS_2;
                break;
            case 3:
                masRatio = 0.2f;
                mas1 = MAS_2;
                mas2 = MAS_3;
                break;
            case 4:
                masRatio = 0.31f;
                mas1 = MAS_3;
                mas2 = MAS_4;
                break;
            case 5:
                masRatio = 0.35f;
                mas1 = MAS_4;
                mas2 = MAS_5;
                break;
            case 6:
                masRatio = 0.47f;
                mas1 = MAS_5;
                mas2 = MAS_6;
                break;
            case 7:
                masRatio = 0.5f;
                mas1 = MAS_6;
                mas2 = MAS_7;
                break;
            default:
                return 0;
        }
        deltaMas = mas2 - mas1;
        if(stage == 7){
            return ((money - MAS_6)* masRatio);
        }
        if(money < mas1){
            return 0;
        }
        else if(money > mas2){
            return (deltaMas * masRatio);
        }
        else{
            return ((mas2 - money) * masRatio);
        }
    }


    @Override
    public double IncomeTax(TaxPayer taxPayer) {
        int sum_taxes = 0;
        double val;
        for (int i = 0; i < 7; i++) {
            val = stagesSwitch(i,taxPayer.getIncome());
            if(val != 0) // sanity check
                sum_taxes += val;
            else
                break;
        }
        return sum_taxes;
    }

    @Override
    public double BituahLeomi(TaxPayer taxPayer) {
        return 0;
    }

    @Override
    public double PurchaseTax(TaxPayer taxPayer, double buyAmount) {
        return 0;
    }

    @Override
    public double ValueAddedTax(TaxPayer taxPayer, double dealAmount) {
        return 0;
    }

    @Override
    public double zikuiPointToShekels(TaxPayer taxPayer) {
        return (taxPayer.getZikuiPoints() * ZIKUI_POINT);
    }

    @Override
    public double pensionCompansationToShekels(TaxPayer taxPayer) {
        double money = taxPayer.getPensionRate() * taxPayer.getIncome();
        return (money * (35/100));
    }
}
