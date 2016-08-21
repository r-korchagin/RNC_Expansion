package info.truthornot.rnc;

public class SlotData {
	
	private String Slot;  // @Slot@
	
	// IU-CS User Plane	 
	private String lurDefaultGW = "";   //@lurDefaultGW@
	private String IurNetworkPrefix  = ""; //@IurNetworkPrefix@
	private String pIurIP  = ""; //@pIurIP@
	private String sIurIP  = ""; //@sIurIP@
	private String VlanCS  = ""; //@VlanCS@  //264
	
	 
	 //Iu-PS User Plane
	private String luPSDefaultGW  = "";  // @luPSDefaultGW@
	private String IuPSNetworkPrefix  = "";  // @IuPSNetworkPrefix@
	private String IuPSIP  = "";  // @IuPSIP@
	private String VlanPS  = ""; //@VlanPS@ //267
	
	// Iub
	private String IubDefaultGW  = ""; // @IubDefaultGW@   Iub (VIP on SR)
	private String IubNetworkPrefix  = ""; // @IubNetworkPrefix@   == 24
	private String pIubIP  = ""; // @pIubIP@   // From network  Iub BSC net/24
	private String sIubIP  = ""; // @sIubIP@	// From network  Iub BSC net/24  +1
	private String VlanIUB  = ""; // @VlanIUB@  // 600
	
	
	//
	private String pdrNumber = ""; //@PDRNum@
	private int linkPriority = 0; //@PrLink@ //0 LINK_ONE_PRIMARY_LINK_TWO_SECONDARY // 1 LINK_TWO_PRIMARY_LINK_ONE_SECONDARY
	
	public int get_linkPriority(){
		return this.linkPriority;
	}
	
	public void set_linkPriority(int linkPriority){
		this.linkPriority = linkPriority;
	}		
	
	public String get_Slot(){
		return this.Slot;
	}
	
	public void set_Slot(String Slot){
		this.Slot = Slot;
	}
	
	public String get_PdrNum(){
		return this.pdrNumber;
	}
	
	public void set_PdrNum(String pdrNumber){
		this.pdrNumber = pdrNumber;
	}
	
	
	// IU-CS
	public String get_lurDefaultGW(){
		return this.lurDefaultGW;
	}
	
	public String get_IurNetworkPrefix(){
		return this.IurNetworkPrefix;
	}
	
	public String get_pIurIP(){
		return this.pIurIP;
	}
	
	public String get_sIurIP(){
		return this.sIurIP;
	}
	
	public String get_VlanCS(){
		return this.VlanCS;
	}
	
	public void set_lurDefaultGW(String lurDefaultGW){
		this.lurDefaultGW = lurDefaultGW;
	}
	
	public void set_IurNetworkPrefix(String IurNetworkPrefix){
		this.IurNetworkPrefix = IurNetworkPrefix;
	}
	
	public void set_pIurIP(String pIurIP){
		this.pIurIP = pIurIP;
	}
	
	public void set_sIurIP(String sIurIP){
		this.sIurIP = sIurIP;
	}
	
	public void set_VlanCS(String VlanCS){
		this.VlanCS = VlanCS;
	}
	
	// IU-PS
	public String get_luPSDefaultGW(){
		return this.luPSDefaultGW;
	}
	public String get_IuPSNetworkPrefix(){
		return this.IuPSNetworkPrefix;
	}
	public String get_IuPSIP(){
		return this.IuPSIP;
	}
	public String get_VlanPS(){
		return this.VlanPS;
	}
	
	public void set_luPSDefaultGW(String luPSDefaultGW){
		this.luPSDefaultGW = luPSDefaultGW;
	}
	public void set_IuPSNetworkPrefix(String IuPSNetworkPrefix){
		this.IuPSNetworkPrefix = IuPSNetworkPrefix;
	}
	public void set_IuPSIP(String IuPSIP){
		this.IuPSIP = IuPSIP;
	}
	public void set_VlanPS(String VlanPS){
		this.VlanPS = VlanPS;
	}
	// IUB
	public String get_IubDefaultGW(){
		return this.IubDefaultGW;
	}
	
	public String get_IubNetworkPrefix(){
		return this.IubNetworkPrefix;
	}
	
	public String get_pIubIP(){
		return this.pIubIP;
	}
	
	public String get_sIubIP(){
		return this.sIubIP;
	}
	
	public String get_VlanIUB(){
		return this.VlanIUB;
	}
	
	public void set_IubDefaultGW(String IubDefaultGW){
		this.IubDefaultGW = IubDefaultGW;
	}
	
	public void set_IubNetworkPrefix(String IubNetworkPrefix){
		this.IubNetworkPrefix = IubNetworkPrefix;
	}
	
	public void set_pIubIP(String pIubIP){
		this.pIubIP = pIubIP;
	}
	
	public void set_sIubIP(String sIubIP){
		this.sIubIP = sIubIP;
	}
	
	public void set_VlanIUB(String VlanIUB){
		this.VlanIUB = VlanIUB;
	}
	
}
