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

import org.junit.Test;
import org.tn5250j.encoding.CharMappings;
import org.tn5250j.encoding.ICodePage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Testing the correctness of {@link CCSID1147} and comparing with existing implementation.
 *
 * @author master_jaf
 */
public class CCSID1147Test {

    /**
     * Correctness test for old implementation ....
     * Testing byte -> Unicode -> byte
     */
    @Test
    public void testOldConverter1147() {

        ICodePage cp = CharMappings.getCodePage("1147");
        assertNotNull("At least an ASCII Codepage should be available.", cp);

        for (int i = 0; i < 256; i++) {
            final byte beginvalue = (byte) i;
            final char converted = cp.ebcdic2uni(beginvalue);
            final byte afterall = cp.uni2ebcdic(converted);
            assertEquals("Testing item #" + i, beginvalue, afterall);
        }

    }

    /**
     * Correctness test for new implementation ...
     * Testing byte -> Unicode -> byte
     */
    @Test
    public void testNewConverter1147() {
        CCSID1147 cp = new CCSID1147();
        cp.init();
        assertNotNull("At least an ASCII Codepage should be available.", cp);

        for (int i = 0; i < 256; i++) {
            final byte beginvalue = (byte) i;
            final char converted = cp.ebcdic2uni(beginvalue);
            final byte afterall = cp.uni2ebcdic(converted);
            assertEquals("Testing item #" + i, beginvalue, afterall);
        }
    }

    /**
     * Testing for Correctness both implementations ...
     * Testing byte -> Unicode -> byte
     */
    @Test
    public void testBoth() {
        final ICodePage cp = CharMappings.getCodePage("1147");
        final CCSID1147 cpex = new CCSID1147();
        cpex.init();
        assertNotNull("At least an ASCII Codepage should be available.", cpex);

        for (int i = 0; i < 256; i++) {
            final byte beginvalue = (byte) i;
            assertEquals("Testing to EBCDIC item #" + i, cp.ebcdic2uni(beginvalue), cpex.ebcdic2uni(beginvalue));
            final char converted = cp.ebcdic2uni(beginvalue);
            assertEquals("Testing to UNICODE item #" + i, cp.uni2ebcdic(converted), cpex.uni2ebcdic(converted));
            final byte afterall = cp.uni2ebcdic(converted);
            assertEquals("Testing before and after item #" + i, beginvalue, afterall);
        }
    }

}
