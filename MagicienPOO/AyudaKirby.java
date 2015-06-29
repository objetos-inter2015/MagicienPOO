import greenfoot.*;

/**
 * clase que contiene la portada ayuda de kirby.
 */
public class AyudaKirby extends Ayuda
{
    //sonido
    private GreenfootSound kirbyS=new GreenfootSound("kirby.wav");
    
    /**
     * Constructor for objects of class AyudaKirby.
     * 
     */
    public AyudaKirby()
    {
    }
    public void act()
    {
        interaccion();
    }
    /**
     * funcion para realizar una espera o interaccion con el teclado. 
     */
    public void interaccion()
    {
        if(Greenfoot.isKeyDown("enter"))// Ayuda
        {
            //efecto sonido
            kirbyS.setVolume(65);
            kirbyS.play();   
            Greenfoot.delay(20);
            Greenfoot.setWorld(new AyudaGhost());
        }
    }
}
