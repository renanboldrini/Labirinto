import java.io.IOException;
import java.util.Random;

import com.senac.SimpleJava.Console;
import com.senac.SimpleJava.Graphics.Image;

public class Inimigo {
	Random random = new Random();
	private int raca = random.nextInt(3);//0 = orc / 1 = goblin / 2 = troll
	private int energia = 6;//como não ficou especificado, no meu jogo todos os inimigos terão 5 de energia
	private int arma = random.nextInt(2); //0 = desarmado / 1 = armado
	
	
	public Image desenhaInimigo(int posicao) throws IOException{
		Image im;//troquei caso ocorra erro
		if(raca==0){
		    if(posicao==0)
		    	return im = new Image("image/orc0.png");
		       
		   if(posicao==1 || posicao==4 || posicao==5)
			   return im = new Image("image/orc1.png");   	
		    
		   if(posicao==2)
		    	return im = new Image("image/orc2.png");
		    
		   if(posicao==3)
		    	return im = new Image("image/orc3.png");		    
		    
		}		
		if(raca==1){
		    if(posicao==0)
		    	return im = new Image("image/goblin0.png");
		       
		    if(posicao==1 || posicao==4 || posicao==5)
		    	return im = new Image("image/goblin1.png");   	
		    
		    if(posicao==2)
		    	return im = new Image("image/goblin2.png");
		    
		    if(posicao==3)
		    	return im = new Image("image/goblin3.png");		    
		    
		}
		if(raca==2){
		    if(posicao==0)
		    	return im = new Image("image/troll0.png");
		       
		    if(posicao==1 || posicao==4 || posicao==5)
		    	return im = new Image("image/troll1.png");
		    
		    if(posicao==2)
		    	return im = new Image("image/troll2.png");
		    
		    if(posicao==3)
		    	return im = new Image("image/troll3.png");	
		}
		return im = new Image("image/erro.png");
		}//desenhaInimigo

	public int getEnergia(){
		return this.energia;
	}
	
	public int danoInimigo(){
		int golpe = 0;
		
		if(energia < 1)
			return 0;
		else{
			if(raca == 0){ // Orc
				golpe = 4;		
			}
			if(raca == 1){ // Goblin
				golpe = 2;
			}
			if(raca == 2){ // Troll
				golpe = 6;
			}
			if(arma == 1)
				golpe = golpe * 2;
		}
		
		return golpe;
	}

	public int getRaca(){
		return this.raca;
	}

	public void setEnergia(int e){
		this.energia = e;
	}
}//final class


//Renan Fontoura Boldrini Ramos