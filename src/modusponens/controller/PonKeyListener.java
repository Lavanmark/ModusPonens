package modusponens.controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import org.jbox2d.common.Vec2;

import modusponens.model.Model;

public class PonKeyListener implements KeyListener{

	private Model mainModel;
	
	public PonKeyListener(Model m){
		mainModel = m;
	}
	private void gameKeyPressed(int key){
		switch(key){
		case KeyEvent.VK_W:
			//UP
			break;
		case KeyEvent.VK_S:
			//DOWN
			break;
		case KeyEvent.VK_A:
			//LEFT
			mainModel.wilbert.moveLeft();

			break;
		case KeyEvent.VK_D:
			//RIGHT
			mainModel.wilbert.getBody().applyLinearImpulse(new Vec2(0.01f, 0.0f),mainModel.wilbert.getBody().getPosition());
			break;
		case KeyEvent.VK_SPACE:
			//JUMP
			
			break;
		case KeyEvent.VK_H:
			//ACTION 1 (punch or hit with object in hand)
			break;
		case KeyEvent.VK_J:
			//ACTION 2
			break;
		case KeyEvent.VK_K:
			//ACTION 3 (kick)
			break;
		case KeyEvent.VK_L:
			//ACTION 4
			break;
			
		}
	}
	
	private void gameKeyReleased(int key){
		switch(key){
		case KeyEvent.VK_W:
			//UP
			break;
		case KeyEvent.VK_S:
			//DOWN
			break;
		case KeyEvent.VK_A:
			//LEFT
			mainModel.wilbert.stopMoveLeft();
			break;
		case KeyEvent.VK_D:
			//RIGHT
			break;
		case KeyEvent.VK_SPACE:
			//JUMP
			mainModel.wilbert.getBody().applyLinearImpulse(new Vec2(0.0f,-0.05f), mainModel.wilbert.getBody().getPosition());
			
			System.out.println("jump");
			break;
		case KeyEvent.VK_H:
			//ACTION 1
			break;
		case KeyEvent.VK_J:
			//ACTION 2
			break;
		case KeyEvent.VK_K:
			//ACTION 3
			break;
		case KeyEvent.VK_L:
			//ACTION 4
			break;
		}
	}
	
	@Override
	public void keyPressed(KeyEvent ke) {
		gameKeyPressed(ke.getKeyCode());
	}

	@Override
	public void keyReleased(KeyEvent ke) {
		gameKeyReleased(ke.getKeyCode());
	}

	@Override
	public void keyTyped(KeyEvent ke) {
		
	}

}
