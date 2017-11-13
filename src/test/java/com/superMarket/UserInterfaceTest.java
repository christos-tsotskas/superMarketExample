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

import org.junit.Rule;
import org.junit.Test;

import java.lang.RuntimeException;

import com.superMarket.UserInterface;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

/**
 *  Test User Interface
 */
public class UserInterfaceTest {

    static String GBP_symbol = "\u00A3";



    /**
     * verify Output On A Period Of Offer With Dummy Values
     */
    @Test
    public void verifyOutputOnAPeriodOfOfferWithDummyValues() {
        String[] commandLineArguments = {"Apples", "Milk", "Bread"};

        String expectedFirstLine = "Subtotal: "+GBP_symbol+"3.10";
        String expectedSecondLine = "Apples 10% off: -10p";
        String expectedThirdLine = "Total: "+GBP_symbol+"3.00";

        UserInterface.main(commandLineArguments);

        UserInterface dummyUI = new UserInterface(commandLineArguments);
        assertEquals(expectedFirstLine, dummyUI.getDummyFirstLineWithAppleMilkBread());
        assertEquals(expectedSecondLine, dummyUI.getDummySecondLineWithAppleMilkBreadWithOffers());
        assertEquals(expectedThirdLine, dummyUI.getDummyThirdLineWithAppleMilkBreadWithOffers());



    }

    @Test
    public void verifyOutputWithoutAnyOffersWithDummyValues() {
        String[] commandLineArguments = {"Apples", "Milk", "Bread"};

        String expectedFirstLine = "Subtotal: "+GBP_symbol+"3.10";
        String expectedSecondLine = "(no offers available)";
        String expectedThirdLine = "Total: "+GBP_symbol+"3.10";

        UserInterface.main(commandLineArguments);

        UserInterface dummyUI = new UserInterface(commandLineArguments);

        assertEquals(expectedFirstLine, dummyUI.getDummyFirstLineWithAppleMilkBread());
        assertEquals(expectedSecondLine, dummyUI.getDummySecondLineWithAppleMilkBreadWithoutOffers());
        assertEquals(expectedThirdLine, dummyUI.getDummyThirdLineWithAppleMilkBreadWithoutOffers());
    }

    @Test
    public void verifyOutputWithoutAnyOffersWithDummyValuesByProvidingMalformedInput() {
        String[] commandLineArguments = {"AppLES", "MiLk", "BRead"};

        String expectedFirstLine = "Subtotal: "+GBP_symbol+"3.10";
        String expectedSecondLine = "(no offers available)";
        String expectedThirdLine = "Total: "+GBP_symbol+"3.10";

        UserInterface.main(commandLineArguments);

        UserInterface dummyUI = new UserInterface(commandLineArguments);

        assertEquals(expectedFirstLine, dummyUI.getDummyFirstLineWithAppleMilkBread());
        assertEquals(expectedSecondLine, dummyUI.getDummySecondLineWithAppleMilkBreadWithoutOffers());
        assertEquals(expectedThirdLine, dummyUI.getDummyThirdLineWithAppleMilkBreadWithoutOffers());
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void verifyThatErrorMessageIsThrownIfTheUserRequestsItemsNonInTheList(){
        String[] commandLineArguments = {"Pumkin"};

        try {
        thrown.expect(RuntimeException.class);
        thrown.expectMessage("The item(s) is/are not available!");
            UserInterface.main(commandLineArguments);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testPurchasingOneLoafOfBread() {
        String[] commandLineArguments = {"Bread"};

        String expectedFirstLine = "Subtotal: "+GBP_symbol+"0.80";
        String expectedSecondLine = "(no offers available)";
        String expectedThirdLine = "Total: "+GBP_symbol+"0.80";

        UserInterface.main(commandLineArguments);

        UserInterface dummyUI = new UserInterface(commandLineArguments);

        assertEquals(expectedFirstLine, dummyUI.getFirstLine());
        assertEquals(expectedSecondLine, dummyUI.getSecondLine());
        assertEquals(expectedThirdLine, dummyUI.getThirdLine());
    }

    @Test
    public void testPurchasingOneBottleOfMilk() {
        String[] commandLineArguments = {"Milk"};

        String expectedFirstLine = "Subtotal: "+GBP_symbol+"1.30";
        String expectedSecondLine = "(no offers available)";
        String expectedThirdLine = "Total: "+GBP_symbol+"1.30";

        UserInterface.main(commandLineArguments);

        UserInterface dummyUI = new UserInterface(commandLineArguments);

        assertEquals(expectedFirstLine, dummyUI.getFirstLine());
        assertEquals(expectedSecondLine, dummyUI.getSecondLine());
        assertEquals(expectedThirdLine, dummyUI.getThirdLine());
    }

    @Test
    public void testPurchasingTwoBottlesOfMilk() {
        String[] commandLineArguments = {"Milk", "Milk"};

        String expectedFirstLine = "Subtotal: "+GBP_symbol+"2.60";
        String expectedSecondLine = "(no offers available)";
        String expectedThirdLine = "Total: "+GBP_symbol+"2.60";

        UserInterface.main(commandLineArguments);

        UserInterface dummyUI = new UserInterface(commandLineArguments);

        assertEquals(expectedFirstLine, dummyUI.getFirstLine());
        assertEquals(expectedSecondLine, dummyUI.getSecondLine());
        assertEquals(expectedThirdLine, dummyUI.getThirdLine());
    }

    @Test
    public void testPurchasingOneBottlesOfMilkAndOneLoafOfBread() {
        String[] commandLineArguments = {"Milk", "Bread"};

        String expectedFirstLine = "Subtotal: "+GBP_symbol+"2.10";
        String expectedSecondLine = "(no offers available)";
        String expectedThirdLine = "Total: "+GBP_symbol+"2.10";

        UserInterface.main(commandLineArguments);

        UserInterface dummyUI = new UserInterface(commandLineArguments);

        assertEquals(expectedFirstLine, dummyUI.getFirstLine());
        assertEquals(expectedSecondLine, dummyUI.getSecondLine());
        assertEquals(expectedThirdLine, dummyUI.getThirdLine());
    }

}