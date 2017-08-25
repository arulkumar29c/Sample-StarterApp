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

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import gwt.material.design.addins.client.autocomplete.base.MaterialSuggestionOracle;
/**
 * <h1>UserOracle</h1>
 * <p>
 * The UserOracle is a view class<br/>
 * which can use for client <br/>
 * side materila seggestion view.
 * </p>
 */
public class UserOracle extends MaterialSuggestionOracle {

    private List<AutoCompleteData> dataList = new LinkedList<AutoCompleteData>();

    public void addUsers(List<AutoCompleteData> users) {
        dataList.addAll(users);
    }

    @Override
    public void requestSuggestions(Request request, Callback callback) {
        Response resp = new Response();
        if (dataList.isEmpty()) {
            callback.onSuggestionsReady(request, resp);
            return;
        }
        String text = request.getQuery();
        text = text.toLowerCase();

        List<UserSuggestion> list = new ArrayList<UserSuggestion>();

//        for (AutoCompleteData user : dataList) {
//            if (user.getDisplayValue().toLowerCase().contains(text) && text.length()>=3) {
//                list.add(new UserSuggestion(user));
//            }
//        }
        
       CoreEngine ce = new CoreEngine();
       String[] re = ce.getTxt(text);
       for (int i = 0; i < re.length; i++) {
    	   
    	  // consoleLog("**");
    	   if(re[i]!=null)
    	   {
    	   AutoCompleteData user = new AutoCompleteData();
    	   user.setDisplayValue(re[i]);
    	   list.add(new UserSuggestion(user));
    	   }
       }

        resp.setSuggestions(list);
        callback.onSuggestionsReady(request, resp);
    }
    public final native String consoleLog(String txt)
    /*-{
		console.log("txttxt--**-->"+txt);
	}-*/;
}

