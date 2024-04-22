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
					if (typ==1) {
						typKnihy=false;
						System.out.println("Zadaj nazov knihy");
						String nazovKnihy = sc.next();
						System.out.println("Zadaj autora knihy");
						String autorKnihy = sc.next();
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
						String nazovKnihy = sc.next();
						System.out.println("Zadaj autora knihy");
						String autorKnihy = sc.next();
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
					System.out.println("Zadaj nazov knihy, ktoru chces upravit");
					
					System.out.println("");
					
					System.out.println("");
					
					break;
				case 3:
					mojaPolicka.vypisKnihy();
									
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


