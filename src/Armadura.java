import java.io.IOException;
import java.util.Random;

import com.senac.SimpleJava.Graphics.Image;

public class Armadura extends Item{
	Random random = new Random();
	private int material = random.nextInt(3); //0=Armadura de Couro/ 1=Armadura de Metal /2=Armadura de Mithril
	private boolean status = true ;

	public Armadura() {
		super(2);
	}
	public int retornaProtecao(){
		if(material == 0)  //couro
			return 2;
			
		if(material == 1)	//metal
			return 3;
		
		else //mithril
			return 5;
	}

	public Image imgArmadura() throws IOException{
		Image img;
		if(material == 0)
			return img = new Image("image/ArmaduraC.png");
		if(material == 1)
			return img = new Image("image/ArmaduraMe.png");
		
		else return img = new Image("image/ArmaduraM.png");			
	}
	
}//final class

//Renan Fontoura Boldrini Ramos


