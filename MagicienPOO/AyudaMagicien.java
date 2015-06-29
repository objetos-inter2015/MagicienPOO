import greenfoot.*;

/**
 * clase que contiene la ayuda de magicien.
 */
public class AyudaMagicien extends Ayuda
{
    //sonido
    private GreenfootSound kirbyS=new GreenfootSound("kirby.wav");
    
    /**
     * Constructor for objects of class AyudaMagicien.
     * 
     */
    public AyudaMagicien()
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
            Greenfoot.setWorld(new AyudaKirby());
        }
    }
}
