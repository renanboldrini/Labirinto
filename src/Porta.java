import java.io.IOException;
import java.util.Random;

import com.senac.SimpleJava.Graphics.Image;

public class Porta {
	Random random = new Random();
	private int cor = random.nextInt(4);//0 = Vermelho / 1 = azul / 2 = amarelo /3 = verde
	private boolean status = false; // true = trancada / false = aberta
	private int destino;
	private Inimigo inimigo;// = new Inimigo();//teste
	private Image img;
	private boolean armadilha = false;//false = desarmada / true = armada 
	

	public boolean GetArmadilha() {
		return armadilha;
	}

	public void setArmadilha(boolean armadilha) {
		this.armadilha = armadilha;
	}

	public Image getImg() {
		return img;
	}

	public void setImg(String local) throws IOException {
		if(cor == 0)
			this.img = new Image(local+"ve.png");//	vermelho		
		if(cor == 1)
			this.img = new Image(local+"az.png");//	azul		
		if(cor == 2)
			this.img = new Image(local+"am.png");//amarelo
		if(cor == 3)
			this.img = new Image(local+"ver.png");//verde
	}

	public int getDestino() {
		return destino;
	}

	public void setDestino(int destino) {
		this.destino = destino;
	}

	public boolean getStatus(){
		return this.status;
	}

	public void alteraStatus(boolean st){//serve tanto para trancar/ quanto para abrir a porta
		this.status = st;
		
	}

	public Image imagemInimigo(int posicao) throws IOException{
		return inimigo.desenhaInimigo(posicao);
	}

	public Inimigo getInimigo() {
		return inimigo;
	}

	public int retornaEnergiaInimigo(){
		return inimigo.getEnergia();
	}

	public void criainimigo(){
		inimigo = new Inimigo();
	}

	public int retornaRacaInimigo(){
		return inimigo.getRaca();
	}
	
	public int retornaDanoinimigo(){
		return inimigo.danoInimigo();
	}
	
	public void inimigoSofreDano(int e){
		inimigo.setEnergia(e);
	}
	
	public int getCor(){
		return this.cor;
	}
}//final classe

//Renan Fontoura Boldrini Ramos