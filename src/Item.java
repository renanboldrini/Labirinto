
public class Item {
	private int x;//0 = arma / 1 = chave / 2 = armadura / 3 = escudo
	private boolean status = true ;//true aparece/ falce = não aparece

	public Item(int x){
		this.x = x;
	}
	
	public int getX(){
		return this.x;
	}
	
	public boolean getStatus(){
		return this.status;
	}
	
	public void setStatus(boolean st){
		this.status = st;
	}
	
}

//Renan Fontoura Boldrini Ramos
