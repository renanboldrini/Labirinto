import java.io.IOException;
import java.util.Random;

import com.senac.SimpleJava.Console;
import com.senac.SimpleJava.Graphics.Canvas;
import com.senac.SimpleJava.Graphics.Color;
import com.senac.SimpleJava.Graphics.Drawable;
import com.senac.SimpleJava.Graphics.GraphicApplication;
import com.senac.SimpleJava.Graphics.Image;
import com.senac.SimpleJava.Graphics.Point;
import com.senac.SimpleJava.Graphics.Rect;
import com.senac.SimpleJava.Graphics.Resolution;
import com.senac.SimpleJava.Graphics.events.MouseEvent;
import com.senac.SimpleJava.Graphics.events.MouseObserver;

public class jogo extends GraphicApplication implements MouseObserver{
	Random random = new Random();
	private int jogo = 1;
	private Labirinto mundo = new Labirinto();
	int salaEmQueEstamos = (random.nextInt(31)+1);	
	private Image um;
	private static final String ums = "image/apresentacao.png";
	private Image bg;
	private static final String BG="image/sala.png"; 
	
	@Override
	protected void draw(Canvas canvas) {
		canvas.clear();
		
		if(jogo == 1)
			canvas.drawImage(um, 0, 0);
		if(jogo == 2){
			canvas.putText(80, 75, 10, String.format("Escolha o nível de dificuldade do jogo:"));
			canvas.putText(80, 90, 10, String.format("Easy: Click com o botão direito do mouse"));
			canvas.putText(80, 105, 10, String.format("Medium: Click com o scroll do mouse\n"));
			canvas.putText(80, 120, 10, String.format("Harde: Click com o botão esquerdo do mouse"));
			}
			
		if(salaEmQueEstamos > 0 && salaEmQueEstamos < 33 && jogo==0){
			canvas.drawImage(bg, 0, 0);
			canvas.putText(20, 3, 9, String.format("Energia: "+mundo.vidaGuerreiro())); // vida
			canvas.putText(30, 15, 10, String.format("Sala: "+salaEmQueEstamos)); // sala
			canvas.putText(280, 270, 9, String.format("Estoque 1: "+mundo.retornEstoque(0))); // Estoque 0
			canvas.putText(285, 280, 10, String.format("Estoque 2: "+mundo.retornEstoque(1))); // Estoque 1	
			
			
			if(mundo.verificaItemExiste(salaEmQueEstamos, 3) == true)//3 = escudo
				canvas.drawImage(mundo.imgEscudo(salaEmQueEstamos), 210,100);			
			
			if(mundo.verificaItemExiste(salaEmQueEstamos, 0) == true)//0 = arma / 3 = escudo
				canvas.drawImage(mundo.imgArma(salaEmQueEstamos), 160,170);
			
			if(mundo.verificaChaveExiste(salaEmQueEstamos)==true)//chave
				canvas.drawImage(mundo.imgChave(salaEmQueEstamos), 70,60);
			
			if(mundo.verificaItemExiste(salaEmQueEstamos, 2) == true)// 2 = armadura 
				canvas.drawImage(mundo.imgArmadura(salaEmQueEstamos), 300,100);
			
			
			if(mundo.visualizaSeAPortaExiste(salaEmQueEstamos, 0)==true){
				canvas.drawImage(mundo.retornaImagemDaPorta(salaEmQueEstamos, 0), 145, 268);
				if(condiçãoInimigo(0) == true)
					canvas.drawImage(mundo.mostraInimigo(salaEmQueEstamos, 0), 170, 265);
				if(mundo.getArmadilha(salaEmQueEstamos, 0)== true)
					canvas.putText(180, 230, 30, "£");
			}
			if(mundo.visualizaSeAPortaExiste(salaEmQueEstamos, 1)==true){
				canvas.drawImage(mundo.retornaImagemDaPorta(salaEmQueEstamos, 1), 145, 4);
				if(condiçãoInimigo(1) == true)
					canvas.drawImage(mundo.mostraInimigo(salaEmQueEstamos, 1), 180, 8);
				if(mundo.getArmadilha(salaEmQueEstamos, 1)== true)
					canvas.putText(180, 30, 30, "£");
			}
			if(mundo.visualizaSeAPortaExiste(salaEmQueEstamos, 2)==true){
				canvas.drawImage(mundo.retornaImagemDaPorta(salaEmQueEstamos, 2), 368, 110);
				if(condiçãoInimigo(2) == true)
					canvas.drawImage(mundo.mostraInimigo(salaEmQueEstamos, 2), 363, 140);
				if(mundo.getArmadilha(salaEmQueEstamos, 2)== true)
					canvas.putText(345, 135, 30, "£");
			}
			if(mundo.visualizaSeAPortaExiste(salaEmQueEstamos, 3)==true){
				canvas.drawImage(mundo.retornaImagemDaPorta(salaEmQueEstamos, 3), 4, 110);
				if(condiçãoInimigo(3) == true)
					canvas.drawImage(mundo.mostraInimigo(salaEmQueEstamos, 3), 8, 140);
				if(mundo.getArmadilha(salaEmQueEstamos, 3)== true)
					canvas.putText(40, 135, 30, "£");
			}
			if(mundo.visualizaSeAPortaExiste(salaEmQueEstamos, 4)==true){
				canvas.drawImage(mundo.retornaImagemDaPorta(salaEmQueEstamos, 4), 45, 190);
				if(condiçãoInimigo(4) == true)
					canvas.drawImage(mundo.mostraInimigo(salaEmQueEstamos, 4), 65, 220);
				if(mundo.getArmadilha(salaEmQueEstamos, 4)== true)
					canvas.putText(70, 220, 30, "£");
			}
			if(mundo.visualizaSeAPortaExiste(salaEmQueEstamos, 5)==true){
				canvas.drawImage(mundo.retornaImagemDaPorta(salaEmQueEstamos, 5), 280, 3);
				if(condiçãoInimigo(5) == true)
					canvas.drawImage(mundo.mostraInimigo(salaEmQueEstamos, 5), 300, 4);
				if(mundo.getArmadilha(salaEmQueEstamos, 5)== true)
					canvas.putText(310, 30, 30, "£");
			}			
		}// final if
		if(salaEmQueEstamos == 0 && jogo == 0)
			canvas.putText(100, 110, 40, String.format("You Win !"));
		
		if(mundo.vidaGuerreiro() < 1){
			jogo = 1;
			salaEmQueEstamos = 0;
			canvas.putText(55, 110, 60, String.format("You Lose !"));			
		}					
	}//final draw

