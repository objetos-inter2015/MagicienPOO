import greenfoot.*;

/**
 * clase para mostrar la portada de creditos
 */
public class Creditos extends World
{
    //sonido
    private GreenfootSound kirbyS=new GreenfootSound("kirby.wav");
    
    public Creditos()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 
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
