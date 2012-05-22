package testtower;

public class Mirko_Test {

   static final int WIDTH = 1024;
   static final int HEIGHT = 576;
   static boolean ship1 = true;
   static boolean ship2 = true;
   static boolean ship3 = true;
   static boolean ship4 = true;
   
   
   public static void main(String[] args) {
      
      setWindow();
      game();
      
   }
   
   /*
    * sets window settings, size, scale
    * */
   public static void setWindow() {
      
      StdDraw.setCanvasSize(WIDTH, HEIGHT);
      StdDraw.setXscale(0, WIDTH);
      StdDraw.setYscale(0, HEIGHT);
      
      // Background
      StdDraw.picture(WIDTH/2, HEIGHT/2, "back1.png", WIDTH, HEIGHT);
      
      // Waypoints
      setWay();
      
      // Coords
      StdDraw.text(      50,     10, "unten links");
      StdDraw.text(WIDTH-50,     10, "unten rechts");
      StdDraw.text(WIDTH-50, HEIGHT-10, "oben rechts");
      StdDraw.text(      50, HEIGHT-10, "oben links");
      StdDraw.text(WIDTH/2, HEIGHT/2, "mitte");
      

   }
   
   public static void setWay() {
      
      // Way
      StdDraw.picture(WIDTH/2-300, HEIGHT/2, "weg.png");
      StdDraw.picture(WIDTH/2-100, HEIGHT/2, "weg.png");
      StdDraw.picture(WIDTH/2+100, HEIGHT/2, "weg.png");
      StdDraw.picture(WIDTH/2+300, HEIGHT/2, "weg.png");
      StdDraw.picture(WIDTH/2+500, HEIGHT/2, "weg.png");

   }
   /*
    * click with mouse on a ship to attack it
    * returns true on hit
    * */
   public static void shootShip(int x) {
      
      
      //System.out.println(StdDraw.mouseX());
      
      
      if(StdDraw.mousePressed() == true) {
         
         double r = StdDraw.mouseX() - WIDTH/2;
         double s = r - x;
         
         if(s > 40 || s < -40) ship2 = true; else ship2 = false;
         /*System.out.println("SHOOT!");
         System.out.println("mouseX = " + r);
         System.out.println("x = " + x);*/
         
      }
         
         /*
         if(  StdDraw.mouseX() > x+100 && 
               StdDraw.mouseY() > y+60 || 
               StdDraw.mouseX() > x-100 && 
               StdDraw.mouseY() > y-60
           ) {
            System.out.println("SHIP!");
            return true;
         } else {
            System.out.println("WATER!");
            return false;
            
         }
      */
   }
   
   public static void game() {
      
      int x1 = -300;
      int x2 = -200;
      int x3 = -100;
      int x4 = 0;
      
      int y1 = 0;
      
      while(true) {
         
         // set waypoints
         setWay();
         
         // Ships
         if(ship1 == true)StdDraw.picture(WIDTH/2+x1, HEIGHT/2+y1, "testschiff1.png");
         if(ship2 == true)StdDraw.picture(WIDTH/2+x2, HEIGHT/2, "testschiff1.png");
         if(ship3 == true)StdDraw.picture(WIDTH/2+x3, HEIGHT/2, "testschiff1.png");
         if(ship4 == true)StdDraw.picture(WIDTH/2+x4, HEIGHT/2, "testschiff1.png");
         
         
         // move ships
         x1 += 1;
         x2 += 1;
         x3 += 1;
         x4 += 1;
         
         y1 += 1;
         
         if(x1 > 300) x1 = -300;
         if(x2 > 300) x2 = -300;
         if(x3 > 300) x3 = -300;
         if(x4 > 300) x4 = -300;
         
         // shoot ships
         shootShip(x1);
         shootShip(x2);
         shootShip(x3);
         shootShip(x4);
         
         // refresh
         StdDraw.show(10);

      }
   }

}
