package com;

public class GeometricObject {
    private String color;
    private boolean filled;

    //无参构造
    public GeometricObject() {
        this("white", false);
    }

    //带参构造
    public GeometricObject(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    //color的访问器+修改器
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    //filled的访问器+修改器
    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }
}
