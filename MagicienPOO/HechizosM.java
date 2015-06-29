import greenfoot.*;

/**
 * clase para el hechizo de magicien
 */
public class HechizosM extends Hechizos
{
    private int x; // tipo
    private int velPoder=15;// velocidad del hechizo
    //animacion
    private int contAnimacion=0;//contador animacion
    GreenfootImage uno = new GreenfootImage("spell.png");
    GreenfootImage dos = new GreenfootImage("spell2.png");
    GreenfootImage tres = new GreenfootImage("spell3.png");
    GreenfootImage cuatro = new GreenfootImage("spell4.png");
    GreenfootImage cinco = new GreenfootImage("spell5.png");
    public HechizosM(int i)
    {
        x=i;
    }
    public void act() 
    
    {
        contAnimacion++;
        
        if(contAnimacion == 6)
            contAnimacion=0;
        animacion();       
            
        if(getX()>5 && getX()<795 && getY()>5)
        {
            if(x==1)
                setLocation(getX()-velPoder, getY());
            if(x==2)            
                setLocation(getX(), getY()-velPoder);
            if(x==3)
                setLocation(getX()+velPoder, getY());            
        }
        else
            getWorld().removeObjects(getWorld().getObjects(HechizosM.class)); // borrar hechizo magicien       
    }
    /**
     * funcion para la creacion de animaciones
     */
    public void animacion()
    {
        if(contAnimacion==1)
            setImage(uno);
        if(contAnimacion==2)
            setImage(dos);
        if(contAnimacion==3)
            setImage(tres);
        if(contAnimacion==4)
            setImage(cuatro);
        if(contAnimacion==5)
            setImage(cinco);    
    }
}
