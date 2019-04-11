package ec.cjpq.parrot.security.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import org.zkoss.zul.DefaultTreeModel;
import org.zkoss.zul.DefaultTreeNode;
import org.zkoss.zul.TreeModel;
import ec.cjpq.parrot.util.Module;

public class MenuTreeModel {

    private TreeModel model; 

    public MenuTreeModel(){
        // http://zkfiddle.org/sample/1qfattf/3-Tree-with-onSelect-and-onOpen#source-2
        List<DefaultTreeNode<MenuItem>> root = new ArrayList<DefaultTreeNode<MenuItem>>();

        Subject currentUser = SecurityUtils.getSubject();
        // if (currentUser.hasRole("ei")) {
        if ( currentUser.hasRole(Module.EI.toString() )) {
            List<DefaultTreeNode<MenuItem>> branch = new ArrayList<DefaultTreeNode<MenuItem>>();
            branch.add(new DefaultTreeNode(new MenuItem("0101", "Configuración",           "/pages/ei/configuration.zul")));
            branch.add(new DefaultTreeNode(new MenuItem("0102", "Cola de autorizaciones" , "/pages/ei/panel.zul")));
            branch.add(new DefaultTreeNode(new MenuItem("0103", "Enviar Guía de Remisión", "/pages/ei/waybill.zul")));
            branch.add(new DefaultTreeNode(new MenuItem("0104", "Enviar Retención"       , "/pages/ei/retention.zul")));
            branch.add(new DefaultTreeNode(new MenuItem("0105", "Enviar Notas de Crédito", "/pages/ei/ar_transaction.zul")));
            branch.add(new DefaultTreeNode(new MenuItem("0106", "Enviar Notas de Débito" , "/pages/ei/ar_transaction.zul")));
            
            root  .add(new DefaultTreeNode(new MenuItem("01"  , "Facturación electrónica", ""), branch));
        }

        root.add(new DefaultTreeNode(new MenuItem("version", "Versión", "")));
        root.add(new DefaultTreeNode(new MenuItem("exit", "Salir",   "")));

        this.model = new DefaultTreeModel(new DefaultTreeNode(null, root));
    }
    
    public TreeModel getModel(){
        return model;
    }

}

