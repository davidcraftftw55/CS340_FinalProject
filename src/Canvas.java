import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;
import java.util.List;
import javax.swing.*;

public class Canvas extends JComponent implements ActionListener, KeyListener {
    // DEFAULT SERIAL NUMBER
    private static final long serialVersionUID = 1L;

    private JFrame frame;
    private Timer gameLoopTimer;
    private List<GameObject> gameObjectList;
    private int highlighted = 0;


    public Canvas() {
        // TASK 1: CREATE A LIST OF CHARACTERS THAT WILL APPEAR ON THE CANVAS
        gameObjectList = new LinkedList<GameObject>();

        // TASK 2: CREATE A WINDOW FOR THE APPLICATION
        frame = new JFrame("Animation Canvas");
        frame.setSize(800, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(this);

        // TASK 3: CONSTRUCT A TIMER FOR GAME LOOP
        gameLoopTimer = new Timer(25, this);
        gameLoopTimer.start();

        setFocusTraversalKeysEnabled(false);
        addKeyListener(this);

        // TASK 4: MAKE THE WINDOW VISIBLE
        frame.setVisible(true);

    }

    public synchronized void addGameObject(GameObject sprite) {
        gameObjectList.add(sprite);

        if (gameObjectList.size() == 1) {
            setBorder(BorderFactory.createLineBorder(Color.RED));
        }
    }

    /**
     * Draws the GameObject graphic onto the Canvas
     */
    public synchronized void paint(Graphics g) {
        for (GameObject s : gameObjectList) {
            s.draw(this, g);
        }

        if (gameObjectList.size() > highlighted) {
            GameObject user = gameObjectList.get(highlighted);
            Graphics2D g2d = (Graphics2D) g;
            g2d.setColor(Color.RED);
            g2d.drawRect(user.getX(), user.getY(),
                    user.getCurrentImage().getIconWidth(), user.getCurrentImage().getIconHeight());
        }
    }


    // ****************************************************
    // Canvas must implement the inherited abstract method
    // ActionListener.actionPerformed(ActionEvent)
    public synchronized void actionPerformed(ActionEvent e) {
        if (gameObjectList.size() > highlighted) {
            GameObject user = gameObjectList.get(highlighted);
            user.move(this);
            user.setImage();
        }
        repaint();
    }

    // ****************************************************
    // Canvas must implement the inherited abstract methods
    // for KeyListener

    public void keyTyped(KeyEvent e) {
    }

    public void keyPressed(KeyEvent e) {
    }

    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_TAB) {
            if (gameObjectList.size() > 0) {
                removeKeyListener((KeyListener) gameObjectList.get(highlighted));
                highlighted = highlighted + 1;
                if (highlighted == gameObjectList.size()) {
                    highlighted = 0;
                }
                addKeyListener((KeyListener) gameObjectList.get(highlighted));
            }
        }
    }

}
