import greenfoot.*;

/**
 * clase para el hechizo de kirby
 */
public class HechizosK extends Hechizos
{
    private int velPoder=10;// velocidad hechizo
    
    public void act() 
    {
        setLocation(getX(), getY()+velPoder);
    }    
}
