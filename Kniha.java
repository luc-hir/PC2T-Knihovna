package balicek;

public abstract class Kniha {
	String nazov;
	String autor;
	private int rok_vydania;
	private boolean dostupnost = true;
	
	public Kniha(String nazov, String autor, int rok_vydania, boolean dostupnost) {
		this.nazov = nazov;
		this.autor = autor;
		this.rok_vydania = rok_vydania;
		this.dostupnost = dostupnost;
	}
	
	public String getNazov() {
		return this.nazov;
	}
	
	public String getAutor() {
		return this.autor;
	}
	
	public int getRok_vydania(){
		return this.rok_vydania;
	}
	
	public boolean getDostupnost() {
		return this.dostupnost;
	}
	
	public void setNazov(String nazov) {
		this.nazov = nazov;
	}
	
	public void setAutor(String autor) {
		this.autor = autor;
	}
	
	public void setRok_vydania(int rok_vydania) {
		this.rok_vydania = rok_vydania;
	}
	
	public void setDostupnost(boolean dostupnost) {
		this.dostupnost = dostupnost;
	}
	
public void zmenDostupnost() {
		if(this.dostupnost) {
			this.dostupnost = false;
		}
		else{
			this.dostupnost = true;
		}
	}

	public abstract void infoKniha();

}
