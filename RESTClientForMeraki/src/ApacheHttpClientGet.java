import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;

public class ApacheHttpClientGet {
	
	public static void main(String[] args) {
		
		
		HttpOrgRequests one = new HttpOrgRequestsImpl();
		
		one.getListOfOrgs();
		
		one.getOrgById(660707);
		
		one.getLicenseStateById(660707);
		
		one.getSnmpById(660707);
		
		one.getVpnPeersById(660707);
		
		one.getListOfNetworksById(660707);
		
		one.getNetworkById(660707, "N_566327653141842928");
		
		one.getPhonesByNetworkId("N_566327653141842928");
		
		one.getDevicesByNetworkId("N_566327653141842928");
		
		one.getAdminByOrgId(660707);

		}
	
	
}
