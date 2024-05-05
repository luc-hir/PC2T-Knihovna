package balicek;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;

public class Policka {
	public Policka()
	{
		sc=new Scanner(System.in);
		naPolicke=new Kniha[100];		
	}
	
	public void setRoman(String nazovKnihy, String autorKnihy, int rok_vydaniaKnihy, boolean dostupnost, int CisloZaner )
	{
		
			naPolicke[poslednaKniha++]=new Roman(nazovKnihy, autorKnihy, rok_vydaniaKnihy, dostupnost, CisloZaner);
	}

	public void setUcebnica(String nazovKnihy, String autorKnihy, int rok_vydaniaKnihy, boolean dostupnost, int rocnik ) 
	{
			
			naPolicke[poslednaKniha++]=new Ucebnice(nazovKnihy, autorKnihy, rok_vydaniaKnihy, dostupnost, rocnik);		
	}
	
	public void vypisPodlaZanra(String zaner) {
		for (int i = 0; i < poslednaKniha; i++) {
			if(naPolicke[i] instanceof Roman) {
				if((((Roman)naPolicke[i]).getZaner()).equals(zaner)) {
					System.out.print("Nazov: "+naPolicke[i].getNazov()+"\nAutor: "+naPolicke[i].getAutor()+"\nRok: "+naPolicke[i].getRok_vydania()+"\n");
					if(naPolicke[i].getDostupnost()) {
						System.out.println("Volna");	
					}
					else {
						System.out.println("Nedostupna");
					}
					System.out.println("Zaner: "+ ((Roman)naPolicke[i]).getZaner());
				}
			}
		}
	}
	
	public void infoOKnihe(int i) {
		System.out.print("Nazov: "+naPolicke[i].getNazov()+"\nAutor: "+naPolicke[i].getAutor()+"\nRok: "+naPolicke[i].getRok_vydania()+"\n");
		if(naPolicke[i].getDostupnost()) {
			System.out.println("Volna");	
		}
		else {
			System.out.println("Nedostupna");
		}
		if(naPolicke[i] instanceof Roman) {
			System.out.println("Zaner: "+ ((Roman)naPolicke[i]).getZaner());
		}
		else {
			System.out.println("Rocnik: "+ ((Ucebnice)naPolicke[i]).getRocnik()+".");
		}
		System.out.println("");
	}

	public int najdiIndexNazov(String string) {
		int i;
		for (i=0; i<poslednaKniha; i++) {
			if ((naPolicke[i].getNazov().compareTo(string))>=0) {
	            return i;
	        }
		}
		System.out.println("Knihu sa nepodarilo najst.");
		return -1;	
	}
	
	public Kniha najdiKnihuAutor (String string) {
		int i;
		for (i=0; i<poslednaKniha; i++) {
			String autor = naPolicke[i].getAutor();
			if(autor.compareTo(string)==0) {
				break;
			}
		}
		return naPolicke[i];
	}		
		
	public void vypisKnihy() 
	{
		Arrays.sort(naPolicke, Porovnani.comparing(Kniha::getNazov));
		for (int i = 0; i < poslednaKniha ;i++) 
		{
			System.out.print("Nazov: "+naPolicke[i].getNazov()+"\nAutor: "+naPolicke[i].getAutor()+"\nRok: "+naPolicke[i].getRok_vydania()+"\n");
			if(naPolicke[i].getDostupnost()) {
				System.out.println("Volna");	
			}
			else {
				System.out.println("Nedostupna");
			}
			if(naPolicke[i] instanceof Roman) {
				System.out.println("Zaner: "+ ((Roman)naPolicke[i]).getZaner());
			}
			else {
				System.out.println("Rocnik: "+ ((Ucebnice)naPolicke[i]).getRocnik()+".");
			}
			System.out.println("");
		}
	}

	public void suPozicane() {
		for (int i = 0; i < poslednaKniha; i++) {
			if(!naPolicke[i].getDostupnost()) {
				System.out.print("Nazov: "+naPolicke[i].getNazov()+"\nAutor: "+naPolicke[i].getAutor()+"\nRok: "+naPolicke[i].getRok_vydania()+"\n");
				if(naPolicke[i] instanceof Roman) {
					System.out.println("Zaner: "+ ((Roman)naPolicke[i]).getZaner());
				}
				else {
					System.out.println("Rocnik: "+ ((Ucebnice)naPolicke[i]).getRocnik()+".");
				}
				System.out.println("");
			}
		}
	}
		
	public void ulozTo(String nazovKnihy) throws IOException {
		int i = 0;
		for (int j = 0; j<poslednaKniha; j++) {
			if (naPolicke[i].getNazov().equals(nazovKnihy)) {
				break;
				}
			i++;
		}
		try {
			FileWriter fw = new FileWriter(naPolicke[i].getNazov()+".txt");
			BufferedWriter bw=new BufferedWriter(fw);
			fw.write("Meno: "+naPolicke[i].getNazov()+"\nAutor: "+naPolicke[i].getAutor()+"\nRok: "+naPolicke[i].getRok_vydania());
			if(naPolicke[i].getDostupnost()) {
				bw.write("\nDostupna");
			}
			else {
				bw.write("\nNedostupna");
			}
			if(naPolicke[i] instanceof Roman) {
				bw.write("\nZaner: "+((Roman)naPolicke[i]).getZaner());
			}
			else {
				bw.write("\nRocnik: "+((Ucebnice)naPolicke[i]).getRocnik());
			
			}
			bw.close();
			fw.close();
			
		}
		catch(IOException e) {
			System.out.println("Nepodarilo sa vytvorit subor.");
		}			
	}	

	public void nacitajTo(String fileName) throws IOException {
		try {
			FileReader fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);
		
		String line=br.readLine();
		String words[]=line.split(" ");
		
		int pocet_prvkov = Integer.parseInt(words[1]);
		naPolicke=new Kniha[pocet_prvkov];
		poslednaKniha=0;
		
		while ((line= br.readLine())!=null) {
			words = line.split("");
			
			
			}
		br.close();
		fr.close();	
		}
		catch(FileNotFoundException e) {
			System.out.println("Subor sa nenasiel.");
		}		
	}
	public void smazKniha(int index) {
	for (int i = index; i < mojaPolicka.length - 1; i++) {
        mojaPolicka[i] = mojaPolicka[i + 1];
          }
	mojaPolicka[mojaPolicka.length - 1] = null;
	
	}
		
	private Scanner sc;
	private Kniha [] naPolicke;
	private int poslednaKniha;
	
}
