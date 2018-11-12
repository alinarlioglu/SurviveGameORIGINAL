/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.CircleShape;
import city.cs.engine.Shape;
import city.cs.engine.Walker;
import city.cs.engine.World;

/**
 * Creates a circle. It has a radius.
 * @author Ali Narlioglu
 */
public class PowerUp extends Walker{

    /**
     * Sets a circle shape with 0.2 radius.
     */
    private static Shape powerUp = new CircleShape(0.2f);
    
    /**
     * Creates the circle object and initialises it's attributes.
     * @param w The world to generate the circle in.
     */
    public PowerUp(World w) {
        super(w, powerUp);
    }
    
    
}
