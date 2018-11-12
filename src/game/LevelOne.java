/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.Body;
import city.cs.engine.BoxShape;
import city.cs.engine.Shape;
import city.cs.engine.SolidFixture;
import city.cs.engine.SoundClip;
import city.cs.engine.StaticBody;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import org.jbox2d.common.Vec2;

/**
 * Class used to initialise the first level of the game.
 * @author Ali Narlioglu
 */
public class LevelOne extends GameLevel {

     /**
     * Declares a visible instance of 'Time' class.
     */
    Time time;
    
     /**
     * Constructs a declared linked 'Time' instance to the initialised 'Time' instance in the other classes.
     * Also, it sets the finish level requirements to an integer value of 10, and starts playing the background music by initialising 'gameMusic'.
     * @param time 'Time' class instance.
     */
    public LevelOne(Time time) {
        this.finishLevel = 10;
        this.time=time;
        try {
            this.gameMusic = new SoundClip("data/level1.wav");
            gameMusic.loop();
        } catch (UnsupportedAudioFileException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (LineUnavailableException ex) {
            ex.printStackTrace();
        }
    }
    
    /**
     * Adds instances and objects to the current level.
     * @param game The class used to initialise the changing of levels.
     */
    @Override
    public void populate(Game game) {
        super.populate(game);
        //Left Wall
        Shape leftPlatform = new BoxShape(0.25f, 30);
        Body leftBody = new StaticBody(this, leftPlatform);
        leftBody.setPosition(new Vec2(-12.25f, -12));

        //Allows the balls to bounce off the left wall in a fixed speed without the balls slowing down or moving faster.
        SolidFixture leftFixture = new SolidFixture(leftBody, leftPlatform);
        leftFixture.setDensity(1);
        leftFixture.setRestitution(1);

        //Right Wall
        Shape rightPlatform = new BoxShape(0.25f, 30);
        Body rightBody = new StaticBody(this, rightPlatform);
        rightBody.setPosition(new Vec2(12.25f, -12));

        //Allows the balls to bounce off the right wall in a fixed speed without the balls slowing down or moving faster.
        SolidFixture rightFixture = new SolidFixture(rightBody, rightPlatform);
        rightFixture.setDensity(1);
        rightFixture.setRestitution(1);

        //Top Wall
        Shape topPlatform = new BoxShape(30, 0.25f);
        Body topBody = new StaticBody(this, topPlatform);
        topBody.setPosition(new Vec2(-12, 12.25f));

        //Allows the balls to bounce off the top wall in a fixed speed without the balls slowing down or moving faster.
        SolidFixture topFixture = new SolidFixture(topBody, topPlatform);
        topFixture.setDensity(1);
        topFixture.setRestitution(1);

        //Bottom Wall
        Shape bottomPlatform = new BoxShape(30, 0.25f);
        Body bottomBody = new StaticBody(this, bottomPlatform);
        bottomBody.setPosition(new Vec2(-12, -12.25f));

        //Allows the balls to bounce off the bottom wall in a fixed speed without the balls slowing down or moving faster.
        SolidFixture bottomFixture = new SolidFixture(bottomBody, bottomPlatform);
        bottomFixture.setDensity(1);
        bottomFixture.setRestitution(1);

        //Creating a ball object within the world
        Ball ballTwo = new Ball(this, 6, 1);
        ballTwo.setLinearVelocity(new Vec2(-2, -10));

        //Creating a box object within the world
        Box boxOne = new Box(this, -6, 9);

        Puppet puppet = new Puppet(this);
        puppet.setPosition(new Vec2(10, 10));

        //Creating a powerUp object and setting the position
        PowerUp powerUp = new PowerUp(this);
        powerUp.setPosition(new Vec2(-10, 10));
    }
    
    /**
     * Returns the instance of 'SoundClip' class.
     * @return Instance of 'SoundClip' class.
     */
    @Override
    public SoundClip getGameMusic(){
        return gameMusic;
    }
    
    /**
     * Stops the background music of the level.
     */
    @Override
    public void stopSound(){
        gameMusic.stop();
    }
    
     /**
     * Returns an integer value needed to finish the current level.
     * @return The integer value.
     */
    @Override
    public int getFinishLevel() {
        return finishLevel;
    }
    
    /**
     * Returns a boolean value if the player's score matches the finish level requirements of the current level.
     * @return True or false.
     */
    @Override
    public boolean isCompleted() {
        return time.secondsPassed==finishLevel;
    }
}
