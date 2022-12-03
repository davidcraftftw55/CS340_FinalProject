import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;

public class Type_C_GameObject extends GameObject implements KeyListener {
    /**
     * Constructs a GameObject
     *
     * @param x starting x coordinate for this GameObject
     * @param y starting y coordinate for this GameObject
     */
    public Type_C_GameObject(int x, int y) {
        super(x, y);
        setDirection(Direction.NONE);
        setVelocity(10);

        imageList = new LinkedList<>();
        imageList.add(new ImageIcon("images/Type_C_Left.png"));
        imageList.add(new ImageIcon("images/Type_C_Right.png"));

    }

    @Override
    public void move(Canvas c) {
        Icon icon = getCurrentImage();

        int iconWidth = icon.getIconWidth();
        int canvasWidth = (int) c.getSize().getWidth();

        switch (getDirection()) {
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
            case Direction.LEFT:
                currentImage = 0;
                break;
            case Direction.RIGHT:
                currentImage = 1;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                setDirection(Direction.LEFT);
                break;
            case KeyEvent.VK_RIGHT:
                setDirection(Direction.RIGHT);
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
