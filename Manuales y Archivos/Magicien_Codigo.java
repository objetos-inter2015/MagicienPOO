import greenfoot.*;
import javax.swing.*;
/**
 * clase que contiene el menu principal del juego.
 * @author LOPEZ SILVA MARTIN RAMON
 * @version 26/06/15
 */
public class Portada extends World
{
    //sonido
    private GreenfootSound kirbyS=new GreenfootSound("kirby.wav");    
    public Portada()
    {       
        super(800, 600, 1);        
    }    
    
    public void act()
    {        
        menu();
    }
    /**
     * funcion que contiene el menu y sus interacciones.
     */
    public void menu()
    {
        if(Greenfoot.isKeyDown("0"))//musica
        {
            //musica
        }
        if(Greenfoot.isKeyDown("1"))//Jugar
        {           
            Greenfoot.setWorld(new Play());
        }
        if(Greenfoot.isKeyDown("2"))// Ayuda
        {
            //efecto sonido
            kirbyS.setVolume(65);
            kirbyS.play();            
            Greenfoot.delay(20);
            Greenfoot.setWorld(new AyudaMagicien());
        }
        if(Greenfoot.isKeyDown("3"))//Creditos
        {
            //efecto sonido
            kirbyS.setVolume(65);
            kirbyS.play();   
            Greenfoot.delay(20);
            Greenfoot.setWorld(new Creditos());
        }
        if(Greenfoot.isKeyDown("4"))// Salir
        {
            kirbyS.setVolume(65);
            kirbyS.play();        
            System.exit(0);
        }
    }
}


import greenfoot.*;

/**
 * clase que contiene el final del juego.
 */
public class Final extends World
{

    /**
     * Constructor for objects of class Final.
     * 
     */
    public Final()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 
    }
}

import greenfoot.*;

/**
 * clase con la escena final del juego.
 */
public class Escena1 extends Final
{
    private int contEscena=0;
    private int tiempoEscena=50;
    
    public void act()
    {
        Greenfoot.delay(100);// delay para ver escena
        contEscena++;
        interaccion(contEscena);
    }
    /**
     * funcion para realizar una espera o interaccion con el teclado 
     */
    public void interaccion(int contEscena)
    {
        // reset de contador
        Greenfoot.delay(120);
        Greenfoot.setWorld(new Portada());
        if(contEscena == tiempoEscena + 1) 
        {
            contEscena=0;
        }
        // condicional de espera o tecla enter
        if(Greenfoot.isKeyDown("enter"))
        {
            Greenfoot.setWorld(new Portada());
        }
    }
}

import greenfoot.*;

/**
 * clase para mostrar la portada de creditos
 */
public class Creditos extends World
{
    //sonido
    private GreenfootSound kirbyS=new GreenfootSound("kirby.wav");
    
    public Creditos()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 
    }
    
    public void act()
    {
        interaccion();
    }
    /**
     * funcion para realizar una espera o interaccion con el teclado.
     */
    public void interaccion()
    {
        if(Greenfoot.isKeyDown("enter"))// Ayuda
        {
            //efecto sonido
            kirbyS.setVolume(65);
            kirbyS.play();   
            Greenfoot.delay(20);
            Greenfoot.setWorld(new Portada());
        }
    }
}

import greenfoot.*;

/**
 * clase principal del juego. se invocan todos los elementos del juego desde aqui.
 */
