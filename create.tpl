////////////////////////////////////////////////////////////
//FDN=ManagedElement=1,Equipment=1,Subrack=@Subrack@,Slot=@Slot@,PlugInUnit=1,ExchangeTerminalIp=1,GigaBitEthernet=1
//modifier=set
//nrOfAttributes=1
////////////////////////////////////////////////////////////
SET
(
    mo "ManagedElement=1,Equipment=1,Subrack=@Subrack@,Slot=@Slot@,PlugInUnit=1,ExchangeTerminalIp=1,GigaBitEthernet=1"
    exception none
	primaryLink @PrLink@
        
)

@@@

////////////////////////////////////////////////////////////
//FDN=ManagedElement=1,Equipment=1,Subrack=@Subrack@,Slot=@Slot@,PlugInUnit=1,PiuDevice=1,ExchangeTerminalIp=1,GigaBitEthernet=1
//modifier=set
//nrOfAttributes=1
////////////////////////////////////////////////////////////
SET
(
    mo "ManagedElement=1,Equipment=1,Subrack=@Subrack@,Slot=@Slot@,PlugInUnit=1,PiuDevice=1,ExchangeTerminalIp=1,GigaBitEthernet=1"
    exception none
	primaryLink @PrLink@
        
)

@@@

////////////////////////////////////////////////////////////
//FDN=ManagedElement=1,Equipment=1,Subrack=@Subrack@,Slot=@Slot@,PlugInUnit=1,ExchangeTerminalIp=1,GigaBitEthernet=1,IpInterface=@Subrack@-@Slot@_IuCS_Iur_P
//modifier=create
//nrOfAttributes=10
////////////////////////////////////////////////////////////
CREATE
(
    parent "ManagedElement=1,Equipment=1,Subrack=@Subrack@,Slot=@Slot@,PlugInUnit=1,ExchangeTerminalIp=1,GigaBitEthernet=1"
    identity "@Subrack@-@Slot@_IuCS_Iur_P"
    moType IpInterface
    exception none
    nrOfAttributes 10
        ownIpAddressPassive String "0.0.0.0"
        userLabel String "IpInterface_@Subrack@-@Slot@_IuCS_Iur_P"
        mtu Integer 1500
        defaultRouter2 String "0.0.0.0"
        defaultRouter1 String "0.0.0.0"
        defaultRouter0 String "@lurDefaultGW@" 
        rps Boolean false
        ownIpAddressActive String "0.0.0.0"
        vlanRef Ref "ManagedElement=1,EthernetSwitchFabric=1,Vlan=@VlanCS@"
        networkPrefixLength Integer @IurNetworkPrefix@
)

@@@

////////////////////////////////////////////////////////////
//FDN=ManagedElement=1,Equipment=1,Subrack=@Subrack@,Slot=@Slot@,PlugInUnit=1,ExchangeTerminalIp=1,GigaBitEthernet=1,IpInterface=@Subrack@-@Slot@_Iub_P
//modifier=create
//nrOfAttributes=10
////////////////////////////////////////////////////////////
CREATE
(
    parent "ManagedElement=1,Equipment=1,Subrack=@Subrack@,Slot=@Slot@,PlugInUnit=1,ExchangeTerminalIp=1,GigaBitEthernet=1"
    identity "@Subrack@-@Slot@_Iub_P"
    moType IpInterface
    exception none
    nrOfAttributes 10
        ownIpAddressPassive String "0.0.0.0"
        userLabel String "IpInterface_@Subrack@-@Slot@_Iub_P"
        mtu Integer 1500
        defaultRouter2 String "0.0.0.0"
        defaultRouter1 String "0.0.0.0"
        defaultRouter0 String "@IubDefaultGW@" 
        rps Boolean false
        ownIpAddressActive String "0.0.0.0"
        vlanRef Ref "ManagedElement=1,EthernetSwitchFabric=1,Vlan=@VlanIUB@"
        networkPrefixLength Integer @IubNetworkPrefix@
)

@@@

