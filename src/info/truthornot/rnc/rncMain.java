package info.truthornot.rnc;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JSplitPane;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
// import java.lang.reflect.Type;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import java.awt.SystemColor;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import com.google.gson.Gson;

import java.awt.Color;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class rncMain {

	static JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JFormattedTextField formattedTextField;
	private JFormattedTextField formattedTextField_1;
	private JComboBox comboBox;
	private JFormattedTextField formattedTextField_2;
	private JFormattedTextField formattedTextField_3;
	private JFormattedTextField formattedTextField_8;
	private JFormattedTextField formattedTextField_4;
	private JFormattedTextField formattedTextField_5;
	private JComboBox comboBox_1;
	private JFormattedTextField formattedTextField_6;
	private JFormattedTextField formattedTextField_7;
	private JFormattedTextField formattedTextField_9;
	private JFormattedTextField formattedTextField_10;
	private JFormattedTextField formattedTextField_11;
	private JComboBox comboBox_2;
	private JFormattedTextField formattedTextField_12;
	private JFormattedTextField formattedTextField_13;
	private JFormattedTextField formattedTextField_14;
	private JFormattedTextField formattedTextField_15; // Start PdrDev number
	private int[] MSSlot = new int[] {8,24,37,50,63,76,88,101,114,127,141,154,167,180,193,206,219,232,245,258,271,284,297,310,323,336,349,364};
	
	private JLabel[] MSboard = new JLabel[20];
	private JLabel[] MSlabel = new JLabel[28];

	private JLabel[] ES1board = new JLabel[24];
	private JLabel[] ES1label = new JLabel[28];

	private JLabel[] ES2board = new JLabel[24];
	private JLabel[] ES2label = new JLabel[28];
	
	private JLabel ES3Label_3;
	private JLabel ES3Label_4;
	private JLabel ES3Label_5;
	private JLabel ES3Label_6;
	private JLabel ES3Label_7;
	private JLabel ES3Label_8;
	private JLabel ES3Label_9;
	private JLabel ES3Label_10;
	private JLabel ES3Label_11;
	private JLabel ES3Label_12;
	private JLabel ES3Label_13;
	private JLabel ES3Label_14;
	private JLabel ES3Label_15;
	private JLabel ES3Label_16;
	private JLabel ES3Label_17;
	private JLabel ES3Label_18;
	private JLabel ES3Label_19;
	private JLabel ES3Label_20;
	private JLabel ES3Label_21;
	private JLabel ES3Label_22;
	private JLabel ES3Label_23;
	private JLabel ES3Label_24;
	private JLabel ES3Label_25;
	private JLabel ES3Label_26;
	private JLabel ES4Label_3;
	private JLabel ES4Label_4;
	private JLabel ES4Label_5;
	private JLabel ES4Label_6;
	private JLabel ES4Label_7;
	private JLabel ES4Label_8;
	private JLabel ES4Label_9;
	private JLabel ES4Label_10;
	private JLabel ES4Label_11;
	private JLabel ES4Label_12;
	private JLabel ES4Label_13;
	private JLabel ES4Label_14;
	private JLabel ES4Label_15;
	private JLabel ES4Label_16;
	private JLabel ES4Label_17;
	private JLabel ES4Label_18;
	private JLabel ES4Label_19;
	private JLabel ES4Label_20;
	private JLabel ES4Label_21;
	private JLabel ES4Label_22;
	private JLabel ES4Label_23;
	private JLabel ES4Label_24;
	private JLabel ES4Label_25;
	private JLabel ES4Label_26;
	private JLabel ES5Label_3;
	private JLabel ES5Label_4;
	private JLabel ES5Label_5;
	private JLabel ES5Label_6;
	private JLabel ES5Label_7;
	private JLabel ES5Label_8;
	private JLabel ES5Label_9;
	private JLabel ES5Label_10;
	private JLabel ES5Label_11;
	private JLabel ES5Label_12;
	private JLabel ES5Label_13;
	private JLabel ES5Label_14;
	private JLabel ES5Label_15;
	private JLabel ES5Label_16;
	private JLabel ES5Label_17;
	private JLabel ES5Label_18;
	private JLabel ES5Label_19;
	private JLabel ES5Label_20;
	private JLabel ES5Label_21;
	private JLabel ES5Label_22;
	private JLabel ES5Label_23;
	private JLabel ES5Label_24;
	private JLabel ES5Label_25;
	private JLabel ES5Label_26;
	public ImageIcon Board =  new ImageIcon(rncMain.class.getResource("/images/Board.png"));
	public ImageIcon Board_over =  new ImageIcon(rncMain.class.getResource("/images/Board_over.png"));
	public ImageIcon Board_selected =  new ImageIcon(rncMain.class.getResource("/images/Board_selected.png"));
	public static prjRNC RNC = new prjRNC(); 
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					rncMain window = new rncMain();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public rncMain() {
		initialize();
	}
	
	public int getNetPref(int index){
		//"17 - 255.255.128.0" - 0
		//"18 - 255.255.192.0" - 1
		//"19 - 255.255.224.0" - 2
		//"20 - 255.255.240.0" - 3
		//"21 - 255.255.248.0" - 4
		//"22 - 255.255.252.0" - 5
		//"23 - 255.255.254.0" - 6
		//"24 - 255.255.255.0" - 7
		//25 - 255.255.255.128" - 8
		//26 - 255.255.255.192" - 9
		//27 - 255.255.255.224" - 10
		//28 - 255.255.255.240" -11		
		int[] net = new int[] {17,18,19,20,21,22,23,24,25,26,27,28};
		if (index < 12){
			return net[index];
		}
		return -1;
	}
	
	private static String get_col(String line, String Delemiter, int numcol) {
		String col = "";
		int count = 0;
		StringTokenizer st = new StringTokenizer(line, Delemiter, true);
		while (st.hasMoreTokens()) {
			col = st.nextToken().trim();
			if ((!col.equals("")) && (!col.equals(Delemiter))) {
				count++;
				if (count == numcol) {
					return col;
				}
			}
		}
		return "";
	}
	
	private List<String> getIPList(String ipFrom, String ipTo){
		List<String> ipArray = new ArrayList<String>();
		String prefix = get_col(ipFrom,".",1)+"."+get_col(ipFrom,".",2)+"."+get_col(ipFrom,".",3)+".";
		int StartIP = Integer.parseInt(get_col(ipFrom,".",4));
		int StopIP = Integer.parseInt(get_col(ipTo,".",4));
		while (StartIP < StopIP+1){
			ipArray.add(prefix+String.valueOf(StartIP));
			StartIP++;
		}
		return ipArray;
	}
	
	public void fillSlotData(){
		// CS
		String csLeft_DGW =  formattedTextField.getText();
		String csRight_DGW = formattedTextField_1.getText();
		int csNetPrefix = getNetPref(comboBox.getSelectedIndex()); // index in combobox meen 8 == 24
		String csIPfrom = formattedTextField_2.getText();
		String csIPto = formattedTextField_3.getText();
		String csVLAN = formattedTextField_8.getText();
		List<String> CSIPRange = getIPList(csIPfrom,csIPto); 
		// PS
		String psLeft_DGW = formattedTextField_4.getText();
		String psRight_DGW = formattedTextField_5.getText();
		int psNetPrefix = getNetPref(comboBox_1.getSelectedIndex()); // index in combobox meen 8 == 24
		String psIPfrom = formattedTextField_6.getText();
		String psIPto = formattedTextField_7.getText();
		String psVLAN = formattedTextField_9.getText();
		List<String> PSIPRange = getIPList(psIPfrom,psIPto);
		// IUB
		String iubLeft_DGW = formattedTextField_10.getText();
		String iubRight_DGW = formattedTextField_11.getText();
		int iubNetPrefix = getNetPref(comboBox_2.getSelectedIndex()); //index in combobox meen 8 == 24
		String iubIPfrom = formattedTextField_12.getText();
		String iubIPto = formattedTextField_13.getText();
		String iubVLAN = formattedTextField_14.getText();
		List<String> iubIPRange = getIPList(iubIPfrom,iubIPto);
		// Fill data
		// MS
		int indexCS = 0;
		int indexPS = 0;
		int indexIub = 0;
		int prdNum = Integer.parseInt(formattedTextField_15.getText());
		for(int i = 0; i < RNC.get_MS_Count(); i++){
			//CS
			RNC.get_MS_SlotData(i).set_IurNetworkPrefix(String.valueOf(csNetPrefix));
			RNC.get_MS_SlotData(i).set_VlanCS(csVLAN);
			RNC.get_MS_SlotData(i).set_pIurIP(CSIPRange.get(indexCS));
			indexCS++;
			RNC.get_MS_SlotData(i).set_sIurIP(CSIPRange.get(indexCS));
			indexCS++;
			RNC.get_MS_SlotData(i).set_VlanCS(csVLAN);
			//PS
			RNC.get_MS_SlotData(i).set_IuPSNetworkPrefix(String.valueOf(psNetPrefix));
			RNC.get_MS_SlotData(i).set_VlanPS(psVLAN);
			RNC.get_MS_SlotData(i).set_IuPSIP(PSIPRange.get(indexPS));
			indexPS++;
			//IUB
			RNC.get_MS_SlotData(i).set_IubNetworkPrefix(String.valueOf(iubNetPrefix));
			RNC.get_MS_SlotData(i).set_VlanIUB(iubVLAN);
			RNC.get_MS_SlotData(i).set_pIubIP(iubIPRange.get(indexIub));
			indexIub++;
			RNC.get_MS_SlotData(i).set_sIubIP(iubIPRange.get(indexIub));
			indexIub++;
			int Slot = Integer.parseInt(RNC.get_MS_SlotData(i).get_Slot());
			if (Slot < 15){
				RNC.get_MS_SlotData(i).set_lurDefaultGW(csLeft_DGW);
				RNC.get_MS_SlotData(i).set_luPSDefaultGW(psLeft_DGW);
				RNC.get_MS_SlotData(i).set_IubDefaultGW(iubLeft_DGW);
				RNC.get_MS_SlotData(i).set_linkPriority(0);
			}else{
				RNC.get_MS_SlotData(i).set_lurDefaultGW(csRight_DGW);
				RNC.get_MS_SlotData(i).set_luPSDefaultGW(psRight_DGW);
				RNC.get_MS_SlotData(i).set_IubDefaultGW(iubRight_DGW);
				RNC.get_MS_SlotData(i).set_linkPriority(1);
			}
			RNC.get_MS_SlotData(i).set_PdrNum(String.valueOf(prdNum));
			prdNum++;
		}
		for(int i = 0; i < RNC.get_ES1_Count(); i++){
			//CS
			RNC.get_ES1_SlotData(i).set_IurNetworkPrefix(String.valueOf(csNetPrefix));
			RNC.get_ES1_SlotData(i).set_VlanCS(csVLAN);
			RNC.get_ES1_SlotData(i).set_pIurIP(CSIPRange.get(indexCS));
			indexCS++;
			RNC.get_ES1_SlotData(i).set_sIurIP(CSIPRange.get(indexCS));
			indexCS++;
			RNC.get_ES1_SlotData(i).set_VlanCS(csVLAN);
			//PS
			RNC.get_ES1_SlotData(i).set_IuPSNetworkPrefix(String.valueOf(psNetPrefix));
			RNC.get_ES1_SlotData(i).set_VlanPS(psVLAN);
			RNC.get_ES1_SlotData(i).set_IuPSIP(PSIPRange.get(indexPS));
			indexPS++;
			//IUB
			RNC.get_ES1_SlotData(i).set_IubNetworkPrefix(String.valueOf(iubNetPrefix));
			RNC.get_ES1_SlotData(i).set_VlanIUB(iubVLAN);
			RNC.get_ES1_SlotData(i).set_pIubIP(iubIPRange.get(indexIub));
			indexIub++;
			RNC.get_ES1_SlotData(i).set_sIubIP(iubIPRange.get(indexIub));
			indexIub++;
			int Slot = Integer.parseInt(RNC.get_ES1_SlotData(i).get_Slot());
			if (Slot < 15){
				RNC.get_ES1_SlotData(i).set_lurDefaultGW(csLeft_DGW);
				RNC.get_ES1_SlotData(i).set_luPSDefaultGW(psLeft_DGW);
				RNC.get_ES1_SlotData(i).set_IubDefaultGW(iubLeft_DGW);
				RNC.get_ES1_SlotData(i).set_linkPriority(0);
			}else{
				RNC.get_ES1_SlotData(i).set_lurDefaultGW(csRight_DGW);
				RNC.get_ES1_SlotData(i).set_luPSDefaultGW(psRight_DGW);
				RNC.get_ES1_SlotData(i).set_IubDefaultGW(iubRight_DGW);
				RNC.get_ES1_SlotData(i).set_linkPriority(1);
			}
			RNC.get_ES1_SlotData(i).set_PdrNum(String.valueOf(prdNum));
			prdNum++;
		}
		for(int i = 0; i < RNC.get_ES2_Count(); i++){
			//CS
			RNC.get_ES2_SlotData(i).set_IurNetworkPrefix(String.valueOf(csNetPrefix));
			RNC.get_ES2_SlotData(i).set_VlanCS(csVLAN);
			RNC.get_ES2_SlotData(i).set_pIurIP(CSIPRange.get(indexCS));
			indexCS++;
			RNC.get_ES2_SlotData(i).set_sIurIP(CSIPRange.get(indexCS));
			indexCS++;
			RNC.get_ES2_SlotData(i).set_VlanCS(csVLAN);
			//PS
			RNC.get_ES2_SlotData(i).set_IuPSNetworkPrefix(String.valueOf(psNetPrefix));
			RNC.get_ES2_SlotData(i).set_VlanPS(psVLAN);
			RNC.get_ES2_SlotData(i).set_IuPSIP(PSIPRange.get(indexPS));
			indexPS++;
			//IUB
			RNC.get_ES2_SlotData(i).set_IubNetworkPrefix(String.valueOf(iubNetPrefix));
			RNC.get_ES2_SlotData(i).set_VlanIUB(iubVLAN);
			RNC.get_ES2_SlotData(i).set_pIubIP(iubIPRange.get(indexIub));
			indexIub++;
			RNC.get_ES2_SlotData(i).set_sIubIP(iubIPRange.get(indexIub));
			indexIub++;
			int Slot = Integer.parseInt(RNC.get_ES2_SlotData(i).get_Slot());
			if (Slot < 15){
				RNC.get_ES2_SlotData(i).set_lurDefaultGW(csLeft_DGW);
				RNC.get_ES2_SlotData(i).set_luPSDefaultGW(psLeft_DGW);
				RNC.get_ES2_SlotData(i).set_IubDefaultGW(iubLeft_DGW);
				RNC.get_ES2_SlotData(i).set_linkPriority(0);
			}else{
				RNC.get_ES2_SlotData(i).set_lurDefaultGW(csRight_DGW);
				RNC.get_ES2_SlotData(i).set_luPSDefaultGW(psRight_DGW);
				RNC.get_ES2_SlotData(i).set_IubDefaultGW(iubRight_DGW);
				RNC.get_ES2_SlotData(i).set_linkPriority(1);
			}
			RNC.get_ES2_SlotData(i).set_PdrNum(String.valueOf(prdNum));
			prdNum++;
		}
		for(int i = 0; i < RNC.get_ES3_Count(); i++){
			//CS
			RNC.get_ES3_SlotData(i).set_IurNetworkPrefix(String.valueOf(csNetPrefix));
			RNC.get_ES3_SlotData(i).set_VlanCS(csVLAN);
			RNC.get_ES3_SlotData(i).set_pIurIP(CSIPRange.get(indexCS));
			indexCS++;
			RNC.get_ES3_SlotData(i).set_sIurIP(CSIPRange.get(indexCS));
			indexCS++;
			RNC.get_ES3_SlotData(i).set_VlanCS(csVLAN);
			//PS
			RNC.get_ES3_SlotData(i).set_IuPSNetworkPrefix(String.valueOf(psNetPrefix));
			RNC.get_ES3_SlotData(i).set_VlanPS(psVLAN);
			RNC.get_ES3_SlotData(i).set_IuPSIP(PSIPRange.get(indexPS));
			indexPS++;
			//IUB
			RNC.get_ES3_SlotData(i).set_IubNetworkPrefix(String.valueOf(iubNetPrefix));
			RNC.get_ES3_SlotData(i).set_VlanIUB(iubVLAN);
			RNC.get_ES3_SlotData(i).set_pIubIP(iubIPRange.get(indexIub));
			indexIub++;
			RNC.get_ES3_SlotData(i).set_sIubIP(iubIPRange.get(indexIub));
			indexIub++;
			int Slot = Integer.parseInt(RNC.get_ES3_SlotData(i).get_Slot());
			if (Slot < 15){
				RNC.get_ES3_SlotData(i).set_lurDefaultGW(csLeft_DGW);
				RNC.get_ES3_SlotData(i).set_luPSDefaultGW(psLeft_DGW);
				RNC.get_ES3_SlotData(i).set_IubDefaultGW(iubLeft_DGW);
				RNC.get_ES3_SlotData(i).set_linkPriority(0);
			}else{
				RNC.get_ES3_SlotData(i).set_lurDefaultGW(csRight_DGW);
				RNC.get_ES3_SlotData(i).set_luPSDefaultGW(psRight_DGW);
				RNC.get_ES3_SlotData(i).set_IubDefaultGW(iubRight_DGW);
				RNC.get_ES3_SlotData(i).set_linkPriority(1);
			}
			RNC.get_ES3_SlotData(i).set_PdrNum(String.valueOf(prdNum));
			prdNum++;
		}
		for(int i = 0; i < RNC.get_ES4_Count(); i++){
			//CS
			RNC.get_ES4_SlotData(i).set_IurNetworkPrefix(String.valueOf(csNetPrefix));
			RNC.get_ES4_SlotData(i).set_VlanCS(csVLAN);
			RNC.get_ES4_SlotData(i).set_pIurIP(CSIPRange.get(indexCS));
			indexCS++;
			RNC.get_ES4_SlotData(i).set_sIurIP(CSIPRange.get(indexCS));
			indexCS++;
			RNC.get_ES4_SlotData(i).set_VlanCS(csVLAN);
			//PS
			RNC.get_ES4_SlotData(i).set_IuPSNetworkPrefix(String.valueOf(psNetPrefix));
			RNC.get_ES4_SlotData(i).set_VlanPS(psVLAN);
			RNC.get_ES4_SlotData(i).set_IuPSIP(PSIPRange.get(indexPS));
			indexPS++;
			//IUB
			RNC.get_ES4_SlotData(i).set_IubNetworkPrefix(String.valueOf(iubNetPrefix));
			RNC.get_ES4_SlotData(i).set_VlanIUB(iubVLAN);
			RNC.get_ES4_SlotData(i).set_pIubIP(iubIPRange.get(indexIub));
			indexIub++;
			RNC.get_ES4_SlotData(i).set_sIubIP(iubIPRange.get(indexIub));
			indexIub++;
			int Slot = Integer.parseInt(RNC.get_ES4_SlotData(i).get_Slot());
			if (Slot < 15){
				RNC.get_ES4_SlotData(i).set_lurDefaultGW(csLeft_DGW);
				RNC.get_ES4_SlotData(i).set_luPSDefaultGW(psLeft_DGW);
				RNC.get_ES4_SlotData(i).set_IubDefaultGW(iubLeft_DGW);
				RNC.get_ES4_SlotData(i).set_linkPriority(0);
			}else{
				RNC.get_ES4_SlotData(i).set_lurDefaultGW(csRight_DGW);
				RNC.get_ES4_SlotData(i).set_luPSDefaultGW(psRight_DGW);
				RNC.get_ES4_SlotData(i).set_IubDefaultGW(iubRight_DGW);
				RNC.get_ES4_SlotData(i).set_linkPriority(1);
			}
			RNC.get_ES4_SlotData(i).set_PdrNum(String.valueOf(prdNum));
			prdNum++;
		}
		for(int i = 0; i < RNC.get_ES5_Count(); i++){
			//CS
			RNC.get_ES5_SlotData(i).set_IurNetworkPrefix(String.valueOf(csNetPrefix));
			RNC.get_ES5_SlotData(i).set_VlanCS(csVLAN);
			RNC.get_ES5_SlotData(i).set_pIurIP(CSIPRange.get(indexCS));
			indexCS++;
			RNC.get_ES5_SlotData(i).set_sIurIP(CSIPRange.get(indexCS));
			indexCS++;
			RNC.get_ES5_SlotData(i).set_VlanCS(csVLAN);
			//PS
			RNC.get_ES5_SlotData(i).set_IuPSNetworkPrefix(String.valueOf(psNetPrefix));
			RNC.get_ES5_SlotData(i).set_VlanPS(psVLAN);
			RNC.get_ES5_SlotData(i).set_IuPSIP(PSIPRange.get(indexPS));
			indexPS++;
			//IUB
			RNC.get_ES5_SlotData(i).set_IubNetworkPrefix(String.valueOf(iubNetPrefix));
			RNC.get_ES5_SlotData(i).set_VlanIUB(iubVLAN);
			RNC.get_ES5_SlotData(i).set_pIubIP(iubIPRange.get(indexIub));
			indexIub++;
			RNC.get_ES5_SlotData(i).set_sIubIP(iubIPRange.get(indexIub));
			indexIub++;
			int Slot = Integer.parseInt(RNC.get_ES5_SlotData(i).get_Slot());
			if (Slot < 15){
				RNC.get_ES5_SlotData(i).set_lurDefaultGW(csLeft_DGW);
				RNC.get_ES5_SlotData(i).set_luPSDefaultGW(psLeft_DGW);
				RNC.get_ES5_SlotData(i).set_IubDefaultGW(iubLeft_DGW);
				RNC.get_ES5_SlotData(i).set_linkPriority(0);
			}else{
				RNC.get_ES5_SlotData(i).set_lurDefaultGW(csRight_DGW);
				RNC.get_ES5_SlotData(i).set_luPSDefaultGW(psRight_DGW);
				RNC.get_ES5_SlotData(i).set_IubDefaultGW(iubRight_DGW);
				RNC.get_ES5_SlotData(i).set_linkPriority(1);
			}
			RNC.get_ES5_SlotData(i).set_PdrNum(String.valueOf(prdNum));
			prdNum++;
		}
	}
	
	public void refresh_slot_data() {
		for(int i=0; i < 20; i++) MSboard[i].setIcon(Board);
		for(int i=0; i < 24; i++) ES1board[i].setIcon(Board);
		for(int i=0; i < 24; i++) ES2board[i].setIcon(Board);

		 ES3Label_3.setIcon(Board);
		 ES3Label_4.setIcon(Board);
		 ES3Label_5.setIcon(Board);
		 ES3Label_6.setIcon(Board);	
		 ES3Label_7.setIcon(Board);	
		 ES3Label_8.setIcon(Board);	
		 ES3Label_9.setIcon(Board);
		 ES3Label_10.setIcon(Board);
		 ES3Label_11.setIcon(Board);
		 ES3Label_12.setIcon(Board);
		 ES3Label_13.setIcon(Board);
		 ES3Label_14.setIcon(Board);
		 ES3Label_15.setIcon(Board);
		 ES3Label_16.setIcon(Board);
		 ES3Label_17.setIcon(Board);
		 ES3Label_18.setIcon(Board);
		 ES3Label_19.setIcon(Board);
		 ES3Label_20.setIcon(Board);
		 ES3Label_21.setIcon(Board);
		 ES3Label_22.setIcon(Board);
		 ES3Label_23.setIcon(Board);
		 ES3Label_24.setIcon(Board);
		 ES3Label_25.setIcon(Board);
		 ES3Label_26.setIcon(Board);
		 ES4Label_3.setIcon(Board);
		 ES4Label_4.setIcon(Board);
		 ES4Label_5.setIcon(Board);
		 ES4Label_6.setIcon(Board);	
		 ES4Label_7.setIcon(Board);	
		 ES4Label_8.setIcon(Board);	
		 ES4Label_9.setIcon(Board);
		 ES4Label_10.setIcon(Board);
		 ES4Label_11.setIcon(Board);
		 ES4Label_12.setIcon(Board);
		 ES4Label_13.setIcon(Board);
		 ES4Label_14.setIcon(Board);
		 ES4Label_15.setIcon(Board);
		 ES4Label_16.setIcon(Board);
		 ES4Label_17.setIcon(Board);
		 ES4Label_18.setIcon(Board);
		 ES4Label_19.setIcon(Board);
		 ES4Label_20.setIcon(Board);
		 ES4Label_21.setIcon(Board);
		 ES4Label_22.setIcon(Board);
		 ES4Label_23.setIcon(Board);
		 ES4Label_24.setIcon(Board);
		 ES4Label_25.setIcon(Board);
		 ES4Label_26.setIcon(Board);
		 ES5Label_3.setIcon(Board);
		 ES5Label_4.setIcon(Board);
		 ES5Label_5.setIcon(Board);
		 ES5Label_6.setIcon(Board);	
		 ES5Label_7.setIcon(Board);	
		 ES5Label_8.setIcon(Board);	
		 ES5Label_9.setIcon(Board);
		 ES5Label_10.setIcon(Board);
		 ES5Label_11.setIcon(Board);
		 ES5Label_12.setIcon(Board);
		 ES5Label_13.setIcon(Board);
		 ES5Label_14.setIcon(Board);
		 ES5Label_15.setIcon(Board);
		 ES5Label_16.setIcon(Board);
		 ES5Label_17.setIcon(Board);
		 ES5Label_18.setIcon(Board);
		 ES5Label_19.setIcon(Board);
		 ES5Label_20.setIcon(Board);
		 ES5Label_21.setIcon(Board);
		 ES5Label_22.setIcon(Board);
		 ES5Label_23.setIcon(Board);
		 ES5Label_24.setIcon(Board);
		 ES5Label_25.setIcon(Board);
		 ES5Label_26.setIcon(Board);
		for (int i = 0; i < RNC.get_MS_Count(); i++){	
			int slotNo = Integer.parseInt(RNC.get_MS_SlotData(i).get_Slot());
			MSboard[slotNo-5].setIcon(Board_selected);
		}
		
		for (int i = 0; i < RNC.get_ES1_Count(); i++){
			int slotNo = Integer.parseInt(RNC.get_ES1_SlotData(i).get_Slot());
			ES1board[slotNo-3].setIcon(Board_selected);
		}
		for (int i = 0; i < RNC.get_ES2_Count(); i++){	
			int slotNo = Integer.parseInt(RNC.get_ES2_SlotData(i).get_Slot());
			ES2board[slotNo-3].setIcon(Board_selected);
		}
		for (int i = 0; i < RNC.get_ES3_Count(); i++){	
			if(RNC.get_ES3_SlotData(i).get_Slot().equalsIgnoreCase("3")) ES3Label_3.setIcon(Board_selected);
			if(RNC.get_ES3_SlotData(i).get_Slot().equalsIgnoreCase("4")) ES3Label_4.setIcon(Board_selected);
			if(RNC.get_ES3_SlotData(i).get_Slot().equalsIgnoreCase("5")) ES3Label_5.setIcon(Board_selected);
			if(RNC.get_ES3_SlotData(i).get_Slot().equalsIgnoreCase("6")) ES3Label_6.setIcon(Board_selected);	
			if(RNC.get_ES3_SlotData(i).get_Slot().equalsIgnoreCase("7")) ES3Label_7.setIcon(Board_selected);	
			if(RNC.get_ES3_SlotData(i).get_Slot().equalsIgnoreCase("8")) ES3Label_8.setIcon(Board_selected);	
			if(RNC.get_ES3_SlotData(i).get_Slot().equalsIgnoreCase("9")) ES3Label_9.setIcon(Board_selected);
			if(RNC.get_ES3_SlotData(i).get_Slot().equalsIgnoreCase("10")) ES3Label_10.setIcon(Board_selected);
			if(RNC.get_ES3_SlotData(i).get_Slot().equalsIgnoreCase("11")) ES3Label_11.setIcon(Board_selected);
			if(RNC.get_ES3_SlotData(i).get_Slot().equalsIgnoreCase("12")) ES3Label_12.setIcon(Board_selected);
			if(RNC.get_ES3_SlotData(i).get_Slot().equalsIgnoreCase("13")) ES3Label_13.setIcon(Board_selected);
			if(RNC.get_ES3_SlotData(i).get_Slot().equalsIgnoreCase("14")) ES3Label_14.setIcon(Board_selected);
			if(RNC.get_ES3_SlotData(i).get_Slot().equalsIgnoreCase("15")) ES3Label_15.setIcon(Board_selected);
			if(RNC.get_ES3_SlotData(i).get_Slot().equalsIgnoreCase("16")) ES3Label_16.setIcon(Board_selected);
			if(RNC.get_ES3_SlotData(i).get_Slot().equalsIgnoreCase("17")) ES3Label_17.setIcon(Board_selected);
			if(RNC.get_ES3_SlotData(i).get_Slot().equalsIgnoreCase("18")) ES3Label_18.setIcon(Board_selected);
			if(RNC.get_ES3_SlotData(i).get_Slot().equalsIgnoreCase("19")) ES3Label_19.setIcon(Board_selected);
			if(RNC.get_ES3_SlotData(i).get_Slot().equalsIgnoreCase("20")) ES3Label_20.setIcon(Board_selected);
			if(RNC.get_ES3_SlotData(i).get_Slot().equalsIgnoreCase("21")) ES3Label_21.setIcon(Board_selected);
			if(RNC.get_ES3_SlotData(i).get_Slot().equalsIgnoreCase("22")) ES3Label_22.setIcon(Board_selected);
			if(RNC.get_ES3_SlotData(i).get_Slot().equalsIgnoreCase("23")) ES3Label_23.setIcon(Board_selected);
			if(RNC.get_ES3_SlotData(i).get_Slot().equalsIgnoreCase("24")) ES3Label_24.setIcon(Board_selected);
			if(RNC.get_ES3_SlotData(i).get_Slot().equalsIgnoreCase("25")) ES3Label_25.setIcon(Board_selected);
			if(RNC.get_ES3_SlotData(i).get_Slot().equalsIgnoreCase("26")) ES3Label_26.setIcon(Board_selected);
		}
		for (int i = 0; i < RNC.get_ES4_Count(); i++){	
			if(RNC.get_ES4_SlotData(i).get_Slot().equalsIgnoreCase("3")) ES4Label_3.setIcon(Board_selected);
			if(RNC.get_ES4_SlotData(i).get_Slot().equalsIgnoreCase("4")) ES4Label_4.setIcon(Board_selected);
			if(RNC.get_ES4_SlotData(i).get_Slot().equalsIgnoreCase("5")) ES4Label_5.setIcon(Board_selected);
			if(RNC.get_ES4_SlotData(i).get_Slot().equalsIgnoreCase("6")) ES4Label_6.setIcon(Board_selected);	
			if(RNC.get_ES4_SlotData(i).get_Slot().equalsIgnoreCase("7")) ES4Label_7.setIcon(Board_selected);	
			if(RNC.get_ES4_SlotData(i).get_Slot().equalsIgnoreCase("8")) ES4Label_8.setIcon(Board_selected);	
			if(RNC.get_ES4_SlotData(i).get_Slot().equalsIgnoreCase("9")) ES4Label_9.setIcon(Board_selected);
			if(RNC.get_ES4_SlotData(i).get_Slot().equalsIgnoreCase("10")) ES4Label_10.setIcon(Board_selected);
			if(RNC.get_ES4_SlotData(i).get_Slot().equalsIgnoreCase("11")) ES4Label_11.setIcon(Board_selected);
			if(RNC.get_ES4_SlotData(i).get_Slot().equalsIgnoreCase("12")) ES4Label_12.setIcon(Board_selected);
			if(RNC.get_ES4_SlotData(i).get_Slot().equalsIgnoreCase("13")) ES4Label_13.setIcon(Board_selected);
			if(RNC.get_ES4_SlotData(i).get_Slot().equalsIgnoreCase("14")) ES4Label_14.setIcon(Board_selected);
			if(RNC.get_ES4_SlotData(i).get_Slot().equalsIgnoreCase("15")) ES4Label_15.setIcon(Board_selected);
			if(RNC.get_ES4_SlotData(i).get_Slot().equalsIgnoreCase("16")) ES4Label_16.setIcon(Board_selected);
			if(RNC.get_ES4_SlotData(i).get_Slot().equalsIgnoreCase("17")) ES4Label_17.setIcon(Board_selected);
			if(RNC.get_ES4_SlotData(i).get_Slot().equalsIgnoreCase("18")) ES4Label_18.setIcon(Board_selected);
			if(RNC.get_ES4_SlotData(i).get_Slot().equalsIgnoreCase("19")) ES4Label_19.setIcon(Board_selected);
			if(RNC.get_ES4_SlotData(i).get_Slot().equalsIgnoreCase("20")) ES4Label_20.setIcon(Board_selected);
			if(RNC.get_ES4_SlotData(i).get_Slot().equalsIgnoreCase("21")) ES4Label_21.setIcon(Board_selected);
			if(RNC.get_ES4_SlotData(i).get_Slot().equalsIgnoreCase("22")) ES4Label_22.setIcon(Board_selected);
			if(RNC.get_ES4_SlotData(i).get_Slot().equalsIgnoreCase("23")) ES4Label_23.setIcon(Board_selected);
			if(RNC.get_ES4_SlotData(i).get_Slot().equalsIgnoreCase("24")) ES4Label_24.setIcon(Board_selected);
			if(RNC.get_ES4_SlotData(i).get_Slot().equalsIgnoreCase("25")) ES4Label_25.setIcon(Board_selected);
			if(RNC.get_ES4_SlotData(i).get_Slot().equalsIgnoreCase("26")) ES4Label_26.setIcon(Board_selected);
		}
		for (int i = 0; i < RNC.get_ES5_Count(); i++){	
			if(RNC.get_ES5_SlotData(i).get_Slot().equalsIgnoreCase("3")) ES5Label_3.setIcon(Board_selected);
			if(RNC.get_ES5_SlotData(i).get_Slot().equalsIgnoreCase("4")) ES5Label_4.setIcon(Board_selected);
			if(RNC.get_ES5_SlotData(i).get_Slot().equalsIgnoreCase("5")) ES5Label_5.setIcon(Board_selected);
			if(RNC.get_ES5_SlotData(i).get_Slot().equalsIgnoreCase("6")) ES5Label_6.setIcon(Board_selected);	
			if(RNC.get_ES5_SlotData(i).get_Slot().equalsIgnoreCase("7")) ES5Label_7.setIcon(Board_selected);	
			if(RNC.get_ES5_SlotData(i).get_Slot().equalsIgnoreCase("8")) ES5Label_8.setIcon(Board_selected);	
			if(RNC.get_ES5_SlotData(i).get_Slot().equalsIgnoreCase("9")) ES5Label_9.setIcon(Board_selected);
			if(RNC.get_ES5_SlotData(i).get_Slot().equalsIgnoreCase("10")) ES5Label_10.setIcon(Board_selected);
			if(RNC.get_ES5_SlotData(i).get_Slot().equalsIgnoreCase("11")) ES5Label_11.setIcon(Board_selected);
			if(RNC.get_ES5_SlotData(i).get_Slot().equalsIgnoreCase("12")) ES5Label_12.setIcon(Board_selected);
			if(RNC.get_ES5_SlotData(i).get_Slot().equalsIgnoreCase("13")) ES5Label_13.setIcon(Board_selected);
			if(RNC.get_ES5_SlotData(i).get_Slot().equalsIgnoreCase("14")) ES5Label_14.setIcon(Board_selected);
			if(RNC.get_ES5_SlotData(i).get_Slot().equalsIgnoreCase("15")) ES5Label_15.setIcon(Board_selected);
			if(RNC.get_ES5_SlotData(i).get_Slot().equalsIgnoreCase("16")) ES5Label_16.setIcon(Board_selected);
			if(RNC.get_ES5_SlotData(i).get_Slot().equalsIgnoreCase("17")) ES5Label_17.setIcon(Board_selected);
			if(RNC.get_ES5_SlotData(i).get_Slot().equalsIgnoreCase("18")) ES5Label_18.setIcon(Board_selected);
			if(RNC.get_ES5_SlotData(i).get_Slot().equalsIgnoreCase("19")) ES5Label_19.setIcon(Board_selected);
			if(RNC.get_ES5_SlotData(i).get_Slot().equalsIgnoreCase("20")) ES5Label_20.setIcon(Board_selected);
			if(RNC.get_ES5_SlotData(i).get_Slot().equalsIgnoreCase("21")) ES5Label_21.setIcon(Board_selected);
			if(RNC.get_ES5_SlotData(i).get_Slot().equalsIgnoreCase("22")) ES5Label_22.setIcon(Board_selected);
			if(RNC.get_ES5_SlotData(i).get_Slot().equalsIgnoreCase("23")) ES5Label_23.setIcon(Board_selected);
			if(RNC.get_ES5_SlotData(i).get_Slot().equalsIgnoreCase("24")) ES5Label_24.setIcon(Board_selected);
			if(RNC.get_ES5_SlotData(i).get_Slot().equalsIgnoreCase("25")) ES5Label_25.setIcon(Board_selected);
			if(RNC.get_ES5_SlotData(i).get_Slot().equalsIgnoreCase("26")) ES5Label_26.setIcon(Board_selected);
		}
		textField.setText(String.valueOf(RNC.get_Total_Board()));
		textField_1.setText(RNC.get_Total_Board_List());
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Advanced RNC Expansion Scripter  // By Roman Korchagin  // roman.korchagin@kyivstar.net");
		frame.setBounds(100, 100, 900, 650);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.SOUTH);
		
		JButton btnLoadProject = new JButton("Load Project");
		btnLoadProject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser FilleDLG = new JFileChooser();
				int resultDLG = FilleDLG.showOpenDialog(frame);
				if (resultDLG == JFileChooser.APPROVE_OPTION){
					File f = FilleDLG.getSelectedFile();
					String filePath = f.getPath();
					Gson gson = new Gson();
					try {
						//write converted json data to a file named "file.json"
						FileReader reader = new FileReader(filePath);
						//MyType target2 = gson.fromJson(json, MyType.class); // deserializes json into target2
						RNC = gson.fromJson(reader, prjRNC.class);						
						//gson.toJson(RNC,writer);					    						
						reader.close();
						//TODO
						formattedTextField.setText(RNC.get_cs_Left_GW());
						formattedTextField_1.setText(RNC.get_cs_Right_GW());
						comboBox.setSelectedIndex(RNC.get_cs_Net_Prefix());
						formattedTextField_2.setText(RNC.get_cs_IP_From());
						formattedTextField_3.setText(RNC.get_cs_IP_To());
						formattedTextField_8.setText(RNC.get_cs_VLAN());
						
						formattedTextField_4.setText(RNC.get_ps_Left_GW());
						formattedTextField_5.setText(RNC.get_ps_Right_GW());
						comboBox_1.setSelectedIndex(RNC.get_ps_Net_Prefix());
						formattedTextField_6.setText(RNC.get_ps_IP_From());
						formattedTextField_7.setText(RNC.get_ps_IP_To());
						formattedTextField_9.setText(RNC.get_ps_VLAN());
						
						formattedTextField_10.setText(RNC.get_iub_Left_GW());
						formattedTextField_11.setText(RNC.get_iub_Right_GW());
						comboBox_2.setSelectedIndex(RNC.get_iub_Net_Prefix());
						formattedTextField_12.setText(RNC.get_iub_IP_From());
						formattedTextField_13.setText(RNC.get_iub_IP_To());
						formattedTextField_14.setText(RNC.get_iub_VLAN());
						formattedTextField_15.setText(RNC.get_prd_num());
						refresh_slot_data();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		panel.add(btnLoadProject);
		
		JButton btnSaveProject = new JButton("Save Project");
		btnSaveProject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {			
				JFileChooser FilleDLG = new JFileChooser();
				int resultDLG = FilleDLG.showSaveDialog(frame);
				if ( resultDLG == JFileChooser.APPROVE_OPTION){
					File f = FilleDLG.getSelectedFile();
					String filePath = f.getPath();
					if (!filePath.toLowerCase().endsWith(".json")){
						filePath = filePath+".json";						
					}
					//
					RNC.set_cs_Left_GW(formattedTextField.getText());
					RNC.set_cs_Right_GW(formattedTextField_1.getText());
					RNC.set_cs_Net_Prefix(comboBox.getSelectedIndex());
					RNC.set_cs_IP_From(formattedTextField_2.getText());
					RNC.set_cs_IP_To(formattedTextField_3.getText());
					RNC.set_cs_VLAN(formattedTextField_8.getText());
					//
					RNC.set_ps_Left_GW(formattedTextField_4.getText());
					RNC.set_ps_Right_GW(formattedTextField_5.getText());
					RNC.set_ps_Net_Prefix(comboBox_1.getSelectedIndex());
					RNC.set_ps_IP_From(formattedTextField_6.getText());
					RNC.set_ps_IP_To(formattedTextField_7.getText());
					RNC.set_ps_VLAN(formattedTextField_9.getText());
					//
					RNC.set_iub_Left_GW(formattedTextField_10.getText());
					RNC.set_iub_Right_GW(formattedTextField_11.getText());
					RNC.set_iub_Net_Prefix(comboBox_2.getSelectedIndex());
					RNC.set_iub_IP_From(formattedTextField_12.getText());
					RNC.set_iub_IP_To(formattedTextField_13.getText());
					RNC.set_iub_VLAN(formattedTextField_14.getText());
					RNC.set_prd_num(formattedTextField_15.getText());
					//
					Gson gson = new Gson();
					try {
						//write converted json data to a file named "file.json"
						FileWriter writer = new FileWriter(filePath);
					    gson.toJson(RNC,writer);
					    
					    writer.flush();
					    writer.close();
				 
					} catch (IOException e) {
						e.printStackTrace();
					}

				}
			}
		});
		panel.add(btnSaveProject);
		
		JButton btnSaveCommandFile = new JButton("Save Create MO Command File");
		btnSaveCommandFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {	
				JFileChooser FilleDLG = new JFileChooser();
				int resultDLG = FilleDLG.showSaveDialog(frame);
				if ( resultDLG == JFileChooser.APPROVE_OPTION){
					File f = FilleDLG.getSelectedFile();
					String filePath = f.getPath();
					if (!filePath.toLowerCase().endsWith(".mo")){
						filePath = filePath+".mo";						
					}
						fillSlotData();
						RNCelevator.createCommandFile("create.tpl",filePath);
									
				}				
			}
		});
		panel.add(btnSaveCommandFile);
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setResizeWeight(0.3);
		frame.getContentPane().add(splitPane, BorderLayout.CENTER);
		
		Dimension minimumSize = new Dimension(450, 400);
		
		JPanel panel_1 = new JPanel();
		panel_1.setMinimumSize(minimumSize);
		splitPane.setLeftComponent(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3, BorderLayout.NORTH);
		
		JLabel lblCountOfBoard = new JLabel("Boards:");
		panel_3.add(lblCountOfBoard);
		
		textField = new JTextField();
		textField.setBorder(null);
		textField.setEditable(false);
		textField.setBackground(SystemColor.menu);
		panel_3.add(textField);
		textField.setColumns(3);
		
		JLabel lblSelectedSlots = new JLabel("    Selected Slots:");
		panel_3.add(lblSelectedSlots);
		
		textField_1 = new JTextField();
		textField_1.setBorder(null);
		textField_1.setEditable(false);
		textField_1.setBackground(SystemColor.menu);
		panel_3.add(textField_1);
		textField_1.setColumns(30);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		panel_1.add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("MS", null, panel_4, null);
		panel_4.setLayout(null);
		
		//
		JPanel panel_10 = new JPanel();
		panel_10.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_10.setBounds(10, 30, 392, 247);
		panel_4.add(panel_10);
		panel_10.setLayout(null);								
		
		JLabel MSLabel_1 = new JLabel("");
		MSLabel_1.setBounds(10, 27, 14, 193);
		panel_10.add(MSLabel_1);
		MSLabel_1.setIcon(new ImageIcon(rncMain.class.getResource("/images/SCXB3.png")));
		
		JLabel MSLabel_2 = new JLabel("");
		MSLabel_2.setBounds(23, 27, 14, 193);
		panel_10.add(MSLabel_2);
		MSLabel_2.setIcon(new ImageIcon(rncMain.class.getResource("/images/CMXB3.png")));
				
		JLabel MSLabel_3 = new JLabel("");
		MSLabel_3.setBounds(36, 27, 14, 193);
		panel_10.add(MSLabel_3);
		MSLabel_3.setIcon(new ImageIcon(rncMain.class.getResource("/images/inactive_Board.png")));
		
		JLabel MSLabel_4 = new JLabel("");
		MSLabel_4.setBounds(49, 27, 14, 193);
		panel_10.add(MSLabel_4);
		MSLabel_4.setIcon(new ImageIcon(rncMain.class.getResource("/images/inactive_Board.png")));
		
		
		
		MouseAdapter MSboardEv = new MouseAdapter(){
			@Override
			public void mouseExited(MouseEvent e) {
				JLabel atractor = (JLabel) e.getSource();
				for (int i = 0; i < MSboard.length; i++){
					if(atractor == MSboard[i]){
						if (RNC.get_MS_SlotData_byName(String.valueOf(i+5)) == -1){
							MSboard[i].setIcon(Board);
						}
					}
				}
				
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				JLabel atractor = (JLabel) e.getSource();
				for (int i = 0; i < MSboard.length; i++){
					if(atractor == MSboard[i]){
						if (RNC.get_MS_SlotData_byName(String.valueOf(i+5)) == -1){
							MSboard[i].setIcon(Board_selected);
							SlotData newBoard = new SlotData();
							newBoard.set_Slot(String.valueOf(i+5));
							RNC.add_MS_SlotData(newBoard);
							textField.setText(String.valueOf(RNC.get_Total_Board()));
							textField_1.setText(RNC.get_Total_Board_List());
						}else{
							MSboard[i].setIcon(Board);
							RNC.delete_MS_SlotData_byName(String.valueOf(i+5));
							textField.setText(String.valueOf(RNC.get_Total_Board()));
							textField_1.setText(RNC.get_Total_Board_List());
						}
					}
				}				
			}
		};
		
		MouseMotionAdapter MSboardMo = new MouseMotionAdapter(){
			@Override
			public void mouseMoved(MouseEvent e) {
				JLabel atractor = (JLabel) e.getSource();
				for (int i = 0; i < MSboard.length; i++){
					if(atractor == MSboard[i]){
						if (RNC.get_MS_SlotData_byName(String.valueOf(i+5)) == -1){
							MSboard[i].setIcon(Board_over);
						}
					}
				}
				
			}
		};
		
		
		int p = 62;
		for(int i=0; i<20; i++){
			MSboard[i] = new JLabel("");
			MSboard[i].addMouseListener(MSboardEv);
			MSboard[i].addMouseMotionListener(MSboardMo);
			MSboard[i].setBounds(p, 27, 14, 193);
			panel_10.add(MSboard[i]);
			MSboard[i].setIcon(Board);
			p+=13;
		}
		
		
		
		JLabel MSLabel_25 = new JLabel("");
		MSLabel_25.setIcon(new ImageIcon(rncMain.class.getResource("/images/inactive_Board.png")));
		MSLabel_25.setBounds(322, 27, 14, 193);
		panel_10.add(MSLabel_25);
		
		JLabel MSLabel_26 = new JLabel("");
		MSLabel_26.setIcon(new ImageIcon(rncMain.class.getResource("/images/inactive_Board.png")));
		MSLabel_26.setBounds(335, 27, 14, 193);
		panel_10.add(MSLabel_26);
		
		JLabel MSLabel_27 = new JLabel("");
		MSLabel_27.setIcon(new ImageIcon(rncMain.class.getResource("/images/SCXB3.png")));
		MSLabel_27.setBounds(348, 27, 14, 193);
		panel_10.add(MSLabel_27);
		
		JLabel MSLabel_28 = new JLabel("");
		MSLabel_28.setIcon(new ImageIcon(rncMain.class.getResource("/images/CMXB3.png")));
		MSLabel_28.setBounds(361, 27, 14, 193);
		panel_10.add(MSLabel_28);		
		
		
		// Fill label for MS subrack slot title
		for(int i=0; i<28; i++){
			MSlabel[i] = new JLabel(String.valueOf(i+1));
			if (i == 0 | i == 27)
				MSlabel[i].setFont(new Font("Vrinda", Font.PLAIN, 12));
			else if (i < 9)
				MSlabel[i].setFont(new Font("Vrinda", Font.PLAIN, 11));
			else
				MSlabel[i].setFont(new Font("Vrinda", Font.PLAIN, 10));
			if (i == 27)
				MSlabel[i].setBounds(MSSlot[i], 10, 14, 15);
			else
				MSlabel[i].setBounds(MSSlot[i], 10, 12, 15);
			panel_10.add(MSlabel[i]);
			MSlabel[i].setHorizontalAlignment(SwingConstants.CENTER);
		}		
								
		
		JLabel MSLabel = new JLabel("Subrack MS");
		MSLabel.setBounds(293, 231, 75, 14);
		panel_10.add(MSLabel);				
				
		/////////////////////////////////////////////////////////////////////////////////////////////
		JPanel panel_5 = new JPanel();
		tabbedPane.addTab("ES-1", null, panel_5, null);
		panel_5.setLayout(null);
		
		//
		JPanel panel_11 = new JPanel();
		panel_11.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_11.setBounds(10, 30, 392, 247);
		panel_5.add(panel_11);
		panel_11.setLayout(null);								
		
		JLabel ES1Label_1 = new JLabel("");
		ES1Label_1.setBounds(10, 27, 14, 193);
		panel_11.add(ES1Label_1);
		ES1Label_1.setIcon(new ImageIcon(rncMain.class.getResource("/images/SCXB3.png")));
		
		JLabel ES1Label_2 = new JLabel("");
		ES1Label_2.setBounds(23, 27, 14, 193);
		panel_11.add(ES1Label_2);
		ES1Label_2.setIcon(new ImageIcon(rncMain.class.getResource("/images/CMXB3.png")));
		
		MouseAdapter ES1boardEv = new MouseAdapter(){
			@Override
			public void mouseExited(MouseEvent e) {
				JLabel atractor = (JLabel) e.getSource();
				for (int i = 0; i < ES1board.length; i++){
					if(atractor == ES1board[i]){
						if (RNC.get_ES1_SlotData_byName(String.valueOf(i+3)) == -1){
							ES1board[i].setIcon(Board);
						}
					}
				}
				
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				JLabel atractor = (JLabel) e.getSource();
				for (int i = 0; i < ES1board.length; i++){
					if(atractor == ES1board[i]){
						if (RNC.get_ES1_SlotData_byName(String.valueOf(i+3)) == -1){
							ES1board[i].setIcon(Board_selected);
							SlotData newBoard = new SlotData();
							newBoard.set_Slot(String.valueOf(i+3));
							RNC.add_ES1_SlotData(newBoard);
							textField.setText(String.valueOf(RNC.get_Total_Board()));
							textField_1.setText(RNC.get_Total_Board_List());
						}else{
							ES1board[i].setIcon(Board);
							RNC.delete_ES1_SlotData_byName(String.valueOf(i+3));
							textField.setText(String.valueOf(RNC.get_Total_Board()));
							textField_1.setText(RNC.get_Total_Board_List());
						}
					}
				}				
			}
		};
		
		MouseMotionAdapter ES1boardMo = new MouseMotionAdapter(){
			@Override
			public void mouseMoved(MouseEvent e) {
				JLabel atractor = (JLabel) e.getSource();
				for (int i = 0; i < ES1board.length; i++){
					if(atractor == ES1board[i]){
						if (RNC.get_ES1_SlotData_byName(String.valueOf(i+3)) == -1){
							ES1board[i].setIcon(Board_over);
						}
					}
				}
				
			}
		};
		
		
		p = 36;
		for(int i=0; i<24; i++){
			ES1board[i] = new JLabel("");
			ES1board[i].addMouseListener(ES1boardEv);
			ES1board[i].addMouseMotionListener(ES1boardMo);
			ES1board[i].setBounds(p, 27, 14, 193);
			panel_11.add(ES1board[i]);
			ES1board[i].setIcon(Board);
			p+=13;
		}
						
		
		JLabel ES1Label_27 = new JLabel("");
		ES1Label_27.setIcon(new ImageIcon(rncMain.class.getResource("/images/SCXB3.png")));
		ES1Label_27.setBounds(348, 27, 14, 193);
		panel_11.add(ES1Label_27);
		
		JLabel ES1Label_28 = new JLabel("");
		ES1Label_28.setIcon(new ImageIcon(rncMain.class.getResource("/images/CMXB3.png")));
		ES1Label_28.setBounds(361, 27, 14, 193);
		panel_11.add(ES1Label_28);		
		
		
		// Fill label for ES1 subrack slot title
		for(int i=0; i<28; i++){
			ES1label[i] = new JLabel(String.valueOf(i+1));
			if (i == 0 | i == 27)
				ES1label[i].setFont(new Font("Vrinda", Font.PLAIN, 12));
			else if (i < 9)
				ES1label[i].setFont(new Font("Vrinda", Font.PLAIN, 11));
			else
				ES1label[i].setFont(new Font("Vrinda", Font.PLAIN, 10));
			if (i == 27)
				ES1label[i].setBounds(MSSlot[i], 10, 14, 15);
			else
				ES1label[i].setBounds(MSSlot[i], 10, 12, 15);
			panel_11.add(ES1label[i]);
			ES1label[i].setHorizontalAlignment(SwingConstants.CENTER);
		}							
		
		JLabel ES1Label = new JLabel("Subrack ES-1");
		ES1Label.setBounds(293, 231, 89, 14);
		panel_11.add(ES1Label);
		//////////////////////////////////////////////////////////////////////////////////////////////
		JPanel panel_6 = new JPanel();
		tabbedPane.addTab("ES-2", null, panel_6, null);
		//-
		panel_6.setLayout(null);
		
		//
		JPanel panel_12 = new JPanel();
		panel_12.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_12.setBounds(10, 30, 392, 247);
		panel_6.add(panel_12);
		panel_12.setLayout(null);								
		
		JLabel ES2Label_1 = new JLabel("");
		ES2Label_1.setBounds(10, 27, 14, 193);
		panel_12.add(ES2Label_1);
		ES2Label_1.setIcon(new ImageIcon(rncMain.class.getResource("/images/SCXB3.png")));
		
		JLabel ES2Label_2 = new JLabel("");
		ES2Label_2.setBounds(23, 27, 14, 193);
		panel_12.add(ES2Label_2);
		ES2Label_2.setIcon(new ImageIcon(rncMain.class.getResource("/images/CMXB3.png")));
		
		
		MouseAdapter ES2boardEv = new MouseAdapter(){
			@Override
			public void mouseExited(MouseEvent e) {
				JLabel atractor = (JLabel) e.getSource();
				for (int i = 0; i < ES2board.length; i++){
					if(atractor == ES2board[i]){
						if (RNC.get_ES2_SlotData_byName(String.valueOf(i+3)) == -1){
							ES2board[i].setIcon(Board);
						}
					}
				}
				
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				JLabel atractor = (JLabel) e.getSource();
				for (int i = 0; i < ES2board.length; i++){
					if(atractor == ES2board[i]){
						if (RNC.get_ES2_SlotData_byName(String.valueOf(i+3)) == -1){
							ES2board[i].setIcon(Board_selected);
							SlotData newBoard = new SlotData();
							newBoard.set_Slot(String.valueOf(i+3));
							RNC.add_ES2_SlotData(newBoard);
							textField.setText(String.valueOf(RNC.get_Total_Board()));
							textField_1.setText(RNC.get_Total_Board_List());
						}else{
							ES2board[i].setIcon(Board);
							RNC.delete_ES2_SlotData_byName(String.valueOf(i+3));
							textField.setText(String.valueOf(RNC.get_Total_Board()));
							textField_1.setText(RNC.get_Total_Board_List());
						}
					}
				}				
			}
		};
		
		MouseMotionAdapter ES2boardMo = new MouseMotionAdapter(){
			@Override
			public void mouseMoved(MouseEvent e) {
				JLabel atractor = (JLabel) e.getSource();
				for (int i = 0; i < ES2board.length; i++){
					if(atractor == ES2board[i]){
						if (RNC.get_ES2_SlotData_byName(String.valueOf(i+3)) == -1){
							ES2board[i].setIcon(Board_over);
						}
					}
				}
				
			}
		};
		
		
		p = 36;
		for(int i=0; i<24; i++){
			ES2board[i] = new JLabel("");
			ES2board[i].addMouseListener(ES2boardEv);
			ES2board[i].addMouseMotionListener(ES2boardMo);
			ES2board[i].setBounds(p, 27, 14, 193);
			panel_12.add(ES2board[i]);
			ES2board[i].setIcon(Board);
			p+=13;
		}
		
		
		
		JLabel ES2Label_27 = new JLabel("");
		ES2Label_27.setIcon(new ImageIcon(rncMain.class.getResource("/images/SCXB3.png")));
		ES2Label_27.setBounds(348, 27, 14, 193);
		panel_12.add(ES2Label_27);
		
		JLabel ES2Label_28 = new JLabel("");
		ES2Label_28.setIcon(new ImageIcon(rncMain.class.getResource("/images/CMXB3.png")));
		ES2Label_28.setBounds(361, 27, 14, 193);
		panel_12.add(ES2Label_28);
		
		// Fill label for ES1 subrack slot title
		for(int i=0; i<28; i++){
			ES2label[i] = new JLabel(String.valueOf(i+1));
			if (i == 0 | i == 27)
				ES2label[i].setFont(new Font("Vrinda", Font.PLAIN, 12));
			else if (i < 9)
				ES2label[i].setFont(new Font("Vrinda", Font.PLAIN, 11));
			else
				ES2label[i].setFont(new Font("Vrinda", Font.PLAIN, 10));
			if (i == 27)
				ES2label[i].setBounds(MSSlot[i], 10, 14, 15);
			else
				ES2label[i].setBounds(MSSlot[i], 10, 12, 15);
 			panel_12.add(ES2label[i]);
			ES2label[i].setHorizontalAlignment(SwingConstants.CENTER);
		}
						
		
		JLabel ES2Label = new JLabel("Subrack ES-2");
		ES2Label.setBounds(293, 231, 99, 14);
		panel_12.add(ES2Label);
		//////////////////////////////////////////////////////////////////////////////////////////////
		JPanel panel_7 = new JPanel();
		tabbedPane.addTab("ES-3", null, panel_7, null);
		// --
		panel_7.setLayout(null);
		
		JPanel panel_13 = new JPanel();
		panel_13.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_13.setBounds(10, 30, 392, 247);
		panel_7.add(panel_13);
		panel_13.setLayout(null);								
		
		JLabel ES3Label_1 = new JLabel("");
		ES3Label_1.setBounds(10, 27, 14, 193);
		panel_13.add(ES3Label_1);
		ES3Label_1.setIcon(new ImageIcon(rncMain.class.getResource("/images/SCXB3.png")));
		
		JLabel ES3Label_2 = new JLabel("");
		ES3Label_2.setBounds(23, 27, 14, 193);
		panel_13.add(ES3Label_2);
		ES3Label_2.setIcon(new ImageIcon(rncMain.class.getResource("/images/CMXB3.png")));
				
		  ES3Label_3 = new JLabel(""); //Slot 3
		ES3Label_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent arg0) {
				if (RNC.get_ES3_SlotData_byName("3") == -1){
					ES3Label_3.setIcon(Board);
				}
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (RNC.get_ES3_SlotData_byName("3") == -1){
					ES3Label_3.setIcon(Board_selected);
					SlotData newBoard = new SlotData();
					newBoard.set_Slot("3");
					RNC.add_ES3_SlotData(newBoard);
					textField.setText(String.valueOf(RNC.get_Total_Board()));
					textField_1.setText(RNC.get_Total_Board_List());
				}else{
					ES3Label_3.setIcon(Board);
					RNC.delete_ES3_SlotData_byName("3");
					textField.setText(String.valueOf(RNC.get_Total_Board()));
					textField_1.setText(RNC.get_Total_Board_List());
				}
			}
		});
		ES3Label_3.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
				if (RNC.get_ES3_SlotData_byName("3") == -1){
					ES3Label_3.setIcon(Board_over);
				}
			}
		});
		ES3Label_3.setBounds(36, 27, 14, 193);
		panel_13.add(ES3Label_3);
		ES3Label_3.setIcon(Board);
		
		  ES3Label_4 = new JLabel(""); //Slot 4
		ES3Label_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent arg0) {
				if (RNC.get_ES3_SlotData_byName("4") == -1){
					ES3Label_4.setIcon(Board);
				}
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (RNC.get_ES3_SlotData_byName("4") == -1){
					ES3Label_4.setIcon(Board_selected);
					SlotData newBoard = new SlotData();
					newBoard.set_Slot("4");
					RNC.add_ES3_SlotData(newBoard);
					textField.setText(String.valueOf(RNC.get_Total_Board()));
					textField_1.setText(RNC.get_Total_Board_List());
				}else{
					ES3Label_4.setIcon(Board);
					RNC.delete_ES3_SlotData_byName("4");
					textField.setText(String.valueOf(RNC.get_Total_Board()));
					textField_1.setText(RNC.get_Total_Board_List());
				}
			}
		});
		ES3Label_4.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
				if (RNC.get_ES3_SlotData_byName("4") == -1){
					ES3Label_4.setIcon(Board_over);
				}
			}
		});
		ES3Label_4.setBounds(49, 27, 14, 193);
		panel_13.add(ES3Label_4);
		ES3Label_4.setIcon(Board);
		
		
		  ES3Label_5 = new JLabel(""); //Slot 5
		ES3Label_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent arg0) {
				if (RNC.get_ES3_SlotData_byName("5") == -1){
					ES3Label_5.setIcon(Board);
				}
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (RNC.get_ES3_SlotData_byName("5") == -1){
					ES3Label_5.setIcon(Board_selected);
					SlotData newBoard = new SlotData();
					newBoard.set_Slot("5");
					RNC.add_ES3_SlotData(newBoard);
					textField.setText(String.valueOf(RNC.get_Total_Board()));
					textField_1.setText(RNC.get_Total_Board_List());
				}else{
					ES3Label_5.setIcon(Board);
					RNC.delete_ES3_SlotData_byName("5");
					textField.setText(String.valueOf(RNC.get_Total_Board()));
					textField_1.setText(RNC.get_Total_Board_List());
				}
			}
		});
		ES3Label_5.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
				if (RNC.get_ES3_SlotData_byName("5") == -1){
					ES3Label_5.setIcon(Board_over);
				}
			}
		});
		ES3Label_5.setBounds(62, 27, 14, 193);
		panel_13.add(ES3Label_5);
		ES3Label_5.setIcon(Board);
		
		  ES3Label_6 = new JLabel(""); //Slot 6
		ES3Label_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent arg0) {
				if (RNC.get_ES3_SlotData_byName("6") == -1){
					ES3Label_6.setIcon(Board);
				}
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (RNC.get_ES3_SlotData_byName("6") == -1){
					ES3Label_6.setIcon(Board_selected);
					SlotData newBoard = new SlotData();
					newBoard.set_Slot("6");
					RNC.add_ES3_SlotData(newBoard);
					textField.setText(String.valueOf(RNC.get_Total_Board()));
					textField_1.setText(RNC.get_Total_Board_List());
				}else{
					ES3Label_6.setIcon(Board);
					RNC.delete_ES3_SlotData_byName("6");
					textField.setText(String.valueOf(RNC.get_Total_Board()));
					textField_1.setText(RNC.get_Total_Board_List());
				}
			}
		});
		ES3Label_6.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
				if (RNC.get_ES3_SlotData_byName("6") == -1){
					ES3Label_6.setIcon(Board_over);
				}	
			}
		});
		ES3Label_6.setIcon(Board);		
		ES3Label_6.setBounds(75, 27, 14, 193);
		panel_13.add(ES3Label_6);
		
		  ES3Label_7 = new JLabel(""); //Slot 7
		ES3Label_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent arg0) {
				if (RNC.get_ES3_SlotData_byName("7") == -1){
					ES3Label_7.setIcon(Board);
				}
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (RNC.get_ES3_SlotData_byName("7") == -1){
					ES3Label_7.setIcon(Board_selected);
					SlotData newBoard = new SlotData();
					newBoard.set_Slot("7");
					RNC.add_ES3_SlotData(newBoard);
					textField.setText(String.valueOf(RNC.get_Total_Board()));
					textField_1.setText(RNC.get_Total_Board_List());
				}else{
					ES3Label_7.setIcon(Board);
					RNC.delete_ES3_SlotData_byName("7");
					textField.setText(String.valueOf(RNC.get_Total_Board()));
					textField_1.setText(RNC.get_Total_Board_List());
				}
			}
		});
		ES3Label_7.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
				if (RNC.get_ES3_SlotData_byName("7") == -1){
					ES3Label_7.setIcon(Board_over);
				}
			}
		});
		ES3Label_7.setIcon(Board);
		ES3Label_7.setBounds(88, 27, 14, 193);
		panel_13.add(ES3Label_7);
		
		  ES3Label_8 = new JLabel(""); // Slot 8
		ES3Label_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent arg0) {
				if (RNC.get_ES3_SlotData_byName("8") == -1){
					ES3Label_8.setIcon(Board);
				}	
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (RNC.get_ES3_SlotData_byName("8") == -1){
					ES3Label_8.setIcon(Board_selected);
					SlotData newBoard = new SlotData();
					newBoard.set_Slot("8");
					RNC.add_ES3_SlotData(newBoard);
					textField.setText(String.valueOf(RNC.get_Total_Board()));
					textField_1.setText(RNC.get_Total_Board_List());
				}else{
					ES3Label_8.setIcon(Board);
					RNC.delete_ES3_SlotData_byName("8");
					textField.setText(String.valueOf(RNC.get_Total_Board()));
					textField_1.setText(RNC.get_Total_Board_List());
				}
			}
		});
		ES3Label_8.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
				if (RNC.get_ES3_SlotData_byName("8") == -1){
					ES3Label_8.setIcon(Board_over);
				}	
			}
		});
		ES3Label_8.setIcon(Board);
		ES3Label_8.setBounds(101, 27, 14, 193);
		panel_13.add(ES3Label_8);
		
		  ES3Label_9 = new JLabel(""); // Slot 9
		ES3Label_9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent arg0) {
				if (RNC.get_ES3_SlotData_byName("9") == -1){
					ES3Label_9.setIcon(Board);
				}	
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (RNC.get_ES3_SlotData_byName("9") == -1){
					ES3Label_9.setIcon(Board_selected);
					SlotData newBoard = new SlotData();
					newBoard.set_Slot("9");
					RNC.add_ES3_SlotData(newBoard);
					textField.setText(String.valueOf(RNC.get_Total_Board()));
					textField_1.setText(RNC.get_Total_Board_List());
				}else{
					ES3Label_9.setIcon(Board);
					RNC.delete_ES3_SlotData_byName("9");
					textField.setText(String.valueOf(RNC.get_Total_Board()));
					textField_1.setText(RNC.get_Total_Board_List());
				}
			}
		});
		ES3Label_9.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
				if (RNC.get_ES3_SlotData_byName("9") == -1){
					ES3Label_9.setIcon(Board_over);
				}
			}
		});
		ES3Label_9.setIcon(Board);
		ES3Label_9.setBounds(114, 27, 14, 193);
		panel_13.add(ES3Label_9);
		
		  ES3Label_10 = new JLabel(""); // Slot 10
		ES3Label_10.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent arg0) {
				if (RNC.get_ES3_SlotData_byName("10") == -1){
					ES3Label_10.setIcon(Board);
				}
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (RNC.get_ES3_SlotData_byName("10") == -1){
					ES3Label_10.setIcon(Board_selected);
					SlotData newBoard = new SlotData();
					newBoard.set_Slot("10");
					RNC.add_ES3_SlotData(newBoard);
					textField.setText(String.valueOf(RNC.get_Total_Board()));
					textField_1.setText(RNC.get_Total_Board_List());
				}else{
					ES3Label_10.setIcon(Board);
					RNC.delete_ES3_SlotData_byName("10");
					textField.setText(String.valueOf(RNC.get_Total_Board()));
					textField_1.setText(RNC.get_Total_Board_List());
				}
			}
		});
		ES3Label_10.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
				if (RNC.get_ES3_SlotData_byName("10") == -1){
					ES3Label_10.setIcon(Board_over);
				}
			}
		});
		ES3Label_10.setIcon(Board);
		ES3Label_10.setBounds(127, 27, 14, 193);
		panel_13.add(ES3Label_10);
		
		  ES3Label_11 = new JLabel(""); //Slot 11
		ES3Label_11.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent arg0) {
				if (RNC.get_ES3_SlotData_byName("11") == -1){
					ES3Label_11.setIcon(Board);			
				}
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (RNC.get_ES3_SlotData_byName("11") == -1){
					ES3Label_11.setIcon(Board_selected);
					SlotData newBoard = new SlotData();
					newBoard.set_Slot("11");
					RNC.add_ES3_SlotData(newBoard);
					textField.setText(String.valueOf(RNC.get_Total_Board()));
					textField_1.setText(RNC.get_Total_Board_List());
				}else{
					ES3Label_11.setIcon(Board);
					RNC.delete_ES3_SlotData_byName("11");
					textField.setText(String.valueOf(RNC.get_Total_Board()));
					textField_1.setText(RNC.get_Total_Board_List());
				}
			}
		});
		ES3Label_11.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
				if (RNC.get_ES3_SlotData_byName("11") == -1){
					ES3Label_11.setIcon(Board_over);
				}
			}
		});
		ES3Label_11.setIcon(Board);
		ES3Label_11.setBounds(140, 27, 14, 193);
		panel_13.add(ES3Label_11);
		
		
		  ES3Label_12 = new JLabel(""); // Slot 12
		ES3Label_12.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent arg0) {
				if (RNC.get_ES3_SlotData_byName("12") == -1){
					ES3Label_12.setIcon(Board);
				}
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (RNC.get_ES3_SlotData_byName("12") == -1){
					ES3Label_12.setIcon(Board_selected);
					SlotData newBoard = new SlotData();
					newBoard.set_Slot("12");
					RNC.add_ES3_SlotData(newBoard);
					textField.setText(String.valueOf(RNC.get_Total_Board()));
					textField_1.setText(RNC.get_Total_Board_List());
				}else{
					ES3Label_12.setIcon(Board);
					RNC.delete_ES3_SlotData_byName("12");
					textField.setText(String.valueOf(RNC.get_Total_Board()));
					textField_1.setText(RNC.get_Total_Board_List());
				}
			}
		});
		ES3Label_12.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
				if (RNC.get_ES3_SlotData_byName("12") == -1){
					ES3Label_12.setIcon(Board_over);
				}
			}
		});
		ES3Label_12.setIcon(Board);
		ES3Label_12.setBounds(153, 27, 14, 193);
		panel_13.add(ES3Label_12);
		
		  ES3Label_13 = new JLabel(""); // Slot 13
		ES3Label_13.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent arg0) {
				if (RNC.get_ES3_SlotData_byName("13") == -1){
					ES3Label_13.setIcon(Board);
				}	
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (RNC.get_ES3_SlotData_byName("13") == -1){
					ES3Label_13.setIcon(Board_selected);
					SlotData newBoard = new SlotData();
					newBoard.set_Slot("13");
					RNC.add_ES3_SlotData(newBoard);
					textField.setText(String.valueOf(RNC.get_Total_Board()));
					textField_1.setText(RNC.get_Total_Board_List());
				}else{
					ES3Label_13.setIcon(Board);
					RNC.delete_ES3_SlotData_byName("13");
					textField.setText(String.valueOf(RNC.get_Total_Board()));
					textField_1.setText(RNC.get_Total_Board_List());
				}
			}
		});
		ES3Label_13.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
				if (RNC.get_ES3_SlotData_byName("13") == -1){
					ES3Label_13.setIcon(Board_over);
				}
			}
		});
		ES3Label_13.setIcon(Board);
		ES3Label_13.setBounds(166, 27, 14, 193);
		panel_13.add(ES3Label_13);
		
		  ES3Label_14 = new JLabel(""); // Slot 14
		ES3Label_14.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent arg0) {
				if (RNC.get_ES3_SlotData_byName("14") == -1){
					ES3Label_14.setIcon(Board);
				}
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (RNC.get_ES3_SlotData_byName("14") == -1){
					ES3Label_14.setIcon(Board_selected);
					SlotData newBoard = new SlotData();
					newBoard.set_Slot("14");
					RNC.add_ES3_SlotData(newBoard);
					textField.setText(String.valueOf(RNC.get_Total_Board()));
					textField_1.setText(RNC.get_Total_Board_List());
				}else{
					ES3Label_14.setIcon(Board);
					RNC.delete_ES3_SlotData_byName("14");
					textField.setText(String.valueOf(RNC.get_Total_Board()));
					textField_1.setText(RNC.get_Total_Board_List());
				}
			}
		});
		ES3Label_14.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
				if (RNC.get_ES3_SlotData_byName("14") == -1){
					ES3Label_14.setIcon(Board_over);
				}
			}
		});
		ES3Label_14.setIcon(Board);
		ES3Label_14.setBounds(179, 27, 14, 193);
		panel_13.add(ES3Label_14);
		
		  ES3Label_15 = new JLabel(""); // Slot 15
		ES3Label_15.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent arg0) {
				if (RNC.get_ES3_SlotData_byName("15") == -1){
					ES3Label_15.setIcon(Board);
				}
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (RNC.get_ES3_SlotData_byName("15") == -1){
					ES3Label_15.setIcon(Board_selected);
					SlotData newBoard = new SlotData();
					newBoard.set_Slot("15");
					RNC.add_ES3_SlotData(newBoard);
					textField.setText(String.valueOf(RNC.get_Total_Board()));
					textField_1.setText(RNC.get_Total_Board_List());
				}else{
					ES3Label_15.setIcon(Board);
					RNC.delete_ES3_SlotData_byName("15");
					textField.setText(String.valueOf(RNC.get_Total_Board()));
					textField_1.setText(RNC.get_Total_Board_List());
				}
			}
		});
		ES3Label_15.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
				if (RNC.get_ES3_SlotData_byName("15") == -1){
					ES3Label_15.setIcon(Board_over);
				}
			}
		});
		ES3Label_15.setIcon(Board);
		ES3Label_15.setBounds(192, 27, 14, 193);
		panel_13.add(ES3Label_15);
		
		  ES3Label_16 = new JLabel(""); //Slot 16
		ES3Label_16.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent arg0) {
				if (RNC.get_ES3_SlotData_byName("16") == -1){
					ES3Label_16.setIcon(Board);
				}
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (RNC.get_ES3_SlotData_byName("16") == -1){
					ES3Label_16.setIcon(Board_selected);
					SlotData newBoard = new SlotData();
					newBoard.set_Slot("16");
					RNC.add_ES3_SlotData(newBoard);
					textField.setText(String.valueOf(RNC.get_Total_Board()));
					textField_1.setText(RNC.get_Total_Board_List());
				}else{
					ES3Label_16.setIcon(Board);
					RNC.delete_ES3_SlotData_byName("16");
					textField.setText(String.valueOf(RNC.get_Total_Board()));
					textField_1.setText(RNC.get_Total_Board_List());
				}
			}
		});
		ES3Label_16.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
				if (RNC.get_ES3_SlotData_byName("16") == -1){
					ES3Label_16.setIcon(Board_over);
				}
			}
		});
		ES3Label_16.setIcon(Board);
		ES3Label_16.setBounds(205, 27, 14, 193);
		panel_13.add(ES3Label_16);
		
		  ES3Label_17 = new JLabel(""); // Slot 17
		ES3Label_17.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent arg0) {
				if (RNC.get_ES3_SlotData_byName("17") == -1){
					ES3Label_17.setIcon(Board);
				}
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (RNC.get_ES3_SlotData_byName("17") == -1){
					ES3Label_17.setIcon(Board_selected);
					SlotData newBoard = new SlotData();
					newBoard.set_Slot("17");
					RNC.add_ES3_SlotData(newBoard);
					textField.setText(String.valueOf(RNC.get_Total_Board()));
					textField_1.setText(RNC.get_Total_Board_List());
				}else{
					ES3Label_17.setIcon(Board);
					RNC.delete_ES3_SlotData_byName("17");
					textField.setText(String.valueOf(RNC.get_Total_Board()));
					textField_1.setText(RNC.get_Total_Board_List());
				}
			}
		});
		ES3Label_17.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
				if (RNC.get_ES3_SlotData_byName("17") == -1){
					ES3Label_17.setIcon(Board_over);
				}
			}
		});
		ES3Label_17.setIcon(Board);
		ES3Label_17.setBounds(218, 27, 14, 193);
		panel_13.add(ES3Label_17);
		
		  ES3Label_18 = new JLabel(""); // Slot 18
		ES3Label_18.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent arg0) {
				if (RNC.get_ES3_SlotData_byName("18") == -1){
					ES3Label_18.setIcon(Board);
				}
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (RNC.get_ES3_SlotData_byName("18") == -1){
					ES3Label_18.setIcon(Board_selected);
					SlotData newBoard = new SlotData();
					newBoard.set_Slot("18");
					RNC.add_ES3_SlotData(newBoard);
					textField.setText(String.valueOf(RNC.get_Total_Board()));
					textField_1.setText(RNC.get_Total_Board_List());
				}else{
					ES3Label_18.setIcon(Board);
					RNC.delete_ES3_SlotData_byName("18");
					textField.setText(String.valueOf(RNC.get_Total_Board()));
					textField_1.setText(RNC.get_Total_Board_List());
				}
			}
		});
		ES3Label_18.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
				if (RNC.get_ES3_SlotData_byName("18") == -1){
					ES3Label_18.setIcon(Board_over);
				}
			}
		});
		ES3Label_18.setIcon(Board);
		ES3Label_18.setBounds(231, 27, 14, 193);
		panel_13.add(ES3Label_18);
		
		  ES3Label_19 = new JLabel(""); // Slot 19
		ES3Label_19.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent arg0) {
				if (RNC.get_ES3_SlotData_byName("19") == -1){
					ES3Label_19.setIcon(Board);
				}
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (RNC.get_ES3_SlotData_byName("19") == -1){
					ES3Label_19.setIcon(Board_selected);
					SlotData newBoard = new SlotData();
					newBoard.set_Slot("19");
					RNC.add_ES3_SlotData(newBoard);
					textField.setText(String.valueOf(RNC.get_Total_Board()));
					textField_1.setText(RNC.get_Total_Board_List());
				}else{
					ES3Label_19.setIcon(Board);
					RNC.delete_ES3_SlotData_byName("19");
					textField.setText(String.valueOf(RNC.get_Total_Board()));
					textField_1.setText(RNC.get_Total_Board_List());
				}
			}
		});
		ES3Label_19.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
				if (RNC.get_ES3_SlotData_byName("19") == -1){
					ES3Label_19.setIcon(Board_over);
				}
			}
		});
		ES3Label_19.setIcon(Board);
		ES3Label_19.setBounds(244, 27, 14, 193);
		panel_13.add(ES3Label_19);
		
		  ES3Label_20 = new JLabel(""); // Slot 20
		ES3Label_20.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent arg0) {
				if (RNC.get_ES3_SlotData_byName("20") == -1){
					ES3Label_20.setIcon(Board);
				}
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (RNC.get_ES3_SlotData_byName("20") == -1){
					ES3Label_20.setIcon(Board_selected);
					SlotData newBoard = new SlotData();
					newBoard.set_Slot("20");
					RNC.add_ES3_SlotData(newBoard);
					textField.setText(String.valueOf(RNC.get_Total_Board()));
					textField_1.setText(RNC.get_Total_Board_List());
				}else{
					ES3Label_20.setIcon(Board);
					RNC.delete_ES3_SlotData_byName("20");
					textField.setText(String.valueOf(RNC.get_Total_Board()));
					textField_1.setText(RNC.get_Total_Board_List());
				}
			}
		});
		ES3Label_20.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
				if (RNC.get_ES3_SlotData_byName("20") == -1){
					ES3Label_20.setIcon(Board_over);
				}
			}
		});
		ES3Label_20.setIcon(Board);
		ES3Label_20.setBounds(257, 27, 14, 193);
		panel_13.add(ES3Label_20);
		
		  ES3Label_21 = new JLabel(""); // Slot 21
		ES3Label_21.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent arg0) {
				if (RNC.get_ES3_SlotData_byName("21") == -1){
					ES3Label_21.setIcon(Board);
				}
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (RNC.get_ES3_SlotData_byName("21") == -1){
					ES3Label_21.setIcon(Board_selected);
					SlotData newBoard = new SlotData();
					newBoard.set_Slot("21");
					RNC.add_ES3_SlotData(newBoard);
					textField.setText(String.valueOf(RNC.get_Total_Board()));
					textField_1.setText(RNC.get_Total_Board_List());
				}else{
					ES3Label_21.setIcon(Board);
					RNC.delete_ES3_SlotData_byName("21");
					textField.setText(String.valueOf(RNC.get_Total_Board()));
					textField_1.setText(RNC.get_Total_Board_List());
				}
			}
		});
		ES3Label_21.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
				if (RNC.get_ES3_SlotData_byName("21") == -1){
					ES3Label_21.setIcon(Board_over);
				}
			}
		});
		ES3Label_21.setIcon(Board);
		ES3Label_21.setBounds(270, 27, 14, 193);
		panel_13.add(ES3Label_21);
		
		  ES3Label_22 = new JLabel(""); // Slot 22
		ES3Label_22.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent arg0) {
				if (RNC.get_ES3_SlotData_byName("22") == -1){
					ES3Label_22.setIcon(Board);
				}
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (RNC.get_ES3_SlotData_byName("22") == -1){
					ES3Label_22.setIcon(Board_selected);
					SlotData newBoard = new SlotData();
					newBoard.set_Slot("22");
					RNC.add_ES3_SlotData(newBoard);
					textField.setText(String.valueOf(RNC.get_Total_Board()));
					textField_1.setText(RNC.get_Total_Board_List());
				}else{
					ES3Label_22.setIcon(Board);
					RNC.delete_ES3_SlotData_byName("22");
					textField.setText(String.valueOf(RNC.get_Total_Board()));
					textField_1.setText(RNC.get_Total_Board_List());
				}
			}
		});
		ES3Label_22.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
				if (RNC.get_ES3_SlotData_byName("22") == -1){
					ES3Label_22.setIcon(Board_over);
				}
			}
		});
		ES3Label_22.setIcon(Board);
		ES3Label_22.setBounds(283, 27, 14, 193);
		panel_13.add(ES3Label_22);
		
		  ES3Label_23 = new JLabel(""); // Slot 23
		ES3Label_23.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent arg0) {
				if (RNC.get_ES3_SlotData_byName("23") == -1){
					ES3Label_23.setIcon(Board);
				}
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (RNC.get_ES3_SlotData_byName("23") == -1){
					ES3Label_23.setIcon(Board_selected);
					SlotData newBoard = new SlotData();
					newBoard.set_Slot("23");
					RNC.add_ES3_SlotData(newBoard);
					textField.setText(String.valueOf(RNC.get_Total_Board()));
					textField_1.setText(RNC.get_Total_Board_List());
				}else{
					ES3Label_23.setIcon(Board);
					RNC.delete_ES3_SlotData_byName("23");
					textField.setText(String.valueOf(RNC.get_Total_Board()));
					textField_1.setText(RNC.get_Total_Board_List());
				}
			}
		});
		ES3Label_23.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
				if (RNC.get_ES3_SlotData_byName("23") == -1){
					ES3Label_23.setIcon(Board_over);
				}
			}
		});
		ES3Label_23.setIcon(Board);
		ES3Label_23.setBounds(296, 27, 14, 193);
		panel_13.add(ES3Label_23);
		
		  ES3Label_24 = new JLabel(""); // Slot 24
		ES3Label_24.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent arg0) {
				if (RNC.get_ES3_SlotData_byName("24") == -1){
					ES3Label_24.setIcon(Board);
				}
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (RNC.get_ES3_SlotData_byName("24") == -1){
					ES3Label_24.setIcon(Board_selected);
					SlotData newBoard = new SlotData();
					newBoard.set_Slot("24");
					RNC.add_ES3_SlotData(newBoard);
					textField.setText(String.valueOf(RNC.get_Total_Board()));
					textField_1.setText(RNC.get_Total_Board_List());
				}else{
					ES3Label_24.setIcon(Board);
					RNC.delete_ES3_SlotData_byName("24");
					textField.setText(String.valueOf(RNC.get_Total_Board()));
					textField_1.setText(RNC.get_Total_Board_List());
				}
			}
		});
		ES3Label_24.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
				if (RNC.get_ES3_SlotData_byName("24") == -1){
					ES3Label_24.setIcon(Board_over);
				}
			}
		});
		ES3Label_24.setIcon(Board);
		ES3Label_24.setBounds(309, 27, 14, 193);
		panel_13.add(ES3Label_24);
		
		  ES3Label_25 = new JLabel(""); // Slot 25
		ES3Label_25.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent arg0) {
				if (RNC.get_ES3_SlotData_byName("25") == -1){
					ES3Label_25.setIcon(Board);
				}
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (RNC.get_ES3_SlotData_byName("25") == -1){
					ES3Label_25.setIcon(Board_selected);
					SlotData newBoard = new SlotData();
					newBoard.set_Slot("25");
					RNC.add_ES3_SlotData(newBoard);
					textField.setText(String.valueOf(RNC.get_Total_Board()));
					textField_1.setText(RNC.get_Total_Board_List());
				}else{
					ES3Label_25.setIcon(Board);
					RNC.delete_ES3_SlotData_byName("25");
					textField.setText(String.valueOf(RNC.get_Total_Board()));
					textField_1.setText(RNC.get_Total_Board_List());
				}
			}
		});
		ES3Label_25.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
				if (RNC.get_ES3_SlotData_byName("25") == -1){
					ES3Label_25.setIcon(Board_over);
				}
			}
		});
		ES3Label_25.setIcon(Board);
		ES3Label_25.setBounds(322, 27, 14, 193);
		panel_13.add(ES3Label_25);
		
		  ES3Label_26 = new JLabel(""); // Slot 26
		ES3Label_26.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent arg0) {
				if (RNC.get_ES3_SlotData_byName("26") == -1){
					ES3Label_26.setIcon(Board);
				}
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (RNC.get_ES3_SlotData_byName("26") == -1){
					ES3Label_26.setIcon(Board_selected);
					SlotData newBoard = new SlotData();
					newBoard.set_Slot("26");
					RNC.add_ES3_SlotData(newBoard);
					textField.setText(String.valueOf(RNC.get_Total_Board()));
					textField_1.setText(RNC.get_Total_Board_List());
				}else{
					ES3Label_26.setIcon(Board);
					RNC.delete_ES3_SlotData_byName("26");
					textField.setText(String.valueOf(RNC.get_Total_Board()));
					textField_1.setText(RNC.get_Total_Board_List());
				}
			}
		});
		ES3Label_26.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
				if (RNC.get_ES3_SlotData_byName("26") == -1){
					ES3Label_26.setIcon(Board_over);
				}
			}
		});
		ES3Label_26.setIcon(Board);
		ES3Label_26.setBounds(335, 27, 14, 193);
		panel_13.add(ES3Label_26);
		
		JLabel ES3Label_27 = new JLabel("");
		ES3Label_27.setIcon(new ImageIcon(rncMain.class.getResource("/images/SCXB3.png")));
		ES3Label_27.setBounds(348, 27, 14, 193);
		panel_13.add(ES3Label_27);
		
		JLabel ES3Label_28 = new JLabel("");
		ES3Label_28.setIcon(new ImageIcon(rncMain.class.getResource("/images/CMXB3.png")));
		ES3Label_28.setBounds(361, 27, 14, 193);
		panel_13.add(ES3Label_28);		
		
		JLabel ES3Label_1_1 = new JLabel("1");
		ES3Label_1_1.setFont(new Font("Vrinda", Font.PLAIN, 12));
		ES3Label_1_1.setBounds(8, 10, 12, 15);
		panel_13.add(ES3Label_1_1);
		ES3Label_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel ES3Label_1_2 = new JLabel("2");
		ES3Label_1_2.setFont(new Font("Vrinda", Font.PLAIN, 11));
		ES3Label_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		ES3Label_1_2.setBounds(24, 10, 12, 15);
		panel_13.add(ES3Label_1_2);
		
		JLabel ES3Label_1_3 = new JLabel("3");
		ES3Label_1_3.setFont(new Font("Vrinda", Font.PLAIN, 11));
		ES3Label_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		ES3Label_1_3.setBounds(37, 10, 12, 15);
		panel_13.add(ES3Label_1_3);
		
		JLabel ES3Label_1_4 = new JLabel("4");
		ES3Label_1_4.setFont(new Font("Vrinda", Font.PLAIN, 11));
		ES3Label_1_4.setHorizontalAlignment(SwingConstants.CENTER);
		ES3Label_1_4.setBounds(50, 10, 12, 15);
		panel_13.add(ES3Label_1_4);
		
		JLabel ES3Label_1_5 = new JLabel("5");
		ES3Label_1_5.setFont(new Font("Vrinda", Font.PLAIN, 11));
		ES3Label_1_5.setHorizontalAlignment(SwingConstants.CENTER);
		ES3Label_1_5.setBounds(63, 10, 12, 15);
		panel_13.add(ES3Label_1_5);
		
		JLabel ES3Label_1_6 = new JLabel("6");
		ES3Label_1_6.setHorizontalAlignment(SwingConstants.CENTER);
		ES3Label_1_6.setFont(new Font("Vrinda", Font.PLAIN, 11));
		ES3Label_1_6.setBounds(76, 10, 12, 15);
		panel_13.add(ES3Label_1_6);
		
		JLabel ES3Label_1_7 = new JLabel("7");
		ES3Label_1_7.setHorizontalAlignment(SwingConstants.CENTER);
		ES3Label_1_7.setFont(new Font("Vrinda", Font.PLAIN, 11));
		ES3Label_1_7.setBounds(88, 10, 12, 15);
		panel_13.add(ES3Label_1_7);
		
		JLabel ES3Label_1_8 = new JLabel("8");
		ES3Label_1_8.setHorizontalAlignment(SwingConstants.CENTER);
		ES3Label_1_8.setFont(new Font("Vrinda", Font.PLAIN, 11));
		ES3Label_1_8.setBounds(101, 10, 12, 15);
		panel_13.add(ES3Label_1_8);
		
		JLabel ES3Label_1_9 = new JLabel("9");
		ES3Label_1_9.setHorizontalAlignment(SwingConstants.CENTER);
		ES3Label_1_9.setFont(new Font("Vrinda", Font.PLAIN, 11));
		ES3Label_1_9.setBounds(114, 10, 12, 15);
		panel_13.add(ES3Label_1_9);
		
		JLabel ES3Label_1_10 = new JLabel("10");
		ES3Label_1_10.setHorizontalAlignment(SwingConstants.CENTER);
		ES3Label_1_10.setFont(new Font("Vrinda", Font.PLAIN, 10));
		ES3Label_1_10.setBounds(127, 10, 12, 15);
		panel_13.add(ES3Label_1_10);
		
		JLabel ES3Label_1_11 = new JLabel("11");
		ES3Label_1_11.setHorizontalAlignment(SwingConstants.CENTER);
		ES3Label_1_11.setFont(new Font("Vrinda", Font.PLAIN, 10));
		ES3Label_1_11.setBounds(141, 10, 12, 15);
		panel_13.add(ES3Label_1_11);
		
		JLabel ES3Label_1_12 = new JLabel("12");
		ES3Label_1_12.setHorizontalAlignment(SwingConstants.CENTER);
		ES3Label_1_12.setFont(new Font("Vrinda", Font.PLAIN, 10));
		ES3Label_1_12.setBounds(154, 10, 12, 15);
		panel_13.add(ES3Label_1_12);
		
		JLabel ES3Label_1_13 = new JLabel("13");
		ES3Label_1_13.setHorizontalAlignment(SwingConstants.CENTER);
		ES3Label_1_13.setFont(new Font("Vrinda", Font.PLAIN, 10));
		ES3Label_1_13.setBounds(167, 10, 12, 15);
		panel_13.add(ES3Label_1_13);
		
		JLabel ES3Label_1_14 = new JLabel("14");
		ES3Label_1_14.setHorizontalAlignment(SwingConstants.CENTER);
		ES3Label_1_14.setFont(new Font("Vrinda", Font.PLAIN, 10));
		ES3Label_1_14.setBounds(180, 10, 12, 15);
		panel_13.add(ES3Label_1_14);
		
		JLabel ES3Label_1_15 = new JLabel("15");
		ES3Label_1_15.setHorizontalAlignment(SwingConstants.CENTER);
		ES3Label_1_15.setFont(new Font("Vrinda", Font.PLAIN, 10));
		ES3Label_1_15.setBounds(193, 10, 12, 15);
		panel_13.add(ES3Label_1_15);
		
		JLabel ES3Label_1_16 = new JLabel("16");
		ES3Label_1_16.setHorizontalAlignment(SwingConstants.CENTER);
		ES3Label_1_16.setFont(new Font("Vrinda", Font.PLAIN, 10));
		ES3Label_1_16.setBounds(206, 10, 12, 15);
		panel_13.add(ES3Label_1_16);
		
		JLabel ES3Label_1_17 = new JLabel("17");
		ES3Label_1_17.setHorizontalAlignment(SwingConstants.CENTER);
		ES3Label_1_17.setFont(new Font("Vrinda", Font.PLAIN, 10));
		ES3Label_1_17.setBounds(219, 10, 12, 15);
		panel_13.add(ES3Label_1_17);
		
		JLabel ES3Label_1_18 = new JLabel("18");
		ES3Label_1_18.setHorizontalAlignment(SwingConstants.CENTER);
		ES3Label_1_18.setFont(new Font("Vrinda", Font.PLAIN, 10));
		ES3Label_1_18.setBounds(232, 10, 12, 15);
		panel_13.add(ES3Label_1_18);
		
		JLabel ES3Label_1_19 = new JLabel("19");
		ES3Label_1_19.setHorizontalAlignment(SwingConstants.CENTER);
		ES3Label_1_19.setFont(new Font("Vrinda", Font.PLAIN, 10));
		ES3Label_1_19.setBounds(245, 10, 12, 15);
		panel_13.add(ES3Label_1_19);
		
		JLabel ES3Label_1_20 = new JLabel("20");
		ES3Label_1_20.setHorizontalAlignment(SwingConstants.CENTER);
		ES3Label_1_20.setFont(new Font("Vrinda", Font.PLAIN, 10));
		ES3Label_1_20.setBounds(258, 10, 12, 15);
		panel_13.add(ES3Label_1_20);
		
		JLabel ES3Label_1_21 = new JLabel("21");
		ES3Label_1_21.setHorizontalAlignment(SwingConstants.CENTER);
		ES3Label_1_21.setFont(new Font("Vrinda", Font.PLAIN, 10));
		ES3Label_1_21.setBounds(271, 10, 12, 15);
		panel_13.add(ES3Label_1_21);				
		
		JLabel ES3Label_1_22 = new JLabel("22");		
		ES3Label_1_22.setHorizontalAlignment(SwingConstants.CENTER);
		ES3Label_1_22.setFont(new Font("Vrinda", Font.PLAIN, 10));
		ES3Label_1_22.setBounds(284, 10, 12, 15);
		panel_13.add(ES3Label_1_22);
		
		JLabel ES3Label_1_23 = new JLabel("23");		
		ES3Label_1_23.setHorizontalAlignment(SwingConstants.CENTER);
		ES3Label_1_23.setFont(new Font("Vrinda", Font.PLAIN, 10));
		ES3Label_1_23.setBounds(297, 10, 12, 15);
		panel_13.add(ES3Label_1_23);
		
		JLabel ES3Label_1_24 = new JLabel("24");		
		ES3Label_1_24.setHorizontalAlignment(SwingConstants.CENTER);
		ES3Label_1_24.setFont(new Font("Vrinda", Font.PLAIN, 10));
		ES3Label_1_24.setBounds(310, 10, 12, 15);
		panel_13.add(ES3Label_1_24);
		
		JLabel ES3Label_1_25 = new JLabel("25");
		ES3Label_1_25.setHorizontalAlignment(SwingConstants.CENTER);
		ES3Label_1_25.setFont(new Font("Vrinda", Font.PLAIN, 10));
		ES3Label_1_25.setBounds(323, 10, 12, 15);
		panel_13.add(ES3Label_1_25);
		
		JLabel ES3Label_1_26 = new JLabel("26");
		ES3Label_1_26.setHorizontalAlignment(SwingConstants.CENTER);
		ES3Label_1_26.setFont(new Font("Vrinda", Font.PLAIN, 10));
		ES3Label_1_26.setBounds(336, 10, 12, 15);
		panel_13.add(ES3Label_1_26);
		
		JLabel ES3Label_1_27 = new JLabel("27");
		ES3Label_1_27.setHorizontalAlignment(SwingConstants.CENTER);
		ES3Label_1_27.setFont(new Font("Vrinda", Font.PLAIN, 10));
		ES3Label_1_27.setBounds(349, 10, 12, 15);
		panel_13.add(ES3Label_1_27);
		
		JLabel ES3Label_1_28 = new JLabel("28");
		ES3Label_1_28.setHorizontalAlignment(SwingConstants.CENTER);
		ES3Label_1_28.setFont(new Font("Vrinda", Font.PLAIN, 12));
		ES3Label_1_28.setBounds(364, 10, 14, 15);
		panel_13.add(ES3Label_1_28);
								
		
		JLabel ES3Label = new JLabel("Subrack ES-3");
		ES3Label.setBounds(293, 231, 99, 14);
		panel_13.add(ES3Label);
		/////////////////////////////////////////////////////////////////////////////////////////////
		JPanel panel_8 = new JPanel();
		tabbedPane.addTab("ES-4", null, panel_8, null);
		// -
		panel_8.setLayout(null);
		
		JPanel panel_14 = new JPanel();
		panel_14.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_14.setBounds(10, 30, 392, 247);
		panel_8.add(panel_14);
		panel_14.setLayout(null);								
		
		JLabel ES4Label_1 = new JLabel("");
		ES4Label_1.setBounds(10, 27, 14, 193);
		panel_14.add(ES4Label_1);
		ES4Label_1.setIcon(new ImageIcon(rncMain.class.getResource("/images/SCXB3.png")));
		
		JLabel ES4Label_2 = new JLabel("");
		ES4Label_2.setBounds(23, 27, 14, 193);
		panel_14.add(ES4Label_2);
		ES4Label_2.setIcon(new ImageIcon(rncMain.class.getResource("/images/CMXB3.png")));
				
		  ES4Label_3 = new JLabel(""); //Slot 3
		ES4Label_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent arg0) {
				if (RNC.get_ES4_SlotData_byName("3") == -1){
					ES4Label_3.setIcon(Board);
				}
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (RNC.get_ES4_SlotData_byName("3") == -1){
					ES4Label_3.setIcon(Board_selected);
					SlotData newBoard = new SlotData();
					newBoard.set_Slot("3");
					RNC.add_ES4_SlotData(newBoard);
					textField.setText(String.valueOf(RNC.get_Total_Board()));
					textField_1.setText(RNC.get_Total_Board_List());
				}else{
					ES4Label_3.setIcon(Board);
					RNC.delete_ES4_SlotData_byName("3");
					textField.setText(String.valueOf(RNC.get_Total_Board()));
					textField_1.setText(RNC.get_Total_Board_List());
				}
			}
		});
		ES4Label_3.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
				if (RNC.get_ES4_SlotData_byName("3") == -1){
					ES4Label_3.setIcon(Board_over);
				}
			}
		});
		ES4Label_3.setBounds(36, 27, 14, 193);
		panel_14.add(ES4Label_3);
		ES4Label_3.setIcon(Board);
		
		  ES4Label_4 = new JLabel(""); //Slot 4
		ES4Label_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent arg0) {
				if (RNC.get_ES4_SlotData_byName("4") == -1){
					ES4Label_4.setIcon(Board);
				}
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (RNC.get_ES4_SlotData_byName("4") == -1){
					ES4Label_4.setIcon(Board_selected);
					SlotData newBoard = new SlotData();
					newBoard.set_Slot("4");
					RNC.add_ES4_SlotData(newBoard);
					textField.setText(String.valueOf(RNC.get_Total_Board()));
					textField_1.setText(RNC.get_Total_Board_List());
				}else{
					ES4Label_4.setIcon(Board);
					RNC.delete_ES4_SlotData_byName("4");
					textField.setText(String.valueOf(RNC.get_Total_Board()));
					textField_1.setText(RNC.get_Total_Board_List());
				}
			}
		});
		ES4Label_4.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
				if (RNC.get_ES4_SlotData_byName("4") == -1){
					ES4Label_4.setIcon(Board_over);
				}
			}
		});
		ES4Label_4.setBounds(49, 27, 14, 193);
		panel_14.add(ES4Label_4);
		ES4Label_4.setIcon(Board);
		
		
		  ES4Label_5 = new JLabel(""); //Slot 5
		ES4Label_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent arg0) {
				if (RNC.get_ES4_SlotData_byName("5") == -1){
					ES4Label_5.setIcon(Board);
				}
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (RNC.get_ES4_SlotData_byName("5") == -1){
					ES4Label_5.setIcon(Board_selected);
					SlotData newBoard = new SlotData();
					newBoard.set_Slot("5");
					RNC.add_ES4_SlotData(newBoard);
					textField.setText(String.valueOf(RNC.get_Total_Board()));
					textField_1.setText(RNC.get_Total_Board_List());
				}else{
					ES4Label_5.setIcon(Board);
					RNC.delete_ES4_SlotData_byName("5");
					textField.setText(String.valueOf(RNC.get_Total_Board()));
					textField_1.setText(RNC.get_Total_Board_List());
				}
			}
		});
		ES4Label_5.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
				if (RNC.get_ES4_SlotData_byName("5") == -1){
					ES4Label_5.setIcon(Board_over);
				}
			}
		});
		ES4Label_5.setBounds(62, 27, 14, 193);
		panel_14.add(ES4Label_5);
		ES4Label_5.setIcon(Board);
		
		  ES4Label_6 = new JLabel(""); //Slot 6
		ES4Label_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent arg0) {
				if (RNC.get_ES4_SlotData_byName("6") == -1){
					ES4Label_6.setIcon(Board);
				}
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (RNC.get_ES4_SlotData_byName("6") == -1){
					ES4Label_6.setIcon(Board_selected);
					SlotData newBoard = new SlotData();
					newBoard.set_Slot("6");
					RNC.add_ES4_SlotData(newBoard);
					textField.setText(String.valueOf(RNC.get_Total_Board()));
					textField_1.setText(RNC.get_Total_Board_List());
				}else{
					ES4Label_6.setIcon(Board);
					RNC.delete_ES4_SlotData_byName("6");
					textField.setText(String.valueOf(RNC.get_Total_Board()));
					textField_1.setText(RNC.get_Total_Board_List());
				}
			}
		});
		ES4Label_6.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
				if (RNC.get_ES4_SlotData_byName("6") == -1){
					ES4Label_6.setIcon(Board_over);
				}	
			}
		});
		ES4Label_6.setIcon(Board);		
		ES4Label_6.setBounds(75, 27, 14, 193);
		panel_14.add(ES4Label_6);
		
		  ES4Label_7 = new JLabel(""); //Slot 7
		ES4Label_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent arg0) {
				if (RNC.get_ES4_SlotData_byName("7") == -1){
					ES4Label_7.setIcon(Board);
				}
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (RNC.get_ES4_SlotData_byName("7") == -1){
					ES4Label_7.setIcon(Board_selected);
					SlotData newBoard = new SlotData();
					newBoard.set_Slot("7");
					RNC.add_ES4_SlotData(newBoard);
					textField.setText(String.valueOf(RNC.get_Total_Board()));
					textField_1.setText(RNC.get_Total_Board_List());
				}else{
					ES4Label_7.setIcon(Board);
					RNC.delete_ES4_SlotData_byName("7");
					textField.setText(String.valueOf(RNC.get_Total_Board()));
					textField_1.setText(RNC.get_Total_Board_List());
				}
			}
		});
		ES4Label_7.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
				if (RNC.get_ES4_SlotData_byName("7") == -1){
					ES4Label_7.setIcon(Board_over);
				}
			}
		});
		ES4Label_7.setIcon(Board);
		ES4Label_7.setBounds(88, 27, 14, 193);
		panel_14.add(ES4Label_7);
		
		  ES4Label_8 = new JLabel(""); // Slot 8
		ES4Label_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent arg0) {
				if (RNC.get_ES4_SlotData_byName("8") == -1){
					ES4Label_8.setIcon(Board);
				}	
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (RNC.get_ES4_SlotData_byName("8") == -1){
					ES4Label_8.setIcon(Board_selected);
					SlotData newBoard = new SlotData();
					newBoard.set_Slot("8");
					RNC.add_ES4_SlotData(newBoard);
					textField.setText(String.valueOf(RNC.get_Total_Board()));
					textField_1.setText(RNC.get_Total_Board_List());
				}else{
					ES4Label_8.setIcon(Board);
					RNC.delete_ES4_SlotData_byName("8");
					textField.setText(String.valueOf(RNC.get_Total_Board()));
					textField_1.setText(RNC.get_Total_Board_List());
				}
			}
		});
		ES4Label_8.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
				if (RNC.get_ES4_SlotData_byName("8") == -1){
					ES4Label_8.setIcon(Board_over);
				}	
			}
		});
		ES4Label_8.setIcon(Board);
		ES4Label_8.setBounds(101, 27, 14, 193);
		panel_14.add(ES4Label_8);
		
		  ES4Label_9 = new JLabel(""); // Slot 9
		ES4Label_9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent arg0) {
				if (RNC.get_ES4_SlotData_byName("9") == -1){
					ES4Label_9.setIcon(Board);
				}	
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (RNC.get_ES4_SlotData_byName("9") == -1){
					ES4Label_9.setIcon(Board_selected);
					SlotData newBoard = new SlotData();
					newBoard.set_Slot("9");
					RNC.add_ES4_SlotData(newBoard);
					textField.setText(String.valueOf(RNC.get_Total_Board()));
					textField_1.setText(RNC.get_Total_Board_List());
				}else{
					ES4Label_9.setIcon(Board);
					RNC.delete_ES4_SlotData_byName("9");
					textField.setText(String.valueOf(RNC.get_Total_Board()));
					textField_1.setText(RNC.get_Total_Board_List());
				}
			}
		});
		ES4Label_9.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
				if (RNC.get_ES4_SlotData_byName("9") == -1){
					ES4Label_9.setIcon(Board_over);
				}
			}
		});
		ES4Label_9.setIcon(Board);
		ES4Label_9.setBounds(114, 27, 14, 193);
		panel_14.add(ES4Label_9);
		
		  ES4Label_10 = new JLabel(""); // Slot 10
		ES4Label_10.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent arg0) {
				if (RNC.get_ES4_SlotData_byName("10") == -1){
					ES4Label_10.setIcon(Board);
				}
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (RNC.get_ES4_SlotData_byName("10") == -1){
					ES4Label_10.setIcon(Board_selected);
					SlotData newBoard = new SlotData();
					newBoard.set_Slot("10");
					RNC.add_ES4_SlotData(newBoard);
					textField.setText(String.valueOf(RNC.get_Total_Board()));
					textField_1.setText(RNC.get_Total_Board_List());
				}else{
					ES4Label_10.setIcon(Board);
					RNC.delete_ES4_SlotData_byName("10");
					textField.setText(String.valueOf(RNC.get_Total_Board()));
					textField_1.setText(RNC.get_Total_Board_List());
				}
			}
		});
		ES4Label_10.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
				if (RNC.get_ES4_SlotData_byName("10") == -1){
					ES4Label_10.setIcon(Board_over);
				}
			}
		});
		ES4Label_10.setIcon(Board);
		ES4Label_10.setBounds(127, 27, 14, 193);
		panel_14.add(ES4Label_10);
		
		  ES4Label_11 = new JLabel(""); //Slot 11
		ES4Label_11.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent arg0) {
				if (RNC.get_ES4_SlotData_byName("11") == -1){
					ES4Label_11.setIcon(Board);			
				}
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (RNC.get_ES4_SlotData_byName("11") == -1){
					ES4Label_11.setIcon(Board_selected);
					SlotData newBoard = new SlotData();
					newBoard.set_Slot("11");
					RNC.add_ES4_SlotData(newBoard);
					textField.setText(String.valueOf(RNC.get_Total_Board()));
					textField_1.setText(RNC.get_Total_Board_List());
				}else{
					ES4Label_11.setIcon(Board);
					RNC.delete_ES4_SlotData_byName("11");
					textField.setText(String.valueOf(RNC.get_Total_Board()));
					textField_1.setText(RNC.get_Total_Board_List());
				}
			}
		});
		ES4Label_11.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
				if (RNC.get_ES4_SlotData_byName("11") == -1){
					ES4Label_11.setIcon(Board_over);
				}
			}
		});
		ES4Label_11.setIcon(Board);
		ES4Label_11.setBounds(140, 27, 14, 193);
		panel_14.add(ES4Label_11);
		
		
		  ES4Label_12 = new JLabel(""); // Slot 12
		ES4Label_12.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent arg0) {
				if (RNC.get_ES4_SlotData_byName("12") == -1){
					ES4Label_12.setIcon(Board);
				}
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (RNC.get_ES4_SlotData_byName("12") == -1){
					ES4Label_12.setIcon(Board_selected);
					SlotData newBoard = new SlotData();
					newBoard.set_Slot("12");
					RNC.add_ES4_SlotData(newBoard);
					textField.setText(String.valueOf(RNC.get_Total_Board()));
					textField_1.setText(RNC.get_Total_Board_List());
				}else{
					ES4Label_12.setIcon(Board);
					RNC.delete_ES4_SlotData_byName("12");
					textField.setText(String.valueOf(RNC.get_Total_Board()));
					textField_1.setText(RNC.get_Total_Board_List());
				}
			}
		});
		ES4Label_12.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
				if (RNC.get_ES4_SlotData_byName("12") == -1){
					ES4Label_12.setIcon(Board_over);
				}
			}
		});
		ES4Label_12.setIcon(Board);
		ES4Label_12.setBounds(153, 27, 14, 193);
		panel_14.add(ES4Label_12);
		
		  ES4Label_13 = new JLabel(""); // Slot 13
		ES4Label_13.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent arg0) {
				if (RNC.get_ES4_SlotData_byName("13") == -1){
					ES4Label_13.setIcon(Board);
				}	
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (RNC.get_ES4_SlotData_byName("13") == -1){
					ES4Label_13.setIcon(Board_selected);
					SlotData newBoard = new SlotData();
					newBoard.set_Slot("13");
					RNC.add_ES4_SlotData(newBoard);
					textField.setText(String.valueOf(RNC.get_Total_Board()));
					textField_1.setText(RNC.get_Total_Board_List());
				}else{
					ES4Label_13.setIcon(Board);
					RNC.delete_ES4_SlotData_byName("13");
					textField.setText(String.valueOf(RNC.get_Total_Board()));
					textField_1.setText(RNC.get_Total_Board_List());
				}
			}
		});
		ES4Label_13.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
				if (RNC.get_ES4_SlotData_byName("13") == -1){
					ES4Label_13.setIcon(Board_over);
				}
			}
		});
		ES4Label_13.setIcon(Board);
		ES4Label_13.setBounds(166, 27, 14, 193);
		panel_14.add(ES4Label_13);
		
		  ES4Label_14 = new JLabel(""); // Slot 14
		ES4Label_14.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent arg0) {
				if (RNC.get_ES4_SlotData_byName("14") == -1){
					ES4Label_14.setIcon(Board);
				}
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (RNC.get_ES4_SlotData_byName("14") == -1){
					ES4Label_14.setIcon(Board_selected);
					SlotData newBoard = new SlotData();
					newBoard.set_Slot("14");
					RNC.add_ES4_SlotData(newBoard);
					textField.setText(String.valueOf(RNC.get_Total_Board()));
					textField_1.setText(RNC.get_Total_Board_List());
				}else{
					ES4Label_14.setIcon(Board);
					RNC.delete_ES4_SlotData_byName("14");
					textField.setText(String.valueOf(RNC.get_Total_Board()));
					textField_1.setText(RNC.get_Total_Board_List());
				}
			}
		});
		ES4Label_14.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
				if (RNC.get_ES4_SlotData_byName("14") == -1){
					ES4Label_14.setIcon(Board_over);
				}
			}
		});
		ES4Label_14.setIcon(Board);
		ES4Label_14.setBounds(179, 27, 14, 193);
		panel_14.add(ES4Label_14);
		
		  ES4Label_15 = new JLabel(""); // Slot 15
		ES4Label_15.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent arg0) {
				if (RNC.get_ES4_SlotData_byName("15") == -1){
					ES4Label_15.setIcon(Board);
				}
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (RNC.get_ES4_SlotData_byName("15") == -1){
					ES4Label_15.setIcon(Board_selected);
					SlotData newBoard = new SlotData();
					newBoard.set_Slot("15");
					RNC.add_ES4_SlotData(newBoard);
					textField.setText(String.valueOf(RNC.get_Total_Board()));
					textField_1.setText(RNC.get_Total_Board_List());
				}else{
					ES4Label_15.setIcon(Board);
					RNC.delete_ES4_SlotData_byName("15");
					textField.setText(String.valueOf(RNC.get_Total_Board()));
					textField_1.setText(RNC.get_Total_Board_List());
				}
			}
		});
		ES4Label_15.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
				if (RNC.get_ES4_SlotData_byName("15") == -1){
					ES4Label_15.setIcon(Board_over);
				}
			}
		});
		ES4Label_15.setIcon(Board);
		ES4Label_15.setBounds(192, 27, 14, 193);
		panel_14.add(ES4Label_15);
		
		  ES4Label_16 = new JLabel(""); //Slot 16
		ES4Label_16.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent arg0) {
				if (RNC.get_ES4_SlotData_byName("16") == -1){
					ES4Label_16.setIcon(Board);
				}
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (RNC.get_ES4_SlotData_byName("16") == -1){
					ES4Label_16.setIcon(Board_selected);
					SlotData newBoard = new SlotData();
					newBoard.set_Slot("16");
					RNC.add_ES4_SlotData(newBoard);
					textField.setText(String.valueOf(RNC.get_Total_Board()));
					textField_1.setText(RNC.get_Total_Board_List());
				}else{
					ES4Label_16.setIcon(Board);
					RNC.delete_ES4_SlotData_byName("16");
					textField.setText(String.valueOf(RNC.get_Total_Board()));
					textField_1.setText(RNC.get_Total_Board_List());
				}
			}
		});
		ES4Label_16.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
				if (RNC.get_ES4_SlotData_byName("16") == -1){
					ES4Label_16.setIcon(Board_over);
				}
			}
		});
		ES4Label_16.setIcon(Board);
		ES4Label_16.setBounds(205, 27, 14, 193);
		panel_14.add(ES4Label_16);
		
		  ES4Label_17 = new JLabel(""); // Slot 17
		ES4Label_17.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent arg0) {
				if (RNC.get_ES4_SlotData_byName("17") == -1){
					ES4Label_17.setIcon(Board);
				}
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (RNC.get_ES4_SlotData_byName("17") == -1){
					ES4Label_17.setIcon(Board_selected);
					SlotData newBoard = new SlotData();
					newBoard.set_Slot("17");
					RNC.add_ES4_SlotData(newBoard);
					textField.setText(String.valueOf(RNC.get_Total_Board()));
					textField_1.setText(RNC.get_Total_Board_List());
				}else{
					ES4Label_17.setIcon(Board);
					RNC.delete_ES4_SlotData_byName("17");
					textField.setText(String.valueOf(RNC.get_Total_Board()));
					textField_1.setText(RNC.get_Total_Board_List());
				}
			}
		});
		ES4Label_17.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
				if (RNC.get_ES4_SlotData_byName("17") == -1){
					ES4Label_17.setIcon(Board_over);
				}
			}
		});
		ES4Label_17.setIcon(Board);
		ES4Label_17.setBounds(218, 27, 14, 193);
		panel_14.add(ES4Label_17);
		
		  ES4Label_18 = new JLabel(""); // Slot 18
		ES4Label_18.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent arg0) {
				if (RNC.get_ES4_SlotData_byName("18") == -1){
					ES4Label_18.setIcon(Board);
				}
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (RNC.get_ES4_SlotData_byName("18") == -1){
					ES4Label_18.setIcon(Board_selected);
					SlotData newBoard = new SlotData();
					newBoard.set_Slot("18");
					RNC.add_ES4_SlotData(newBoard);
					textField.setText(String.valueOf(RNC.get_Total_Board()));
					textField_1.setText(RNC.get_Total_Board_List());
				}else{
					ES4Label_18.setIcon(Board);
					RNC.delete_ES4_SlotData_byName("18");
					textField.setText(String.valueOf(RNC.get_Total_Board()));
					textField_1.setText(RNC.get_Total_Board_List());
				}
			}
		});
		ES4Label_18.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
				if (RNC.get_ES4_SlotData_byName("18") == -1){
					ES4Label_18.setIcon(Board_over);
				}
			}
		});
		ES4Label_18.setIcon(Board);
		ES4Label_18.setBounds(231, 27, 14, 193);
		panel_14.add(ES4Label_18);
		
		  ES4Label_19 = new JLabel(""); // Slot 19
		ES4Label_19.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent arg0) {
				if (RNC.get_ES4_SlotData_byName("19") == -1){
					ES4Label_19.setIcon(Board);
				}
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (RNC.get_ES4_SlotData_byName("19") == -1){
					ES4Label_19.setIcon(Board_selected);
					SlotData newBoard = new SlotData();
					newBoard.set_Slot("19");
					RNC.add_ES4_SlotData(newBoard);
					textField.setText(String.valueOf(RNC.get_Total_Board()));
					textField_1.setText(RNC.get_Total_Board_List());
				}else{
					ES4Label_19.setIcon(Board);
					RNC.delete_ES4_SlotData_byName("19");
					textField.setText(String.valueOf(RNC.get_Total_Board()));
					textField_1.setText(RNC.get_Total_Board_List());
				}
			}
		});
		ES4Label_19.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
				if (RNC.get_ES4_SlotData_byName("19") == -1){
					ES4Label_19.setIcon(Board_over);
				}
			}
		});
		ES4Label_19.setIcon(Board);
		ES4Label_19.setBounds(244, 27, 14, 193);
		panel_14.add(ES4Label_19);
		
		  ES4Label_20 = new JLabel(""); // Slot 20
		ES4Label_20.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent arg0) {
				if (RNC.get_ES4_SlotData_byName("20") == -1){
					ES4Label_20.setIcon(Board);
				}
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (RNC.get_ES4_SlotData_byName("20") == -1){
					ES4Label_20.setIcon(Board_selected);
					SlotData newBoard = new SlotData();
					newBoard.set_Slot("20");
					RNC.add_ES4_SlotData(newBoard);
					textField.setText(String.valueOf(RNC.get_Total_Board()));
					textField_1.setText(RNC.get_Total_Board_List());
				}else{
					ES4Label_20.setIcon(Board);
					RNC.delete_ES4_SlotData_byName("20");
					textField.setText(String.valueOf(RNC.get_Total_Board()));
					textField_1.setText(RNC.get_Total_Board_List());
				}
			}
		});
		ES4Label_20.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
				if (RNC.get_ES4_SlotData_byName("20") == -1){
					ES4Label_20.setIcon(Board_over);
				}
			}
		});
		ES4Label_20.setIcon(Board);
		ES4Label_20.setBounds(257, 27, 14, 193);
		panel_14.add(ES4Label_20);
		
		  ES4Label_21 = new JLabel(""); // Slot 21
		ES4Label_21.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent arg0) {
				if (RNC.get_ES4_SlotData_byName("21") == -1){
					ES4Label_21.setIcon(Board);
				}
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (RNC.get_ES4_SlotData_byName("21") == -1){
					ES4Label_21.setIcon(Board_selected);
					SlotData newBoard = new SlotData();
					newBoard.set_Slot("21");
					RNC.add_ES4_SlotData(newBoard);
					textField.setText(String.valueOf(RNC.get_Total_Board()));
					textField_1.setText(RNC.get_Total_Board_List());
				}else{
					ES4Label_21.setIcon(Board);
					RNC.delete_ES4_SlotData_byName("21");
					textField.setText(String.valueOf(RNC.get_Total_Board()));
					textField_1.setText(RNC.get_Total_Board_List());
				}
			}
		});
		ES4Label_21.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
				if (RNC.get_ES4_SlotData_byName("21") == -1){
					ES4Label_21.setIcon(Board_over);
				}
			}
		});
		ES4Label_21.setIcon(Board);
		ES4Label_21.setBounds(270, 27, 14, 193);
		panel_14.add(ES4Label_21);
		
		  ES4Label_22 = new JLabel(""); // Slot 22
		ES4Label_22.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent arg0) {
				if (RNC.get_ES4_SlotData_byName("22") == -1){
					ES4Label_22.setIcon(Board);
				}
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (RNC.get_ES4_SlotData_byName("22") == -1){
					ES4Label_22.setIcon(Board_selected);
					SlotData newBoard = new SlotData();
					newBoard.set_Slot("22");
					RNC.add_ES4_SlotData(newBoard);
					textField.setText(String.valueOf(RNC.get_Total_Board()));
					textField_1.setText(RNC.get_Total_Board_List());
				}else{
					ES4Label_22.setIcon(Board);
					RNC.delete_ES4_SlotData_byName("22");
					textField.setText(String.valueOf(RNC.get_Total_Board()));
					textField_1.setText(RNC.get_Total_Board_List());
				}
			}
		});
		ES4Label_22.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
				if (RNC.get_ES4_SlotData_byName("22") == -1){
					ES4Label_22.setIcon(Board_over);
				}
			}
		});
		ES4Label_22.setIcon(Board);
		ES4Label_22.setBounds(283, 27, 14, 193);
		panel_14.add(ES4Label_22);
		
		  ES4Label_23 = new JLabel(""); // Slot 23
		ES4Label_23.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent arg0) {
				if (RNC.get_ES4_SlotData_byName("23") == -1){
					ES4Label_23.setIcon(Board);
				}
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (RNC.get_ES4_SlotData_byName("23") == -1){
					ES4Label_23.setIcon(Board_selected);
					SlotData newBoard = new SlotData();
					newBoard.set_Slot("23");
					RNC.add_ES4_SlotData(newBoard);
					textField.setText(String.valueOf(RNC.get_Total_Board()));
					textField_1.setText(RNC.get_Total_Board_List());
				}else{
					ES4Label_23.setIcon(Board);
					RNC.delete_ES4_SlotData_byName("23");
					textField.setText(String.valueOf(RNC.get_Total_Board()));
					textField_1.setText(RNC.get_Total_Board_List());
				}
			}
		});
		ES4Label_23.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
				if (RNC.get_ES4_SlotData_byName("23") == -1){
					ES4Label_23.setIcon(Board_over);
				}
			}
		});
		ES4Label_23.setIcon(Board);
		ES4Label_23.setBounds(296, 27, 14, 193);
		panel_14.add(ES4Label_23);
		
		  ES4Label_24 = new JLabel(""); // Slot 24
		ES4Label_24.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent arg0) {
				if (RNC.get_ES4_SlotData_byName("24") == -1){
					ES4Label_24.setIcon(Board);
				}
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (RNC.get_ES4_SlotData_byName("24") == -1){
					ES4Label_24.setIcon(Board_selected);
					SlotData newBoard = new SlotData();
					newBoard.set_Slot("24");
					RNC.add_ES4_SlotData(newBoard);
					textField.setText(String.valueOf(RNC.get_Total_Board()));
					textField_1.setText(RNC.get_Total_Board_List());
				}else{
					ES4Label_24.setIcon(Board);
					RNC.delete_ES4_SlotData_byName("24");
					textField.setText(String.valueOf(RNC.get_Total_Board()));
					textField_1.setText(RNC.get_Total_Board_List());
				}
			}
		});
		ES4Label_24.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
				if (RNC.get_ES4_SlotData_byName("24") == -1){
					ES4Label_24.setIcon(Board_over);
				}
			}
		});
		ES4Label_24.setIcon(Board);
		ES4Label_24.setBounds(309, 27, 14, 193);
		panel_14.add(ES4Label_24);
		
		  ES4Label_25 = new JLabel(""); // Slot 25
		ES4Label_25.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent arg0) {
				if (RNC.get_ES4_SlotData_byName("25") == -1){
					ES4Label_25.setIcon(Board);
				}
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (RNC.get_ES4_SlotData_byName("25") == -1){
					ES4Label_25.setIcon(Board_selected);
					SlotData newBoard = new SlotData();
					newBoard.set_Slot("25");
					RNC.add_ES4_SlotData(newBoard);
					textField.setText(String.valueOf(RNC.get_Total_Board()));
					textField_1.setText(RNC.get_Total_Board_List());
				}else{
					ES4Label_25.setIcon(Board);
					RNC.delete_ES4_SlotData_byName("25");
					textField.setText(String.valueOf(RNC.get_Total_Board()));
					textField_1.setText(RNC.get_Total_Board_List());
				}
			}
		});
		ES4Label_25.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
				if (RNC.get_ES4_SlotData_byName("25") == -1){
					ES4Label_25.setIcon(Board_over);
				}
			}
		});
		ES4Label_25.setIcon(Board);
		ES4Label_25.setBounds(322, 27, 14, 193);
		panel_14.add(ES4Label_25);
		
		  ES4Label_26 = new JLabel(""); // Slot 26
		ES4Label_26.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent arg0) {
				if (RNC.get_ES4_SlotData_byName("26") == -1){
					ES4Label_26.setIcon(Board);
				}
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (RNC.get_ES4_SlotData_byName("26") == -1){
					ES4Label_26.setIcon(Board_selected);
					SlotData newBoard = new SlotData();
					newBoard.set_Slot("26");
					RNC.add_ES4_SlotData(newBoard);
					textField.setText(String.valueOf(RNC.get_Total_Board()));
					textField_1.setText(RNC.get_Total_Board_List());
				}else{
					ES4Label_26.setIcon(Board);
					RNC.delete_ES4_SlotData_byName("26");
					textField.setText(String.valueOf(RNC.get_Total_Board()));
					textField_1.setText(RNC.get_Total_Board_List());
				}
			}
		});
		ES4Label_26.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
				if (RNC.get_ES4_SlotData_byName("26") == -1){
					ES4Label_26.setIcon(Board_over);
				}
			}
		});
		ES4Label_26.setIcon(Board);
		ES4Label_26.setBounds(335, 27, 14, 193);
		panel_14.add(ES4Label_26);
		
		JLabel ES4Label_27 = new JLabel("");
		ES4Label_27.setIcon(new ImageIcon(rncMain.class.getResource("/images/SCXB3.png")));
		ES4Label_27.setBounds(348, 27, 14, 193);
		panel_14.add(ES4Label_27);
		
		JLabel ES4Label_28 = new JLabel("");
		ES4Label_28.setIcon(new ImageIcon(rncMain.class.getResource("/images/CMXB3.png")));
		ES4Label_28.setBounds(361, 27, 14, 193);
		panel_14.add(ES4Label_28);		
		
		JLabel ES4Label_1_1 = new JLabel("1");
		ES4Label_1_1.setFont(new Font("Vrinda", Font.PLAIN, 12));
		ES4Label_1_1.setBounds(8, 10, 12, 15);
		panel_14.add(ES4Label_1_1);
		ES4Label_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel ES4Label_1_2 = new JLabel("2");
		ES4Label_1_2.setFont(new Font("Vrinda", Font.PLAIN, 11));
		ES4Label_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		ES4Label_1_2.setBounds(24, 10, 12, 15);
		panel_14.add(ES4Label_1_2);
		
		JLabel ES4Label_1_3 = new JLabel("3");
		ES4Label_1_3.setFont(new Font("Vrinda", Font.PLAIN, 11));
		ES4Label_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		ES4Label_1_3.setBounds(37, 10, 12, 15);
		panel_14.add(ES4Label_1_3);
		
		JLabel ES4Label_1_4 = new JLabel("4");
		ES4Label_1_4.setFont(new Font("Vrinda", Font.PLAIN, 11));
		ES4Label_1_4.setHorizontalAlignment(SwingConstants.CENTER);
		ES4Label_1_4.setBounds(50, 10, 12, 15);
		panel_14.add(ES4Label_1_4);
		
		JLabel ES4Label_1_5 = new JLabel("5");
		ES4Label_1_5.setFont(new Font("Vrinda", Font.PLAIN, 11));
		ES4Label_1_5.setHorizontalAlignment(SwingConstants.CENTER);
		ES4Label_1_5.setBounds(63, 10, 12, 15);
		panel_14.add(ES4Label_1_5);
		
		JLabel ES4Label_1_6 = new JLabel("6");
		ES4Label_1_6.setHorizontalAlignment(SwingConstants.CENTER);
		ES4Label_1_6.setFont(new Font("Vrinda", Font.PLAIN, 11));
		ES4Label_1_6.setBounds(76, 10, 12, 15);
		panel_14.add(ES4Label_1_6);
		
		JLabel ES4Label_1_7 = new JLabel("7");
		ES4Label_1_7.setHorizontalAlignment(SwingConstants.CENTER);
		ES4Label_1_7.setFont(new Font("Vrinda", Font.PLAIN, 11));
		ES4Label_1_7.setBounds(88, 10, 12, 15);
		panel_14.add(ES4Label_1_7);
		
		JLabel ES4Label_1_8 = new JLabel("8");
		ES4Label_1_8.setHorizontalAlignment(SwingConstants.CENTER);
		ES4Label_1_8.setFont(new Font("Vrinda", Font.PLAIN, 11));
		ES4Label_1_8.setBounds(101, 10, 12, 15);
		panel_14.add(ES4Label_1_8);
		
		JLabel ES4Label_1_9 = new JLabel("9");
		ES4Label_1_9.setHorizontalAlignment(SwingConstants.CENTER);
		ES4Label_1_9.setFont(new Font("Vrinda", Font.PLAIN, 11));
		ES4Label_1_9.setBounds(114, 10, 12, 15);
		panel_14.add(ES4Label_1_9);
		
		JLabel ES4Label_1_10 = new JLabel("10");
		ES4Label_1_10.setHorizontalAlignment(SwingConstants.CENTER);
		ES4Label_1_10.setFont(new Font("Vrinda", Font.PLAIN, 10));
		ES4Label_1_10.setBounds(127, 10, 12, 15);
		panel_14.add(ES4Label_1_10);
		
		JLabel ES4Label_1_11 = new JLabel("11");
		ES4Label_1_11.setHorizontalAlignment(SwingConstants.CENTER);
		ES4Label_1_11.setFont(new Font("Vrinda", Font.PLAIN, 10));
		ES4Label_1_11.setBounds(141, 10, 12, 15);
		panel_14.add(ES4Label_1_11);
		
		JLabel ES4Label_1_12 = new JLabel("12");
		ES4Label_1_12.setHorizontalAlignment(SwingConstants.CENTER);
		ES4Label_1_12.setFont(new Font("Vrinda", Font.PLAIN, 10));
		ES4Label_1_12.setBounds(154, 10, 12, 15);
		panel_14.add(ES4Label_1_12);
		
		JLabel ES4Label_1_13 = new JLabel("13");
		ES4Label_1_13.setHorizontalAlignment(SwingConstants.CENTER);
		ES4Label_1_13.setFont(new Font("Vrinda", Font.PLAIN, 10));
		ES4Label_1_13.setBounds(167, 10, 12, 15);
		panel_14.add(ES4Label_1_13);
		
		JLabel ES4Label_1_14 = new JLabel("14");
		ES4Label_1_14.setHorizontalAlignment(SwingConstants.CENTER);
		ES4Label_1_14.setFont(new Font("Vrinda", Font.PLAIN, 10));
		ES4Label_1_14.setBounds(180, 10, 12, 15);
		panel_14.add(ES4Label_1_14);
		
		JLabel ES4Label_1_15 = new JLabel("15");
		ES4Label_1_15.setHorizontalAlignment(SwingConstants.CENTER);
		ES4Label_1_15.setFont(new Font("Vrinda", Font.PLAIN, 10));
		ES4Label_1_15.setBounds(193, 10, 12, 15);
		panel_14.add(ES4Label_1_15);
		
		JLabel ES4Label_1_16 = new JLabel("16");
		ES4Label_1_16.setHorizontalAlignment(SwingConstants.CENTER);
		ES4Label_1_16.setFont(new Font("Vrinda", Font.PLAIN, 10));
		ES4Label_1_16.setBounds(206, 10, 12, 15);
		panel_14.add(ES4Label_1_16);
		
		JLabel ES4Label_1_17 = new JLabel("17");
		ES4Label_1_17.setHorizontalAlignment(SwingConstants.CENTER);
		ES4Label_1_17.setFont(new Font("Vrinda", Font.PLAIN, 10));
		ES4Label_1_17.setBounds(219, 10, 12, 15);
		panel_14.add(ES4Label_1_17);
		
		JLabel ES4Label_1_18 = new JLabel("18");
		ES4Label_1_18.setHorizontalAlignment(SwingConstants.CENTER);
		ES4Label_1_18.setFont(new Font("Vrinda", Font.PLAIN, 10));
		ES4Label_1_18.setBounds(232, 10, 12, 15);
		panel_14.add(ES4Label_1_18);
		
		JLabel ES4Label_1_19 = new JLabel("19");
		ES4Label_1_19.setHorizontalAlignment(SwingConstants.CENTER);
		ES4Label_1_19.setFont(new Font("Vrinda", Font.PLAIN, 10));
		ES4Label_1_19.setBounds(245, 10, 12, 15);
		panel_14.add(ES4Label_1_19);
		
		JLabel ES4Label_1_20 = new JLabel("20");
		ES4Label_1_20.setHorizontalAlignment(SwingConstants.CENTER);
		ES4Label_1_20.setFont(new Font("Vrinda", Font.PLAIN, 10));
		ES4Label_1_20.setBounds(258, 10, 12, 15);
		panel_14.add(ES4Label_1_20);
		
		JLabel ES4Label_1_21 = new JLabel("21");
		ES4Label_1_21.setHorizontalAlignment(SwingConstants.CENTER);
		ES4Label_1_21.setFont(new Font("Vrinda", Font.PLAIN, 10));
		ES4Label_1_21.setBounds(271, 10, 12, 15);
		panel_14.add(ES4Label_1_21);				
		
		JLabel ES4Label_1_22 = new JLabel("22");		
		ES4Label_1_22.setHorizontalAlignment(SwingConstants.CENTER);
		ES4Label_1_22.setFont(new Font("Vrinda", Font.PLAIN, 10));
		ES4Label_1_22.setBounds(284, 10, 12, 15);
		panel_14.add(ES4Label_1_22);
		
		JLabel ES4Label_1_23 = new JLabel("23");		
		ES4Label_1_23.setHorizontalAlignment(SwingConstants.CENTER);
		ES4Label_1_23.setFont(new Font("Vrinda", Font.PLAIN, 10));
		ES4Label_1_23.setBounds(297, 10, 12, 15);
		panel_14.add(ES4Label_1_23);
		
		JLabel ES4Label_1_24 = new JLabel("24");		
		ES4Label_1_24.setHorizontalAlignment(SwingConstants.CENTER);
		ES4Label_1_24.setFont(new Font("Vrinda", Font.PLAIN, 10));
		ES4Label_1_24.setBounds(310, 10, 12, 15);
		panel_14.add(ES4Label_1_24);
		
		JLabel ES4Label_1_25 = new JLabel("25");
		ES4Label_1_25.setHorizontalAlignment(SwingConstants.CENTER);
		ES4Label_1_25.setFont(new Font("Vrinda", Font.PLAIN, 10));
		ES4Label_1_25.setBounds(323, 10, 12, 15);
		panel_14.add(ES4Label_1_25);
		
		JLabel ES4Label_1_26 = new JLabel("26");
		ES4Label_1_26.setHorizontalAlignment(SwingConstants.CENTER);
		ES4Label_1_26.setFont(new Font("Vrinda", Font.PLAIN, 10));
		ES4Label_1_26.setBounds(336, 10, 12, 15);
		panel_14.add(ES4Label_1_26);
		
		JLabel ES4Label_1_27 = new JLabel("27");
		ES4Label_1_27.setHorizontalAlignment(SwingConstants.CENTER);
		ES4Label_1_27.setFont(new Font("Vrinda", Font.PLAIN, 10));
		ES4Label_1_27.setBounds(349, 10, 12, 15);
		panel_14.add(ES4Label_1_27);
		
		JLabel ES4Label_1_28 = new JLabel("28");
		ES4Label_1_28.setHorizontalAlignment(SwingConstants.CENTER);
		ES4Label_1_28.setFont(new Font("Vrinda", Font.PLAIN, 12));
		ES4Label_1_28.setBounds(364, 10, 14, 15);
		panel_14.add(ES4Label_1_28);
								
		
		JLabel ES4Label = new JLabel("Subrack ES-4");
		ES4Label.setBounds(293, 231, 99, 14);
		panel_14.add(ES4Label);
		/////////////////////////////////////////////////////////////////////////////////////////////
		JPanel panel_9 = new JPanel();
		tabbedPane.addTab("ES-5", null, panel_9, null);
		// -
		panel_9.setLayout(null);
		
		JPanel panel_15 = new JPanel();
		panel_15.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_15.setBounds(10, 30, 392, 247);
		panel_9.add(panel_15);
		panel_15.setLayout(null);								
		
		JLabel ES5Label_1 = new JLabel("");
		ES5Label_1.setBounds(10, 27, 14, 193);
		panel_15.add(ES5Label_1);
		ES5Label_1.setIcon(new ImageIcon(rncMain.class.getResource("/images/SCXB3.png")));
		
		JLabel ES5Label_2 = new JLabel("");
		ES5Label_2.setBounds(23, 27, 14, 193);
		panel_15.add(ES5Label_2);
		ES5Label_2.setIcon(new ImageIcon(rncMain.class.getResource("/images/CMXB3.png")));
				
		  ES5Label_3 = new JLabel(""); //Slot 3
		ES5Label_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent arg0) {
				if (RNC.get_ES5_SlotData_byName("3") == -1){
					ES5Label_3.setIcon(Board);
				}
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (RNC.get_ES5_SlotData_byName("3") == -1){
					ES5Label_3.setIcon(Board_selected);
					SlotData newBoard = new SlotData();
					newBoard.set_Slot("3");
					RNC.add_ES5_SlotData(newBoard);
					textField.setText(String.valueOf(RNC.get_Total_Board()));
					textField_1.setText(RNC.get_Total_Board_List());
				}else{
					ES5Label_3.setIcon(Board);
					RNC.delete_ES5_SlotData_byName("3");
					textField.setText(String.valueOf(RNC.get_Total_Board()));
					textField_1.setText(RNC.get_Total_Board_List());
				}
			}
		});
		ES5Label_3.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
				if (RNC.get_ES5_SlotData_byName("3") == -1){
					ES5Label_3.setIcon(Board_over);
				}
			}
		});
		ES5Label_3.setBounds(36, 27, 14, 193);
		panel_15.add(ES5Label_3);
		ES5Label_3.setIcon(Board);
		
		  ES5Label_4 = new JLabel(""); //Slot 4
		ES5Label_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent arg0) {
				if (RNC.get_ES5_SlotData_byName("4") == -1){
					ES5Label_4.setIcon(Board);
				}
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (RNC.get_ES5_SlotData_byName("4") == -1){
					ES5Label_4.setIcon(Board_selected);
					SlotData newBoard = new SlotData();
					newBoard.set_Slot("4");
					RNC.add_ES5_SlotData(newBoard);
					textField.setText(String.valueOf(RNC.get_Total_Board()));
					textField_1.setText(RNC.get_Total_Board_List());
				}else{
					ES5Label_4.setIcon(Board);
					RNC.delete_ES5_SlotData_byName("4");
					textField.setText(String.valueOf(RNC.get_Total_Board()));
					textField_1.setText(RNC.get_Total_Board_List());
				}
			}
		});
		ES5Label_4.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
				if (RNC.get_ES5_SlotData_byName("4") == -1){
					ES5Label_4.setIcon(Board_over);
				}
			}
		});
		ES5Label_4.setBounds(49, 27, 14, 193);
		panel_15.add(ES5Label_4);
		ES5Label_4.setIcon(Board);
		
		
		  ES5Label_5 = new JLabel(""); //Slot 5
		ES5Label_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent arg0) {
				if (RNC.get_ES5_SlotData_byName("5") == -1){
					ES5Label_5.setIcon(Board);
				}
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (RNC.get_ES5_SlotData_byName("5") == -1){
					ES5Label_5.setIcon(Board_selected);
					SlotData newBoard = new SlotData();
					newBoard.set_Slot("5");
					RNC.add_ES5_SlotData(newBoard);
					textField.setText(String.valueOf(RNC.get_Total_Board()));
					textField_1.setText(RNC.get_Total_Board_List());
				}else{
					ES5Label_5.setIcon(Board);
					RNC.delete_ES5_SlotData_byName("5");
					textField.setText(String.valueOf(RNC.get_Total_Board()));
					textField_1.setText(RNC.get_Total_Board_List());
				}
			}
		});
		ES5Label_5.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
				if (RNC.get_ES5_SlotData_byName("5") == -1){
					ES5Label_5.setIcon(Board_over);
				}
			}
		});
		ES5Label_5.setBounds(62, 27, 14, 193);
		panel_15.add(ES5Label_5);
		ES5Label_5.setIcon(Board);
		
		  ES5Label_6 = new JLabel(""); //Slot 6
		ES5Label_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent arg0) {
				if (RNC.get_ES5_SlotData_byName("6") == -1){
					ES5Label_6.setIcon(Board);
				}
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (RNC.get_ES5_SlotData_byName("6") == -1){
					ES5Label_6.setIcon(Board_selected);
					SlotData newBoard = new SlotData();
					newBoard.set_Slot("6");
					RNC.add_ES5_SlotData(newBoard);
					textField.setText(String.valueOf(RNC.get_Total_Board()));
					textField_1.setText(RNC.get_Total_Board_List());
				}else{
					ES5Label_6.setIcon(Board);
					RNC.delete_ES5_SlotData_byName("6");
					textField.setText(String.valueOf(RNC.get_Total_Board()));
					textField_1.setText(RNC.get_Total_Board_List());
				}
			}
		});
		ES5Label_6.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
				if (RNC.get_ES5_SlotData_byName("6") == -1){
					ES5Label_6.setIcon(Board_over);
				}	
			}
		});
		ES5Label_6.setIcon(Board);		
		ES5Label_6.setBounds(75, 27, 14, 193);
		panel_15.add(ES5Label_6);
		
		  ES5Label_7 = new JLabel(""); //Slot 7
		ES5Label_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent arg0) {
				if (RNC.get_ES5_SlotData_byName("7") == -1){
					ES5Label_7.setIcon(Board);
				}
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (RNC.get_ES5_SlotData_byName("7") == -1){
					ES5Label_7.setIcon(Board_selected);
					SlotData newBoard = new SlotData();
					newBoard.set_Slot("7");
					RNC.add_ES5_SlotData(newBoard);
					textField.setText(String.valueOf(RNC.get_Total_Board()));
					textField_1.setText(RNC.get_Total_Board_List());
				}else{
					ES5Label_7.setIcon(Board);
					RNC.delete_ES5_SlotData_byName("7");
					textField.setText(String.valueOf(RNC.get_Total_Board()));
					textField_1.setText(RNC.get_Total_Board_List());
				}
			}
		});
		ES5Label_7.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
				if (RNC.get_ES5_SlotData_byName("7") == -1){
					ES5Label_7.setIcon(Board_over);
				}
			}
		});
		ES5Label_7.setIcon(Board);
		ES5Label_7.setBounds(88, 27, 14, 193);
		panel_15.add(ES5Label_7);
		
		  ES5Label_8 = new JLabel(""); // Slot 8
		ES5Label_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent arg0) {
				if (RNC.get_ES5_SlotData_byName("8") == -1){
					ES5Label_8.setIcon(Board);
				}	
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (RNC.get_ES5_SlotData_byName("8") == -1){
					ES5Label_8.setIcon(Board_selected);
					SlotData newBoard = new SlotData();
					newBoard.set_Slot("8");
					RNC.add_ES5_SlotData(newBoard);
					textField.setText(String.valueOf(RNC.get_Total_Board()));
					textField_1.setText(RNC.get_Total_Board_List());
				}else{
					ES5Label_8.setIcon(Board);
					RNC.delete_ES5_SlotData_byName("8");
					textField.setText(String.valueOf(RNC.get_Total_Board()));
					textField_1.setText(RNC.get_Total_Board_List());
				}
			}
		});
		ES5Label_8.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
				if (RNC.get_ES5_SlotData_byName("8") == -1){
					ES5Label_8.setIcon(Board_over);
				}	
			}
		});
		ES5Label_8.setIcon(Board);
		ES5Label_8.setBounds(101, 27, 14, 193);
		panel_15.add(ES5Label_8);
		
		  ES5Label_9 = new JLabel(""); // Slot 9
		ES5Label_9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent arg0) {
				if (RNC.get_ES5_SlotData_byName("9") == -1){
					ES5Label_9.setIcon(Board);
				}	
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (RNC.get_ES5_SlotData_byName("9") == -1){
					ES5Label_9.setIcon(Board_selected);
					SlotData newBoard = new SlotData();
					newBoard.set_Slot("9");
					RNC.add_ES5_SlotData(newBoard);
					textField.setText(String.valueOf(RNC.get_Total_Board()));
					textField_1.setText(RNC.get_Total_Board_List());
				}else{
					ES5Label_9.setIcon(Board);
					RNC.delete_ES5_SlotData_byName("9");
					textField.setText(String.valueOf(RNC.get_Total_Board()));
					textField_1.setText(RNC.get_Total_Board_List());
				}
			}
		});
		ES5Label_9.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
				if (RNC.get_ES5_SlotData_byName("9") == -1){
					ES5Label_9.setIcon(Board_over);
				}
			}
		});
		ES5Label_9.setIcon(Board);
		ES5Label_9.setBounds(114, 27, 14, 193);
		panel_15.add(ES5Label_9);
		
		  ES5Label_10 = new JLabel(""); // Slot 10
		ES5Label_10.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent arg0) {
				if (RNC.get_ES5_SlotData_byName("10") == -1){
					ES5Label_10.setIcon(Board);
				}
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (RNC.get_ES5_SlotData_byName("10") == -1){
					ES5Label_10.setIcon(Board_selected);
					SlotData newBoard = new SlotData();
					newBoard.set_Slot("10");
					RNC.add_ES5_SlotData(newBoard);
					textField.setText(String.valueOf(RNC.get_Total_Board()));
					textField_1.setText(RNC.get_Total_Board_List());
				}else{
					ES5Label_10.setIcon(Board);
					RNC.delete_ES5_SlotData_byName("10");
					textField.setText(String.valueOf(RNC.get_Total_Board()));
					textField_1.setText(RNC.get_Total_Board_List());
				}
			}
		});
		ES5Label_10.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
				if (RNC.get_ES5_SlotData_byName("10") == -1){
					ES5Label_10.setIcon(Board_over);
				}
			}
		});
		ES5Label_10.setIcon(Board);
		ES5Label_10.setBounds(127, 27, 14, 193);
		panel_15.add(ES5Label_10);
		
		  ES5Label_11 = new JLabel(""); //Slot 11
		ES5Label_11.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent arg0) {
				if (RNC.get_ES5_SlotData_byName("11") == -1){
					ES5Label_11.setIcon(Board);			
				}
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (RNC.get_ES5_SlotData_byName("11") == -1){
					ES5Label_11.setIcon(Board_selected);
					SlotData newBoard = new SlotData();
					newBoard.set_Slot("11");
					RNC.add_ES5_SlotData(newBoard);
					textField.setText(String.valueOf(RNC.get_Total_Board()));
					textField_1.setText(RNC.get_Total_Board_List());
				}else{
					ES5Label_11.setIcon(Board);
					RNC.delete_ES5_SlotData_byName("11");
					textField.setText(String.valueOf(RNC.get_Total_Board()));
					textField_1.setText(RNC.get_Total_Board_List());
				}
			}
		});
		ES5Label_11.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
				if (RNC.get_ES5_SlotData_byName("11") == -1){
					ES5Label_11.setIcon(Board_over);
				}
			}
		});
		ES5Label_11.setIcon(Board);
		ES5Label_11.setBounds(140, 27, 14, 193);
		panel_15.add(ES5Label_11);
		
		
		  ES5Label_12 = new JLabel(""); // Slot 12
		ES5Label_12.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent arg0) {
				if (RNC.get_ES5_SlotData_byName("12") == -1){
					ES5Label_12.setIcon(Board);
				}
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (RNC.get_ES5_SlotData_byName("12") == -1){
					ES5Label_12.setIcon(Board_selected);
					SlotData newBoard = new SlotData();
					newBoard.set_Slot("12");
					RNC.add_ES5_SlotData(newBoard);
					textField.setText(String.valueOf(RNC.get_Total_Board()));
					textField_1.setText(RNC.get_Total_Board_List());
				}else{
					ES5Label_12.setIcon(Board);
					RNC.delete_ES5_SlotData_byName("12");
					textField.setText(String.valueOf(RNC.get_Total_Board()));
					textField_1.setText(RNC.get_Total_Board_List());
				}
			}
		});
		ES5Label_12.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
				if (RNC.get_ES5_SlotData_byName("12") == -1){
					ES5Label_12.setIcon(Board_over);
				}
			}
		});
		ES5Label_12.setIcon(Board);
		ES5Label_12.setBounds(153, 27, 14, 193);
		panel_15.add(ES5Label_12);
		
		  ES5Label_13 = new JLabel(""); // Slot 13
		ES5Label_13.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent arg0) {
				if (RNC.get_ES5_SlotData_byName("13") == -1){
					ES5Label_13.setIcon(Board);
				}	
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (RNC.get_ES5_SlotData_byName("13") == -1){
					ES5Label_13.setIcon(Board_selected);
					SlotData newBoard = new SlotData();
					newBoard.set_Slot("13");
					RNC.add_ES5_SlotData(newBoard);
					textField.setText(String.valueOf(RNC.get_Total_Board()));
					textField_1.setText(RNC.get_Total_Board_List());
				}else{
					ES5Label_13.setIcon(Board);
					RNC.delete_ES5_SlotData_byName("13");
					textField.setText(String.valueOf(RNC.get_Total_Board()));
					textField_1.setText(RNC.get_Total_Board_List());
				}
			}
		});
		ES5Label_13.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
				if (RNC.get_ES5_SlotData_byName("13") == -1){
					ES5Label_13.setIcon(Board_over);
				}
			}
		});
		ES5Label_13.setIcon(Board);
		ES5Label_13.setBounds(166, 27, 14, 193);
		panel_15.add(ES5Label_13);
		
		  ES5Label_14 = new JLabel(""); // Slot 14
		ES5Label_14.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent arg0) {
				if (RNC.get_ES5_SlotData_byName("14") == -1){
					ES5Label_14.setIcon(Board);
				}
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (RNC.get_ES5_SlotData_byName("14") == -1){
					ES5Label_14.setIcon(Board_selected);
					SlotData newBoard = new SlotData();
					newBoard.set_Slot("14");
					RNC.add_ES5_SlotData(newBoard);
					textField.setText(String.valueOf(RNC.get_Total_Board()));
					textField_1.setText(RNC.get_Total_Board_List());
				}else{
					ES5Label_14.setIcon(Board);
					RNC.delete_ES5_SlotData_byName("14");
					textField.setText(String.valueOf(RNC.get_Total_Board()));
					textField_1.setText(RNC.get_Total_Board_List());
				}
			}
		});
		ES5Label_14.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
				if (RNC.get_ES5_SlotData_byName("14") == -1){
					ES5Label_14.setIcon(Board_over);
				}
			}
		});
		ES5Label_14.setIcon(Board);
		ES5Label_14.setBounds(179, 27, 14, 193);
		panel_15.add(ES5Label_14);
		
		  ES5Label_15 = new JLabel(""); // Slot 15
		ES5Label_15.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent arg0) {
				if (RNC.get_ES5_SlotData_byName("15") == -1){
					ES5Label_15.setIcon(Board);
				}
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (RNC.get_ES5_SlotData_byName("15") == -1){
					ES5Label_15.setIcon(Board_selected);
					SlotData newBoard = new SlotData();
					newBoard.set_Slot("15");
					RNC.add_ES5_SlotData(newBoard);
					textField.setText(String.valueOf(RNC.get_Total_Board()));
					textField_1.setText(RNC.get_Total_Board_List());
				}else{
					ES5Label_15.setIcon(Board);
					RNC.delete_ES5_SlotData_byName("15");
					textField.setText(String.valueOf(RNC.get_Total_Board()));
					textField_1.setText(RNC.get_Total_Board_List());
				}
			}
		});
		ES5Label_15.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
				if (RNC.get_ES5_SlotData_byName("15") == -1){
					ES5Label_15.setIcon(Board_over);
				}
			}
		});
		ES5Label_15.setIcon(Board);
		ES5Label_15.setBounds(192, 27, 14, 193);
		panel_15.add(ES5Label_15);
		
		  ES5Label_16 = new JLabel(""); //Slot 16
		ES5Label_16.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent arg0) {
				if (RNC.get_ES5_SlotData_byName("16") == -1){
					ES5Label_16.setIcon(Board);
				}
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (RNC.get_ES5_SlotData_byName("16") == -1){
					ES5Label_16.setIcon(Board_selected);
					SlotData newBoard = new SlotData();
					newBoard.set_Slot("16");
					RNC.add_ES5_SlotData(newBoard);
					textField.setText(String.valueOf(RNC.get_Total_Board()));
					textField_1.setText(RNC.get_Total_Board_List());
				}else{
					ES5Label_16.setIcon(Board);
					RNC.delete_ES5_SlotData_byName("16");
					textField.setText(String.valueOf(RNC.get_Total_Board()));
					textField_1.setText(RNC.get_Total_Board_List());
				}
			}
		});
		ES5Label_16.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
				if (RNC.get_ES5_SlotData_byName("16") == -1){
					ES5Label_16.setIcon(Board_over);
				}
			}
		});
		ES5Label_16.setIcon(Board);
		ES5Label_16.setBounds(205, 27, 14, 193);
		panel_15.add(ES5Label_16);
		
		  ES5Label_17 = new JLabel(""); // Slot 17
		ES5Label_17.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent arg0) {
				if (RNC.get_ES5_SlotData_byName("17") == -1){
					ES5Label_17.setIcon(Board);
				}
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (RNC.get_ES5_SlotData_byName("17") == -1){
					ES5Label_17.setIcon(Board_selected);
					SlotData newBoard = new SlotData();
					newBoard.set_Slot("17");
					RNC.add_ES5_SlotData(newBoard);
					textField.setText(String.valueOf(RNC.get_Total_Board()));
					textField_1.setText(RNC.get_Total_Board_List());
				}else{
					ES5Label_17.setIcon(Board);
					RNC.delete_ES5_SlotData_byName("17");
					textField.setText(String.valueOf(RNC.get_Total_Board()));
					textField_1.setText(RNC.get_Total_Board_List());
				}
			}
		});
		ES5Label_17.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
				if (RNC.get_ES5_SlotData_byName("17") == -1){
					ES5Label_17.setIcon(Board_over);
				}
			}
		});
		ES5Label_17.setIcon(Board);
		ES5Label_17.setBounds(218, 27, 14, 193);
		panel_15.add(ES5Label_17);
		
		  ES5Label_18 = new JLabel(""); // Slot 18
		ES5Label_18.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent arg0) {
				if (RNC.get_ES5_SlotData_byName("18") == -1){
					ES5Label_18.setIcon(Board);
				}
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (RNC.get_ES5_SlotData_byName("18") == -1){
					ES5Label_18.setIcon(Board_selected);
					SlotData newBoard = new SlotData();
					newBoard.set_Slot("18");
					RNC.add_ES5_SlotData(newBoard);
					textField.setText(String.valueOf(RNC.get_Total_Board()));
					textField_1.setText(RNC.get_Total_Board_List());
				}else{
					ES5Label_18.setIcon(Board);
					RNC.delete_ES5_SlotData_byName("18");
					textField.setText(String.valueOf(RNC.get_Total_Board()));
					textField_1.setText(RNC.get_Total_Board_List());
				}
			}
		});
		ES5Label_18.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
				if (RNC.get_ES5_SlotData_byName("18") == -1){
					ES5Label_18.setIcon(Board_over);
				}
			}
		});
		ES5Label_18.setIcon(Board);
		ES5Label_18.setBounds(231, 27, 14, 193);
		panel_15.add(ES5Label_18);
		
		  ES5Label_19 = new JLabel(""); // Slot 19
		ES5Label_19.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent arg0) {
				if (RNC.get_ES5_SlotData_byName("19") == -1){
					ES5Label_19.setIcon(Board);
				}
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (RNC.get_ES5_SlotData_byName("19") == -1){
					ES5Label_19.setIcon(Board_selected);
					SlotData newBoard = new SlotData();
					newBoard.set_Slot("19");
					RNC.add_ES5_SlotData(newBoard);
					textField.setText(String.valueOf(RNC.get_Total_Board()));
					textField_1.setText(RNC.get_Total_Board_List());
				}else{
					ES5Label_19.setIcon(Board);
					RNC.delete_ES5_SlotData_byName("19");
					textField.setText(String.valueOf(RNC.get_Total_Board()));
					textField_1.setText(RNC.get_Total_Board_List());
				}
			}
		});
		ES5Label_19.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
				if (RNC.get_ES5_SlotData_byName("19") == -1){
					ES5Label_19.setIcon(Board_over);
				}
			}
		});
		ES5Label_19.setIcon(Board);
		ES5Label_19.setBounds(244, 27, 14, 193);
		panel_15.add(ES5Label_19);
		
		  ES5Label_20 = new JLabel(""); // Slot 20
		ES5Label_20.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent arg0) {
				if (RNC.get_ES5_SlotData_byName("20") == -1){
					ES5Label_20.setIcon(Board);
				}
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (RNC.get_ES5_SlotData_byName("20") == -1){
					ES5Label_20.setIcon(Board_selected);
					SlotData newBoard = new SlotData();
					newBoard.set_Slot("20");
					RNC.add_ES5_SlotData(newBoard);
					textField.setText(String.valueOf(RNC.get_Total_Board()));
					textField_1.setText(RNC.get_Total_Board_List());
				}else{
					ES5Label_20.setIcon(Board);
					RNC.delete_ES5_SlotData_byName("20");
					textField.setText(String.valueOf(RNC.get_Total_Board()));
					textField_1.setText(RNC.get_Total_Board_List());
				}
			}
		});
		ES5Label_20.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
				if (RNC.get_ES5_SlotData_byName("20") == -1){
					ES5Label_20.setIcon(Board_over);
				}
			}
		});
		ES5Label_20.setIcon(Board);
		ES5Label_20.setBounds(257, 27, 14, 193);
		panel_15.add(ES5Label_20);
		
		  ES5Label_21 = new JLabel(""); // Slot 21
		ES5Label_21.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent arg0) {
				if (RNC.get_ES5_SlotData_byName("21") == -1){
					ES5Label_21.setIcon(Board);
				}
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (RNC.get_ES5_SlotData_byName("21") == -1){
					ES5Label_21.setIcon(Board_selected);
					SlotData newBoard = new SlotData();
					newBoard.set_Slot("21");
					RNC.add_ES5_SlotData(newBoard);
					textField.setText(String.valueOf(RNC.get_Total_Board()));
					textField_1.setText(RNC.get_Total_Board_List());
				}else{
					ES5Label_21.setIcon(Board);
					RNC.delete_ES5_SlotData_byName("21");
					textField.setText(String.valueOf(RNC.get_Total_Board()));
					textField_1.setText(RNC.get_Total_Board_List());
				}
			}
		});
		ES5Label_21.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
				if (RNC.get_ES5_SlotData_byName("21") == -1){
					ES5Label_21.setIcon(Board_over);
				}
			}
		});
		ES5Label_21.setIcon(Board);
		ES5Label_21.setBounds(270, 27, 14, 193);
		panel_15.add(ES5Label_21);
		
		  ES5Label_22 = new JLabel(""); // Slot 22
		ES5Label_22.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent arg0) {
				if (RNC.get_ES5_SlotData_byName("22") == -1){
					ES5Label_22.setIcon(Board);
				}
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (RNC.get_ES5_SlotData_byName("22") == -1){
					ES5Label_22.setIcon(Board_selected);
					SlotData newBoard = new SlotData();
					newBoard.set_Slot("22");
					RNC.add_ES5_SlotData(newBoard);
					textField.setText(String.valueOf(RNC.get_Total_Board()));
					textField_1.setText(RNC.get_Total_Board_List());
				}else{
					ES5Label_22.setIcon(Board);
					RNC.delete_ES5_SlotData_byName("22");
					textField.setText(String.valueOf(RNC.get_Total_Board()));
					textField_1.setText(RNC.get_Total_Board_List());
				}
			}
		});
		ES5Label_22.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
				if (RNC.get_ES5_SlotData_byName("22") == -1){
					ES5Label_22.setIcon(Board_over);
				}
			}
		});
		ES5Label_22.setIcon(Board);
		ES5Label_22.setBounds(283, 27, 14, 193);
		panel_15.add(ES5Label_22);
		
		  ES5Label_23 = new JLabel(""); // Slot 23
		ES5Label_23.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent arg0) {
				if (RNC.get_ES5_SlotData_byName("23") == -1){
					ES5Label_23.setIcon(Board);
				}
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (RNC.get_ES5_SlotData_byName("23") == -1){
					ES5Label_23.setIcon(Board_selected);
					SlotData newBoard = new SlotData();
					newBoard.set_Slot("23");
					RNC.add_ES5_SlotData(newBoard);
					textField.setText(String.valueOf(RNC.get_Total_Board()));
					textField_1.setText(RNC.get_Total_Board_List());
				}else{
					ES5Label_23.setIcon(Board);
					RNC.delete_ES5_SlotData_byName("23");
					textField.setText(String.valueOf(RNC.get_Total_Board()));
					textField_1.setText(RNC.get_Total_Board_List());
				}
			}
		});
		ES5Label_23.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
				if (RNC.get_ES5_SlotData_byName("23") == -1){
					ES5Label_23.setIcon(Board_over);
				}
			}
		});
		ES5Label_23.setIcon(Board);
		ES5Label_23.setBounds(296, 27, 14, 193);
		panel_15.add(ES5Label_23);
		
		  ES5Label_24 = new JLabel(""); // Slot 24
		ES5Label_24.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent arg0) {
				if (RNC.get_ES5_SlotData_byName("24") == -1){
					ES5Label_24.setIcon(Board);
				}
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (RNC.get_ES5_SlotData_byName("24") == -1){
					ES5Label_24.setIcon(Board_selected);
					SlotData newBoard = new SlotData();
					newBoard.set_Slot("24");
					RNC.add_ES5_SlotData(newBoard);
					textField.setText(String.valueOf(RNC.get_Total_Board()));
					textField_1.setText(RNC.get_Total_Board_List());
				}else{
					ES5Label_24.setIcon(Board);
					RNC.delete_ES5_SlotData_byName("24");
					textField.setText(String.valueOf(RNC.get_Total_Board()));
					textField_1.setText(RNC.get_Total_Board_List());
				}
			}
		});
		ES5Label_24.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
				if (RNC.get_ES5_SlotData_byName("24") == -1){
					ES5Label_24.setIcon(Board_over);
				}
			}
		});
		ES5Label_24.setIcon(Board);
		ES5Label_24.setBounds(309, 27, 14, 193);
		panel_15.add(ES5Label_24);
		
		  ES5Label_25 = new JLabel(""); // Slot 25
		ES5Label_25.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent arg0) {
				if (RNC.get_ES5_SlotData_byName("25") == -1){
					ES5Label_25.setIcon(Board);
				}
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (RNC.get_ES5_SlotData_byName("25") == -1){
					ES5Label_25.setIcon(Board_selected);
					SlotData newBoard = new SlotData();
					newBoard.set_Slot("25");
					RNC.add_ES5_SlotData(newBoard);
					textField.setText(String.valueOf(RNC.get_Total_Board()));
					textField_1.setText(RNC.get_Total_Board_List());
				}else{
					ES5Label_25.setIcon(Board);
					RNC.delete_ES5_SlotData_byName("25");
					textField.setText(String.valueOf(RNC.get_Total_Board()));
					textField_1.setText(RNC.get_Total_Board_List());
				}
			}
		});
		ES5Label_25.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
				if (RNC.get_ES5_SlotData_byName("25") == -1){
					ES5Label_25.setIcon(Board_over);
				}
			}
		});
		ES5Label_25.setIcon(Board);
		ES5Label_25.setBounds(322, 27, 14, 193);
		panel_15.add(ES5Label_25);
		
		  ES5Label_26 = new JLabel(""); // Slot 26
		ES5Label_26.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent arg0) {
				if (RNC.get_ES5_SlotData_byName("26") == -1){
					ES5Label_26.setIcon(Board);
				}
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (RNC.get_ES5_SlotData_byName("26") == -1){
					ES5Label_26.setIcon(Board_selected);
					SlotData newBoard = new SlotData();
					newBoard.set_Slot("26");
					RNC.add_ES5_SlotData(newBoard);
					textField.setText(String.valueOf(RNC.get_Total_Board()));
					textField_1.setText(RNC.get_Total_Board_List());
				}else{
					ES5Label_26.setIcon(Board);
					RNC.delete_ES5_SlotData_byName("26");
					textField.setText(String.valueOf(RNC.get_Total_Board()));
					textField_1.setText(RNC.get_Total_Board_List());
				}
			}
		});
		ES5Label_26.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
				if (RNC.get_ES5_SlotData_byName("26") == -1){
					ES5Label_26.setIcon(Board_over);
				}
			}
		});
		ES5Label_26.setIcon(Board);
		ES5Label_26.setBounds(335, 27, 14, 193);
		panel_15.add(ES5Label_26);
		
		JLabel ES5Label_27 = new JLabel("");
		ES5Label_27.setIcon(new ImageIcon(rncMain.class.getResource("/images/SCXB3.png")));
		ES5Label_27.setBounds(348, 27, 14, 193);
		panel_15.add(ES5Label_27);
		
		JLabel ES5Label_28 = new JLabel("");
		ES5Label_28.setIcon(new ImageIcon(rncMain.class.getResource("/images/CMXB3.png")));
		ES5Label_28.setBounds(361, 27, 14, 193);
		panel_15.add(ES5Label_28);		
		
		JLabel ES5Label_1_1 = new JLabel("1");
		ES5Label_1_1.setFont(new Font("Vrinda", Font.PLAIN, 12));
		ES5Label_1_1.setBounds(8, 10, 12, 15);
		panel_15.add(ES5Label_1_1);
		ES5Label_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel ES5Label_1_2 = new JLabel("2");
		ES5Label_1_2.setFont(new Font("Vrinda", Font.PLAIN, 11));
		ES5Label_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		ES5Label_1_2.setBounds(24, 10, 12, 15);
		panel_15.add(ES5Label_1_2);
		
		JLabel ES5Label_1_3 = new JLabel("3");
		ES5Label_1_3.setFont(new Font("Vrinda", Font.PLAIN, 11));
		ES5Label_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		ES5Label_1_3.setBounds(37, 10, 12, 15);
		panel_15.add(ES5Label_1_3);
		
		JLabel ES5Label_1_4 = new JLabel("4");
		ES5Label_1_4.setFont(new Font("Vrinda", Font.PLAIN, 11));
		ES5Label_1_4.setHorizontalAlignment(SwingConstants.CENTER);
		ES5Label_1_4.setBounds(50, 10, 12, 15);
		panel_15.add(ES5Label_1_4);
		
		JLabel ES5Label_1_5 = new JLabel("5");
		ES5Label_1_5.setFont(new Font("Vrinda", Font.PLAIN, 11));
		ES5Label_1_5.setHorizontalAlignment(SwingConstants.CENTER);
		ES5Label_1_5.setBounds(63, 10, 12, 15);
		panel_15.add(ES5Label_1_5);
		
		JLabel ES5Label_1_6 = new JLabel("6");
		ES5Label_1_6.setHorizontalAlignment(SwingConstants.CENTER);
		ES5Label_1_6.setFont(new Font("Vrinda", Font.PLAIN, 11));
		ES5Label_1_6.setBounds(76, 10, 12, 15);
		panel_15.add(ES5Label_1_6);
		
		JLabel ES5Label_1_7 = new JLabel("7");
		ES5Label_1_7.setHorizontalAlignment(SwingConstants.CENTER);
		ES5Label_1_7.setFont(new Font("Vrinda", Font.PLAIN, 11));
		ES5Label_1_7.setBounds(88, 10, 12, 15);
		panel_15.add(ES5Label_1_7);
		
		JLabel ES5Label_1_8 = new JLabel("8");
		ES5Label_1_8.setHorizontalAlignment(SwingConstants.CENTER);
		ES5Label_1_8.setFont(new Font("Vrinda", Font.PLAIN, 11));
		ES5Label_1_8.setBounds(101, 10, 12, 15);
		panel_15.add(ES5Label_1_8);
		
		JLabel ES5Label_1_9 = new JLabel("9");
		ES5Label_1_9.setHorizontalAlignment(SwingConstants.CENTER);
		ES5Label_1_9.setFont(new Font("Vrinda", Font.PLAIN, 11));
		ES5Label_1_9.setBounds(114, 10, 12, 15);
		panel_15.add(ES5Label_1_9);
		
		JLabel ES5Label_1_10 = new JLabel("10");
		ES5Label_1_10.setHorizontalAlignment(SwingConstants.CENTER);
		ES5Label_1_10.setFont(new Font("Vrinda", Font.PLAIN, 10));
		ES5Label_1_10.setBounds(127, 10, 12, 15);
		panel_15.add(ES5Label_1_10);
		
		JLabel ES5Label_1_11 = new JLabel("11");
		ES5Label_1_11.setHorizontalAlignment(SwingConstants.CENTER);
		ES5Label_1_11.setFont(new Font("Vrinda", Font.PLAIN, 10));
		ES5Label_1_11.setBounds(141, 10, 12, 15);
		panel_15.add(ES5Label_1_11);
		
		JLabel ES5Label_1_12 = new JLabel("12");
		ES5Label_1_12.setHorizontalAlignment(SwingConstants.CENTER);
		ES5Label_1_12.setFont(new Font("Vrinda", Font.PLAIN, 10));
		ES5Label_1_12.setBounds(154, 10, 12, 15);
		panel_15.add(ES5Label_1_12);
		
		JLabel ES5Label_1_13 = new JLabel("13");
		ES5Label_1_13.setHorizontalAlignment(SwingConstants.CENTER);
		ES5Label_1_13.setFont(new Font("Vrinda", Font.PLAIN, 10));
		ES5Label_1_13.setBounds(167, 10, 12, 15);
		panel_15.add(ES5Label_1_13);
		
		JLabel ES5Label_1_14 = new JLabel("14");
		ES5Label_1_14.setHorizontalAlignment(SwingConstants.CENTER);
		ES5Label_1_14.setFont(new Font("Vrinda", Font.PLAIN, 10));
		ES5Label_1_14.setBounds(180, 10, 12, 15);
		panel_15.add(ES5Label_1_14);
		
		JLabel ES5Label_1_15 = new JLabel("15");
		ES5Label_1_15.setHorizontalAlignment(SwingConstants.CENTER);
		ES5Label_1_15.setFont(new Font("Vrinda", Font.PLAIN, 10));
		ES5Label_1_15.setBounds(193, 10, 12, 15);
		panel_15.add(ES5Label_1_15);
		
		JLabel ES5Label_1_16 = new JLabel("16");
		ES5Label_1_16.setHorizontalAlignment(SwingConstants.CENTER);
		ES5Label_1_16.setFont(new Font("Vrinda", Font.PLAIN, 10));
		ES5Label_1_16.setBounds(206, 10, 12, 15);
		panel_15.add(ES5Label_1_16);
		
		JLabel ES5Label_1_17 = new JLabel("17");
		ES5Label_1_17.setHorizontalAlignment(SwingConstants.CENTER);
		ES5Label_1_17.setFont(new Font("Vrinda", Font.PLAIN, 10));
		ES5Label_1_17.setBounds(219, 10, 12, 15);
		panel_15.add(ES5Label_1_17);
		
		JLabel ES5Label_1_18 = new JLabel("18");
		ES5Label_1_18.setHorizontalAlignment(SwingConstants.CENTER);
		ES5Label_1_18.setFont(new Font("Vrinda", Font.PLAIN, 10));
		ES5Label_1_18.setBounds(232, 10, 12, 15);
		panel_15.add(ES5Label_1_18);
		
		JLabel ES5Label_1_19 = new JLabel("19");
		ES5Label_1_19.setHorizontalAlignment(SwingConstants.CENTER);
		ES5Label_1_19.setFont(new Font("Vrinda", Font.PLAIN, 10));
		ES5Label_1_19.setBounds(245, 10, 12, 15);
		panel_15.add(ES5Label_1_19);
		
		JLabel ES5Label_1_20 = new JLabel("20");
		ES5Label_1_20.setHorizontalAlignment(SwingConstants.CENTER);
		ES5Label_1_20.setFont(new Font("Vrinda", Font.PLAIN, 10));
		ES5Label_1_20.setBounds(258, 10, 12, 15);
		panel_15.add(ES5Label_1_20);
		
		JLabel ES5Label_1_21 = new JLabel("21");
		ES5Label_1_21.setHorizontalAlignment(SwingConstants.CENTER);
		ES5Label_1_21.setFont(new Font("Vrinda", Font.PLAIN, 10));
		ES5Label_1_21.setBounds(271, 10, 12, 15);
		panel_15.add(ES5Label_1_21);				
		
		JLabel ES5Label_1_22 = new JLabel("22");		
		ES5Label_1_22.setHorizontalAlignment(SwingConstants.CENTER);
		ES5Label_1_22.setFont(new Font("Vrinda", Font.PLAIN, 10));
		ES5Label_1_22.setBounds(284, 10, 12, 15);
		panel_15.add(ES5Label_1_22);
		
		JLabel ES5Label_1_23 = new JLabel("23");		
		ES5Label_1_23.setHorizontalAlignment(SwingConstants.CENTER);
		ES5Label_1_23.setFont(new Font("Vrinda", Font.PLAIN, 10));
		ES5Label_1_23.setBounds(297, 10, 12, 15);
		panel_15.add(ES5Label_1_23);
		
		JLabel ES5Label_1_24 = new JLabel("24");		
		ES5Label_1_24.setHorizontalAlignment(SwingConstants.CENTER);
		ES5Label_1_24.setFont(new Font("Vrinda", Font.PLAIN, 10));
		ES5Label_1_24.setBounds(310, 10, 12, 15);
		panel_15.add(ES5Label_1_24);
		
		JLabel ES5Label_1_25 = new JLabel("25");
		ES5Label_1_25.setHorizontalAlignment(SwingConstants.CENTER);
		ES5Label_1_25.setFont(new Font("Vrinda", Font.PLAIN, 10));
		ES5Label_1_25.setBounds(323, 10, 12, 15);
		panel_15.add(ES5Label_1_25);
		
		JLabel ES5Label_1_26 = new JLabel("26");
		ES5Label_1_26.setHorizontalAlignment(SwingConstants.CENTER);
		ES5Label_1_26.setFont(new Font("Vrinda", Font.PLAIN, 10));
		ES5Label_1_26.setBounds(336, 10, 12, 15);
		panel_15.add(ES5Label_1_26);
		
		JLabel ES5Label_1_27 = new JLabel("27");
		ES5Label_1_27.setHorizontalAlignment(SwingConstants.CENTER);
		ES5Label_1_27.setFont(new Font("Vrinda", Font.PLAIN, 10));
		ES5Label_1_27.setBounds(349, 10, 12, 15);
		panel_15.add(ES5Label_1_27);
		
		JLabel ES5Label_1_28 = new JLabel("28");
		ES5Label_1_28.setHorizontalAlignment(SwingConstants.CENTER);
		ES5Label_1_28.setFont(new Font("Vrinda", Font.PLAIN, 12));
		ES5Label_1_28.setBounds(364, 10, 14, 15);
		panel_15.add(ES5Label_1_28);
								
		
		JLabel ES5Label = new JLabel("Subrack ES-5");
		ES5Label.setBounds(293, 231, 99, 14);
		panel_15.add(ES5Label);
		/////////////////////////////////////////////////////////////////////////////////////////////
		JPanel panel_2 = new JPanel();
		splitPane.setRightComponent(panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{0, 113, 132, 16, 0};
		gbl_panel_2.rowHeights = new int[]{10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_2.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		JLabel lblIucs = new JLabel("Iu_CS User Plane");
		lblIucs.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblIucs.setIcon(new ImageIcon(rncMain.class.getResource("/images/arrow_right_blue.png")));
		GridBagConstraints gbc_lblIucs = new GridBagConstraints();
		gbc_lblIucs.anchor = GridBagConstraints.WEST;
		gbc_lblIucs.insets = new Insets(0, 0, 5, 5);
		gbc_lblIucs.gridx = 1;
		gbc_lblIucs.gridy = 1;
		panel_2.add(lblIucs, gbc_lblIucs);
		
		JLabel lblNewLabel = new JLabel("Left Default GW:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 2;
		panel_2.add(lblNewLabel, gbc_lblNewLabel);
		
		formattedTextField = new JFormattedTextField(new IPAddressFormatter());		
		formattedTextField.setSize(100, 20);
		GridBagConstraints gbc_formattedTextField = new GridBagConstraints();
		gbc_formattedTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_formattedTextField.insets = new Insets(0, 0, 5, 5);
		gbc_formattedTextField.gridx = 2;
		gbc_formattedTextField.gridy = 2;
		panel_2.add(formattedTextField, gbc_formattedTextField);
		
		JLabel lblRightDefaultGw = new JLabel("Right Default GW:");
		GridBagConstraints gbc_lblRightDefaultGw = new GridBagConstraints();
		gbc_lblRightDefaultGw.anchor = GridBagConstraints.EAST;
		gbc_lblRightDefaultGw.insets = new Insets(0, 0, 5, 5);
		gbc_lblRightDefaultGw.gridx = 1;
		gbc_lblRightDefaultGw.gridy = 3;
		panel_2.add(lblRightDefaultGw, gbc_lblRightDefaultGw);
		
		formattedTextField_1 = new JFormattedTextField(new IPAddressFormatter());
		GridBagConstraints gbc_formattedTextField_1 = new GridBagConstraints();
		gbc_formattedTextField_1.insets = new Insets(0, 0, 5, 5);
		gbc_formattedTextField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_formattedTextField_1.gridx = 2;
		gbc_formattedTextField_1.gridy = 3;
		panel_2.add(formattedTextField_1, gbc_formattedTextField_1);
		
		JLabel lblNetPreffics = new JLabel("Net Prefix:");
		GridBagConstraints gbc_lblNetPreffics = new GridBagConstraints();
		gbc_lblNetPreffics.anchor = GridBagConstraints.EAST;
		gbc_lblNetPreffics.insets = new Insets(0, 0, 5, 5);
		gbc_lblNetPreffics.gridx = 1;
		gbc_lblNetPreffics.gridy = 4;
		panel_2.add(lblNetPreffics, gbc_lblNetPreffics);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"17 - 255.255.128.0", "18 - 255.255.192.0", "19 - 255.255.224.0", "20 - 255.255.240.0", "21 - 255.255.248.0", "22 - 255.255.252.0", "23 - 255.255.254.0", "24 - 255.255.255.0", "25 - 255.255.255.128", "26 - 255.255.255.192", "27 - 255.255.255.224", "28 - 255.255.255.240"}));
		comboBox.setSelectedIndex(7);
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 2;
		gbc_comboBox.gridy = 4;
		panel_2.add(comboBox, gbc_comboBox);
		
		JLabel lblIpIucsUp = new JLabel("IP From:");
		GridBagConstraints gbc_lblIpIucsUp = new GridBagConstraints();
		gbc_lblIpIucsUp.anchor = GridBagConstraints.EAST;
		gbc_lblIpIucsUp.insets = new Insets(0, 0, 5, 5);
		gbc_lblIpIucsUp.gridx = 1;
		gbc_lblIpIucsUp.gridy = 5;
		panel_2.add(lblIpIucsUp, gbc_lblIpIucsUp);
		
		formattedTextField_2 = new JFormattedTextField(new IPAddressFormatter());
		GridBagConstraints gbc_formattedTextField_2 = new GridBagConstraints();
		gbc_formattedTextField_2.insets = new Insets(0, 0, 5, 5);
		gbc_formattedTextField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_formattedTextField_2.gridx = 2;
		gbc_formattedTextField_2.gridy = 5;
		panel_2.add(formattedTextField_2, gbc_formattedTextField_2);
		
		JLabel lblIpIucsUp_1 = new JLabel("IP To:");
		GridBagConstraints gbc_lblIpIucsUp_1 = new GridBagConstraints();
		gbc_lblIpIucsUp_1.anchor = GridBagConstraints.EAST;
		gbc_lblIpIucsUp_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblIpIucsUp_1.gridx = 1;
		gbc_lblIpIucsUp_1.gridy = 6;
		panel_2.add(lblIpIucsUp_1, gbc_lblIpIucsUp_1);
		
		formattedTextField_3 = new JFormattedTextField(new IPAddressFormatter());
		GridBagConstraints gbc_formattedTextField_3 = new GridBagConstraints();
		gbc_formattedTextField_3.insets = new Insets(0, 0, 5, 5);
		gbc_formattedTextField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_formattedTextField_3.gridx = 2;
		gbc_formattedTextField_3.gridy = 6;
		panel_2.add(formattedTextField_3, gbc_formattedTextField_3);
		
		JLabel lblVlan = new JLabel("VLAN:");
		GridBagConstraints gbc_lblVlan = new GridBagConstraints();
		gbc_lblVlan.anchor = GridBagConstraints.EAST;
		gbc_lblVlan.insets = new Insets(0, 0, 5, 5);
		gbc_lblVlan.gridx = 1;
		gbc_lblVlan.gridy = 7;
		panel_2.add(lblVlan, gbc_lblVlan);
		
		 NumberFormat vlanFormat = NumberFormat.getNumberInstance();
		 vlanFormat.setMaximumIntegerDigits(3);
		
		formattedTextField_8 = new JFormattedTextField(vlanFormat);
		formattedTextField_8.setText("264");
		GridBagConstraints gbc_formattedTextField_8 = new GridBagConstraints();
		gbc_formattedTextField_8.insets = new Insets(0, 0, 5, 5);
		gbc_formattedTextField_8.fill = GridBagConstraints.HORIZONTAL;
		gbc_formattedTextField_8.gridx = 2;
		gbc_formattedTextField_8.gridy = 7;
		panel_2.add(formattedTextField_8, gbc_formattedTextField_8);
		
		JLabel lblIupsUserPlane = new JLabel("Iu-PS User Plane");
		lblIupsUserPlane.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblIupsUserPlane.setIcon(new ImageIcon(rncMain.class.getResource("/images/arrow_right_blue.png")));
		GridBagConstraints gbc_lblIupsUserPlane = new GridBagConstraints();
		gbc_lblIupsUserPlane.anchor = GridBagConstraints.WEST;
		gbc_lblIupsUserPlane.insets = new Insets(0, 0, 5, 5);
		gbc_lblIupsUserPlane.gridx = 1;
		gbc_lblIupsUserPlane.gridy = 8;
		panel_2.add(lblIupsUserPlane, gbc_lblIupsUserPlane);
		
		JLabel lblNewLabel_1 = new JLabel("Left Default GW:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 9;
		panel_2.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		formattedTextField_4 = new JFormattedTextField(new IPAddressFormatter());
		GridBagConstraints gbc_formattedTextField_4 = new GridBagConstraints();
		gbc_formattedTextField_4.insets = new Insets(0, 0, 5, 5);
		gbc_formattedTextField_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_formattedTextField_4.gridx = 2;
		gbc_formattedTextField_4.gridy = 9;
		panel_2.add(formattedTextField_4, gbc_formattedTextField_4);
		
		JLabel lblRightDefaultGw_1 = new JLabel("Right Default GW:");
		GridBagConstraints gbc_lblRightDefaultGw_1 = new GridBagConstraints();
		gbc_lblRightDefaultGw_1.anchor = GridBagConstraints.EAST;
		gbc_lblRightDefaultGw_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblRightDefaultGw_1.gridx = 1;
		gbc_lblRightDefaultGw_1.gridy = 10;
		panel_2.add(lblRightDefaultGw_1, gbc_lblRightDefaultGw_1);
		
		formattedTextField_5 = new JFormattedTextField(new IPAddressFormatter());
		GridBagConstraints gbc_formattedTextField_5 = new GridBagConstraints();
		gbc_formattedTextField_5.insets = new Insets(0, 0, 5, 5);
		gbc_formattedTextField_5.fill = GridBagConstraints.HORIZONTAL;
		gbc_formattedTextField_5.gridx = 2;
		gbc_formattedTextField_5.gridy = 10;
		panel_2.add(formattedTextField_5, gbc_formattedTextField_5);
		
		JLabel lblNetPrefix = new JLabel("Net Prefix:");
		GridBagConstraints gbc_lblNetPrefix = new GridBagConstraints();
		gbc_lblNetPrefix.anchor = GridBagConstraints.EAST;
		gbc_lblNetPrefix.insets = new Insets(0, 0, 5, 5);
		gbc_lblNetPrefix.gridx = 1;
		gbc_lblNetPrefix.gridy = 11;
		panel_2.add(lblNetPrefix, gbc_lblNetPrefix);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"17 - 255.255.128.0", "18 - 255.255.192.0", "19 - 255.255.224.0", "20 - 255.255.240.0", "21 - 255.255.248.0", "22 - 255.255.252.0", "23 - 255.255.254.0", "24 - 255.255.255.0", "25 - 255.255.255.128", "26 - 255.255.255.192", "27 - 255.255.255.224", "28 - 255.255.255.240"}));
		comboBox_1.setSelectedIndex(7);
		GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
		gbc_comboBox_1.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_1.gridx = 2;
		gbc_comboBox_1.gridy = 11;
		panel_2.add(comboBox_1, gbc_comboBox_1);
		
		JLabel lblIpIupsUp = new JLabel("IP From:");
		GridBagConstraints gbc_lblIpIupsUp = new GridBagConstraints();
		gbc_lblIpIupsUp.anchor = GridBagConstraints.EAST;
		gbc_lblIpIupsUp.insets = new Insets(0, 0, 5, 5);
		gbc_lblIpIupsUp.gridx = 1;
		gbc_lblIpIupsUp.gridy = 12;
		panel_2.add(lblIpIupsUp, gbc_lblIpIupsUp);
		
		formattedTextField_6 = new JFormattedTextField(new IPAddressFormatter());
		GridBagConstraints gbc_formattedTextField_6 = new GridBagConstraints();
		gbc_formattedTextField_6.insets = new Insets(0, 0, 5, 5);
		gbc_formattedTextField_6.fill = GridBagConstraints.HORIZONTAL;
		gbc_formattedTextField_6.gridx = 2;
		gbc_formattedTextField_6.gridy = 12;
		panel_2.add(formattedTextField_6, gbc_formattedTextField_6);
		
		JLabel lblIpTo = new JLabel("IP To:");
		GridBagConstraints gbc_lblIpTo = new GridBagConstraints();
		gbc_lblIpTo.anchor = GridBagConstraints.EAST;
		gbc_lblIpTo.insets = new Insets(0, 0, 5, 5);
		gbc_lblIpTo.gridx = 1;
		gbc_lblIpTo.gridy = 13;
		panel_2.add(lblIpTo, gbc_lblIpTo);
		
		formattedTextField_7 = new JFormattedTextField(new IPAddressFormatter());
		GridBagConstraints gbc_formattedTextField_7 = new GridBagConstraints();
		gbc_formattedTextField_7.insets = new Insets(0, 0, 5, 5);
		gbc_formattedTextField_7.fill = GridBagConstraints.HORIZONTAL;
		gbc_formattedTextField_7.gridx = 2;
		gbc_formattedTextField_7.gridy = 13;
		panel_2.add(formattedTextField_7, gbc_formattedTextField_7);
		
		JLabel lblVlan_1 = new JLabel("VLAN:");
		GridBagConstraints gbc_lblVlan_1 = new GridBagConstraints();
		gbc_lblVlan_1.anchor = GridBagConstraints.EAST;
		gbc_lblVlan_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblVlan_1.gridx = 1;
		gbc_lblVlan_1.gridy = 14;
		panel_2.add(lblVlan_1, gbc_lblVlan_1);
		
		formattedTextField_9 = new JFormattedTextField(vlanFormat);
		formattedTextField_9.setText("267");
		GridBagConstraints gbc_formattedTextField_9 = new GridBagConstraints();
		gbc_formattedTextField_9.insets = new Insets(0, 0, 5, 5);
		gbc_formattedTextField_9.fill = GridBagConstraints.HORIZONTAL;
		gbc_formattedTextField_9.gridx = 2;
		gbc_formattedTextField_9.gridy = 14;
		panel_2.add(formattedTextField_9, gbc_formattedTextField_9);
		
		JLabel lblIub = new JLabel("IUB");
		lblIub.setIcon(new ImageIcon(rncMain.class.getResource("/images/arrow_right_blue.png")));
		lblIub.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblIub = new GridBagConstraints();
		gbc_lblIub.anchor = GridBagConstraints.WEST;
		gbc_lblIub.insets = new Insets(0, 0, 5, 5);
		gbc_lblIub.gridx = 1;
		gbc_lblIub.gridy = 15;
		panel_2.add(lblIub, gbc_lblIub);
		
		JLabel lblNewLabel_2 = new JLabel("Left Default GW:");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 16;
		panel_2.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		formattedTextField_10 = new JFormattedTextField(new IPAddressFormatter());
		GridBagConstraints gbc_formattedTextField_10 = new GridBagConstraints();
		gbc_formattedTextField_10.insets = new Insets(0, 0, 5, 5);
		gbc_formattedTextField_10.fill = GridBagConstraints.HORIZONTAL;
		gbc_formattedTextField_10.gridx = 2;
		gbc_formattedTextField_10.gridy = 16;
		panel_2.add(formattedTextField_10, gbc_formattedTextField_10);
		
		JLabel lblRightDefaultGw_2 = new JLabel("Right Default GW:");
		GridBagConstraints gbc_lblRightDefaultGw_2 = new GridBagConstraints();
		gbc_lblRightDefaultGw_2.anchor = GridBagConstraints.EAST;
		gbc_lblRightDefaultGw_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblRightDefaultGw_2.gridx = 1;
		gbc_lblRightDefaultGw_2.gridy = 17;
		panel_2.add(lblRightDefaultGw_2, gbc_lblRightDefaultGw_2);
		
		formattedTextField_11 = new JFormattedTextField(new IPAddressFormatter());
		GridBagConstraints gbc_formattedTextField_11 = new GridBagConstraints();
		gbc_formattedTextField_11.insets = new Insets(0, 0, 5, 5);
		gbc_formattedTextField_11.fill = GridBagConstraints.HORIZONTAL;
		gbc_formattedTextField_11.gridx = 2;
		gbc_formattedTextField_11.gridy = 17;
		panel_2.add(formattedTextField_11, gbc_formattedTextField_11);
		
		JLabel lblNetPrefix_1 = new JLabel("Net Prefix:");
		GridBagConstraints gbc_lblNetPrefix_1 = new GridBagConstraints();
		gbc_lblNetPrefix_1.anchor = GridBagConstraints.EAST;
		gbc_lblNetPrefix_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNetPrefix_1.gridx = 1;
		gbc_lblNetPrefix_1.gridy = 18;
		panel_2.add(lblNetPrefix_1, gbc_lblNetPrefix_1);
		
		comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"17 - 255.255.128.0", "18 - 255.255.192.0", "19 - 255.255.224.0", "20 - 255.255.240.0", "21 - 255.255.248.0", "22 - 255.255.252.0", "23 - 255.255.254.0", "24 - 255.255.255.0", "25 - 255.255.255.128", "26 - 255.255.255.192", "27 - 255.255.255.224", "28 - 255.255.255.240"}));
		comboBox_2.setSelectedIndex(7);
		GridBagConstraints gbc_comboBox_2 = new GridBagConstraints();
		gbc_comboBox_2.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_2.gridx = 2;
		gbc_comboBox_2.gridy = 18;
		panel_2.add(comboBox_2, gbc_comboBox_2);
		
		JLabel lblIpFrom = new JLabel("IP From:");
		GridBagConstraints gbc_lblIpFrom = new GridBagConstraints();
		gbc_lblIpFrom.anchor = GridBagConstraints.EAST;
		gbc_lblIpFrom.insets = new Insets(0, 0, 5, 5);
		gbc_lblIpFrom.gridx = 1;
		gbc_lblIpFrom.gridy = 19;
		panel_2.add(lblIpFrom, gbc_lblIpFrom);
		
		formattedTextField_12 = new JFormattedTextField(new IPAddressFormatter());
		GridBagConstraints gbc_formattedTextField_12 = new GridBagConstraints();
		gbc_formattedTextField_12.insets = new Insets(0, 0, 5, 5);
		gbc_formattedTextField_12.fill = GridBagConstraints.HORIZONTAL;
		gbc_formattedTextField_12.gridx = 2;
		gbc_formattedTextField_12.gridy = 19;
		panel_2.add(formattedTextField_12, gbc_formattedTextField_12);
		
		JLabel lblIpTo_1 = new JLabel("IP To:");
		GridBagConstraints gbc_lblIpTo_1 = new GridBagConstraints();
		gbc_lblIpTo_1.anchor = GridBagConstraints.EAST;
		gbc_lblIpTo_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblIpTo_1.gridx = 1;
		gbc_lblIpTo_1.gridy = 20;
		panel_2.add(lblIpTo_1, gbc_lblIpTo_1);
		
		formattedTextField_13 = new JFormattedTextField(new IPAddressFormatter());
		GridBagConstraints gbc_formattedTextField_13 = new GridBagConstraints();
		gbc_formattedTextField_13.insets = new Insets(0, 0, 5, 5);
		gbc_formattedTextField_13.fill = GridBagConstraints.HORIZONTAL;
		gbc_formattedTextField_13.gridx = 2;
		gbc_formattedTextField_13.gridy = 20;
		panel_2.add(formattedTextField_13, gbc_formattedTextField_13);
		
		JLabel lblVlan_2 = new JLabel("VLAN:");
		GridBagConstraints gbc_lblVlan_2 = new GridBagConstraints();
		gbc_lblVlan_2.anchor = GridBagConstraints.EAST;
		gbc_lblVlan_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblVlan_2.gridx = 1;
		gbc_lblVlan_2.gridy = 21;
		panel_2.add(lblVlan_2, gbc_lblVlan_2);
		
		formattedTextField_14 = new JFormattedTextField(vlanFormat);
		formattedTextField_14.setText("600");
		GridBagConstraints gbc_formattedTextField_14 = new GridBagConstraints();
		gbc_formattedTextField_14.insets = new Insets(0, 0, 5, 5);
		gbc_formattedTextField_14.fill = GridBagConstraints.HORIZONTAL;
		gbc_formattedTextField_14.gridx = 2;
		gbc_formattedTextField_14.gridy = 21;
		panel_2.add(formattedTextField_14, gbc_formattedTextField_14);
		
		JLabel lblStartPdr = new JLabel("Start PdrDevice Number:");		
		lblStartPdr.setIcon(new ImageIcon(rncMain.class.getResource("/images/arrow_right_blue.png")));
		lblStartPdr.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblStartPdr = new GridBagConstraints();
		gbc_lblStartPdr.anchor = GridBagConstraints.WEST;
		gbc_lblStartPdr.insets = new Insets(0, 0, 0, 5);
		gbc_lblStartPdr.gridx = 1;
		gbc_lblStartPdr.gridy = 22;
		panel_2.add(lblStartPdr, gbc_lblStartPdr);
		
		formattedTextField_15 = new JFormattedTextField(vlanFormat);
		formattedTextField_15.setText("0");
		GridBagConstraints gbc_formattedTextField_15 = new GridBagConstraints();
		gbc_formattedTextField_15.insets = new Insets(0, 0, 0, 5);
		gbc_formattedTextField_15.fill = GridBagConstraints.HORIZONTAL;
		gbc_formattedTextField_15.gridx = 2;
		gbc_formattedTextField_15.gridy = 22;
		panel_2.add(formattedTextField_15, gbc_formattedTextField_15);
	}
}
