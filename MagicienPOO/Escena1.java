import greenfoot.*;

/**
 * clase con la escena final del juego.
 */
public class Escena1 extends Final
{
    private int contEscena=0;
    private int tiempoEscena=50;
    
    public void act()
    {
        Greenfoot.delay(100);// delay para ver escena
        contEscena++;
        interaccion(contEscena);
    }
    /**
     * funcion para realizar una espera o interaccion con el teclado 
     */
    public void interaccion(int contEscena)
    {
        // reset de contador
        Greenfoot.delay(120);
        Greenfoot.setWorld(new Portada());
        if(contEscena == tiempoEscena + 1) 
        {
            contEscena=0;
        }
        // condicional de espera o tecla enter
        if(Greenfoot.isKeyDown("enter"))
        {
            Greenfoot.setWorld(new Portada());
        }
    }
}
