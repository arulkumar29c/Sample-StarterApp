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



public class Engine {

//	public static void main(String args[]) {
//
//		try {
//
//			Sample s = new Sample();
//
//			String txt = "ho";
//
//			String[] result = s.getTxt(txt);
//
//			for (int i = 0; i < result.length; i++) {
//
//				if (result[i] == null) {
//
//					break;
//
//				}
//
//				System.out.println(result[i]);
//
//			}
//
//			if (result[0] == null) {
//
//				String[] results = s.getTxt(txt);
//
//				for (int i = 0; i < results.length; i++) {
//
//					if (results[i] == null) {
//
//						break;
//
//					}
//
//					System.out.println(results[i]);
//
//				}
//
//			}
//
//		} catch (JSONException e) {
//
//			e.printStackTrace();
//
//		}
//
//	}

}

class Sample {
//
//	JSONObject h = null;
//
//	JSONObject w = null;
//
//	public Sample() throws JSONException {
//
//		JSONArray letterHArray = new JSONArray();
//
//		h = new JSONObject();
//
//		letterHArray.put("how to build app");
//
//		letterHArray.put("heat the iron");
//
//		h.put("top", letterHArray);
//
//		letterHArray = new JSONArray();
//
//		letterHArray.put("home for students");
//
//		h.put("low", letterHArray);
//
//		JSONArray letterWArray = new JSONArray();
//
//		w = new JSONObject();
//
//		letterWArray.put("where is ur");
//
//		w.put("top", letterWArray);
//
//		letterWArray = new JSONArray();
//
//		letterWArray.put("what happen");
//
//		letterWArray.put("when is ur bd");
//
//		w.put("low", letterWArray);
//
//	}
//
//	public String[] getTxt(String txt) throws JSONException {
//
//		JSONObject v = getJson(txt);
//
//		String[] result = new String[10];
//
//		JSONArray top = v.getJSONArray("top");
//
//		JSONArray low = v.getJSONArray("low");
//
//		int count = 0;
//
//		for (int i = 0; i < top.length(); i++) {
//
//			if (top.get(i).toString().toLowerCase().startsWith(txt.toLowerCase())) {
//
//				result[count] = top.get(i).toString();
//
//				count++;
//
//			}
//
//			if (count > 9) {
//
//				break;
//
//			}
//
//		}
//
//		if (count < 9) {
//
//			for (int i = 0; i < low.length(); i++) {
//
//				if (low.get(i).toString().toLowerCase().startsWith(txt.toLowerCase())) {
//
//					result[count] = low.get(i).toString();
//
//					count++;
//
//				}
//
//				if (count > 9) {
//
//					break;
//
//				}
//
//			}
//
//		}
//
//		if (result[0] == null) {
//
//			v.getJSONArray("top").put(txt);
//
//		}
//
//		return result;
//
//	}
//
//	public JSONObject getJson(String txt) {
//
//		char[] chr = txt.toLowerCase().toCharArray();
//
//		if (chr[0] == 'h') {
//
//			return h;
//
//		} else {
//
//			return w;
//
//		}
//
//	}
//
}
