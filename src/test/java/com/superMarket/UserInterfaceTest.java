package com.superMarket;

import org.junit.Test;

import java.lang.RuntimeException;

import com.superMarket.UserInterface;

import static org.junit.Assert.*;

public class UserInterfaceTest {

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

    @Test(expected = RuntimeException.class)
    public void verifyThatErrorMessageIsThrownIfTheUserRequestsItemsNonInTheList() {
        String[] commandLineArguments = {"Pumkin"};

        UserInterface.main(commandLineArguments);
    }

}