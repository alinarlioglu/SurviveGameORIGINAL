/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.*;
import city.cs.engine.DynamicBody;
import org.jbox2d.common.Vec2;

/**
 * Creates a ball. It has a radius as well as mass and restitute.
 * @author Ali Narlioglu
 */
public class Ball extends DynamicBody{
    
    /**
     * The shape of the ball - circle. It has a radius of 0.5.
     */
    private static final Shape BALL = new CircleShape(0.5f);
    
    /**
     * Initialises the characteristics of the ball such as restitute and mass.
     * @param w The world to generate the ball in.
     * @param xPos The x-position the ball will be generated on.
     * @param yPos The y-position the ball will be generated on.
     */
    public Ball(GameLevel w, int xPos, int yPos) {
        super(w);

        //Setting the ball character within the world
        Body ballBody = new DynamicBody(w, BALL);
        ballBody.setPosition(new Vec2(xPos,yPos));
        
        //Making the balls weigh less and bouncy.
        SolidFixture ballFixture = new SolidFixture(ballBody, BALL);
        ballFixture.setDensity(1);
        ballFixture.setRestitution(1);
    }

 
    
}
