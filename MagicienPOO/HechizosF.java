import greenfoot.*;

/**
 * clase para hechizo de los fantasmas
 */
public class HechizosF extends Hechizos
{
    private int velPoder=5;// velocidad del hechizo
    //animacion
    private int contAnimacion=0;// contador animaciones
    private int ranAnimacion=0;//random animaciones
    GreenfootImage uno = new GreenfootImage("r1.png");
    GreenfootImage dos = new GreenfootImage("r2.png");
    GreenfootImage tres = new GreenfootImage("r3.png");
    GreenfootImage cuatro = new GreenfootImage("r4.png");
    GreenfootImage cinco = new GreenfootImage("r5.png");
    GreenfootImage seis = new GreenfootImage("r6.png");
    GreenfootImage siete = new GreenfootImage("r7.png");
    
    public void act() 
    {
        contAnimacion++;
        setLocation(getX(), getY()+velPoder);
        
        if(contAnimacion == 20 )// contador animacion
        {
            ranAnimacion=Greenfoot.getRandomNumber(7+1);
            contAnimacion=0;
        }        
        animacion();        
    }
    /**
     * funcion crea animacion.
     */
    public void animacion()
    {
        if(ranAnimacion == 1)
            setImage(uno);
        if(ranAnimacion==2)
            setImage(dos);
        if(ranAnimacion == 3)
            setImage(tres);
        if(ranAnimacion == 4)
            setImage(cuatro);
        if(ranAnimacion==5)
            setImage(cinco);
        if(ranAnimacion == 6)
            setImage(seis);
        if(ranAnimacion == 7)
            setImage(siete);
    }
}
