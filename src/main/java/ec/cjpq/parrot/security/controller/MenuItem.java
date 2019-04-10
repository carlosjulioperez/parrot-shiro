package ec.cjpq.parrot.security.controller;

public class MenuItem{
    
    private String id;
    private String description;
    private String form;

    public MenuItem(String id, String description, String form) {
        this.id = id;
        this.description = description;
        this.form = form;
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getForm() {
        return form;
    }

}
