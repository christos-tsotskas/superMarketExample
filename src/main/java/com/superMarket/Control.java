package com.superMarket;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Control {

    List<String> allowedItems;
    String[] requestedItems;

    private List<String> convertArrayOfSTringsToCapital(String[] inputArrayOfStrings){
       List<String> capitalisedArrayOfStrings = new ArrayList<String>();

        for(String item : Arrays.asList(inputArrayOfStrings) ){
            capitalisedArrayOfStrings.add(item.toUpperCase());
        }

        return capitalisedArrayOfStrings;
    }

    public Control(String[] itemsToCheck){
        String[] good = {"Apples", "Milk", "Bread", "Soup"};
        allowedItems = convertArrayOfSTringsToCapital(good);
        requestedItems = itemsToCheck;
    }

    public void checkThatRequestedItemsExist(){

        for (String item : requestedItems){
            if (allowedItems.contains(item.toUpperCase()) == false) {
                throw new java.lang.RuntimeException("this is not quite as bad");
            }
        }
    }
}
