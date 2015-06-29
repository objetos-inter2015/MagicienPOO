import greenfoot.*;
import java.awt.Color;
/** 
 * clase para agregar pantalla de puntaje en el juego 
 */
public class ScoreInGame extends Marcador
{
    public String nombre;
    public int vida;
    public int score;
    public int t=0;
    /**
     * Constructor con parametros para escoger la pantalla de puntaje
     */
    public ScoreInGame(String name, int life, int puntos, int tipo)
    {
        if (tipo == 1) // gameover letra blanca, fondo rosa
        {
            nombre=name;
            vida=life;
            score=puntos;
            t=tipo;            
            GreenfootImage textImage = new GreenfootImage(nombre+" Score: "+score +" Vidas: "+vida, 60, new Color(255,255,255), new Color(0, 0, 0, 0));
            GreenfootImage image = new GreenfootImage(800, 65);
            image.setColor(new Color(0,0,0));
            image.setColor(new Color(217,72,139));// fondo
            image.fillRect(0, 20, image.getWidth(), image.getHeight());            
            image.drawImage(textImage, 10, 10);
            setImage(image);
        }
        if (tipo == 2) // gameover letra blanca, fondo azul
        {
            nombre=name;
            vida=life;
            score=puntos;
            t=tipo;            
            GreenfootImage textImage = new GreenfootImage(nombre+" Score: "+score +" Vidas: "+vida, 60, new Color(255,255,255), new Color(0, 0, 0, 0));
            GreenfootImage image = new GreenfootImage(800, 65);
            image.setColor(new Color(0,0,0));
            image.setColor(new Color(54,125,217));// fondo
            image.fillRect(0, 20, image.getWidth(), image.getHeight());            
            image.drawImage(textImage, 10, 10);
            setImage(image);
        }
    }
    public void act() 
    {        
        if(Greenfoot.isKeyDown("enter") && t == 1)// Ayuda
        {            
            Greenfoot.delay(30);
            Greenfoot.setWorld(new Portada());
        }
        if(t == 2)// Ayuda
        {            
            Greenfoot.delay(70);
            Greenfoot.setWorld(new Escena1());
        }
    }    
}
