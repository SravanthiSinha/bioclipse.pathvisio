package net.bioclipse.pv.editor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.HeadlessException;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.PlatformUI;
import org.pathvisio.core.model.ConverterException;
import org.pathvisio.core.model.GpmlFormat;
import org.pathvisio.core.model.Pathway;

import org.pathvisio.core.model.PathwayImporter;
import org.pathvisio.core.preferences.PreferenceManager;
import org.pathvisio.core.view.VPathway;
import org.pathvisio.gui.view.VPathwaySwing;

public class PathvisioPanel extends JPanel{

    public static Pathway pathway;
    private VPathway vPathway;
    private VPathwaySwing wrapper;
   public static JPanel panel;
    private JScrollPane scrollPane = new JScrollPane();
    


    public PathvisioPanel() throws HeadlessException {
      PreferenceManager.init();
        
        panel = new JPanel(new BorderLayout());
      
     
        ISelection sel=PlatformUI.getWorkbench().getActiveWorkbenchWindow().getSelectionService().getSelection();
    IResource r = extractSelection(sel);
 
                    File f = r.getRawLocation().makeAbsolute().toFile(); 
                    try {
                        loadAndShow(f);
                    } catch (ConverterException e) {

                    }
              
                    
                    add(panel);

    }
    IResource extractSelection(ISelection sel) {
        if (!(sel instanceof IStructuredSelection))
           return null;
        IStructuredSelection ss = (IStructuredSelection) sel;
        Object element = ss.getFirstElement();
        if (element instanceof IResource)
           return (IResource) element;
        if (!(element instanceof IAdaptable))
           return null;
        IAdaptable adaptable = (IAdaptable)element;
        Object adapter = adaptable.getAdapter(IResource.class);
        return (IResource) adapter;
     }
    public void loadAndShow(File f) throws ConverterException {

        pathway = new Pathway();
        PathwayImporter importer = new GpmlFormat();
        pathway=importer.doImport(f);
      
        wrapper = new VPathwaySwing(scrollPane);
        vPathway = wrapper.createVPathway();
        vPathway.fromModel(pathway);
        vPathway.setEditMode(false);
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.setPreferredSize(scrollPane.getPreferredSize());
    }

    
}