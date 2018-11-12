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
 * Creates a rectangle. It has a set width and height.
 * @author Ali Narlioglu
 */
public class Rectangle extends DynamicBody{

    /**
     * Sets the rectangle's width and height.
     */
    private static final Shape RECTANGLE = new BoxShape(1, 0.5f);
    
    /**
     * Initialises the rectangle's attributes within the indicated world.
     * @param w The world to generate the rectangle in.
     */
    public Rectangle(GameLevel w) {
        super(w, RECTANGLE);
        
        
    }
    
    
}
