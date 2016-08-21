package info.truthornot.rnc;

import java.util.ArrayList;
import java.util.List;

public class prjRNC {
	private List<SlotData> MSsubrack = new ArrayList<SlotData>(); 
	private List<SlotData> ES1subrack = new ArrayList<SlotData>();
	private List<SlotData> ES2subrack = new ArrayList<SlotData>();
	private List<SlotData> ES3subrack = new ArrayList<SlotData>();
	private List<SlotData> ES4subrack = new ArrayList<SlotData>();
	private List<SlotData> ES5subrack = new ArrayList<SlotData>();
	private String cs_Left_GW = "";
	private String cs_Right_GW = "";
	private int cs_Net_Prefix = 7;
	private String cs_IP_From = "";
	private String cs_IP_To = "";
	private String cs_VLAN = "264";
	private String ps_Left_GW = "";
	private String ps_Right_GW = "";
	private int ps_Net_Prefix = 7;
	private String ps_IP_From = "";
	private String ps_IP_To = "";
	private String ps_VLAN = "267";
	private String iub_Left_GW = "";
	private String iub_Right_GW = "";
	private int iub_Net_Prefix = 7;
	private String iub_IP_From = "";
	private String iub_IP_To = "";
	private String iub_VLAN = "267";
	private String start_prtd_num = "0";
	
	
	// CS IP
	public void set_cs_Left_GW(String cs_Left_GW){
		this.cs_Left_GW = cs_Left_GW;
	}
	
	public String get_cs_Left_GW(){
		return this.cs_Left_GW;
	}
	
	public void set_cs_Right_GW(String cs_Right_GW){
		this.cs_Right_GW = cs_Right_GW;
	}
	
	public String get_cs_Right_GW(){
		return this.cs_Right_GW;
	}
	
	public void set_cs_Net_Prefix(int cs_Net_Prefix){
		this.cs_Net_Prefix = cs_Net_Prefix;
	}
	
	public int get_cs_Net_Prefix(){
		return this.cs_Net_Prefix;
	}
	
	public void set_cs_IP_From(String cs_IP_From){
		this.cs_IP_From = cs_IP_From;
	}
	
	public String get_cs_IP_From(){
		return this.cs_IP_From;
	}
	
	public void set_cs_IP_To(String cs_IP_To){
		this.cs_IP_To = cs_IP_To;
	}
	
	public String get_cs_IP_To(){
		return this.cs_IP_To;
	}
	
	public void set_cs_VLAN(String cs_VLAN){
		this.cs_VLAN = cs_VLAN;
	}
	
	public String get_cs_VLAN(){
		return this.cs_VLAN;
	}
	
	// PS IP
		public void set_ps_Left_GW(String ps_Left_GW){
			this.ps_Left_GW = ps_Left_GW;
		}
		
		public String get_ps_Left_GW(){
			return this.ps_Left_GW;
		}
		
		public void set_ps_Right_GW(String ps_Right_GW){
			this.ps_Right_GW = ps_Right_GW;
		}
		
		public String get_ps_Right_GW(){
			return this.ps_Right_GW;
		}
		
		public void set_ps_Net_Prefix(int ps_Net_Prefix){
			this.ps_Net_Prefix = ps_Net_Prefix;
		}
		
		public int get_ps_Net_Prefix(){
			return this.ps_Net_Prefix;
		}
		
		public void set_ps_IP_From(String ps_IP_From){
			this.ps_IP_From = ps_IP_From;
		}
		
		public String get_ps_IP_From(){
			return this.ps_IP_From;
		}
		
		public void set_ps_IP_To(String ps_IP_To){
			this.ps_IP_To = ps_IP_To;
		}
		
		public String get_ps_IP_To(){
			return this.ps_IP_To;
		}
		
		public void set_ps_VLAN(String ps_VLAN){
			this.ps_VLAN = ps_VLAN;
		}
		
		public String get_ps_VLAN(){
			return this.ps_VLAN;
		}
	
		// IUB IP
		public void set_iub_Left_GW(String iub_Left_GW){
			this.iub_Left_GW = iub_Left_GW;
		}
		
		public String get_iub_Left_GW(){
			return this.iub_Left_GW;
		}
		
		public void set_iub_Right_GW(String iub_Right_GW){
			this.iub_Right_GW = iub_Right_GW;
		}
		
