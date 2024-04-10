package balicek;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;

public class Test {
	
	int pocet_knih=100;
	int posledna_kniha=0;
	Kniha policka[] = new Kniha[pocet_knih];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc=new Scanner(System.in);
		int volba;
		boolean run=true;
		while(run){
			System.out.println("Vyberte cinnost:");
			System.out.println("1 ... pridanie novej knihy");
			System.out.println("2 ... uprava knihy");
			System.out.println("3 ... zmazanie knihy");
			System.out.println("4 ... dostupna/pozicana");
			System.out.println("5 ... vypis knih");
			System.out.println("6 ... vyhladanie knihy");
			System.out.println("7 ... vypis knih od autora");
			System.out.println("8 ... vypis podla zanru");
			System.out.println("9 ... vypis pozicanych knih");
			System.out.println("10 .. ulozenie knihy do suboru");
			System.out.println("11 .. nacitanie knihy zo suboru");
			System.out.println("12 .. ukonceni aplikace");
			
			volba = sc.nextInt();
			switch(volba)
			{
				case 1:
					System.out.println("Roman (True) alebo Ucebnica (False)");
					if (sc.nextBoolean()) {
						System.out.println("Zadaj nazov knihy");
						String nazovKnihy = sc.next();
						System.out.println("Zadaj autora knihy");
						String autorKnihy = sc.next();
						System.out.println("Zadaj rok vydania");
						int rok_vydaniaKnihy = sc.nextInt();
						System.out.println("Zadaj rok vydania");
						boolean dostupnost = sc.nextBoolean();
						System.out.println("Zadaj zaner: 1-Romanticky, 2-Historicky, 3-Sci-fi, 4-Detektivni, 5-Fantasy");
						Int cisloZaner = sc.next();
						
						policka[0] = new Roman(nazovKnihy, autorKnihy, rok_vydaniaKnihy, dostupnost, zaner);
						
					}
					else {
						System.out.println("Zadaj nazov knihy");
						String nazovKnihy = sc.next();
						System.out.println("Zadaj autora knihy");
						String autorKnihy = sc.next();
						System.out.println("Zadaj rok vydania");
						int rok_vydaniaKnihy = sc.nextInt();
						System.out.println("Zadaj rok vydania");
						boolean dostupnost = sc.nextBoolean();
						System.out.println("Zadaj rocnik");
						int rocnik = sc.nextInt();
						
						policka[posledna_kniha++] = new Ucebnice(nazovKnihy, autorKnihy, rok_vydaniaKnihy, dostupnost, rocnik);							
						
					}
					break;
				case 2:
					System.out.println("Zadaj nazov knihy, ktoru chces upravit");
					
					System.out.println("");
					
					System.out.println("");
					
					break;
				case 3:
					
					
					break;
				case 4:
					break;
				case 5:
					break;
				case 6:
					
					break;
				case 7:
					
					break;
				case 8:
					run = false;
					break;
				case 9:
					run = false;
					break;
				case 10:
					run = false;
					break;
				case 11:
					run = false;
					break;
				case 12:
					run = false;
					break;
			}
			
		}
	}


	}


