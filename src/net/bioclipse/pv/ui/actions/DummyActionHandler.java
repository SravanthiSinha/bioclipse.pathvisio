package net.bioclipse.pv.ui.actions;


import java.util.Map;
import java.util.concurrent.ExecutionException;

import net.bioclipse.cdk.domain.CDKMoleculeSelectionHelper;
import net.bioclipse.cdk.domain.ICDKMolecule;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.jface.viewers.ISelection;

import org.eclipse.ui.handlers.HandlerUtil;



public class DummyActionHandler extends AbstractHandler{
  @Override
  public Object execute(ExecutionEvent arg0) {
	 
	  ExecutionEvent event = null;
	ISelection sel = HandlerUtil.getCurrentSelection( event );
	
	return arg0;
 
  }

public Object execute(Map parameterValuesByName) throws ExecutionException {
	// TODO Auto-generated method stub
	return null;
}
 }