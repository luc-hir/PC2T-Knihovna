package balicek;

public class Roman extends Kniha{
	
	private int cisloZaner;
	private String zaner;
	
    private static final Map<Integer, String> zanryMapa = new HashMap<>();
    
    static {
        zanryMapa.put(1, "Romanticky");
        zanryMapa.put(2, "Historicky");
        zanryMapa.put(3, "Sci-fi");
        zanryMapa.put(4, "Detektivni");
        zanryMapa.put(5, "Fantasy");
    }

	public Roman(String nazov, String autor, int rok_vydania, boolean dostupnost, int cisloZaner) {
		super(nazov, autor, rok_vydania, dostupnost);
		this.zaner = zanryMapa.get(cisloZaner);}
	
    public String getZaner() {
        return this.zaner;
    }
    
    public void setZaner(int cisloZaner) {
        this.zaner = zanryMapa.get(cisloZaner);
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
