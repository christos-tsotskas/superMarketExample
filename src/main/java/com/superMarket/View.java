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

import java.text.DecimalFormat;

/**
 * View perspective in Model-View-Control
 */
public class View {

    static String GBP = "\u00A3";
    String currency;
    final DecimalFormat doubleNumberFormatter = new DecimalFormat("#0.00");

    public View(String currency){
        if (currency.toUpperCase().equals("GBP")) {
            this.currency = GBP;
        }

    }

//TODO: format the output (p if the value is less than 1.00)


    public String getFirstLine(double subtotalCost) {
        return  "Subtotal: " + this.currency + doubleNumberFormatter.format(subtotalCost);
    }


    public String getSecondLine() {
        String noOffersText = "(no offers available)";
        String output = noOffersText;

        return output;
    }

    public String getThirdLine(double totalCost) {
        return  "Total: " + this.currency + doubleNumberFormatter.format(totalCost);
    }

    public void reportAll(Model superMarketModel){
        System.out.println( getFirstLine(superMarketModel.getTotalCostOfRequestedItemsWithoutDiscount()) );
        System.out.println( getSecondLine() );
        System.out.println( getThirdLine(superMarketModel.getTotalCostOfRequestedItemsWithoutDiscount()) );
    }
}
