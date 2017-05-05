import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpMessage;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;

public class HttpOrgRequestsImpl implements HttpOrgRequests{
	
	 
	    public void getListOfOrgs(){
	    	
		   HttpGet getRequest = new HttpGet(HttpOrgRequests.baseurl + "/organizations");
		   applyHeaders(getRequest);
		   isValidRequest(getRequest);
		   System.out.println("Output from Meraki: The available organizations are :\n");
		   getOrgHttpResponse(getRequest);
		  
		}
		
		public void applyHeaders(HttpRequestBase getRequest){
			(getRequest).addHeader("X-Cisco-Meraki-API-Key", "741f8f89617deccbbc77e980e340b7624fb98a34");
			(getRequest).addHeader("Content-Type", "application/json");
			
		}
		
		public boolean isValidRequest(HttpRequestBase getRequest){
			return true;
		}

		@Override
		public void getOrgById(int orgId) {
			
			HttpGet getRequest = new HttpGet(HttpOrgRequests.baseurl + "/organizations/" + orgId);
			applyHeaders(getRequest);
			isValidRequest(getRequest);
			
			System.out.println("Output from Meraki: The organization with orgId:" + orgId + " is :\n");
			getOrgHttpResponse(getRequest);
			
		}
		
		
		public void getOrgHttpResponse(HttpRequestBase getRequest){
		
		
		try(CloseableHttpClient httpClient = HttpClientBuilder.create().build()){
			
		HttpResponse response = httpClient.execute(getRequest);

			if (response.getStatusLine().getStatusCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
				   + response.getStatusLine().getStatusCode());
			}

			BufferedReader br = new BufferedReader(
	                         new InputStreamReader((response.getEntity().getContent())));

			String output;
			
			while ((output = br.readLine()) != null) {
				System.out.println(output);
			}

		  } catch (ClientProtocolException e) {

			e.printStackTrace();

		  } catch (IOException e) {

			e.printStackTrace();
		  }
		
		}
		
		public void updateOrgById(int orgId, StringEntity jsonData){
			
			HttpPut request = new HttpPut(HttpOrgRequests.baseurl + "/organizations/" + orgId);
			applyHeaders(request);
			isValidRequest(request);
			getOrgHttpResponse(request);
			
			
		}
		
      public void createOrg(){
			
		HttpPost request = new HttpPost(HttpOrgRequests.baseurl + "/organizations");
    	 
			applyHeaders(request);
			request.setHeader("X-Cisco-Meraki-API-Key", "741f8f89617deccbbc77e980e340b7624fb98a34");
			request.setHeader("Content-Type", "application/json");

			List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
			urlParameters.add(new BasicNameValuePair("name", "wavicle3"));
			

			try {
				request.setEntity(new UrlEncodedFormEntity(urlParameters));
			} catch (UnsupportedEncodingException e) {
				
				e.printStackTrace();
			}
			
			
			isValidRequest(request);
			getOrgHttpResponse(request);
			
			
		}
      
      
      public void getLicenseStateById(int orgId){
    	  
    	  HttpGet getRequest = new HttpGet(HttpOrgRequests.baseurl + "/organizations/" + orgId + "/licenseState");
			applyHeaders(getRequest);
			isValidRequest(getRequest);
			System.out.println("Output from Meraki: The license state for orgid: " + orgId + " is :\n");
			getOrgHttpResponse(getRequest);
    	  
      }
		
      public void getSnmpById(int orgId){
    	  
    	  HttpGet getRequest = new HttpGet(HttpOrgRequests.baseurl + "/organizations/" + orgId + "/snmp");
		  applyHeaders(getRequest);
		  isValidRequest(getRequest);
		  System.out.println("Output from Meraki: The SNMP for orgid: " + orgId + " is :\n");
		  getOrgHttpResponse(getRequest);
    	  
      }
		
      public void getVpnPeersById(int orgId){
    	  
    	  HttpGet getRequest = new HttpGet(HttpOrgRequests.baseurl + "/organizations/" + orgId + "/thirdPartyVPNPeers");
		  applyHeaders(getRequest);
		  isValidRequest(getRequest);
		  System.out.println("Output from Meraki: The VPN Peers for orgid: " + orgId + " is :\n");
		  getOrgHttpResponse(getRequest);
    	  
      }
      
      public void getListOfNetworksById(int orgId){
    	  
    	  HttpGet getRequest = new HttpGet(HttpOrgRequests.baseurl + "/organizations/" + orgId + "/networks");
		  applyHeaders(getRequest);
		  isValidRequest(getRequest);
		  System.out.println("Output from Meraki: The available networks for orgid: " + orgId + " is :\n");
		  getOrgHttpResponse(getRequest);
      }
      
      
      public void getNetworkById(int orgId, String networkId){
    	  HttpGet getRequest = new HttpGet(HttpOrgRequests.baseurl + "/organizations/" + orgId + "/networks/" + networkId);
		  applyHeaders(getRequest);
		  isValidRequest(getRequest);
		  System.out.println("Output from Meraki: The network details for orgid: " + orgId + " and network id: " + networkId +" is :\n");
		  getOrgHttpResponse(getRequest);
      }

      public void getPhonesByNetworkId(String networkId){
    	  
    	  HttpGet getRequest = new HttpGet(HttpOrgRequests.baseurl + "/networks/" + networkId);
		  applyHeaders(getRequest);
		  isValidRequest(getRequest);
		  System.out.println("Output from Meraki: The network details for network id: " + networkId +" is :\n");
		  getOrgHttpResponse(getRequest);
    	  
    	  
      }
      
      public void getDevicesByNetworkId(String networkId){
    	  
    	  HttpGet getRequest = new HttpGet(HttpOrgRequests.baseurl + "/networks/" + networkId + "/devices");
		  applyHeaders(getRequest);
		  isValidRequest(getRequest);
		  System.out.println("Output from Meraki: The devices available in the network id: " + networkId +" is :\n");
		  getOrgHttpResponse(getRequest);
    	  
    	  
      }
      
      
      public void getAdminByOrgId(int orgId){
    	  
    	  HttpGet getRequest = new HttpGet(HttpOrgRequests.baseurl + "/organizations/" + orgId + "/admins");
		  applyHeaders(getRequest);
		  isValidRequest(getRequest);
		  System.out.println("Output from Meraki: The available admins for orgid: " + orgId + " is :\n");
		  getOrgHttpResponse(getRequest);
    	  
    	  
      }
      
      
     // public void createAdminByOrgId(int orgId){
    	  
    	//HttpPost request = new HttpPost(HttpOrgRequests.baseurl + "/organizations");
    	  
    	  
     // }
      
      
      
      
      
      
      
      
      
      
}
