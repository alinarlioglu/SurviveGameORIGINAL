/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.KeyListener;
import javax.swing.JFrame;

/**
 * Initialises the game by creating a window frame to play the game within. It changes the current level as well as implements the collision and mouse handlers to the concurrent level.
 * @author Ali Narlioglu
 */
public class Game {

    /**
     * Declaring a JFrame instance to create the game window.
     */
    //Creates a window to display and interact with the game
    private JFrame frame;
    
    /**
     * Declaring the world the game will be initialised.
     */
    //The world in which objects will interact.
    private GameLevel world;
    
    /**
     * Declares the 'MyView' instance allowing the game to be viewed and displayed in an interactive format.
     */
    //Displays the game in an understandable and interactive format.
    private MyView view;
    
    /**
     * Declares an integer variable.
     */
    private int level;
    
    /**
     * Declares an instance of 'mouseMovement' class.
     */
    private mouseMovement mouse;
    
    /**
     * Declares an instance of the 'Time' class.
     */
    private Time time;
    
    /**
     * Declares a keyListener object. It allows the game to receive key actions.
     */
    private KeyListener keyListener;
    
    /**
     * Declares a visible instance of this ('Game') class.
     */
    Game game;
    
    /**
     * Initialising the game to the first level by initialising the 'GameLevel' instance to its subclass - 'LevelOne', and adding the 'world' instance to the view instance.
     * The time, view, mouse and keyListener instances are initialised and added to the view as well. The 'frame' instance is used to create and display a game window to play each level and components such as the buttons from the 'ControlPanel' class, and the view instance are added to the 'frame' instance. 
     * Thus, this allows the various instances' effects to be seen on the game such as the 'mouse' instance allows the user to control the 'Character' instance by moving the mouse within the game window.
     */
    public Game(){
        level = 1;
        //Setting the world to the GameWorld class
        System.out.println("Level 1!");
        world = new LevelOne(new Time(this));
        world.populate(this);
        time = new Time(this);
        time.start();
        //Adding mouse movement events and putting the world into a graphical view.
        view = new MyView(world, 600,500, time, this);
        mouse = new mouseMovement(view, world, view);
        keyListener = new Restart(world, mouse.getCharacter(), time, this, view, view.getHighscore());
        
        //Enabling character movement by moving the mouse around the window
        view.addMouseMotionListener(mouse);
        
        //Passing the initialized character to the view
        view.setCharacter(mouse.getCharacter());
        
        //Adding a KeyListener to allow the 'ENTER' key to allow the game to restart
        view.addKeyListener(keyListener);
        
        //Allows the window to receive key events.
        view.setFocusable(true);
        
        frame = new JFrame("Game");
        //Terminates the game once the game window is closed.
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true); 
        //Displays the game world in a window
        frame.add(view);
        frame.pack();
        //Adding an interface to control the game.
        Container buttons = new ControlPanel(world, mouse.getCharacter(), time, this, view, view.getHighscore());
        frame.add(buttons, BorderLayout.WEST);
        //Makes the window visible including the added components to the frame.
        frame.setVisible(true);

