import greenfoot.*;

/**
 * clase para la portada de ayuda de los fantasmas.
 */
public class AyudaGhost extends Ayuda
{
    //sonido
    private GreenfootSound kirbyS=new GreenfootSound("kirby.wav");
    
    /**
     * Constructor for objects of class AyudaGhost.
     * 
     */
    public AyudaGhost()
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
            Greenfoot.setWorld(new Portada());
        }
    }
}
