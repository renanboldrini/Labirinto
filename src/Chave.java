import java.io.IOException;
import java.util.Random;

import com.senac.SimpleJava.Graphics.Image;

public class Chave  extends Item{
	Random random = new Random();
	private int cor = random.nextInt(4);//0 = Vermelho / 1 = azul / 2 = amarelo /3 = verde
	private boolean status = true ; //true aparece/ falce = não aparece
	
	public Chave(){//construtor
		super(1);
	}
	
	public Image desenhaChave() throws IOException{
		Image chave;
		if(cor == 0)
			return chave = new Image("image/chavever.png");
		if(cor == 1)
			return chave = new Image("image/chaveaz.png");
		if(cor == 2)
			return chave = new Image("image/chaveam.png");
		if(cor == 3)
			return chave = new Image("image/chavev.png");
		     
		else return chave = new Image("image/erro.png");
	}

	public boolean getStatus(){
		return status;
	}
	
	public void setStatus(boolean t){
		this.status = t;
	}

	public int getCor(){
		return this.cor;
	}
}//final clas

//Renan Fontoura Boldrini Ramos
