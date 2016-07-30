package pl.javadevmatt.tutorialclicker.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class Player extends Image{

	private final static int WIDHT = 77;
	private final static int HEIGHT = 152;
	
	private final static int STARTING_X = 200;
	private final static int STARTING_Y = 300;
	
	public Player(){
		super(new Texture("badlogic.jpg"));
		
		this.setOrigin(WIDHT /2, HEIGHT/2 );
		this.setSize(WIDHT, HEIGHT);
		
		// starting position
		this.setPosition(STARTING_X, STARTING_Y);
	}

	public void touchEvent() {

		float przesun = MathUtils.random(-200,200);
		float zwieksz = MathUtils.random(-25,100);
		Action moveAct = Actions.sequence(
			Actions.moveBy(przesun,10,0.2f, Interpolation.bounce),
			Actions.moveBy(-przesun,-10,0.2f,Interpolation.circleIn)
		);
		Action growAct = Actions.sequence(
				Actions.sizeBy(zwieksz,15,0.2f,Interpolation.circle),
				Actions.sizeBy(-zwieksz,-15,0.2f,Interpolation.circle)
		);


this.addAction(moveAct);
		this.addAction(growAct);
		if(this.getHeight()>165){
			this.addAction(Actions.rotateBy(MathUtils.randomSign()*360,0.2f,Interpolation.circle));

		}
	}
}