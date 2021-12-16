package InterfaceGrafica;
import processing.core.PApplet;

//Adaptação de código de Mitko Nikov: https://github.com/mitkonikov/Processing
public class TextBox {
	   private int X = 500, Y = 500, H = 35, W = 200;
	   private int TEXTSIZE = 24;
	   private PApplet app;
	   
	   private boolean BorderEnable = false;
	   private int BorderWeight = 1;
	   
	   private String Text = "";
	   private int TextLength = 0;
	   
	   public TextBox(PApplet app) {
		   this.app = app;
		   this.X = app.width/2; 
		   this.Y = app.height/2 + app.height/5; 
		   this.W = app.width/3; 
		   this.H = app.height/15;
	   }
	   
	   public TextBox(PApplet app, int x, int y, int w, int h) {
	      this.app = app;
		  this.X = x; this.Y = y; this.W = w; this.H = h;
	   }
	   
	   void draw() {
	      // DRAWING THE BACKGROUND
	      app.fill(app.color(160, 160, 160));
	      app.rect(X, Y, W, H);
	      // DRAWING THE TEXT ITSELF
	      app.fill(app.color(0, 0, 0));
	      app.textSize(TEXTSIZE);
	      app.text(Text, X, Y);
	   }
	   
	   // IF THE KEYCODE IS ENTER RETURN 1
	   // ELSE RETURN 0
	   boolean keyPressed(char KEY, int KEYCODE) {
	     
	         if (KEYCODE == (int) app.BACKSPACE) {
	            backspace();
	         } else if (KEYCODE == 32) {
	            // SPACE
	            addText(' ');
	         } else if (KEYCODE == (int) app.ENTER) {
	            return true;
	         } else {
	            // CHECK IF THE KEY IS A LETTER OR A NUMBER
	            boolean isKeyCapitalLetter = (KEY >= 'A' && KEY <= 'Z');
	            boolean isKeySmallLetter = (KEY >= 'a' && KEY <= 'z');
	            boolean isKeyNumber = (KEY >= '0' && KEY <= '9');
	      
	            if (isKeyCapitalLetter || isKeySmallLetter || isKeyNumber) {
	               addText(KEY);
	            }
	         }
	      
	      return false;
	   }
	   
	   private void addText(char text) {
	      // IF THE TEXT WIDHT IS IN BOUNDARIES OF THE TEXTBOX
	      if (app.textWidth(Text + text) < W) {
	         Text += text;
	         TextLength++;
	      }
	   }
	   
	   private void backspace() {
	      if (TextLength - 1 >= 0) {
	         Text = Text.substring(0, TextLength - 1);
	         TextLength--;
	      }
	   }
	   
	   public String getText() {
		   return this.Text;
	   }
	   
	   public boolean isEmpty() {
		   return this.Text.equals("");
	   }
}
