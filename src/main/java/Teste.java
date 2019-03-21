import java.io.IOException;

import com.google.appengine.repackaged.com.google.gson.Gson;
import com.google.appengine.repackaged.com.google.gson.GsonBuilder;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.GeocodingResult;

public class Teste {
	
	public static void main(String[] args) throws ApiException, InterruptedException, IOException {
		GeoApiContext context = new GeoApiContext.Builder()
			    .enterpriseCredentials("108139909826-n5ips4i66tch20nbb1mrkftq2rhea26g.apps.googleusercontent.com", "ZueTo0i6IFIcwiTLHyeMvCP2")
			    .build();
			GeocodingResult[] results =  GeocodingApi.geocode(context,
			    "1600 Amphitheatre Parkway Mountain View, CA 94043").await();
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			System.out.println(gson.toJson(results[0].addressComponents));
	}

}
