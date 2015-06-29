import greenfoot.*;

/**
 * clase hechizo zonal escarcha.
 */
public class Escarcha extends Hechizos
{
    private int velPoder=8;// velocidad hechizo
    //animacion
    private int contAnimacion=0;// contador animacion
    GreenfootImage uno = new GreenfootImage("s1.png");
    GreenfootImage dos = new GreenfootImage("s2.png");
    GreenfootImage tres = new GreenfootImage("s3.png");
    GreenfootImage cuatro = new GreenfootImage("s4.png");
    GreenfootImage cinco = new GreenfootImage("s5.png");
    
    public void act() 
    {
        contAnimacion++;
        setLocation(getX(), getY()+velPoder);            
        
        if(contAnimacion == 51 )// contador animacion
        {
            contAnimacion=0;
        }        
                
        if(isAtEdge() == true)// objeto en la orilla borrar
            getWorld().removeObject(this);
    }
    /**
     * funcion para crear la animacion de el hechizo escarcha.
     */
    public void animacion()
    {        
        if(contAnimacion == 10)
            setImage(uno);
        if(contAnimacion==20)
            setImage(dos);
        if(contAnimacion == 30)
            setImage(tres);
        if(contAnimacion== 40)
            setImage(cuatro);
        if(contAnimacion==50)
            setImage(cinco);
    }
}