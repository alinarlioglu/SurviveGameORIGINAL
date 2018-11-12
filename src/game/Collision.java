/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import city.cs.engine.SoundClip;
import java.awt.Color;
import java.io.IOException;
import java.util.Random;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import org.jbox2d.common.Vec2;

/**
 * Handles the interaction between the bodies shapes. It initialises instances of certain classes as well.
 * @author Ali Narlioglu
 */
public class Collision implements CollisionListener{
    
    /**
     * Declares a non-visible instance of the 'SoundClip' class.
     */
    private SoundClip collisionSound;
    
    /**
     * Declares a non-visible instance of the 'Boxes' class.
     */
    private Boxes box;
    
    /**
     * Declares a non-visible instance of the 'Ball' class.
     */
    private Ball ballTwo;
    
    /**
     * Declares a non-visible instance of the 'Rectangle' class.
     */
    private Rectangle rectangle;
    
    /**
     * Declares a non-visible instance of the 'BallTest' class.
     */
    private BallTest ball;
    
    /**
     * Declares a non-visible instance of the 'Character' class.
     */
    private Character character;
    
    /**
     * Declares a non-visible instance of the 'PowerUp' class.
     */
    private PowerUp powerUp;
    
    /**
     * Declares a visible instance of the 'Time' class.
     */
    Time time;
    
    /**
     * Declares a visible instance of the 'Score' class.
     */
    Score score;
    
    /**
     * Initialises the various instances of the BallTest, Boxes and Rectangle classes as well as indicating the position these instances will start within the game window. 
     * Also, sets a constructor that will link the declared visible instances of the Time, Score, Character and PowerUp classes to the initialised instances within other classes.
     * @param character Instance of the 'Character' class.
     * @param powerUp Instance of the 'PowerUp' class.
     * @param time Instance of the 'Time' class.
     * @param score Instance of the 'Score' class.
     */
    public Collision(Character character, PowerUp powerUp, Time time, Score score) {
        this.character = character;
        this.powerUp=powerUp;
        this.time=time;
        this.score=score;
        
        box = new Boxes(time.getGame().getWorld());
        box.setPosition(new Vec2(-2,10));
        
        rectangle = new Rectangle(time.getGame().getWorld());
        rectangle.setPosition(new Vec2(0, 5));
        
        ball = new BallTest(time.getGame().getWorld());
        ball.setPosition(new Vec2(8,3));
    }

    /**
     * Returns the time instance.
     * @return The time instance.
     */
    public Time getTime() {
        return time;
    }

    /**
     * Detects the collisions between the different shapes and acts upon the detected collision.
     * The 'SoundClip' instance is initialised, so it plays a sound every time the 'Character' instance collides with any other shape instance - helps raise awareness of the decrease of the 'Character' instance's lives. 
     * Also, the lives of the 'Character' instance is decreased every time the instance collides with the other shape instances. It's decreased by running the 'numberOfLives' method of the Character class.
     * Once the integer value of lives reach zero - the game window is frozen at its current position.
     * <br>
     * When the 'Character' instance collides with the 'PowerUp' instance, then the 'Character' instances size increases by running the 'incrementSize' method of Character class.
     * When the 'Character' instance collides with the 'BallTest' instance, then the lives of the 'Character' instance is set to integer value of zero by running the 'setLives' method of Character class, and the game window is closed on collision as well.
     * When the 'Character' instance collides with the 'Rectangle' instance, then the 'Rectangle' instance is rotated 270 degrees and moved positions within the game window.
     * When the 'Character' instance collides with the 'Boxes' instance, then the 'Boxes' instance's colour is changed to any other random colour.
     * @param e Instance of the 'CollisionEvent' class - describes the geometry and dynamics of a collision between two objects.
     */
    @Override
    public void collide(CollisionEvent e) {
        if(e.getReportingBody() instanceof Character){
            try {
                collisionSound = new SoundClip("data/impact.wav");
                collisionSound.play();
            } catch (UnsupportedAudioFileException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
            } catch (LineUnavailableException ex) {
                ex.printStackTrace();
            }
            //Every time the robot character hits any other body, the numberOfLives() method is run
            character.numberOfLives();
            if((e.getOtherBody() instanceof PowerUp)){
               
                character.incrementSize();
            }
            if(e.getOtherBody() instanceof BallTest){
                character.setLives(0);
                System.out.println("GAME OVER! CAREFUL OF TOUCHING PARTICULAR ENEMIES....");
                System.exit(0);
            }
            if(e.getOtherBody() instanceof Rectangle) {
                rectangle.rotateDegrees(270);
                rectangle.move(new Vec2(0,6));
            }
            if(e.getOtherBody() instanceof Boxes) {
                //Generate a random number
                Random random = new Random();
                //Change the box colour to any random colour using the random number generator
                box.setFillColor(new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256)));
            }
            if(character.getLives()==0){
                character.stopWorld();
            }
        }

    }
}
