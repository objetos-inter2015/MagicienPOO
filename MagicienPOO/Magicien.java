import greenfoot.*;
import javax.swing.*;
/**
 * clase de actor magicien.
 */
public class Magicien extends Personaje
{
    //informacion score y jugador
    public String nombre="";
    public int score=0;
    public int ghostPuntaje=100;
    public int kirbyPuntaje=1000;
    public int fScore=0;    
    // variables contador
    private int contador;// declaracion private de contador correcto    
    private int tamContador=50; // variable para salto tiempo
    // variables salto
    private int jumpAltura=120;//tamano salto
    private int velJump=10;//velocidad salto
    private int velCaida=10;// velocidad caida
    private int fSalto=0; // bandera de salto
    private int fCaida=0;//bandera de caida
    private int pisoY;// piso coordenadas
    // score
    private int vida=3;//3
    // poderes
    private int contPoder=0; // contador hechizo
    private int timePoder=35;// tiempo hechizo
    private int fPoder=0;// bandera hechizo
    private int contAnimacion=0;// contador animacion
    // muerto
    private int fDead=0;// bandera muerto
    private int fMuerto=0;//bandera muerto para marcador en mundo
    private int contDead=0;// contador muerto
    public int fRescatada=0;// princesa rescatada
    // animacion
    GreenfootImage myImage ;
    //animacion izquierda
    GreenfootImage unoI = new GreenfootImage("01.png");
    GreenfootImage dosI = new GreenfootImage("02.png");
    GreenfootImage tresI = new GreenfootImage("03.png");
    GreenfootImage cuatroI = new GreenfootImage("04.png");
    GreenfootImage cincoI = new GreenfootImage("05.png");
    //animacion derecha
    GreenfootImage unoD = new GreenfootImage("01d.png");
    GreenfootImage dosD = new GreenfootImage("02d.png");
    GreenfootImage tresD = new GreenfootImage("03d.png");
    GreenfootImage cuatroD = new GreenfootImage("04d.png");
    GreenfootImage cincoD = new GreenfootImage("05d.png");
    // animaciones down y muerte
    GreenfootImage down = new GreenfootImage("down.png");
    GreenfootImage dead = new GreenfootImage("dead.png");
    //sonido
    GreenfootSound magicienS=new GreenfootSound("hechizom.wav");
    GreenfootSound vidaS=new GreenfootSound("vidam.wav");
    GreenfootSound saltoS=new GreenfootSound("saltom.wav");
    GreenfootSound star=new GreenfootSound("kirby.wav");
     //sonido
    private static GreenfootSound goS=new GreenfootSound("rescatada.wav");
    public int fMusic=0;
    public int fMusic2=0;
    //nombre
    private int fNombre=0;// bandera nombre
    public void act() 
    {
        pideNombre();// pide nombre
        
        int cont = contador(tamContador);// funcion Contador    
        contPoder++; // contador poder        
        contAnimacion++;
        contDead++;
        
        if(contAnimacion == 21)// contador animacion
            contAnimacion=0;
        if( contDead == 50)// contador animacion
            contDead=0;         
        interaccion();        
        if(getX()>10 && getX()<785 && getY()>4 && getY()<550 && fDead == 0)
        {
            movimiento();
            salto(cont);            
            colision();                      
        }
    }
    /**
     * funcion que verifica interacciones vida, muerte, movimiento.
     */
    public void interaccion()
    {
        if(vida <= 0)
        {
            setImage(dead);
            setLocation(getX(), getY()+1);
            fDead=1;
            if(contDead == 20 && fDead==1)
            {
                if(isAtEdge() == true){
                    fMuerto=1;
                    if(fMusic == 0)
                    {
                        fMusic=1;
                        goS.setVolume(80);
                        goS.play();
                    }
                }
                if(isTouching(piso.class)==false) 
                    setLocation(getX(), getY()+6);
                else
                {
                    setLocation(getX(), getY());
                    if(contDead == 20 )
                    {
                        fMuerto=1;
                    }
                }                
            }            
        }    
    }
    /**
     * funcion colisiones.
     */
    public void colision()
    {
            if (isTouching(HechizosK.class))
            {            
                removeTouching(HechizosK.class);
                vida--;
            }
             
            if (isTouching(HechizosF.class))
            {            
                removeTouching(HechizosF.class);
                vida--;
            }
            
            if (isTouching(Kirby.class) || isTouching(Fantasma.class) || isTouching(BalaB.class) || isTouching(Mario.class))// choque con personajes
            {
                vida=0;
            }
            
            if(isTouching(MarioFat.class))
            {
                removeTouching(MarioFat.class);
                vida++;
                //sonido
                vidaS.play();
                vidaS.setVolume(85);
                score += ghostPuntaje;
            }
            if(isTouching(Escarcha.class))
            {
                removeTouching(Escarcha.class);
                vida--;
            }
            if(isTouching(FireBallM.class))
            {
                vida--;
            } 
            if(isTouching(Princesa.class))
            {                
                if (fScore == 0){
                    fScore = 1;
                    score += kirbyPuntaje;
                    fRescatada=1;
                    if(fMusic2 == 0)
                    {
                        fMusic2=1;
                        goS.setVolume(80);
                        goS.play();
                    }
                }
            }   
    }
    /**
     * funcion pide nombre al jugador.
     */
    public void pideNombre()
    {
        //nombre
        if(fNombre == 0)
        {
            nombre = JOptionPane.showInputDialog(null,"Cual es tu nombre magicien: " ,"Ingresa nombre" ,JOptionPane.QUESTION_MESSAGE);
            //efecto sonido
            star.setVolume(65);
            star.play();            
            fNombre = 1;
        }
    }
    /**
     * funcion de movimiento del personaje magicien.
     */
    public void movimiento()
    {        
        if (contPoder > timePoder && fPoder==0)
        {
            fPoder=1;
            contPoder=0;
        }
        
        if ( Greenfoot.isKeyDown("w") || Greenfoot.isKeyDown("up"))//arriba
        {
            myImage = new GreenfootImage("UpIzq.png");
            setImage(myImage);
            if(Greenfoot.isKeyDown("1") && fPoder==1)
            {
                fPoder=0;
                hechizo(2);
                contPoder=0;                
            }
        }
        if ( Greenfoot.isKeyDown("s") || Greenfoot.isKeyDown("down"))//abajo  && enPiso() == 0
        {
            setImage(down);
        }
        if ( Greenfoot.isKeyDown("a") || Greenfoot.isKeyDown("left"))//izquierda
        {
            myImage = new GreenfootImage("walkIzq0.png");
            move(-10);
            //animaciones
            setImage(myImage);
            if(contAnimacion == 4)
                setImage(unoI);
            if(contAnimacion==8)
                setImage(dosI);
            if(contAnimacion==12)
                setImage(tresI);
            if(contAnimacion==16)
                setImage(cuatroI);
            if(contAnimacion==20)
                setImage(cincoI);                
            if(Greenfoot.isKeyDown("1") && fPoder==1)
            {
                hechizo(1);
                fPoder=0;
                contPoder=0;                
            }
            if(getX()<=11)
                move(10);
        }
        if ( Greenfoot.isKeyDown("d") || Greenfoot.isKeyDown("right"))//derecha
        {
            myImage = new GreenfootImage("walkDer0.png");
            move(10);
            setImage(myImage);
            if(contAnimacion == 4)
                setImage(unoD);
            if(contAnimacion==8)
                setImage(dosD);
            if(contAnimacion==12)
                setImage(tresD);
            if(contAnimacion==16)
                setImage(cuatroD);
            if(contAnimacion==20)
                setImage(cincoD); 
            if(Greenfoot.isKeyDown("1") && fPoder==1)
            {
                hechizo(3);
                fPoder=0;
                contPoder=0;                
            }
            if(getX()>=784)
                move(-10);
        }
    }
    /**
     * funcion contador modificado.
     */
    public int contador(int tamContador)
    {        
        if (contador == tamContador)
        {
            contador=0;            
        }
        else        
            contador++;
            
        return contador;
    }
    /**
     * funcion para verificar si el personaje esta en el piso.
     */
    public int enPiso()
    {
        int tocando=0;
        pisoY=532;//532 en y
        Actor piso;
        piso=getOneObjectAtOffset(0, 20, piso.class);
        if (piso == null)
            return tocando=0;// no piso
        else
            return tocando=1;// piso
    }
    /**
     * funcion para saltar y agregar efecto gravedad.
     */
    public void salto(int cont)
    {
        int actoreny=getY();
        //tecla espacio salto
        if ( Greenfoot.isKeyDown("space") && enPiso() == 1 && fSalto == 0 && fCaida == 0)//salto
        {
            fSalto=1;
            //sonido
            saltoS.play();
            saltoS.setVolume(73);
        }
        // salto
        if (fSalto == 1)//saltando if (cont == 2 && enPiso() == 0) o if (fsalto == 1 && enPiso() == 0)
        {            
            if( actoreny > pisoY - jumpAltura)// mayor que 532 + 50
                setLocation(getX(), getY() - velJump);
            if( actoreny == pisoY - jumpAltura)// igual que 532 + 50
            {
                fCaida=1;
                fSalto=0;
            }            
        }
        //caida salto
        if (fCaida == 1)
        {
            if( actoreny < pisoY)// menor que 532 + 50
            {
                setLocation( getX(), getY() + velCaida);                
            }
            if(actoreny == pisoY)
                    fCaida=0;
        }
    }
    /**
     * funcion para crear el hechizo de magicien.
     */
    public void hechizo(int opcion)
    {
        //sonido
        magicienS.play();
        magicienS.setVolume(77);
        if(opcion == 1)//izquierda
        {
            getWorld().addObject(new HechizosM(1), getX()-30, getY());
            opcion=0;
        }
        
        if(opcion == 2)//arriba
        {
            getWorld().addObject(new HechizosM(2), getX(), getY()-30);
            opcion=0;
        }
        
        if(opcion == 3)//derecha
        {
            getWorld().addObject(new HechizosM(3), getX()+30, getY());
            opcion=0;
        }
        
        if(opcion == 4)//izquierda diagonal
        {
            getWorld().addObject(new HechizosM(4), getX()-30, getY()-30);
            opcion=0;
        }
        
        if(opcion == 5)//derecha diagonal
        {
            getWorld().addObject(new HechizosM(5), getX()+30, getY()-30);
            opcion=0;
        }
    }    
    /**
     * funcion que regresa score al mundo.
     */
    public int scoreM()
    {
        return score;
    }
    /**
     * funcion que regresa nombre al mundo.
     */
    public String nombreM()
    {
        return nombre;
    }
    /**
     * funcion que regresa vida al mundo.
     */
    public int vidaM()
    {
        return vida;
    }
    /**
     * funcion que regresa bandera de magicien si murio al mundo.
     */
    public int muerto()
    {
        return fMuerto;
    }
    /**
     * funcion que regresa si la princesa fue rescada al mundo
     */
    public int rescatada()
    {
        return fRescatada;
    }
}