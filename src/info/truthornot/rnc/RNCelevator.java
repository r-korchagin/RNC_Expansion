package info.truthornot.rnc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;




public class RNCelevator {
	
	public static StringBuilder scriptWriter (StringBuilder input){
	//	System.out.println(input);
		
		StringBuilder newBLOCK = new StringBuilder();
		
		if(input.toString().indexOf("@StartCSPool@")>-1){
			//CS Pool
			int count = (rncMain.RNC.get_MS_Count()+rncMain.RNC.get_ES1_Count()+rncMain.RNC.get_ES2_Count()+
					rncMain.RNC.get_ES3_Count()+rncMain.RNC.get_ES4_Count()+rncMain.RNC.get_ES5_Count())*2;
			Scanner scanner = new Scanner(input.toString());
			String Line = "";
			List<String> pool = new ArrayList<String>(); 
			while (scanner.hasNext()){
				Line = scanner.nextLine();
				Line = Line.replaceAll("@countOfBoardCS@", String.valueOf(count));
				if (Line.indexOf("@StartCSPool@")>-1){
					//Get pool line
					while (scanner.hasNext()&Line.indexOf("@StopCSPool@")==-1){												
							Line = scanner.nextLine();
							if (Line.indexOf("@StopCSPool@")==-1){	
								pool.add(Line);
							}						
					}
					if (Line.indexOf("@StopCSPool@")>-1){Line = scanner.nextLine();}
					//Add line pool MS
					for(int i = 0; i < rncMain.RNC.get_MS_Count(); i++){
						for(int k = 0; k < pool.size(); k++){
							String poolLine = pool.get(k);
							poolLine = poolLine.replaceAll("@Subrack@", "MS");
							poolLine = poolLine.replaceAll("@Slot@", rncMain.RNC.get_MS_SlotData(i).get_Slot());
							newBLOCK.append(poolLine);
							newBLOCK.append(System.getProperty("line.separator"));
						}
					}
					//Add line pool ES-1
					for(int i = 0; i < rncMain.RNC.get_ES1_Count(); i++){
						for(int k = 0; k < pool.size(); k++){
							String poolLine = pool.get(k);
							poolLine = poolLine.replaceAll("@Subrack@", "ES-1");
							poolLine = poolLine.replaceAll("@Slot@", rncMain.RNC.get_ES1_SlotData(i).get_Slot());
							newBLOCK.append(poolLine);
							newBLOCK.append(System.getProperty("line.separator"));
						}
					}
					//Add line pool ES-2
					for(int i = 0; i < rncMain.RNC.get_ES2_Count(); i++){
						for(int k = 0; k < pool.size(); k++){
							String poolLine = pool.get(k);
							poolLine = poolLine.replaceAll("@Subrack@", "ES-2");
							poolLine = poolLine.replaceAll("@Slot@", rncMain.RNC.get_ES2_SlotData(i).get_Slot());
							newBLOCK.append(poolLine);
							newBLOCK.append(System.getProperty("line.separator"));
						}
					}
					//Add line pool ES-3
					for(int i = 0; i < rncMain.RNC.get_ES3_Count(); i++){
						for(int k = 0; k < pool.size(); k++){
							String poolLine = pool.get(k);
							poolLine = poolLine.replaceAll("@Subrack@", "ES-3");
							poolLine = poolLine.replaceAll("@Slot@", rncMain.RNC.get_ES3_SlotData(i).get_Slot());
							newBLOCK.append(poolLine);
							newBLOCK.append(System.getProperty("line.separator"));
						}
					}
					//Add line pool ES-4
					for(int i = 0; i < rncMain.RNC.get_ES4_Count(); i++){
						for(int k = 0; k < pool.size(); k++){
							String poolLine = pool.get(k);
							poolLine = poolLine.replaceAll("@Subrack@", "ES-4");
							poolLine = poolLine.replaceAll("@Slot@", rncMain.RNC.get_ES4_SlotData(i).get_Slot());
							newBLOCK.append(poolLine);
							newBLOCK.append(System.getProperty("line.separator"));
						}
					}
					//Add line pool ES-5
					for(int i = 0; i < rncMain.RNC.get_ES5_Count(); i++){
						for(int k = 0; k < pool.size(); k++){
							String poolLine = pool.get(k);
							poolLine = poolLine.replaceAll("@Subrack@", "ES-5");
							poolLine = poolLine.replaceAll("@Slot@", rncMain.RNC.get_ES5_SlotData(i).get_Slot());
							newBLOCK.append(poolLine);
							newBLOCK.append(System.getProperty("line.separator"));
						}
					}
				}
				newBLOCK.append(Line);
				newBLOCK.append(System.getProperty("line.separator"));
			}
			scanner.close();
			return newBLOCK;
		}
		
		if(input.toString().indexOf("@StartPSPool@")>-1){
			//PS Pool
			int count = (rncMain.RNC.get_MS_Count()+rncMain.RNC.get_ES1_Count()+rncMain.RNC.get_ES2_Count()+
					rncMain.RNC.get_ES3_Count()+rncMain.RNC.get_ES4_Count()+rncMain.RNC.get_ES5_Count());
			Scanner scanner = new Scanner(input.toString());
			String Line = "";
			List<String> pool = new ArrayList<String>(); 
			while (scanner.hasNext()){
				Line = scanner.nextLine();
				Line = Line.replaceAll("@countOfBoardPS@", String.valueOf(count));
				if (Line.indexOf("@StartPSPool@")>-1){
					//Get pool line
					while (scanner.hasNext()&Line.indexOf("@StopPSPool@")==-1){												
							Line = scanner.nextLine();
							if (Line.indexOf("@StopPSPool@")==-1){	
								pool.add(Line);
							}						
					}
					if (Line.indexOf("@StopPSPool@")>-1){Line = scanner.nextLine();}
					//Add line pool MS
					for(int i = 0; i < rncMain.RNC.get_MS_Count(); i++){
						for(int k = 0; k < pool.size(); k++){
							String poolLine = pool.get(k);
							poolLine = poolLine.replaceAll("@Subrack@", "MS");
							poolLine = poolLine.replaceAll("@Slot@", rncMain.RNC.get_MS_SlotData(i).get_Slot());
							newBLOCK.append(poolLine);
							newBLOCK.append(System.getProperty("line.separator"));
						}
					}
					//Add line pool ES-1
					for(int i = 0; i < rncMain.RNC.get_ES1_Count(); i++){
						for(int k = 0; k < pool.size(); k++){
							String poolLine = pool.get(k);
							poolLine = poolLine.replaceAll("@Subrack@", "ES-1");
							poolLine = poolLine.replaceAll("@Slot@", rncMain.RNC.get_ES1_SlotData(i).get_Slot());
							newBLOCK.append(poolLine);
							newBLOCK.append(System.getProperty("line.separator"));
						}
					}
					//Add line pool ES-2
					for(int i = 0; i < rncMain.RNC.get_ES2_Count(); i++){
						for(int k = 0; k < pool.size(); k++){
							String poolLine = pool.get(k);
							poolLine = poolLine.replaceAll("@Subrack@", "ES-2");
							poolLine = poolLine.replaceAll("@Slot@", rncMain.RNC.get_ES2_SlotData(i).get_Slot());
							newBLOCK.append(poolLine);
							newBLOCK.append(System.getProperty("line.separator"));
						}
					}
					//Add line pool ES-3
					for(int i = 0; i < rncMain.RNC.get_ES3_Count(); i++){
						for(int k = 0; k < pool.size(); k++){
							String poolLine = pool.get(k);
							poolLine = poolLine.replaceAll("@Subrack@", "ES-3");
							poolLine = poolLine.replaceAll("@Slot@", rncMain.RNC.get_ES3_SlotData(i).get_Slot());
							newBLOCK.append(poolLine);
							newBLOCK.append(System.getProperty("line.separator"));
						}
					}
					//Add line pool ES-4
					for(int i = 0; i < rncMain.RNC.get_ES4_Count(); i++){
						for(int k = 0; k < pool.size(); k++){
							String poolLine = pool.get(k);
							poolLine = poolLine.replaceAll("@Subrack@", "ES-4");
							poolLine = poolLine.replaceAll("@Slot@", rncMain.RNC.get_ES4_SlotData(i).get_Slot());
							newBLOCK.append(poolLine);
							newBLOCK.append(System.getProperty("line.separator"));
						}
					}
					//Add line pool ES-5
					for(int i = 0; i < rncMain.RNC.get_ES5_Count(); i++){
						for(int k = 0; k < pool.size(); k++){
							String poolLine = pool.get(k);
							poolLine = poolLine.replaceAll("@Subrack@", "ES-5");
							poolLine = poolLine.replaceAll("@Slot@", rncMain.RNC.get_ES5_SlotData(i).get_Slot());
							newBLOCK.append(poolLine);
							newBLOCK.append(System.getProperty("line.separator"));
						}
					}
				}
				newBLOCK.append(Line);
				newBLOCK.append(System.getProperty("line.separator"));
			}
			scanner.close();
			return newBLOCK;
		}
		
		if(input.toString().indexOf("@StartIUBPool@")>-1){
			//IUB Pool
			int count = (rncMain.RNC.get_MS_Count()+rncMain.RNC.get_ES1_Count()+rncMain.RNC.get_ES2_Count()+
					rncMain.RNC.get_ES3_Count()+rncMain.RNC.get_ES4_Count()+rncMain.RNC.get_ES5_Count())*2;
			Scanner scanner = new Scanner(input.toString());
			String Line = "";
			List<String> pool = new ArrayList<String>(); 
			while (scanner.hasNext()){
				Line = scanner.nextLine();
				Line = Line.replaceAll("@countOfBoardIub@", String.valueOf(count));
				if (Line.indexOf("@StartIUBPool@")>-1){
					//Get pool line
					while (scanner.hasNext()&Line.indexOf("@StopIUBPool@")==-1){												
							Line = scanner.nextLine();
							if (Line.indexOf("@StopIUBPool@")==-1){	
								pool.add(Line);
							}						
					}
					if (Line.indexOf("@StopIUBPool@")>-1){Line = scanner.nextLine();}
					//Add line pool MS
					for(int i = 0; i < rncMain.RNC.get_MS_Count(); i++){
						for(int k = 0; k < pool.size(); k++){
							String poolLine = pool.get(k);
							poolLine = poolLine.replaceAll("@Subrack@", "MS");
							poolLine = poolLine.replaceAll("@Slot@", rncMain.RNC.get_MS_SlotData(i).get_Slot());
							newBLOCK.append(poolLine);
							newBLOCK.append(System.getProperty("line.separator"));
						}
					}
					//Add line pool ES-1
					for(int i = 0; i < rncMain.RNC.get_ES1_Count(); i++){
						for(int k = 0; k < pool.size(); k++){
							String poolLine = pool.get(k);
							poolLine = poolLine.replaceAll("@Subrack@", "ES-1");
							poolLine = poolLine.replaceAll("@Slot@", rncMain.RNC.get_ES1_SlotData(i).get_Slot());
							newBLOCK.append(poolLine);
							newBLOCK.append(System.getProperty("line.separator"));
						}
					}
					//Add line pool ES-2
					for(int i = 0; i < rncMain.RNC.get_ES2_Count(); i++){
						for(int k = 0; k < pool.size(); k++){
							String poolLine = pool.get(k);
							poolLine = poolLine.replaceAll("@Subrack@", "ES-2");
							poolLine = poolLine.replaceAll("@Slot@", rncMain.RNC.get_ES2_SlotData(i).get_Slot());
							newBLOCK.append(poolLine);
							newBLOCK.append(System.getProperty("line.separator"));
						}
					}
					//Add line pool ES-3
					for(int i = 0; i < rncMain.RNC.get_ES3_Count(); i++){
						for(int k = 0; k < pool.size(); k++){
							String poolLine = pool.get(k);
							poolLine = poolLine.replaceAll("@Subrack@", "ES-3");
							poolLine = poolLine.replaceAll("@Slot@", rncMain.RNC.get_ES3_SlotData(i).get_Slot());
							newBLOCK.append(poolLine);
							newBLOCK.append(System.getProperty("line.separator"));
						}
					}
					//Add line pool ES-4
					for(int i = 0; i < rncMain.RNC.get_ES4_Count(); i++){
						for(int k = 0; k < pool.size(); k++){
							String poolLine = pool.get(k);
							poolLine = poolLine.replaceAll("@Subrack@", "ES-4");
							poolLine = poolLine.replaceAll("@Slot@", rncMain.RNC.get_ES4_SlotData(i).get_Slot());
							newBLOCK.append(poolLine);
							newBLOCK.append(System.getProperty("line.separator"));
						}
					}
					//Add line pool ES-5
					for(int i = 0; i < rncMain.RNC.get_ES5_Count(); i++){
						for(int k = 0; k < pool.size(); k++){
							String poolLine = pool.get(k);
							poolLine = poolLine.replaceAll("@Subrack@", "ES-5");
							poolLine = poolLine.replaceAll("@Slot@", rncMain.RNC.get_ES5_SlotData(i).get_Slot());
							newBLOCK.append(poolLine);
							newBLOCK.append(System.getProperty("line.separator"));
						}
					}
				}
				newBLOCK.append(Line);
				newBLOCK.append(System.getProperty("line.separator"));
			}
			scanner.close();
			return newBLOCK;
		}
		
		//MS
		for(int i = 0; i < rncMain.RNC.get_MS_Count(); i++){
			Scanner scanner = new Scanner(input.toString());
			String Line = "";
			while (scanner.hasNext()){
				Line = scanner.nextLine();
				//CS
				Line = Line.replaceAll("@Subrack@", "MS");
				Line = Line.replaceAll("@Slot@", rncMain.RNC.get_MS_SlotData(i).get_Slot());
				Line = Line.replaceAll("@lurDefaultGW@", rncMain.RNC.get_MS_SlotData(i).get_lurDefaultGW());
				Line = Line.replaceAll("@IurNetworkPrefix@", rncMain.RNC.get_MS_SlotData(i).get_IurNetworkPrefix());
				Line = Line.replaceAll("@pIurIP@", rncMain.RNC.get_MS_SlotData(i).get_pIurIP());
				Line = Line.replaceAll("@sIurIP@", rncMain.RNC.get_MS_SlotData(i).get_sIurIP());
				Line = Line.replaceAll("@VlanCS@", rncMain.RNC.get_MS_SlotData(i).get_VlanCS());
				//PS
				Line = Line.replaceAll("@luPSDefaultGW@", rncMain.RNC.get_MS_SlotData(i).get_luPSDefaultGW());
				Line = Line.replaceAll("@IuPSNetworkPrefix@", rncMain.RNC.get_MS_SlotData(i).get_IuPSNetworkPrefix());
				Line = Line.replaceAll("@IuPSIP@", rncMain.RNC.get_MS_SlotData(i).get_IuPSIP());
				Line = Line.replaceAll("@VlanPS@", rncMain.RNC.get_MS_SlotData(i).get_VlanPS());
				//IUB
				Line = Line.replaceAll("@IubDefaultGW@", rncMain.RNC.get_MS_SlotData(i).get_IubDefaultGW());
				Line = Line.replaceAll("@IubNetworkPrefix@", rncMain.RNC.get_MS_SlotData(i).get_IubNetworkPrefix());
				Line = Line.replaceAll("@pIubIP@", rncMain.RNC.get_MS_SlotData(i).get_pIubIP());
				Line = Line.replaceAll("@sIubIP@", rncMain.RNC.get_MS_SlotData(i).get_sIubIP());
				Line = Line.replaceAll("@VlanIUB@", rncMain.RNC.get_MS_SlotData(i).get_VlanIUB());
				//
				Line = Line.replaceAll("@PDRNum@", rncMain.RNC.get_MS_SlotData(i).get_PdrNum());				
				Line = Line.replaceAll("@PrLink@", String.valueOf(rncMain.RNC.get_MS_SlotData(i).get_linkPriority()));
				
				newBLOCK.append(Line);
				newBLOCK.append(System.getProperty("line.separator"));
			}
			newBLOCK.append("");
			newBLOCK.append(System.getProperty("line.separator"));
			scanner.close();
			
		}
		//ES1
		for(int i = 0; i < rncMain.RNC.get_ES1_Count(); i++){
				Scanner scanner = new Scanner(input.toString());
				String Line = "";
				while (scanner.hasNext()){
					Line = scanner.nextLine();
					//CS
					Line = Line.replaceAll("@Subrack@", "ES-1");
					Line = Line.replaceAll("@Slot@", rncMain.RNC.get_ES1_SlotData(i).get_Slot());
					Line = Line.replaceAll("@lurDefaultGW@", rncMain.RNC.get_ES1_SlotData(i).get_lurDefaultGW());
					Line = Line.replaceAll("@IurNetworkPrefix@", rncMain.RNC.get_ES1_SlotData(i).get_IurNetworkPrefix());
					Line = Line.replaceAll("@pIurIP@", rncMain.RNC.get_ES1_SlotData(i).get_pIurIP());
					Line = Line.replaceAll("@sIurIP@", rncMain.RNC.get_ES1_SlotData(i).get_sIurIP());
					Line = Line.replaceAll("@VlanCS@", rncMain.RNC.get_ES1_SlotData(i).get_VlanCS());
					//PS
					Line = Line.replaceAll("@luPSDefaultGW@", rncMain.RNC.get_ES1_SlotData(i).get_luPSDefaultGW());
					Line = Line.replaceAll("@IuPSNetworkPrefix@", rncMain.RNC.get_ES1_SlotData(i).get_IuPSNetworkPrefix());
					Line = Line.replaceAll("@IuPSIP@", rncMain.RNC.get_ES1_SlotData(i).get_IuPSIP());
					Line = Line.replaceAll("@VlanPS@", rncMain.RNC.get_ES1_SlotData(i).get_VlanPS());
					//IUB
					Line = Line.replaceAll("@IubDefaultGW@", rncMain.RNC.get_ES1_SlotData(i).get_IubDefaultGW());
					Line = Line.replaceAll("@IubNetworkPrefix@", rncMain.RNC.get_ES1_SlotData(i).get_IubNetworkPrefix());
					Line = Line.replaceAll("@pIubIP@", rncMain.RNC.get_ES1_SlotData(i).get_pIubIP());
					Line = Line.replaceAll("@sIubIP@", rncMain.RNC.get_ES1_SlotData(i).get_sIubIP());
					Line = Line.replaceAll("@VlanIUB@", rncMain.RNC.get_ES1_SlotData(i).get_VlanIUB());
					
					//
					Line = Line.replaceAll("@PDRNum@", rncMain.RNC.get_ES1_SlotData(i).get_PdrNum());
					Line = Line.replaceAll("@PrLink@", String.valueOf(rncMain.RNC.get_ES1_SlotData(i).get_linkPriority()));
					
					newBLOCK.append(Line);
					newBLOCK.append(System.getProperty("line.separator"));
				}
				newBLOCK.append("");
				newBLOCK.append(System.getProperty("line.separator"));
				scanner.close();
			}
		//ES2
		for(int i = 0; i < rncMain.RNC.get_ES2_Count(); i++){
				Scanner scanner = new Scanner(input.toString());
				String Line = "";
				while (scanner.hasNext()){
					Line = scanner.nextLine();
					//CS
					Line = Line.replaceAll("@Subrack@", "ES-2");
					Line = Line.replaceAll("@Slot@", rncMain.RNC.get_ES2_SlotData(i).get_Slot());
					Line = Line.replaceAll("@lurDefaultGW@", rncMain.RNC.get_ES2_SlotData(i).get_lurDefaultGW());
					Line = Line.replaceAll("@IurNetworkPrefix@", rncMain.RNC.get_ES2_SlotData(i).get_IurNetworkPrefix());
					Line = Line.replaceAll("@pIurIP@", rncMain.RNC.get_ES2_SlotData(i).get_pIurIP());
					Line = Line.replaceAll("@sIurIP@", rncMain.RNC.get_ES2_SlotData(i).get_sIurIP());
					Line = Line.replaceAll("@VlanCS@", rncMain.RNC.get_ES2_SlotData(i).get_VlanCS());
					//PS
					Line = Line.replaceAll("@luPSDefaultGW@", rncMain.RNC.get_ES2_SlotData(i).get_luPSDefaultGW());
					Line = Line.replaceAll("@IuPSNetworkPrefix@", rncMain.RNC.get_ES2_SlotData(i).get_IuPSNetworkPrefix());
					Line = Line.replaceAll("@IuPSIP@", rncMain.RNC.get_ES2_SlotData(i).get_IuPSIP());
					Line = Line.replaceAll("@VlanPS@", rncMain.RNC.get_ES2_SlotData(i).get_VlanPS());
					//IUB
					Line = Line.replaceAll("@IubDefaultGW@", rncMain.RNC.get_ES2_SlotData(i).get_IubDefaultGW());
					Line = Line.replaceAll("@IubNetworkPrefix@", rncMain.RNC.get_ES2_SlotData(i).get_IubNetworkPrefix());
					Line = Line.replaceAll("@pIubIP@", rncMain.RNC.get_ES2_SlotData(i).get_pIubIP());
					Line = Line.replaceAll("@sIubIP@", rncMain.RNC.get_ES2_SlotData(i).get_sIubIP());
					Line = Line.replaceAll("@VlanIUB@", rncMain.RNC.get_ES2_SlotData(i).get_VlanIUB());
					
					//
					Line = Line.replaceAll("@PDRNum@", rncMain.RNC.get_ES2_SlotData(i).get_PdrNum());
					Line = Line.replaceAll("@PrLink@", String.valueOf(rncMain.RNC.get_ES2_SlotData(i).get_linkPriority()));
					
					newBLOCK.append(Line);
					newBLOCK.append(System.getProperty("line.separator"));
				}
				newBLOCK.append("");
				newBLOCK.append(System.getProperty("line.separator"));
				scanner.close();
			}
		//ES3
		for(int i = 0; i < rncMain.RNC.get_ES3_Count(); i++){
				Scanner scanner = new Scanner(input.toString());
				String Line = "";
				while (scanner.hasNext()){
					Line = scanner.nextLine();
					//CS
					Line = Line.replaceAll("@Subrack@", "ES-3");
					Line = Line.replaceAll("@Slot@", rncMain.RNC.get_ES3_SlotData(i).get_Slot());
					Line = Line.replaceAll("@lurDefaultGW@", rncMain.RNC.get_ES3_SlotData(i).get_lurDefaultGW());
					Line = Line.replaceAll("@IurNetworkPrefix@", rncMain.RNC.get_ES3_SlotData(i).get_IurNetworkPrefix());
					Line = Line.replaceAll("@pIurIP@", rncMain.RNC.get_ES3_SlotData(i).get_pIurIP());
					Line = Line.replaceAll("@sIurIP@", rncMain.RNC.get_ES3_SlotData(i).get_sIurIP());
					Line = Line.replaceAll("@VlanCS@", rncMain.RNC.get_ES3_SlotData(i).get_VlanCS());
					//PS
					Line = Line.replaceAll("@luPSDefaultGW@", rncMain.RNC.get_ES3_SlotData(i).get_luPSDefaultGW());
					Line = Line.replaceAll("@IuPSNetworkPrefix@", rncMain.RNC.get_ES3_SlotData(i).get_IuPSNetworkPrefix());
					Line = Line.replaceAll("@IuPSIP@", rncMain.RNC.get_ES3_SlotData(i).get_IuPSIP());
					Line = Line.replaceAll("@VlanPS@", rncMain.RNC.get_ES3_SlotData(i).get_VlanPS());
					//IUB
					Line = Line.replaceAll("@IubDefaultGW@", rncMain.RNC.get_ES3_SlotData(i).get_IubDefaultGW());
					Line = Line.replaceAll("@IubNetworkPrefix@", rncMain.RNC.get_ES3_SlotData(i).get_IubNetworkPrefix());
					Line = Line.replaceAll("@pIubIP@", rncMain.RNC.get_ES3_SlotData(i).get_pIubIP());
					Line = Line.replaceAll("@sIubIP@", rncMain.RNC.get_ES3_SlotData(i).get_sIubIP());
					Line = Line.replaceAll("@VlanIUB@", rncMain.RNC.get_ES3_SlotData(i).get_VlanIUB());
					
					//
					Line = Line.replaceAll("@PDRNum@", rncMain.RNC.get_ES3_SlotData(i).get_PdrNum());
					Line = Line.replaceAll("@PrLink@", String.valueOf(rncMain.RNC.get_ES3_SlotData(i).get_linkPriority()));
					
					newBLOCK.append(Line);
					newBLOCK.append(System.getProperty("line.separator"));
				}
				newBLOCK.append("");
				newBLOCK.append(System.getProperty("line.separator"));
				scanner.close();
			}
		//ES4
		for(int i = 0; i < rncMain.RNC.get_ES4_Count(); i++){
				Scanner scanner = new Scanner(input.toString());
				String Line = "";
				while (scanner.hasNext()){
					Line = scanner.nextLine();
					//CS
					Line = Line.replaceAll("@Subrack@", "ES-4");
					Line = Line.replaceAll("@Slot@", rncMain.RNC.get_ES4_SlotData(i).get_Slot());
					Line = Line.replaceAll("@lurDefaultGW@", rncMain.RNC.get_ES4_SlotData(i).get_lurDefaultGW());
					Line = Line.replaceAll("@IurNetworkPrefix@", rncMain.RNC.get_ES4_SlotData(i).get_IurNetworkPrefix());
					Line = Line.replaceAll("@pIurIP@", rncMain.RNC.get_ES4_SlotData(i).get_pIurIP());
					Line = Line.replaceAll("@sIurIP@", rncMain.RNC.get_ES4_SlotData(i).get_sIurIP());
					Line = Line.replaceAll("@VlanCS@", rncMain.RNC.get_ES4_SlotData(i).get_VlanCS());
					//PS
					Line = Line.replaceAll("@luPSDefaultGW@", rncMain.RNC.get_ES4_SlotData(i).get_luPSDefaultGW());
					Line = Line.replaceAll("@IuPSNetworkPrefix@", rncMain.RNC.get_ES4_SlotData(i).get_IuPSNetworkPrefix());
					Line = Line.replaceAll("@IuPSIP@", rncMain.RNC.get_ES4_SlotData(i).get_IuPSIP());
					Line = Line.replaceAll("@VlanPS@", rncMain.RNC.get_ES4_SlotData(i).get_VlanPS());
					//IUB
					Line = Line.replaceAll("@IubDefaultGW@", rncMain.RNC.get_ES4_SlotData(i).get_IubDefaultGW());
					Line = Line.replaceAll("@IubNetworkPrefix@", rncMain.RNC.get_ES4_SlotData(i).get_IubNetworkPrefix());
					Line = Line.replaceAll("@pIubIP@", rncMain.RNC.get_ES4_SlotData(i).get_pIubIP());
					Line = Line.replaceAll("@sIubIP@", rncMain.RNC.get_ES4_SlotData(i).get_sIubIP());
					Line = Line.replaceAll("@VlanIUB@", rncMain.RNC.get_ES4_SlotData(i).get_VlanIUB());
					
					//
					Line = Line.replaceAll("@PDRNum@", rncMain.RNC.get_ES4_SlotData(i).get_PdrNum());
					Line = Line.replaceAll("@PrLink@", String.valueOf(rncMain.RNC.get_ES4_SlotData(i).get_linkPriority()));
					
					newBLOCK.append(Line);
					newBLOCK.append(System.getProperty("line.separator"));
				}
				newBLOCK.append("");
				newBLOCK.append(System.getProperty("line.separator"));
				scanner.close();
			}
		//ES5
		for(int i = 0; i < rncMain.RNC.get_ES5_Count(); i++){
				Scanner scanner = new Scanner(input.toString());
				String Line = "";
				while (scanner.hasNext()){
					Line = scanner.nextLine();
					//CS
					Line = Line.replaceAll("@Subrack@", "ES-5");
					Line = Line.replaceAll("@Slot@", rncMain.RNC.get_ES5_SlotData(i).get_Slot());
					Line = Line.replaceAll("@lurDefaultGW@", rncMain.RNC.get_ES5_SlotData(i).get_lurDefaultGW());
					Line = Line.replaceAll("@IurNetworkPrefix@", rncMain.RNC.get_ES5_SlotData(i).get_IurNetworkPrefix());
					Line = Line.replaceAll("@pIurIP@", rncMain.RNC.get_ES5_SlotData(i).get_pIurIP());
					Line = Line.replaceAll("@sIurIP@", rncMain.RNC.get_ES5_SlotData(i).get_sIurIP());
					Line = Line.replaceAll("@VlanCS@", rncMain.RNC.get_ES5_SlotData(i).get_VlanCS());
					//PS
					Line = Line.replaceAll("@luPSDefaultGW@", rncMain.RNC.get_ES5_SlotData(i).get_luPSDefaultGW());
					Line = Line.replaceAll("@IuPSNetworkPrefix@", rncMain.RNC.get_ES5_SlotData(i).get_IuPSNetworkPrefix());
					Line = Line.replaceAll("@IuPSIP@", rncMain.RNC.get_ES5_SlotData(i).get_IuPSIP());
					Line = Line.replaceAll("@VlanPS@", rncMain.RNC.get_ES5_SlotData(i).get_VlanPS());
					//IUB
					Line = Line.replaceAll("@IubDefaultGW@", rncMain.RNC.get_ES5_SlotData(i).get_IubDefaultGW());
					Line = Line.replaceAll("@IubNetworkPrefix@", rncMain.RNC.get_ES5_SlotData(i).get_IubNetworkPrefix());
					Line = Line.replaceAll("@pIubIP@", rncMain.RNC.get_ES5_SlotData(i).get_pIubIP());
					Line = Line.replaceAll("@sIubIP@", rncMain.RNC.get_ES5_SlotData(i).get_sIubIP());
					Line = Line.replaceAll("@VlanIUB@", rncMain.RNC.get_ES5_SlotData(i).get_VlanIUB());
					
					//
					Line = Line.replaceAll("@PDRNum@", rncMain.RNC.get_ES5_SlotData(i).get_PdrNum());
					Line = Line.replaceAll("@PrLink@", String.valueOf(rncMain.RNC.get_ES5_SlotData(i).get_linkPriority()));
					
					newBLOCK.append(Line);
					newBLOCK.append(System.getProperty("line.separator"));
				}
				newBLOCK.append("");
				newBLOCK.append(System.getProperty("line.separator"));
				scanner.close();
			}		
		return newBLOCK;
	}
	
