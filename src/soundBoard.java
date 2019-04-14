import javax.swing.*;

public class soundBoard {


    private static JFrame frame;
    private JButton meow;
    JButton bark;
    JButton disposeFrame;
    JButton smallInteger;
    JButton bigInteger;

    private static void main(String[] args) {
        frame = new JFrame("Purdue University Professor Dunsmore Soundboard");
    }

    private void addImageToFrame(String filePath) {

    }

    private void meowSound() {
        meow = new JButton("Meow");
    }

    private void barkSound() {
        bark = new JButton("Bark");
    }

    private void disposeFrameSound() {
        disposeFrame = new JButton("Bluhluhluh");

    }

    private void smallIntegerSound() {
        smallInteger = new JButton("int");
    }

    private void bigIntegerSound() {
        bigInteger = new JButton("INTEGER");
    }

    private void playSound(String fileName) {
        /**
         * ENSURE THAT THE FILE GIVEN IS IN THE SOUNDS FOLDER!
         */

    }
}
