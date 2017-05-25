import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.StringEntity;

/* Copyright (C) 2017 Ilakkuvaselvi Manoharan - All Rights Reserved
 * 
 */

public interface HttpOrgRequests {

    public String baseurl = "https://dashboard.meraki.com/api/v0";
	
	public void getListOfOrgs();
	
	public void getOrgById(int i);
	
	//update an organization
	
	public void updateOrgById(int i, StringEntity data);  

	public void createOrg();  
	
	public void getLicenseStateById(int orgId);

	public void getSnmpById(int i);
	
	public void getVpnPeersById(int i);
	
	public void getListOfNetworksById(int i);
	
	public void getNetworkById(int orgId, String nId);
	
	//List all phones in a network and their contact assignment.
	
	public void getPhonesByNetworkId(String nid);
	
	//List the devices in the network
	
	public void getDevicesByNetworkId(String nid);
	
	//List the dashboard administrators in this organization
	
	public void getAdminByOrgId(int orgId);
	
	//Create a new dashboard administrator
	
	//public void createAdminByOrgId(int orgId);
	
	
	
}