////////////////////////////////////////////////////////////
//FDN=ManagedElement=1,Equipment=1,Subrack=@Subrack@,Slot=@Slot@,PlugInUnit=1,PiuDevice=1,ExchangeTerminalIp=1,GigaBitEthernet=1,IpInterface=@Subrack@-@Slot@_IuCS_Iur_S
//modifier=create
//nrOfAttributes=10
////////////////////////////////////////////////////////////
CREATE
(
    parent "ManagedElement=1,Equipment=1,Subrack=@Subrack@,Slot=@Slot@,PlugInUnit=1,PiuDevice=1,ExchangeTerminalIp=1,GigaBitEthernet=1"
    identity "@Subrack@-@Slot@_IuCS_Iur_S"
    moType IpInterface
    exception none
    nrOfAttributes 10
        ownIpAddressPassive String "0.0.0.0"
        userLabel String "IpInterface_@Subrack@-@Slot@_IuCS_Iur_S"
        mtu Integer 1500
        defaultRouter2 String "0.0.0.0"
        defaultRouter1 String "0.0.0.0"
        defaultRouter0 String "@lurDefaultGW@" 
        rps Boolean false
        ownIpAddressActive String "0.0.0.0"
        vlanRef Ref "ManagedElement=1,EthernetSwitchFabric=1,Vlan=@VlanCS@"
        networkPrefixLength Integer @IurNetworkPrefix@
)

@@@

////////////////////////////////////////////////////////////
//FDN=ManagedElement=1,Equipment=1,Subrack=@Subrack@,Slot=@Slot@,PlugInUnit=1,PiuDevice=1,ExchangeTerminalIp=1,GigaBitEthernet=1,IpInterface=@Subrack@-@Slot@_IuPS
//modifier=create
//nrOfAttributes=10
////////////////////////////////////////////////////////////
CREATE
(
    parent "ManagedElement=1,Equipment=1,Subrack=@Subrack@,Slot=@Slot@,PlugInUnit=1,PiuDevice=1,ExchangeTerminalIp=1,GigaBitEthernet=1"
    identity "@Subrack@-@Slot@_IuPS"
    moType IpInterface
    exception none
    nrOfAttributes 10
        ownIpAddressPassive String "0.0.0.0"
        userLabel String "IpInterface_@Subrack@-@Slot@_IuPS"
        mtu Integer 1500
        defaultRouter2 String "0.0.0.0"
        defaultRouter1 String "0.0.0.0"
        defaultRouter0 String "@luPSDefaultGW@" 
        rps Boolean false
        ownIpAddressActive String "0.0.0.0"
        vlanRef Ref "ManagedElement=1,EthernetSwitchFabric=1,Vlan=@VlanPS@"
        networkPrefixLength Integer @IuPSNetworkPrefix@
)

@@@

////////////////////////////////////////////////////////////
//FDN=ManagedElement=1,Equipment=1,Subrack=@Subrack@,Slot=@Slot@,PlugInUnit=1,PiuDevice=1,ExchangeTerminalIp=1,GigaBitEthernet=1,IpInterface=@Subrack@-@Slot@_Iub_S
//modifier=create
//nrOfAttributes=10
////////////////////////////////////////////////////////////
CREATE
(
    parent "ManagedElement=1,Equipment=1,Subrack=@Subrack@,Slot=@Slot@,PlugInUnit=1,PiuDevice=1,ExchangeTerminalIp=1,GigaBitEthernet=1"
    identity "@Subrack@-@Slot@_Iub_S"
    moType IpInterface
    exception none
    nrOfAttributes 10
        ownIpAddressPassive String "0.0.0.0"
        userLabel String "IpInterface_@Subrack@-@Slot@_Iub_S"
        mtu Integer 1500
        defaultRouter2 String "0.0.0.0"
        defaultRouter1 String "0.0.0.0"
        defaultRouter0 String "@IubDefaultGW@" 
        rps Boolean false
        ownIpAddressActive String "0.0.0.0"
        vlanRef Ref "ManagedElement=1,EthernetSwitchFabric=1,Vlan=@VlanIUB@"
        networkPrefixLength Integer @IubNetworkPrefix@
)

