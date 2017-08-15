# RNC_Expansion

##This is small application for simply **3G mobile** expansion **Ericsson WCDMA RNC EVOC 8200** by **EPB** board with few clicks.##

For **EPB** board expansion you need to enter some input data:

**1.** Choose subracks and board slots, where board should be inserted. Count of selected boards and their position will show in "**Boards:**" and "**Selected Slots:**".

**2.**  You need to enter next network parameters in the right side of application  (**Iu_CS** interfaces, **Iu_PS** interfaces and **IUB** interfaces) for expansion.
 - "**Left Default GW**",  "**Right Default GW**" - this is Default Gateway for the left side of subrack (till 14 slot) and DGW for the right side of subrack (from 15 slot). Default GW for the left and right side you can see in the existing boards configuration.
 - "**Net prefix**" - this is network mask for the current interface (usually "/24")
 - "**VLAN**" - Virtual Local Area Network for current interface (usually for  **Iu_CS** interfaces is **264**, for **Iu_PS** interfaces is 257, for IUB interfaces is  **600**)
 - "**IP From**" , "**IP To**" this is range IP address for current interface. For **Iu_PS** count of IP address **equals** count of boards. For **Iu_CS** and **IUB** count of **IP address** in **2 times more** then board count.  The sequence of address assignment for boards is the same as sequence in "**Selected Slots:**".
	
**3.** Set "**Start PdrDevice Number**". This is the start number of new **PdrDevice** in pool. You can see the last number in configuration of RNC in route «**ManagedElement=1,Equipment=1,SpDevicePool=PdrDevice**». For new board this number will be next.

