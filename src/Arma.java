import java.io.IOException;
import java.util.Random;
import com.senac.SimpleJava.Graphics.Image;

public class Arma extends Item{
	Random random = new Random();
	private int tipo = random.nextInt(4); //0=Adaga / 1=Faca /2=Espada / 3=Espada Longa
	
	public Arma(){//construtor
		super(0);
	}
		
	public int getTipo(){
		return this.tipo;
	}

	public int danoArma(){ // o resultado de dano, ja vai com a soma do dano do guerreiro
		
			if(tipo == 0) // Adaga
				return 3; 		
			
			if(tipo == 1) // Faca
				return 4;
			
			if(tipo == 2) // Espada
				return 5;
			
			else
				return 7; // Espada Longa

	}
	
	public Image imgArma() throws IOException{ // o resultado de dano, ja vai com a soma do dano do guerreiro
		Image img;
		if(tipo == 0) // Adaga
			return img = new Image("image/adaga.png"); 		
		
		if(tipo == 1) // Faca
			return img = new Image("image/faca.png"); 
		
		if(tipo == 2) // Espada
			return img = new Image("image/espada.png");
		
		else// Espada Longa
			return img = new Image("image/espadaL.png"); 
}
	
}//Final Class
