package net.bioclipse.pv.editor;


import java.awt.Panel;

import javax.swing.JFrame;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.awt.SWT_AWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.EditorPart;


 public class PathvisioEditor extends EditorPart {
      private JFrame contents;
      public PathvisioEditor()
      {
    	  super();
      }
      public void createPartControl(Composite parent) {
     
        // contents=new GPMLTest();
    	  try {
          	System.setProperty("sun.awt.noerasebackground", "true");
          } catch (NoSuchMethodError error) {
          }

          //Set the layout for parent
          GridLayout layout = new GridLayout();
          layout.numColumns = 1;
          layout.verticalSpacing = 2;
          layout.marginWidth = 0;
          layout.marginHeight = 2;
          
          parent.setLayout(layout);

          GridData layoutData = new GridData();
          layoutData.grabExcessHorizontalSpace = true;
          layoutData.grabExcessVerticalSpace = true;
          parent.setLayoutData(layoutData);

          //Add the Jmol composite to the top
          Composite composite = new Composite( parent, SWT.NO_BACKGROUND 
                                                     | SWT.EMBEDDED
                                                     | SWT.DOUBLE_BUFFERED );
          layout = new GridLayout();
          composite.setLayout(layout);
          layoutData = new GridData(GridData.FILL_BOTH);
          composite.setLayoutData(layoutData);

          java.awt.Frame awtFrame = SWT_AWT.new_Frame(composite);
          java.awt.Panel awtPanel 
              = new java.awt.Panel(new java.awt.BorderLayout());
          awtFrame.add(new PathvisioPanel());
         
      }
      
     
	@Override
	public void doSave(IProgressMonitor monitor) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void doSaveAs() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void init(IEditorSite site, IEditorInput input)
			throws PartInitException {
		// TODO Auto-generated method stub
		  setSite(site);
	         setInput(input);
	}
	@Override
	public boolean isDirty() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean isSaveAsAllowed() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void setFocus() {
		// TODO Auto-generated method stub
		
	}
   }