	public static void createCommandFile(String fileName, String SaveFileName) {
		StringBuilder ScriptFile = new StringBuilder();
		StringBuilder ResultFile = new StringBuilder();
		StringBuilder BLOCK = new StringBuilder();
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(fileName));
			String  thisLine = null;
			while ((thisLine = br.readLine()) != null) {				
				ScriptFile.append(thisLine);				
				ScriptFile.append(System.getProperty("line.separator"));
			}
			System.out.println("ScriptFile");
			//System.out.println(ScriptFile);
			
			Scanner scanner = new Scanner(ScriptFile.toString());
			String Line = "";			
			while (scanner.hasNext()){
				Line = scanner.nextLine();
				//System.out.println(Line);
				if (Line.indexOf("@@@")>-1){
					// WRITE result for current block
					ResultFile.append(scriptWriter(BLOCK));
					ResultFile.append(System.getProperty("line.separator"));
					BLOCK.setLength(0);
				}else{	BLOCK.append(Line); BLOCK.append(System.getProperty("line.separator")); }				
			}
			scanner.close();
			ResultFile.append(scriptWriter(BLOCK));
			//BLOCK.setLength(0);
											
			File file = new File(SaveFileName);
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			try {					    
				writer.write(ResultFile.toString());
			} finally {
					if (writer != null) writer.close();
			}
								
			
						
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
}
