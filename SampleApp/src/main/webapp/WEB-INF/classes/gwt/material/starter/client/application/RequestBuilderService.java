/*
 * #%L
 * GwtMaterial
 * %%
 * Copyright (C) 2015 - 2017 GwtMaterialDesign
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
package gwt.material.starter.client.application;

import com.google.gwt.core.client.GWT;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.user.client.Window;

import gwt.material.design.client.ui.MaterialButton;

public class RequestBuilderService {

	public RequestBuilderService() {

	}  

	public void makeRestService() {

		// String builderString = urlEncode(dataJSON);
		RequestBuilder builder = new RequestBuilder(RequestBuilder.GET, GWT.getHostPageBaseURL() + "rest-api/test");
		builder.setHeader("Content-Type", "application/json");
		try {
			builder.sendRequest("json=temp",
					// + builderString ,
					new RequestCallback() {
						public void onResponseReceived(Request request, Response res) {
							Window.alert(res.getText());
						}

						public void onError(Request request, Throwable exception) {
							Window.alert("RestFull Service Failed");
						}
					});
		} catch (RequestException e) {
			e.printStackTrace();

		}

	}

	/**
	 * 
	 * @param toEncodeUrl
	 *            -> To give String json
	 * @return encodedUrl -> encodeURIComponent will return encodedUtl
	 */

	public static native String urlEncode(String toEncodeUrl) /*-{
		var encodedUrl = encodeURIComponent(toEncodeUrl);
		return encodedUrl;
	}-*/;

}
