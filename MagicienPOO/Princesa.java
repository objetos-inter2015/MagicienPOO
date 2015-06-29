import greenfoot.*;

/**
 * clase del personaje peach.
 */
public class Princesa extends Personaje
{
    private int velCaida=1;// velocidad de caida
    private int contFlotar=0;// contador para flotar
    private int izqFlotar=-5;// contador flotar izquierda
    private int derFlotar=5;//contador flotar derecha
    private int fIzq=0;// bandera izquierda
    private int fDer=0;// bandera derecha
    private int contMovimiento=0;// contador movimiento
    // sonido
    private GreenfootSound peachwinS=new GreenfootSound("peachwin.wav");
        
    public void act() 
    {
        contMovimiento++;
        flotar();
        setLocation(getX()+contFlotar, getY()+velCaida);
    }
    /**
     * funcion que crea el efecto de flotar y agregando gravedad.
     */
    public void flotar()
    {
        GreenfootImage myImage = new GreenfootImage("peachStand.png");
        if(contMovimiento == 15)
        {
            if(contFlotar == 0 && fIzq == 0) 
            {
                contFlotar--;
                if(contFlotar == izqFlotar)
                {
                    contFlotar++;
                }
                if(contFlotar == 0)
                {
                    contFlotar = 0;
                    fDer=1;
                    fIzq =1;
                }
            }
            
            if(contFlotar == 0 && fDer==1) 
            {
                contFlotar++;
                if(contFlotar == derFlotar)
                {
                    contFlotar--;
                }
                if(contFlotar == 0)
                {
                    contFlotar = 0;
                    fDer=0;
                    fIzq =0;
                }
            }
            velCaida++;
            contMovimiento=0;
        }
        
        if(isTouching(piso.class))
        {
            setImage(myImage);
            velCaida=0;
            contFlotar=0;
            fDer=0;
            fIzq =1;            
            if(isTouching(Magicien.class))
            {
                //efecto sonido
                peachwinS.setVolume(35);
                peachwinS.play();
            }
        }
    }    
}
