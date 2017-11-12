package com.superMarket;

import com.superMarket.View;
import com.superMarket.Model;

public class UserInterface {
    //TODO: add external configuration file for week of offer or not

    private View superMarketView;
    private Model superMarketModel;

    public UserInterface(String[] args){
        superMarketView = new View();
        superMarketModel = new Model();
    }


    public static void main(String[] args) {

        UserInterface U1 = new UserInterface(args);

        U1.superMarketView.report();
    }

    public String getFirstLine() {

        return "";
    }

    public String getDummyFirstLineWithAppleMilkBread() {

        return "Subtotal: £3.10";
    }


    public String getSecondLine() {

        return "";
    }

    public String getDummySecondLineWithAppleMilkBreadWithOffers() {

        return "Apples 10% off: -10p";
    }

    public String getDummySecondLineWithAppleMilkBreadWithoutOffers() {

        return "(no offers available)";
    }

    public String getThirdLine() {

        return "";
    }

    public String getDummyThirdLineWithAppleMilkBreadWithOffers() {

        return "Total: £3.00";
    }

    public String getDummyThirdLineWithAppleMilkBreadWithoutOffers() {

        return "Total: £3.10";
    }

}