public class Play extends World
{
    private int contWorld=0;//contador
    private int fContador=0;//bandera contador
    //private Fantasma []ghost={ new Fantasma(), new Fantasma(), new Fantasma(), new Fantasma(), new Fantasma(), new Fantasma(), new Fantasma(), new Fantasma(), new Fantasma(), new Fantasma()};
    private Fantasma g1=new Fantasma();
    private Fantasma g2=new Fantasma();
    private Fantasma g3=new Fantasma();
    private Fantasma g4=new Fantasma();
    private Fantasma g5=new Fantasma();
    private Fantasma g6=new Fantasma();
    private Fantasma g7=new Fantasma();
    private Fantasma g8=new Fantasma();
    private Fantasma g9=new Fantasma();
    private Fantasma g10=new Fantasma();
    //sonido
    private GreenfootSound kirbyS=new GreenfootSound("kirby.wav");
    //score magicien
    public String nombreM;
    public int puntosM;
    public int puntosK;
    public int scoreTotal;
    public int vidaM;
    //score
    public int nivelK;
    public int vidaK;
    public Magicien m=new Magicien();
    public Kirby k=new Kirby();    
    //puntos score fantasmas
    public int pG1;
    public int pG2;
    public int pG3;
    public int pG4;
    public int pG5;
    public int pG6;
    public int pG7;
    public int pG8;
    public int pG9;
    public int pG10;    
    
    public Play()
    {    
        super(800, 600, 1);
        
        piso p=new piso();//objeto piso
        // agregar objetos
        addObject(p, 400,560);//piso
        addObject(m, 50,532);// mago        
        addObject(k, 700, 60);//kirby        
    }
    
    public void act() 
    {        
        if (fContador == 0)
        {
            contWorld++;
        }
        if(contWorld == 101)// reset de contador para agregar objetos al escenario
        {
            fContador=1;
        }
        agregarGhost(contWorld);
        // score por return de magicien.
        puntosM = m.scoreM();
        //score por return kirby.
        puntosK = k.scoreK();
        //score por return fantasmas.
        pG1 = g1.scoreF();
        pG2 = g2.scoreF();
        pG3 = g3.scoreF();
        pG4 = g4.scoreF();
        pG5 = g5.scoreF();
        pG6 = g6.scoreF();
        pG7 = g7.scoreF();
        pG8 = g8.scoreF();
        pG9 = g9.scoreF();
        pG10 = g10.scoreF();
        
        // nombre por return magicien.
        nombreM = m.nombreM();
        // vida por return magicien.
        vidaM = m.vidaM();
        //total de puntaje
        scoreTotal = puntosM + puntosK + pG1 + pG2 + pG3 + pG4 + pG5 + pG6 + pG7 + pG8 + pG9 + pG10;
        // nivel por return kirby.
        nivelK = k.nivelK(); 
        // vida por return kirby.
        vidaK = k.vidaK();
        // marcador o contador magicien
        showText("MAGICIEN " + nombreM +"      VIDA: "+ vidaM + "      SCORE: " + scoreTotal, 200, 585);
        // marcador o contador kirby
        showText(" NIVEL ESCENARIO: "+ nivelK + "       KIRBY: " + vidaK, 620, 585);
        if(m.muerto() == 1)
            addObject(new ScoreInGame(nombreM, vidaM, scoreTotal, 1), 400, 300);//gameover
        if(m.rescatada() == 1)
            addObject(new ScoreInGame(nombreM, vidaM, scoreTotal, 2), 400, 300);//win
    }
    /**
     * funcion agrega fantasma al escenario.
     */
    public void agregarGhost(int contWorld)
    {
        if(contWorld==10)
        {
            addObject(g1, Greenfoot.getRandomNumber(600)+ 100,Greenfoot.getRandomNumber(400)+ 80 );
        }
        if(contWorld==20)
        {
            addObject(g2, Greenfoot.getRandomNumber(600)+ 100,Greenfoot.getRandomNumber(400)+ 80 );
        }
        if(contWorld==30)
        {
            addObject(g3, Greenfoot.getRandomNumber(600)+ 100,Greenfoot.getRandomNumber(400)+ 80 );
        }
        if(contWorld==40)
        {
            addObject(g4, Greenfoot.getRandomNumber(600)+ 100,Greenfoot.getRandomNumber(400)+ 80 );
        }
        if(contWorld==50)
        {
            addObject(g5, Greenfoot.getRandomNumber(600)+ 100,Greenfoot.getRandomNumber(400)+ 80 );
        }
        if(contWorld==60)
        {
            addObject(g6, Greenfoot.getRandomNumber(600)+ 100,Greenfoot.getRandomNumber(400)+ 80 );
        }
        if(contWorld==70)
        {
            addObject(g7, Greenfoot.getRandomNumber(600)+ 100,Greenfoot.getRandomNumber(400)+ 80 );
        }
        if(contWorld==80)
        {
            addObject(g8, Greenfoot.getRandomNumber(600)+ 100,Greenfoot.getRandomNumber(400)+ 80 );
        }
        if(contWorld==90)
        {
            addObject(g9, Greenfoot.getRandomNumber(600)+ 100,Greenfoot.getRandomNumber(400)+ 80 );
        }
        if(contWorld==100)
        {
            addObject(g10, Greenfoot.getRandomNumber(600)+ 100,Greenfoot.getRandomNumber(400)+ 80 );
        }
    }
}

