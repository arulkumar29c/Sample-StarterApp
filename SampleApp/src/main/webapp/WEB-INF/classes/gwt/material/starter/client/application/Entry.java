/*
 * #%L
 * GwtMaterial
 * %%
 * Copyright (C) 2015 - 2016 GwtMaterialDesign
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

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.Hidden;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;

import gwtupload.client.IFileInput.FileInputType;
import gwtupload.client.IUploadStatus.Status;
import gwtupload.client.IUploader;
import gwtupload.client.IUploader.OnChangeUploaderHandler;
import gwtupload.client.IUploader.OnFinishUploaderHandler;
import gwtupload.client.IUploader.OnStartUploaderHandler;
import gwtupload.client.MultiUploader;

public class Entry implements EntryPoint {

	@Override
	public void onModuleLoad() {
		// RootPanel.get().add(HomeScreen.getHomescreen());
		final Label responseLabel = new Label();

		MultiUploader multiUploader = new MultiUploader(FileInputType.BUTTON);
		multiUploader.setAutoSubmit(true);
		multiUploader.setEnabled(true);
		multiUploader.avoidRepeatFiles(false);
		multiUploader.addOnChangeUploadHandler(new OnChangeUploaderHandler() {
			@Override
			public void onChange(IUploader uploader) {
				if (uploader.getStatus() == Status.CHANGED) {
					System.out.println("File input changed, can be handled before upload begin");
					/**
					 * If you want to validate something at your side before
					 * upload. Check it here and you can cancel uploading.
					 * Uncomment below line if you need it. /
					 * 
					 * /* uploader.cancel();
					 */
				}
			}
		});
		multiUploader.addOnStartUploadHandler(new OnStartUploaderHandler() {
			@Override
			public void onStart(IUploader uploader) {
				/**
				 * This is where you can pass the hidden value to servlet.
				 */
				uploader.add(new Hidden("param1", "value"));
				uploader.add(new Hidden("param2", "value"));
			}
		});
		multiUploader.addOnFinishUploadHandler(new OnFinishUploaderHandler() {
			@Override
			public void onFinish(IUploader uploader) {
				/**
				 * Before processing output check the status of upload.
				 */
				if (uploader.getStatus() == Status.SUCCESS) {
					/**
					 * If you passed details in JSONObject. You have to use
					 * subtring function of String to get your JSON String.
					 */
					System.out.println(uploader.getServerResponse());
					responseLabel.setText(uploader.getServerRawResponse());
				} else {
					System.out.println(uploader.getStatus());
				}
			}
		});
		// 10485760 = 10 MB x 1024 x 1024
		multiUploader.setServletPath(GWT.getModuleBaseURL() + "UploadServlet?maxUpload=10485760");

		// Add the nameField and sendButton to the RootPanel
		// Use RootPanel.get() to get the entire body element
		RootPanel.get("MultiUpload").add(multiUploader);
		RootPanel.get("infoLabel").add(responseLabel);
	}
}
