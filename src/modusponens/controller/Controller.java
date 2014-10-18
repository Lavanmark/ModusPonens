package modusponens.controller;

import modusponens.model.Model;
import modusponens.view.View;

public class Controller {

	private Model mainModel;
	private View mainView;
	private PonKeyListener ponKL;
	private PonMouseListener ponML;
	
	
	public Controller(Model model, View view){
		mainModel = model;
		mainView = view;
		
		ponKL = new PonKeyListener(mainModel);
		ponML = new PonMouseListener();
		mainView.linkPKL(ponKL);
		mainView.linkPML(ponML);
	}
	
	
	
	public void update(){
		
		
		
		
		
		mainModel.update();
		mainView.update();
	}
}
