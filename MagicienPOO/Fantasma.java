import greenfoot.*;

/**
 * clase del actor fantasma.
 */
public class Fantasma extends Personaje
{
    private int contador;// declaracion private de contador correcto
    private int fIzq=0, fDer=0, fUp=0, fDown=0;// banderas movimiento
    private int fCont = 0, random = 0;// contadores y random
    private int fSpell=0;// bandera hechizo
    private int gravedad=80;//salto    
    // vida
    private int vida=5;
    // animacion personalizada
    private int contAnimacion=0;
    private int ranAnimacion=0;
    // transparencia
    private int transparente=255;   
    //animacion derecha
    GreenfootImage myImage= new GreenfootImage("ghost.png");
    GreenfootImage unoD = new GreenfootImage("1.png");
    GreenfootImage dosD = new GreenfootImage("2.png");
    GreenfootImage tresD = new GreenfootImage("3.png");
    GreenfootImage cuatroD = new GreenfootImage("4.png");
    GreenfootImage cincoD = new GreenfootImage("5.png");
    //animacion izquierda
    GreenfootImage myImagei = new GreenfootImage("ghosti.png");   
    GreenfootImage unoI = new GreenfootImage("1i.png");
    GreenfootImage dosI = new GreenfootImage("2i.png");
    GreenfootImage tresI = new GreenfootImage("3i.png");
    GreenfootImage cuatroI = new GreenfootImage("4i.png");
    GreenfootImage cincoI = new GreenfootImage("5i.png");
    // sound
    private GreenfootSound ghostdeadS=new GreenfootSound("ghostdead.wav");
    // score
    public int scoreF=0;
    
    public void act() 
    {
        int cont = contador(); // funcion regresa entero contador       
        int trans = transparencia(vida);
        movimiento(cont, trans);//movimiento con limites al azar de enemigo de jugador        
        contAnimacion++;
        
        if(contAnimacion == 50 )// contador animacion
        {
            ranAnimacion=Greenfoot.getRandomNumber(6+1);
            contAnimacion=0;
        }
        interaccion();        
    }
    /**
     * funcion de interaccion con el escenario vida, muerte.
     */
    public void interaccion()
    {
        if( isTouching(HechizosM.class))
        {
            scoreF += 25;  
            vida--;
            removeTouching(HechizosM.class);
        }
        
        if(vida == 0)
        {
            getWorld().addObject(new MarioFat(), getX(), getY()+50);
            getWorld().removeObject(this);
            //efecto sonido
            ghostdeadS.play();
            ghostdeadS.setVolume(80);
        }        
    }
    /**
     * funcion transparencia al recibir dano.
     */
    public int transparencia(int v)
    {
        
        if(v==5)
            transparente=255;
        if(v==4)
            transparente=220;
        if(v==3)
            transparente=185;
        if(v==2)
            transparente=150;
        if(v==1)
            transparente=115;
        return transparente;
    }
    /**
     * funcion para generar movimiento del fantasma.
     */
    public void movimiento(int cont, int trans)
    {        
        int move;      
        
        if(getX()>15 && getX()<780 && getY()>15 && getY()<480)
        {            
            while(fCont == 0 && cont == 10)
            {
                random=Greenfoot.getRandomNumber(10);// velocidad kirby
                fCont=0;
                if(random == 1 || random == 2 || random == 3 || random == 4 || random == 5)
                {
                    fCont=1;
                    if(random == 5 ||random == 1|| random == 2)
                        fSpell=1;
                }
            } 
            
            if( random == 1 )//|| fUp == 1 )//arriba
            {
                setLocation(getX(), getY() - 10);
                fCont=0;
                cont = 0;
                if( getY()<25 )//up
                {
                    setLocation(getX(), getY() + 25);
                    fCont = 0;
                    fUp=0;
                    random=2;
                }            
            }
        
            if( random == 2 || fDown == 1)//abajo
            {
                setLocation(getX(), getY() + 1);
                fCont=0;
                cont = 0;
                if( getY()>450 )//down
                {
                    setLocation(getX(), getY() - 25);
                    fCont = 0;
                    fDown=0;
                    random=1;
                }
            }
            
            if( random == 3 || fDer == 1)//derecha
            {
                move(1);  
                fCont=0;
                cont = 0;
                if(ranAnimacion == 1){
                    setImage(myImage);
                    myImage.setTransparency(trans);
                }
                if(ranAnimacion == 2)
                {
                    setImage(unoD);
                    unoD.setTransparency(trans);
                }
                if(ranAnimacion==3)
                {
                    setImage(dosD);  
                    dosD.setTransparency(trans);
                }
                if(ranAnimacion==4)
                {                    
                    setImage(tresD);
                    tresD.setTransparency(trans);
                }
                if(ranAnimacion==5)
                {
                    setImage(cuatroD);
                    cuatroD.setTransparency(trans);
                }
                if(ranAnimacion==6)
                {
                    setImage(cincoD); 
                    cincoD.setTransparency(trans);
                }
                if( getX()>775 )//derecha
                {
                    move(-60);
                    fCont = 1;
                    fDer=0;
                    random=4;
                }       
            }
            
            if( random == 4 || fIzq == 1)//izquierda
            {
                move(-1);
                             
                fCont=0;
                cont = 0;
                if(ranAnimacion == 1)
                {
                    setImage(myImagei);
                    myImagei.setTransparency(trans);
                }
                if(ranAnimacion == 2)
                {
                    setImage(unoI);
                    unoI.setTransparency(trans);
                }
                if(ranAnimacion==3)
                {
                    setImage(dosI);
                    dosI.setTransparency(trans);
                }
                if(ranAnimacion==4)
                {
                    setImage(tresI);
                    tresI.setTransparency(trans);
                }
                if(ranAnimacion==5)
                {
                    setImage(cuatroI);
                    cuatroI.setTransparency(trans);
                }
                if(ranAnimacion==6)
                {
                    setImage(cincoI);
                    cincoI.setTransparency(trans);
                }
                if( getX()<20 )//izquierda
                {
                    move(25);
                    fCont = 0;
                    fIzq=0;
                    random=3;
                }
            }
            
            if(fSpell == 1)//random == 5 && 
            {
                hechizo();
                random=3;
                fCont=0;
                fSpell=0;
                cont = 0;
            }
        }
    }
    /**
     * funcion contador modificado.
     */
    public int contador()
    {
        if (contador <= 100)
        {
            contador++;
        }
        else
        {            
            contador=0;
        }
        return contador;
    }
    /**
     * funcion para crear el hechizo del fantasma.
     */
    public void hechizo()
    {       
        getWorld().addObject(new HechizosF(), getX(), getY()+40);
    }
    /**
     * funcion regresa score de cada uno de los fantasmas al mundo.
     */    
    public int scoreF()
    {
        return scoreF;
    }
}
