import com.cleeng.apiv3.CleengApi;
import com.cleeng.apiv3.domain.*;

class CleengApiExample {

	public static void main(String args[]) throws Exception {
		CleengApi cleengApi = new CleengApi();
		cleengApi.enableSandbox(); // remove this line when going live

		// you should retrieve the customerToken & offerId from the HTTP request
		String customerToken = "JS-82A_mtlZlJMuuJHvkhnFo_4F1xHRcbqllOzdIO59m-adg";
		String offerId = "P765685881_NL";

		boolean isgranted = cleengApi.isAccessGranted(customerToken, offerId);
		if(isgranted) {
			System.out.println("Access granted");
		} else {
			System.out.println("Access denied");
		}
	}
}
