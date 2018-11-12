/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.BodyImage;
import city.cs.engine.PolygonShape;
import city.cs.engine.Shape;
import city.cs.engine.StaticBody;
/**
 * Creates a character with the appearance of a robot. The robot has features ranging from lives to size.
 * @author Ali Narlioglu
 */
public class Character extends StaticBody{

    /**
     * The shape of the character - polygon.
     */
    //Setting the shape for the character
    private static final Shape ROBOT_SHAPE = new PolygonShape(0.09f,1.5f, 0.69f,0.96f, 1.27f,-0.85f, 0.76f,-1.48f, -0.72f,-1.49f, -1.28f,-0.82f, -0.68f,0.96f, -0.14f,1.49f);
    
    /**
     * Robot image is obtained and held by a variable.
     */
    //Setting the image for the character
    private static final BodyImage ROBOT_IMAGE = new BodyImage("Data/robot.png", 2);

    /**
     * The lives feature.
     */
    private int lives;
    
    /**
     * The world to generate the character in.
     */
    private GameLevel w;
    
    /**
     * The size feature.
     */
    private int size;
    
    /**
     * Initialises the character and places a robot image on the character.
     * Also, lives is initialised to an integer - four.
     * @param w The world the character will be generated on.
     */
    public Character(GameLevel w) {
        //Implementing the robot character into the world
        super(w,ROBOT_SHAPE);
        this.w = w;
        //Implementing the image to the robot character
        addImage(ROBOT_IMAGE);
        //Adding a lives attribute to the robot character, so every time it hits another body the lives decreases.
        lives=4;
        
    }

    /**
     * Returns the size of the character.
     * @return The integer value of the character's size.
     */
    public int getSize() {
        return size;
    }

    /**
     * Increase the character's size - in terms of an integer. Then, implements the new size to the character.
     */
    public void incrementSize() {
        //Increases the size of the image
        BodyImage robotImageChange = new BodyImage("Data/robot.png", 4);
        addImage(robotImageChange);
    }
    
    /**
     * Changes the lives.
     * @param lives The integer value.
     */
    public void setLives(int lives) {
        this.lives=lives;
    }
    
    /**
     * Returns the lives.
     * @return The integer value.
     */
    public int getLives() {
        return lives;
    }

    /**
     * Sets the lives to an integer - four.
     */
    public void fixedLives(){
        lives = 4;
    }
    
    /**
     * Stops the runtime of the game window at its current position.
     */
    public void stopWorld(){
        System.out.println("Stopping world!");
        w.stop();
    }
    
    /**
     * Decreases the integer value of lives by one.
     */
    public void numberOfLives() {
        lives--;
        System.out.println("Lives left: " + lives);  
    }
    
}
