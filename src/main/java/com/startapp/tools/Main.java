package com.startapp.tools;

import java.util.List;

import com.startapp.beans.alegra.AlegraWarehouse;
import com.startapp.beans.rappi.RappiStore;
import com.startapp.beans.alegra.AlegraCategory;
import com.startapp.beans.woocommerce.WoocommerceCategory;
import com.startapp.integraciones.Alegra;
import com.startapp.integraciones.Rappi;
import com.startapp.integraciones.Woocommerce;

public class Main {
	public static void main(String[] args) throws Exception {
		
		List<WoocommerceCategory> woo = Woocommerce.getWoocommerceCategories();
		System.out.println("Categorias de Woocommerce");
		System.out.println("=========================");
		for (WoocommerceCategory categoria : woo) {
			System.out.println(categoria.getName()+" - "+categoria.getId());
		}
		
		List<AlegraCategory> ale = Alegra.getAlegraCategories();
		System.out.println("");
		System.out.println("");
		System.out.println("Categorias de Alegra");
		System.out.println("====================");

		for (AlegraCategory categoria : ale) {
			System.out.println(categoria.getName()+" - "+categoria.getId());
		}
		
		List<AlegraWarehouse> bod = Alegra.getAlegraAlmacenes();
		
		System.out.println("");
		System.out.println("");
		System.out.println("Bodegas de Alegra");
		System.out.println("====================");
		
		for (AlegraWarehouse categoria : bod) {
			System.out.println(categoria.getName()+" - "+categoria.getId());
		}
		
		List<RappiStore> rapSt = Rappi.getRappiStores();
		
		System.out.println("");
		System.out.println("");
		System.out.println("Tiendas de Rappi");
		System.out.println("====================");
		
		for (RappiStore tienda : rapSt) {
			System.out.println(tienda.toString());
		}
		
	}

}
