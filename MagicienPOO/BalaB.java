import greenfoot.*;

/**
 * clase hechizo bala.
 */
public class BalaB extends Hechizos
{
    private int velPoder=10;// velocidad hechizo
    
    public void act() 
    {
        setLocation(getX() - velPoder, getY());
        if(isAtEdge() == true)// hechizo a la orilla borrarlo
            getWorld().removeObject(this);       
    }  
}
