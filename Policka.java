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
	
	public void setKniha()
	{
		System.out.println("Zadaj typ knihy: roman(true)/ucebnica(false)");
		String typ_knihy= sc.next();
		switch(typ_knihy) {
			case "roman":
				System.out.println("Zadaj nazov knihy");
				String nazov=sc.next();
				System.out.println("Zadaj autor knihy");
				String autor=sc.next();
				System.out.println("Zadaj rok vydania knihy");
				int rok_vydania=sc.nextInt();
				System.out.println("Zadaj rok vydania knihy");
				boolean dostupnost=sc.nextBoolean();
				System.out.println("Zadaj zaner romanu");
				String zaner=sc.next();
				naPolicke[poslednaKniha++]=new Roman(nazov, autor, rok_vydania, dostupnost, zaner );
			case "ucebnica":
				System.out.println("Zadaj nazov knihy");
				String Nazov=sc.next();
				System.out.println("Zadaj autor knihy");
				String Autor=sc.next();
				System.out.println("Zadaj rok vydania knihy");
				int rokVydania=sc.nextInt();
				System.out.println("Zadaj rok vydania knihy");
				boolean dostupna =sc.nextBoolean();
				System.out.println("Zadaj rocnik ucebnice");
				int rocnik=sc.nextInt();
				naPolicke[poslednaKniha++]=new Ucebnice(Nazov, Autor, rokVydania, dostupna, rocnik);
		}
				
	}
	
	public Kniha getKniha(int idx)
	{
		return naPolicke[idx];
	}
	
	
		
		
	public void vypisKnihy() 
	{
		for (int i = 0; i < poslednaKniha ;i++) 
		{
			System.out.print("Meno: "+naPolicke[i].getNazov()+"\t Autor: "+naPolicke[i].getAutor()+"\t Rok: "+naPolicke[i].getRok_vydania());
			if(naPolicke[i].getDostupnost()) {
				System.out.println("Volna");	
			}
			else {
				System.out.println("Nedostupna");
			}
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