import greenfoot.*;

/**
 *clase que contiene las portadas de ayuda para el juego.
 */
public class Ayuda extends World
{
    public Ayuda()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 
    }
}

import greenfoot.*;

/**
 * clase para la portada de ayuda de los fantasmas.
 */
public class AyudaGhost extends Ayuda
{
    //sonido
    private GreenfootSound kirbyS=new GreenfootSound("kirby.wav");
    
    /**
     * Constructor for objects of class AyudaGhost.
     * 
     */
    public AyudaGhost()
    {
    }
    public void act()
    {
        interaccion();
    }
    /**
     * funcion para realizar una espera o interaccion con el teclado.
     */
    public void interaccion()
    {
        if(Greenfoot.isKeyDown("enter"))// Ayuda
        {
            //efecto sonido
            kirbyS.setVolume(65);
            kirbyS.play();   
            Greenfoot.delay(20);
            Greenfoot.setWorld(new Portada());
        }
    }
}

import greenfoot.*;

/**
 * clase que contiene la portada ayuda de kirby.
 */
public class AyudaKirby extends Ayuda
{
    //sonido
    private GreenfootSound kirbyS=new GreenfootSound("kirby.wav");
    
    /**
     * Constructor for objects of class AyudaKirby.
     * 
     */
    public AyudaKirby()
    {
    }
    public void act()
    {
        interaccion();
    }
    /**
     * funcion para realizar una espera o interaccion con el teclado. 
     */
    public void interaccion()
    {
        if(Greenfoot.isKeyDown("enter"))// Ayuda
        {
            //efecto sonido
            kirbyS.setVolume(65);
            kirbyS.play();   
            Greenfoot.delay(20);
            Greenfoot.setWorld(new AyudaGhost());
        }
    }
}

import greenfoot.*;

/**
 * clase que contiene la ayuda de magicien.
 */
public class AyudaMagicien extends Ayuda
{
    //sonido
    private GreenfootSound kirbyS=new GreenfootSound("kirby.wav");
    
    /**
     * Constructor for objects of class AyudaMagicien.
     * 
     */
    public AyudaMagicien()
    {
    }
    public void act()
    {
        interaccion();
    }
    /**
     * funcion para realizar una espera o interaccion con el teclado.
     */
    public void interaccion()
    {
        if(Greenfoot.isKeyDown("enter"))// Ayuda
        {
            //efecto sonido
            kirbyS.setVolume(65);
            kirbyS.play();   
            Greenfoot.delay(20);
            Greenfoot.setWorld(new AyudaKirby());
        }
    }
}

// ACTORES

import greenfoot.*;

/**
 * clase que contiene los personajes principales del juego.
 */
public class Personaje extends Actor
{
    /**
     * Act - do whatever the Personaje wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
}

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

import greenfoot.*;

/**
 * Write a description of class Marcador here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Marcador extends Actor
{
    /**
     * clase que contiene marcadores de perder o ganar juego.
     */
    public void act() 
    {
        // Add your action code here.
    }    
}

import greenfoot.*;
import java.awt.Color;
/** 
 * clase para agregar pantalla de puntaje en el juego 
 */
