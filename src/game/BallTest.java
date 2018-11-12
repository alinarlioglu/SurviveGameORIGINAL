/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.CircleShape;
import city.cs.engine.DynamicBody;
import city.cs.engine.Shape;

/**
 * Creates a ball. It has a radius as well as mass and restitute.
 * @author Ali Narlioglu
 */
public class BallTest extends DynamicBody{
    
    /**
     * The shape of the ball - circle. It has a radius of 0.5.
     */
    private static final Shape BALL_SHAPE = new CircleShape(0.25f);
    
    /**
     * Initialises the characteristics of the ball.
     * @param w The world to generate the ball in.
     */
    public BallTest(GameLevel w) {
        super(w, BALL_SHAPE);
    }

    
    
}
