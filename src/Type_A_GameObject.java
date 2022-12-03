import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;

public class Type_A_GameObject extends GameObject implements KeyListener {

    /**
     * Constructs a GameObject
     *
     * @param x starting x coordinate for this GameObject
     * @param y starting y coordinate for this GameObject
     */
    public Type_A_GameObject(int x, int y) {
        super(x, y);
        setDirection(Direction.NONE);
        setVelocity(10);

        imageList = new LinkedList<>();
        imageList.add(new ImageIcon("images/Type_A_Up.png"));
        imageList.add(new ImageIcon("images/Type_A_Down.png"));
    }

    @Override
    public void move(Canvas c) {
        Icon icon = getCurrentImage();

        int iconHeight = icon.getIconHeight();
        int canvasHeight = (int) c.getSize().getHeight();

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
