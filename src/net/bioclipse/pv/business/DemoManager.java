/*******************************************************************************
 * Copyright (c) 2013  Sravanthi Sinha <kmitsravanthi@gmail.com>
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contact: http://www.bioclipse.net/
 ******************************************************************************/
package net.bioclipse.pv.business;

import net.bioclipse.managers.business.IBioclipseManager;
import net.bioclipse.pv.editor.PathvisioPanel;

import org.apache.log4j.Logger;
import org.pathvisio.core.model.ObjectType;
import org.pathvisio.core.model.Pathway;
import org.pathvisio.core.model.PathwayElement;

public class DemoManager implements IBioclipseManager {

	private static final Logger logger = Logger.getLogger(DemoManager.class);

	/**
	 * Gives a short one word name of the manager used as variable name when
	 * scripting.
	 */
	public String getManagerName() {
		return "pv";
	}

	public String test(String cmd) {
		return cmd;
	}

	public String getListOfDataNodes() {
		String datanodes= "";
		Pathway currentpathway = PathvisioPanel.pathway;
		for (PathwayElement pe : currentpathway.getDataObjects()) {

			if (pe.getObjectType() == ObjectType.DATANODE) {
				datanodes= datanodes+"\n"+pe.getTextLabel();
			}
		}
		return datanodes;

	}
}
