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
package gwt.material.starter.client.autoComplete;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONException;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;

public class CoreEngine {
	/* gwt json Structure */
	JSONObject h = null;// new JSONObject();
	JSONObject w = null;

	public CoreEngine() throws JSONException {

		/* gwt json Structure */
		JSONArray letterHArray = new JSONArray();
		h = new JSONObject();
		w = new JSONObject();
		letterHArray.set(0, new JSONString("how to build app"));
		letterHArray.set(1, new JSONString("heat the iron"));
		h.put("top", letterHArray);
		letterHArray = new JSONArray();
		letterHArray.set(0, new JSONString("home for students"));
		h.put("low", letterHArray);

		JSONArray letterWArray = new JSONArray();
		w = new JSONObject();
		letterWArray.set(0, new JSONString("where is ur"));
		letterWArray.set(1, new JSONString("what happen"));
		w.put("top", letterWArray);
		letterWArray = new JSONArray();
		letterWArray.set(0, new JSONString("when is "));
		w.put("low", letterWArray);

		
	}

	public String[] getTxt(String txt) throws JSONException {

		JSONObject v = getJson(txt);
		String[] result = new String[10];
		JSONArray top = (JSONArray) v.get("top");
		JSONArray low = (JSONArray) v.get("low");

		int count = 0;

		for (int i = 0; i < top.size(); i++) {
			
			String value = top.get(i).toString().replace("\"", "");
			if (value.startsWith(txt.toLowerCase())) {
				result[count] = value;
				count++;
			}

			if (count > 9) {
				break;
			}

		}

		if (count < 9) {

			for (int i = 0; i < low.size(); i++) {
				String value = top.get(i).toString().replace("\"", "");
				if (value.toLowerCase().startsWith(txt.toLowerCase())) {

					result[count] = value;

					count++;

				}

				if (count > 9) {

					break;

				}

			}

		}

		if (result[0] == null) {

			JSONArray newVal = (JSONArray) v.get("top");
			int index = newVal.size();
			newVal.set(index + 1, new JSONString(txt));

		}

		return result;

	}

	public JSONObject getJson(String txt) {

		char[] chr = txt.toLowerCase().toCharArray();
		if (chr[0] == 'h') {
			return h;
		} else {
			return w;
		}
	}

	public final native String consoleLog(String txt)
	/*-{
		console.log("txttxt---->"+txt);
	}-*/;
}
