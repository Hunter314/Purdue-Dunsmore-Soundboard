import javax.imageio.ImageIO;
import javax.print.attribute.standard.Media;
import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;
import java.util.Random;

public class soundBoard {


    private static JFrame frame;
    private static JPanel buttonPanel;
    private static JButton meow;
    private static JButton bark;
    private static JButton disposeFrame;
    private static JButton smallInteger;
    private static JButton bigInteger;

    public static void main(String[] args) {
        frame = new JFrame("Purdue University Professor Dunsmore Soundboard");
        addImageToFrame(frame, "bxd.png");
        setupFrame(frame);
        initButtons();
        setButtonsInFrame();
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
        playSound("Sounds/bork.wav");
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
            JOptionPane.showMessageDialog(null, "FILE DOES NOT EXIST!", "FATAL ERROR!",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void setupFrame(JFrame frame) {
        frame.setResizable(false);
        frame.setLayout(new GridLayout());
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(new Dimension(480, 640));
        frame.setVisible(true);
    }

    private static void initButtons() {

        float[] colors = randomBorderColors();
        meow = new JButton("Meow");
        meow.setBorder(BorderFactory.createLineBorder(new Color(colors[0], colors[1], colors[2])));
        meow.setSize(new Dimension(40, 60));

        colors = randomBorderColors();
        bark = new JButton("Bark");
        bark.setBorder(BorderFactory.createLineBorder(new Color(colors[0], colors[1], colors[2])));
        bark.setSize(new Dimension(40, 60));

        colors = randomBorderColors();
        disposeFrame = new JButton("Bluhluhluh");
        disposeFrame.setBorder(BorderFactory.createLineBorder(new Color(colors[0], colors[1], colors[2])));
        disposeFrame.setSize(new Dimension(40, 60));

        colors = randomBorderColors();
        smallInteger = new JButton("int");
        smallInteger.setBorder(BorderFactory.createLineBorder(new Color(colors[0], colors[1], colors[2])));
        smallInteger.setSize(new Dimension(40, 60));

        colors = randomBorderColors();
        bigInteger = new JButton("INTEGER");
        bigInteger.setBorder(BorderFactory.createLineBorder(new Color(colors[0], colors[1], colors[2])));
        bigInteger.setSize(new Dimension(40, 60));

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
    }

    private static void setButtonsInFrame() {
        frame.setLayout(new FlowLayout());
        frame.add(meow, BorderLayout.CENTER);
        frame.add(bark, BorderLayout.SOUTH);
        frame.add(smallInteger, BorderLayout.SOUTH);
        frame.add(bigInteger, BorderLayout.SOUTH);
        frame.add(disposeFrame, BorderLayout.SOUTH);
    }

    private static float[] randomBorderColors() {
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
