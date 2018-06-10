//package tsdb.open;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.io.UnsupportedEncodingException;
//
//import org.apache.http.HttpResponse;
//import org.apache.http.client.ClientProtocolException;
//import org.apache.http.client.methods.HttpPost;
//import org.apache.http.entity.StringEntity;
//import org.apache.http.impl.client.CloseableHttpClient;
//import org.apache.http.impl.client.HttpClients;
//import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
//import org.apache.log4j.BasicConfigurator;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.sun.mail.iap.Response;
//
//@SuppressWarnings("unused")
//public class Httpmanager {
//	public static String url1 = "http://localhost:4242/api/put?details";
//	public static String url = "http://localhost:4242/api/rollup?details";
//
//	public static void main(String args[]) {
//		try {
//			BasicConfigurator.configure();
//			
//			PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
//
//			cm.setMaxTotal(300);
//
//			cm.setDefaultMaxPerRoute(200);
//
//			CloseableHttpClient httpClient = HttpClients.custom().setConnectionManager(cm).build();
//
//			HttpPost post = new HttpPost(url);
//
//			post.addHeader("Content-Type", "application/JSON");
//
//			//jsonSmaller jOA = new jsonSmaller("sys.cpy.nice", 1526695000, 2, "web01");
//			JsonObjectAttributes jOA = new JsonObjectAttributes(
//					"sys.cpa.nice",
//					1526693000,
//					4,
//					new String[]{"web01","1"},
//					"1h",
//					"SUM",
//					"MAX"); 
//			
//			ObjectMapper mapper = new ObjectMapper();
//			String json;
//			json = mapper.writeValueAsString(jOA);
//			System.out.println(json);
//			StringEntity params = new StringEntity(json);
//
//			post.setEntity(params);
//
//			HttpResponse response = httpClient.execute(post);
//
//			System.out.println("\nSending Post rq to URL : " + url);
//			System.out.println("Post param : " + post.getEntity());
//			System.out.println("response code : " + response.getStatusLine().getStatusCode());
//			
//			BufferedReader rd = new BufferedReader( new InputStreamReader(response.getEntity().getContent()));
//			
//			StringBuffer result = new StringBuffer();
//			
//			String line = "";
//			
//			while((line = rd.readLine()) != null) {
//				result.append(line);
//			}
//			System.out.println(result.toString());
//		} catch (JsonProcessingException e) {
//
//			e.printStackTrace();
//		} catch (UnsupportedEncodingException e) {
//
//			e.printStackTrace();
//		} catch (ClientProtocolException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//}
