import java.io.IOException;

import com.senac.SimpleJava.Console;
import com.senac.SimpleJava.Graphics.Image;

public class Sala {
private Porta porta[] = new Porta[6];
private Item item[] = new Item[4];  //posição do array: 0 = arma / 1 = chave / 2 = armadura / 3 = escudo

	public int retornaCorPorta(int p ){
		return porta[p].getCor();
	}

	public Item passaChave(){
		return item[1];
	}
	
	public Image imgArmadura() throws IOException{    
	return ((Armadura)item[2]).imgArmadura();                
	}

	public Image imgChave() throws IOException{    //1 será sempre chave
	return ((Chave)item[1]).desenhaChave();                 //  type casting
	}

	public Image imgEscudo() throws IOException{
		return ((Escudo)item[3]).imgEscudo();
	}
	
	public Image imgArma() throws IOException{
		return ((Arma)item[0]).imgArma();
	}
	
	public void desabilitaChave(){
		((Chave)item[1]).setStatus(false);
	}
	
	public void desabilitaItem(int n){  //0 = arma / 1 = chave / 2 = armadura / 3 = escudo
		item[n].setStatus(false);
	}
	
	public boolean verificaItemViisivel(int i){ //0 = arma / 1 = chave / 2 = armadura / 3 = escudo
		if(item[i] != null && item[i].getStatus() == true)
			return true;
		else return false; 
	}
	
	public boolean verificaChaveExiste(){
		if(item[1] != null && ((Chave)item[1]).getStatus() == true)
			return true;
		else return false; 
	}

	public void criaArmadura(){
		this.item[2] = new Armadura();
	}
	
	public void criaArma(){
		this.item[0] = new Arma();
	}
	
	public void criaEscudo(){
		this.item[3] = new Escudo();
	}

	public void criaChave(){
		this.item[1] = new Chave();
	}
	
	public void setDestino(int np, int d){//quando seta o destino o método inicializa aporta
		porta[np] = new Porta();
		porta[np].setDestino(d);
	}
	
	public int destinoDaPorta(int p){
		 return porta[p].getDestino();
	}
	
	public void setImg(int np, String img) throws IOException{
		porta[np].setImg(img);
	}

	public Image ImagemPorta(int i){
		return porta[i].getImg();
	}
	
	public boolean existePorta(int p){
		if(porta[p] == null)
			return false;
		else
			return true;
	}
	
	public boolean retornaStatus(int p){
		return porta[p].getStatus();
	}

	public void alteraStatusPorta(int p, boolean st){
		if(porta[p]==null){            //quando uma porta não existir
			p=0;                       //ele zér o "p"  
			while(porta[p]==null)      // para entrar em um while, até achar uma pora válida
				p++;                   
		}                                  
		porta[p].alteraStatus(st);     //quando achar a porta válida, a mesma é travada
	}
	
	public Image imgInimigo(int p) throws IOException {
		return porta[p].imagemInimigo(p);
	}
	
	public boolean verificaSeExisteInimigo(int p){  //if false = não tem inimigo 
		if(porta[p].getInimigo() == null){
			return false;
		}
		else return true;
	}

	public int retornaEnergiaInimigo(int p){
		return porta[p].retornaEnergiaInimigo();
	}
	
	public void criainimigo(int p){
		if(porta[p]==null){            //quando uma porta não existir
			p=0;                       //ele zera o "p"  
			while(porta[p]==null)      // para entrar em um while, até achar uma pora válida
				p++;                   
		}                                  
		porta[p].criainimigo();;     //quando achar a porta válida, a mesma cria o inimigo
	}
	
	public int retornaRacainimigoPorta(int p){
		return porta[p].retornaRacaInimigo();
	}
	
	public int retornaDanoInimigoPorta(int p){
		return porta[p].retornaDanoinimigo();
	}

	public void InimigoSofreDanoPorta(int p, int e){
		porta[p].inimigoSofreDano(e);
	}

	public Item retornaItem(int i){
		return item[i];
	}
	
	public boolean statusArmadilha(int p){
		return porta[p].GetArmadilha();
	}
	
	public void setAramadilha(int p, boolean st){
		if(porta[p]==null){            //quando uma porta não existir
			p=0;                       //ele zera o "p"  
			while(porta[p]==null){      // para entrar em um while, até achar uma pora válida
				p++;
				}                   
		}                                  
		porta[p].setArmadilha(st);     //quando achar a porta válida, a mesma é travada
	}

	
}//final classe sala


//Renan Fontoura Boldrini Ramos