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

import com.superMarket.View;
import com.superMarket.Model;

public class UserInterface {
    //TODO: add external configuration file for week of offer or not

    private Control superMarketControl;
    private Model superMarketModel;
    private View superMarketView;

    public UserInterface(String[] args){
        superMarketControl = new Control(args);
        superMarketControl.checkThatRequestedItemsExist();

        superMarketModel = new Model();
        superMarketView = new View();
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
