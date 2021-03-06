/**
 * Created by Hoan Tran @ http://hoantran-it.blogspot.com
 *
 * Any modifications to this file must keep this entire header intact.
 *
 */
package com.github.hoantran.lib.utility.validation;

import static org.junit.Assert.*;

import org.junit.Test;

import com.github.hoantran.lib.utility.validation.NumberValidation;

/**
 * @author hoan.tran
 */
public class TestNumberValidation {

    @Test
    public void testIsNumeric() {
        assertTrue(NumberValidation.isNumber("123"));
        assertTrue(NumberValidation.isNumber("0123"));
        assertFalse(NumberValidation.isNumber("123 "));
        assertFalse(NumberValidation.isNumber("abc"));
    }

}
