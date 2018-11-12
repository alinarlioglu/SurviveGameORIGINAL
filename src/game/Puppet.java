/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.BodyImage;
import city.cs.engine.DynamicBody;
import city.cs.engine.PolygonShape;
import city.cs.engine.Shape;
import city.cs.engine.World;

/**
 * Creates a polygon shape with an image attached.
 * @author Ali Narlioglu
 */
public class Puppet extends DynamicBody {
    
    /**
     * Sets the polygon shape.
     */
    //Setting the shape for the puppet character
    private static final Shape PUPPET_SHAPE = new PolygonShape(0.424f,0.961f, 0.268f,0.697f, 0.126f,-0.147f, 0.182f,-0.615f, 0.818f,-0.584f, 0.801f,-0.087f, 0.723f,0.684f, 0.532f,0.879f);
    
    /**
     * Variable obtains and holds a puppet image.
     */
    //Setting the image for the puppet character
    private static final BodyImage PUPPET_IMAGE = new BodyImage("data/puppet5.png", 3);

    /**
     * Initialises the polygon shape and attaches the image of the puppet on the shape.
     * @param w The world the puppet will be generated in.
     */
    public Puppet(GameLevel w) {
        //Implementing the puppet character into the world
        super(w, PUPPET_SHAPE);
        //Adding an image on the puppet character
        addImage(PUPPET_IMAGE);
    }

    
    
}
