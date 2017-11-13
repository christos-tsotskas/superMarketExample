/*
 * MIT License
 *
 * Copyright (c) 2017. Christos Tsotskas
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.superMarket;

import java.util.List;
import java.util.Map;

/**
 * User Interface Class
 */
public class UserInterface {
    //TODO: add external configuration file for week of offer or not

    private Control superMarketControl;
    private Model superMarketModel;
    private View superMarketView;

    private List<String> validRequestedItems;

    /**
     * Constructor
     *
     * @param args command line items
     * @throws RuntimeException  if the requested items are not provided by the supermarket
     */
    public UserInterface(String[] args) throws RuntimeException{
        superMarketControl = new Control(args);

            superMarketControl.checkThatRequestedItemsExist();


        validRequestedItems = superMarketControl.getRequestedItems();

        superMarketModel = new Model(validRequestedItems);

        superMarketView = new View("GBP");
        superMarketView.reportAll(superMarketModel);
    }


    /**
     * Main method
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        try {
            UserInterface U1 = new UserInterface(args);
        } catch (Exception ex) {
            System.out.println("Exception Message: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    /**
     * Generate the subtotal of the order
     *
     * @return literal of the subtotal of the order
     */
    public String getFirstLine() {
        return superMarketView.getFirstLine(superMarketModel.getTotalCostOfRequestedItemsWithoutDiscount());
    }


    /**
     * Helper method for the integration tests
     *
     * @return hard-coded literal of the subtotal of the order
     */
    public String getDummyFirstLineWithAppleMilkBread() {
        String GBP_symbol = "\u00A3";
        return "Subtotal: " + GBP_symbol + "3.10";
    }


    /**
     * Generate additional information messages
     *
     * @return information literal to explain any discount
     */
    public String getSecondLine() {
        return superMarketView.getSecondLine();
    }

    /**
     * Helper method for the integration tests
     *
     * @return hard-coded literal to demonstrate discount message
     */
    public String getDummySecondLineWithAppleMilkBreadWithOffers() {
        return "Apples 10% off: -10p";
    }

    /**
     * Helper method for the integration tests
     *
     * @return hard-coded literal for no-offers
     */
    public String getDummySecondLineWithAppleMilkBreadWithoutOffers() {
        return "(no offers available)";
    }

    /**
     * Generate the total of the order
     *
     * @return literal of the total of the order
     */
    public String getThirdLine() {
        return superMarketView.getThirdLine(superMarketModel.getTotalCostOfRequestedItemsWithoutDiscount());
    }

    /**
     * Helper method for the integration tests
     *
     * @return hard-coded literal of the total of the order
     */
    public String getDummyThirdLineWithAppleMilkBreadWithOffers() {
        String GBP_symbol = "\u00A3";
        return "Total: " + GBP_symbol + "3.00";
    }

    /**
     * Helper method for the integration tests
     *
     * @return hard-coded literal of the total of the order
     */
    public String getDummyThirdLineWithAppleMilkBreadWithoutOffers() {
        String GBP_symbol = "\u00A3";
        return "Total: " + GBP_symbol + "3.10";
    }

}
