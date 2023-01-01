/**
 * $Id$
 * <p>
 * Title: tn5250J
 * Copyright:   Copyright (c) 2001,2009
 * Company:
 *
 * @author: master_jaf
 * <p>
 * Description:
 * <p>
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2, or (at your option)
 * any later version.
 * <p>
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * <p>
 * You should have received a copy of the GNU General Public License
 * along with this software; see the file COPYING.  If not, write to
 * the Free Software Foundation, Inc., 59 Temple Place, Suite 330,
 * Boston, MA 02111-1307 USA
 */
package org.tn5250j.encoding.builtin;

import org.junit.Before;
import org.junit.Test;
import org.tn5250j.encoding.CharMappings;
import org.tn5250j.encoding.ICodePage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Testing the correctness of {@link CCSID500Ex} and comparing with existing implementation.
 *
 * @author master_jaf
 */
public class CCSID500Test {

    private char[] TESTSTRING = new char[255];

    @Before
    public void setUp() {
        for (int i = 1; i <= 255; i++) {
            TESTSTRING[i - 1] = (char) i;
        }
    }

    /**
     * Correctness test for old implementation ....
     */
    @Test
    public void testOldConverter500() {

        ICodePage cp = CharMappings.getCodePage("500-ch");
        assertNotNull("At least an ASCII Codepage should be available.", cp);

        for (int i = 0; i < TESTSTRING.length; i++) {
            final char beginvalue = TESTSTRING[i];
            final byte converted = cp.uni2ebcdic(beginvalue);
            final char afterall = cp.ebcdic2uni(converted & 0xFF);
            assertEquals("Testing item #" + i, beginvalue, afterall);
        }

    }

    /**
     * Correctness test for new implementation ...
     */
    @Test
    public void testNewConverter500() {
        CCSID500 cp = new CCSID500();
        cp.init();
        assertNotNull("At least an ASCII Codepage should be available.", cp);

        for (int i = 0; i < TESTSTRING.length; i++) {
            final char beginvalue = TESTSTRING[i];
            final byte converted = cp.uni2ebcdic(beginvalue);
            final char afterall = cp.ebcdic2uni(converted & 0xFF);
            assertEquals("Testing item #" + i, beginvalue, afterall);
        }
    }

}