public class ScoreInGame extends Marcador
{
    public String nombre;
    public int vida;
    public int score;
    public int t=0;
    /**
     * Constructor con parametros para escoger la pantalla de puntaje
     */
    public ScoreInGame(String name, int life, int puntos, int tipo)
    {
        if (tipo == 1) // gameover letra blanca, fondo rosa
        {
            nombre=name;
            vida=life;
            score=puntos;
            t=tipo;            
            GreenfootImage textImage = new GreenfootImage(nombre+" Score: "+score +" Vidas: "+vida, 60, new Color(255,255,255), new Color(0, 0, 0, 0));
            GreenfootImage image = new GreenfootImage(800, 65);
            image.setColor(new Color(0,0,0));
            image.setColor(new Color(217,72,139));// fondo
            image.fillRect(0, 20, image.getWidth(), image.getHeight());            
            image.drawImage(textImage, 10, 10);
            setImage(image);
        }
        if (tipo == 2) // gameover letra blanca, fondo azul
        {
            nombre=name;
            vida=life;
            score=puntos;
            t=tipo;            
            GreenfootImage textImage = new GreenfootImage(nombre+" Score: "+score +" Vidas: "+vida, 60, new Color(255,255,255), new Color(0, 0, 0, 0));
            GreenfootImage image = new GreenfootImage(800, 65);
            image.setColor(new Color(0,0,0));
            image.setColor(new Color(54,125,217));// fondo
            image.fillRect(0, 20, image.getWidth(), image.getHeight());            
            image.drawImage(textImage, 10, 10);
            setImage(image);
        }
    }
    public void act() 
    {        
        if(Greenfoot.isKeyDown("enter") && t == 1)// Ayuda
        {            
            Greenfoot.delay(30);
            Greenfoot.setWorld(new Portada());
        }
        if(t == 2)// Ayuda
        {            
            Greenfoot.delay(70);
            Greenfoot.setWorld(new Escena1());
        }
    }    
}

import greenfoot.*;

/**
 * clase para contener los items del juego
 */
public class items extends Actor
{
    /**
     * Act - do whatever the items wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
}

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

import greenfoot.*;

/**
 * clase para contener los hechizos del jugador como tambien de los enemigos
 */
public class Hechizos extends Actor
{
    /**
     * Act - do whatever the Hechizos wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
}

import greenfoot.*;

/**
 * clase hechizo bala.
 */
public class BalaB extends Hechizos
{
    private int velPoder=10;// velocidad hechizo
    
    public void act() 
    {
        setLocation(getX() - velPoder, getY());
        if(isAtEdge() == true)// hechizo a la orilla borrarlo
            getWorld().removeObject(this);       
    }  
}

import greenfoot.*;

/**
 * clase hechizo zonal escarcha.
 */
public class Escarcha extends Hechizos
{
    private int velPoder=8;// velocidad hechizo
    //animacion
    private int contAnimacion=0;// contador animacion
    GreenfootImage uno = new GreenfootImage("s1.png");
    GreenfootImage dos = new GreenfootImage("s2.png");
    GreenfootImage tres = new GreenfootImage("s3.png");
    GreenfootImage cuatro = new GreenfootImage("s4.png");
    GreenfootImage cinco = new GreenfootImage("s5.png");
    
    public void act() 
    {
        contAnimacion++;
        setLocation(getX(), getY()+velPoder);            
        
        if(contAnimacion == 51 )// contador animacion
        {
            contAnimacion=0;
        }        
                
        if(isAtEdge() == true)// objeto en la orilla borrar
            getWorld().removeObject(this);
    }
    /**
     * funcion para crear la animacion de el hechizo escarcha.
     */
    public void animacion()
    {        
        if(contAnimacion == 10)
            setImage(uno);
        if(contAnimacion==20)
            setImage(dos);
        if(contAnimacion == 30)
            setImage(tres);
        if(contAnimacion== 40)
            setImage(cuatro);
        if(contAnimacion==50)
            setImage(cinco);
    }
}

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

import greenfoot.*;

/**
 * clase para el hechizo de kirby
 */
public class HechizosK extends Hechizos
{
    private int velPoder=10;// velocidad hechizo
    
    public void act() 
    {
        setLocation(getX(), getY()+velPoder);
    }    
}

