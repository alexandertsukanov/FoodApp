package com.gda.ws.forms;

public class CategoryForm {
    private Long id;
    private String name;
    private String link;
    private String linkBig;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getLinkBig() {
        return linkBig;
    }

    public void setLinkBig(String linkBig) {
        this.linkBig = linkBig;
    }
}
