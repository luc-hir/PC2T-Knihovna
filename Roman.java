package balicek;

public class Roman extends Kniha{
	
	private int cisloZaner;
	private string zaner;

	public Roman(String nazov, String autor, int rok_vydania, boolean dostupnost, string zaner) {
		super(nazov, autor, rok_vydania, dostupnost);
		this.CisloZaner = zaner;
		// TODO Auto-generated constructor stub
	}
	
	public int getCisloZaner() {
		return this.CisloZaner;
	}
	
	public void setZaner(int CisloZaner) {
		this.CisloZaner = this.zaner;
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
		System.out.println("Zaner knihy: " + this.getZaner());
	}

}