        //Starts the game
        world.start();
    }
    
    /**
     * Returns a boolean value if the 'isCompleted' method of the current world (level) is true.
     * @return True or false.
     */
    public boolean isCurrentLevelCompleted() {
        return world.isCompleted();
    }

    /**
     * Changes the level value.
     * @param level The integer value.
     */
    public void setLevel(int level) {
        this.level = level;
    }
    
    /**
     * Returns the required integer value needed to finish the current level.
     * @return The integer value.
     */
    public int finish(){
        return world.getFinishLevel();
    }
    
    /**
     * Changes the game level by checking the 'level' variable's current integer value. The game level is changed only if the current level's finishing requirements are met.
     * Every time a new level is initialised, the instances of 'world', 'mouse', 'keyListener' and 'frame' are overwritten, thus the instances' effects can be seen on the next level as well, and the next level can be generated by overwriting the 'frame' instance.
     */
    public void goNextLevel() {
        world.stop();
        if(level == 4) {
            System.exit(0);
        } else if(level == 1) { 
            world.stopSound();
            level++;
            //Overwrite the world to the LevelTwo class
            world = new LevelTwo(time);
            //Deleting the old frame
            frame.dispose();
            //Add bodies and platforms to the world
            world.populate(this);
            //Change the world the view is displaying
            view.setWorld(world);
            mouse = new mouseMovement(view, world, view);
            keyListener = new Restart(world, mouse.getCharacter(), time, this, view, view.getHighscore());
            //Add bodies and methods to the new world
            view.setCharacter(mouse.getCharacter());
            view.addMouseMotionListener(mouse);
            view.addKeyListener(keyListener);
            view.setFocusable(true);
            
            //Creating a new frame for the restart button to work
            frame = new JFrame("Game");
            //Terminates the game once the game window is closed.
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationByPlatform(true); 
            //Displays the game world in a window
            frame.add(view);
            frame.pack();
            //Adding an interface to control the game.
            Container buttons = new ControlPanel(world, mouse.getCharacter(), time, this, view, view.getHighscore());
            frame.add(buttons, BorderLayout.WEST);
            //Makes the window visible including the added components to the frame.
            frame.setVisible(true);
            
            //Run the game!
            world.start();
            System.out.println("Congratulations! You've reached level 2!");

        } else if(level == 2){
            world.stopSound();
            level++;
            //Overwrite the world to the LevelThree class
            world = new LevelThree(time);
            //Deleting the old frame
            frame.dispose();
            //Add bodies and platforms to the world
            world.populate(this);
            //Change the world the view is displaying
            view.setWorld(world);
            mouse = new mouseMovement(view, world, view);
            keyListener = new Restart(world, mouse.getCharacter(), time, this, view, view.getHighscore());
            //Add bodies and methods to the new world
            view.setCharacter(mouse.getCharacter());
            view.addMouseMotionListener(mouse);
            view.addKeyListener(keyListener);
            view.setFocusable(true);
            
            //Creating a new frame for the restart button to work 
            frame = new JFrame("Game");
            //Terminates the game once the game window is closed.
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationByPlatform(true); 
            //Displays the game world in a window
            frame.add(view);
            frame.pack();
            //Adding an interface to control the game.
            Container buttons = new ControlPanel(world, mouse.getCharacter(), time, this, view, view.getHighscore());
            frame.add(buttons, BorderLayout.WEST);
            //Makes the window visible including the added components to the frame.
            frame.setVisible(true);
            
            //Run the game!
            world.start();
            System.out.println("Congratulations! You've reached level 3!");
        } else if(level == 3){
            world.stopSound();
            level++;
            //Overwrite the world to the LevelFour class
            world = new LevelFour(time);
            //Deleting the old frame
            frame.dispose();
            //Add bodies and platforms to the world
            world.populate(this);
            //Change the world the view is displaying
            view.setWorld(world);
            mouse = new mouseMovement(view, world, view);
            keyListener = new Restart(world, mouse.getCharacter(), time, this, view, view.getHighscore());
            //Add bodies and methods to the new world
            view.setCharacter(mouse.getCharacter());
            view.addMouseMotionListener(mouse);
            view.addKeyListener(keyListener);
            view.setFocusable(true);
            
             //Creating a new frame for the restart button to work - if it works.....
            frame = new JFrame("Game");
            //Terminates the game once the game window is closed.
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationByPlatform(true); 
            //Displays the game world in a window
            frame.add(view);
            frame.pack();
            //Adding an interface to control the game.
            Container buttons = new ControlPanel(world, mouse.getCharacter(), time, this, view, view.getHighscore());
            frame.add(buttons, BorderLayout.WEST);
            //Makes the window visible including the added components to the frame.
            frame.setVisible(true);
            
            //Run the game!
            world.start();
            System.out.println("Congratulations! You've reached level 4!");
        }
    }

    /**
     * Returns the current world (level).
     * @return The current world
     */
    public GameLevel getWorld() {
        return world;
    }

    /**
     * Returns the instance of 'Game' class.
     * @return Instance of 'Game' class.
     */
    public Game getGame() {
        return game;
    }
    
    /**
     * Returns the current level value.
     * @return The integer value.
     */
    public int getLevel(){
        return level;
    }

    public static void main(String[] args) {
        new Game();
    }
    
}
