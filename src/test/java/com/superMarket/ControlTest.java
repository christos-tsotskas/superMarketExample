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

import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.sun.jmx.mbeanserver.Util.cast;
import static org.junit.Assert.*;

public class ControlTest {



    @Test
    public void checkThatRequestedItemsExist() throws Exception {
        //TODO implement
    }

    @Test
    public void getRequestedItems() throws Exception {
        //TODO implement
    }

    @Test
    public void testConvertingArrayOfStringsToCapital() {
        String[] lowerCaseArrayOfStrings = {"aa", "bb"};
        Control c1 = new Control( lowerCaseArrayOfStrings );
        Class controlKlass = com.superMarket.Control.class;
        List<String> expected = Arrays.asList("AA", "BB");
        ArrayList<String> actual; // = new ArrayList<String>();
        try {

            Method method7 = controlKlass.getDeclaredMethod("convertArrayOfStringsToCapital", lowerCaseArrayOfStrings.getClass());
            method7.setAccessible(true);
            Object obj7 = method7.invoke(c1, new Object[]{ lowerCaseArrayOfStrings});
            actual = cast(obj7);


            assertEquals(expected, actual);



        }catch (NoSuchMethodException n){
            System.err.println("Caught NoSuchMethodException: " + n.getMessage());
        }catch (IllegalAccessException i){
            System.err.println("Caught IllegalAccessException: " + i.getMessage());
        }catch (InvocationTargetException i2){
            System.err.println("Caught InvocationTargetException: " + i2.getMessage());
        }catch (Exception e){
          System.err.println("Caught Exception: " + e.getMessage());
        }
    }

}