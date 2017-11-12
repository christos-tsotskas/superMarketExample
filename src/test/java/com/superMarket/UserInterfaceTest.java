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

import org.junit.Test;

import java.lang.RuntimeException;

import com.superMarket.UserInterface;

import static org.junit.Assert.*;

/**
 *  Test User Interface
 */
public class UserInterfaceTest {

    /**
     * verify Output On A Period Of Offer With Dummy Values
     */
    @Test
    public void verifyOutputOnAPeriodOfOfferWithDummyValues() {
        String[] commandLineArguments = {"Apples", "Milk", "Bread"};

        String expectedFirstLine = "Subtotal: £3.10";
        String expectedSecondLine = "Apples 10% off: -10p";
        String expectedThirdLine = "Total: £3.00";

        UserInterface.main(commandLineArguments);

        UserInterface dummyUI = new UserInterface(commandLineArguments);

        assertEquals(expectedFirstLine, dummyUI.getDummyFirstLineWithAppleMilkBread());
        assertEquals(expectedSecondLine, dummyUI.getDummySecondLineWithAppleMilkBreadWithOffers());
        assertEquals(expectedThirdLine, dummyUI.getDummyThirdLineWithAppleMilkBreadWithOffers());
    }

    @Test
    public void verifyOutputWithoutAnyOffersWithDummyValues() {
        String[] commandLineArguments = {"Apples", "Milk", "Bread"};

        String expectedFirstLine = "Subtotal: £3.10";
        String expectedSecondLine = "(no offers available)";
        String expectedThirdLine = "Total: £3.10";

        UserInterface.main(commandLineArguments);

        UserInterface dummyUI = new UserInterface(commandLineArguments);

        assertEquals(expectedFirstLine, dummyUI.getDummyFirstLineWithAppleMilkBread());
        assertEquals(expectedSecondLine, dummyUI.getDummySecondLineWithAppleMilkBreadWithoutOffers());
        assertEquals(expectedThirdLine, dummyUI.getDummyThirdLineWithAppleMilkBreadWithoutOffers());
    }

    @Test
    public void verifyOutputWithoutAnyOffersWithDummyValuesByProvidingMalformedInput() {
        String[] commandLineArguments = {"AppLES", "MiLk", "BRead"};

        String expectedFirstLine = "Subtotal: £3.10";
        String expectedSecondLine = "(no offers available)";
        String expectedThirdLine = "Total: £3.10";

        UserInterface.main(commandLineArguments);

        UserInterface dummyUI = new UserInterface(commandLineArguments);

        assertEquals(expectedFirstLine, dummyUI.getDummyFirstLineWithAppleMilkBread());
        assertEquals(expectedSecondLine, dummyUI.getDummySecondLineWithAppleMilkBreadWithoutOffers());
        assertEquals(expectedThirdLine, dummyUI.getDummyThirdLineWithAppleMilkBreadWithoutOffers());
    }

    @Test(expected = RuntimeException.class)
    public void verifyThatErrorMessageIsThrownIfTheUserRequestsItemsNonInTheList() {
        String[] commandLineArguments = {"Pumkin"};

        UserInterface.main(commandLineArguments);
    }

    @Test
    public void testPurchasingOneLoafOfBread() {
        String[] commandLineArguments = {"Bread"};

        String expectedFirstLine = "Subtotal: £0.80";
        String expectedSecondLine = "(no offers available)";
        String expectedThirdLine = "Total: £0.80";

        UserInterface.main(commandLineArguments);

        UserInterface dummyUI = new UserInterface(commandLineArguments);

        assertEquals(expectedFirstLine, dummyUI.getFirstLine());
        assertEquals(expectedSecondLine, dummyUI.getSecondLine());
        assertEquals(expectedThirdLine, dummyUI.getThirdLine());
    }

    @Test
    public void testPurchasingOneBottleOfMilk() {
        String[] commandLineArguments = {"Milk"};

        String expectedFirstLine = "Subtotal: £1.30";
        String expectedSecondLine = "(no offers available)";
        String expectedThirdLine = "Total: £1.30";

        UserInterface.main(commandLineArguments);

        UserInterface dummyUI = new UserInterface(commandLineArguments);

        assertEquals(expectedFirstLine, dummyUI.getFirstLine());
        assertEquals(expectedSecondLine, dummyUI.getSecondLine());
        assertEquals(expectedThirdLine, dummyUI.getThirdLine());
    }

}