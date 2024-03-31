package balicek;

public class Ucebnice extends Kniha {

	private int rocnik;
	
	public Ucebnice(String nazov, String autor, int rok_vydania, boolean dostupnost, int rocnik) {
		super(nazov, autor, rok_vydania, dostupnost);
		this.rocnik = rocnik;
		// TODO Auto-generated constructor stub
	}
	
	public int getRocnik() {
		return this.rocnik;
	}
	
	public void setRocnik(int rocnik) {
		this.rocnik = rocnik;
	}
	
	public void infoKniha() {
		System.out.println("Nazov knihy: " + this.getNazov());
		System.out.println("Autor knihy: " + this.getAutor());
		System.out.println("Rok vydania: " + this.getRok_vydania());
		if(getDostupnost()) {
			System.out.println("Kniha je dostupna.");
		}
		else {
			System.out.println("Kniha nie je dostupna.");
		}
			System.out.println("Odporucany rocnik: " + this.getRocnik());
	}

}
