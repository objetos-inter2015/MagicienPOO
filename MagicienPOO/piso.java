import greenfoot.*;

/**
 * clase del item piso
 */
public class piso extends items
{
    public int contKirbyOff=0;
    private GreenfootSound piedraS=new GreenfootSound("piedra.wav");// sonido piedras kirby
    private GreenfootSound piedraS2=new GreenfootSound("piedra.wav");// sonido piedras fantasmas

    public void act() 
    {
        colision();        
    }    
    
    public void colision()
    {
        if (isTouching(HechizosK.class))
        {            
            removeTouching(HechizosK.class);
            //efecto sonido            
            piedraS2.play();
            piedraS2.setVolume(90);
        }
        if (isTouching(HechizosF.class))
        {            
            removeTouching(HechizosF.class);
            //efecto sonido            
            piedraS.play();
            piedraS.setVolume(75);
        }
        if (isTouching(Escarcha.class))
        {            
            removeTouching(Escarcha.class);
        }
        if (isTouching(Kirby.class))
        {   
            contKirbyOff++;
            if(contKirbyOff == 40)
            {
                removeTouching(Kirby.class);
            }
        }
    }
}
