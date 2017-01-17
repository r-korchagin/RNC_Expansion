package rnc.ebpext.scripts;

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
import java.awt.FlowLayout;

public class rncMain {

	JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JFormattedTextField formattedTextField;
	private JFormattedTextField formattedTextField_1;
	private JComboBox<String> comboBox;
	private JFormattedTextField formattedTextField_2;
	private JFormattedTextField formattedTextField_3;
	private JFormattedTextField formattedTextField_8;
	private JFormattedTextField formattedTextField_4;
	private JFormattedTextField formattedTextField_5;
	private JComboBox<String> comboBox_1;
	private JFormattedTextField formattedTextField_6;
	private JFormattedTextField formattedTextField_7;
	private JFormattedTextField formattedTextField_9;
	private JFormattedTextField formattedTextField_10;
	private JFormattedTextField formattedTextField_11;
	private JComboBox<String> comboBox_2;
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
	
	private JLabel[] ES3board = new JLabel[24];
	private JLabel[] ES3label = new JLabel[28];

	private JLabel[] ES4board = new JLabel[24];
	private JLabel[] ES4label = new JLabel[28];
	
	private JLabel[] ES5board = new JLabel[24];
	private JLabel[] ES5label = new JLabel[28];

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
		for(int i=0; i < 24; i++) {
			ES1board[i].setIcon(Board);
			ES2board[i].setIcon(Board);
			ES3board[i].setIcon(Board);
			ES4board[i].setIcon(Board);
			ES5board[i].setIcon(Board);
		}

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
			int slotNo = Integer.parseInt(RNC.get_ES3_SlotData(i).get_Slot());
			ES3board[slotNo-3].setIcon(Board_selected);
		}
		
		for (int i = 0; i < RNC.get_ES4_Count(); i++){	
			int slotNo = Integer.parseInt(RNC.get_ES4_SlotData(i).get_Slot());
			ES4board[slotNo-3].setIcon(Board_selected);
		}
		
		for (int i = 0; i < RNC.get_ES5_Count(); i++){	
			int slotNo = Integer.parseInt(RNC.get_ES5_SlotData(i).get_Slot());
			ES5board[slotNo-3].setIcon(Board_selected);
		}
		
		textField.setText(String.valueOf(RNC.get_Total_Board()));
		textField_1.setText(RNC.get_Total_Board_List());
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame( "Advanced RNC Expansion Scripter  // By Roman Korchagin" );
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
		
		JButton btnSaveCommandFile = new JButton("Save MO Command File");
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
		FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
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
		textField_1.setColumns(25);
		
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
				
		/////////////////////////////       END MS subrack   ////////////////////////////////////
		JPanel panel_5 = new JPanel();
		tabbedPane.addTab("ES-1", null, panel_5, null);
		panel_5.setLayout(null);
		
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
		
		// Fill label for ES2 subrack slot title
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
		/////////////////////////////////////////  END ES2 subrack  /////////////////////////////////////////////////////
		
		
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
		
		
		
		MouseAdapter ES3boardEv = new MouseAdapter(){
			@Override
			public void mouseExited(MouseEvent e) {
				JLabel atractor = (JLabel) e.getSource();
				for (int i = 0; i < ES3board.length; i++){
					if(atractor == ES3board[i]){
						if (RNC.get_ES3_SlotData_byName(String.valueOf(i+3)) == -1){
							ES3board[i].setIcon(Board);
						}
					}
				}
				
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				JLabel atractor = (JLabel) e.getSource();
				for (int i = 0; i < ES3board.length; i++){
					if(atractor == ES3board[i]){
						if (RNC.get_ES3_SlotData_byName(String.valueOf(i+3)) == -1){
							ES3board[i].setIcon(Board_selected);
							SlotData newBoard = new SlotData();
							newBoard.set_Slot(String.valueOf(i+3));
							RNC.add_ES3_SlotData(newBoard);
							textField.setText(String.valueOf(RNC.get_Total_Board()));
							textField_1.setText(RNC.get_Total_Board_List());
						}else{
							ES3board[i].setIcon(Board);
							RNC.delete_ES3_SlotData_byName(String.valueOf(i+3));
							textField.setText(String.valueOf(RNC.get_Total_Board()));
							textField_1.setText(RNC.get_Total_Board_List());
						}
					}
				}				
			}
		};
		
		MouseMotionAdapter ES3boardMo = new MouseMotionAdapter(){
			@Override
			public void mouseMoved(MouseEvent e) {
				JLabel atractor = (JLabel) e.getSource();
				for (int i = 0; i < ES3board.length; i++){
					if(atractor == ES3board[i]){
						if (RNC.get_ES3_SlotData_byName(String.valueOf(i+3)) == -1){
							ES3board[i].setIcon(Board_over);
						}
					}
				}
				
			}
		};
		
		
		p = 36;
		for(int i=0; i<24; i++){
			ES3board[i] = new JLabel("");
			ES3board[i].addMouseListener(ES3boardEv);
			ES3board[i].addMouseMotionListener(ES3boardMo);
			ES3board[i].setBounds(p, 27, 14, 193);
			panel_13.add(ES3board[i]);
			ES3board[i].setIcon(Board);
			p+=13;
		}	
				
		
		JLabel ES3Label_27 = new JLabel("");
		ES3Label_27.setIcon(new ImageIcon(rncMain.class.getResource("/images/SCXB3.png")));
		ES3Label_27.setBounds(348, 27, 14, 193);
		panel_13.add(ES3Label_27);
		
		JLabel ES3Label_28 = new JLabel("");
		ES3Label_28.setIcon(new ImageIcon(rncMain.class.getResource("/images/CMXB3.png")));
		ES3Label_28.setBounds(361, 27, 14, 193);
		panel_13.add(ES3Label_28);		
		
		
		// Fill label for ES3 subrack slot title
		for(int i=0; i<28; i++){
			ES3label[i] = new JLabel(String.valueOf(i+1));
			if (i == 0 | i == 27)
				ES3label[i].setFont(new Font("Vrinda", Font.PLAIN, 12));
			else if (i < 9)
				ES3label[i].setFont(new Font("Vrinda", Font.PLAIN, 11));
			else
				ES3label[i].setFont(new Font("Vrinda", Font.PLAIN, 10));
			if (i == 27)
				ES3label[i].setBounds(MSSlot[i], 10, 14, 15);
			else
				ES3label[i].setBounds(MSSlot[i], 10, 12, 15);
 			panel_13.add(ES3label[i]);
			ES3label[i].setHorizontalAlignment(SwingConstants.CENTER);
		}
		
				
		JLabel ES3Label = new JLabel("Subrack ES-3");
		ES3Label.setBounds(293, 231, 99, 14);
		panel_13.add(ES3Label);
		
		//////////////////////////////////////////  END ES3 subrack   ///////////////////////////////////////////////////
		
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
				

		MouseAdapter ES4boardEv = new MouseAdapter(){
			@Override
			public void mouseExited(MouseEvent e) {
				JLabel atractor = (JLabel) e.getSource();
				for (int i = 0; i < ES4board.length; i++){
					if(atractor == ES4board[i]){
						if (RNC.get_ES4_SlotData_byName(String.valueOf(i+3)) == -1){
							ES4board[i].setIcon(Board);
						}
					}
				}
				
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				JLabel atractor = (JLabel) e.getSource();
				for (int i = 0; i < ES4board.length; i++){
					if(atractor == ES4board[i]){
						if (RNC.get_ES4_SlotData_byName(String.valueOf(i+3)) == -1){
							ES4board[i].setIcon(Board_selected);
							SlotData newBoard = new SlotData();
							newBoard.set_Slot(String.valueOf(i+3));
							RNC.add_ES4_SlotData(newBoard);
							textField.setText(String.valueOf(RNC.get_Total_Board()));
							textField_1.setText(RNC.get_Total_Board_List());
						}else{
							ES4board[i].setIcon(Board);
							RNC.delete_ES4_SlotData_byName(String.valueOf(i+3));
							textField.setText(String.valueOf(RNC.get_Total_Board()));
							textField_1.setText(RNC.get_Total_Board_List());
						}
					}
				}				
			}
		};
		
		MouseMotionAdapter ES4boardMo = new MouseMotionAdapter(){
			@Override
			public void mouseMoved(MouseEvent e) {
				JLabel atractor = (JLabel) e.getSource();
				for (int i = 0; i < ES4board.length; i++){
					if(atractor == ES4board[i]){
						if (RNC.get_ES4_SlotData_byName(String.valueOf(i+3)) == -1){
							ES4board[i].setIcon(Board_over);
						}
					}
				}
				
			}
		};

		p = 36;
		for(int i=0; i<24; i++){
			ES4board[i] = new JLabel("");
			ES4board[i].addMouseListener(ES4boardEv);
			ES4board[i].addMouseMotionListener(ES4boardMo);
			ES4board[i].setBounds(p, 27, 14, 193);
			panel_14.add(ES4board[i]);
			ES4board[i].setIcon(Board);
			p+=13;
		}	
		
		JLabel ES4Label_27 = new JLabel("");
		ES4Label_27.setIcon(new ImageIcon(rncMain.class.getResource("/images/SCXB3.png")));
		ES4Label_27.setBounds(348, 27, 14, 193);
		panel_14.add(ES4Label_27);
		
		JLabel ES4Label_28 = new JLabel("");
		ES4Label_28.setIcon(new ImageIcon(rncMain.class.getResource("/images/CMXB3.png")));
		ES4Label_28.setBounds(361, 27, 14, 193);
		panel_14.add(ES4Label_28);		
		
		
		// Fill label for ES4 subrack slot title
		for(int i=0; i<28; i++){
			ES4label[i] = new JLabel(String.valueOf(i+1));
			if (i == 0 | i == 27)
				ES4label[i].setFont(new Font("Vrinda", Font.PLAIN, 12));
			else if (i < 9)
				ES4label[i].setFont(new Font("Vrinda", Font.PLAIN, 11));
			else
				ES4label[i].setFont(new Font("Vrinda", Font.PLAIN, 10));
			if (i == 27)
				ES4label[i].setBounds(MSSlot[i], 10, 14, 15);
			else
				ES4label[i].setBounds(MSSlot[i], 10, 12, 15);
 			panel_14.add(ES4label[i]);
			ES4label[i].setHorizontalAlignment(SwingConstants.CENTER);
		}
										
		
		JLabel ES4Label = new JLabel("Subrack ES-4");
		ES4Label.setBounds(293, 231, 99, 14);
		panel_14.add(ES4Label);
		
		////////////////////////////  END ES4 subrack    ///////////////////////////////////
		
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
		
		
		MouseAdapter ES5boardEv = new MouseAdapter(){
			@Override
			public void mouseExited(MouseEvent e) {
				JLabel atractor = (JLabel) e.getSource();
				for (int i = 0; i < ES5board.length; i++){
					if(atractor == ES5board[i]){
						if (RNC.get_ES5_SlotData_byName(String.valueOf(i+3)) == -1){
							ES5board[i].setIcon(Board);
						}
					}
				}				
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				JLabel atractor = (JLabel) e.getSource();
				for (int i = 0; i < ES5board.length; i++){
					if(atractor == ES5board[i]){
						if (RNC.get_ES5_SlotData_byName(String.valueOf(i+3)) == -1){
							ES5board[i].setIcon(Board_selected);
							SlotData newBoard = new SlotData();
							newBoard.set_Slot(String.valueOf(i+3));
							RNC.add_ES5_SlotData(newBoard);
							textField.setText(String.valueOf(RNC.get_Total_Board()));
							textField_1.setText(RNC.get_Total_Board_List());
						}else{
							ES5board[i].setIcon(Board);
							RNC.delete_ES5_SlotData_byName(String.valueOf(i+3));
							textField.setText(String.valueOf(RNC.get_Total_Board()));
							textField_1.setText(RNC.get_Total_Board_List());
						}
					}
				}				
			}
		};
		
		MouseMotionAdapter ES5boardMo = new MouseMotionAdapter(){
			@Override
			public void mouseMoved(MouseEvent e) {
				JLabel atractor = (JLabel) e.getSource();
				for (int i = 0; i < ES5board.length; i++){
					if(atractor == ES5board[i]){
						if (RNC.get_ES5_SlotData_byName(String.valueOf(i+3)) == -1){
							ES5board[i].setIcon(Board_over);
						}
					}
				}
				
			}
		};

		p = 36;
		for(int i=0; i<24; i++){
			ES5board[i] = new JLabel("");
			ES5board[i].addMouseListener(ES5boardEv);
			ES5board[i].addMouseMotionListener(ES5boardMo);
			ES5board[i].setBounds(p, 27, 14, 193);
			panel_15.add(ES5board[i]);
			ES5board[i].setIcon(Board);
			p+=13;
		}	
		
		
		
		
		JLabel ES5Label_27 = new JLabel("");
		ES5Label_27.setIcon(new ImageIcon(rncMain.class.getResource("/images/SCXB3.png")));
		ES5Label_27.setBounds(348, 27, 14, 193);
		panel_15.add(ES5Label_27);
		
		JLabel ES5Label_28 = new JLabel("");
		ES5Label_28.setIcon(new ImageIcon(rncMain.class.getResource("/images/CMXB3.png")));
		ES5Label_28.setBounds(361, 27, 14, 193);
		panel_15.add(ES5Label_28);		
		
		// Fill label for ES5 subrack slot title
		for(int i=0; i<28; i++){
			ES5label[i] = new JLabel(String.valueOf(i+1));
			if (i == 0 | i == 27)
				ES5label[i].setFont(new Font("Vrinda", Font.PLAIN, 12));
			else if (i < 9)
				ES5label[i].setFont(new Font("Vrinda", Font.PLAIN, 11));
			else
				ES5label[i].setFont(new Font("Vrinda", Font.PLAIN, 10));
			if (i == 27)
				ES5label[i].setBounds(MSSlot[i], 10, 14, 15);
			else
				ES5label[i].setBounds(MSSlot[i], 10, 12, 15);
 			panel_15.add(ES4label[i]);
			ES5label[i].setHorizontalAlignment(SwingConstants.CENTER);
		}

		
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
		
		comboBox = new JComboBox<String>();
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"17 - 255.255.128.0", "18 - 255.255.192.0", "19 - 255.255.224.0", "20 - 255.255.240.0", "21 - 255.255.248.0", "22 - 255.255.252.0", "23 - 255.255.254.0", "24 - 255.255.255.0", "25 - 255.255.255.128", "26 - 255.255.255.192", "27 - 255.255.255.224", "28 - 255.255.255.240"}));
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
		
		comboBox_1 = new JComboBox<String>();
		comboBox_1.setModel(new DefaultComboBoxModel<String>(new String[] {"17 - 255.255.128.0", "18 - 255.255.192.0", "19 - 255.255.224.0", "20 - 255.255.240.0", "21 - 255.255.248.0", "22 - 255.255.252.0", "23 - 255.255.254.0", "24 - 255.255.255.0", "25 - 255.255.255.128", "26 - 255.255.255.192", "27 - 255.255.255.224", "28 - 255.255.255.240"}));
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
		
		comboBox_2 = new JComboBox<String>();
		comboBox_2.setModel(new DefaultComboBoxModel<String>(new String[] {"17 - 255.255.128.0", "18 - 255.255.192.0", "19 - 255.255.224.0", "20 - 255.255.240.0", "21 - 255.255.248.0", "22 - 255.255.252.0", "23 - 255.255.254.0", "24 - 255.255.255.0", "25 - 255.255.255.128", "26 - 255.255.255.192", "27 - 255.255.255.224", "28 - 255.255.255.240"}));
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
