import javax.print.attribute.standard.Media;
import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class soundBoard {


    private static JFrame frame;
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
        initActionListeners();


    }

    private static void addImageToFrame(JFrame jf, String fileName) {
        jf.setContentPane(new JLabel(new ImageIcon(fileName)));
    }

    private static void meowSound() {
        playSound("Sounds/meow.mp3");
    }

    private static void barkSound() {
        playSound("Sounds/bork.mp3");
    }

    private static void disposeFrameSound() {
        playSound("Sounds/blululululu.mp3");
    }

    private static void smallIntegerSound() {
        playSound("Sounds/int.mp3");
    }

    private static void bigIntegerSound() {
        playSound("Sounds/INTEGER.mp3");
    }

    private static void playSound(String fileName) {
        File file = new File(fileName);
        if (file.exists()) {
            try {
                AudioInputStream audioInputStream =
                        AudioSystem.getAudioInputStream(new File(fileName).getAbsoluteFile());
                Clip clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.start();

            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                JOptionPane.showMessageDialog(null, "Problem in playing file.",
                        "FATAL ERROR!",
                        JOptionPane.ERROR_MESSAGE);
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
        meow = new JButton("Meow");
        bark = new JButton("Bark");
        disposeFrame = new JButton("Bluhluhluh");
        smallInteger = new JButton("int");
        bigInteger = new JButton("INTEGER");
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


}
