package ec.cjpq.parrot.security.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;

import org.zkoss.zul.DefaultTreeModel;
import org.zkoss.zul.DefaultTreeNode;
import org.zkoss.zul.Tree;
import org.zkoss.zul.TreeModel;
import org.zkoss.zul.Treeitem;

import ec.cjpq.parrot.security.controller.MenuItem;
import ec.cjpq.parrot.util.Util;

public class TreeController extends SelectorComposer<Component>{

    @Wire
    private Tree rootTree;

    //https://www.zkoss.org/wiki/ZK_Developer%27s_Reference/MVC/Model/Tree_Model
    public void doAfterCompose(Component comp) throws Exception {
        super.doAfterCompose(comp);

        rootTree.setModel(buildModel());
        rootTree.setItemRenderer(new MenuItemRenderer());
    }

    private TreeModel buildModel(){
        // http://zkfiddle.org/sample/1qfattf/3-Tree-with-onSelect-and-onOpen#source-2
        List<DefaultTreeNode<MenuItem>> rootChildren = new ArrayList<DefaultTreeNode<MenuItem>>();

        Subject currentUser = SecurityUtils.getSubject();
        if (currentUser.hasRole("ei")) {
            List<DefaultTreeNode<MenuItem>> nodeChildren = new ArrayList<DefaultTreeNode<MenuItem>>();
            nodeChildren.add(new DefaultTreeNode(new MenuItem("0101", "Configuración",           "/ei/configuracion.zul")));
            nodeChildren.add(new DefaultTreeNode(new MenuItem("0102", "Cola de autorizaciones" , "/ei/configuracion.zul")));
            nodeChildren.add(new DefaultTreeNode(new MenuItem("0103", "Enviar Guía de Remisión", "/ei/configuracion.zul")));
            nodeChildren.add(new DefaultTreeNode(new MenuItem("0104", "Enviar Retención"       , "/ei/configuracion.zul")));
            nodeChildren.add(new DefaultTreeNode(new MenuItem("0105", "Enviar Notas de Crédito", "/ei/configuracion.zul")));
            nodeChildren.add(new DefaultTreeNode(new MenuItem("0106", "Enviar Notas de Débito" , "/ei/configuracion.zul")));
            rootChildren.add(new DefaultTreeNode(new MenuItem("01", "Facturación electrónica", ""), nodeChildren));
        }

        rootChildren.add(new DefaultTreeNode(new MenuItem("version", "Versión", "")));
        rootChildren.add(new DefaultTreeNode(new MenuItem("exit", "Salir",   "")));

        TreeModel model = new DefaultTreeModel(new DefaultTreeNode(null, rootChildren));

        return model;
    }

    @Listen("onClick=#rootTree")
    public void doAction(){
        //System.out.println("onClick");

        Treeitem treeItem = rootTree.getSelectedItem();
        MenuItem menuItem = (MenuItem)treeItem.getValue();

        //If a treeItem has a defined form, execute it
        if (menuItem.getForm().length() > 0){
           Util.getInstance().showForm(menuItem.getForm());
        }

        //if (menuItem.getDescription().equals("Salir")){
        if (menuItem.getId().equals("exit")){
            Executions.sendRedirect("/login.zul");
            SecurityUtils.getSubject().logout();
        }
        
    }
    
}


