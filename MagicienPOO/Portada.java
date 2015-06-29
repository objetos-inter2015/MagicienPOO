import greenfoot.*;
import javax.swing.*;
/**
 * clase que contiene el menu principal del juego.
 * @author LOPEZ SILVA MARTIN RAMON
 * @version 26/06/15
 */
public class Portada extends World
{
    //sonido
    private GreenfootSound kirbyS=new GreenfootSound("kirby.wav");    
    public Portada()
    {       
        super(800, 600, 1);        
    }    
    
    public void act()
    {        
        menu();
    }
    /**
     * funcion que contiene el menu y sus interacciones.
     */
    public void menu()
    {
        if(Greenfoot.isKeyDown("0"))//musica
        {
            //musica
        }
        if(Greenfoot.isKeyDown("1"))//Jugar
        {           
            Greenfoot.setWorld(new Play());
        }
        if(Greenfoot.isKeyDown("2"))// Ayuda
        {
            //efecto sonido
            kirbyS.setVolume(65);
            kirbyS.play();            
            Greenfoot.delay(20);
            Greenfoot.setWorld(new AyudaMagicien());
        }
        if(Greenfoot.isKeyDown("3"))//Creditos
        {
            //efecto sonido
            kirbyS.setVolume(65);
            kirbyS.play();   
            Greenfoot.delay(20);
            Greenfoot.setWorld(new Creditos());
        }
        if(Greenfoot.isKeyDown("4"))// Salir
        {
            kirbyS.setVolume(65);
            kirbyS.play();        
            System.exit(0);
        }
    }
}