@@@


////////////////////////////////////////////////////////////
//FDN=ManagedElement=1,IpSystem=1,IpAccessHostEt=@Subrack@-@Slot@_IuCS_Iur_P
//modifier=create
//nrOfAttributes=7
////////////////////////////////////////////////////////////
CREATE
(
    parent "ManagedElement=1,IpSystem=1"
    identity "@Subrack@-@Slot@_IuCS_Iur_P"
    moType IpAccessHostEt
    exception none
    nrOfAttributes 7
        administrativeState Integer 1
        ipAddress String "@pIurIP@" 
        ipDefaultTtl Integer 64
        ipInterfaceMoRef Ref "ManagedElement=1,Equipment=1,Subrack=@Subrack@,Slot=@Slot@,PlugInUnit=1,ExchangeTerminalIp=1,GigaBitEthernet=1,IpInterface=@Subrack@-@Slot@_IuCS_Iur_P"
        userLabel String "IpAccessHostEt_@Subrack@-@Slot@_IuCS_Iur_P"
        ntpServerMode Integer 0
        ntpDscp Integer 56
)

@@@

////////////////////////////////////////////////////////////
//FDN=ManagedElement=1,IpSystem=1,IpAccessHostEt=@Subrack@-@Slot@_IuCS_Iur_S
//modifier=create
//nrOfAttributes=7
////////////////////////////////////////////////////////////
CREATE
(
    parent "ManagedElement=1,IpSystem=1"
    identity "@Subrack@-@Slot@_IuCS_Iur_S"
    moType IpAccessHostEt
    exception none
    nrOfAttributes 7
        administrativeState Integer 1
        ipAddress String "@sIurIP@"
        ipDefaultTtl Integer 64
        ipInterfaceMoRef Ref "ManagedElement=1,Equipment=1,Subrack=@Subrack@,Slot=@Slot@,PlugInUnit=1,PiuDevice=1,ExchangeTerminalIp=1,GigaBitEthernet=1,IpInterface=@Subrack@-@Slot@_IuCS_Iur_S"
        userLabel String "IpAccessHostEt_@Subrack@-@Slot@_IuCS_Iur_S"
        ntpServerMode Integer 0
        ntpDscp Integer 56
)

@@@

////////////////////////////////////////////////////////////
//FDN=ManagedElement=1,IpSystem=1,IpAccessHostEt=@Subrack@-@Slot@_IuPS
//modifier=create
//nrOfAttributes=7
////////////////////////////////////////////////////////////
CREATE
(
    parent "ManagedElement=1,IpSystem=1"
    identity "@Subrack@-@Slot@_IuPS"
    moType IpAccessHostEt
    exception none
    nrOfAttributes 7
        administrativeState Integer 1
        ipAddress String "@IuPSIP@"
        ipDefaultTtl Integer 64
        ipInterfaceMoRef Ref "ManagedElement=1,Equipment=1,Subrack=@Subrack@,Slot=@Slot@,PlugInUnit=1,PiuDevice=1,ExchangeTerminalIp=1,GigaBitEthernet=1,IpInterface=@Subrack@-@Slot@_IuPS"
        userLabel String "IpAccessHostEt_@Subrack@-@Slot@_IuPS"
        ntpServerMode Integer 0
        ntpDscp Integer 56
)

@@@

////////////////////////////////////////////////////////////
//FDN=ManagedElement=1,IpSystem=1,IpAccessHostEt=@Subrack@-@Slot@_Iub_P
//modifier=create
//nrOfAttributes=7
////////////////////////////////////////////////////////////
CREATE
(
    parent "ManagedElement=1,IpSystem=1"
    identity "@Subrack@-@Slot@_Iub_P"
    moType IpAccessHostEt
    exception none
    nrOfAttributes 7
        administrativeState Integer 1
        ipAddress String "@pIubIP@"
        ipDefaultTtl Integer 64
        ipInterfaceMoRef Ref "ManagedElement=1,Equipment=1,Subrack=@Subrack@,Slot=@Slot@,PlugInUnit=1,ExchangeTerminalIp=1,GigaBitEthernet=1,IpInterface=@Subrack@-@Slot@_Iub_P"
        userLabel String "IpAccessHostEt_@Subrack@-@Slot@_Iub_P"
        ntpServerMode Integer 0
        ntpDscp Integer 56
)

