package ec.cjpq.parrot.security.controller;

import org.apache.shiro.SecurityUtils;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;

import org.zkoss.zul.Tree;
import org.zkoss.zul.Treeitem;

import ec.cjpq.parrot.security.controller.MenuItem;
import ec.cjpq.parrot.util.Util;

public class TreeController extends SelectorComposer<Component>{

    @Wire
    private Tree rootTree;

    //https://www.zkoss.org/wiki/ZK_Developer%27s_Reference/MVC/Model/Tree_Model
    public void doAfterCompose(Component comp) throws Exception {
        super.doAfterCompose(comp);

        rootTree.setModel(new MenuTreeModel().getModel());
        rootTree.setItemRenderer(new MenuItemRenderer());
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
            Executions.sendRedirect("/pages/login.zul");
            SecurityUtils.getSubject().logout();
        }
        
    }
    
}
