package balicek;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Policka mojaPolicka= new Policka();
		mojaPolicka.setRoman("Makova Valka", "R. F. Kuang", 2018, false, 5);
		mojaPolicka.setRoman("Stoparuv pruvodce galaxii", "Douglas Adams", 1979, false, 3);
		mojaPolicka.setRoman("Teorie lasky", "Ali Hazelwood", 2024, false, 1);
		mojaPolicka.setUcebnica("Hrava matematika", "Magdalena Faltilova", 2019, false, 4);
		mojaPolicka.setUcebnica("Biologia pre 6. rocnik", "Maria Uherekova", 2020, false, 6);
		mojaPolicka.setUcebnica("Slabikar", "Jiri Zacek", 2017, false, 1);
		

		Scanner sc=new Scanner(System.in);
		int volba;
		boolean run=true;
		String nazov_knihy;
		while(run){
			System.out.println("*---*---*---*---*---*---*---*");
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
			System.out.println("*---*---*---*---*---*---*---*");
		
			volba = sc.nextInt();
			sc.nextLine();
			switch(volba)
			{
				case 1:
					boolean typKnihy = true;
					int typ;
					while(typKnihy) {
					System.out.println("Zadaj typ knihy:");
					System.out.println("1 ... Roman");
					System.out.println("2 ... Ucebnica");
					typ = sc.nextInt();
					sc.next();
					if (typ==1) {
						typKnihy=false;
						System.out.println("Zadaj nazov knihy");
						String nazovKnihy = sc.nextLine();
						System.out.println("Zadaj autora knihy");
						String autorKnihy = sc.nextLine();
						System.out.println("Zadaj rok vydania");
						int rok_vydaniaKnihy = sc.nextInt();
						System.out.println("Zadaj dostupnost (true/false)");
						boolean dostupnost = sc.nextBoolean();
						System.out.println("Zadaj zaner: 1-Romanticky, 2-Historicky, 3-Sci-fi, 4-Detektivni, 5-Fantasy");
						int CisloZaner = sc.nextInt();
						mojaPolicka.setRoman(nazovKnihy, autorKnihy, rok_vydaniaKnihy, dostupnost, CisloZaner);
						
					}
					if (typ==2) {
						typKnihy=false;
						System.out.println("Zadaj nazov knihy");
						String nazovKnihy = sc.nextLine();
						System.out.println("Zadaj autora knihy");
						String autorKnihy = sc.nextLine();
						System.out.println("Zadaj rok vydania");
						int rok_vydaniaKnihy = sc.nextInt();
						System.out.println("Zadaj dostupnost (true/false)");
						boolean dostupnost = sc.nextBoolean();
						System.out.println("Zadaj rocnik");
						int rocnik = sc.nextInt();
						mojaPolicka.setUcebnica(nazovKnihy, autorKnihy, rok_vydaniaKnihy, dostupnost, rocnik);
					}
					}
					System.out.println("Kniha je zadana.");					
					break;
				case 2:
					System.out.println("Zadaj nazov knihy, ktoru chces upravit:");
					String nazev = sc.nextLine();
					int i = mojaPolicka.najdiIndexNazov(nazev);
					Kniha upravovana = mojaPolicka.getKniha(i);
					System.out.println("Co chces upravit?");
					System.out.println("Nazov ... 1		Dostupnost ... 4");
					System.out.println("Autor ... 2		Zaner 	   ... 5");
					System.out.println("Rok   ... 3		Rocnik	   ... 6");
					int zmena;
					try {
						zmena = sc.nextInt();
					}
					catch (NullPointerException e) {
						System.out.println("Zadaj cislo.");
						zmena = sc.nextInt();
					}
					catch (InputMismatchException e) {
						System.out.println("Zadaj cislo.");
						zmena = sc.nextInt();
					}
					switch(zmena) {
					case 1:
						System.out.println("Zadaj novy nazov:");
						upravovana.setNazov(sc.nextLine());
					case 2:
						System.out.println("Zadaj noveho autora:");
						upravovana.setAutor(sc.nextLine());
					case 3:
						System.out.println("Zadaj novy rok:");
						upravovana.setRok_vydania(sc.nextInt());
					case 4:
						upravovana.zmenDostupnost();
					case 5:
						System.out.println("Zadaj novy zaner:");
						((Roman)upravovana).setZaner(sc.nextInt());
					case 6:
						System.out.println("Zadaj novy rocnik:");
						((Ucebnice)upravovana).setRocnik(sc.nextInt());
					}
					System.out.println("Zmena zaznamenana.");
					
					break;
				case 3:
					mojaPolicka.vypisKnihy();
					break;
				case 4:
					System.out.println("Zadaj nazov knihy, ktoru chces upravit:");
					nazov_knihy = sc.next();
					int idx = mojaPolicka.najdiIndexNazov(nazov_knihy);
					Kniha menena = mojaPolicka.getKniha(idx);
					menena.zmenDostupnost();
					System.out.println("Zmena zaznamenana.");
					break;
				case 5:
					mojaPolicka.vypisKnihy();
					break;
				case 6:
					System.out.println("Zadaj nazov knihy:");
					nazov_knihy = sc.next();
					int index = mojaPolicka.najdiIndexNazov(nazov_knihy);
					mojaPolicka.getKniha(index);
					break;
				case 7:
					
					break;
				case 8:
					System.out.println("Zadaj zaner: Romanticky, Historicky, Sci-fi, Detektivni, Fantasy");
					String zaner = sc.next();
					mojaPolicka.vypisPodlaZanra(zaner);
					break;
				case 9:
					mojaPolicka.suPozicane();
					break;
				case 10:
					System.out.println("Zadaj nazov knihy: ");
					String nazov_knihy = sc.next();
					mojaPolicka.ulozTo(nazov_knihy);
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


