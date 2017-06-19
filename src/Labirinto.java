import com.senac.SimpleJava.Console;
import com.senac.SimpleJava.Graphics.Image;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Labirinto {
	private Sala sala[] = new Sala[32];
	private Guerreiro player = new Guerreiro();
	
	public String retornEstoque(int e){
		return player.retornaEstoque(e);
	}

	public void lerTxt(String nomeArquivo) throws IOException{
		
		 try { File arquivo = new File(nomeArquivo);
		 Scanner sc = new Scanner(arquivo);
		 int numero_sala = 0;
		
		 while(sc.hasNext()){
			sala[0] = new Sala(); //cria a sala 0 que seria o exterior do labirinto
			String a = sc.next();
					
				if( a.startsWith("r")){
					numero_sala = Integer.parseInt(sc.next());  //recebe numero da sala
					sala[numero_sala] = new Sala();
					}				
				
				if( a.startsWith("s")){
					int numero_porta_s = Integer.parseInt(sc.next());  //recebe numero para porta, sabendo de qual sala pertence
					sala[numero_sala].setDestino(0, numero_porta_s);   // 0 é o numero da porta sul
					sala[numero_sala].setImg(0,"image/porta0");    // imagem da porta
				}
					
				if( a.startsWith("n")){
					int numero_porta_n = Integer.parseInt(sc.next());  //recebe numero para porta, sabendo de qual sala pertence
					sala[numero_sala].setDestino(1, numero_porta_n);  // 1 é o numero da porta norte
					sala[numero_sala].setImg(1,"image/porta1");    // imagem da porta
				}
					
				if( a.startsWith("e")){
					int numero_porta_e = Integer.parseInt(sc.next());  //recebe numero para porta, sabendo de qual sala pertence
					sala[numero_sala].setDestino(2, numero_porta_e);  // 2 é o numero da porta leste
					sala[numero_sala].setImg(2,"image/porta2");    // imagem da porta
				}
					
				if( a.startsWith("w")){
					int numero_porta_w = Integer.parseInt(sc.next());  //recebe numero para porta, sabendo de qual sala pertence
					sala[numero_sala].setDestino(3, numero_porta_w);  // 3 é o numero da porta oeste
					sala[numero_sala].setImg(3,"image/porta3");    // imagem da porta
				}
					
				if( a.startsWith("d")){
					int numero_porta_desce = Integer.parseInt(sc.next());  //recebe numero para porta, sabendo de qual sala pertence
					sala[numero_sala].setDestino(4, numero_porta_desce);  // 4 é o numero da porta que desce
					sala[numero_sala].setImg(4,"image/porta4");    // imagem do local que desce
				}
					
				if( a.startsWith("u")){
					int numero_porta_sobe = Integer.parseInt(sc.next());  //recebe numero para porta, sabendo de qual sala pertence
					sala[numero_sala].setDestino(5, numero_porta_sobe);  // 5 é o numero da porta que sobe
					sala[numero_sala].setImg(5,"image/porta5");    // imagem da escada q sobe
				}
					
				} 				
		sc.close(); 
		} catch (FileNotFoundException e) {
		 e.printStackTrace(); 
		}
	} // final metodo ler texto

	public Image retornaImagemDaPorta(int s, int p){
		return sala[s].ImagemPorta(p);
	}

	public boolean visualizaSeAPortaExiste(int s, int p){
		if(sala[s].existePorta(p)== false)
			return false;  // n existe
		else
			return true;  // existe
	}

	public int mostraDestino(int sal, int porta){
			return sala[sal].destinoDaPorta(porta);
		
	}

	public boolean statusPorta(int s, int p){
		return sala[s].retornaStatus(p);
	}

	public void trancaEAbrePorta(int s, int p, boolean st){
		sala[s].alteraStatusPorta(p, st);
	}
	
	public void trancaPortas(int quantidadeDePortasTrancadas){
		Random random = new Random();
		for(int i = 0; i < quantidadeDePortasTrancadas; i++){
			trancaEAbrePorta((random.nextInt(31)+1), random.nextInt(6), true);
		}
	}

	public Image mostraInimigo(int s, int p){
		try {
			return sala[s].imgInimigo(p);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean verificaInimigo(int s,int p){       //if false = nao tem inimigo
		return sala[s].verificaSeExisteInimigo(p);
	}

	public int retornaEnergiaInimigo(int s, int p){
		return sala[s].retornaEnergiaInimigo(p);
	}

	public void criaInimigo(int s, int p){
		sala[s].criainimigo(p);
	}
	
	public void inicializaInimigo(int quantidadeDeinimigos){
		Random random = new Random();
		for(int i = 0; i < quantidadeDeinimigos; i++){
			criaInimigo((random.nextInt(31)+1), random.nextInt(6));
		}
	}

	public int danoInimigo(int s, int p){
		return sala[s].retornaDanoInimigoPorta(p);
	}
	
	public int racaInimigo(int s, int p){
		return sala[s].retornaRacainimigoPorta(p);
	}
	
	public void batalha(int s, int p){//ataque // Vou deixar os testes para que tu possa ver como funciona ;)
		Random random = new Random();
		int energiaInimigo = 0;
		int danoSofridoGuerreiro = 0;
		int orc = 75 - player.retornaEscudo();      //Verifica se tem escudo
		int goblin = 80 - player.retornaEscudo();   //Verifica se tem escudo
		int troll = 50 - player.retornaEscudo();    //Verifica se tem escudo
		
		Console.println("testenecudo"+orc+" "+goblin+" "+troll);
		
		energiaInimigo = retornaEnergiaInimigo(s, p) - player.danoGuerreiro();
		Console.println("resultado da batalha p1: "+energiaInimigo);
		
		if(energiaInimigo>0){// se o inimigonão morrer...
			if(racaInimigo(s,p) == 0){ //0 = orc / 1 = goblin / 2 = troll
				if(random.nextInt(100)< orc)
					danoSofridoGuerreiro = danoInimigo(s,p);
			}			
			if(racaInimigo(s,p) == 1){ //0 = orc / 1 = goblin / 2 = troll
				if(random.nextInt(100)< goblin)
					danoSofridoGuerreiro = danoInimigo(s,p);
			}
			if(racaInimigo(s,p) == 2){ //0 = orc / 1 = goblin / 2 = troll
				if(random.nextInt(100)< troll)
					danoSofridoGuerreiro = danoInimigo(s,p);
			}
			Console.println("resultado da batalha p2: "+danoSofridoGuerreiro);
		}
		
		danoSofridoGuerreiro = danoSofridoGuerreiro - player.retornaArmadura();
		
		Console.println("depois do ataque vem a armadura -> teste armadura: "+player.retornaArmadura()+" dano sofrido guerreiro"+danoSofridoGuerreiro);
		
		if(energiaInimigo<0)
			energiaInimigo = 0;
		if(danoSofridoGuerreiro<0)
			danoSofridoGuerreiro = 0;		
		
		player.setEnergia((player.getEnergia() - danoSofridoGuerreiro));
		sala[s].InimigoSofreDanoPorta(p,energiaInimigo);		
	}//ataque	
	
	public int vidaGuerreiro(){
		return player.getEnergia();
	}

	public boolean verificaChaveExiste(int s){
		return sala[s].verificaChaveExiste();
	}
	
	public boolean verificaItemExiste(int s, int i){
		return sala[s].verificaItemViisivel(i);//0 = arma / 1 = chave / 2 = armadura / 3 = escudo
	}

	public Image imgChave(int s){
		try {
			return sala[s].imgChave();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public void criaChaveSala(int s){
		sala[s].criaChave();
	}
	
	public void inicializaChave(int QuantidadeDeChaves){
		Random random = new Random();
		for(int i = 0; i < QuantidadeDeChaves; i++)
			criaChaveSala((random.nextInt(31)+1));
}

	public void criaArmadura(int s){
		sala[s].criaArmadura();
	}

	public void inicializaArmadura(int QuantidadeDeChaves){
		Random random = new Random();
		for(int i = 0; i < QuantidadeDeChaves; i++)
			criaArmadura((random.nextInt(31)+1));
}	
	
	public void criaArma(int s){
		sala[s].criaArma();
	}
	
	public void inicializaArma(int QuantidadeDeChaves){
		Random random = new Random();
		for(int i = 0; i < QuantidadeDeChaves; i++)
			criaArma((random.nextInt(31)+1));
		}
	
	public void criaEscudo(int s){
		sala[s].criaEscudo();
	}
	
	public void inicializaEscudo(int QuantidadeDeChaves){
		Random random = new Random();
		for(int i = 0; i < QuantidadeDeChaves; i++)
			criaEscudo((random.nextInt(31)+1));
		}
	
	public void desativaChave(int s){
		sala[s].desabilitaChave();
	}

	public void atribuiChaveParaGuerreiro(int s){
		player.setEstoque0(sala[s].passaChave());
	}

	public void tentaAbrirPorta(int s, int p){
		if(player.mostraCorChave() == sala[s].retornaCorPorta(p))
			trancaEAbrePorta(s, p, false);
	}

	public Image imgArmadura(int s){
		try {
			return sala[s].imgArmadura();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public Image imgEscudo(int s){
		try {
			return sala[s].imgEscudo();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public Image imgArma(int s){
		try {
			return sala[s].imgArma();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public void atribuiItemGuerreiro(int s, int i){
		player.setEstoque1(sala[s].retornaItem(i));
	}

	public void desativaItem(int s, int i){
		sala[s].desabilitaItem(i);
	}

	public void setArmadilha(int s, int p, boolean st){
		sala[s].setAramadilha(p, st);
	}
	
	public boolean getArmadilha(int s, int p){
		return sala[s].statusArmadilha(p);
	}
	
	public void inicializaArmadilhas(int QuantidadeDeArmadilhas){
		Random random = new Random();
		for(int i = 0; i < QuantidadeDeArmadilhas; i++){
			setArmadilha((random.nextInt(31)+1), random.nextInt(6), true);
		}
	}

	public void setEnergiaPlayer(int e){
		player.setEnergia(e);
	}
}// final classe




//Renan Fontoura Boldrini Ramos
