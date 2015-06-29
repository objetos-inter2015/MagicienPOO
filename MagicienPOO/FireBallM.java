import greenfoot.*;

/**
 * clase para el hechizo de mario.
 */
public class FireBallM extends Hechizos
{
    private int velPoder=10;// velocidad del hechizo
    // animacion
    private int contAnimacion=0;// contador animacion
    GreenfootImage  uno= new GreenfootImage("f1.png");
    GreenfootImage  dos= new GreenfootImage("f2.png");
    GreenfootImage  tres= new GreenfootImage("f3.png");
    GreenfootImage  cuatro= new GreenfootImage("f4.png");
    GreenfootImage  cinco= new GreenfootImage("f5.png");
    GreenfootImage  seis= new GreenfootImage("f6.png");
    GreenfootImage  siete= new GreenfootImage("f7.png");
    GreenfootImage  ocho= new GreenfootImage("f8.png");
    GreenfootImage  nueve= new GreenfootImage("f9.png");
    GreenfootImage  diez= new GreenfootImage("f10.png");
    GreenfootImage  once= new GreenfootImage("f11.png");
    
    public void act() 
    {
        contAnimacion++;
        setLocation(getX()+velPoder, getY());       
        
        if(contAnimacion == 12)
            contAnimacion=0;       
        animacion();
        
        if(isAtEdge() == true)// en la orilla borrarlo
            getWorld().removeObject(this);       
    }
    /**
     * funcion para la creacion de animacion.
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
        if(contAnimacion==6)
            setImage(seis);
        if(contAnimacion==7)
            setImage(siete);
        if(contAnimacion==8)
            setImage(ocho);
        if(contAnimacion==9)
            setImage(nueve);
        if(contAnimacion==10)
            setImage(diez);
        if(contAnimacion==11)
            setImage(once);
    }
}
