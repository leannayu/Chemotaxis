import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Chemotaxis extends PApplet {

 //http://images.fineartamerica.com/images-medium-large/stars-in-the-night-sky-natthawut-punyosaeng.jpg
 //http://i.ytimg.com/vi/w7JrHIHi8t0/hqdefault.jpg

Jumper bob;
Jumper [] colonyBob;
Walker fred;  
Walker [] colonyFred;
public void setup()   
 {     
 	size (500,500);
 	bob = new Jumper();
 	colonyBob = new Jumper[10];
 	for(int a=0; a < colonyBob.length ; a++)
 	{
 		colonyBob[a] = new Jumper();
 	}
 	fred = new Walker();
 	colonyFred = new Walker[25];
 	for(int b=0; b < colonyFred.length ; b++)
 	{
 		colonyFred[b] = new Walker();
 	}
 }   
 public void draw()   
 {   
 	int m = 7*height/8;
 	frameRate(10);
 	for(int i =800; i>=0 ; i-=1 )
 	{
   		noStroke();
    	fill(0,0,i-230);
    	rect(0,i,500,1);
	}  
	noStroke();
	fill(0);
	rect (0, m, width, 1*height/8);
	triangle (0, m, 5, m-5, 7, m);
	triangle (8, m, 20, m-8, 22, m);
	triangle (24, m, 56, m- 7, 80, m);
	triangle (82, m, 112, m-4, 130, m);
	triangle (124, m, 150, m-10, 200, m);
	triangle (200, m, 220, m-8, 222, m);
	triangle (222, m, 312, m-4, 330, m);
	triangle (330, m, 335, m-5,347, m);
	triangle (347, m, 350, m-10, 400, m);
	triangle (404, m, 420, m-5, 425, m);
	triangle (424, m, 456, m-7, 480, m);
	triangle (480, m, 488, m-8, 500, m);
	fill(250);
	ellipse (50, 80, 120, 120);
	for(int a=0; a < colonyBob.length ; a++)
 	{
 		colonyBob[a].show();
 		colonyBob[a].jump();
 	}
 	for(int b=0; b < colonyFred.length ; b++)
 	{
 		colonyFred[b].show();
 		colonyFred[b].walk();
 	}
 }  
 class Jumper    
 {     
 	int myX, myY;
 	Jumper()
 	{
 		myX = 250;
 		myY = 250;
 	} 
 	public void jump()
 	{
 		myX = (int)(Math.random()*width);
 		myY = (int)(Math.random()*11*height/16);
 	}
 	public void show()
 	{
 		noStroke();
 		int b = (int)(Math.random()*255);
 		fill (255, 255, b);
 		int size = (int)(Math.random()*6);
 		ellipse(myX, myY, size, size);
 	}
 }
 class Walker 
 {
 	int myX, myY;
 	Walker()
 	{
 		myX = (int)(Math.random()*width);
 		myY = (int)(Math.random()*11*height/16);
 	}
 	public void walk()
 	{
 		myX = myX + (int)(Math.random()*3)-1;
 		myY = myY + (int)(Math.random()*3)-1;
 	}
 	public void show()
 	{
 		noStroke();
 		int b = (int)(Math.random()*255);
 		fill (255, 255, b);
 		int size = (int)(Math.random()*6);
 		ellipse(myX, myY, size, size);
 	}

 }  
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Chemotaxis" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