![screen_rnc_epb_exp](https://cloud.githubusercontent.com/assets/24788396/22425071/1682266a-e702-11e6-8759-79390e82e0a0.PNG)

**4.** Click "**Save MO Command File**". Then application create MO command file for expansion selected board. (The command file will create based on template in file "**create.tpl**")

**5.** Finally. It is necessary  to change command file in path of pool configuration, because application does not get your current RNC configuration.

```
FDN=ManagedElement=1,IpSystem=1,IpAccessHostPool=IU_CS
FDN=ManagedElement=1,IpSystem=1,IpAccessHostPool=IU_PS
FDN=ManagedElement=1,IpSystem=1,IpAccessHostPool=IUB
```

For example, if you have in current configuration **RNC** three **EPB** board (**MS-5, MS-7, MS-24**) and you want to add five new board, you should append existing board in command file:

```
SET
(
    mo "ManagedElement=1,IpSystem=1,IpAccessHostPool=IU_PS"
    exception none
        ipAccessHostRef Array Reference 8                           // 3 old + 5 new
            "ManagedElement=1,IpSystem=1,IpAccessHostEt=MS-5_IuPS"  // new row - existing board in position MS-5
            "ManagedElement=1,IpSystem=1,IpAccessHostEt=MS-7_IuPS"  // new row - existing board in position MS-7
            "ManagedElement=1,IpSystem=1,IpAccessHostEt=MS-24_IuPS" // new row - existing board in position MS-24
            "ManagedElement=1,IpSystem=1,IpAccessHostEt=MS-6_IuPS"  // new board in position MS-6 (already exist in script)
            "ManagedElement=1,IpSystem=1,IpAccessHostEt=MS-8_IuPS"  // new board in position MS-8 (already exist in script)
            "ManagedElement=1,IpSystem=1,IpAccessHostEt=MS-9_IuPS"  // new board in position MS-9 (already exist in script)
            "ManagedElement=1,IpSystem=1,IpAccessHostEt=MS-22_IuPS"  // new board in position MS-22 (already exist in script)
            "ManagedElement=1,IpSystem=1,IpAccessHostEt=MS-23_IuPS"  // new board in position MS-23 (already exist in script)
)

SET
(
    mo "ManagedElement=1,IpSystem=1,IpAccessHostPool=IU_CS"
    exception none
       ipAccessHostRef Array Reference 16                                     // 3 old *2  + 5 new *2
            "ManagedElement=1,IpSystem=1,IpAccessHostEt=MS-5_IuCS_Iur_P"      //  new row - existing board in position MS-5   
            "ManagedElement=1,IpSystem=1,IpAccessHostEt=MS-5_IuCS_Iur_S"      //  new row - existing board in position MS-5   
            "ManagedElement=1,IpSystem=1,IpAccessHostEt=MS-7_IuCS_Iur_P"      //  new row - existing board in position MS-7 
            "ManagedElement=1,IpSystem=1,IpAccessHostEt=MS-7_IuCS_Iur_S"      //  new row - existing board in position MS-7
            "ManagedElement=1,IpSystem=1,IpAccessHostEt=MS-24_IuCS_Iur_P"     //  new row - existing board in position MS-24
            "ManagedElement=1,IpSystem=1,IpAccessHostEt=MS-24_IuCS_Iur_S"     //  new row - existing board in position MS-24
            "ManagedElement=1,IpSystem=1,IpAccessHostEt=MS-6_IuCS_Iur_P"      // new board in position MS-6 (already exist in script)
            "ManagedElement=1,IpSystem=1,IpAccessHostEt=MS-6_IuCS_Iur_S"      // new board in position MS-6 (already exist in script)
            "ManagedElement=1,IpSystem=1,IpAccessHostEt=MS-8_IuCS_Iur_P"      // new board in position MS-8 (already exist in script)
            "ManagedElement=1,IpSystem=1,IpAccessHostEt=MS-8_IuCS_Iur_S"      // new board in position MS-8 (already exist in script)
            "ManagedElement=1,IpSystem=1,IpAccessHostEt=MS-9_IuCS_Iur_P"      // new board in position MS-9 (already exist in script)
            "ManagedElement=1,IpSystem=1,IpAccessHostEt=MS-9_IuCS_Iur_S"      // new board in position MS-9 (already exist in script)
            "ManagedElement=1,IpSystem=1,IpAccessHostEt=MS-22_IuCS_Iur_P"     // new board in position MS-22 (already exist in script)
            "ManagedElement=1,IpSystem=1,IpAccessHostEt=MS-22_IuCS_Iur_S"     // new board in position MS-22 (already exist in script)
            "ManagedElement=1,IpSystem=1,IpAccessHostEt=MS-23_IuCS_Iur_P"     // new board in position MS-23 (already exist in script)
            "ManagedElement=1,IpSystem=1,IpAccessHostEt=MS-23_IuCS_Iur_S"     // new board in position MS-23 (already exist in script)
)

SET
(
    mo "ManagedElement=1,IpSystem=1,IpAccessHostPool=IUB"
    exception none
        ipAccessHostRef Array Reference 16                                  // 3 old *2  + 5 new *2
            "ManagedElement=1,IpSystem=1,IpAccessHostEt=MS-5_Iub_P"         //  new row - existing board in position MS-5
            "ManagedElement=1,IpSystem=1,IpAccessHostEt=MS-5_Iub_S"         //  new row - existing board in position MS-5
            "ManagedElement=1,IpSystem=1,IpAccessHostEt=MS-7_Iub_P"         //  new row - existing board in position MS-7
            "ManagedElement=1,IpSystem=1,IpAccessHostEt=MS-7_Iub_S"         //  new row - existing board in position MS-7
            "ManagedElement=1,IpSystem=1,IpAccessHostEt=MS-24_Iub_P"        //  new row - existing board in position MS-24
            "ManagedElement=1,IpSystem=1,IpAccessHostEt=MS-24_Iub_S"        //  new row - existing board in position MS-24
            "ManagedElement=1,IpSystem=1,IpAccessHostEt=MS-6_Iub_P"         // new board in position MS-6 (already exist in script)
            "ManagedElement=1,IpSystem=1,IpAccessHostEt=MS-6_Iub_S"         // new board in position MS-6 (already exist in script)
            "ManagedElement=1,IpSystem=1,IpAccessHostEt=MS-8_Iub_P"         // new board in position MS-8 (already exist in script)
            "ManagedElement=1,IpSystem=1,IpAccessHostEt=MS-8_Iub_S"         // new board in position MS-8 (already exist in script)
            "ManagedElement=1,IpSystem=1,IpAccessHostEt=MS-9_Iub_P"         // new board in position MS-9 (already exist in script)
            "ManagedElement=1,IpSystem=1,IpAccessHostEt=MS-9_Iub_S"         // new board in position MS-9 (already exist in script)
            "ManagedElement=1,IpSystem=1,IpAccessHostEt=MS-22_Iub_P"        // new board in position MS-22 (already exist in script)
            "ManagedElement=1,IpSystem=1,IpAccessHostEt=MS-22_Iub_S"        // new board in position MS-22 (already exist in script)
            "ManagedElement=1,IpSystem=1,IpAccessHostEt=MS-23_Iub_P"        // new board in position MS-23 (already exist in script)
            "ManagedElement=1,IpSystem=1,IpAccessHostEt=MS-23_Iub_S"        // new board in position MS-23 (already exist in script)
)
```
