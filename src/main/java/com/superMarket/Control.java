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

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Control perspective in Model-View-Control
 */
public class Control {

    /**
     * @param allowedItems available items provided by the supermarket
     */
    List<String> allowedItems;

    /**
     * @param requestedItems items requested by the user (via the command line)
     */
    String[] requestedItems;

    /**
     * Convert an array of strings in capitals
     *
     * @param inputArrayOfStrings list of literals to convert to capital
     * @return list of strings in capitals
     */
    private List<String> convertArrayOfStringsToCapital(String[] inputArrayOfStrings) {
        List<String> capitalisedArrayOfStrings = new ArrayList<String>();

        for (String item : Arrays.asList(inputArrayOfStrings)) {
            capitalisedArrayOfStrings.add(item.toUpperCase());
        }

        return capitalisedArrayOfStrings;
    }


    /**
     * Constructor
     *
     * @param itemsToCheck array of strings to check
     */
    public Control(String[] itemsToCheck) {
        String[] good = {"Apples", "Milk", "Bread", "Soup"};
        allowedItems = convertArrayOfStringsToCapital(good);
        requestedItems = itemsToCheck;
    }


    /**
     * Checks that the requested items exist in the list, otherwise raises an exception
     *
     * @throws RuntimeException if the requested items are not provided by the supermarket
     */
    public void checkThatRequestedItemsExist() throws RuntimeException {

        for (String item : requestedItems) {
            if (allowedItems.contains(item.toUpperCase()) == false) {
                throw new java.lang.RuntimeException("The item(s) is/are not available!");
            }
        }
    }

    /**
     * Get the requested items
     *
     * @return list of strings that describe the requested items
     */
    public List<String> getRequestedItems() {
        return Arrays.asList(requestedItems);
    }



}