@@@

////////////////////////////////////////////////////////////
//FDN=ManagedElement=1,IpSystem=1,IpAccessHostEt=@Subrack@-@Slot@_Iub_S
//modifier=create
//nrOfAttributes=7
////////////////////////////////////////////////////////////
CREATE
(
    parent "ManagedElement=1,IpSystem=1"
    identity "@Subrack@-@Slot@_Iub_S"
    moType IpAccessHostEt
    exception none
    nrOfAttributes 7
        administrativeState Integer 1
        ipAddress String "@sIubIP@"
        ipDefaultTtl Integer 64
        ipInterfaceMoRef Ref "ManagedElement=1,Equipment=1,Subrack=@Subrack@,Slot=@Slot@,PlugInUnit=1,PiuDevice=1,ExchangeTerminalIp=1,GigaBitEthernet=1,IpInterface=@Subrack@-@Slot@_Iub_S"
        userLabel String "IpAccessHostEt_@Subrack@-@Slot@_Iub_S"
        ntpServerMode Integer 1
        ntpDscp Integer 56
)

@@@

////////////////////////////////////////////////////////////
// THIS SECTION MUST BE MODIFIED MANUALY BY ADDING ALL IpAccessHostEt=.*_IuCS_Iur_.* ON NODE
// amos cmd: IpAccessHostEt=.*_IuCS_Iur_.*
////////////////////////////////////////////////////////////

////////////////////////////////////////////////////////////
//FDN=ManagedElement=1,IpSystem=1,IpAccessHostPool=IU_CS
//modifier=set
//nrOfAttributes=3
////////////////////////////////////////////////////////////

SET
(
    mo "ManagedElement=1,IpSystem=1,IpAccessHostPool=IU_CS"
    exception none
       ipAccessHostRef Array Reference @countOfBoardCS@
		@StartCSPool@
            "ManagedElement=1,IpSystem=1,IpAccessHostEt=@Subrack@-@Slot@_IuCS_Iur_P"            
            "ManagedElement=1,IpSystem=1,IpAccessHostEt=@Subrack@-@Slot@_IuCS_Iur_S"            
		@StopCSPool@
)

@@@

////////////////////////////////////////////////////////////
// THIS SECTION MUST BE MODIFIED MANUALY BY ADDING ALL IpAccessHostEt=.*_IuPS ON NODE
// amos cmd: lpr IpAccessHostEt=.*_IuPS
////////////////////////////////////////////////////////////

////////////////////////////////////////////////////////////
//FDN=ManagedElement=1,IpSystem=1,IpAccessHostPool=IU_PS
//modifier=set
//nrOfAttributes=3
////////////////////////////////////////////////////////////
SET
(
    mo "ManagedElement=1,IpSystem=1,IpAccessHostPool=IU_PS"
    exception none
        ipAccessHostRef Array Reference @countOfBoardPS@
		@StartPSPool@
            "ManagedElement=1,IpSystem=1,IpAccessHostEt=@Subrack@-@Slot@_IuPS"  
		@StopPSPool@
)

@@@

////////////////////////////////////////////////////////////
// THIS SECTION MUST BE MODIFIED MANUALY BY ADDING ALL IpAccessHostEt=.*_IuB_.* ON NODE
// amos cmd: lpr IpAccessHostEt=.*Iub_.*
////////////////////////////////////////////////////////////