		public String get_iub_Right_GW(){
			return this.iub_Right_GW;
		}
		
		public void set_iub_Net_Prefix(int iub_Net_Prefix){
			this.iub_Net_Prefix = iub_Net_Prefix;
		}
		
		public int get_iub_Net_Prefix(){
			return this.iub_Net_Prefix;
		}
		
		public void set_iub_IP_From(String iub_IP_From){
			this.iub_IP_From = iub_IP_From;
		}
		
		public String get_iub_IP_From(){
			return this.iub_IP_From;
		}
		
		public void set_iub_IP_To(String iub_IP_To){
			this.iub_IP_To = iub_IP_To;
		}
		
		public String get_iub_IP_To(){
			return this.iub_IP_To;
		}
		
		public void set_iub_VLAN(String iub_VLAN){
			this.iub_VLAN = iub_VLAN;
		}
		
		public String get_iub_VLAN(){
			return this.iub_VLAN;
		}
	
		// start_prtd_num
		public void set_prd_num(String start_prtd_num){
			this.start_prtd_num = start_prtd_num;
		}
		
		public String get_prd_num(){
			return this.start_prtd_num;
		}
		
		
	
	
	public boolean ClearRNC (){
		MSsubrack.clear();
		ES1subrack.clear();
		ES2subrack.clear();
		ES3subrack.clear();
		ES4subrack.clear();
		ES5subrack.clear();
		return true;
	}
	
	public int get_Total_Board (){					
		return MSsubrack.size()+ES1subrack.size()+ES2subrack.size()+ES3subrack.size()+ES4subrack.size()+ES5subrack.size();
	}
	
	public String get_Total_Board_List (){
		String rez = "";
		for (int i=0; i < MSsubrack.size(); i++){
			rez = rez + "MS(" + MSsubrack.get(i).get_Slot() + ");";
		}
		for (int i=0; i < ES1subrack.size(); i++){
			rez = rez + "ES-1(" + ES1subrack.get(i).get_Slot() + ");";
		}
		for (int i=0; i < ES2subrack.size(); i++){
			rez = rez + "ES-2(" + ES2subrack.get(i).get_Slot() + ");";
		}
		for (int i=0; i < ES3subrack.size(); i++){
			rez = rez + "ES-3(" + ES3subrack.get(i).get_Slot() + ");";
		}
		for (int i=0; i < ES4subrack.size(); i++){
			rez = rez + "ES-4(" + ES4subrack.get(i).get_Slot() + ");";
		}
		for (int i=0; i < ES5subrack.size(); i++){
			rez = rez + "ES-5(" + ES5subrack.get(i).get_Slot() + ");";
		}
		return rez;
	}
	
	// MS
	public int get_MS_SlotData_byName(String SlotName){
		int rex = -1;
		for (int i=0; i < MSsubrack.size(); i++){
			if (MSsubrack.get(i).get_Slot().equalsIgnoreCase(SlotName)){
				return i;
			}
		}
		return rex;
	}
	
	public void delete_MS_SlotData_byName(String SlotName){		
		for (int i=0; i < MSsubrack.size(); i++){
			if (MSsubrack.get(i).get_Slot().equalsIgnoreCase(SlotName)){
				MSsubrack.remove(i);
				return;
			}
		}		
	}
	
	public SlotData get_MS_SlotData(int index){
		return MSsubrack.get(index);
	}
	
	public int get_MS_Count(){
		return MSsubrack.size();
	}
	
	public void add_MS_SlotData (SlotData Board_data) {
		MSsubrack.add(Board_data);
	}
	
	public void delete_MS_SlotData (int index) {
		MSsubrack.remove(index);
	}
	
	//ES1
	
	public int get_ES1_SlotData_byName(String SlotName){
		int rex = -1;
		for (int i=0; i < ES1subrack.size(); i++){
			if (ES1subrack.get(i).get_Slot().equalsIgnoreCase(SlotName)){
				return i;
			}
		}
		return rex;
	}
	
	public void delete_ES1_SlotData_byName(String SlotName){		
		for (int i=0; i < ES1subrack.size(); i++){
			if (ES1subrack.get(i).get_Slot().equalsIgnoreCase(SlotName)){
				ES1subrack.remove(i);
				return;
			}
		}		
	}
	
	public SlotData get_ES1_SlotData(int index){
		return ES1subrack.get(index);
	}
	
