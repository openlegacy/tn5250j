/*
 * Title: PrintAction.java
 * Copyright:   Copyright (c) 2001,2002
 * Company:
 *
 * @author Kenneth J. Pouncey
 * @version 0.5
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
package org.tn5250j.keyboard.actions;

import org.tn5250j.SessionPanel;
import org.tn5250j.TN5250jConstants;
import org.tn5250j.keyboard.KeyMapper;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import static org.tn5250j.keyboard.KeyMnemonic.PRINT_SCREEN;

/**
 * Display session attributes
 */
public class PrintAction extends EmulatorAction {

    private static final long serialVersionUID = 1L;

    public PrintAction(SessionPanel session, KeyMapper keyMap) {
        super(session,
                PRINT_SCREEN.mnemonic,
                KeyStroke.getKeyStroke(KeyEvent.VK_P, KeyEvent.ALT_MASK),
                keyMap);

    }

    public void actionPerformed(ActionEvent e) {
        session.printMe();
    }
}

