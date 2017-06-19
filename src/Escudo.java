import java.io.IOException;

import com.senac.SimpleJava.Graphics.Image;

public class Escudo extends Item {
	private int defesa = 25;
	
	public Escudo() {//escudo
		super(3);
	}
 
	public int getDefesa(){
	 return defesa;
 }

	public Image imgEscudo() throws IOException{
	Image img;
	return img = new Image("image/escudo.png"); 
}
 
}

//Renan Fontoura Boldrini Ramos
