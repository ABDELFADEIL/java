package dao;

import metier.entities.Produit;
import java.lang.System;
import java.util.ArrayList;
import java.util.List;
import java.io.PrintStream;

public class test {
	public static void main(String[] args) {
		ProduitDaoImpl dao = new ProduitDaoImpl();
		Produit p1= dao.Save(new Produit("HP 6580", 900, 45));
		Produit p2= dao.Save(new Produit("Imprimante Epson 760", 1000, 15));
        System.out.println(p1.toString());
        System.out.println(p2.toString());
        System.out.println("CHercher des produits");
        List<Produit> prods = dao.produitParMC("%H%");
        for(Produit p :prods) {
        	System.out.println(p.toString());
        }
        
        

	}  

}
