import greenfoot.*;

/**
 * clase del actor kirby
 */
public class Kirby extends Personaje
{
    private int contador;// declaracion private de contador correcto
    private int fIzq=0, fDer=0, fUp=0, fDown=0;// banderas
    private int fCont = 0, random = 0;// contador y random
    private int fSpell=0;// bandera hechizo
    private int gravedad=80;//salto
    // score
    private int vida=15;//15
    public int scoreK=0;
    //bala
    private int contEnrageB=0;// contador enrage bala
    private int contEnrageE=0;// contador enrage escarcha
    private int tiempoIniEnrageB=97;// tiempo enrage bala
    private int tiempoIniEnrageE=80;// tiempo enrage escarcha
    private int fWin =0; // bandera ganar
    private int enrage=0;// bandera enrage
    private int contKDead=0;//contador kirby muerto
    private int derrotado=0;// bandera kirby derrotado
    //animaciones kirby derrotado
    private GreenfootImage kirbyCayendo = new GreenfootImage("kirbyfall.png");
    private GreenfootImage kirbyDerrotado = new GreenfootImage("kirbyderrotado.png");    
    GreenfootImage dos = new GreenfootImage("kirbyderrotado2.png");
    private int contAnimacion=0;// contador animacion
    // mario
    private int fMarioattack=0;// bandera mario ataque
    // sonidos
    private GreenfootSound kirbydanoS=new GreenfootSound("kirbydano.wav");
    private GreenfootSound balaS=new GreenfootSound("bala.wav");
    private GreenfootSound escarchaS=new GreenfootSound("escarcha.wav");
    private GreenfootSound marioS=new GreenfootSound("mario.wav");
    private GreenfootSound peachcaidaS=new GreenfootSound("peachcaida.wav");
    //nivel 
    public int nivel=1;
    
    public void act() 
    {
        int cont = contador(); // funcion regresa entero contador        
        contAnimacion++;
        if(derrotado == 0)
            contKDead++;
        if(contKDead == 2)
        {
            contKDead=0;
        }
        if(contAnimacion == 20)
            contAnimacion=0;       
        acciones(cont);// funcion vida, movimiento y muerte       
    }
    /**
     * funcion para verificar movimiento , vida y muerte
     */
    public void acciones(int cont)
    {       
        if(vida != 0  && fWin == 0)
        {
            movimiento(cont);//movimiento con limites al azar de enemigo de jugador
        }
        else
        {
            if( derrotado == 0)// contKDead == 1 &&
            {
                setImage(kirbyCayendo);
                setLocation(getX(), getY() + contKDead+10);
                if (isTouching(piso.class))
                {            
                    setImage(kirbyDerrotado);
                    derrotado=1;
                }    
            }
            
            if(derrotado == 1)// && derrotado == 0
            {
                setLocation(getX(), getY() + contKDead);
                if (isTouching(piso.class))
                {
                    //efecto sonido
                    kirbydanoS.play();
                    kirbydanoS.setVolume(90); 
                    if(contAnimacion==1)
                        setImage(kirbyDerrotado);                    
                    if(contAnimacion==19)
                        setImage(dos);
                    contKDead=2;                    
                }       
            }           
        }        
                
        if (isTouching(HechizosM.class) && fWin == 0)
        {            
            removeTouching(HechizosM.class);
            vida--;
            //efecto sonido
            kirbydanoS.play();
            kirbydanoS.setVolume(70);            
        }
        
        if (isTouching(HechizosM.class) && fWin == 1)// despues de ganarle        
        {            
            removeTouching(HechizosM.class);
            setImage(kirbyDerrotado);
        }
        // enrage
        if(vida <= 10 && fWin == 0)// reset contador y creacion de balas
        {   
            nivel=2;
            bala();
            escarcha();
            if(vida <= 8 && fWin == 0)// reset contador y creacion de balas
            {
                nivel=3;
                bala();
                escarcha();
                if(vida <= 5 && fWin == 0)// reset contador y creacion de balas
                {
                    nivel=4;
                    bala();
                    escarcha();
                    if(vida <= 2 && fWin == 0)// reset contador y creacion de balas
                    {
                        nivel=5;
                        bala();
                        escarcha();
                        if(vida <= 1 && fWin == 0 && fMarioattack == 0)
                        {
                            nivel=6;
                            fMarioattack = 1;
                            marioAttack();
                            //efecto sonido
                            marioS.play();
                            marioS.setVolume(70);
                        }
                    }
                }
            }
        }       
        
        if(vida == 0 && fWin == 0 && fWin == 0)
        {            
            getWorld().addObject(new Princesa(), getX(), getY());
            fWin = 1;            
            //efecto sonido
            peachcaidaS.play();
            peachcaidaS.setVolume(60);
        }
    }
    
