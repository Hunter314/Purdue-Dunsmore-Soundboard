import javax.swing.*;
import java.awt.*;

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

    }

    private static void barkSound() {
    }

    private static void disposeFrameSound() {

    }

    private static void smallIntegerSound() {
    }

    private static void bigIntegerSound() {
    }

    private static void playSound(String fileName) {
        /**
         * ENSURE THAT THE FILE GIVEN IS IN THE SOUNDS FOLDER!
         */
    }

    private static void setupFrame(JFrame frame) {
        frame.setResizable(false);
        frame.setLayout(new GridLayout());
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(new Dimension(480, 640));
        frame.setVisible(true);
    }
    private static void initButtons(){
        meow = new JButton("Meow");
        bark = new JButton("Bark");
        disposeFrame = new JButton("Bluhluhluh");
        smallInteger = new JButton("int");
        bigInteger = new JButton("INTEGER");
    }

    private static void initActionListeners(){
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
