/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.BoxShape;
import city.cs.engine.DynamicBody;
import city.cs.engine.Shape;

/**
 * Creates a square. It has a set width and height.
 * @author Ali Narlioglu
 */
public class Boxes extends DynamicBody{
    
    /**
     * The square's characteristics such as the width and height are set.
     */
    private static Shape BOX = new BoxShape(0.3f, 0.3f);

    /**
     * Initialises the characteristics of the square.
     * @param w The world the square will be generated on.
     */
    public Boxes(GameLevel w) {
        super(w, BOX);
    }    
}
