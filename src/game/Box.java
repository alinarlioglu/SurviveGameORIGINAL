/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.BodyImage;
import city.cs.engine.BoxShape;
import city.cs.engine.DynamicBody;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

/**
 * Creates a square. It has a set width and height.
 * @author Ali Narlioglu
 */
public class Box extends DynamicBody{
    
    /**
     * Initialises the characteristics of the square such as the width and height. It adds an image on the square as well.
     * @param w The world to generate the square on.
     * @param xPos The x-position the square will be generated on.
     * @param yPos The y-position the square will be generated on.
     */
    public Box(GameLevel w, int xPos, int yPos) {
        super(w);
        
        //Creating and implementing an image to the body
        Shape box = new BoxShape(0.5f,0.5f);
        DynamicBody boxBody = new DynamicBody(w, box);
        BodyImage boxImage = new BodyImage("data/hi.jpg", 2);
        boxBody.addImage(boxImage);
        boxBody.setPosition(new Vec2(xPos, yPos));
        
           
    }

}
