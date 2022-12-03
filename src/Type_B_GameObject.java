import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;

public class Type_B_GameObject extends GameObject implements KeyListener {

    /**
     * Constructs a GameObject
     *
     * @param x starting x coordinate for this GameObject
     * @param y starting y coordinate for this GameObject
     */
    public Type_B_GameObject(int x, int y) {
        super(x, y);
        setDirection(Direction.NONE);
        setVelocity(10);

        imageList = new LinkedList<>();
        imageList.add(new ImageIcon("images/Type_B_Up.png"));
        imageList.add(new ImageIcon("images/Type_B_Down.png"));
        imageList.add(new ImageIcon("images/Type_B_Left.png"));
        imageList.add(new ImageIcon("images/Type_B_Right.png"));
    }

    @Override
    public void move(Canvas c) {
        Icon icon = getCurrentImage();

        int iconHeight = icon.getIconHeight();
        int iconWidth = icon.getIconWidth();
        int canvasHeight = (int) c.getSize().getHeight();
        int canvasWidth = (int) c.getSize().getWidth();

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

    @Override
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

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                setDirection(Direction.UP);
                break;
            case KeyEvent.VK_DOWN:
                setDirection(Direction.DOWN);
                break;
            case KeyEvent.VK_RIGHT:
                setDirection(Direction.RIGHT);
                break;
            case KeyEvent.VK_LEFT:
                setDirection(Direction.LEFT);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() != KeyEvent.VK_TAB) {
            setDirection(Direction.NONE);
            setVelocity(10);
        }
    }
}
