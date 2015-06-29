import greenfoot.*;

/**
 * clase del actor mario.
 */
public class Mario extends Personaje
{
    private int contAnimacion=0; // contador animacion
    private int fCont=0; // bandera animacion
    //animaciones
    GreenfootImage uno = new GreenfootImage("m1.png");
    GreenfootImage dos = new GreenfootImage("m2.png");
    GreenfootImage tres = new GreenfootImage("m3.png");
    GreenfootImage cuatro = new GreenfootImage("m4.png");
    GreenfootImage cinco = new GreenfootImage("m5.png");
    GreenfootImage seis = new GreenfootImage("m6.png");
    GreenfootImage siete = new GreenfootImage("m7.png");
    //sonido
    private GreenfootSound mariofireS=new GreenfootSound("mariofire.wav");
    private GreenfootSound mariodanoS=new GreenfootSound("mariodano.wav");
    public void act() 
    {
        if(fCont == 0)
            contAnimacion++;        
        // contadores
        if(contAnimacion == 52)// contador animacion
            contAnimacion=0;
        
        animacion(contAnimacion);
        colision();        
    }
    /**
     * animaciones de mario
     */
    public void animacion(int contAnimacion)
    {            
        if(contAnimacion == 10)
            setImage(uno);
        if(contAnimacion == 20)
            setImage(dos);
        if(contAnimacion==30)
            setImage(tres);
        if(contAnimacion==40)
            setImage(cuatro);
        if(contAnimacion==50)
            setImage(cinco);
        if(contAnimacion==51)
        {
            getWorld().addObject(new FireBallM(), 50+10, 532);           
            //efecto sonido
            mariofireS.play();
            mariofireS.setVolume(60);
        }
    }
    /**
     * colisiones de mario
     */
    public void colision()
    {        
        if(isTouching(HechizosM.class) && fCont == 0)
        {
            setImage(seis);
            setLocation(getX()-3, getY());
            //efecto sonido
            mariodanoS.play();
            mariodanoS.setVolume(60);
        }
        if(isAtEdge() == true)
            getWorld().removeObject(this);
    }
}
