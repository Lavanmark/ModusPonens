package modusponens.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

import modusponens.controller.PonKeyListener;
import modusponens.controller.PonMouseListener;
import modusponens.model.Model;

public class ViewFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private GameCanvas canvas;
	private PonKeyListener contrlPKL;
	private PonMouseListener contrlPML;
	private Model mainModel;
	
	static final int CANVAS_WIDTH = 1000;   //800 was original // width and height of the game screen
	static final int CANVAS_HEIGHT = 600;//600
	
	
	public ViewFrame(){
		canvas = new GameCanvas();
		canvas.setPreferredSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT));
		this.setContentPane(canvas);
	      // Other UI components such as button, score board, if any.
	      // ......
	      //this.setIconImage(gameIcon);
	      this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	      this.pack();
	      //do most things after packing it
	      this.setLocationRelativeTo(null);
	      this.setTitle("Modus PONENS");
	      this.setVisible(true);
	      this.setResizable(false);
	}
	public void update(){
		repaint();
	}
	
	private void gameDraw(Graphics2D g2d){
	      /*switch (state) {
	         case INITIALIZED:
	            // ......
	            break;
	         case MENU:
	        	 //draw the menu
	        	 menu.drawMain(g2d);
	        	break;
	         case LOAD:
	        	 //draw the load thing while its loading 
	        	 menu.drawLoad(g2d);
	        	 break;
	         case PLAYING:
	             //draw the main map
	        	 lvl.draw(g2d);
	        	 //draw the player over map
	        	 player.draw(g2d);
	        	 //draw trees over player and map
	        	 lvl.drawTrees(g2d);
	        	 //draw HUD over everything
	        	 player.HUD.draw(g2d);
	        	 
	            break;
	         case INVENTORY:
	        	 lvl.draw(g2d);
	        	 player.draw(g2d);
	        	 lvl.drawTrees(g2d);
	        	 player.HUD.draw(g2d);
	        	 break;public void linkPKLtoJP(PonKeyListener p){
			
		}
	         case PAUSED:
	         	 lvl.draw(g2d);
	        	 player.draw(g2d);
	        	 lvl.drawTrees(g2d);
	        	 player.HUD.draw(g2d);
	            break;
	         case GAMEOVER:
	            menu.drawMain(g2d);
	            break;
		default:
			break;
	         
	      } */
		//g2d.setBackground(Color.BLACK);
		g2d.setColor(Color.WHITE);
		//g2d.drawRect(100, 100, 30, 30);
		
		
		g2d.drawRect((int)mainModel.bod.getPosition().x, (int)mainModel.bod.getPosition().y, (int)mainModel.cShape.getRadius(), (int)mainModel.cShape.getRadius());
		g2d.drawRect((int)mainModel.floor.getBody().getPosition().x-mainModel.floor.getLength()/2, 
				(int)mainModel.floor.getBody().getPosition().y-mainModel.floor.getHeight()/2, 
				mainModel.floor.getLength(), mainModel.floor.getHeight());
		
		
	}
	
	public void linkPKLtoJF(PonKeyListener p){
		contrlPKL = p;
		canvas.setPKLtoJP();
	}
	public void linkPMLtoJF(PonMouseListener p){
		contrlPML = p;
		canvas.setPMLtoJP();
	}
	public void linkModel(Model m){
		mainModel = m;
	}
	class GameCanvas extends JPanel {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		
		public GameCanvas(){
			setFocusable(true);  // so that can receive key-events
	        requestFocus();
	        setResizable(false);
		}
		
		private void setPKLtoJP(){
			addKeyListener(contrlPKL);
		}
		private void setPMLtoJP(){
			addMouseListener(contrlPML);
			addMouseMotionListener(contrlPML);
		}
		
		public void paintComponent(Graphics g) {
	        Graphics2D g2d = (Graphics2D)g;
	        super.paintComponent(g2d);   // paint background
	        setBackground(Color.BLACK);  // may use an image for background
	  
	        // Draw the game objects
	        gameDraw(g2d);
	     }
		
	}
}
