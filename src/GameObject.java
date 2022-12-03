import java.awt.Component;
import java.awt.Graphics;
import java.util.List;
import javax.swing.Icon;

/**
 * Generic object for all actors in this project
 */
public abstract class GameObject {
	//EACH GAME OBJECT HAS AN X,Y LOCATION, VELOCITY, AND A DIRECTION

	private int x;
	private int y;
	private int velocity;
	private int direction;

	/**
	 * List of images (as icons) for each direction of this GameObject
	 */
	protected List<Icon> imageList;
	/**
	 * Index from imageList for current image of this GameObject (as determined by the direction it's travelling
	 */
	protected int currentImage;

	/**
	 * Constructs a GameObject
	 * @param x starting x coordinate for this GameObject
	 * @param y starting y coordinate for this GameObject
	 */
	public GameObject(int x, int y) {
		this.x = x;
		this.y = y;
		velocity = 0;
		currentImage = 0;
	}

	/**
	 * Draws and/or updates this GameObject's position and appearance in the game
	 * @param c component to draw this GameObject on (ie- Canvas)
	 * @param g graphics part of component (ie- Canvas.getGraphics())
	 */
	public void draw(Component c, Graphics g) {
		imageList.get(currentImage).paintIcon(c, g, x, y);
	}

	// SETTERS AND GETTERS

	/**
	 * Getter for this Game Object's x-coordinate
	 * @return x coordiante
	 */
	public int getX() {
		return x;
	}

	/**
	 * Setter for this Game Object's x-coordinate
	 * @param x new x coordinate
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * Getter for this Game Object's y-coordinate
	 * @return y coordiante
	 */
	public int getY() {
		return y;
	}

	/**
	 * Setter for this Game Object's x-coordinate
	 * @param y new y coordinate
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * Setter for the velocity of this GameObject
	 * @param velocity new velocity of this GameObject, in pixels per frame
	 */
	public void setVelocity(int velocity) {
		this.velocity = velocity;
	}

	/**
	 * Getter for the velocity of this GameObject
	 * @return velocity of this GameObject, in pixels per frame
	 */
	public int getVelocity() {
		return velocity;
	}

	/**
	 * Getter for the current direction this GameObject is facing, as a value from {@link Direction}
	 * @return integer representation of this GameObject's direction from {@link Direction}
	 */
	public int getDirection() {
		return direction;
	}

	/**
	 * Setter for the current direction this GameObject is facing, as a value from {@link Direction}
	 * @param direction new interger representing this GameObject's direction it's facing
	 */
	public void setDirection(int direction) {
		this.direction = direction;
	}

	/**
	 * Gets the current image of this GameObject (as an Icon), using the currentImage field
	 * @return Icon containing the current appearance of this GameObject
	 */
	public Icon getCurrentImage() {
		return imageList.get(currentImage);
	}

	/**
	 * Method that is called every frame from Timer in Canvas; should update the location and appearance of this GameObject
	 * @param c canvas object to draw this GameObject on
	 */
	public abstract void move(Canvas c);

	/**
	 * Updates the currentImage field to what the user intends (with their movements)
	 */
	public abstract void setImage();

}
