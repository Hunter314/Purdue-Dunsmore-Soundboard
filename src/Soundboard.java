import javax.imageio.ImageIO;
import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Random;

/**
 * Professor Dunsmore Soundboard
 *
 * A creative project done for humorous purposes, by Kedar Abhyankar
 *
 * @author kedarabhyankar
 * @version 1.0
 *
 * https://kedarabhyankar.me
 * https://github.com/kedarabhyankar
 */

public class Soundboard {
    private static JFrame frame;
    private static JButton meow;
    private static JButton bark;
    private static JButton disposeFrame;
    private static JButton smallInteger;
    private static JButton bigInteger;
    private static JButton geekedOut;
    private static JButton about;

    public static void main(String[] args) {
        frame = new JFrame("Purdue University Professor Dunsmore Soundboard");
        addImageToFrame(frame, "bxd.png");
        setupFrame(frame);
        initButtons();
        setButtonsInFrame();
        frame.pack();
        initActionListeners();
    }

    /**
     * This method displays an image held in the content pane of the JFrame.
     * @param jf the JFrame in which to display an image to.
     * @param fileName the fileName as to what image is being shown. All files must be in the Portable Network
     *                 Graphics format (.png), and must be within the boundaries of the screen size.
     */
    private static void addImageToFrame(JFrame jf, String fileName) {
        try {
            jf.setContentPane(new JPanel() {
                BufferedImage image = ImageIO.read(Soundboard.class.getResourceAsStream("images/"+fileName));

                public void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.drawImage(image, 0, 0, jf.getWidth(), jf.getHeight(), this);
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * The methods listed below each contain calls to the playSound() method, where it will play the
     * corresponding sound file. These methods are called when the ActionListener of each respective
     * JButton is 'tripped'.
     */
    private static void meowSound() {
        playSound("Sounds/meow.wav");
    }

    private static void barkSound() {
        playSound("Sounds/bark.wav");
    }

    private static void disposeFrameSound() {
        playSound("Sounds/blululululu.wav");
    }

    private static void smallIntegerSound() {
        playSound("Sounds/int.wav");
    }

    private static void bigIntegerSound() {
        playSound("Sounds/INTEGER.wav");
    }

    private static void geekedOutSound() {
        playSound("Sounds/geek.wav");
    }

    /**
     * The aboutWindow() method simply shows a JOptionPane with info about this project's creator, Kedar Abhyankar.
     */
    private static void aboutWindow() {
        JOptionPane.showMessageDialog(null,
                "This project was designed " +
                        "\nas a thank-you of sorts" +
                        "\nto the CS180 Staff. " +
                        "\nIt was designed, programmed, and " +
                        "\ndocumented by Kedar Abhyankar. " +
                        "\nThank you CS180 Staff!" +
                        "\n\n\n" +
                        "If you're interested in" +
                        "\nadding to this project" +
                        "\nfork this project from" +
                        "\nmy GitHub repository!" +
                        "\nhttps://git.io/fj3Ic" +
                        "\n\n" +
                        "\nOr, if you have any questions," +
                        "\nYou can reach out to me through" +
                        "\nthe contact links on my website." +
                        "\nhttps://kedarabhyankar.me", "About", JOptionPane.PLAIN_MESSAGE);
    }

    /**
     * The playSound() method takes in a parameter of String filename, which corresponds to the name of the sound
     * file that the program can play. All sounds MUST be in .wav format, due to the specifications laid out by the
     * Clip class. If the file doesn't exist, a warning message will be shown. The program WILL NOT shut down if
     * the button results in an error message.
     * @param fileName The name of the song file to play.
     */
    private static void playSound(String fileName) {
        File file = new File(fileName);
        if (file.exists()) {
            try {
                Clip clip = AudioSystem.getClip();
                clip.open(AudioSystem.getAudioInputStream(new File(fileName)));
                clip.start();
            } catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
                e.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(null, "The file doesn't exist. Perhaps you placed" +
                            " the file in the wrong directory?", "Warning",
                    JOptionPane.WARNING_MESSAGE);
        }
    }

    /**
     * The setupFrame(JFrame frame) method sets up the JFrame, and its specific settings. It is setup to
     * be run in a FlowLayout, in a non resizable 480 by 640 size window, centered on screen.
     * @param frame The JFrame that we are applying these parameters to.
     */
    private static void setupFrame(JFrame frame) {
        frame.setResizable(false);
        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.validate();
        frame.setPreferredSize(new Dimension(480, 640));
        frame.setVisible(true);
        frame.pack();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Point middle = new Point(screenSize.width / 2, screenSize.height / 2);
        Point newLocation = new Point(middle.x - (frame.getWidth() / 2),
                middle.y - (frame.getHeight() / 2));
        frame.setLocation(newLocation);
    }

    /**
     * The initButtons() method handles the instantiation, visibility, and bounding boxes of the JButtons used through
     * out this program. Each button is set to the same dimensions, of BUTTON_WIDTH and BUTTON_HEIGHT.
     */
    private static void initButtons() {

        final int BUTTON_WIDTH = 80;
        final int BUTTON_HEIGHT = 60;

        meow = new JButton("Meow");
        meow.setVisible(true);
        meow.setBounds(new Rectangle(BUTTON_WIDTH, BUTTON_HEIGHT));

        bark = new JButton("Bark");
        bark.setVisible(true);
        bark.setBounds(new Rectangle(BUTTON_WIDTH, BUTTON_HEIGHT));

        disposeFrame = new JButton("Disposal of Frame");
        disposeFrame.setVisible(true);
        disposeFrame.setBounds(new Rectangle(BUTTON_WIDTH, BUTTON_HEIGHT));

        smallInteger = new JButton("int");
        smallInteger.setVisible(true);
        smallInteger.setBounds(new Rectangle(BUTTON_WIDTH, BUTTON_HEIGHT));

        bigInteger = new JButton("INTEGER");
        bigInteger.setVisible(true);
        bigInteger.setBounds(new Rectangle(BUTTON_WIDTH, BUTTON_HEIGHT));

        geekedOut = new JButton("Geeked Out");
        geekedOut.setVisible(true);
        geekedOut.setBounds(new Rectangle(BUTTON_WIDTH, BUTTON_HEIGHT));

        about = new JButton("About");
        about.setVisible(true);
        about.setBounds(new Rectangle(BUTTON_WIDTH, BUTTON_HEIGHT));
    }

    /**
     * The initActionListeners() method handles the creation and functionality of each button's ActionListener. Each
     * button has an ActionListener added to it, and if the ActionListener is 'tripped', then the corresponding
     * method will be run.
     */
    private static void initActionListeners() {
        meow.addActionListener(ActionListener -> {
            meowSound();
        });

        bark.addActionListener(ActionListener -> {
            barkSound();
        });

        disposeFrame.addActionListener(ActionListener -> {
            disposeFrameSound();
        });

        smallInteger.addActionListener(ActionListener -> {
            smallIntegerSound();
        });

        bigInteger.addActionListener(ActionListener -> {
            bigIntegerSound();
        });

        geekedOut.addActionListener(ActionListener -> {
            geekedOutSound();
        });

        about.addActionListener(ActionListener -> {
            aboutWindow();
        });
    }

    /**
     * The setButtonsInFrame() method adds every button used in this program to the JFrame object, frame.
     */
    private static void setButtonsInFrame() {
        frame.add(meow);
        frame.add(bark);
        frame.add(smallInteger);
        frame.add(bigInteger);
        frame.add(disposeFrame);
        frame.add(geekedOut);
        frame.add(about);
    }

    /**
     * The randomColors() method utilizes a Random object in order to generate a series of three floating point
     * numbers, each corresponding to a certain color spectrum in the RGB colorspace. The three values are
     * saved to a floating point number array, and then that array is returned.
     *
     * @return a floating point array containing a random rgb Color value.
     */
    private static float[] randomColors() {
        Random rand = new Random();
        float r = rand.nextFloat();
        float g = rand.nextFloat();
        float b = rand.nextFloat();
        float[] colors = new float[3];
        colors[0] = r;
        colors[1] = g;
        colors[2] = b;
        return colors;
    }


}
