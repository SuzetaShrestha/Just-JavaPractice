import java.awt.*;
import java.io.File;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.*;
public class Anime extends JPanel {
    Random rN=new Random();

    private Image image;
    int x=rN.nextInt(1000),y=rN.nextInt(700);
   
    Anime(){
        super();
        try{
            image=ImageIO.read(new File("./Asteroid.png"));
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
     public void paintComponent(Graphics g){
        super.paintComponent(g);
        // g.setColor(Color.BLUE);
        // g.fillRect(x, y, 50, 50);
        g.drawImage(image, x, y, 100,100,this);
        
    }
    public void update(){
        y++;
    }
    
}
