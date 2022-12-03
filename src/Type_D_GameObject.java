import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 * Starting object for user; can move all 4 directions
 */
public class Type_D_GameObject extends GameObject implements KeyListener {

    /**
     * Constructs a GameObject that can move in all 4 directions (and by default is controlled by user)
     * @param x starting x coordinate for this GameObject
     * @param y starting y coordinate for this GameObject
     */
    public Type_D_GameObject(int x, int y) {
        super(x, y);
        setDirection(Direction.NONE);
        setVelocity(10);

        imageList = new LinkedList<>();
        imageList.add(new ImageIcon("images/Type_D_Up.png"));
        imageList.add(new ImageIcon("images/Type_D_Down.png"));
        imageList.add(new ImageIcon("images/Type_D_Left.png"));
        imageList.add(new ImageIcon("images/Type_D_Right.png"));

    }

    public void move(Canvas c) {
        Icon icon = getCurrentImage();

        int iconHeight = icon.getIconHeight();
        int iconWidth = icon.getIconWidth();
        int canvasHeight = (int) c.getSize().getHeight();
        int canvasWidth = (int) c.getSize().getWidth();

        //MOVE BLUE GAME OBJECT
        switch (getDirection()) {
            case Direction.UP:
                setY(getY() - getVelocity());
                if (getY() < 0) {
                    setY(0);
                }
                break;
            case Direction.DOWN:
                setY(getY() + getVelocity());
                if (getY() + iconHeight > canvasHeight) {
                    setY(canvasHeight - iconHeight);
                }
                break;
            case Direction.LEFT:
                setX(getX() - getVelocity());
                if (getX() < 0) {
                    setX(0);
                }
                break;
            case Direction.RIGHT:
                setX(getX() + getVelocity());
                if (getX() + iconWidth > canvasWidth) {
                    setX(canvasWidth - iconWidth);
                }
        }
        setVelocity(getVelocity() + 1);
    }

    //SPECIFY THE IMAGE TO DISPLAY
    //   USED FOR ANIMATION
    public void setImage() {
        switch (getDirection()) {
            case Direction.UP:
                currentImage = 0;
                break;
            case Direction.DOWN:
                currentImage = 1;
                break;
            case Direction.LEFT:
                currentImage = 2;
                break;
            case Direction.RIGHT:
                currentImage = 3;
                break;
        }
    }

    public void keyTyped(KeyEvent e) {}

    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() != KeyEvent.VK_TAB) {
            setDirection(Direction.NONE);
            setVelocity(10);
        }
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            setDirection(Direction.UP);
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            setDirection(Direction.DOWN);
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            setDirection(Direction.RIGHT);
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            setDirection(Direction.LEFT);
        }
    }

}
