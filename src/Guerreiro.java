import java.util.Random;

import com.senac.SimpleJava.Graphics.Image;

public class Guerreiro {
	private int energia = 20;
	private Item estoque[] = new Item[2];
	
	public int danoGuerreiro(){
		int dano = 0;
		Random random = new Random();
		
		if(estoque[1] == null || estoque[1].getX() != 0){// armas / escudos / armaduras.. só podem ser armazenados no estoque1
			if(random.nextInt(100) < 75)
				dano = 2;		
		}
		if(estoque[1] != null && estoque[1].getX() == 0){ //tipos : 0=Adaga / 1=Faca /2=Espada / 3=Espada Longa
			
			if(((Arma)estoque[1]).getTipo() == 0){
				if(random.nextInt(100) < 75)
					dano = ((Arma)estoque[1]).danoArma();
			} 
			
			if(((Arma)estoque[1]).getTipo() == 1){
				if(random.nextInt(100) < 80)
					dano = ((Arma)estoque[1]).danoArma();
			} 
			
			if(((Arma)estoque[1]).getTipo() == 2){
				if(random.nextInt(100) < 85)
					dano = ((Arma)estoque[1]).danoArma();
			} 
			
			if(((Arma)estoque[1]).getTipo() == 3){
				if(random.nextInt(100) < 65)
					dano = ((Arma)estoque[1]).danoArma();
			} 				
		}
		return dano;
	}//finalDanoGuerreiro
	
	public void setEnergia(int e){
		this.energia = e;
	}
	
	public int getEnergia(){
		return this.energia;
	}

	public int retornaEscudo(){
		if(estoque[1] == null || estoque[1].getX() != 3)
			return 0;
		else
			return ((Escudo)estoque[1]).getDefesa();
	}

	public int retornaArmadura(){
		if(estoque[1] != null && estoque[1].getX() == 2)
			return ((Armadura)estoque[1]).retornaProtecao();
		else return 0;
	}

	public void setEstoque0(Item c){
		estoque[0] = c;
	}
	
	public void setEstoque1(Item c){
		estoque[1] = c;
	}
	

	public int mostraCorChave(){
		if(estoque[0] != null)
			return ((Chave)estoque[0]).getCor();
		else 
			return 999; // esse numero n abre porta...
	}

	public String retornaEstoque(int e){   //0 = arma / 1 = chave / 2 = armadura / 3 = escudo
		if(estoque[e] == null)
			return " ";
		if(estoque[e].getX()==0)
			return "Arma";
		if(estoque[e].getX()==1)
			return "Chave";
		if(estoque[e].getX()==2)
			return "Armadura";
		if(estoque[e].getX()==3)
			return "Escudo";
		else return "***";
		
	}
}

//Renan Fontoura Boldrini Ramos
