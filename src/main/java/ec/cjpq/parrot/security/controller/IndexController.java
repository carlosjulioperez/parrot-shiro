package ec.cjpq.parrot.security.controller;

import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;

import org.zkoss.zul.Window;

public class IndexController extends SelectorComposer<Window>{

    // @Wire
    // Tree rootTree;

    @Listen("onClick=#rootTree")
    public void showForm(){
        System.out.println("Click");
    }
    
}

