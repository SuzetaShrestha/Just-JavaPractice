import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;
public class GamePanel extends JPanel implements Runnable{
    // int x=0;
    // int y=0;
    Thread thread; //thread having datatype Thread
    Anime[] anime=new Anime[10];
    Player player = new Player();

    public GamePanel() {
        super();
        this.setPreferredSize(new Dimension(500,500));
        this.setBackground(Color.BLACK);//panel ko bg color
        for (int i = 0; i < anime.length; i++) {
            anime[i]=new Anime();
        }
        setFocusable(true);
        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e){
                player.update(e);
                System.out.println(e.getKeyCode());
            }
            public void keyReleased(KeyEvent e){
                player.stop();

            }
        });
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        for (int i = 0; i < anime.length; i++) {
            anime[i].paintComponents(g);
            
        }
        player.paintComponent(g);

    }
    public void startGame(){
        thread = new Thread(this);
        thread.start();
    }
    public void update(){
        for (int i = 0; i < anime.length; i++) {
            anime[i].update();
    
        }
        player.move();

    }
    @Override
    public void run() {
        double drawInterval = 1000000000 /60; //calculate in nanoseconds
        double deltaTime = 0;
        long lastPassedTime = System.nanoTime();
        long currentTime = 0;

        while(thread!= null){
            currentTime = System.nanoTime();
            deltaTime+= (currentTime - lastPassedTime)/drawInterval;
            lastPassedTime = currentTime;
            // System.out.println("outside>>");

            if(deltaTime>=1){
                update();
                // y=y+1;
                repaint();
                deltaTime--;
            }
    }
    }
}