    /**
     * funcion crear hechizo escarcha
     */
    public void escarcha()// private void hechizos(String nombre)
    {
        contEnrageE++;
        if(contEnrageE == tiempoIniEnrageE)
        {
            getWorld().addObject(new Escarcha(), Greenfoot.getRandomNumber(700+50), 10);
            contEnrageE=0;
            //efecto sonido
            escarchaS.play();
            escarchaS.setVolume(70);
        }
    }
    /**
     * funcion crear hechizo bala.
     */
    public void bala()
    {
        contEnrageB++;
        if(contEnrageB == tiempoIniEnrageB)
        {
            getWorld().addObject(new BalaB(), 750, Greenfoot.getRandomNumber(500+50));
            contEnrageB=0;
            //efecto sonido
            balaS.play();
            balaS.setVolume(70);
        }
    }
    /**
     * funcion movimiento de kirby.
     */
    public void movimiento(int cont)
    {
        GreenfootImage myImage;
        int move;      
        
        if(getX()>15 && getX()<780 && getY()>15 && getY()<480)
        {            
            while(fCont == 0 && cont == 20)
            {
                random=Greenfoot.getRandomNumber(10);// velocidad kirby
                fCont=0;
                if(random == 1 || random == 2 || random == 3 || random == 4 || random == 5)
                {
                    fCont=1;
                    if(random == 5)
                        fSpell=1;
                }
            } 
            
            if( random == 1 )//|| fUp == 1 )//arriba
            {
                setLocation(getX(), getY() - 10);
                fCont=0;
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
                myImage = new GreenfootImage("kirbysmall.png");
                setImage(myImage);
                fCont=0;
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
                myImage = new GreenfootImage("kirbysmallizq.png");
                setImage(myImage);
                fCont=0;
                if( getX()<20 )//izquierda
                {
                    move(25);
                    fCont = 0;
                    fIzq=0;
                    random=3;
                }
            }
            
            if(random == 5)
            {
                if(fSpell == 1)// bandera hechizo
                {
                    hechizo();
                    fCont=0;
                    fSpell=0;
                    random=3;
                }
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
     * funcion para saber si esta tocando el piso.
     */
    public int enPiso()
    {
        int tocando=0;
        Actor piso;
        piso=getOneObjectAtOffset(0, 20, piso.class);
        if (piso == null)
            return tocando=0;// no piso
        else
            return tocando=1;// piso
    }
    /**
     * funcion para saltar y agregar gravedad.
     */
    public void salto(int cont)
    {
        if ( Greenfoot.isKeyDown("space") && enPiso() == 1 )//salto
        {
            setLocation(getX(), getY() - gravedad);
        }
        if (cont == 5 && enPiso() == 0)//piso != null && 
        {
            setLocation(getX(), getY() + gravedad);
            gravedad++;
        }        
    }
    /**
     * funcion lanzar y crear hechizo.
     */
    public void hechizo()
    {       
        getWorld().addObject(new HechizosK(), getX(), getY()+40);       
    }
    /**
     * funcion lanzar y crear hechizo mario.
     */
    public void marioAttack()
    {
        getWorld().addObject(new Mario(), 50, 532);
    }    
    /**
     * funcion que regresa el score al mundo.
     */
    public int scoreK()
    {
        return scoreK;
    }
    /**
     * funcion que regresa el nivel del escenario al mundo.
     */
    public int nivelK()
    {
        return nivel;
    }
    /**
     * funcion que regresa la vida de kirby al escenario.
     */
    public int vidaK()
    {
        return vida;
    }
}
