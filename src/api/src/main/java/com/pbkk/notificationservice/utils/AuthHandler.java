package com.pbkk.notificationservice.utils;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import org.apache.http.Consts;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.google.common.net.HttpHeaders;

@Service
public class AuthHandler {
	public JSONObject getAuthToken(String username, String password) {
		String key = username + ":" + password;
		String base64Key = Base64.getEncoder().encodeToString(key.getBytes());
		
		List<NameValuePair> form = new ArrayList<>();
		form.add(new BasicNameValuePair("grant_type","password"));
		form.add(new BasicNameValuePair("username","user_customer"));
		form.add(new BasicNameValuePair("password","customer"));
		
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost("https://rendoru.com/kuliah/pbkk/oauth/token");
		httpPost.setHeader(HttpHeaders.AUTHORIZATION,"Basic "+base64Key);
		
		try {
			UrlEncodedFormEntity urlEncodedFormEntity = new UrlEncodedFormEntity(form, Consts.UTF_8);
			httpPost.setEntity(urlEncodedFormEntity);
			
			HttpResponse response = httpClient.execute(httpPost);
			String responseString = new BasicResponseHandler().handleResponse(response);
			return new JSONObject(responseString);
		} catch (Exception e) {
			return null;
		}
	}
}
