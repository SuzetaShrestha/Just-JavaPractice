import javax.swing.*;
 public class Box extends JFrame{
    public static void main(String[] args) {
        JFrame frame= new JFrame("FPS Control Loop");
        frame.setResizable(false);//to make unresizable 
        //frame.setLocationRelativeTo(null);
        GamePanel game= new GamePanel();
        frame.add(game);

        game.startGame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//totally exit garcha bg ma
        
        frame.setSize(1000,700);
        frame.setVisible(true);
    }
}