	public int get_ES1_Count(){
		return ES1subrack.size();
	}
	
	public void add_ES1_SlotData (SlotData Board_data) {
		ES1subrack.add(Board_data);
	}
	
	public void delete_ES1_SlotData (int index) {
		ES1subrack.remove(index);
	}
	
	//ES2
	public int get_ES2_SlotData_byName(String SlotName){
		int rex = -1;
		for (int i=0; i < ES2subrack.size(); i++){
			if (ES2subrack.get(i).get_Slot().equalsIgnoreCase(SlotName)){
				return i;
			}
		}
		return rex;
	}
	
	public void delete_ES2_SlotData_byName(String SlotName){		
		for (int i=0; i < ES2subrack.size(); i++){
			if (ES2subrack.get(i).get_Slot().equalsIgnoreCase(SlotName)){
				ES2subrack.remove(i);
				return;
			}
		}		
	}
	
	public SlotData get_ES2_SlotData(int index){
		return ES2subrack.get(index);
	}
		
	public int get_ES2_Count(){
		return ES2subrack.size();
	}
		
	public void add_ES2_SlotData (SlotData Board_data) {
		ES2subrack.add(Board_data);
	}
		
	public void delete_ES2_SlotData (int index) {
		ES2subrack.remove(index);
	}
	
	//ES3
	public int get_ES3_SlotData_byName(String SlotName){
		int rex = -1;
		for (int i=0; i < ES3subrack.size(); i++){
			if (ES3subrack.get(i).get_Slot().equalsIgnoreCase(SlotName)){
				return i;
			}
		}
		return rex;
	}
	
	public void delete_ES3_SlotData_byName(String SlotName){		
		for (int i=0; i < ES3subrack.size(); i++){
			if (ES3subrack.get(i).get_Slot().equalsIgnoreCase(SlotName)){
				ES3subrack.remove(i);
				return;
			}
		}		
	}
	
	public SlotData get_ES3_SlotData(int index){
		return ES3subrack.get(index);
	}
			
	public int get_ES3_Count(){
		return ES3subrack.size();
	}
			
	public void add_ES3_SlotData (SlotData Board_data) {
		ES3subrack.add(Board_data);
	}
			
	public void delete_ES3_SlotData (int index) {
		ES3subrack.remove(index);
	}
	
	//ES4
	public int get_ES4_SlotData_byName(String SlotName){
		int rex = -1;
		for (int i=0; i < ES4subrack.size(); i++){
			if (ES4subrack.get(i).get_Slot().equalsIgnoreCase(SlotName)){
				return i;
			}
		}
		return rex;
	}
	
	public void delete_ES4_SlotData_byName(String SlotName){		
		for (int i=0; i < ES4subrack.size(); i++){
			if (ES4subrack.get(i).get_Slot().equalsIgnoreCase(SlotName)){
				ES4subrack.remove(i);
				return;
			}
		}		
	}
	
	public SlotData get_ES4_SlotData(int index){
		return ES4subrack.get(index);
	}
				
	public int get_ES4_Count(){
		return ES4subrack.size();
	}
				
	public void add_ES4_SlotData (SlotData Board_data) {
		ES4subrack.add(Board_data);
	}
				
	public void delete_ES4_SlotData (int index) {
		ES4subrack.remove(index);
	}
	
	//ES5
	public int get_ES5_SlotData_byName(String SlotName){
		int rex = -1;
		for (int i=0; i < ES5subrack.size(); i++){
			if (ES5subrack.get(i).get_Slot().equalsIgnoreCase(SlotName)){
				return i;
			}
		}
		return rex;
	}
	
	public void delete_ES5_SlotData_byName(String SlotName){		
		for (int i=0; i < ES5subrack.size(); i++){
			if (ES5subrack.get(i).get_Slot().equalsIgnoreCase(SlotName)){
				ES5subrack.remove(i);
				return;
			}
		}		
	}
	
	public SlotData get_ES5_SlotData(int index){
		return ES5subrack.get(index);
	}
					
	public int get_ES5_Count(){
		return ES5subrack.size();
	}
					
	public void add_ES5_SlotData (SlotData Board_data) {
		ES5subrack.add(Board_data);
	}
					
	public void delete_ES5_SlotData (int index) {
		ES5subrack.remove(index);
	}
}
