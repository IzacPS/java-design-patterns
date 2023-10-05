package me.izac.pattern.structural.flyweight;

import java.util.HashMap;

public class ShapeFactory {
    private static final HashMap<ShapeType, Shape> shapes = new HashMap<>();

    public static Shape getShape(ShapeType type){
        Shape shapeImpl = shapes.get(type);
        if(shapeImpl == null){
            shapeImpl = switch (type){
                case LINE -> new Line();
                case OVAL -> new Oval(false);
                case OVAL_FILL -> new Oval(true);
            };
            shapes.put(type, shapeImpl);
        }
        return shapeImpl;
    }

    public static enum ShapeType{
        OVAL_FILL, OVAL, LINE;
    }

}
