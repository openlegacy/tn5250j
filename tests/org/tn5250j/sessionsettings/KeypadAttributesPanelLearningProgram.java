/*
 * Title: KeypadAttributesPanelLearningTest.java
 * Copyright:   Copyright (c) 2016
 * Company:
 *
 * @author Martin W. Kirst
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
package org.tn5250j.sessionsettings;

import org.tn5250j.SessionConfig;
import org.tn5250j.tools.LangTool;

import javax.swing.*;
import java.awt.*;

public class KeypadAttributesPanelLearningProgram {

    public static void main(String[] args) {
        LangTool.init();

        SessionConfig config = new SessionConfig("test-configuration-resource", "test-session");
        KeypadAttributesPanel keypadAttributesPanel = new KeypadAttributesPanel(config);

        showPanel(keypadAttributesPanel);
    }

    private static void showPanel(JPanel panel) {
        JFrame frame = new JFrame("FrameDemo");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }
}
