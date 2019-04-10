package ec.cjpq.parrot.security.controller;

import org.zkoss.zul.DefaultTreeNode;
import org.zkoss.zul.Treeitem;
import org.zkoss.zul.TreeitemRenderer;

import ec.cjpq.parrot.security.controller.MenuItem;

public class MenuItemRenderer implements TreeitemRenderer<DefaultTreeNode<MenuItem>> {
    public void render(Treeitem item, DefaultTreeNode<MenuItem> data, int index) throws Exception {
        MenuItem menuItem = data.getData();
        item.setValue(menuItem);
        item.setLabel(menuItem.getDescription());

        // Treerow treeRow = new Treerow();
        // item.appendChild(treeRow);
        // treeRow.appendChild(new Treecell(menuItem.getDescription()));
        // //treeRow.appendChild(new Treecell(menuItem.getFormi()));
    }
}
