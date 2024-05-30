package com.JavaMaturita.client;

public class Button {
    private String image;
    private String action;
    private String path;
    private String id;
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Button" + id + "{'" +
                "image='" + image + '\'' +
                ", action='" + action + '\'' +
                ", path='" + path + '\'' +
                '}';
    }
}