import greenfoot.*;

/**
 * clase item mariofat
 */
public class MarioFat extends items
{
    private int velCaida=1;// velocidad de caida
    private int contFlotar=0;// contador flotar
    private int izqFlotar=-5;//flotar a la izquierda
    private int derFlotar=5;// flotar a la derecha
    private int fIzq=0;//bandera izquierda
    private int fDer=0;//bandera derecha
    private int contMovimiento=0;//contador de movimiento
    
    public void act() 
    {
        contMovimiento++;
        flotar();
        setLocation(getX()+contFlotar, getY()+velCaida);
    }
    
    /**
     * funcion para generar el efecto flotar con gravedad
     */
    public void flotar()
    {
        if(contMovimiento == 10)
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
            velCaida=0;
            contFlotar=0;
            fDer=0;
            fIzq =1;            
        }
    }
}
