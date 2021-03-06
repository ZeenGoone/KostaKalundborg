package controller.main;

import java.util.ArrayList;

import ui.GUI;
import entity.tenancy.Caravan;
import entity.tenancy.Hut;
import entity.tenancy.LuxuryHut;
import entity.tenancy.Tenancy;
import entity.tenancy.Tent;

public class GUIController {
	public static void main(String[] args) {
		ArrayList<Tenancy> caravans = new ArrayList<Tenancy>();
		ArrayList<Tenancy> tents = new ArrayList<Tenancy>();
		ArrayList<Tenancy> huts = new ArrayList<Tenancy>();
		ArrayList<Tenancy> luxuryhuts = new ArrayList<Tenancy>();
		for (int i=0; i<10; i++){caravans.add(new Caravan(i));}
		for (int i=10; i<50; i++){tents.add(new Tent(i));}
		for (int i=20; i<30; i++){huts.add(new Hut(i));}
		for (int i=30; i<40; i++){luxuryhuts.add(new LuxuryHut(i));}
		GUI GUI = new GUI();
		GUI.before();
		GUI.setCaravanList(getIntegerList(caravans));
		GUI.setTentList(getIntegerList(tents));
		GUI.setHutList(getIntegerList(huts));
		GUI.setLuxuryhutList(getIntegerList(luxuryhuts));
		GUI.finish();
	}
	private static ArrayList<Integer> getIntegerList(ArrayList<Tenancy> list) {
		ArrayList<Integer> idList = new ArrayList<Integer>();
		for (Tenancy temp: list){idList.add(temp.getId()); }
		return idList;
	}

}
