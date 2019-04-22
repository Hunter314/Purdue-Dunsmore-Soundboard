import javax.imageio.ImageIO;
import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Random;

public class Soundboard {


    private static JFrame frame;
    private static JButton meow;
    private static JButton bark;
    private static JButton disposeFrame;
    private static JButton smallInteger;
    private static JButton bigInteger;
    private static JButton geekedOut;

    public static void main(String[] args) {
        int num = 34;
        System.out.println(num/3);
        frame = new JFrame("Purdue University Professor Dunsmore Soundboard");
        addImageToFrame(frame, "bxd.png");
        setupFrame(frame);
        initButtons();
        setButtonsInFrame();
        frame.pack();
        initActionListeners();
    }

    private static void addImageToFrame(JFrame jf, String fileName) {
        try {
            frame.setContentPane(new JPanel() {
                BufferedImage image = ImageIO.read(new File(fileName));

                public void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.drawImage(image, 0, 0, frame.getWidth(), frame.getHeight(), this);
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

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

    private static void geekedOutSound(){
        playSound("Sounds/geek.wav");
    }

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
                            "the file in the wrong directory?", "Warning",
                    JOptionPane.WARNING_MESSAGE);
        }
    }

    private static void setupFrame(JFrame frame) {
        frame.setResizable(false);
        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.validate();
        frame.setPreferredSize(new Dimension(480,640));
        System.out.println(frame.isPreferredSizeSet());
        frame.setVisible(true);
        frame.pack();
    }

    private static void initButtons() {

        float[] colors;
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
    }

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


    }

    private static void setButtonsInFrame() {
        frame.add(meow);
        frame.add(bark);
        frame.add(smallInteger);
        frame.add(bigInteger);
        frame.add(disposeFrame);
        frame.add(geekedOut);
    }

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
