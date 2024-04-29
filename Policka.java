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
			i++;
			if ((naPolicke[i].getNazov().compareTo(nazovKnihy))>=0) {
				break;
	        }
		}
		FileWriter fw = new FileWriter(naPolicke[i].getNazov());
		BufferedWriter bw=new BufferedWriter(fw);
		bw.write("Meno: "+naPolicke[i].getNazov()+"\t Autor: "+naPolicke[i].getAutor()+"\t Rok: "+naPolicke[i].getRok_vydania());
		if(naPolicke[i].getDostupnost()) {
			bw.write("Dostupna");
		}
		else {
			bw.write("Dostupna");
		}
		if(naPolicke[i] instanceof Roman) {
			bw.write("Zaner: "+((Roman)naPolicke[i]).getZaner());
		}
		else {
			bw.write("Rocnik: "+((Ucebnice)naPolicke[i]).getRocnik());
		}
	}
		
	public void nacitajTo(String fileName) throws IOException {
		FileReader fr = new FileReader(fileName);
		BufferedReader br = new BufferedReader(fr);
		
		String line=br.readLine();
		String words[]=line.split(":");
		
		int pocet_prvkov = Integer.parseInt(words[1]);
		naPolicke=new Kniha[pocet_prvkov];
		poslednaKniha=0;
		
		while ((line= br.readLine())!=null) {
			words = line.split(";");
			Kniha kniha=new Kniha(words[0], Integer.parseInt(words[1]));
			
			}
		br.close();
		fr.close();
	}
		
	private Scanner sc;
	private Kniha [] naPolicke;
	private int poslednaKniha;
	
}
