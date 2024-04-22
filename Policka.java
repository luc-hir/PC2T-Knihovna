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
		naPolicke=new Kniha[100];
		sc=new Scanner(System.in);
	}
	
	public void setRoman(String nazovKnihy, String autorKnihy, int rok_vydaniaKnihy, boolean dostupnost, int CisloZaner )
	{
		
			naPolicke[poslednaKniha]=new Roman(nazovKnihy, autorKnihy, rok_vydaniaKnihy, dostupnost, CisloZaner);
			poslednaKniha++;
	}

	public void setUcebnica(String nazovKnihy, String autorKnihy, int rok_vydaniaKnihy, boolean dostupnost, int rocnik ) 
	{
			
			naPolicke[poslednaKniha]=new Ucebnice(nazovKnihy, autorKnihy, rok_vydaniaKnihy, dostupnost, rocnik);
			poslednaKniha++;		
	}
	
	public Kniha getKniha(int idx)
	{
		return naPolicke[idx];
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
		
	public void ulozTo(String fileName) throws IOException {
		FileWriter fw = new FileWriter(fileName);
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write("velkost databazy:"+naPolicke.length);
		bw.newLine();
		
		for(int i=0; i< poslednaKniha; i++) {
			fw.write("Meno: "+naPolicke[i].getNazov()+"\t Autor: "+naPolicke[i].getAutor()+"\t Rok: "+naPolicke[i].getRok_vydania());
			if(naPolicke[i].getDostupnost()) {
				System.out.println("Volna");	
			}
			else {
				System.out.println("Nedostupna");
			}
			bw.newLine();
		
			}
		bw.close();
		fw.close();
	
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
