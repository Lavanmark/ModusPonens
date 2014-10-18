package modusponens.view;

import modusponens.controller.PonKeyListener;
import modusponens.controller.PonMouseListener;
import modusponens.model.Model;


public class View {

	private Model mainModel;
	private ViewFrame frame;
	
	private PonKeyListener contrlPKL;
	private PonMouseListener contrlPML;
	
	static enum State {
	      INITIALIZED, MENU, LOAD, STARTNEW, PLAYING, INVENTORY, PAUSED, GAMEOVER, DESTROYED
	   }
	static State state;   // current state of the game
	
	public View(Model model){
		mainModel = model;
		frame = new ViewFrame();
		frame.linkModel(mainModel);
		state = State.MENU;
	}
	
	public void linkPKL(PonKeyListener p){
		contrlPKL = p;
		frame.linkPKLtoJF(contrlPKL);
	}
	public void linkPML(PonMouseListener p){
		contrlPML = p;
		frame.linkPMLtoJF(contrlPML);
	}
	
	public void update(){
		frame.update();
	}
	
}
