package net.kadirderer.btc.query;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class BtcTurkOrderbookServiceImpl extends OrderbookService {

	@Override
	public OrderbookResult query() {
		URL url;
		try {
			url = new URL(config.getBtcTurkOrderBookUrl());

			HttpsURLConnection con = (HttpsURLConnection) url.openConnection();

			con.setHostnameVerifier(new HostnameVerifier() {
				public boolean verify(String string, SSLSession ssls) {
					return true;
				}
			});

			BufferedReader br = new BufferedReader(new InputStreamReader(
					con.getInputStream()));

			String input;
			StringBuffer json = new StringBuffer();

			while ((input = br.readLine()) != null) {
				json.append(input);
			}

			ObjectMapper om = new ObjectMapper();
			BtcTurkOrderbookResult result = om.readValue(json.toString(),
					BtcTurkOrderbookResult.class);

			return result;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

}
