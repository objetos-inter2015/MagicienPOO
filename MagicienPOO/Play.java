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