////////////////////////////////////////////////////////////
//FDN=ManagedElement=1,IpSystem=1,IpAccessHostPool=IUB
//modifier=set
//nrOfAttributes=3
////////////////////////////////////////////////////////////
SET
(
    mo "ManagedElement=1,IpSystem=1,IpAccessHostPool=IUB"
    exception none
        ipAccessHostRef Array Reference @countOfBoardIub@
		@StartIUBPool@
            "ManagedElement=1,IpSystem=1,IpAccessHostEt=@Subrack@-@Slot@_Iub_P"            
            "ManagedElement=1,IpSystem=1,IpAccessHostEt=@Subrack@-@Slot@_Iub_S"            
		@StopIUBPool@
)

@@@

////////////////////////////////////////////////////////////
//FDN=ManagedElement=1,IpSystem=1,IpAccessSctp=@Subrack@-@Slot@_Iub
//modifier=create
//nrOfAttributes=2
////////////////////////////////////////////////////////////
CREATE
(
    parent "ManagedElement=1,IpSystem=1"
    identity "@Subrack@-@Slot@_Iub"
    moType IpAccessSctp
    exception none
    nrOfAttributes 2
        ipAccessHostEtRef1 Ref "ManagedElement=1,IpSystem=1,IpAccessHostEt=@Subrack@-@Slot@_Iub_P"
        userLabel String "IpAccessSctp_@Subrack@-@Slot@_Iub"
)

@@@

////////////////////////////////////////////////////////////
//FDN=ManagedElement=1,TransportNetwork=1,Sctp=@Subrack@-@Slot@_Iub
//modifier=create
//nrOfAttributes=36
////////////////////////////////////////////////////////////
CREATE
(
    parent "ManagedElement=1,TransportNetwork=1"
    identity "@Subrack@-@Slot@_Iub"
    moType Sctp
    exception none
    nrOfAttributes 36
        tSack Integer 4
        nPercentage Integer 85
        minimumRto Integer 10
        bundlingTimer Integer 10
        rtoAlphaIndex Integer 3
        initialRto Integer 20
        intervalOobPkts Integer 3600
        heartbeatInterval Integer 1
        heartbeatMaxBurst Integer 0
        heartbeatPathProbingInterval Integer 70
        pathSelection Integer 0
        maxShutDownRtrAtt Integer 5
        rtoBetaIndex Integer 2
        switchbackMode Integer 1
        nThreshold Integer 12
        userLabel String "Sctp_@Subrack@-@Slot@_Iub"
        allowedIncrementCookieLife Integer 30
        associationMaxRtx Integer 12
        maxUserDataSize Integer 556
        keyChangePeriod Integer 4
        rpuId Ref "ManagedElement=1,SwManagement=1,ReliableProgramUniter=sctp_host_@Subrack@-@Slot@-0"
        heartbeatStatus Boolean true
        sctpAssocDeleteTimeout Integer 168
        bundlingActivated Integer 1
        validCookieLife Integer 60
        maxInitialRtrAtt Integer 8
        ipAccessSctpRef Ref "ManagedElement=1,IpSystem=1,IpAccessSctp=@Subrack@-@Slot@_Iub"
        mBuffer Integer 16
        initialAdRecWin Integer 16384
        maximumRto Integer 40
        maxBurst Integer 4
        maxOutgoingStream Integer 17
        maxIncomingStream Integer 17
        numberOfAssociations Integer 512
        pathMaxRtx Integer 12
        potentiallyFailedMaxRtx Integer 4
)

@@@

////////////////////////////////////////////////////////////
//FDN=ManagedElement=1,Equipment=1,SpDevicePool=PdrDevice,PdrDevice=@Subrack@-@Slot@,IpEthPacketDataRouter=Pdr_@Subrack@-@Slot@
//modifier=create
//nrOfAttributes=2
////////////////////////////////////////////////////////////
CREATE
(
    parent "ManagedElement=1,Equipment=1,SpDevicePool=PdrDevice,PdrDevice=@PDRNum@"
    identity "Pdr_@Subrack@-@Slot@"
    moType IpEthPacketDataRouter
    exception none
    nrOfAttributes 2
        userLabel String "IpEthPacketDataRouter_Pdr_@Subrack@-@Slot@"
        administrativeState Integer 1
)