	@Override
	protected void loop() {
		
	}
	
	@Override
	protected void setup() {
		// Application
		try {
			mundo.lerTxt("image/labirinto.txt");//cria o mundo atreves do TXT.
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		addMouseObserver(MouseEvent.CLICK, this);
		addMouseObserver(MouseEvent.DOUBLECLICK, this);
		Resolution res = Resolution.MIDRES;
		setFramesPerSecond(60);
		setResolution(res);
		setTitle("Jogo Labirinto");
		
		try {
			um = new Image(ums);
			um.resize(res.width, res.height);

			bg = new Image(BG);
			bg.resize(res.width, res.height); 
			
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}// final Setup
	
	public void inicializaNívelDeDificuladade(int p,int i,int c,int ad,int ar,int es, int am){
		mundo.trancaPortas(p);//Tenta trancar uma quantidade de vezes algumas portas
		mundo.inicializaInimigo(i);//Tenta inicializar inimigos
		mundo.inicializaChave(c);//Tenta inicializar chaves
		mundo.inicializaArmadura(ad);//Tenta inicializar armaduras
		mundo.inicializaArma(ar);//Teta inicializar Armas
		mundo.inicializaEscudo(es);//Tenta inicializar Escudos
		mundo.inicializaArmadilhas(am);//Tenta inicializar Armadilhas
		
	}
	
	@Override
	public void notify(MouseEvent event, int button, Point point) {
		if (event == MouseEvent.DOUBLECLICK && jogo == 1 && button == 1)
				jogo = 2;
		
		if(event == MouseEvent.CLICK && jogo == 2 && button ==3){
			jogo = 0;
			inicializaNívelDeDificuladade(4, 4,200, 200, 200, 200, 10);
		}
		if(event == MouseEvent.CLICK && jogo == 2 && button ==2){
			jogo = 0;
			inicializaNívelDeDificuladade(20, 20,30, 20, 30, 20, 40);
		}
		if(event == MouseEvent.CLICK && jogo == 2 && button ==1){
			jogo = 0;
			inicializaNívelDeDificuladade(30, 40,40, 20, 20, 20, 60);
		}
			
		if (event == MouseEvent.CLICK && salaEmQueEstamos == 0)
			endLoop();
		if (event == MouseEvent.CLICK && button == 1 ) {			
			
			if(retornaClickPortaBt1(point.x,point.y, 0)== true)	{
				if(mundo.getArmadilha(salaEmQueEstamos, 0) == true)
					mundo.setEnergiaPlayer(0);
				if(mundo.statusPorta(salaEmQueEstamos, 0)== false)//true == trancada
					salaEmQueEstamos = mundo.mostraDestino(salaEmQueEstamos, 0);//sul
			}
			
			if(retornaClickPortaBt1(point.x,point.y, 1)== true){
				if(mundo.getArmadilha(salaEmQueEstamos, 1) == true)
					mundo.setEnergiaPlayer(0);
				if(mundo.statusPorta(salaEmQueEstamos, 1)== false)//true == trancada
					salaEmQueEstamos = mundo.mostraDestino(salaEmQueEstamos, 1);//norte	
			}
			
			if(retornaClickPortaBt1(point.x,point.y, 2)== true){	
				if(mundo.getArmadilha(salaEmQueEstamos, 2) == true)
					mundo.setEnergiaPlayer(0);
				if(mundo.statusPorta(salaEmQueEstamos, 2)== false)//true == trancada
					salaEmQueEstamos = mundo.mostraDestino(salaEmQueEstamos, 2);//leste
			}
			
			if(retornaClickPortaBt1(point.x,point.y, 3)== true){
				if(mundo.getArmadilha(salaEmQueEstamos, 3) == true)
					mundo.setEnergiaPlayer(0);
				if(mundo.statusPorta(salaEmQueEstamos, 3)== false)//true == trancada
					salaEmQueEstamos = mundo.mostraDestino(salaEmQueEstamos, 3);//oeste
			}
			
			if(retornaClickPortaBt1(point.x,point.y, 4)== true){
				if(mundo.getArmadilha(salaEmQueEstamos, 4) == true)
					mundo.setEnergiaPlayer(0);
				if(mundo.statusPorta(salaEmQueEstamos, 4)== false)//true == trancada
					salaEmQueEstamos = mundo.mostraDestino(salaEmQueEstamos, 4);//desce
			}
			
			if(retornaClickPortaBt1(point.x,point.y, 5)== true){	
				if(mundo.getArmadilha(salaEmQueEstamos, 5) == true)
					mundo.setEnergiaPlayer(0);
				if(mundo.statusPorta(salaEmQueEstamos, 5)== false)//true == trancada
					salaEmQueEstamos = mundo.mostraDestino(salaEmQueEstamos, 5);//sobe
			}
		}
		
		if (event == MouseEvent.CLICK && button == 3) {
			
			if(retornaClickInimigoBt3(point.x, point.y, 0)==true)
				mundo.batalha(salaEmQueEstamos, 0);
			if(retornaClickInimigoBt3(point.x, point.y, 1)==true)
				mundo.batalha(salaEmQueEstamos, 1);
			if(retornaClickInimigoBt3(point.x, point.y, 2)==true)
				mundo.batalha(salaEmQueEstamos, 2);
			if(retornaClickInimigoBt3(point.x, point.y, 3)==true)
				mundo.batalha(salaEmQueEstamos, 3);
			if(retornaClickInimigoBt3(point.x, point.y, 4)==true)
				mundo.batalha(salaEmQueEstamos, 4);
			if(retornaClickInimigoBt3(point.x, point.y, 5)==true)
				mundo.batalha(salaEmQueEstamos, 5);
		}
		
		
		if (event == MouseEvent.DOUBLECLICK && button == 1) { 
			//canvas.drawLine(300, 100, 330, 130);
			if(mundo.verificaItemExiste(salaEmQueEstamos, 2)==true && point.x > 300 && point.x < 330 && point.y > 100 && point.y < 130 ){
				mundo.atribuiItemGuerreiro(salaEmQueEstamos, 2); // armadura
				mundo.desativaItem(salaEmQueEstamos, 2);
			}			
			if(mundo.verificaItemExiste(salaEmQueEstamos, 3)==true && point.x > 210 && point.x < 235 && point.y > 100 && point.y < 125 ){
				mundo.atribuiItemGuerreiro(salaEmQueEstamos, 3);//escudo 210, 100, 235, 125
				mundo.desativaItem(salaEmQueEstamos, 3);
			}			
			if(mundo.verificaItemExiste(salaEmQueEstamos, 0)==true && point.x > 155 && point.x < 185 && point.y > 160 && point.y < 210 ){
				mundo.atribuiItemGuerreiro(salaEmQueEstamos, 0);//arma
				mundo.desativaItem(salaEmQueEstamos, 0);
			}						
			if(mundo.verificaChaveExiste(salaEmQueEstamos)==true && point.x > 65 && point.x < 100 && point.y > 60 && point.y < 75 ){
				mundo.atribuiChaveParaGuerreiro(salaEmQueEstamos);//chave
				mundo.desativaChave(salaEmQueEstamos);				
			}
			if(retornaDOUBLECLICKChaveBt1(point.x, point.y, 0))
				mundo.tentaAbrirPorta(salaEmQueEstamos, 0);
			
			if(retornaDOUBLECLICKChaveBt1(point.x, point.y, 1))
				mundo.tentaAbrirPorta(salaEmQueEstamos, 1);
			
			if(retornaDOUBLECLICKChaveBt1(point.x, point.y, 2))
				mundo.tentaAbrirPorta(salaEmQueEstamos, 2);
			
			if(retornaDOUBLECLICKChaveBt1(point.x, point.y, 3))
				mundo.tentaAbrirPorta(salaEmQueEstamos, 3);
			
			if(retornaDOUBLECLICKChaveBt1(point.x, point.y, 4))
				mundo.tentaAbrirPorta(salaEmQueEstamos, 4);
			
			if(retornaDOUBLECLICKChaveBt1(point.x, point.y, 5))
				mundo.tentaAbrirPorta(salaEmQueEstamos, 5);
		}
		
		if (event == MouseEvent.DOUBLECLICK && button == 3) {
			
			if(retornaDOUBLECLICKAramadilhaBt2(point.x,point.y,0) == true)
				mundo.setArmadilha(salaEmQueEstamos, 0, false);
			
			if(retornaDOUBLECLICKAramadilhaBt2(point.x,point.y,1) == true)
				mundo.setArmadilha(salaEmQueEstamos, 1, false);
			
			if(retornaDOUBLECLICKAramadilhaBt2(point.x,point.y,2) == true)
				mundo.setArmadilha(salaEmQueEstamos, 2, false);
			
			if(retornaDOUBLECLICKAramadilhaBt2(point.x,point.y,3) == true)
				mundo.setArmadilha(salaEmQueEstamos, 3, false);
			
			if(retornaDOUBLECLICKAramadilhaBt2(point.x,point.y,4) == true)
				mundo.setArmadilha(salaEmQueEstamos, 4, false);
			
			if(retornaDOUBLECLICKAramadilhaBt2(point.x,point.y,5) == true)
				mundo.setArmadilha(salaEmQueEstamos, 5, false);			
		}		
		redraw();
	}
	
	public boolean retornaClickPortaBt1(double x, double y, int p){//logica portas
		if(p==0 && mundo.visualizaSeAPortaExiste(salaEmQueEstamos, p) != false && x > 165 && x < 235 && y > 265 && y < 300 && (mundo.verificaInimigo(salaEmQueEstamos, p) == false || mundo.retornaEnergiaInimigo(salaEmQueEstamos, p) == 0))
			return true;
		if(p==1 && mundo.visualizaSeAPortaExiste(salaEmQueEstamos, p) != false && x > 150 && x < 215 && y > 0 && y < 35 && (mundo.verificaInimigo(salaEmQueEstamos, p) == false || mundo.retornaEnergiaInimigo(salaEmQueEstamos, p) == 0))
			return true;
		if(p==2 && mundo.visualizaSeAPortaExiste(salaEmQueEstamos, p) != false && x > 365 && x < 395 && y > 120 && y < 195 && (mundo.verificaInimigo(salaEmQueEstamos, p) == false || mundo.retornaEnergiaInimigo(salaEmQueEstamos, p) == 0))
			return true;
		if(p==3 && mundo.visualizaSeAPortaExiste(salaEmQueEstamos, p) != false && x > 3 && x < 30 && y > 110 && y < 195 && (mundo.verificaInimigo(salaEmQueEstamos, p) == false || mundo.retornaEnergiaInimigo(salaEmQueEstamos, p) == 0))
			return true;
		if(p==4 && mundo.visualizaSeAPortaExiste(salaEmQueEstamos, p) != false && x > 45 && x < 115 && y > 190 && y < 260 && (mundo.verificaInimigo(salaEmQueEstamos, p) == false || mundo.retornaEnergiaInimigo(salaEmQueEstamos, p) == 0))
			return true;
		if(p==5 && mundo.visualizaSeAPortaExiste(salaEmQueEstamos, p) != false && x > 275 && x < 340 && y > 0 && y < 35 && (mundo.verificaInimigo(salaEmQueEstamos, p) == false || mundo.retornaEnergiaInimigo(salaEmQueEstamos, p) == 0))
			return true;
		
			else return false;
	}//final metodo retornaClickPortaBt1
	
	public boolean retornaClickInimigoBt3(double x, double y, int p){//logica inimigo
		if(p==0 && mundo.visualizaSeAPortaExiste(salaEmQueEstamos, p) != false && x > 165 && x < 235 && y > 265 && y < 300 && mundo.verificaInimigo(salaEmQueEstamos, p) == true && mundo.retornaEnergiaInimigo(salaEmQueEstamos, p) > 0)
			return true;		
		if(p==1 && mundo.visualizaSeAPortaExiste(salaEmQueEstamos, p) != false && x > 150 && x < 215 && y > 0 && y < 35 && mundo.verificaInimigo(salaEmQueEstamos, p) == true && mundo.retornaEnergiaInimigo(salaEmQueEstamos, p) > 0)
			return true;		
		if(p==2 && mundo.visualizaSeAPortaExiste(salaEmQueEstamos, p) != false && x > 365 && x < 395 && y > 120 && y < 195 && mundo.verificaInimigo(salaEmQueEstamos, p) == true && mundo.retornaEnergiaInimigo(salaEmQueEstamos, p) > 0)
			return true;		
		if(p==3 && mundo.visualizaSeAPortaExiste(salaEmQueEstamos, p) != false && x > 3 && x < 30 && y > 110 && y < 195 && mundo.verificaInimigo(salaEmQueEstamos, p) == true && mundo.retornaEnergiaInimigo(salaEmQueEstamos, p) > 0)
			return true;		
		if(p==4 && mundo.visualizaSeAPortaExiste(salaEmQueEstamos, p) != false && x > 45 && x < 115 && y > 190 && y < 260 && mundo.verificaInimigo(salaEmQueEstamos, p) == true && mundo.retornaEnergiaInimigo(salaEmQueEstamos, p) > 0)
			return true;		
		if(p==5 && mundo.visualizaSeAPortaExiste(salaEmQueEstamos, p) != false && x > 275 && x < 340 && y > 0 && y < 35 && mundo.verificaInimigo(salaEmQueEstamos, p) == true && mundo.retornaEnergiaInimigo(salaEmQueEstamos, p) > 0)
			return true;		
		else
			return false;		
	}
	
	public boolean retornaDOUBLECLICKChaveBt1(double x, double y, int p){//logica Chave 2 clicks na porta para destravar se tiver a chave
		if(p==0 && mundo.visualizaSeAPortaExiste(salaEmQueEstamos, p) != false && mundo.statusPorta(salaEmQueEstamos, p)== true && x > 165 && x < 235 && y > 265 && y < 300)
			return true;
		if(p==1 && mundo.visualizaSeAPortaExiste(salaEmQueEstamos, p) != false && mundo.statusPorta(salaEmQueEstamos, p)== true && x > 150 && x < 215 && y > 0 && y < 35)
			return true;
		if(p==2 && mundo.visualizaSeAPortaExiste(salaEmQueEstamos, p) != false && mundo.statusPorta(salaEmQueEstamos, p)== true && x > 365 && x < 395 && y > 120 && y < 195)
			return true;
		if(p==3 && mundo.visualizaSeAPortaExiste(salaEmQueEstamos, p) != false && mundo.statusPorta(salaEmQueEstamos, p)== true && x > 3 && x < 30 && y > 110 && y < 195)
			return true;
		if(p==4 && mundo.visualizaSeAPortaExiste(salaEmQueEstamos, p) != false && mundo.statusPorta(salaEmQueEstamos, p)== true && x > 45 && x < 115 && y > 190 && y < 260)
			return true;
		if(p==5 && mundo.visualizaSeAPortaExiste(salaEmQueEstamos, p) != false && mundo.statusPorta(salaEmQueEstamos, p)== true && x > 275 && x < 340 && y > 0 && y < 35)
			return true;
		
			else return false;
	}
	
	public boolean retornaDOUBLECLICKAramadilhaBt2(double x, double y, int p){//logica Chave 2 clicks na porta para destravar se tiver a chave
		if(p==0 && mundo.visualizaSeAPortaExiste(salaEmQueEstamos, p) != false && mundo.getArmadilha(salaEmQueEstamos, p)== true && x > 165 && x < 235 && y > 265 && y < 300)
			return true;
		
		if(p==1 && mundo.visualizaSeAPortaExiste(salaEmQueEstamos, p) != false && mundo.getArmadilha(salaEmQueEstamos, p)== true && x > 150 && x < 215 && y > 0 && y < 35)
			return true;
		
		if(p==2 && mundo.visualizaSeAPortaExiste(salaEmQueEstamos, p) != false && mundo.getArmadilha(salaEmQueEstamos, p)== true && x > 365 && x < 395 && y > 120 && y < 195)
			return true;
		
		if(p==3 && mundo.visualizaSeAPortaExiste(salaEmQueEstamos, p) != false && mundo.getArmadilha(salaEmQueEstamos, p)== true && x > 3 && x < 30 && y > 110 && y < 195)
			return true;
		
		if(p==4 && mundo.visualizaSeAPortaExiste(salaEmQueEstamos, p) != false && mundo.getArmadilha(salaEmQueEstamos, p)== true && x > 45 && x < 115 && y > 190 && y < 260)
			return true;
		
		if(p==5 && mundo.visualizaSeAPortaExiste(salaEmQueEstamos, p) != false && mundo.getArmadilha(salaEmQueEstamos, p)== true && x > 275 && x < 340 && y > 0 && y < 35)
			return true;
		
		return false;		
	}
	
	public boolean condiçãoInimigo(int p){
		if(mundo.verificaInimigo(salaEmQueEstamos, p) != false && mundo.retornaEnergiaInimigo(salaEmQueEstamos, p) != 0)
			return true;
		else return false;

	}
}//final class



//Renan Fontoura Boldrini Ramos   Total das classes: 1297 linhas
